package com.frudev.invoicing.service;
import com.frudev.invoicing.dto.EventDto;
import com.frudev.invoicing.dto.PaginatedDetailsDto;
import com.frudev.invoicing.entity.AuctionEntity;
import com.frudev.invoicing.entity.EventEntity;
import com.frudev.invoicing.mapper.EventMapper;
import com.frudev.invoicing.repository.AuctionRepository;
import com.frudev.invoicing.repository.EventRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final AuctionRepository auctionRepository;
    private final EventMapper eventMapper;
    public EventServiceImpl(EventRepository eventRepository, AuctionRepository auctionRepository, EventMapper eventMapper) {
        this.eventRepository = eventRepository;
        this.auctionRepository = auctionRepository;
        this.eventMapper = eventMapper;
    }
    @Override
    @Transactional(readOnly = true)
    public PaginatedDetailsDto<EventDto> getAll(String search, Pageable pageable) {
        Specification<EventEntity> spec = buildSearchSpec(search);
        Page<EventDto> page = eventRepository.findAll(spec, pageable)
                .map(eventMapper::toDto);
        return new PaginatedDetailsDto<>(
                page.getNumber(),
                page.getSize(),
                page.getTotalPages(),
                page.getTotalElements(),
                page.getContent()
        );
    }
    @Override
    public EventDto getEventById(UUID id) {
        return eventRepository.findById(id)
                .map(eventMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + id));
    }
    @Override
    @Transactional
    public EventDto createEvent(EventDto eventDto) {
        EventEntity entity = eventMapper.toEntity(eventDto);
        if (entity.getId() == null) {
            entity.setId(UUID.randomUUID());
        }
        if (eventDto.auctionId() != null) {
            AuctionEntity auction = auctionRepository.findById(eventDto.auctionId())
                    .orElseThrow(() -> new RuntimeException("Auction not found with id: " + eventDto.auctionId()));
            entity.setAuction(auction);
        }
        EventEntity savedEntity = eventRepository.save(entity);
        return eventMapper.toDto(savedEntity);
    }
    @Override
    @Transactional
    public EventDto updateEvent(UUID id, EventDto eventDto) {
        EventEntity existingEntity = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + id));
        eventMapper.updateEntityFromDto(eventDto, existingEntity);
        if (eventDto.auctionId() != null) {
            AuctionEntity auction = auctionRepository.findById(eventDto.auctionId())
                    .orElseThrow(() -> new RuntimeException("Auction not found with id: " + eventDto.auctionId()));
            existingEntity.setAuction(auction);
        } else {
            existingEntity.setAuction(null);
        }
        EventEntity updatedEntity = eventRepository.save(existingEntity);
        return eventMapper.toDto(updatedEntity);
    }
    @Override
    @Transactional
    public void deleteEvent(UUID id) {
        if (!eventRepository.existsById(id)) {
            throw new RuntimeException("Event not found with id: " + id);
        }
        eventRepository.deleteById(id);
    }
    private Specification<EventEntity> buildSearchSpec(String search) {
        if (search == null || search.isBlank()) return null;
        String pattern = "%" + search.toLowerCase() + "%";
        return (root, query, cb) -> cb.or(
                cb.like(cb.lower(root.get("auction").get("nameOfAuction")), pattern),
                cb.like(cb.lower(root.get("description")), pattern)
        );
    }
}

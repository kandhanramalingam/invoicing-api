package com.frudev.invoicing.service;
import com.frudev.invoicing.dto.EventDto;
import com.frudev.invoicing.dto.PaginatedDetailsDto;
import org.springframework.data.domain.Pageable;
import java.util.UUID;
public interface EventService {
    PaginatedDetailsDto<EventDto> getAll(String search, Pageable pageable);
    EventDto getEventById(UUID id);
    EventDto createEvent(EventDto eventDto);
    EventDto updateEvent(UUID id, EventDto eventDto);
    void deleteEvent(UUID id);
}

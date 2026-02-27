package com.frudev.invoicing.controller;
import com.frudev.invoicing.dto.EventDto;
import com.frudev.invoicing.dto.PaginatedDetailsDto;
import com.frudev.invoicing.dto.ResponseDto;
import com.frudev.invoicing.service.EventService;
import com.frudev.invoicing.utils.CustomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;
@RestController
@RequestMapping("/events")
public class EventController {
    private static final Logger logger = LoggerFactory.getLogger(EventController.class);
    private final EventService eventService;
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
    @GetMapping
    public ResponseEntity<ResponseDto<PaginatedDetailsDto<EventDto>>> getAll(
            @RequestParam(required = false) String search, Pageable pageable) {
        try {
            PaginatedDetailsDto<EventDto> events = eventService.getAll(search, pageable);
            return ResponseEntity.ok(new ResponseDto<>(events, "Events fetched successfully"));
        } catch (Exception e) {
            logger.error("getAll events: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto<>(null, e.getMessage()));
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<EventDto>> getEventById(@PathVariable UUID id) {
        try {
            EventDto event = eventService.getEventById(id);
            return ResponseEntity.ok(new ResponseDto<>(event, "Event fetched successfully"));
        } catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto<>(null, e.getMessage()));
        } catch (Exception e) {
            logger.error("getEventById: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto<>(null, e.getMessage()));
        }
    }
    @PostMapping
    public ResponseEntity<ResponseDto<EventDto>> createEvent(@RequestBody EventDto eventDto) {
        try {
            EventDto created = eventService.createEvent(eventDto);
            return new ResponseEntity<>(new ResponseDto<>(created, "Event created successfully"), HttpStatus.CREATED);
        } catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto<>(null, e.getMessage()));
        } catch (Exception e) {
            logger.error("createEvent: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto<>(null, e.getMessage()));
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto<EventDto>> updateEvent(@PathVariable UUID id, @RequestBody EventDto eventDto) {
        try {
            EventDto updated = eventService.updateEvent(id, eventDto);
            return ResponseEntity.ok(new ResponseDto<>(updated, "Event updated successfully"));
        } catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto<>(null, e.getMessage()));
        } catch (Exception e) {
            logger.error("updateEvent: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto<>(null, e.getMessage()));
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto<Void>> deleteEvent(@PathVariable UUID id) {
        try {
            eventService.deleteEvent(id);
            return ResponseEntity.ok(new ResponseDto<>(null, "Event deleted successfully"));
        } catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto<>(null, e.getMessage()));
        } catch (Exception e) {
            logger.error("deleteEvent: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto<>(null, e.getMessage()));
        }
    }
}

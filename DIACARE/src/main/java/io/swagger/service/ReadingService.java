package io.swagger.service;

import io.swagger.model.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReadingService {

    public ReadingDetails saveReading(ReadingDetailsDto readingDetailsDto);

    public List<ReadingDetailsDto> findReadingsOflastWeek(Integer userId);

    public ReadingDetails findByReadingId(Integer readingId);

    ReadingDetails updateReading(ReadingDetailsDto body);

    ReadingDetailsDto findTodaysReading(Integer userId);
}

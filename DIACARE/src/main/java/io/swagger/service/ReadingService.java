package io.swagger.service;

import io.swagger.model.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReadingService {

    public ReadingDetails saveReading(ReadingDetailsDto readingDetailsDto);

    public ReadingDetails findByReadingId(Integer readingId);

    ReadingDetails updateReading(ReadingDetailsDto body);

    ReadingDetailsDto findTodaysReading(Integer userId);

    public List<ReadingDetailsDto> findAllReadings(Integer userId);
}

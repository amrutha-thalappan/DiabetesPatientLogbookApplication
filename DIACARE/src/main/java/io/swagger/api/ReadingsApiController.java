package io.swagger.api;

import io.swagger.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.service.ReadingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-21T16:30:27.879Z[GMT]")
@Controller
public class ReadingsApiController implements ReadingsApi {

    private static final Logger log = LoggerFactory.getLogger(ReadingsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    ReadingService readingService;

    @org.springframework.beans.factory.annotation.Autowired
    public ReadingsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> readingsDelete() {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<ReadingDetailsDto>> readingsGet(@ApiParam(value = "The ID of the user whose readings need to be retrieved." ,required=true) @RequestParam(value="userId", required=true) Integer userId
) {
        List<ReadingDetailsDto> readingDetailsDtos = null;
        try {
            readingDetailsDtos = readingService.findReadingsOflastWeek(userId);
            return new ResponseEntity<List<ReadingDetailsDto>>(readingDetailsDtos, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<List<ReadingDetailsDto>>(readingDetailsDtos, HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity<ReadingDetails> readingsPost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody ReadingDetailsDto body
) {
        ReadingDetails readingDetails = readingService.saveReading(body);
        return new ResponseEntity<ReadingDetails>(readingDetails, HttpStatus.OK);
    }



    public ResponseEntity<Void> readingsReadingIdDelete(@Min(1)@ApiParam(value = "The ID of the reading to delete",required=true, allowableValues="") @PathVariable("readingId") Integer readingId
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ReadingDetails> readingsReadingIdGet(@Min(1)@ApiParam(value = "The ID of the reading to return",required=true, allowableValues="") @PathVariable("readingId") Integer readingId
) {
        ReadingDetails readingDetails = readingService.findByReadingId(readingId);
        return new ResponseEntity<ReadingDetails>(readingDetails, HttpStatus.OK);
    }

    public ResponseEntity<ReadingDetails> readingsPut(@ApiParam(value = "" ,required=true )  @Valid @RequestBody ReadingDetailsDto body
) {
        ReadingDetails updatedReadingDetails = readingService.updateReading(body);
        return new ResponseEntity<ReadingDetails>(updatedReadingDetails, HttpStatus.OK);
    }


    public ResponseEntity<ReadingDetailsDto> todaysReadingsGet(@ApiParam(value = "The ID of the user whose readings need to be retrieved." ,required=true) @RequestParam(value="userId", required=true) Integer userId
    ) {
        ReadingDetailsDto readingDetailsDto = null;
        try {
            readingDetailsDto = readingService.findTodaysReading(userId);
            return new ResponseEntity<ReadingDetailsDto>(readingDetailsDto, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<ReadingDetailsDto>(readingDetailsDto, HttpStatus.EXPECTATION_FAILED);
        }
    }

}

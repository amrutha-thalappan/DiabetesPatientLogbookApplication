package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.ErrorResponse;
import io.swagger.model.ReadingDetails;
import io.swagger.model.ReadingDetailsDto;
import io.swagger.service.ReadingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
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

    public ResponseEntity<?> readingsPost(@ApiParam(value = "" ,required=true )
                                          @Valid @RequestBody ReadingDetailsDto body) {
        ReadingDetails readingDetails = readingService.saveReading(body);
        return new ResponseEntity<>(readingDetails, HttpStatus.OK);
    }

    public ResponseEntity<?> readingsPut(@ApiParam(value = "" ,required=true )
                                         @Valid @RequestBody ReadingDetailsDto body) {
        try {
            ReadingDetails updatedReadingDetails = readingService.updateReading(body);
            return new ResponseEntity<>(updatedReadingDetails, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(new ErrorResponse(
                    417, "Cannot update reading"), HttpStatus.EXPECTATION_FAILED);
        }
    }


    public ResponseEntity<?> todaysReadingsGet(@ApiParam(
            value = "The ID of the user whose readings need to be retrieved." ,required=true)
                                               @RequestParam(value="userId", required=true) Integer userId) {
        ReadingDetailsDto readingDetailsDto = null;
        try {
            readingDetailsDto = readingService.findTodaysReading(userId);
            return new ResponseEntity<>(readingDetailsDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse(
                    17, "Cannot find reading "), HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity<?> allReadingsGet(@ApiParam(
            value = "The ID of the user whose readings need to be retrieved." ,
            required=true) @RequestParam(value="userId", required=true) Integer userId) {
        List<ReadingDetailsDto> readingDetailsDtos = null;
        try {
            readingDetailsDtos = readingService.findAllReadings(userId);
            return new ResponseEntity<>(readingDetailsDtos, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ErrorResponse(
                    417, "Cannot find reading list"), HttpStatus.EXPECTATION_FAILED);
        }
    }

}

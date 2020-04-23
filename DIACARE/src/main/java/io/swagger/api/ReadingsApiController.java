package io.swagger.api;

import io.swagger.model.DataListDto;
import io.swagger.model.DiabetesData;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.model.DiabetesDataDto;
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

    public ResponseEntity<List<DataListDto>> readingsGet(@ApiParam(value = "The ID of the user whose readings need to be retrieved." ,required=true) @RequestHeader(value="userId", required=true) Integer userId
) {
        List<DataListDto> diabetesDataDtos = null;
        try {
            diabetesDataDtos = readingService.findReadingsOflastWeek(userId);
            return new ResponseEntity<List<DataListDto>>(diabetesDataDtos, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<List<DataListDto>>(diabetesDataDtos, HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity<DiabetesData> readingsPost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody DiabetesDataDto body
) {
        DiabetesData diabetesData = readingService.saveReading(body);
        return new ResponseEntity<DiabetesData>(diabetesData, HttpStatus.OK);
    }

    public ResponseEntity<Void> readingsReadingIdDelete(@Min(1)@ApiParam(value = "The ID of the reading to delete",required=true, allowableValues="") @PathVariable("readingId") Integer readingId
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<DiabetesData> readingsReadingIdGet(@Min(1)@ApiParam(value = "The ID of the reading to return",required=true, allowableValues="") @PathVariable("readingId") Integer readingId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<DiabetesData>(objectMapper.readValue("{\n  \"reading\" : 0.8008281904610115,\n  \"Date\" : \"Date\"\n}", DiabetesData.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<DiabetesData>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<DiabetesData>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<DiabetesData> readingsReadingIdPut(@ApiParam(value = "" ,required=true )  @Valid @RequestBody DiabetesData body
, @Min(1)@ApiParam(value = "The ID of the reading to return",required=true, allowableValues="") @PathVariable("readingId") Integer readingId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<DiabetesData>(objectMapper.readValue("{\n  \"reading\" : 0.8008281904610115,\n  \"Date\" : \"Date\"\n}", DiabetesData.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<DiabetesData>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<DiabetesData>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<DiabetesData>> readingsUserIdGet(@DecimalMin("1")@ApiParam(value = "The ID of the user whose readings need to be retrieved.",required=true) @PathVariable("userId") String userId
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<DiabetesData>>(objectMapper.readValue("[ {\n  \"reading\" : 0.8008281904610115,\n  \"Date\" : \"Date\"\n}, {\n  \"reading\" : 0.8008281904610115,\n  \"Date\" : \"Date\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<DiabetesData>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<DiabetesData>>(HttpStatus.NOT_IMPLEMENTED);
    }

}

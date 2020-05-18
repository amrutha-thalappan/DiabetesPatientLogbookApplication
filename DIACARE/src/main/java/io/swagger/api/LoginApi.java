/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.18).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.ErrorResponse;
import io.swagger.model.LoggedInUser;
import io.swagger.model.LoginCredentials;
import io.swagger.model.User;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-21T16:30:27.879Z[GMT]")
@CrossOrigin(origins = "http://localhost:8082", maxAge = 3600)
@Api(value = "login", description = "the login API")
@RequestMapping(value = "/login")
public interface LoginApi {

    @ApiOperation(value = "User login", nickname = "loginPost", notes = "Enables a user to login", response = LoggedInUser.class, tags={ "LoginController", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation.Return a user", response = LoggedInUser.class),
        @ApiResponse(code = 400, message = "Bad request", response = ErrorResponse.class),
        @ApiResponse(code = 404, message = "No user exists", response = ErrorResponse.class),
        @ApiResponse(code = 200, message = "Unexpected error") })
    @PostMapping
    ResponseEntity<?> loginPost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody LoginCredentials body
);

}

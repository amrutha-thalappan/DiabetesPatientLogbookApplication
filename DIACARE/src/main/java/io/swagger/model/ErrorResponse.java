package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ErrorResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-21T16:30:27.879Z[GMT]")
public class ErrorResponse   {
  @JsonProperty("statuscode")
  private Integer statuscode = null;

  @JsonProperty("message")
  private String message = null;

  public ErrorResponse(Integer statuscode, String message) {
    this.statuscode = statuscode;
    this.message = message;
  }

  public ErrorResponse statuscode(Integer statuscode) {
    this.statuscode = statuscode;
    return this;
  }

  /**
   * Get statuscode
   * @return statuscode
  **/
  @ApiModelProperty(value = "")
  
    public Integer getStatuscode() {
    return statuscode;
  }

  public void setStatuscode(Integer statuscode) {
    this.statuscode = statuscode;
  }

  public ErrorResponse message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
  **/
  @ApiModelProperty(value = "")
  
    public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorResponse errorResponse = (ErrorResponse) o;
    return Objects.equals(this.statuscode, errorResponse.statuscode) &&
        Objects.equals(this.message, errorResponse.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(statuscode, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorResponse {\n");
    
    sb.append("    statuscode: ").append(toIndentedString(statuscode)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

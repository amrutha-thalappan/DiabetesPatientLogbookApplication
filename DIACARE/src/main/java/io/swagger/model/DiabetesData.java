package io.swagger.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;

/**
 * Reading
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-21T16:30:27.879Z[GMT]")
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "DiabetesData")
public class DiabetesData {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false, nullable = false)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "userId", nullable = false)
  private User userId = null;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  @JsonProperty("date")
  @Column(name = "date")
  private Date date = null;

  @JsonProperty("day")
  @Column(name = "day")
  private String day = null;

  @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
  private List<Reading> readings = new ArrayList<>();

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public User getUserId() {
    return userId;
  }

  public void setUserId(User userId) {
    this.userId = userId;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getDay() {
    return day;
  }

  public void setDay(String day) {
    this.day = day;
  }

  public List<Reading> getReadings() {
    return readings;
  }

  public void setReadings(List<Reading> readings) {
    this.readings = readings;
  }
}
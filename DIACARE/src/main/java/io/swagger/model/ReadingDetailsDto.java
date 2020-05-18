package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-21T16:30:27.879Z[GMT]")
public class ReadingDetailsDto {

    @JsonProperty("userId")
    private Integer userId;

    @JsonProperty("date")
    private String date;

    @JsonProperty("day")
    private String day;

    @JsonProperty("insulinBeforeBed")
    private Integer insulinBeforeBed;

    @JsonProperty("insulinBeforeBedTime")
    private String insulinBeforeBedTime;

    @JsonProperty("sugarAtFast")
    private Integer sugarAtFast;

    @JsonProperty("sugarAtFastTime")
    private String sugarAtFastTime;

    @JsonProperty("mrngInsulinBeforeFood")
    private Integer mrngInsulinBeforeFood;

    @JsonProperty("mrngInsulinBeforeFoodTime")
    private String mrngInsulinBeforeFoodTime;

    @JsonProperty("mrngInsulinAfterFood")
    private Integer mrngInsulinAfterFood;

    @JsonProperty("mrngInsulinAfterFoodTime")
    private String mrngInsulinAfterFoodTime;

    @JsonProperty("mrngPlace")
    private String mrngPlace;

    @JsonProperty("mrngSugarBeforeFood")
    private Integer mrngSugarBeforeFood;

    @JsonProperty("mrngSugarBeforeFoodTime")
    private String mrngSugarBeforeFoodTime;

    @JsonProperty("mrngSugarAfterFood")
    private Integer mrngSugarAfterFood;

    @JsonProperty("mrngSugarAfterFoodTime")
    private String mrngSugarAfterFoodTime;

    @JsonProperty("noonInsulinBeforeFood")
    private Integer noonInsulinBeforeFood;

    @JsonProperty("noonInsulinBeforeFoodTime")
    private String noonInsulinBeforeFoodTime;

    @JsonProperty("noonInsulinAfterFood")
    private Integer noonInsulinAfterFood;

    @JsonProperty("noonInsulinAfterFoodTime")
    private String noonInsulinAfterFoodTime;

    @JsonProperty("noonPlace")
    private String noonPlace;

    @JsonProperty("noonSugarBeforeFood")
    private Integer noonSugarBeforeFood;

    @JsonProperty("noonSugarBeforeFoodTime")
    private String noonSugarBeforeFoodTime;

    @JsonProperty("noonSugarAfterFood")
    private Integer noonSugarAfterFood;

    @JsonProperty("noonSugarAfterFoodTime")
    private String noonSugarAfterFoodTime;

    @JsonProperty("evngInsulinBeforeFood")
    private Integer evngInsulinBeforeFood;

    @JsonProperty("evngInsulinBeforeFoodTime")
    private String evngInsulinBeforeFoodTime;

    @JsonProperty("evngInsulinAfterFood")
    private Integer evngInsulinAfterFood;

    @JsonProperty("evngInsulinAfterFoodTime")
    private String evngInsulinAfterFoodTime;

    @JsonProperty("evngPlace")
    private String evngPlace;

    @JsonProperty("evngSugarBeforeFood")
    private Integer evngSugarBeforeFood;

    @JsonProperty("evngSugarBeforeFoodTime")
    private String evngSugarBeforeFoodTime;

    @JsonProperty("evngSugarAfterFood")
    private Integer evngSugarAfterFood;

    @JsonProperty("evngSugarAfterFoodTime")
    private String evngSugarAfterFoodTime;

    @JsonProperty("comment")
    private String comment;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Integer getInsulinBeforeBed() {
        return insulinBeforeBed;
    }

    public void setInsulinBeforeBed(Integer insulinBeforeBed) {
        this.insulinBeforeBed = insulinBeforeBed;
    }

    public String getInsulinBeforeBedTime() {
        return insulinBeforeBedTime;
    }

    public void setInsulinBeforeBedTime(String insulinBeforeBedTime) {
        this.insulinBeforeBedTime = insulinBeforeBedTime;
    }

    public Integer getSugarAtFast() {
        return sugarAtFast;
    }

    public void setSugarAtFast(Integer sugarAtFast) {
        this.sugarAtFast = sugarAtFast;
    }

    public String getSugarAtFastTime() {
        return sugarAtFastTime;
    }

    public void setSugarAtFastTime(String sugarAtFastTime) {
        this.sugarAtFastTime = sugarAtFastTime;
    }

    public Integer getMrngInsulinBeforeFood() {
        return mrngInsulinBeforeFood;
    }

    public void setMrngInsulinBeforeFood(Integer mrngInsulinBeforeFood) {
        this.mrngInsulinBeforeFood = mrngInsulinBeforeFood;
    }

    public String getMrngInsulinBeforeFoodTime() {
        return mrngInsulinBeforeFoodTime;
    }

    public void setMrngInsulinBeforeFoodTime(String mrngInsulinBeforeFoodTime) {
        this.mrngInsulinBeforeFoodTime = mrngInsulinBeforeFoodTime;
    }

    public Integer getMrngInsulinAfterFood() {
        return mrngInsulinAfterFood;
    }

    public void setMrngInsulinAfterFood(Integer mrngInsulinAfterFood) {
        this.mrngInsulinAfterFood = mrngInsulinAfterFood;
    }

    public String getMrngInsulinAfterFoodTime() {
        return mrngInsulinAfterFoodTime;
    }

    public void setMrngInsulinAfterFoodTime(String mrngInsulinAfterFoodTime) {
        this.mrngInsulinAfterFoodTime = mrngInsulinAfterFoodTime;
    }

    public String getMrngPlace() {
        return mrngPlace;
    }

    public void setMrngPlace(String mrngPlace) {
        this.mrngPlace = mrngPlace;
    }

    public Integer getMrngSugarBeforeFood() {
        return mrngSugarBeforeFood;
    }

    public void setMrngSugarBeforeFood(Integer mrngSugarBeforeFood) {
        this.mrngSugarBeforeFood = mrngSugarBeforeFood;
    }

    public String getMrngSugarBeforeFoodTime() {
        return mrngSugarBeforeFoodTime;
    }

    public void setMrngSugarBeforeFoodTime(String mrngSugarBeforeFoodTime) {
        this.mrngSugarBeforeFoodTime = mrngSugarBeforeFoodTime;
    }

    public Integer getMrngSugarAfterFood() {
        return mrngSugarAfterFood;
    }

    public void setMrngSugarAfterFood(Integer mrngSugarAfterFood) {
        this.mrngSugarAfterFood = mrngSugarAfterFood;
    }

    public String getMrngSugarAfterFoodTime() {
        return mrngSugarAfterFoodTime;
    }

    public void setMrngSugarAfterFoodTime(String mrngSugarAfterFoodTime) {
        this.mrngSugarAfterFoodTime = mrngSugarAfterFoodTime;
    }

    public Integer getNoonInsulinBeforeFood() {
        return noonInsulinBeforeFood;
    }

    public void setNoonInsulinBeforeFood(Integer noonInsulinBeforeFood) {
        this.noonInsulinBeforeFood = noonInsulinBeforeFood;
    }

    public String getNoonInsulinBeforeFoodTime() {
        return noonInsulinBeforeFoodTime;
    }

    public void setNoonInsulinBeforeFoodTime(String noonInsulinBeforeFoodTime) {
        this.noonInsulinBeforeFoodTime = noonInsulinBeforeFoodTime;
    }

    public Integer getNoonInsulinAfterFood() {
        return noonInsulinAfterFood;
    }

    public void setNoonInsulinAfterFood(Integer noonInsulinAfterFood) {
        this.noonInsulinAfterFood = noonInsulinAfterFood;
    }

    public String getNoonInsulinAfterFoodTime() {
        return noonInsulinAfterFoodTime;
    }

    public void setNoonInsulinAfterFoodTime(String noonInsulinAfterFoodTime) {
        this.noonInsulinAfterFoodTime = noonInsulinAfterFoodTime;
    }

    public String getNoonPlace() {
        return noonPlace;
    }

    public void setNoonPlace(String noonPlace) {
        this.noonPlace = noonPlace;
    }

    public Integer getNoonSugarBeforeFood() {
        return noonSugarBeforeFood;
    }

    public void setNoonSugarBeforeFood(Integer noonSugarBeforeFood) {
        this.noonSugarBeforeFood = noonSugarBeforeFood;
    }

    public String getNoonSugarBeforeFoodTime() {
        return noonSugarBeforeFoodTime;
    }

    public void setNoonSugarBeforeFoodTime(String noonSugarBeforeFoodTime) {
        this.noonSugarBeforeFoodTime = noonSugarBeforeFoodTime;
    }

    public Integer getNoonSugarAfterFood() {
        return noonSugarAfterFood;
    }

    public void setNoonSugarAfterFood(Integer noonSugarAfterFood) {
        this.noonSugarAfterFood = noonSugarAfterFood;
    }

    public String getNoonSugarAfterFoodTime() {
        return noonSugarAfterFoodTime;
    }

    public void setNoonSugarAfterFoodTime(String noonSugarAfterFoodTime) {
        this.noonSugarAfterFoodTime = noonSugarAfterFoodTime;
    }

    public Integer getEvngInsulinBeforeFood() {
        return evngInsulinBeforeFood;
    }

    public void setEvngInsulinBeforeFood(Integer evngInsulinBeforeFood) {
        this.evngInsulinBeforeFood = evngInsulinBeforeFood;
    }

    public String getEvngInsulinBeforeFoodTime() {
        return evngInsulinBeforeFoodTime;
    }

    public void setEvngInsulinBeforeFoodTime(String evngInsulinBeforeFoodTime) {
        this.evngInsulinBeforeFoodTime = evngInsulinBeforeFoodTime;
    }

    public Integer getEvngInsulinAfterFood() {
        return evngInsulinAfterFood;
    }

    public void setEvngInsulinAfterFood(Integer evngInsulinAfterFood) {
        this.evngInsulinAfterFood = evngInsulinAfterFood;
    }

    public String getEvngInsulinAfterFoodTime() {
        return evngInsulinAfterFoodTime;
    }

    public void setEvngInsulinAfterFoodTime(String evngInsulinAfterFoodTime) {
        this.evngInsulinAfterFoodTime = evngInsulinAfterFoodTime;
    }

    public String getEvngPlace() {
        return evngPlace;
    }

    public void setEvngPlace(String evngPlace) {
        this.evngPlace = evngPlace;
    }

    public Integer getEvngSugarBeforeFood() {
        return evngSugarBeforeFood;
    }

    public void setEvngSugarBeforeFood(Integer evngSugarBeforeFood) {
        this.evngSugarBeforeFood = evngSugarBeforeFood;
    }

    public String getEvngSugarBeforeFoodTime() {
        return evngSugarBeforeFoodTime;
    }

    public void setEvngSugarBeforeFoodTime(String evngSugarBeforeFoodTime) {
        this.evngSugarBeforeFoodTime = evngSugarBeforeFoodTime;
    }

    public Integer getEvngSugarAfterFood() {
        return evngSugarAfterFood;
    }

    public void setEvngSugarAfterFood(Integer evngSugarAfterFood) {
        this.evngSugarAfterFood = evngSugarAfterFood;
    }

    public String getEvngSugarAfterFoodTime() {
        return evngSugarAfterFoodTime;
    }

    public void setEvngSugarAfterFoodTime(String evngSugarAfterFoodTime) {
        this.evngSugarAfterFoodTime = evngSugarAfterFoodTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

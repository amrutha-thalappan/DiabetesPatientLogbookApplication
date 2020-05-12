package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-21T16:30:27.879Z[GMT]")
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Readings")
public class ReadingDetails implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "day")
    private String day;

    @Column(name = "insulinBeforeBed")
    private Integer insulinBeforeBed;

    @Column(name = "insulinBeforeBedTime")
    private String insulinBeforeBedTime;

    @Column(name = "SugarAtFast")
    private Integer SugarAtFast;

    @Column(name = "SugarAtFastTime")
    private String SugarAtFastTime;

    @Column(name = "mrngInsulinBeforeFood")
    private Integer mrngInsulinBeforeFood;

    @Column(name = "mrngInsulinBeforeFoodTime")
    private String mrngInsulinBeforeFoodTime;

    @Column(name = "mrngInsulinAfterFood")
    private Integer mrngInsulinAfterFood;

    @Column(name = "mrngInsulinAfterFoodTime")
    private String mrngInsulinAfterFoodTime;

    @Column(name = "mrngPlace")
    private String mrngPlace;

    @Column(name = "mrngSugarBeforeFood")
    private Integer mrngSugarBeforeFood;

    @Column(name = "mrngSugarBeforeFoodTime")
    private String mrngSugarBeforeFoodTime;

    @Column(name = "mrngSugarAfterFood")
    private Integer mrngSugarAfterFood;

    @Column(name = "mrngSugarAfterFoodTime")
    private String mrngSugarAfterFoodTime;

    @Column(name = "noonInsulinBeforeFood")
    private Integer noonInsulinBeforeFood;

    @Column(name = "noonInsulinBeforeFoodTime")
    private String noonInsulinBeforeFoodTime;

    @Column(name = "noonInsulinAfterFood")
    private Integer noonInsulinAfterFood;

    @Column(name = "noonInsulinAfterFoodTime")
    private String noonInsulinAfterFoodTime;

    @Column(name = "noonPlace")
    private String noonPlace;

    @Column(name = "noonSugarBeforeFood")
    private Integer noonSugarBeforeFood;

    @Column(name = "noonSugarBeforeFoodTime")
    private String noonSugarBeforeFoodTime;

    @Column(name = "noonSugarAfterFood")
    private Integer noonSugarAfterFood;

    @Column(name = "noonSugarAfterFoodTime")
    private String noonSugarAfterFoodTime;

    @Column(name = "evngInsulinBeforeFood")
    private Integer evngInsulinBeforeFood;

    @Column(name = "evngInsulinBeforeFoodTime")
    private String evngInsulinBeforeFoodTime;

    @Column(name = "evngInsulinAfterFood")
    private Integer evngInsulinAfterFood;

    @Column(name = "evngInsulinAfterFoodTime")
    private String evngInsulinAfterFoodTime;

    @Column(name = "evngPlace")
    private String evngPlace;

    @Column(name = "evngSugarBeforeFood")
    private Integer evngSugarBeforeFood;

    @Column(name = "evngSugarBeforeFoodTime")
    private String evngSugarBeforeFoodTime;

    @Column(name = "evngSugarAfterFood")
    private Integer evngSugarAfterFood;

    @Column(name = "evngSugarAfterFoodTime")
    private String evngSugarAfterFoodTime;

    @Column(name = "comment")
    private String comment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        return SugarAtFast;
    }

    public void setSugarAtFast(Integer sugarAtFast) {
        SugarAtFast = sugarAtFast;
    }

    public String getSugarAtFastTime() {
        return SugarAtFastTime;
    }

    public void setSugarAtFastTime(String sugarAtFastTime) {
        SugarAtFastTime = sugarAtFastTime;
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

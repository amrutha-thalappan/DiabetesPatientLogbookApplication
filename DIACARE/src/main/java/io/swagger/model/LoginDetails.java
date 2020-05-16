package io.swagger.model;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.io.Serializable;

@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-21T16:30:27.879Z[GMT]")
@Entity
@Table(name = "LoginDetails")
public class LoginDetails implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) // Autoincrement
    @Column(name = "id", updatable = false, nullable = false) /// column name
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId", nullable = false, referencedColumnName = "userId")
    private User userId = null;

    @Column(name = "userName")
    private String userName = null;

    @Column(name = "password")
    private String password = null;

    public LoginDetails id(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     * @return id
     **/
    @ApiModelProperty(value = "")


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LoginDetails userId(User userId) {
        this.userId = userId;
        return this;
    }

    /**
     * Get userId
     * @return userId
     **/
    @ApiModelProperty(value = "")

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public LoginDetails userName(String userName) {
        this.userName = userName;
        return this;
    }

    /**
     * Get userName
     * @return userName
     **/
    @ApiModelProperty(value = "")

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LoginDetails password(String password) {
        this.password = password;
        return this;
    }

    /**
     * Get password
     * @return password
     **/
    @ApiModelProperty(value = "")

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

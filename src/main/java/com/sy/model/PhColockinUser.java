package com.sy.model;


import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class PhColockinUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    @JsonFormat(pattern = "yyyy-MM-dd")
//    @JSONField(format = "yyyy-MM-dd")
    private Date morningColock;
    private Date nightColock;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getMorningColock() {
        return morningColock;
    }

    public void setMorningColock(Date morningColock) {
        this.morningColock = morningColock;
    }

    public Date getNightColock() {
        return nightColock;
    }

    public void setNightColock(Date nightColock) {
        this.nightColock = nightColock;
    }

    @Override
    public String toString() {
        return "PhColockinUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", morningColock=" + morningColock +
                ", nightColock=" + nightColock +
                '}';
    }
}

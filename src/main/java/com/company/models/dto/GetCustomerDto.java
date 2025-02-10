package com.company.models.dto;

import com.company.models.Gender;

public class GetCustomerDto {

    private Integer id;
    private String name;
    //private String mobile; dont show
    private Gender gender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}

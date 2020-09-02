package com.qa.fit.dto;

import java.util.ArrayList;
import java.util.List;

public class UsersDTO {
    private Long user_id;
    private String fName;
    private String lName;
    private String gender;
    private List<FitDTO> fit = new ArrayList<>();

    public UsersDTO(String fName, String lName, String gender) {
        this.fName = fName;
        this.lName = lName;
        this.gender = gender;
    }

    public UsersDTO() {
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<FitDTO> getFit() {
        return fit;
    }

    public void setFit(List<FitDTO> fit) {
        this.fit = fit;
    }
}

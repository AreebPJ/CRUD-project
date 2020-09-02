package com.qa.fit.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "fit"})
public class Users {
    @Id
    @GeneratedValue
    private Long user_id;

    @Column
    private String fName;

    @Column
    private String lName;

    @Column
    private String gender;

    @OneToMany(mappedBy = "users", fetch = FetchType.EAGER)
    private List<Fit> fit = new ArrayList<>();

    public Users() {
    }

    public Users(String fName, String lName, String gender) {
        this.fName = fName;
        this.lName = lName;
        this.gender = gender;
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

    public List<Fit> getFit() {
        return fit;
    }

    public void setFit(List<Fit> fit) {
        this.fit = fit;
    }
}

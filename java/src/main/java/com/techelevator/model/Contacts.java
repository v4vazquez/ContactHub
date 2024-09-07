package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Contacts {
    private int contactId;
    private int userId;
    private String name;
    private String notes;
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private Date birthDate;
    private String email;
    private String address;
    private String likes;
    private String dislikes;


    public Contacts() {

    }

    public Contacts(int contactId,int userId, String name, String notes, Date birthDate,
                    String email, String address, String likes, String dislikes) {
        this.contactId = contactId;
        this.userId = userId;
        this.name = name;
        this.notes = notes;
        this.birthDate = birthDate;
        this.email = email;
        this.address = address;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getDislikes() {
        return dislikes;
    }

    public void setDislikes(String dislikes) {
        this.dislikes = dislikes;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "contactId=" + contactId +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", notes='" + notes + '\'' +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", likes='" + likes + '\'' +
                ", dislikes='" + dislikes + '\'' +
                '}';
    }
}

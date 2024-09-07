package com.techelevator.model;

public class ProfilePicture {
    private int id;
    private int contactId;
    private String pictureUrl;


    public ProfilePicture() {

    }

    public ProfilePicture(int id, int contactId, String pictureUrl) {
        this.id = id;
        this.contactId = contactId;
        this.pictureUrl = pictureUrl;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    @Override
    public String toString() {
        return "ProfilePicture{" +
                "id=" + id +
                ", contactId=" + contactId +
                ", pictureUrl='" + pictureUrl + '\'' +
                '}';
    }
}

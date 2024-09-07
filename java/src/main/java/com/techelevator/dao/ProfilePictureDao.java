package com.techelevator.dao;

import com.techelevator.model.ProfilePicture;

public interface ProfilePictureDao {

    void saveProfilePicture(ProfilePicture profilePicture);
    ProfilePicture getProfilePictureByContactId(int contactId);
}

package com.techelevator.dao;

import com.techelevator.model.ProfilePicture;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcProfilePictureDao implements ProfilePictureDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcProfilePictureDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveProfilePicture(ProfilePicture profilePicture){
        String sql = "INSERT INTO profile_pictures (contact_id, profile_picture_url) VALUES (?,?)";
        jdbcTemplate.update(sql, profilePicture.getContactId(), profilePicture.getPictureUrl());
    }
    @Override
    public ProfilePicture getProfilePictureByContactId(int contactId){
        String sql = "SELECT * FROM profile_pictures WHERE contact_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, contactId);
        if(results.next()){
            return mapRowToProfilePicture(results);
        }
        return null;
    }

    private ProfilePicture mapRowToProfilePicture(SqlRowSet results){
        ProfilePicture profilePicture = new ProfilePicture();
        profilePicture.setId(results.getInt("profile_picture_id"));
        profilePicture.setContactId(results.getInt("contact_id"));
        profilePicture.setPictureUrl(results.getString("profile_picture_url"));
        return profilePicture;
    }
}

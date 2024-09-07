package com.techelevator.dao;

import com.techelevator.model.Contacts;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcContactsDao implements ContactsDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcContactsDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public int createContact(User user, Contacts contacts){
        String sql = "Insert INTO contacts(user_id, name, notes, birthDate, email, address, likes, dislikes) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?) RETURNING contact_id";
       return jdbcTemplate.queryForObject(sql,new Object[]{user.getId(),contacts.getName(),contacts.getNotes(),
                contacts.getBirthDate(),contacts.getEmail(),contacts.getAddress(),contacts.getLikes(),contacts.getDislikes()}, Integer.class);
    }
    public List<Contacts> getContactsForCurrentUser(int userId){
        List<Contacts> contactsList = new ArrayList<>();
        String sql = "SELECT * FROM contacts WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,userId);
        while(results.next()){
            contactsList.add(mapRowToContacts(results));
        }
        return contactsList;
    }
    public void updateContact(int contactId, Contacts contacts){
        String sql = "UPDATE contacts SET name = ?, notes = ?, birthDate = ?, email = ? , " +
                "address = ?, likes = ?, dislikes = ? WHERE contact_id = ? ";
        jdbcTemplate.update(sql,contacts.getName(), contacts.getNotes(),contacts.getBirthDate(),
                contacts.getEmail(), contacts.getAddress(),contacts.getLikes(), contacts.getDislikes(), contactId);
    }

    public void deleteContact(int contactId){
        String sql = "DELETE from contacts where contact_id = ? ";
        jdbcTemplate.update(sql,contactId);
    }
    public Contacts mapRowToContacts(SqlRowSet results){
        Contacts contacts = new Contacts();
        contacts.setName(results.getString("name"));
        contacts.setContactId(results.getInt("contact_id"));
        contacts.setUserId(results.getInt("user_id"));
        contacts.setNotes(results.getString("notes"));
        contacts.setBirthDate(results.getDate("birthdate"));
        contacts.setEmail(results.getString("email"));
        contacts.setAddress(results.getString("address"));
        contacts.setLikes(results.getString("likes"));
        contacts.setDislikes(results.getString("dislikes"));

     return contacts;
    }
}

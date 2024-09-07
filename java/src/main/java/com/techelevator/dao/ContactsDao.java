package com.techelevator.dao;

import com.techelevator.model.Contacts;
import com.techelevator.model.User;

import java.util.List;

public interface ContactsDao {

    int createContact(User user, Contacts contacts);
    void updateContact(int contactId, Contacts contacts);
    List<Contacts> getContactsForCurrentUser(int contactId);
    void deleteContact(int contactId);

}

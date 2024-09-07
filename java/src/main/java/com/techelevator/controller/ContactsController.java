package com.techelevator.controller;

import com.techelevator.Services.S3Service;
import com.techelevator.dao.ContactsDao;
import com.techelevator.dao.ProfilePictureDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Contacts;
import com.techelevator.model.ProfilePicture;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/contacts")
@CrossOrigin
public class ContactsController {

    private final ContactsDao contactsDao;
    private final S3Service s3Service;
    private final ProfilePictureDao profilePictureDao;
    @Autowired
    private final UserDao userDao;

    public ContactsController(ContactsDao contactsDao, UserDao userDao, S3Service s3Service, ProfilePictureDao profilePictureDao){
        this.contactsDao = contactsDao;
        this.userDao = userDao;
        this.s3Service = s3Service;
        this.profilePictureDao = profilePictureDao;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/new-contact",consumes = {"multipart/form-data"})
    public void createContact(Principal principal, @ModelAttribute Contacts contacts,
                              @RequestPart("profilePicture") MultipartFile profilePicture){
        if(principal != null) {
            User user = userDao.getUserByUsername(principal.getName());
            int contactId = contactsDao.createContact(user, contacts);

            String profilePictureUrl = s3Service.uploadFile(profilePicture);
            ProfilePicture picture = new ProfilePicture();

            picture.setContactId(contactId);
            picture.setPictureUrl(profilePictureUrl);
            profilePictureDao.saveProfilePicture(picture);
        }
        else{
            System.out.println("User is not logged in");
        }
    }
    @RequestMapping(path ="/contacts-list/{userId}", method=RequestMethod.GET)
    public List<Contacts> getContactsForCurrentUser(@PathVariable int userId){
        return contactsDao.getContactsForCurrentUser(userId);
    }
//    @RequestMapping(path ="/update-contact/{contactId}", method = RequestMethod.PUT)
//    public void updateContact(@RequestBody Contacts contacts, @PathVariable int contactId){
//        contactsDao.updateContact(contactId,contacts);
//    }
    @RequestMapping(path="/update-contact/{contactId}", method=RequestMethod.PUT, consumes = {"multipart/form-data"})
    public void updateContact(@PathVariable int contactId, @ModelAttribute Contacts contacts,
                              @RequestPart(value="profilePicture", required=false) MultipartFile profilePicture){
        contactsDao.updateContact(contactId, contacts);
        if(profilePicture !=null && !profilePicture.isEmpty()){
            String profilePictureUrl = s3Service.uploadFile(profilePicture);

            ProfilePicture existingPicture = profilePictureDao.getProfilePictureByContactId(contactId);
                    if(existingPicture != null){
                        existingPicture.setPictureUrl(profilePictureUrl);
                        profilePictureDao.saveProfilePicture(existingPicture);
                    }else{
                        ProfilePicture newPicture = new ProfilePicture();
                        newPicture.setContactId(contactId);
                        newPicture.setPictureUrl(profilePictureUrl);
                        profilePictureDao.saveProfilePicture(newPicture);
                    }
        }
    }

    @RequestMapping(path="/delete-contact/{contactId}", method = RequestMethod.DELETE)
    public void deleteContact(@PathVariable int contactId){
        contactsDao.deleteContact(contactId);
    }


}

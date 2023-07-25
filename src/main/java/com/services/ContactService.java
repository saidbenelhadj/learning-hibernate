package com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.information.learninghibernate.entities.ContactEntity;
import com.information.learninghibernate.reporitories.ContactRepository;

@Service
public class ContactService {

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }
    private final ContactRepository contactRepository;

    public Iterable<ContactEntity> findAll(){
        return contactRepository.findAll();
    }
    public ContactEntity save(ContactEntity contact){
        return contactRepository.save(contact);
    }

    public void deleteByid(Integer id){
        contactRepository.deleteById(id);
    }
    public ContactEntity findById(Integer id){
        return contactRepository.findById(id).orElse(null);
    }
    public Iterable<ContactEntity> findByName(String name){
        return contactRepository.findByNameLike(name);
    }
}

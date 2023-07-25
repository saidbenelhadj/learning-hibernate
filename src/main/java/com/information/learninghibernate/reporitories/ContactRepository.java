package com.information.learninghibernate.reporitories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.information.learninghibernate.entities.ContactEntity;

@Repository
public interface ContactRepository extends CrudRepository<ContactEntity, Integer> {
    Iterable<ContactEntity> findByNameLike(String name);
}

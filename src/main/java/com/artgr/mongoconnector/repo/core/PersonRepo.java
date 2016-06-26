package com.artgr.mongoconnector.repo.core;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepo extends MongoRepository<Person, ObjectId> {

    Person findByFullName(final String fullName);

}

package com.artgr.mongoconnector.repo.history;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ShoppingHistoryRepo extends MongoRepository<ShoppingHistory, ObjectId>{

    List<ShoppingHistory> findAllByPersonId(final ObjectId personId);

}

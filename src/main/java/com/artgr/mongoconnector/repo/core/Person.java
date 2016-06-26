package com.artgr.mongoconnector.repo.core;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class Person {
    private ObjectId id;
    private String fullName;
}

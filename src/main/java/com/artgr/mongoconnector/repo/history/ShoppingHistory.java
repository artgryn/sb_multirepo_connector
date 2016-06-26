package com.artgr.mongoconnector.repo.history;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class ShoppingHistory {
    private ObjectId id;
    private ObjectId personId;
    private String itemName;
    private Integer price;
}

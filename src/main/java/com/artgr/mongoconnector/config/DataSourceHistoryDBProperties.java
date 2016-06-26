package com.artgr.mongoconnector.config;

import lombok.Data;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("datasource.history")
public class DataSourceHistoryDBProperties {
    private MongoProperties mongodb = new MongoProperties();
}

package com.artgr.mongoconnector.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClientURI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

@Configuration
public abstract class AbstractRepoConfig {

    protected abstract String getDatabaseName();

    protected abstract MongoClientURI getPropertiesMongoUri();

    public abstract Mongo mongo() throws Exception;

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory());
    }

    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
        return new SimpleMongoDbFactory(getPropertiesMongoUri());
    }
}

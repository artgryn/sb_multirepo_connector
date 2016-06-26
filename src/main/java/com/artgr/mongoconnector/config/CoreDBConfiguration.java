package com.artgr.mongoconnector.config;

import com.artgr.mongoconnector.repo.core.CoreDBMarker;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackageClasses = CoreDBMarker.class, mongoTemplateRef = "mongoOperations")
public class CoreDBConfiguration extends AbstractRepoConfig {

    @Bean
    @Primary
    public MongoProperties primaryDataSource() {
        return new MongoProperties();
    }

    @Override
    protected String getDatabaseName() {
        final MongoClientURI mongoUri = new MongoClientURI(primaryDataSource().getUri());
        return mongoUri.getDatabase();
    }

    @Override
    protected MongoClientURI getPropertiesMongoUri() {
        return new MongoClientURI(primaryDataSource().getUri());
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(primaryDataSource().getHost(), primaryDataSource().getPort());
    }

    @Bean(name = {"mongoOperations"})
    @Override
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), getDatabaseName());
    }
}


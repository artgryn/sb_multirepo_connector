package com.artgr.mongoconnector.config;

import com.artgr.mongoconnector.repo.history.HistoryDBMarker;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackageClasses = HistoryDBMarker.class, mongoTemplateRef = "mongoHistoryOperations")
public class HistoryDBConfiguration extends AbstractRepoConfig {
    @Bean
    public DataSourceHistoryDBProperties getHistorDataSource() {
        return new DataSourceHistoryDBProperties();
    }

    @Override
    protected String getDatabaseName() {
        final MongoClientURI mongoUri = new MongoClientURI(getHistorDataSource().getMongodb().getUri());
        return mongoUri.getDatabase();
    }

    @Override
    protected MongoClientURI getPropertiesMongoUri() {
        return new MongoClientURI(getHistorDataSource().getMongodb().getUri());
    }

    @Override
    public Mongo mongo() throws Exception {
        final MongoClientURI mongoUri = new MongoClientURI(getHistorDataSource().getMongodb().getUri());
        return new MongoClient(mongoUri.getHosts().get(0), getHistorDataSource().getMongodb().getPort());
    }

    @Bean(name = {"mongoHistoryOperations"})
    @Override
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), getDatabaseName());
    }
}

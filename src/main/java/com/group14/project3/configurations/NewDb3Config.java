package com.group14.project3.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.groupO.project2.repository.commentRepo"},
mongoTemplateRef = NewDb3Config.MONGO_TEMPLATE
)
public class NewDb3Config {
    protected static final String MONGO_TEMPLATE = "newdb3MongoTemplate";
}
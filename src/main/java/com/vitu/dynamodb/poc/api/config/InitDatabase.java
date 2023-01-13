package com.vitu.dynamodb.poc.api.config;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class InitDatabase {

    @Autowired
    AmazonDynamoDB amazonDynamoDB;

    @Bean
    public void createTable() {

        CreateTableRequest request = new CreateTableRequest()
                .withAttributeDefinitions(new AttributeDefinition("id", ScalarAttributeType.S))
                .withKeySchema(new KeySchemaElement("id", KeyType.HASH))
                .withProvisionedThroughput(new ProvisionedThroughput(1L, 1L))
                .withTableName("person");
        try {
            CreateTableResult result = amazonDynamoDB.createTable(request);
            System.out.println(result.getTableDescription().getTableName());
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
        }
    }

}

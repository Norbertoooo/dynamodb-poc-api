package com.vitu.dynamodb.poc.api.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedJson;
import com.amazonaws.services.dynamodbv2.xspec.S;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "person")
public class Person {

    @DynamoDBHashKey
    private String id;

    @DynamoDBTypeConvertedJson
    private Document document;

}

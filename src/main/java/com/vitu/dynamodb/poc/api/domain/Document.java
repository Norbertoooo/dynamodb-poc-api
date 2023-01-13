package com.vitu.dynamodb.poc.api.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Document {

    private String numero;
    private String type;
    private String name;
}

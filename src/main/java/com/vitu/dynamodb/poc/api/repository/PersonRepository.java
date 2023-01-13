package com.vitu.dynamodb.poc.api.repository;

import com.vitu.dynamodb.poc.api.domain.Person;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@EnableScan
public interface PersonRepository extends CrudRepository<Person, String> {

    Optional<Person> findByDocument_Name(String name);
}

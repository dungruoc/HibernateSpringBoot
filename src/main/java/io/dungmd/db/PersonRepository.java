package io.dungmd.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.dungmd.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

}
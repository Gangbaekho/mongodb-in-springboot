package com.jinsoo.mongodbinspringboot;

import com.jinsoo.mongodbinspringboot.model.Person;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import static org.springframework.data.mongodb.core.query.Criteria.where;

public class MongoApp {

    private static Logger LOGGER = LoggerFactory.getLogger(MongoApp.class);

    public static void main(String[] args){

        MongoOperations mongoOps = new MongoTemplate(MongoClients.create(),"database");
        mongoOps.insert(new Person("jinsoo",28));

        LOGGER.info("person whose name is jinsoo -> {}",mongoOps.findOne(new Query(where("name").is("jinsoo")),Person.class));

        mongoOps.dropCollection("person");


    }
}

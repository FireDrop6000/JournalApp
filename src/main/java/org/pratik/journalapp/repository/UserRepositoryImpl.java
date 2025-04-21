package org.pratik.journalapp.repository;

import java.util.List;

import org.pratik.journalapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class UserRepositoryImpl {
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<User> getUsersForSA() {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").regex("^[a-zA-Z0-9_.±]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$"));
        query.addCriteria(Criteria.where("sentimentAnalysis").exists(true));

        List<User> users = mongoTemplate.find(query, User.class);
        return users;
    }
}

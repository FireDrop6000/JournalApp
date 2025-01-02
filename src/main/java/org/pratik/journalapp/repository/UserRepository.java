package org.pratik.journalapp.repository;

import org.bson.types.ObjectId;
import org.pratik.journalapp.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
    public User findByUsername(String username);
    public void deleteByUsername(String username);

}

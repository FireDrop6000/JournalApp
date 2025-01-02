package org.pratik.journalapp.repository;

import org.bson.types.ObjectId;
import org.pratik.journalapp.entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalRepository extends MongoRepository<JournalEntry, ObjectId>  {

    
}

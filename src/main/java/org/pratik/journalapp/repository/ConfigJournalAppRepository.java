package org.pratik.journalapp.repository;

import org.bson.types.ObjectId;
import org.pratik.journalapp.entity.ConfigJournalAppEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigJournalAppRepository extends MongoRepository<ConfigJournalAppEntity, ObjectId> {

}

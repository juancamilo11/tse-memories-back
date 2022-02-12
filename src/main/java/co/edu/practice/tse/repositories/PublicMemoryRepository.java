package co.edu.practice.tse.repositories;

import co.edu.practice.tse.collections.PublicMemory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicMemoryRepository extends CrudRepository<PublicMemory, String> {
}

package co.edu.practice.tse.repositories;

import co.edu.practice.tse.collections.ProtectedMemory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProtectedMemoryRepository extends MongoRepository<ProtectedMemory, Long> {
}

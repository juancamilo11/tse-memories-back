package co.edu.practice.tse.repositories;

import co.edu.practice.tse.collections.PrivateMemory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivateMemoryRepository extends MongoRepository<PrivateMemory, Long> {
}

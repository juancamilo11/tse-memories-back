package co.edu.practice.tse.repositories;

import co.edu.practice.tse.collections.PublicMemory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicMemoryRepository extends CrudRepository<PublicMemory, String> {
    List<PublicMemory> findAllById(String id);
}

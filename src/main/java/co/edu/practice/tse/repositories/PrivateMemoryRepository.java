package co.edu.practice.tse.repositories;

import co.edu.practice.tse.collections.PrivateMemory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrivateMemoryRepository extends CrudRepository<PrivateMemory, String> {
    List<PrivateMemory> findAllByCreatorId(String id);

}
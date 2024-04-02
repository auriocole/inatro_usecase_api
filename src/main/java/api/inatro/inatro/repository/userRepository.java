package api.inatro.inatro.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import api.inatro.inatro.model.userModel.userModel;

@Repository
public interface userRepository extends CrudRepository<userModel, Long> {
    
} 

package com.pfproject.api.repository;

import com.pfproject.api.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByUsername(final String userName);

    @Query(value = "{ 'username' : ?0 }", fields = "{ 'username' : 1, 'password' : 1}")
    List<User> findAll1();
}

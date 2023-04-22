package com.diploma.repository;

import com.diploma.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User> {

    @Query("SELECT u FROM User u WHERE u.username = :username")
    public User getUserByUsername(@Param("username") String username);
}

package com.jpa.todo.repository;

import com.jpa.todo.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Integer> {

    @Query("FROM AppUser u WHERE u.username=:username AND u.password=:pass")
    AppUser findUserByUsernameAndPassword(@Param("username") String name, String pass);
}

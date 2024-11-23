package com.example.JGyNezok;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

//import java.util.Optional;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    /*@Query("SELECT m FROM Message m ORDER BY m.createdAt DESC")
    List<Message> findAllMessagesOrderedByCreatedAt();*/
}

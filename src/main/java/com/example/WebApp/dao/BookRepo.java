package com.example.WebApp.dao;

import com.example.WebApp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {

    @Modifying
    @Transactional
    @Query("update Book b set b.availability = ?2 where b.bid = ?1")
    void setFixedAvailabilityFor(int bid, String availability);

}

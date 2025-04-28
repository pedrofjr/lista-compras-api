package com.example.shoppinglist.repository;

import com.example.shoppinglist.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query("SELECT MAX(i.ordem) FROM Item i")
    Integer findMaxOrdem();
}

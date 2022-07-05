package com.storage.warehouse.item.repository;

import com.storage.warehouse.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
// <Item, Long> => tipo da entity, tipo do id
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Optional<Item>> findItemByName(String name);
    List<Optional<Item>> findItemByDescription(String name);

}

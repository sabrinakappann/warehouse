package com.storage.warehouse.compositionItemsQuantities.repository;

import com.storage.warehouse.compositionItemsQuantities.entity.CompositionItems;
import com.storage.warehouse.compositionItemsQuantities.entity.CompositionItemsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompositionItemsRepository extends JpaRepository<CompositionItems, CompositionItemsId> {

}

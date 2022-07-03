package com.storage.warehouse.compositionItemsQuantities;

import com.storage.warehouse.composition.Composition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompositionItemsRepository extends JpaRepository<CompositionItems, CompositionItemsId> {

}

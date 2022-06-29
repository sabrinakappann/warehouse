package com.storage.warehouse.component;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ComponentRepository extends JpaRepository<Component, Long> {

    List<Optional<Component>> findComponentByName(String name);
    List<Optional<Component>> findComponentByDescription(String description);

}

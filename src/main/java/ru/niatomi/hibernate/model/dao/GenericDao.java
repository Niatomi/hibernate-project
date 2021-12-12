package ru.niatomi.hibernate.model.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDao<Item, ID> {

    Optional<Item> findById(ID key);

    List<Item> findAll();

    Item save(Item item);

    Optional<Item> update(ID key, Item item);

    Optional<Item> deleteById(ID key);

}

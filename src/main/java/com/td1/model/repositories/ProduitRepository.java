package com.td1.model.repositories;

import org.springframework.data.repository.CrudRepository;

import com.td1.model.entities.Produit;

public interface ProduitRepository extends CrudRepository<Produit, Long> {

}

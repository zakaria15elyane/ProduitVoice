package com.therealdanvega.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.therealdanvega.domain.Produit;
public interface ProduitRepository extends JpaRepository<Produit,String>{

	public Page<Produit>findByNomContains(String mc,Pageable pageable);

	
}



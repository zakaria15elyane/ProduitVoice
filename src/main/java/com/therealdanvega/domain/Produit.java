package com.therealdanvega.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Produit {
	
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private String _id;
	
	private String nom;
	private String categorie;
	
	private String marque;
	@Id
	private String prix;
	private String description;

	
}

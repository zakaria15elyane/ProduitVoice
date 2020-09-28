package com.therealdanvega.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.therealdanvega.domain.Produit;

public class RestClient {

	private static final String CallVokal="";
	
	
	static RestTemplate restTemplate=new RestTemplate();
	HttpHeaders headers = new HttpHeaders();

	public static void main(String[] args) {
		callVokal();	
	}
	
	private static void callVokal(){
		Produit produit=new Produit();
		ResponseEntity<Produit> p=restTemplate.postForEntity(CallVokal,produit,Produit.class);
		System.out.println(p.getBody());
	}
	
}

package com.therealdanvega.controller;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.therealdanvega.domain.Produit;
import com.therealdanvega.repository.ProduitRepository;
@RestController


public class ProduitRestController {
	
	@Autowired
	private	ProduitRepository produitRepository;
	
	 //private FileStorageService fileStorageService;
	@GetMapping(path="/produit")
	 public List<Produit>produits(){
	return produitRepository.findAll();
	}
}

	/*  @PostMapping("/uploadFile")
	    public Responses uploadFile(@RequestParam("file") MultipartFile file) {
	        String fileName = fileStorageService.storeFile(file);

	        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	                .path("/downloadFile/")
	                .path(fileName)
	                .toUriString();

	        return new Responses(fileName,fileDownloadUri,file.getContentType(),file.getSize());
	    }

	    @PostMapping("/uploadMultipleFiles")
	    public List<Responses> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
	        return Arrays.asList(files)
	                .stream()
	                .map(file -> uploadFile(file))
	                .collect(Collectors.toList());
	    }*/
/*	private static void callVocal(){
		RestTemplate restTemplate=new RestTemplate();
		Produit produit=restTemplate.getForObject("url", Produit.class);
	}*/
	 /*@RequestMapping(path="/upload",
			 method = RequestMethod.POST,
				consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	    public ResponseEntity<byte[]> getsong(@PathParam("token") String token, HttpServletResponse response) {
	        try {
	        	
	                Path path = Paths.get("F:/audio/");
	                response.setContentType("audio/wav");
	                response.setHeader("Content-Disposition", "attachment; filename=\"	" + "song.wav" + "\"");
	                response.setContentLength((int) Files.size(path));
	                Files.copy(path, response.getOutputStream());
	                response.flushBuffer();
	                	
	                URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(produits().getClass())
                            .toUri();
	                return ResponseEntity.created(location).build();
	        } catch (Exception ignored) {
	        }
			return null;}}*/
	 
	    
	/* @PostMapping(path="/produits")
	
	
	   public void callVokal(@PathParam("audio.mp3") String audioPlay, InputStream flux) throws IOException {     
	      byte[] octets = lireOctets(flux);
	     FileOutputStream fichier = new FileOutputStream("C:/Users/Compaq/workspace/spring-boot-jsontodb-master/src/main/resources/audio/record.mp3");
	     fichier.write(octets);
	      fichier.close();
	      System.out.println("audio Saved!");
	   }
	 
	 private byte[] lireOctets(InputStream stream) throws IOException {
	      ByteArrayOutputStream baos = new ByteArrayOutputStream();
	      byte[] buffer = new byte[1024]; int octetsLus = 0;
	      do {
	         octetsLus = stream.read(buffer);
	         if (octetsLus > 0) { baos.write(buffer, 0, octetsLus); }
	      } 
	      while (octetsLus > -1);
	      return baos.toByteArray();
	 }}*/
	
	
	/*	@PostMapping(path="/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public String uploadFile(
		@FormDataParam("file") InputStream uploadedInputStream	
			)
	@PostMapping(path="/",value = "/createProduit", consumes = "application/json", produces = "application/json")
	private static void callVokal(){
		try {
			RestTemplate restTemplate=new RestTemplate();
			Produit produit=restTemplate.getForObject("url",Produit.class);
			System.out.println("Saved!");
		} catch (Exception e) {
			System.out.println("Unable to save: " + e.getMessage());
		}*/
		
		
	



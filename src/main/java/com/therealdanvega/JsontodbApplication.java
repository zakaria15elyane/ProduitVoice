package com.therealdanvega;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.LineUnavailableException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.therealdanvega.controller.ProduitController;
import com.therealdanvega.domain.Produit;
import com.therealdanvega.repository.ProduitRepository;

@SpringBootApplication

@RestController

public class JsontodbApplication {
	 private static final int RECORD_TIME = 10000; 
	public static void main(String[] args) {
			
		SpringApplication.run(JsontodbApplication.class, args);
		 File wavFile = new File("F:/Record.wav");
	     
		/* Client client=Client.create(new DefaultClientConfig());
			URI uri=UriBuilder.fromUri("http://localhost:8080/upload").build();
			//ObjectMapper mapper=new ObjectMapper();
			ClientResponse response=client.resource(uri).path("/upload")
					.type(MediaType.MULTIPART_FORM_DATA_VALUE)
					.post(ClientResponse.class);
			String corpsReqHttp=response.getEntity(String.class);
			System.out.println(corpsReqHttp);	
		*/
	}

/*		 @RequestMapping(path="/produits",method = RequestMethod.POST,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	     public ResponseEntity<Object> getsong(File file, InputStream flux, HttpServletResponse response) {
	        try {
	        	final TargetDataLine line;
	        	 
	        	 
	        	final AudioFileFormat.Type targetType = AudioFileFormat.Type.WAVE;
	        	//private final AudioFileFormat.Type targetType = AudioFileFormat.Type.AU;
	         
	         
	        	final AudioInputStream inputStream;
	         
	        	//byte[] octets = lireOctets(flux);
	                Path path = Paths.get("F:/audio/");
	                //response.setContentType("audio/wav");
	               
	               //response.getHeader("Content-Disposition");
	                //response.setHeader("Content-Disposition", "attachment; filename=\"	" + "song.wav" + "\"");
	               // response.sendRedirect("http://localhost:8080/upload");
	                //response.setContentLength((int) Files.size(path));
	                Files.copy(path, response.getOutputStream());
	                //response.flushBuffer();
	                //File convertFile = new File("F:/audio/"+file.getOriginalFilename());
	        		//convertFile.createNewFile();
	        		//FileOutputStream fout = new FileOutputStream(convertFile);
	        		//fout.write(file.getBytes());
	        		System.out.println(response.getOutputStream());
	        		return new ResponseEntity<>("File is uploaded successfully", HttpStatus.OK);
	        		//fout.close();		
	        }
	      
	        catch (Exception ignored) {
	        	System.out.println("Error");
	        }
	        // System.out.println("audio Saved!");
			return null;
	        
    		
    		//return new ResponseEntity<>("File is uploaded successfully", HttpStatus.OK);
	        //return null;
	        }*/
		 

/*	    private byte[] lireOctets(InputStream stream) throws IOException {
		      ByteArrayOutputStream baos = new ByteArrayOutputStream();
		      byte[] buffer = new byte[1024]; int octetsLus = 0;
		      do {
		         octetsLus = stream.read(buffer);
		         if (octetsLus > 0) { baos.write(buffer, 0, octetsLus); }
		      } 
		      while (octetsLus > -1);
		      return baos.toByteArray();}*/
	   
	/*@RequestMapping(value="/upload", method=RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Object> uploadFile(@RequestParam(value="file") MultipartFile file) throws IOException {
		File convertFile = new File("C:\\Users\\Compaq\\audio\\"+file.getBytes());
		convertFile.createNewFile();
		FileOutputStream fout = new FileOutputStream(convertFile);
		fout.write(file.getBytes());
		
		fout.close();
		return new ResponseEntity<>("File is uploaded successfully", HttpStatus.OK);
		
	*/
	
	@Bean
	CommandLineRunner runner(ProduitRepository produitRepository){
	    return args -> {
			// read JSON and load json
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Produit>> typeReference = new TypeReference<List<Produit>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/data_with_ids_v3_7.json");
			try {
				List<Produit> produits = mapper.readValue(inputStream,typeReference);
				produitRepository.saveAll(produits);
				System.out.println("Produits Saved!");
			} catch (IOException e){
				System.out.println("Unable to save produits: " + e.getMessage());
			}
	    };
	    
	}
}

package com.therealdanvega.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.therealdanvega.domain.Produit;
import com.therealdanvega.repository.ProduitRepository;
 
@Controller


public class ProduitController {
   
    
	@Autowired
	private	ProduitRepository produitRepository;
	@GetMapping(path="/index")
	public String index(){
		return "index";
	}
	@GetMapping(path="/produits")
	public String list(Model model, Pageable pageable,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="200") int size,
	@RequestParam(name="keyword",defaultValue="")String mc
			) {
		Page<Produit> pages = produitRepository.findByNomContains(mc,PageRequest.of(page, size));
		model.addAttribute("number", pages.getNumber());
		model.addAttribute("totalPages", pages.getTotalPages());
		model.addAttribute("totalPages", pages.getTotalPages());
		model.addAttribute("totalElements", pages.getTotalElements());
		model.addAttribute("currentPage",page);
		model.addAttribute("size",size);
		model.addAttribute("produits", pages.getContent());
		return "produits";}
	@GetMapping("/refresh")
	public String refreshCache(Model model, Pageable pageable) {
		//produitRepository.r;
		Page<Produit> pages = produitRepository.findAll(pageable);
		model.addAttribute("number", pages.getNumber());
		model.addAttribute("totalPages", pages.getTotalPages());
		model.addAttribute("totalElements", pages.getTotalElements());
		model.addAttribute("size", pages.getSize());
		model.addAttribute("produits", pages.getContent());
		return "produits";
	}
/*	
	@RequestMapping(value ="/produits",
			method = RequestMethod.POST,
			consumes = MediaType.MULTIPART_FORM_DATA_VALUE)

	public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException
	{
		File convertFile = new File("C:\\talk2amareswaran-downloads\\fileuploaddemo\\fileuploaddemo\\" + file.getOriginalFilename());
		convertFile.createNewFile();

		try (FileOutputStream fout = new FileOutputStream(convertFile))
		{
			fout.write(file.getBytes());
		}
		catch (Exception exe)
		{
			exe.printStackTrace();
		}
		return "File has uploaded successfully";
	}*/
	/*@RequestMapping(value="/produits", method=RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Object> uploadFile(@RequestParam(name = "audioPlay") MultipartFile[] file) throws IOException {
		File convertFile = new File("C:\\talk2amareswaran-downloads\\fileuploaddemo\\fileuploaddemo\\"+file.getOriginalFilename());
		convertFile.createNewFile();
		FileOutputStream fout = new FileOutputStream(convertFile);
		fout.write(file.getBytes());
		fout.close();
		return new ResponseEntity<>("File is uploaded successfully", HttpStatus.OK);
	}
	
*/
	@RequestMapping(value="/produits", method=RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
		File convertFile = new File("C:\\talk2amareswaran-downloads\\fileuploaddemo\\fileuploaddemo\\"+file.getOriginalFilename());
		convertFile.createNewFile();
		FileOutputStream fout = new FileOutputStream(convertFile);
		fout.write(file.getBytes());
		fout.close();
		return new ResponseEntity<>("File is uploaded successfully", HttpStatus.OK);
	}
	/*@RequestMapping(value="/produits", method=RequestMethod.POST)
	
		public void save(File wavFile) throws IOException {
		
		 byte[] audioData = recordBytes.toByteArray();
	        ByteArrayInputStream bais = new ByteArrayInputStream(audioData);
	        AudioInputStream audioInputStream = new AudioInputStream(bais, format,
	                audioData.length / format.getFrameSize());
	 
	        AudioSystem.write(audioInputStream, AudioFileFormat.Type.WAVE,wavFile);
	 
	        audioInputStream.close();
	        recordBytes.close();
			
	        }*/
		
		/*try{
		File convertFile = new File("C:\\talk2amareswaran-downloads\\fileuploaddemo\\fileuploaddemo\\"+file.getOriginalFilename());
		convertFile.createNewFile();
		FileOutputStream fout = new FileOutputStream(convertFile);
		fout.write(file.getBytes());
		fout.close();
		return new ResponseEntity<>("File is uploaded successfully", HttpStatus.OK);}
		   catch (Exception ignored) {
	        	System.out.println("Error");
	        	 return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	        }*/
	
		
		
	
	/* @RequestMapping(path="/produit",
			 method = RequestMethod.POST,
				consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	    public ResponseEntity<Object> getsong(@PathParam("token")MultipartFile file, InputStream flux, String token, HttpServletResponse response) {
	        try {
	        	byte[] octets = lireOctets(flux);
	                Path path = Paths.get("C:/Users/Compaq/workspace/spring-boot-jsontodb-master/src/main/resources/audio");
	                //response.setContentType("audio/wav"); 
	               response.getHeader("Content-Disposition");
	                //response.setHeader("Content-Disposition", "attachment; filename=\"	" + "song.wav" + "\"");
	                //response.sendRedirect("http://localhost:8080/upload");
	                response.setContentLength((int) Files.size(path));
	                Files.copy(path, response.getOutputStream());
	                response.flushBuffer();
	                File convertFile = new File("C:/Users/Compaq/workspace/spring-boot-jsontodb-master/src/main/resources/audio"+file.getOriginalFilename());
	        		convertFile.createNewFile();
	        		FileOutputStream fout = new FileOutputStream(convertFile);
	        		fout.write(file.getBytes());
	        		fout.close();
	        		
	        	    System.out.println("audio !");
	        } catch (Exception ignored) {
	        //ignored.printStackTrace();
	        }
	        System.out.println("audio Saved!");
    		
    		return new ResponseEntity<>("File is uploaded successfully", HttpStatus.OK);
    		
	        }
	    private byte[] lireOctets(InputStream stream) throws IOException {
		      ByteArrayOutputStream baos = new ByteArrayOutputStream();
		      byte[] buffer = new byte[1024]; int octetsLus = 0;
		      do {
		         octetsLus = stream.read(buffer);
		         if (octetsLus > 0) { baos.write(buffer, 0, octetsLus); }
		      } 
		      while (octetsLus > -1);
		      return baos.toByteArray();}*/
	/*@GetMapping(path="/produits")
	public String list(Model model,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="3") int size,
	@RequestParam(name="keyword",defaultValue="")String mc){
		Page<Produit>pageProduits=produitRepository.findByNomContains(mc,PageRequest.of(page, size));
		model.addAttribute("produits",pageProduits.getContent());
		model.addAttribute("pages",new int [pageProduits.getTotalPages()]);
		model.addAttribute("currentPage",page);
		model.addAttribute("size",size);
		model.addAttribute("keyword",mc);
		return "produits";
	}
	
/*	@GetMapping(path="/produit")
	

	public String list(Model model){
		List<Produit>produits=produitRepository.findAll();
		model.addAttribute("produits",produits);
		
		Produit produit=new Produit();
		ObjectMapper objectMapper=new ObjectMapper();
		try {
			String jsonStr=objectMapper.writeValueAsString(produits);
			System.out.println(jsonStr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "produit";
	}*/
			
	
	/*@GetMapping(path="/deleteProduit")
	public String delete(Long id,String keyword){
		produitRepository.deleteById(id);
		return "redirect:/patients?keyword="+keyword;
	}
	@GetMapping(path="/deleteProduit2")
	public String delete(Long id,String keyword,Model model){
		produitRepository.deleteById(id);
		return list(model, keyword);
	}
	@GetMapping(path="/formProduit")
	public String formProduit(Model model){
		model.addAttribute("produit",new Produit());
		model.addAttribute("mode","new");
		return "formProduit";
	}
	@GetMapping(path="/editProduit")
	public String editProduit(Model model,Long id){
		Produit p=produitRepository.findById(id).get();
		model.addAttribute("produit",p);
		model.addAttribute("mode", "edit");
		return "formProduit";
	}
	@PostMapping(path="/savePatient")
	public String savePatient(Model model,@Valid Produit produit,BindingResult bindingResult){
		if (bindingResult.hasErrors()) return "formProduit";
			produitRepository.save(produit);
			model.addAttribute("produit",produit);
			return "confirmation";
			
		

		

	}*/
}

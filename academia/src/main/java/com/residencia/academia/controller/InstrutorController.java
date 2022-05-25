package com.residencia.academia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.academia.dto.InstrutorDTO;
import com.residencia.academia.entity.Instrutor;

import com.residencia.academia.service.InstrutorService;


@RestController
@RequestMapping("/instrutor")
public class InstrutorController {
	
	@Autowired
	private InstrutorService instrutorService;
	
	@GetMapping
	public ResponseEntity<List<Instrutor>> findAllInstrutor(){
		List<Instrutor> instrutorList =instrutorService.findAllInstrutor();
//		return ResponseEntity.ok().body(instrutorList);
		return new ResponseEntity<>(instrutorList, HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Instrutor> findInstrutorById(@PathVariable Integer id) {
		//return new ResponseEntity<>(instrutorService.findInstrutorById(id), HttpStatus.OK);
		Instrutor instrutor = instrutorService.findInstrutorById(id);
		if (null == instrutor) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
		return new ResponseEntity<>(instrutor, HttpStatus.OK);
		}
	}
	
	@GetMapping("/dto/{id}")
	public ResponseEntity<InstrutorDTO> findInstrutorDTOById(@PathVariable Integer id) {
		//return new ResponseEntity<>(instrutorService.findInstrutorById(id), HttpStatus.OK);
		InstrutorDTO instrutorDTO = instrutorService.findInstrutorDTOById(id);
//		if (null == instrutorDTO) {
//			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//		} else {
		return new ResponseEntity<>(instrutorDTO, HttpStatus.OK);
		}
	
	
	
	
	 @PostMapping
	    public ResponseEntity <Instrutor> saveInstrutor(@RequestBody Instrutor instrutor){
		 Instrutor novoInstrutor = instrutorService.saveInstrutor(instrutor);
		 	
	        return new ResponseEntity<>(novoInstrutor, HttpStatus.CREATED);
	    }
	 
	 @PostMapping("/post-dto")
	    public ResponseEntity <InstrutorDTO> saveInstrutorDTO(@RequestBody InstrutorDTO instrutorDTO){
		 InstrutorDTO novoInstrutorDTO = instrutorService.saveInstrutorDTO(instrutorDTO);
		 
		 
	        return new ResponseEntity<>(novoInstrutorDTO, HttpStatus.CREATED);
	    }
	 
//	 @PostMapping("/post-dto")
//	 public ResponseEntity<Instrutor> salvar(@RequestBody InstrutorDTO dto) {
//	     Instrutor instrutor = instrutorService.saveInstrutor(dto.transformObject());
//	     return new ResponseEntity<>(instrutor, HttpStatus.CREATED);
//	 }

	    @PutMapping

	    public ResponseEntity<Instrutor> updateInstrutor (@RequestBody Instrutor instrutor){
	    	Instrutor novoInstrutor = instrutorService.updateInstrutor(instrutor);
	    	return new ResponseEntity<>(instrutor, HttpStatus.OK);
	    }
//	    public Instrutor update(@PathVariable(value = "id") Integer id, @RequestBody Instrutor instrutor) {
//	    	return instrutorService.saveInstrutor(instrutor);
//	    }
//	    
	    @DeleteMapping("/{id}")
	    public void delete(@PathVariable (value = "id") Integer Id){
	       instrutorService.deleteInstrutor(Id);
	    }
	    public ResponseEntity<String> deleteInstrutor(@PathVariable Integer id){
	    	instrutorService.deleteInstrutor(id);
	    	return new ResponseEntity<>("", HttpStatus.OK);
	    }

}

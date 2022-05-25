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

import com.residencia.academia.dto.TurmaDTO;
import com.residencia.academia.entity.Turma;
import com.residencia.academia.exception.NoSuchElementFoundException;
import com.residencia.academia.service.TurmaService;

@RestController
@RequestMapping ("/turma")
public class TurmaController {

	@Autowired
	private TurmaService turmaService;
	
	@GetMapping
	public ResponseEntity<List<Turma>> findAllTurma(){
		List<Turma> turmaList = turmaService.findAllTurma();
//		return ResponseEntity.ok().body(instrutorList);
		return new ResponseEntity<>(turmaService.findAllTurma(), HttpStatus.OK);
		
	}
	
//	@GetMapping("/{id}")
//	public ResponseEntity<Turma> findTurmaById(@PathVariable(value = "id")Integer id) {
//		return new ResponseEntity<>(turmaService.findTurmaById(id), HttpStatus.OK);
////		Turma turma= turmaService.findTurmaById(id);
////		return new ResponseEntity<>(turma, HttpStatus.OK);
//	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Turma> findTurmaById(@PathVariable Integer id) {
		Turma turma = turmaService.findTurmaById(id);
		if(null == turma)
			throw new NoSuchElementFoundException("ih! não foi encontrado o " + id + " tem certeza que ele existe?");
		else
			return new ResponseEntity<>(turmaService.findTurmaById(id), HttpStatus.OK);
	}
	
	 @PostMapping
	    public ResponseEntity<Turma> saveTurma(@RequestBody Turma turma){
	        return new ResponseEntity<> (turmaService.saveTurma(turma), HttpStatus.CREATED);
	    }
	 
	 @PostMapping("/post-dto")
     public ResponseEntity<TurmaDTO> saveDTO(@RequestBody TurmaDTO turmaDTO){
         TurmaDTO novaTurmaDTO = turmaService.saveTurmaDTO(turmaDTO);
         return new ResponseEntity<>(novaTurmaDTO, HttpStatus.CREATED);
     }
	 
	  @PutMapping
	    ResponseEntity<Turma> updateTurma(@RequestBody Turma turma) {
	    	return new ResponseEntity<>(turmaService.updateTurma (turma), HttpStatus.OK);
	  }
//	    public Turma update(@PathVariable(value = "id") Integer id, @RequestBody Turma turma) {
//	    	return turmaService.saveTurma(turma);
//	    }
	  
	  @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteTurma(@PathVariable Integer id){
		  Turma turma = turmaService.findTurmaById(id);
			if(null == turma)
				throw new NoSuchElementFoundException("Não tem como deletar algo que não existe. Tente outro id");
			else
		  
		  
		  turmaService.deleteTurma(id);
		  
	      return new ResponseEntity<>("", HttpStatus.OK);
	    }
	  
	  
//		  if(null == id)
//				throw new NoSuchElementFoundException("Não se pode deletar algo que não existe. Tente outro código" );
//			else
//				return new ResponseEntity<>("", HttpStatus.OK);
}

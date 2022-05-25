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
import com.residencia.academia.entity.Atividade;
import com.residencia.academia.exception.NoSuchElementFoundException;
import com.residencia.academia.service.AtividadeService;


@RestController
@RequestMapping("/atividade")
public class AtividadeController {
	
	@Autowired
	private AtividadeService atividadeService;

	
	@GetMapping
	public ResponseEntity<List<Atividade>> findAll(){
		List<Atividade> atividadeList =atividadeService.findAll();

		return new ResponseEntity<>(atividadeList, HttpStatus.OK);
		}
	
	@GetMapping("/{id}")
	public ResponseEntity<Atividade> findAtividadeId(@PathVariable Integer id) {
		Atividade atividade = atividadeService.findAtividadeById(id);
		if(null == atividade)
			throw new NoSuchElementFoundException("Essa atividade não existe! Tente outra.");
		else
			return new ResponseEntity<>(atividadeService.findAtividadeById(id), HttpStatus.OK);
	}
	
	
	@PostMapping
    public ResponseEntity <Atividade> saveAtividade(@RequestBody Atividade atividade){
	 Atividade novaAtividade = atividadeService.saveAtividade(atividade);
        return new ResponseEntity<>(novaAtividade, HttpStatus.CREATED);
    }
	
//	 @PutMapping
//	 public ResponseEntity<Atividade> updateAtividade (@RequestBody Atividade atividade){
//	    Atividade novaAtividade = atividadeService.updateAtividade(atividade);
//	    return new ResponseEntity<>(atividade, HttpStatus.OK);
//	  }
	
	 @PutMapping("/{id}")
	    public Atividade updateAtividade(@PathVariable (value = "id") Integer autorId , @RequestBody Atividade atividade) {
	        return atividadeService.updateAtividade(atividade, autorId);
	    }
	 
	 @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteAtividade(@PathVariable Integer id){
		  Atividade atividade = atividadeService.findAtividadeById(id);
			if(null == atividade)
				throw new NoSuchElementFoundException("Não tem como deletar algo que não existe. Tente outro id");
			else
		  atividadeService.deleteAtividade(id);
		  
	      return new ResponseEntity<>("", HttpStatus.OK);
	    }

}

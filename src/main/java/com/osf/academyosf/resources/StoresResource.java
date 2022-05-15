package com.osf.academyosf.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osf.academyosf.entities.Stores;
import com.osf.academyosf.repositories.StoresRepository;

@RestController
@RequestMapping(value = "/api")
public class StoresResource {

	@Autowired
	private StoresRepository stores_repository;

	@GetMapping("/stores") 
	public List<Stores> lista_stores() {
		return stores_repository.findAll();
	}

	@GetMapping("/stores/{id}") 
	public Stores lista_stores_one(@PathVariable(value = "id") int id) {
		return stores_repository.findById(id);
	}

	@PostMapping("/stores")
	public Stores salve_stores(@RequestBody Stores stores) {
		return stores_repository.save(stores);
	}

	@DeleteMapping("/stores") 
	public void delete_stores(@RequestBody Stores stores) {
		stores_repository.delete(stores);
	}

	@DeleteMapping("/stores/{id}")
	public Stores delete_stores_one(@PathVariable(value = "id") int id ){
		return stores_repository.deleteById(id);
	}

	@PutMapping("/stores") 
	public Stores update_stores(@RequestBody Stores stores) {
		return stores_repository.save(stores);
	}
}

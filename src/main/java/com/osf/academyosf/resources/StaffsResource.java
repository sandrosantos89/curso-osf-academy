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

import com.osf.academyosf.entities.Staffs;
import com.osf.academyosf.repositories.StaffsRepository;

@RestController
@RequestMapping(value = "/api")
public class StaffsResource {

	@Autowired
	StaffsRepository staffs_repository;

	@GetMapping("/staffs") 
	public List<Staffs> lista_staffs() {
		return staffs_repository.findAll();
	}

	@GetMapping("/staffs/{id}") 
	public Staffs lista_staffs_one(@PathVariable(value = "id") int id) {
		return staffs_repository.findById(id);
	}

	@PostMapping("/staffs")
	public Staffs salve_staffs(@RequestBody Staffs staffs) {
		return staffs_repository.save(staffs);
	}

	@DeleteMapping("/staffs") 
	public void delete_staffs(@RequestBody Staffs staffs) {
		staffs_repository.delete(staffs);
	}

	@DeleteMapping("/staffs/{id}")
	public Staffs delete_staffs_one(@PathVariable(value = "id") int id ){
		return staffs_repository.deleteById(id);
	}

	@PutMapping("/staffs") 
	public Staffs update_staffs(@RequestBody Staffs staffs) {
		return staffs_repository.save(staffs);
	}
}

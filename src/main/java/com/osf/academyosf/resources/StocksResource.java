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

import com.osf.academyosf.entities.Stocks;
import com.osf.academyosf.repositories.StocksRepository;

@RestController
@RequestMapping(value = "/api")
public class StocksResource {

	@Autowired
	StocksRepository stocks_repository;

	@GetMapping("/stocks") 
	public List<Stocks> lista_stocks() {
		return stocks_repository.findAll();
	}

	@GetMapping("/stocks/{id}") 
	public Stocks lista_stocks_one(@PathVariable(value = "id") int id) {
		return stocks_repository.findById(id);
	}

	@PostMapping("/stocks")
	public Stocks salve_stocks(@RequestBody Stocks stocks) {
		return stocks_repository.save(stocks);
	}

	@DeleteMapping("/stocks") 
	public void delete_stocks(@RequestBody Stocks stocks) {
		stocks_repository.delete(stocks);
	}

	@DeleteMapping("/stocks/{id}")
	public Stocks delete_stocks_one(@PathVariable(value = "id") int id ){
		return stocks_repository.deleteById(id);
	}

	@PutMapping("/stocks") 
	public Stocks update_stocks(@RequestBody Stocks stocks) {
		return stocks_repository.save(stocks);
	}
}

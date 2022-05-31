package com.osf.academyosf.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.osf.academyosf.entities.Stocks;

public interface StocksRepository extends JpaRepository<Stocks, Integer> {

	Stocks findById(int id);
	Stocks deleteById(int id);
	Page<Stocks> findAll(Pageable var1);
	
}
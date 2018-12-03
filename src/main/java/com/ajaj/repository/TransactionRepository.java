package com.ajaj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ajaj.model.Transaction;;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

	@Query("select f from Transaction f")
	List<Transaction> findAlls();
}

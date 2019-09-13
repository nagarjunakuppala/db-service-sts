package org.uhcl.edu.stock.dbservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uhcl.edu.stock.dbservice.model.Quote;

public interface QuotesRepository extends JpaRepository<Quote, Integer>{

	public List<Quote> findByUserName(String username);
}

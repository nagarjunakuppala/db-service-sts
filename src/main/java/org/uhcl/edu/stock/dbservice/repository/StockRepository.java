package org.uhcl.edu.stock.dbservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uhcl.edu.stock.dbservice.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer>{

	public List<Stock> findByUserName(String username);
}

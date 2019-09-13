package org.uhcl.edu.stock.dbservice.resource;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uhcl.edu.stock.dbservice.model.Quote;
import org.uhcl.edu.stock.dbservice.model.Quotes;
import org.uhcl.edu.stock.dbservice.model.Stock;
import org.uhcl.edu.stock.dbservice.model.Stocks;
import org.uhcl.edu.stock.dbservice.repository.QuotesRepository;
import org.uhcl.edu.stock.dbservice.repository.StockRepository;

@RestController
@RequestMapping("/rest/db")
//@CrossOrigin(origins="http://10.0.0.96:4200")
public class DBServiceResource {

	@Autowired
	private QuotesRepository quotesRepository;
	
	@Autowired
	private StockRepository stockRepository;
	
	/*public DBServiceResource() {
		System.out.println("default method");
	}*/
	public DBServiceResource(QuotesRepository quotesRepository, StockRepository stockRepository) {
		System.out.println("default method");
		this.quotesRepository = quotesRepository;
		this.stockRepository = stockRepository;
	}

	@GetMapping("/{userName}")
	public List<String> getQuotes(@PathVariable("userName") final String userName){
		
		return getQuotesByUserName(userName);
	}
	
	@PostMapping("/create")
	public List<String> create(@RequestBody final Quotes quotes){
		quotes.getQuotes().stream().forEach(quote -> {
			quotesRepository.save(new Quote(quotes.getUserName(), quote.toUpperCase()));
		});
		return getQuotesByUserName(quotes.getUserName());
	}
	
	@PostMapping("/delete/{userName}")
	public List<String> delete(@PathVariable("userName") final String userName) {

		List<Quote> list = quotesRepository.findByUserName(userName);
		quotesRepository.delete(list);
		return getQuotesByUserName(userName);
	}
	
	private List<String> getQuotesByUserName(String userName){
		return quotesRepository.findByUserName(userName).stream().map(Quote :: getQuote).collect(Collectors.toList());
		
	}
	
	@GetMapping("/stock/{userName}")
	public List<Stock> getStocks(@PathVariable("userName") final String userName){
		
		return getStocksByUserName(userName);
	}
	
	@PostMapping("/stock/store")
	public List<Stock> storeStocks(@RequestBody final Stocks stocks) {
		stocks.getStocks().stream().forEach(stock -> {
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
			stock.setStockDate(date);
			stock.setUserName(stocks.getUserName());
			stockRepository.save(stock);
		});
		return getStocksByUserName(stocks.getUserName());
	}
	
	private List<Stock> getStocksByUserName(String userName){
		List<Stock> stocks = stockRepository.findByUserName(userName);
		return stocks;
		
	}

}

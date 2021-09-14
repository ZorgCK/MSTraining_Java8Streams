package one.microstream.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import one.microstream.domain.Author;
import one.microstream.domain.Book;


@Controller("/streams")
public class StreamsController
{
	@Get("/intstream")
	public HttpResponse<?> createIntStream()
	{
		
		return HttpResponse.ok();
	}
	
	@Get("/arraystream")
	public HttpResponse<?> createArrayStream()
	{
		
		return HttpResponse.ok();
	}
	
	@Get("/objectstream")
	public HttpResponse<?> createObjectStream()
	{
		
		return HttpResponse.ok();
	}
	
	@Get("/arraycollector")
	public Book[] createArrayCollector()
	{
		
	}
	
	@Get("/listcollector")
	public List<Book> createListCollector()
	{
		
	}
	
	@Get("/setcollector")
	public Set<Book> createSetCollector()
	{
		
	}
	
	@Get("/stringcollector")
	public String createStringCollector()
	{
		
	}
	
	@Get("/findany")
	public Book findAny()
	{
		
	}
	
	@Get("/findfirst")
	public Book findFirst()
	{
		
	}
	
	@Get("/bookspricesum")
	public BigDecimal booksPriceSum()
	{
		
	}
	
	@Get("/bookspricesum")
	public Map<Author, BigDecimal> booksPriceSum()
	{
		
	}
}

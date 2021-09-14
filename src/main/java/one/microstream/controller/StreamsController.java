package one.microstream.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import one.microstream.domain.Author;
import one.microstream.domain.Book;
import one.microstream.storage.DB;


@Controller("/streams")
public class StreamsController
{
	@Get("/intstream")
	public HttpResponse<?> createIntStream()
	{
		IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).forEach(i -> System.out.println(i));
		IntStream.range(5, 10).forEach(i -> System.out.println(i));
		
		return HttpResponse.ok();
	}
	
	@Get("/arraystream")
	public HttpResponse<?> createArrayStream()
	{
		Integer[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		Stream.of(nums).forEach(i -> System.out.println(i));
		Arrays.stream(nums).forEach(System.out::println);
		
		return HttpResponse.ok();
	}
	
	@Get("/objectstream")
	public HttpResponse<?> createObjectStream()
	{
		DB.root.getBooks().forEach(b -> System.out.println(b.getName()));
		
		return HttpResponse.ok();
	}
	
	@Get("/arraycollector")
	public Book[] createArrayCollector()
	{
		return DB.root.getBooks().stream().toArray(Book[]::new);
	}
	
	@Get("/listcollector")
	public List<Book> createListCollector()
	{
		return DB.root.getBooks().stream().collect(Collectors.toList());
	}
	
	@Get("/setcollector")
	public Set<Book> createSetCollector()
	{
		return DB.root.getBooks().stream().collect(Collectors.toSet());
	}
	
	@Get("/stringcollector")
	public String createStringCollector()
	{
		List<String> petList = Arrays.asList("Cat", "Dog", "Mouse", "Bird");
		return petList.stream().collect(Collectors.joining(","));
	}
	
	@Get("/findany")
	public Book findAny()
	{
		return DB.root.getBooks().stream().findAny().get();
	}
	
	@Get("/findfirst")
	public Book findFirst()
	{
		return DB.root.getBooks().stream().findFirst().get();
	}
	
	@Get("/bookspricesum")
	public BigDecimal booksPriceSum()
	{
		BigDecimal collect =
			DB.root.getBooks().stream().collect(Collectors.reducing(BigDecimal.ZERO, Book::getPrice, BigDecimal::add));
		
		return collect;
	}
	
	@Get("/booksgrouppricesum")
	public Map<Author, BigDecimal> booksGroupPriceSum()
	{
		Map<Author, BigDecimal> collect = DB.root.getBooks().stream().collect(
			Collectors.groupingBy(
				Book::getAuthor,
				Collectors.reducing(BigDecimal.ZERO, Book::getPrice, BigDecimal::add)));
		
		return collect;
	}
}

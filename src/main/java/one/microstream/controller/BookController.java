package one.microstream.controller;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import one.microstream.domain.Address;
import one.microstream.domain.Author;
import one.microstream.domain.Book;
import one.microstream.storage.DB;
import one.microstream.utils.MockupUtils;


@Controller("/books")
public class BookController
{
	@Get("/create")
	public HttpResponse<?> createBooks()
	{
		List<Book> allCreatedBooks = MockupUtils.loadMockupData();
		
		DB.root.getBooks().addAll(allCreatedBooks);
		DB.storageManager.store(DB.root.getBooks());
		
		return HttpResponse.ok("Books successfully created!");
	}
	
	@Get
	public List<Book> getBook()
	{
		// return DB.root.getBooks().stream().sorted(Comparator.comparing(Book::getName)).collect(Collectors.toList());
		return DB.root.getBooks().stream().sorted((b1, b2) -> b2.getPrice().compareTo(b1.getPrice())).collect(
			Collectors.toList());
	}
	
	@Get("/byTitlePredicate")
	public List<Book> getBooksbyTitlePredicate()
	{
		Predicate<Book> namePredicate = b -> b.getName().equals("Bangkok Dangerous");
		Predicate<Book> isbnPredicate = b -> b.getIsbn().equals("12345");
		Predicate<Book> nameAndISBNPredicate = namePredicate.and(isbnPredicate);
		
		return DB.root.getBooks().stream().filter(nameAndISBNPredicate).collect(
			Collectors.toList());
	}
	
	@Get("/byTitle")
	public List<Book> getBooksbyTitle()
	{
		return DB.root.getBooks().stream().filter(b -> b.getName().equals("Bangkok Dangerous")).collect(
			Collectors.toList());
	}
	
	@Get("/startsWith_A")
	public List<Book> getBooksWithA()
	{
		return DB.root.getBooks().stream().filter(b -> b.getName().startsWith("A")).collect(Collectors.toList());
	}
	
	@Get("/clear")
	public HttpResponse<?> clearBooks()
	{
		DB.root.getBooks().clear();
		DB.storageManager.store(DB.root.getBooks());
		
		return HttpResponse.ok("Books successfully cleared!");
	}
	
	@Get("/authorList")
	public List<Author> getAllAuthors()
	{
		List<Author> collect = DB.root.getBooks().stream().map(c -> c.getAuthor()).collect(Collectors.toList());
		
		return collect;
	}
	
	@Get("/addressList")
	public List<Address> getAllAddresses()
	{
		List<Address> addresses =
			getAllAuthors().stream().flatMap(a -> a.getAddresses().stream()).collect(Collectors.toList());
		
		return addresses;
	}
}

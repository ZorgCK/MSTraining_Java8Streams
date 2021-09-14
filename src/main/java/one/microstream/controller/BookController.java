package one.microstream.controller;

import java.util.List;

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
		return DB.root.getBooks();
	}
	
	@Get("/byTitlePredicate")
	public List<Book> getBooksbyTitlePredicate()
	{
		
	}
	
	@Get("/byTitle")
	public List<Book> getBooksbyTitle()
	{
		
	}
	
	@Get("/startsWith_A")
	public List<Book> getBooksWithA()
	{
		
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
		
	}
	
	@Get("/addressList")
	public List<Address> getAllAddresses()
	{
		
	}
}

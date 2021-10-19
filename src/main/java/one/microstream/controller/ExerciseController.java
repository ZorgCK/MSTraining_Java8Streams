package one.microstream.controller;

import java.util.List;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import one.microstream.domain.Author;
import one.microstream.domain.Book;


@Controller("/exercise")
public class ExerciseController
{
	@Get("/booksfromfemaleauthor")
	public List<Book> getBooksFromFemaleAuthor()
	{
		
	}
	
	@Get("/authorsfrompoland")
	public List<Author> getAuthorsFromPoland()
	{
		
	}
	
	@Get("/booksreleasedbefore2012")
	public List<Book> getBooksBefore2012()
	{
		
	}
}

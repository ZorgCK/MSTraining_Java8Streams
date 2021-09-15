package one.microstream.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import one.microstream.domain.Address;
import one.microstream.domain.Author;
import one.microstream.domain.Book;
import one.microstream.storage.DB;


@Controller("/exercise")
public class ExerciseController
{
	@Get("/booksfromfemaleauthor")
	public List<Book> getBooksFromFemaleAuthor()
	{
		List<Book> collect =
			DB.root.getBooks().stream().filter(b -> b.getAuthor().getGender().equalsIgnoreCase("female")).collect(
				Collectors.toList());
		return collect;
	}
	
	@Get("/authorsfrompoland")
	public List<Author> getAuthorsFromPoland()
	{
		// return DB.root.getBooks().stream()
		// .map(Book::getAuthor)
		// .filter(author -> author.getAddresses().stream()
		// .anyMatch(address -> address.getCountry().equals("Poland")))
		// .collect(Collectors.toList());
		
		Predicate<Address> polandPredicate = a -> a.getCountry().equalsIgnoreCase("Poland");
		
		List<Author> collect = DB.root.getBooks().stream().map(b -> b.getAuthor()).filter(
			a -> a.getAddresses().stream().anyMatch(polandPredicate)).collect(Collectors.toList());
		
		return collect;
	}
	
	@Get("/booksreleasedbefore2012")
	public List<Book> getBooksBefore2012()
	{
		List<Book> collect =
			DB.root.getBooks().stream().filter(book -> book.getRelease().isBefore(LocalDate.of(2012, 1, 1))).collect(
				Collectors.toList());
		
		DB.root.getBooks().stream().filter(b -> b.getRelease().getYear() < 2012).collect(Collectors.toList());
		
		return collect;
	}
}

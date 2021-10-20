package one.microstream.controller;

import java.time.LocalDate;
import java.time.Month;
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
		// @formatter:off
		return DB.root.getBooks().stream()
			.filter(b -> b.getAuthor().getGender().equalsIgnoreCase("F")).collect(
			Collectors.toList());
	}
	
	@Get("/authorsfrompoland")
	public List<Author> getAuthorsFromPoland()
	{
		Predicate<Address> polandPredicate = a -> a.getCountry().equalsIgnoreCase("Poland");
		
		List<Author> collect = DB.root.getBooks().stream().map(b -> b.getAuthor())
			.filter(au -> au.getAddresses().stream()
				.anyMatch(polandPredicate))
			.collect(Collectors.toList());
		
		return collect;
	}
	
	@Get("/booksreleasedbefore2012")
	public List<Book> getBooksBefore2012()
	{
		LocalDate startDate = LocalDate.of(2012, Month.JANUARY, 1);
		
        return DB.root.getBooks().stream()
        	.filter(b -> b.getRelease().isBefore(startDate)).collect(Collectors.toList());
	}
}

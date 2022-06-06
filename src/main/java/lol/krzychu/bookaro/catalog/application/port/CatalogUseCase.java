package lol.krzychu.bookaro.catalog.application.port;

import lol.krzychu.bookaro.catalog.domain.Book;
import lombok.Value;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public interface CatalogUseCase {
    public List<Book> findByTitle(String title);
    public List<String> findByAuthor(String providedAuthor);
    List<Book> findAll();
    public Optional<Book> findOneByTitleAndAuthor(String title, String author);
    public void addBook(CreateBookCommand command);
    UpdateBookResponse updateBook(UpdateBookCommand command);
    public void removeById(long id);

    @Value
    class CreateBookCommand     //this also looks like complicating the code
    {
        String title;
        String author;
        Integer year;
    }
    @Value
    class UpdateBookCommand     //this also looks like complicating the code
    {
        Long id;
        String title;
        String author;
        Integer year;
    }
    @Value
    class UpdateBookResponse    //this is getting very strange
    {
        public static UpdateBookResponse SUCCESS = new UpdateBookResponse(true, Collections.emptyList());
        boolean success;
        List<String> errors;
    }
}

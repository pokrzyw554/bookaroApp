package lol.krzychu.bookaro.catalog.application.port;

import lol.krzychu.bookaro.catalog.domain.Book;

import java.util.List;
import java.util.Optional;

public interface CatalogUseCase {
    public List<Book> findByTitle(String title);
    public List<String> findByAuthor(String providedAuthor);
    List<Book> findAll();
    public Optional<Book> findOneByTitleAndAuthor(String title, String author);
    public void addBook();
    public void removeById(long id);
}

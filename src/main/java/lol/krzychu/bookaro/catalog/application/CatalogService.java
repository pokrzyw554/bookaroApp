package lol.krzychu.bookaro.catalog.application;

//import lol.krzychu.bookaro.catalog.infrastructure.BestsellerRepository;
import lol.krzychu.bookaro.catalog.application.port.CatalogUseCase;
import lol.krzychu.bookaro.catalog.domain.Book;
import lol.krzychu.bookaro.catalog.domain.CatalogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CatalogService implements CatalogUseCase {


    private final CatalogRepository repository;

//    public CatalogService(CatalogRepository repository)
//    {
//        this.repository = repository;
//    }


    public List<Book> findByTitle(String title)
    {
        return repository.findAll()
                .stream()
                .filter(book -> book.getTitle().startsWith(title))
                .collect(Collectors.toList());
    }

    public List<String> findByAuthor(String providedAuthor) {
        List<Book> all = repository.findAll()
                .stream().filter(book -> book.getAuthor().startsWith(providedAuthor))
                .collect(Collectors.toList());
        List<String> result = new LinkedList<>();
        for (Book a:all)
        {
            result.add(a.getAuthor());
        }
        return result;
    }
    public List<Book> findAll()
    {
        return repository.findAll();
    }
    public Optional<Book> findOneByTitleAndAuthor(String title, String author)
    {
        return repository.findAll()
                .stream()
                .filter(book -> book.getTitle().startsWith(title))
                .filter(book -> book.getAuthor().startsWith(author))
                .findFirst();
       // return Optional.empty();
    }

    public void addBook(CreateBookCommand command)
    {
        Book book = new Book(command.getTitle(), command.getAuthor(), command.getYear());
        repository.save(book);
    }

    @Override
    public UpdateBookResponse updateBook(UpdateBookCommand command) {
        return repository.findById(command.getId())
                .map(book -> {
                    book.setTitle(command.getTitle());
                    book.setAuthor(command.getAuthor());
                    book.setYear(command.getYear());
                    repository.save(book);
                    return UpdateBookResponse.SUCCESS;
                })
                .orElseGet(() -> new UpdateBookResponse(false, Arrays.asList("Book not found with id: "+command.getId())));
    }

    public void removeById(long id)
    {

    }
}

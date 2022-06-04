package lol.krzychu.bookaro.catalog.application;

//import lol.krzychu.bookaro.catalog.infrastructure.BestsellerRepository;
import lol.krzychu.bookaro.catalog.application.port.CatalogUseCase;
import lol.krzychu.bookaro.catalog.domain.Book;
import lol.krzychu.bookaro.catalog.domain.CatalogRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
//@AllArgsConstructor
public class CatalogService implements CatalogUseCase {


    private final CatalogRepository repository;

    public CatalogService(CatalogRepository repository)
    {
        this.repository = repository;
    }


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
        return null;
    }
    public Optional<Book> findOneByTitleAndAuthor(String title, String author)
    {
        return Optional.empty();
    }
    public void addBook()
    {

    }
    public void removeById(long id)
    {

    }
}

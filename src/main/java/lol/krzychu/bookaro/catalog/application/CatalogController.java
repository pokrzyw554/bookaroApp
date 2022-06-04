package lol.krzychu.bookaro.catalog.application;

import lol.krzychu.bookaro.catalog.domain.Book;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class CatalogController {
    private final CatalogService service;

    public List<Book> findByTitle(String title)
    {
        return service.findByTitle(title);
    }
    public List<String> findByAuthor(String author)
    {
        return service.findByAuthor(author);
    }
}

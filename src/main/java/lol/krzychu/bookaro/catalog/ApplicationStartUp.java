package lol.krzychu.bookaro.catalog;

import lol.krzychu.bookaro.catalog.application.CatalogController;
import lol.krzychu.bookaro.catalog.application.port.CatalogUseCase;
import lol.krzychu.bookaro.catalog.domain.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApplicationStartUp implements CommandLineRunner {

    private final CatalogUseCase catalog;
    private final String title = "pan";
    private final String author = "Henryk";

    public ApplicationStartUp(CatalogUseCase catalogService) {
        this.catalog = catalogService;
    }

    @Override
    public void run(String... args) throws Exception {
        //CatalogService service = new CatalogService();
        List<Book> books = catalog.findByTitle(title);
        books.forEach(System.out::println);
        System.out.println("a teraz moja część!");
        List<String> authors = catalog.findByAuthor(author);
        authors.forEach(System.out::println);
    }
}

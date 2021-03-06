package lol.krzychu.bookaro.catalog;

import lol.krzychu.bookaro.catalog.application.CatalogController;
import lol.krzychu.bookaro.catalog.application.port.CatalogUseCase;
import lol.krzychu.bookaro.catalog.application.port.CatalogUseCase.UpdateBookResponse;
import lol.krzychu.bookaro.catalog.domain.Book;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import lol.krzychu.bookaro.catalog.application.port.CatalogUseCase.CreateBookCommand;

import java.util.List;

@Component
public class ApplicationStartUp implements CommandLineRunner {

    private final CatalogUseCase catalog;
    @Value("${bookaro.catalog.query}") String title;
    private final String author = "Adam";

    public ApplicationStartUp(CatalogUseCase catalogService) {
        this.catalog = catalogService;
    }

    @Override
    public void run(String... args) throws Exception {
        //CatalogService service = new CatalogService();
        initData();
        findByTitle();
        System.out.println("a teraz moja część!");
        findAndUpdate();
        findByTitle();
        CreateBookCommand command = new CreateBookCommand("Pan Nowak", "autor nieznany", 2023);
        System.out.println("dodawanie książki");
        catalog.addBook(command);
        findByTitle();
    }

    private void findAndUpdate() {
        catalog.findOneByTitleAndAuthor("Pan Tadeusz", "Adam Mickiewicz")
                .ifPresent(book -> {
                    CatalogUseCase.UpdateBookCommand command = CatalogUseCase.UpdateBookCommand.builder()
                            .id(book.getId())
                            .title("Pan Tadeusz, czyli ostatni zajazd na Litwie")
                            .build();
                    UpdateBookResponse result = catalog.updateBook(command);
                    System.out.println("updating book result "+ result.isSuccess());
                });
    }

    private void initData() {
        catalog.addBook(new CreateBookCommand("harry poter", "JK ROwling", 1998));
        catalog.addBook(new CreateBookCommand("czysty kod", "wuja bob", 2011));
        catalog.addBook(new CreateBookCommand("władca pierscienia: dwie wierze", "Tolkien", 2002));
        catalog.addBook(new CreateBookCommand("hakowanie IoT w praktyce", "Fotios Chantzis", 2021));
        catalog.addBook(new CreateBookCommand("Pan Tadeusz", "Adam Mickiewicz", 1954));
        catalog.addBook(new CreateBookCommand("Pan wolodyjowski", "ktos tam", 1977));
        catalog.addBook(new CreateBookCommand("Chłopi", "Henryk Sienkiewicz", 1977));
    }

    private void findByTitle() {
        List<Book> books = catalog.findByTitle(title);
        books.forEach(System.out::println);
    }

    private void findByAuthor() {
        List<String> authors = catalog.findByAuthor(author);
        authors.forEach(System.out::println);
    }
}

package lol.krzychu.bookaro.catalog.infrastructure;

import lol.krzychu.bookaro.catalog.domain.Book;
import lol.krzychu.bookaro.catalog.domain.CatalogRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SchoolCatalogRepository implements CatalogRepository {

    private final Map<Long, Book> storage = new ConcurrentHashMap<>();


    public SchoolCatalogRepository() {
        storage.put(1L, new Book(1L, "pan tadeusz", "adam mickiewicz", 1834));
        storage.put(2L, new Book(2L, "ogniem i mieczem", "Henryk Sienkiewicz", 1884));
        storage.put(3L, new Book(3L, "Chłopi", "Władysław reymont", 1904));
        storage.put(4L, new Book(4L, "tango", "Sławomir Mrożek", 1964));

    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(storage.values());
    }
}

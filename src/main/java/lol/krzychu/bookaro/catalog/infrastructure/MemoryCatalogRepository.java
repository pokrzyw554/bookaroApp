package lol.krzychu.bookaro.catalog.infrastructure;

import lol.krzychu.bookaro.catalog.domain.Book;
import lol.krzychu.bookaro.catalog.domain.CatalogRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MemoryCatalogRepository implements CatalogRepository {
    private final Map<Long, Book> storage = new ConcurrentHashMap<>();
    private final AtomicLong ID_NEXT_VALUE = new AtomicLong(0L);


    public MemoryCatalogRepository() {
        storage.put(1L, new Book(1L, "harry poter", "JK ROwling", 1998));
        storage.put(2L, new Book(2L, "czysty kod", "wuja bob", 2011));
        storage.put(3L, new Book(3L, "władca pierscienia: dwie wierze", "Tolkien", 2002));
        storage.put(4L, new Book(4L, "hakowanie IoT w praktyce", "Fotios Chantzis", 2021));

    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void save(Book book) {
        if (book.getId() != null) {
            storage.put(book.getId(), book);
        } else {
            long nextId = nextId();
        book.setId(nextId);         //ten fragmeny wydaję mi się komplikowaniem sprawy
        storage.put(nextId, book);
    }
    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    private long nextId() {
        return ID_NEXT_VALUE.getAndIncrement();
    }
}

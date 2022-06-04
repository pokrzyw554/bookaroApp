package lol.krzychu.bookaro.catalog.domain;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Book {
    private final Long id;
    private final String title;
    private final String author;
    private final Integer year;

}

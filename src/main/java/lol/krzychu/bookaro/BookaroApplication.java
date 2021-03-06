package lol.krzychu.bookaro;

import lol.krzychu.bookaro.catalog.domain.CatalogRepository;
import lol.krzychu.bookaro.catalog.infrastructure.MemoryCatalogRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookaroApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookaroApplication.class, args);
	}

/*	@Bean
	CatalogRepository catalogRepository()
	{
		return new MemoryCatalogRepository();
	}*/

	@Bean
	String query()
	{
		return "Pan";
	}

}

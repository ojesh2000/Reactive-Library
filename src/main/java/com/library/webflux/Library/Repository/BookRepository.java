package com.library.webflux.Library.Repository;

import com.library.webflux.Library.Model.Book;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface BookRepository extends ReactiveMongoRepository<Book, String> {
    Flux<Book> findByGenre(String genre);

    Flux<Book> findByAuthorId(int id);

    Flux<Book> findByGenreAndCopiesAvailableGreaterThan(String genre , int copiesAvailable);
}

package com.library.webflux.Library.Repository;

import com.library.webflux.Library.Model.Author;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface AuthorRepository extends ReactiveMongoRepository<Author, String> {
    Flux<Author> findByName(String name);

    @Query("{name: {$regex: /?0/ , $options:\"i\"}}")
    Flux<Author> getAuthorsLike(String authorName);

}

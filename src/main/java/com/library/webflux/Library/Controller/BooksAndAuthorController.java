package com.library.webflux.Library.Controller;

import com.library.webflux.Library.Model.Author;
import com.library.webflux.Library.Model.Book;
import com.library.webflux.Library.Service.BooksAndAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class BooksAndAuthorController {

    @Autowired
    BooksAndAuthorService service;
    @GetMapping("/")
    public Mono<String> getRoot(){
        return Mono.just("Hello World");
    }

    @GetMapping("/getAllBooks")
    public Flux<Book> getAllBooks(){
        return service.getAllBooks();
    }

    @GetMapping("/getBooksByGenre")
    public Flux<Book> getBooksByGenre(@RequestParam String genre){
        return service.getBooksByGenre(genre);
    }

    @GetMapping("/getBooksByGenreAndCopiesAvailable")
    public Flux<Book> getBooksByGenreAndCopiesAvailable(@RequestParam String genre , @RequestParam int copiesAvailable){
        return service.getBooksByGenreAndCopiesAvailable(genre , copiesAvailable);
    }

    @PostMapping("/saveBook")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Book> saveBook(@RequestBody Book book){
        return service.saveBook(book);
    }

    @PostMapping("/saveAuthor")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Author> saveAuthor(@RequestBody Author author){
        return service.saveAuthor(author);
    }

    @GetMapping("/getBooksFromAuthor")
    public Flux<Book> getBooksFromAuthor(@RequestParam String authorName){
        return service.getBooksFromAuthor(authorName);
    }

    @GetMapping("/getAuthorsLike")
    public Flux<Author> getAuthorsLike(@RequestParam String authorName){
        return service.getAuthorsLike(authorName);
    }
}

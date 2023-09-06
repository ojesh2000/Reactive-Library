package com.library.webflux.Library.Service;

import com.library.webflux.Library.Model.Author;
import com.library.webflux.Library.Model.Book;
import com.library.webflux.Library.Repository.AuthorRepository;
import com.library.webflux.Library.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class BooksAndAuthorService {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;

    public Flux<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Flux<Book> getBooksByGenre(String genre) {
        return bookRepository.findByGenre(genre);
    }

    public Flux<Book> getBooksByGenreAndCopiesAvailable(String genre, int copiesAvailable) {
        return bookRepository.findByGenreAndCopiesAvailableGreaterThan(genre , copiesAvailable);
    }

    public Mono<Book> saveBook(Book book) {
//        System.out.println(book);
        return bookRepository.save(book);
    }

    public Mono<Author> saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Flux<Book> getBooksFromAuthor(String authorName) {
        return authorRepository
                .findByName(authorName)
                .flatMap(author -> bookRepository.findByAuthorId(Integer.parseInt(author.getId())));
    }

    public Flux<Author> getAuthorsLike(String authorName) {
        return authorRepository.getAuthorsLike(authorName);
    }
}

package com.library.webflux.Library.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("Books")
public class Book {
    @Id private String id;

    @Field("authorId") private int authorId;


    @Field("genre") private String genre;


    @Field("CopiesAvailable")private int copiesAvailable;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public void setCopiesAvailable(int copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
    }

    @Override
    public String toString(){
        return "ID: " + id + " AuthorID: " + authorId + " Genre: " + genre + " CopiesAvailable: " + copiesAvailable;
    }
}

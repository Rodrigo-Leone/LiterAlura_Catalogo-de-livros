package br.com.alura.literalura.model;


import br.com.alura.literalura.dto.AuthorDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "Autores")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String author;
    private Integer yearBirth;
    private Integer yearDeath;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Book> books = new ArrayList<>();

    public Author(){}

    public Author(AuthorDTO authorDTO) {
        this.author = authorDTO.author();
        this.yearBirth =authorDTO.yearBirth();
        try {
            this.yearDeath = authorDTO.yearDeath();
        } catch (Exception e) {
            this.yearDeath = null;
        }
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getYearBirth() {
        return yearBirth;
    }
    public void setYearBirth(Integer yearBirth) {
        this.yearBirth = yearBirth;
    }

    public Integer getYearDeath() {
        return yearDeath;
    }
    public void setYearDeath(Integer yearDeath) {
        this.yearDeath = yearDeath;
    }

    public List<Book> getBooks() {
        return books;
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        String booksStr = books.stream()
                .map(Book::getTitle)
                .collect(Collectors.joining(", "));

        return  "\n-------------------------------------------------" + '\n' +
                "Nome: " + author + '\n' +
                "Ano de nascimento: " + yearBirth + '\n' +
                "Ano de falecimento: " + yearDeath + "\n" +
                "Livros: " + booksStr + '\n' +
                "-------------------------------------------------";
    }
}

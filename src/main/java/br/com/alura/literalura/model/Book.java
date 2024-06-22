package br.com.alura.literalura.model;

import br.com.alura.literalura.dto.BookDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "Livros")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String title;
    private String language;
    private Double totalDownloads;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Author author;

    public Book() {}

    public Book(BookDTO bookDTO) {
        this.id = bookDTO.id();
        this.title = bookDTO.title();
        this.language = bookDTO.language().get(0);
        this.totalDownloads = bookDTO.numberDownload();
        this.author = new Author(bookDTO.authors().get(0));
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }

    public Double getTotalDownloads() {
        return totalDownloads;
    }
    public void setTotalDownloads(Double totalDownloads) {
        this.totalDownloads = totalDownloads;
    }

    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return  "\n-------------------------------------------------" + '\n' +
                "ID: " + id + '\n' +
                "Titulo: '" + title + '\'' + '\n' +
                "Idioma: " + language + '\n' +
                "Total de Downloads: " + totalDownloads + '\n' +
                "Autor: " + author + '\n' +
                "-------------------------------------------------";
    }
}

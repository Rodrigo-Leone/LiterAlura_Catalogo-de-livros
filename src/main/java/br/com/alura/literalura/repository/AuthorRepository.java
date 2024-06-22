package br.com.alura.literalura.repository;

import br.com.alura.literalura.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository  extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Book b JOIN b.author a WHERE a.author = :author")
    Author searchAuthorByName(String author);
    @Query("SELECT a FROM Book b JOIN b.author a WHERE a.yearBirth <= :year and a.yearDeath >= :year")
    List<Author> searchAuthorsByYear(Integer year);

    @Query("SELECT a FROM Author a WHERE a.author ILIKE %:nameAuthor%")
    List<Author> searchByAuthorName(String nameAuthor);
}

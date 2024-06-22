package br.com.alura.literalura.repository;

import br.com.alura.literalura.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE b.language ILIKE :languageChoice")
    List<Book> findByLanguage(String languageChoice);
}

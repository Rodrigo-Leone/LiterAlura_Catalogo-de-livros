package br.com.alura.literalura.main;

import br.com.alura.literalura.repository.AuthorRepository;
import br.com.alura.literalura.repository.BookRepository;
import br.com.alura.literalura.service.ConvertData;
import br.com.alura.literalura.service.QuerieAPI;

import java.util.Scanner;

public class Main {

    private Scanner read = new Scanner(System.in);
    private QuerieAPI querieAPI = new QuerieAPI();
    private ConvertData convertData = new ConvertData();

    public BookRepository bookRepository;
    public AuthorRepository authorRepository;

    private String url = "http://gutendex.com/books/?search=";

    public Main (BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public void displaysMenu() {
        var option = -1;

        while (option != 0) {
            var menu = """
                    --------------------------------------------------
                    1 - Buscar livros pelo título
                    2 - Listar livros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos por determinado ano
                    5 - Listar livros em um determinado idioma
                    \n
                    0 - Sair
                    --------------------------------------------------
                    """;
        }
    }
}

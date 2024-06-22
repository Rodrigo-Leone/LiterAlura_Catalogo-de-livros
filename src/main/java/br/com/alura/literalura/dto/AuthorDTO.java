package br.com.alura.literalura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AuthorDTO(@JsonAlias("name") String author,
                        @JsonAlias("birth_year") Integer yearBirth,
                        @JsonAlias("death_year") Integer yearDeath) {
}

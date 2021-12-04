package ru.niatomi.hibernate.model.persistence;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "article_table")
@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Article {

    @EqualsAndHashCode.Include
    private Long id;

    private String name;

    private Author author;

    private Reader reader;


}

package ru.niatomi.hibernate.model.persistence;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = Article.ARTICLE_TABLE_NAME)
@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Article {

    public static final String ARTICLE_TABLE_NAME = "articles_tables";


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "title", length = 63, nullable = false)
    @EqualsAndHashCode.Include
    private String title;

    @ManyToMany(cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Reader> readers;

    @ManyToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    private Author author;

}

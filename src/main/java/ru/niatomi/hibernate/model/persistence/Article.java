package ru.niatomi.hibernate.model.persistence;

import lombok.*;

import javax.persistence.*;
@Entity
@Table(name = "articles")
@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "name", length = 63, nullable = false)
    private String name;

    @Column(name = "author", length = 63, nullable = false)
    private Author author;

    @Column(name = "reader", length = 63, nullable = false)
    private Reader reader;


}

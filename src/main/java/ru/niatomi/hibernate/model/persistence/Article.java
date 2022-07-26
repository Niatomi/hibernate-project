package ru.niatomi.hibernate.model.persistence;

import lombok.*;

import javax.persistence.*;
import java.util.List;

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
    @EqualsAndHashCode.Include
    private String title;

    @ManyToMany
    @ToString.Exclude
    private List<Reader> readers;

    @ManyToOne
    @ToString.Exclude
    private Author author;

}

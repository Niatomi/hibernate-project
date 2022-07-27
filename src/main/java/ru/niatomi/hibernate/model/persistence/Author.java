package ru.niatomi.hibernate.model.persistence;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "author_table")
@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "first_name", length = 32)
    @EqualsAndHashCode.Include
    private String firstName;

    @Column(name = "second_name", length = 32)
    @EqualsAndHashCode.Include
    private String secondName;

    @EqualsAndHashCode.Include
    private LocalDate dateBirth;

    @OneToMany
    @ToString.Exclude
    @JoinColumn(name = "article_id")
    private List<Article> article;

}

package ru.niatomi.hibernate.model.persistence.au;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

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

    private String firstName;

    private String secondName;

    private LocalDate dateBirth;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

}

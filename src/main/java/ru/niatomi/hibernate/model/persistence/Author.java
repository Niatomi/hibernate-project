package ru.niatomi.hibernate.model.persistence;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "author_table")
@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Author {

    @EqualsAndHashCode.Include
    private Long id;

    private String firstName;

    private String secondName;

    private LocalDate dateBirth;

    private Article article;

}

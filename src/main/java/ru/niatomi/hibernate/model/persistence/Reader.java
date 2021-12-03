package ru.niatomi.hibernate.model.persistence;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "author_table")
@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Reader {

    @EqualsAndHashCode.Include
    private Long id;

    private String name;

    private String mail;

    private Article article;

}

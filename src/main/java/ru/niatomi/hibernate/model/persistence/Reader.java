package ru.niatomi.hibernate.model.persistence;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "reader_table")
@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Reader {

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
    @Column(name = "mail", length = 32)
    private String mail;

    @ManyToMany
    @ToString.Exclude
    private List<Article> article;


}

package ru.niatomi.hibernate.model.persistence;

import lombok.*;

import javax.persistence.*;

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

    private String name;

    private String mail;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

}

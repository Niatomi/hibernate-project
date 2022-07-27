package ru.niatomi.hibernate.model.persistence;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = Reader.READER_TABLE_NAME)
@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Reader {

    public static final String READER_TABLE_NAME = "reader_table";
    public static final String READER_TABLE_FIRST_NAME = "first_name";
    public static final String READER_TABLE_SECOND_NAME = "second_name";
    public static final String READER_TABLE_MAIL = "mail";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = READER_TABLE_FIRST_NAME, length = 32)
    @EqualsAndHashCode.Include
    private String firstName;

    @Column(name = READER_TABLE_SECOND_NAME, length = 32)
    @EqualsAndHashCode.Include
    private String secondName;

    @EqualsAndHashCode.Include
    @Column(name = READER_TABLE_MAIL, length = 32)
    private String mail;

    @ManyToMany(cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Article> article;


}

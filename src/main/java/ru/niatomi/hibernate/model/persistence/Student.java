package ru.niatomi.hibernate.model.persistence;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "app_user")
@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "first_name", length = 63,nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 63, nullable = false)
    private String lastName;

    @Column(name = "birthday_date")
    private LocalDate birthday;

    @OneToOne(optional = true)
    private Address address;
}

package ru.niatomi.hibernate.model.persistence;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "user_data")
@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class User {
    @EqualsAndHashCode.Include
    private Long id;

    private String firstName;

    private String lastName;

    private LocalDate birthday;
}

package ru.niatomi.hibernate.model.persistence;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "address_data")
@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Address {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "street")
    private String address;
}

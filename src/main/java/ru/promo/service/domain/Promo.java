package ru.promo.service.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Data
public class Promo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;

    @OneToMany
    private Set<Prize> prizes;

    @OneToMany
    private Set<Participant> participants;
}

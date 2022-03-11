package ru.promo.service.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
}

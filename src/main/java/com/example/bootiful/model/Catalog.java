package com.example.bootiful.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "Catalog")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;


    @Column
    private LocalDate addingDate;

}

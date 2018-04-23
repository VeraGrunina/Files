package com.example.bootiful.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "Catalog")
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

    @Column(name = "ADDING_DATE")
    private LocalDate addingDate;

    @Column(name = "NAME")
    private String name;

    private String pathToDirectory;

    @ManyToOne(cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @JoinColumn(name="id", insertable = false, updatable = false)
    private Catalog parentDirectory;
}

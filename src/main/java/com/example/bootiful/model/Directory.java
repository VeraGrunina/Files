package com.example.bootiful.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity(name = "DirectoryTable")
public class Directory extends Catalog {

    @OneToMany(mappedBy = "id", cascade = {CascadeType.REMOVE})
    private Set<Catalog> catalogSet;

    public Directory() {
    }

    public Directory(Long id, LocalDate addingDate, String name, String pathToDirectory, Directory parentDirectory, Set<Catalog> catalogSet) {
        super(id, addingDate, name, pathToDirectory, parentDirectory);
        this.catalogSet = catalogSet;
    }
}

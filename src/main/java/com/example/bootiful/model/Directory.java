package com.example.bootiful.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity(name = "DirectoryTable")
@NoArgsConstructor
@AllArgsConstructor
public class Directory extends Catalog {

    private String pathToDirectory;

    @Column
    private String name;

    @OneToMany(mappedBy = "directory", cascade = CascadeType.ALL)
    private Set<File> fileList;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="id", insertable = false, updatable = false)
    private Directory parentDirectory;

}

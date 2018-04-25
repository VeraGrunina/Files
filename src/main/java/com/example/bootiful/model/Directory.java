package com.example.bootiful.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap.KeySetView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import lombok.ToString;

@Data
@Entity(name = "DIRECTORY_TABLE")
@ToString(exclude = {"fileSet"})
public class Directory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "directory_id", updatable = false, nullable = false)
    protected Long id;

    @Column(name = "adding_date")
    private LocalDate addingDate;

    @Column(name = "name_dir")
    private String name;

    private String pathToDirectory;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="parent_id", insertable = false, updatable = false)
    private Directory parentDirectory;

    @JsonIgnore
    @OneToMany(mappedBy="parentDirectory")
    private List<Directory> childDirectory = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "directory", cascade = {CascadeType.REMOVE})
    private List<File> fileSet = new ArrayList<>();

}

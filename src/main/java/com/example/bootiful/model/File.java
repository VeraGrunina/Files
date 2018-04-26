package com.example.bootiful.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import lombok.ToString;

@Entity(name = "File_Table")
@Data
@ToString(exclude = "directory")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "file_id", updatable = false, nullable = false)
    protected Long id;

    private String nameFile;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="directory_id")
    private Directory directory;

    private byte sizeFile;

}

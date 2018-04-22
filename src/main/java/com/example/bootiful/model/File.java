package com.example.bootiful.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "FileTable")
@Data
public class File extends Catalog {

    private byte size;

    public File() {
    }

    public File(Long id, LocalDate addingDate, String name, String pathToDirectory, Directory parentDirectory, byte size) {
        super(id, addingDate, name, pathToDirectory, parentDirectory);
        this.size = size;
    }
}

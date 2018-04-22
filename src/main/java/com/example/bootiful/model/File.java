package com.example.bootiful.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "FileTable")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class File extends Catalog {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Directory directory;

    @Column
    private String name;

    @Column
    private byte size;
}

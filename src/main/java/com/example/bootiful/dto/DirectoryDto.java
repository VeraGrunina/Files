package com.example.bootiful.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class DirectoryDto {
    private Long id;
    private LocalDate localDate;
    private String name;
    private int countDirectory;
    private int countFiles;
    private String sumSizeFiles;
}

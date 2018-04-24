package com.example.bootiful.services;

import com.example.bootiful.model.File;

import java.util.List;

public interface FileService {
    File createFile(File file);

    File updateFile(File file);

    void deleteFile(Long id);

    List<File> getAllFiles();

    File getFile(Long id);
}

package com.example.bootiful.services;

import com.example.bootiful.model.Directory;

import java.util.List;

public interface DirectoryService {
    Directory createDirectory(Directory directory);

    Directory updateDirecoty(Directory directory);

    void deleteDirectory(Long id);

    List<Directory> getAllDirectory();
}

package com.example.bootiful.services;

import com.example.bootiful.model.Directory;

import com.example.bootiful.model.File;
import java.util.List;

public interface DirectoryService {
    Directory createDirectory(Directory directory);

    Directory updateDirecoty(Directory directory);

    void deleteDirectory(Long id);

    List<Directory> getAllDirectory();

    Directory getDirectory(Long id);

    public List<File> getFilesInDirectory(Long id);

    List<Object> getFirstLevelObjectsInDirectory(Long id);
}

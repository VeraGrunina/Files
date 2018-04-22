package com.example.bootiful.services;

import com.example.bootiful.model.Directory;

import java.util.List;

public interface DirectoryService {
    Directory createDirectory(Directory directory);

    List<Directory> getAllDirectory();
}

package com.example.bootiful.services;

import com.example.bootiful.dto.DirectoryDto;
import com.example.bootiful.dto.DirectorySmallDto;
import com.example.bootiful.model.Directory;

import com.example.bootiful.model.File;
import java.util.List;

public interface DirectoryService {
    Directory createDirectory(Directory directory);

    Directory updateDirectory(Directory directory);

    void deleteDirectory(Long id);

    List<Directory> getAllDirectory();

    Directory getDirectory(Long id);

    public List<File> getFilesInDirectory(Long id);

    List<Object> getFirstLevelObjectsInDirectory(Long id);

    List<DirectoryDto> getFirstLevelDirectory(Long id);

    int countChildDirectory(Long parentId);

  List<DirectorySmallDto> getInnerFileOnClickButton(Long directoryId);
}

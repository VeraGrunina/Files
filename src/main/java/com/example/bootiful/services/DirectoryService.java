package com.example.bootiful.services;

import com.example.bootiful.dto.DirectoryDto;
import com.example.bootiful.dto.DirectorySmallDto;
import com.example.bootiful.model.Directory;

import com.example.bootiful.model.File;
import java.util.List;

public interface DirectoryService {

    List<Directory> getAllDirectory();

    Directory getDirectory(Long id);

    List<Object> getFirstLevelObjectsInDirectory(Long id);

    List<DirectoryDto> getFirstLevelDirectory(Long id);

    int countChildDirectory(Long parentId);

  List<DirectorySmallDto> getInnerFileOnClickButton(Long directoryId);

    DirectoryDto createDirectoryFromName(String name);
}

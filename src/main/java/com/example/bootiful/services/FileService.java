package com.example.bootiful.services;

import com.example.bootiful.model.Directory;
import com.example.bootiful.model.File;

import java.util.List;

public interface FileService {
    File createFile(File file);

    File getFile(Long id);

    List<File> getByDirectoryId(Long id);

    int countFilesInDirectory(Long directoryId);
}

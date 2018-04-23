package com.example.bootiful.services.impl;

import com.example.bootiful.model.File;
import com.example.bootiful.repositories.FileRepository;
import com.example.bootiful.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class FileServiceImpl implements FileService {

    private final FileRepository fileRepository;

    @Autowired
    public FileServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public File createFile(File file) {
        if (file == null) {
            throw new IllegalArgumentException("Can't save empty file");
        }

        return fileRepository.save(file);
    }

    @Override
    public File updateFile(File file) {
        if (file == null) {
            throw new IllegalArgumentException("Can't save empty file");
        }

        return fileRepository.save(file);
    }

    @Override
    public void deleteFile(Long id) {
        fileRepository.delete(id);
    }

    @Override
    public List<File> getAllFiles() {
        return fileRepository.findAll();
    }
}

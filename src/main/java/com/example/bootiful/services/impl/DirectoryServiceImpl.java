package com.example.bootiful.services.impl;

import com.example.bootiful.model.Directory;
import com.example.bootiful.repositories.DirectoryRepository;
import com.example.bootiful.services.DirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectoryServiceImpl implements DirectoryService {
    private final DirectoryRepository directoryRepository;

    @Autowired
    public DirectoryServiceImpl(DirectoryRepository directoryRepository) {
        this.directoryRepository = directoryRepository;
    }


    @Override
    public Directory createDirectory(Directory directory) {
        if (directory == null) {
            throw new IllegalArgumentException("directory is null");
        }
        return directoryRepository.save(directory);
    }

    @Override
    public List<Directory> getAllDirectory() {
        return directoryRepository.findAll();
    }
}

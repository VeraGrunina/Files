package com.example.bootiful.services.impl;

import com.example.bootiful.model.Directory;
import com.example.bootiful.repositories.DirectoryRepository;
import com.example.bootiful.services.DirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
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
    public Directory updateDirecoty(Directory directory) {
        if (directory == null) {
            throw new IllegalArgumentException("directory is null");
        }
        return directoryRepository.save(directory);
    }

    @Override
    public void deleteDirectory(Long id) {
        directoryRepository.deleteById(id);
    }

    @Override
    public List<Directory> getAllDirectory() {
        return directoryRepository.findAll();
    }

  /*  @Override
    public Directory getDirectory(Long id) {
        return directoryRepository.findOne(id);
    }*/
}


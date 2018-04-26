package com.example.bootiful.services.impl;

import com.example.bootiful.model.Directory;
import com.example.bootiful.model.File;
import com.example.bootiful.repositories.DirectoryRepository;
import com.example.bootiful.services.DirectoryService;
import com.example.bootiful.services.FileService;
import com.example.bootiful.services.RadixSortHelper;
import java.util.ArrayList;
import java.util.LinkedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DirectoryServiceImpl implements DirectoryService {

    private final DirectoryRepository directoryRepository;
    @Autowired
    private FileService fileService;

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

        List<Directory> all = directoryRepository.findAll();

        String[] directoryName = new String[all.size()];
        List<Directory> sortDirectory = new LinkedList<>();

        for (int i = 0; i < all.size(); i++) {
            directoryName[i] = all.get(i).getName();
        }

        RadixSortHelper.radixSort(directoryName, '!', '~');

        for (String dn : directoryName) {
            for (Directory d : all) {
                if (d.getName().equals(dn)) {
                    sortDirectory.add(d);
                    all.remove(d);
                    break;
                }
            }
        }
        return sortDirectory;
    }

    @Override
    public Directory getDirectory(Long id) {
        return directoryRepository.findById(id).get();
    }

    @Override
    public List<File> getFilesInDirectory(Long id) {
        return fileService.getByDirectoryId(id);
    }

    @Override
    public List<Object> getFirstLevelObjectsInDirectory(Long id) {

        List<Object> list = new LinkedList<>();

        Directory parentDirectory = getDirectory(id);

        list.addAll(directoryRepository.findByParentDirectory(parentDirectory));
        list.addAll(fileService.getByDirectoryId(id));

        return list;
    }
}


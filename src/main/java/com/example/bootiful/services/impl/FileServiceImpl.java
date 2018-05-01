package com.example.bootiful.services.impl;

import com.example.bootiful.model.Directory;
import com.example.bootiful.model.File;
import com.example.bootiful.repositories.FileRepository;
import com.example.bootiful.services.DirectoryService;
import com.example.bootiful.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class FileServiceImpl implements FileService {

    private final FileRepository fileRepository;

    @Autowired
    private DirectoryService directoryService;

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
        fileRepository.deleteById(id);
    }

    @Override
    public List<File> getAllFiles() {
        return fileRepository.findAll();
    }

    @Override
    public File getFile(Long id) {
        return fileRepository.findById(id).get();
    }

    @Override
    public List<File> getByDirectoryId(Long id) {
        Directory directory = directoryService.getDirectory(id);
        return fileRepository.getAllByDirectoryIsInOrderByNameFile(directory);
    }

  @Override
  public int countFilesInDirectory(Long directoryId) {

        return fileRepository.countFilesByDirectoryId(directoryId);
  }

}

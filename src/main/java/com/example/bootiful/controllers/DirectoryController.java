package com.example.bootiful.controllers;

import com.example.bootiful.model.Directory;
import com.example.bootiful.model.File;
import com.example.bootiful.services.DirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DirectoryController {

    private final DirectoryService directoryService;

    @Autowired
    public DirectoryController(DirectoryService directoryService) {
        this.directoryService = directoryService;
    }

    @PostMapping("/directory")
    public Directory createDirectory(@RequestBody Directory directory) {
        return directoryService.createDirectory(directory);
    }

    @PutMapping("/directory/{id}")
    public Directory updateDirectory(@PathVariable Long id, @RequestBody Directory directory) {
        directory.setId(id);
        return directoryService.updateDirecoty(directory);
    }

    @GetMapping("/directory/{id}")
    public Directory getDirectory(@PathVariable Long id) {
      return directoryService.getDirectory(id);
    }

    @GetMapping("/directory/{id}/files")
    public List<File> getFilesByDirectory(@PathVariable Long id) {
      return directoryService.getFilesInDirectory(id);
    }


    @DeleteMapping("/directory/{id}")
    public void deleteDirectory(@PathVariable Long id) {
        directoryService.deleteDirectory(id);
    }

    @GetMapping("/directory/all")
    public List<Directory> getListDirectory() {
        return directoryService.getAllDirectory();
    }
}

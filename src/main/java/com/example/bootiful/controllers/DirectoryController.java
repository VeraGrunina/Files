package com.example.bootiful.controllers;

import com.example.bootiful.model.Directory;
import com.example.bootiful.services.DirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/directory/all")
    public List<Directory> getListDirectory() {
        return directoryService.getAllDirectory();
    }
}

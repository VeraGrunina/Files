package com.example.bootiful.controllers;

import com.example.bootiful.model.Directory;
import com.example.bootiful.model.File;
import com.example.bootiful.services.FileService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileController {

  private final FileService fileService;

  @Autowired
  public FileController(FileService fileService) {
    this.fileService = fileService;
  }

  @PostMapping("/file")
  public File createDirectory(@RequestBody File file) {
    return fileService.createFile(file);
  }

  @PutMapping("/file/{id}")
  public File updateDirectory(@PathVariable Long id, @RequestBody File file) {
    file.setId(id);
    return fileService.updateFile(file);
  }

  @GetMapping("/file/{id}")
  public File getDirectory(@PathVariable Long id) {
    return fileService.getFile(id);
  }

  @DeleteMapping("/file/{id}")
  public void deleteDirectory(@PathVariable Long id) {
    fileService.deleteFile(id);
  }

}

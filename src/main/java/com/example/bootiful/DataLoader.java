//package com.example.bootiful;
//
//import com.example.bootiful.model.Catalog;
//import com.example.bootiful.model.Directory;
//import com.example.bootiful.services.DirectoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.annotation.PostConstruct;
//import java.time.LocalDate;
//import java.util.HashSet;
//
//@Transactional
//@Component
//public class DataLoader {
//    private DirectoryService service;
//
//    @Autowired
//    public DataLoader(DirectoryService service){
//        this.service = service;
//    }
//
//    @PostConstruct
//    private void loadDirectory(){
//
//        Directory directory = new Directory(null, LocalDate.now(), "firstDir", "bla blabla",
//                null, new HashSet<>());
//
//        service.createDirectory(directory);
//    }
//}

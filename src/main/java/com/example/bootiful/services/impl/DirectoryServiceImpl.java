package com.example.bootiful.services.impl;

import com.example.bootiful.dto.DirectoryDto;
import com.example.bootiful.dto.DirectorySmallDto;
import com.example.bootiful.model.Directory;
import com.example.bootiful.model.File;
import com.example.bootiful.repositories.DirectoryRepository;
import com.example.bootiful.services.DirectoryService;
import com.example.bootiful.services.FileService;
import com.example.bootiful.services.RadixSortHelper;

import java.time.LocalDate;
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
    public List<Object> getFirstLevelObjectsInDirectory(Long id) {

        List<Object> list = new LinkedList<>();

        Directory parentDirectory = getDirectory(id);

        list.addAll(directoryRepository.findByParentDirectory(parentDirectory));
        list.addAll(fileService.getByDirectoryId(id));

        return list;
    }

    @Override
    public List<DirectoryDto> getFirstLevelDirectory(Long id) {
        List<Directory> byParentDirectory = directoryRepository.findByParentDirectoryIdOrderByName(null);

        List<DirectoryDto> dtoList = new ArrayList<>();

        for (Directory dir : byParentDirectory) {
            int countChildDir = countChildDirectory(dir.getId());
            int countFilesInDir = fileService.countFilesInDirectory(dir.getId());
            int sizeFiles = 0;
            String strSizeFiles;
            List<File> fileSet = dir.getFileSet();

            if (fileSet.size() != 0) {
                for (File f:fileSet) {
                    sizeFiles += f.getSizeFile();
                }
            }

            strSizeFiles = getStringSizeFileHelper(sizeFiles);

            DirectoryDto addDir = DirectoryDto.builder()
                    .localDate(dir.getAddingDate())
                    .name(dir.getName())
                    .id(dir.getId())
                    .countDirectory(countChildDir)
                    .countFiles(countFilesInDir)
                    .sumSizeFiles(strSizeFiles)
                    .build();

            dtoList.add(addDir);
        }

        return dtoList;
    }

    private String getStringSizeFileHelper(int sizeFiles) {
        String strSizeFiles;
        if (sizeFiles < 1024) {
            strSizeFiles = sizeFiles + "byte";
        } else if ( sizeFiles > 1024  && sizeFiles < 1024*1024) {
            double newSize = sizeFiles / 1024;
            strSizeFiles = String.format("%.2f", newSize) + "Kb";
        } else {
            double newSize = (sizeFiles / 1024) / 1024;
            strSizeFiles = String.format("%.2f", newSize) + "Mb";
        }
        return strSizeFiles;
    }

    @Override
    public int countChildDirectory(Long parentId) {
        return directoryRepository.countDirectoryByParentDirectoryId(parentId);
    }

    @Override
    public List<DirectorySmallDto> getInnerFileOnClickButton(Long directoryId) {
        Directory one = directoryRepository.getOne(directoryId);

        List<Directory> childDirectory = one.getChildDirectory();

        List<DirectorySmallDto> smallDtoList = new ArrayList<>();

        if (childDirectory.size() > 0) {
            for (Directory dir : childDirectory) {
                DirectorySmallDto directorySmallDto = DirectorySmallDto.builder()
                    .name(dir.getName())
                    .size("&lt;DIR&gt;")
                    .build();


                smallDtoList.add(directorySmallDto);
            }
        }

        List<File> fileList = one.getFileSet();

        if (fileList.size() > 0) {
            for (File f : fileList) {
                int sizeFiles = f.getSizeFile();
                String strSizeFiles;

                strSizeFiles = getStringSizeFileHelper(sizeFiles);

                DirectorySmallDto directorySmallDto = DirectorySmallDto.builder()
                    .name(f.getNameFile())
                    .size(strSizeFiles)
                    .build();

                smallDtoList.add(directorySmallDto);
            }
        }

        return smallDtoList;
    }

    @Override
    public DirectoryDto createDirectoryFromName(String name) {
        Directory directory = new Directory();

        directory.setName(name);
        directory.setAddingDate(LocalDate.now());

        Directory saveDir = directoryRepository.save(directory);

        return DirectoryDto.builder()
                .id(saveDir.getId())
                .name(saveDir.getName())
                .localDate(saveDir.getAddingDate())
                .sumSizeFiles("0byte")
                .countDirectory(0)
                .countFiles(0)
                .build();
    }
}


package com.example.bootiful.repositories;

import com.example.bootiful.model.Directory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectoryRepository extends JpaRepository<Directory, Long> {
  List<Directory> findByParentDirectory(Directory parentDirectory);

  int countDirectoryByParentDirectory(Directory parentDirectory);

  int countDirectoryByParentDirectoryId(Long parentId);

}

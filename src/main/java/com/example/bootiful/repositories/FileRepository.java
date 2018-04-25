package com.example.bootiful.repositories;

import com.example.bootiful.model.File;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
  List<File> getAllByDirectoryIsInOrderByNameFile(Long id);
}

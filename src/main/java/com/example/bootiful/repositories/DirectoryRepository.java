package com.example.bootiful.repositories;

import com.example.bootiful.model.Directory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectoryRepository extends JpaRepository<Directory, Long> {
    Directory findOne(Long aLong);
}

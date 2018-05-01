package com.example.bootiful.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DirectorySmallDto {
  String name;
  String size;
}

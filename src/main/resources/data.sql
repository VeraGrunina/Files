INSERT INTO DIRECTORY_TABLE (directory_id, name_dir)
VALUES (2L, 'first'),
(3L, 'next'),
  (4L, 'nextdir'),
  (5L, 'nex0t'),
  (13L, 'anothernext'),
  (6L, 'ne234xt'),
  (7L, 'nex546t'),
  (8L, 'nex178t'),
  (9L, 'next657'),
  (10L, '123next'),
  (11L, 'n9876 ext'),
  (12L, 'ne432xt');

INSERT INTO File_Table(file_id, name_file, size_file, directory_id)
    VALUES (1L, 'file txt', 3, 2L),
      (2L, 'file jpg', 12, 2L),
      (3L, 'file to next', 7,  3L);
INSERT INTO DIRECTORY_TABLE (directory_id, name_dir, parent_id)
VALUES (2, 'first', null),
(3, 'next', null),
  (4, 'nextdir', 2),
  (5, 'nex0t', 3),
  (13, 'anothernext has parent directory with id 4', 4),
  (14, 'has parent directory with id 4', 4),
  (6, 'ne234xt', 5),
  (7, 'nex546t', 13),
  (8, 'nex178t', 2),
  (9, 'next657', null),
  (10, '123next', 5),
  (11, 'n9876 ext', null),
  (12, 'ne432xt', null);

INSERT INTO File_Table(file_id, name_file, size_file, directory_id)
    VALUES (1, 'file txt', 3, 2),
      (2, 'file jpg', 12, 2),
      (3, 'file to next', 7,  3),
      (4, 'file jpg2', 8, 5),
      (6, 'file jpg2', 8, 4),
      (5, 'file in 10 directory', 11, 10);
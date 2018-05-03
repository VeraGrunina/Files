INSERT INTO DIRECTORY_TABLE (name_dir, parent_id)
VALUES (1, 'first', null),
(2, 'next', null),
  (3, 'nextdir', 2),
  (4, 'nex0t', 3),
  (5, 'anothernext has parent directory with id 1', 1),
  (6, 'ne234xt', 5),
  (7, 'nex546t', 6),
  (8, 'nex178t', 2),
  (9, 'next657', null),
  (10, '123next', 9),
  (12, 'ne432xt', null),
  (13, 'has parent directory with id 1', 1);

INSERT INTO DIRECTORY_TABLE (directory_id, name_dir, parent_id, adding_date)
VALUES (11, 'n9876 ext', null, '2017-04-29');

INSERT INTO File_Table(file_id, name_file, size_file, directory_id)
    VALUES (1, 'file txt', 3, 2),
      (2, 'file jpg', 12, 2),
      (3, 'file to next', 7,  3),
      (4, 'file jpg2', 8, 5),
      (6, 'file jpg2', 8, 4),
      (5, 'file in 10 directory', 11, 9);
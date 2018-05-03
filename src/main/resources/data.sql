INSERT INTO DIRECTORY_TABLE (directory_id, name_dir, parent_id, adding_date)
VALUES (1, 'first', null, '2017-03-15'),
(2, 'next', null, '2017-02-08'),
  (3, 'nextdir', 2, '2017-05-16'),
  (4, 'nex0t', 3, '2016-11-10'),
  (5, 'anothernext has parent directory with id 1', 1, '2017-01-12'),
  (6, 'ne234xt', 5, '2018-08-29'),
  (7, 'nex546t', 6, '2017-04-29'),
  (8, 'nex178t', 2, '2017-04-29'),
  (9, 'next657', null, '2018-04-21'),
  (10, '123next', 9, '2017-04-29'),
  (11, 'n9876 ext', null, '2017-04-29'),
  (12, 'ne432xt', null, '2017-10-13'),
  (13, 'has parent directory with id 1', 1, '2017-04-29');

INSERT INTO File_Table(file_id, name_file, size_file, directory_id)
    VALUES (1, 'file txt', 3342, 2),
      (2, 'file jpg', 1263, 2),
      (3, 'file to next', 74,  3),
      (4, 'file jpg2', 8213, 5),
      (5, 'file in 9 directory', 4216, 9),
      (6, 'file jpg2', 81367357, 4),
      (7, 'file in 1 directory', 421643773, 1);
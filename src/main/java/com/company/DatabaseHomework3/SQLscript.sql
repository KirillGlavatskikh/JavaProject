INSERT INTO groups(id, name, rating, year) VALUES(1, 'physics', 3, 1)
SELECT * FROM groups
INSERT INTO groups(id, name, rating, year) VALUES(2, 'matematics', 5, 3)
INSERT INTO groups(id, name, rating, year) VALUES(3, 'phylophers', 2, 2)
INSERT INTO groups(id, name, rating, year) VALUES(4, 'IT', 4, 5)
INSERT INTO groups(id, name, rating, year) VALUES(5, 'biologists', 1, 1)
SELECT * FROM departments
INSERT INTO departments(id, financing, name) VALUES(1, 20000, 'physics')
INSERT INTO departments(id, financing, name) VALUES(2, 40000, 'matematics')
INSERT INTO departments(id, financing, name) VALUES(3, 25000, 'phylophers')
INSERT INTO departments(id, financing, name) VALUES(4, 100000, 'IT')
INSERT INTO departments(id, financing, name) VALUES(5, 30000, 'biologosts')
SELECT * FROM faculties
INSERT INTO faculties(id, name, dean) VALUES(1,'physics', 'Ivanova')
INSERT INTO faculties(id, name, dean) VALUES(2,'matematics', 'Petrov')
INSERT INTO faculties(id, name, dean) VALUES(3,'phylophers', 'Shishkin')
INSERT INTO faculties(id, name, dean) VALUES(4,'IT', 'Niyazov')
INSERT INTO faculties(id, name, dean) VALUES(5,'biologists', 'Ahmedov')
SELECT * FROM teachers
INSERT INTO teachers(id, employment_date, name, premium, salary, surname, is_professor, is_assistant, position) VALUES(1, '23.05.2003', 'Maria', 5000, 20000, 'Ivanova', '0', '1', 'teacher')
INSERT INTO teachers(id, employment_date, name, premium, salary, surname, is_professor, is_assistant, position) VALUES(2, '10.08.1995', 'Aleksandr', 8000, 30000, 'Petrov', '1', '0', 'teacher')
INSERT INTO teachers(id, employment_date, name, premium, salary, surname, is_professor, is_assistant, position) VALUES(3, '01.02.2000', 'Gennadiy', 5000, 20000, 'Shishkin', '0', '1', 'teacher')
INSERT INTO teachers(id, employment_date, name, premium, salary, surname, is_professor, is_assistant, position) VALUES(4, '15.10.2010', 'Petr', 7000, 25000, 'Niyazov', '1', '0', 'teacher')
INSERT INTO teachers(id, employment_date, name, premium, salary, surname, is_professor, is_assistant, position) VALUES(5, '05.05.2005', 'Nikolay', 7000, 25000, 'Ahmedov', '0', '1', 'teacher')
SELECT * FROM departments ORDER BY id DESC
SELECT * FROM groups
SELECT name, rating FROM groups
SELECT * FROM teachers
ALTER TABLE teachers ADD COLUMN is_assistant BIT NOT NULL DEFAULT 0::BIT
ALTER TABLE teachers ADD COLUMN is_professor BIT NOT NULL DEFAULT 0::BIT
ALTER TABLE teachers ADD COLUMN position VARCHAR NOT NULL CHECK(LENGTH(position) > 0)
SELECT surname, premium + salary FROM teachers
ALTER TABLE faculties ADD COLUMN dean VARCHAR NOT NULL CHECK(LENGTH(dean) > 0)
SELECT surname FROM teachers WHERE is_professor = '1' AND salary > '1050'
SELECT name FROM departments WHERE financing < '11000' OR financing > '25000'
SELECT name FROM faculties WHERE name != 'IT'
SELECT surname, position FROM teachers WHERE is_professor = '0'
SELECT surname, position, salary, premium FROM teachers WHERE premium BETWEEN '4500' AND '7500' AND is_assistant = '1'
SELECT surname, salary FROM teachers WHERE is_assistant = '1'
SELECT surname, position FROM teachers WHERE employment_date < '01.01.2000'
SELECT surname FROM teachers WHERE is_assistant = '1' AND salary + premium < '30000'
SELECT name FROM groups WHERE rating BETWEEN 2 AND 4 AND year = 5
SELECT surname FROM teachers WHERE is_assistant = '1' AND salary < '30000' OR premium < '8000'
CREATE TABLE subject(
id SERIAL NOT NULL PRIMARY KEY,
	name VARCHAR(100) NOT NULL CHECK(LENGTH(name) > 0) UNIQUE
)
CREATE TABLE teacher(
id SERIAL NOT NULL PRIMARY KEY,
	name VARCHAR NOT NULL CHECK(LENGTH(name) > 0),
	salary MONEY NOT NULL CHECK(salary > 0::MONEY),
	surname VARCHAR NOT NULL CHECK(LENGTH(surname) > 0)
)
CREATE TABLE lecture(
id SERIAL NOT NULL PRIMARY KEY,
	day_of_week INTEGER NOT NULL CHECK(day_of_week >= 1 and day_of_week <= 7),
	lecture_room VARCHAR NOT NULL CHECK(LENGTH(lecture_room) > 0),
	subject_id INTEGER NOT NULL REFERENCES subject(id),
	teacher_id INTEGER NOT NULL REFERENCES teacher(id)
)
CREATE TABLE faculty(
id SERIAL NOT NULL PRIMARY KEY,
	name VARCHAR(100) NOT NULL CHECK(LENGTH(name) > 0) UNIQUE
)
CREATE TABLE department(
id SERIAL NOT NULL PRIMARY KEY,
	financing MONEY NOT NULL CHECK(financing >= 0::MONEY) DEFAULT 0,
	name VARCHAR(100) NOT NULL CHECK(LENGTH(name) > 0) UNIQUE,
	faculty_id INTEGER NOT NULL REFERENCES faculty(id)
)
CREATE TABLE department(
id SERIAL NOT NULL PRIMARY KEY,
	financing MONEY NOT NULL CHECK(financing >= 0::MONEY) DEFAULT 0,
	name VARCHAR(100) NOT NULL CHECK(LENGTH(name) > 0) UNIQUE,
	faculty_id INTEGER NOT NULL REFERENCES faculty(id)
)
CREATE TABLE group_lecture(
id SERIAL NOT NULL PRIMARY KEY,
	group_id INTEGER NOT NULL REFERENCES groups(id),
	lecture_id INTEGER NOT NULL REFERENCES lecture(id)
)

INSERT INTO subject(name) VALUES('physics')
INSERT INTO subject(name) VALUES('matematics')
INSERT INTO subject(name) VALUES('phylophers')
INSERT INTO subject(name) VALUES('IT')
INSERT INTO subject(name) VALUES('biologists')

INSERT INTO teacher(name, salary, surname) VALUES('Maria', 20000, 'Ivanova')
INSERT INTO teacher(name, salary, surname) VALUES('Aleksandr', 30000, 'Petrov')
INSERT INTO teacher(name, salary, surname) VALUES('Gennadiy', 20000, 'Shishkin')
INSERT INTO teacher(name, salary, surname) VALUES('Petr', 25000, 'Niyazov')
INSERT INTO teacher(name, salary, surname) VALUES('Nikolay', 25000, 'Ahmedov')

INSERT INTO faculty(name) VALUES('physics')
INSERT INTO faculty(name) VALUES('matematics')
INSERT INTO faculty(name) VALUES('phylophers')
INSERT INTO faculty(name) VALUES('IT')
INSERT INTO faculty(name) VALUES('biologists')

INSERT INTO lecture(day_of_week, lecture_room, subject_id, teacher_id) VALUES(1, '101', 1, 1)
INSERT INTO lecture(day_of_week, lecture_room, subject_id, teacher_id) VALUES(2, '202', 2, 2)
INSERT INTO lecture(day_of_week, lecture_room, subject_id, teacher_id) VALUES(3, '303', 3, 3)
INSERT INTO lecture(day_of_week, lecture_room, subject_id, teacher_id) VALUES(4, '404', 4, 4)
INSERT INTO lecture(day_of_week, lecture_room, subject_id, teacher_id) VALUES(5, '505', 5, 5)

INSERT INTO department(financing, name, faculty_id) VALUES(20000, 'physics', 1)
INSERT INTO department(financing, name, faculty_id) VALUES(40000, 'matematics', 2)
INSERT INTO department(financing, name, faculty_id) VALUES(25000, 'phylophers', 3)
INSERT INTO department(financing, name, faculty_id) VALUES(100000, 'IT', 4)
INSERT INTO department(financing, name, faculty_id) VALUES(30000, 'biologosts', 5)

INSERT INTO groups(name, year, department_id) VALUES('physics', 1,1)
INSERT INTO groups(name, year, department_id) VALUES('matematics', 3, 2)
INSERT INTO groups(name, year, department_id) VALUES('phylophers', 2, 3)
INSERT INTO groups(name, year, department_id) VALUES('IT', 5, 4)
INSERT INTO groups(name, year, department_id) VALUES('biologists', 1, 5)

INSERT INTO group_lecture(group_id, lecture_id) VALUES(1, 1)
INSERT INTO group_lecture(group_id, lecture_id) VALUES(2, 2)
INSERT INTO group_lecture(group_id, lecture_id) VALUES(3, 3)
INSERT INTO group_lecture(group_id, lecture_id) VALUES(4, 4)
INSERT INTO group_lecture(group_id, lecture_id) VALUES(5, 5)

1) SELECT COUNT(teacher.name) FROM teacher, department WHERE teacher.id = department.id and department.name = 'IT'
2) SELECT COUNT(*) FROM teacher, lecture WHERE lecture.id = teacher.id AND teacher.name = 'Nikolay'
3) SELECT COUNT(*) FROM lecture WHERE lecture_room = '101'
6) SELECT AVG(salary::numeric) FROM teacher  - просто средняя ставка преподавателей
8) SELECT AVG(financing::numeric) FROM department
9) SELECT CONCAT(teacher.name, teacher.surname) AS full_name, COUNT(subject.name) FROM teacher, subject WHERE teacher.id = subject.id GROUP BY full_name
11) SELECT lecture.lecture_room, COUNT(groups.id) FROM lecture, groups WHERE lecture.id = groups.id GROUP BY lecture.lecture_room
12) SELECT faculty.name, COUNT(department.name) FROM faculty, department  WHERE faculty.id = department.id GROUP BY faculty.name
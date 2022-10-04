CREATE TABLE curator(
id SERIAL NOT NULL PRIMARY KEY,
	name VARCHAR NOT NULL CHECK(LENGTH(name) > 0),
	surname VARCHAR NOT NULL CHECK(LENGTH(surname) > 0)
)
CREATE TABLE department(
id SERIAL NOT NULL PRIMARY KEY,
	financing MONEY NOT NULL CHECK(financing > 0::MONEY) DEFAULT 0,
	name VARCHAR(100) NOT NULL CHECK(LENGTH(name) > 0) UNIQUE,
	faculty_id INTEGER NOT NULL REFERENCES facultie(id)
)
CREATE TABLE groups(
id SERIAL NOT NULL PRIMARY KEY,
	name VARCHAR(10) NOT NULL CHECK(LENGTH(name) > 0) UNIQUE,
	year INTEGER NOT NULL CHECK(year >= 1 AND year <= 5),
	department_id INTEGER NOT NULL REFERENCES department(id)
)
CREATE TABLE group_curator(
id SERIAL NOT NULL PRIMARY KEY,
	curator_id INTEGER NOT NULL REFERENCES curator(id),
	group_id INTEGER NOT NULL REFERENCES groups(id)
)
CREATE TABLE subjects(
id SERIAL NOT NULL PRIMARY KEY,
	name VARCHAR(100) NOT NULL CHECK(LENGTH(name) > 0) UNIQUE
)
CREATE TABLE lecture(
id SERIAL NOT NULL PRIMARY KEY,
	lecture_room VARCHAR NOT NULL CHECK(LENGTH(lecture_room) > 0),
	subject_id INTEGER NOT NULL REFERENCES subjects(id),
	teacher_id INTEGER NOT NULL REFERENCES teacher(id)
)
CREATE TABLE group_lecture(
id SERIAL NOT NULL PRIMARY KEY,
	group_id INTEGER NOT NULL REFERENCES groups(id),
	lecture_id INTEGER NOT NULL REFERENCES lecture(id)
)
SELECT * FROM curator
INSERT INTO curator(name, surname) VALUES('Vladimir', 'Filatov')
INSERT INTO curator(name, surname) VALUES('Nikolay', 'Frolov')
INSERT INTO curator(name, surname) VALUES('Olga', 'Matveeva')
INSERT INTO curator(name, surname) VALUES('Tamara', 'Popova')
INSERT INTO curator(name, surname) VALUES('Konstantin', 'Mitroshin')
SELECT * FROM department
INSERT INTO department(financing, name, faculty_id) VALUES(20000, 'physics', 1)
INSERT INTO department(financing, name, faculty_id) VALUES(40000, 'matematics', 2)
INSERT INTO department(financing, name, faculty_id) VALUES(25000, 'phylophers', 3)
INSERT INTO department(financing, name, faculty_id) VALUES(100000, 'IT', 4)
INSERT INTO department(financing, name, faculty_id) VALUES(30000, 'biologosts', 5)
SELECT * FROM groups
INSERT INTO groups(name, year, department_id) VALUES('physics', 1, 3)
INSERT INTO groups(name, year, department_id) VALUES('matematics', 3, 4)
INSERT INTO groups(name, year, department_id) VALUES('phylophers', 2, 5)
INSERT INTO groups(name, year, department_id) VALUES('IT', 5, 6)
INSERT INTO groups(name, year, department_id) VALUES('biologists', 1, 7)
SELECT * FROM group_curator
INSERT INTO group_curator(curator_id, group_id) VALUES(1 ,2)
INSERT INTO group_curator(curator_id, group_id) VALUES(2, 3)
INSERT INTO group_curator(curator_id, group_id) VALUES(3, 4)
INSERT INTO group_curator(curator_id, group_id) VALUES(4, 5)
INSERT INTO group_curator(curator_id, group_id) VALUES(5, 6)
SELECT * FROM subject
INSERT INTO subject(name) VALUES('physics')
INSERT INTO subject(name) VALUES('matematics')
INSERT INTO subject(name) VALUES('phylophers')
INSERT INTO subject(name) VALUES('IT')
INSERT INTO subject(name) VALUES('biologists')
SELECT * FROM lecture
INSERT INTO lecture(lecture_room, subject_id,teacher_id) VALUES('101', 1, 1)
INSERT INTO lecture(lecture_room, subject_id,teacher_id) VALUES('202', 2, 2)
INSERT INTO lecture(lecture_room, subject_id,teacher_id) VALUES('303', 3, 3)
INSERT INTO lecture(lecture_room, subject_id,teacher_id) VALUES('404', 4, 4)
INSERT INTO lecture(lecture_room, subject_id,teacher_id) VALUES('505', 5, 5)
SELECT * FROM group_lecture
INSERT INTO group_lecture(group_id, lecture_id) VALUES(2, 1)
INSERT INTO group_lecture(group_id, lecture_id) VALUES(3, 2)
INSERT INTO group_lecture(group_id, lecture_id) VALUES(4, 3)
INSERT INTO group_lecture(group_id, lecture_id) VALUES(5, 4)
INSERT INTO group_lecture(group_id, lecture_id) VALUES(6, 5)

1) SELECT teachers.name, groups.name FROM teachers, groups WHERE teachers.id = groups.id
2) SELECT facultie.name FROM facultie, department WHERE facultie.financing > department.financing
3) SELECT curators.surname, groups.name FROM curators, groups WHERE curators.id = groups.id
4) SELECT CONCAT(teacher.name, teacher.surname) FROM teacher, group_lecture, groups WHERE teacher.id = group_lecture.group_id AND groups.name = 'IT'
5) SELECT teachers.surname, faculties.name FROM teachers,faculties WHERE teachers.id = faculties.id
6) SELECT departments.name, groups.name FROM departments, groups WHERE departments.id = groups.id
7) SELECT subjects.name FROM subjects, lecture WHERE subjects.id = lecture.subject_id AND lecture.subject_id = lecture.teacher_id
9) SELECT groups.name FROM groups, facultie WHERE facultie.id = groups.id AND facultie.name = 'IT'
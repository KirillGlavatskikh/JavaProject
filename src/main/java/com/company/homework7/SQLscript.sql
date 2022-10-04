CREATE TABLE teacher(
id SERIAL NOT NULL PRIMARY KEY,
	name VARCHAR NOT NULL CHECK(LENGTH(name) > 0),
	surname VARCHAR NOT NULL CHECK(LENGTH(surname) > 0)
)
CREATE TABLE subject(
id SERIAL NOT NULL PRIMARY KEY,
	name VARCHAR(100) NOT NULL CHECK(LENGTH(name) > 0) UNIQUE
)
CREATE TABLE lecture(
id SERIAL NOT NULL PRIMARY KEY,
	subject_id INTEGER NOT NULL REFERENCES subject(id),
	teacher_id INTEGER NOT NULL REFERENCES teacher(id)
)
CREATE TABLE group_lecture(
id SERIAL NOT NULL PRIMARY KEY,
	group_id INTEGER NOT NULL REFERENCES groups(id),
	lecture_id INTEGER NOT NULL REFERENCES lecture(id)
)
CREATE TABLE lecture_room(
id SERIAL NOT NULL PRIMARY KEY,
	building INTEGER NOT NULL CHECK(building >= 1 and building <= 5),
	name VARCHAR(10) NOT NULL CHECK(LENGTH(name) > 0) UNIQUE
)
CREATE TABLE shedule(
id SERIAL NOT NULL PRIMARY KEY,
	class INTEGER NOT NULL CHECK(class >= 1 and class <= 8),
	day_of_week INTEGER NOT NULL CHECK(day_of_week >= 1 and day_of_week <= 7),
	week INTEGER NOT NULL CHECK(week >= 1 and week <= 52),
	lecture_id INTEGER NOT NULL REFERENCES lecture(id),
	lecture_room_id INTEGER NOT NULL REFERENCES lecture_room(id)
)
CREATE TABLE head(
id SERIAL NOT NULL PRIMARY KEY,
	teacher_id INTEGER NOT NULL REFERENCES teacher(id)
)
CREATE TABLE assistant(
id SERIAL NOT NULL PRIMARY KEY,
	teacher_id INTEGER NOT NULL REFERENCES teacher(id)
)
CREATE TABLE curator(
id SERIAL NOT NULL PRIMARY KEY,
	teacher_id INTEGER NOT NULL REFERENCES teacher(id)
)
CREATE TABLE dean(
id SERIAL NOT NULL PRIMARY KEY,
	teacher_id INTEGER NOT NULL REFERENCES teacher(id)
)
CREATE TABLE faculty(
id SERIAL NOT NULL PRIMARY KEY,
	building INTEGER NOT NULL CHECK(building >= 1 and building <= 5),
	name VARCHAR(100) NOT NULL CHECK(LENGTH(name) > 0) UNIQUE,
	dean_id INTEGER NOT NULL REFERENCES dean(id)
)
CREATE TABLE department(
id SERIAL NOT NULL PRIMARY KEY,
	building INTEGER NOT NULL CHECK(building >= 1 and building <= 5),
	name VARCHAR(100) NOT NULL CHECK(LENGTH(name) > 0) UNIQUE,
	faculty_id INTEGER NOT NULL REFERENCES faculty(id),
	head_id INTEGER NOT NULL REFERENCES head(id)
)
CREATE TABLE groups(
id SERIAL NOT NULL PRIMARY KEY,
	name VARCHAR(100) NOT NULL CHECK(LENGTH(name) > 0) UNIQUE,
	year INTEGER NOT NULL CHECK(year >= 1 and year <= 5),
	department_id INTEGER NOT NULL REFERENCES department(id)
)
CREATE TABLE group_curator(
id SERIAL NOT NULL PRIMARY KEY,
	curator_id INTEGER NOT NULL REFERENCES curator(id),
	group_id INTEGER NOT NULL REFERENCES groups(id)
)
CREATE TABLE group_lecture(
id SERIAL NOT NULL PRIMARY KEY,
	group_id INTEGER NOT NULL REFERENCES groups(id),
	lecture_id INTEGER NOT NULL REFERENCES lecture(id)
)

INSERT INTO teacher(name, surname) VALUES('Maria', 'Ivanova')
INSERT INTO teacher(name, surname) VALUES('Aleksandr', 'Petrov')
INSERT INTO teacher(name, surname) VALUES('Gennadiy', 'Shishkin')
INSERT INTO teacher(name, surname) VALUES('Petr',  'Niyazov')
INSERT INTO teacher(name, surname) VALUES('Nikolay', 'Ahmedov')

INSERT INTO subject(name) VALUES('physics')
INSERT INTO subject(name) VALUES('matematics')
INSERT INTO subject(name) VALUES('phylophers')
INSERT INTO subject(name) VALUES('IT')
INSERT INTO subject(name) VALUES('biologists')

INSERT INTO lecture(subject_id, teacher_id) VALUES(1, 1);
INSERT INTO lecture(subject_id, teacher_id) VALUES(2, 2);
INSERT INTO lecture(subject_id, teacher_id) VALUES(3, 3);
INSERT INTO lecture(subject_id, teacher_id) VALUES(4, 4);
INSERT INTO lecture(subject_id, teacher_id) VALUES(5, 5);

INSERT INTO lecture_room(building, name) VALUES(1, 101);
INSERT INTO lecture_room(building, name) VALUES(2, 202);
INSERT INTO lecture_room(building, name) VALUES(3, 303);
INSERT INTO lecture_room(building, name) VALUES(4, 404);
INSERT INTO lecture_room(building, name) VALUES(5, 505);

INSERT INTO head(teacher_id) VALUES (1)
INSERT INTO head(teacher_id) VALUES (2)

INSERT INTO dean(teacher_id) VALUES(4)

INSERT INTO assistant(teacher_id) VALUES (3)
INSERT INTO assistant(teacher_id) VALUES (5)

INSERT INTO curator(teacher_id) VALUES (3)
INSERT INTO curator(teacher_id) VALUES (5)

INSERT INTO faculty(building, name, dean_id) VALUES(1, 'physics', 1);
INSERT INTO faculty(building, name, dean_id) VALUES(2, 'matematics', 1);
INSERT INTO faculty(building, name, dean_id) VALUES(3, 'phylophers', 1);
INSERT INTO faculty(building, name, dean_id) VALUES(4, 'IT', 1);
INSERT INTO faculty(building, name, dean_id) VALUES(5, 'biologists', 1);

INSERT INTO department(building, name, faculty_id, head_id) VALUES(1, 'physics', 1, 2);
INSERT INTO department(building, name, faculty_id, head_id) VALUES(2, 'matematics', 2, 1);
INSERT INTO department(building, name, faculty_id, head_id) VALUES(3, 'phylophers', 3, 1);
INSERT INTO department(building, name, faculty_id, head_id) VALUES(4, 'IT', 4, 2);
INSERT INTO department(building, name, faculty_id, head_id) VALUES(5, 'biologists', 5, 2);

INSERT INTO groups(name, year, department_id) VALUES('physics', 1,2);
INSERT INTO groups(name, year, department_id) VALUES('matematics', 3, 3);
INSERT INTO groups(name, year, department_id) VALUES('phylophers', 2, 4);
INSERT INTO groups(name, year, department_id) VALUES('IT', 5, 5);
INSERT INTO groups(name, year, department_id) VALUES('biologists', 1, 6);

INSERT INTO group_curator(curator_id, group_id) VALUES(1, 2);
INSERT INTO group_curator(curator_id, group_id) VALUES(2, 3);
INSERT INTO group_curator(curator_id, group_id) VALUES(1, 4);
INSERT INTO group_curator(curator_id, group_id) VALUES(2, 5);
INSERT INTO group_curator(curator_id, group_id) VALUES(2, 6);

INSERT INTO shedule(class, day_of_week, week, lecture_id, lecture_room_id) VALUES(2, 1, 3, 1, 4);
INSERT INTO shedule(class, day_of_week, week, lecture_id, lecture_room_id) VALUES(4, 5, 5, 4, 2);
INSERT INTO shedule(class, day_of_week, week, lecture_id, lecture_room_id) VALUES(1, 3, 2, 4, 5);
INSERT INTO shedule(class, day_of_week, week, lecture_id, lecture_room_id) VALUES(5, 4, 1, 5, 3);
INSERT INTO shedule(class, day_of_week, week, lecture_id, lecture_room_id) VALUES(3, 2, 4, 2, 1);

INSERT INTO group_lecture(group_id, lecture_id) VALUES(2, 1);
INSERT INTO group_lecture(group_id, lecture_id) VALUES(3, 2);
INSERT INTO group_lecture(group_id, lecture_id) VALUES(4, 3);
INSERT INTO group_lecture(group_id, lecture_id) VALUES(5, 4);
INSERT INTO group_lecture(group_id, lecture_id) VALUES(6, 5);

1) SELECT lecture_room.name FROM lecture_room
   JOIN teacher ON teacher.id = lecture_room.id AND teacher.name = 'Aleksandr'

2) SELECT teacher.surname FROM teacher
  JOIN groups ON teacher.id = groups.id and groups.name = 'IT'

3) SELECT teacher.surname FROM teacher
   JOIN groups ON teacher.id = groups.id and groups.name = 'IT'

4) SELECT teacher.surname FROM teacher
   JOIN shedule ON shedule.id = teacher.id and shedule.day_of_week != 1

5) SELECT CONCAT(lecture_room.name, lecture_room.building) FROM lecture_room
   JOIN shedule ON lecture_room.id = shedule.id and shedule.class = 3 and shedule.day_of_week = 3 and week = 2

7) SELECT faculty.building, department.building, lecture_room.building FROM faculty
   JOIN department ON department.id = faculty.id
   JOIN lecture_room ON lecture_room.id = faculty.id

8) SELECT CONCAT(name, ' ', surname) FROM teacher
   FULL OUTER JOIN dean ON dean.id = teacher.id
   FULL OUTER JOIN head ON head.id = teacher.id
   FULL OUTER JOIN curator ON curator.id = teacher.id
   FULL OUTER JOIN assistant ON assistant.id = teacher.id
   Выводится только одна таблица, со всем списком преподавателей, не знаю, что не так, если напишите, пожалуйста)
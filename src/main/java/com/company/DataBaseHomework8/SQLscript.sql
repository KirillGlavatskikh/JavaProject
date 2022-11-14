CREATE TABLE action(
id SERIAL NOT NULL PRIMARY KEY,
	name VARCHAR(100) NOT NULL CHECK(LENGTH(name) > 0) UNIQUE
)
CREATE TABLE teacher_added_info(
id SERIAL NOT NULL PRIMARY KEY,
	employment_date DATE NOT NULL CHECK(employment_date >= '01.01.1990'),
	name VARCHAR NOT NULL CHECK(LENGTH(name) > 0),
	salary MONEY NOT NULL CHECK(salary > 0::MONEY),
	surname VARCHAR NOT NULL CHECK(LENGTH(surname) > 0),
	manipulation_id INTEGER NOT NULL REFERENCES teacher_manipulation(id)
)
CREATE TABLE teacher_delete_info(
id SERIAL NOT NULL PRIMARY KEY,
	employment_date DATE NOT NULL CHECK(employment_date >= '01.01.1990'),
	name VARCHAR NOT NULL CHECK(LENGTH(name) > 0),
	salary MONEY NOT NULL CHECK(salary > 0::MONEY),
	surname VARCHAR NOT NULL CHECK(LENGTH(surname) > 0),
	manipulation_id INTEGER NOT NULL REFERENCES teacher_manipulation(id)
)
CREATE TABLE teacher_manipulation(
id SERIAL NOT NULL PRIMARY KEY,
	date DATE NOT NULL CHECK(date <= now()),
	action_id INTEGER NOT NULL REFERENCES action(id),
	teacher_id INTEGER NOT NULL REFERENCES teacher(id)
)
CREATE TABLE teacher(
id SERIAL NOT NULL PRIMARY KEY,
	employment_date DATE NOT NULL CHECK(employment_date > '01.01.1990'),
	name VARCHAR NOT NULL CHECK(LENGTH(name) > 0),
	salary MONEY NOT NULL CHECK(salary > 0::MONEY),
	surname VARCHAR NOT NULL CHECK(LENGTH(surname) > 0)
)

INSERT INTO action(name) VALUES('устройтсво')
INSERT INTO action(name) VALUES('увольнение')

INSERT INTO teacher(employment_date, name, salary, surname)	VALUES('20.03.1999', 'Ivan', 35000, 'Ivanov')
INSERT INTO teacher(employment_date, name, salary, surname)	VALUES('28.09.2007', 'Olga', 33000, 'Petrova')
INSERT INTO teacher(employment_date, name, salary, surname)	VALUES('06.11.2012', 'Maria', 40000, 'Vasileva')

INSERT INTO teacher_manipulation(date, action_id, teacher_id) VALUES('20.03.1999', 1, 1)
INSERT INTO teacher_manipulation(date, action_id, teacher_id) VALUES('28.09.2007', 1, 1)
INSERT INTO teacher_manipulation(date, action_id, teacher_id) VALUES('06.11.2012', 2, 1)

INSERT INTO teacher_delete_info(employment_date, name, salary, surname, manipulation_id) VALUES('06.11.2012', 'Maria', 40000, 'Vasileva', 3)

INSERT INTO teacher_added_info(employment_date, name, salary, surname, manipulation_id) VALUES('20.03.1999', 'Ivan', 35000, 'Ivanov', 1)
INSERT INTO teacher_added_info(employment_date, name, salary, surname, manipulation_id) VALUES('28.09.2007', 'Olga', 33000, 'Petrova', 2)

CREATE TABLE faculty(
id SERIAL NOT NULL PRIMARY KEY,
	financing MONEY NOT NULL,
	name VARCHAR NOT NULL
)
INSERT INTO faculty(financing, name) VALUES(50000, 'name')

1) Создать триггер, который позволяет только увеличивать размер фонда финансирования факультета.
CREATE FUNCTION increased_funding() RETURNS trigger AS
$increased_funding$
BEGIN
IF NEW.financing < OLD.financing THEN
RAISE EXCEPTION 'Значение меньше предыдущего';
END IF;
RETURN NEW;
END;
$increased_funding$ LANGUAGE plpgsql;

CREATE TRIGGER increased_funding
BEFORE UPDATE ON faculty
FOR EACH ROW
WHEN (OLD.financing > NEW.financing)
EXECUTE PROCEDURE increased_funding();

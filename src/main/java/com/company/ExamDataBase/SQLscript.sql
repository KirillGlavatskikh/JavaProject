CREATE TABLE country(
id SERIAL NOT NULL PRIMARY KEY,
	name VARCHAR(50) NOT NULL CHECK(LENGTH(name) > 0) UNIQUE
)
CREATE TABLE shop(
id SERIAL NOT NULL PRIMARY KEY,
	name VARCHAR NOT NULL CHECK(LENGTH(name) > 0),
	country_id INTEGER NOT NULL REFERENCES country(id)
)
CREATE TABLE thema(
id SERIAL NOT NULL PRIMARY KEY,
	name VARCHAR(100) NOT NULL CHECK(LENGTH(name) > 0) UNIQUE
)
CREATE TABLE author(
id SERIAL NOT NULL PRIMARY KEY,
	name VARCHAR NOT NULL CHECK(LENGTH(name) > 0),
	surname VARCHAR NOT NULL CHECK(LENGTH(surname) > 0),
	country_id INTEGER NOT NULL REFERENCES country(id)
)
CREATE TABLE book(
id SERIAL NOT NULL PRIMARY KEY,
	name VARCHAR NOT NULL CHECK(LENGTH(name) > 0),
	page INTEGER NOT NULL CHECK(page > 0),
	price MONEY NOT NULL CHECK(price >= 0::MONEY),
	publish_date DATE NOT NULL CHECK(publish_date <= now()),
	author_id INTEGER NOT NULL REFERENCES author(id),
	thema_id INTEGER NOT NULL REFERENCES thema(id)
)
CREATE TABLE sale(
id SERIAL NOT NULL PRIMARY KEY,
	price MONEY NOT NULL CHECK(price >= 0::MONEY),
	quantity INTEGER NOT NULL CHECK(quantity > 0),
	sale_date DATE NOT NULL CHECK(sale_date <= now()) DEFAULT now(),
	book_id INTEGER NOT NULL REFERENCES book(id),
	shop_id INTEGER NOT NULL REFERENCES shop(id)
)

INSERT INTO country(name) VALUES ('Russia')
INSERT INTO country(name) VALUES ('USA')
INSERT INTO country(name) VALUES ('Belorussia')

INSERT INTO shop(name, country_id) VALUES('Book shop RUS', 1)
INSERT INTO shop(name, country_id) VALUES('Book shop USA', 2)
INSERT INTO shop(name, country_id) VALUES('Book shop BEL', 3)

INSERT INTO thema(name) VALUES('Поэзия')
INSERT INTO thema(name) VALUES('IT')

INSERT INTO author(name, surname, country_id) VALUES('Sergey', 'Esenin', 1)
INSERT INTO author(name, surname, country_id) VALUES('Gerbert', 'Shildt', 2)
INSERT INTO author(name, surname, country_id) VALUES('Yanka', 'Kupala', 3)

INSERT INTO book(name, page, price, publish_date, author_id, thema_id) VALUES('Исповедь хулигана', 320, 500, '20.02.1920', 1, 1)
INSERT INTO book(name, page, price, publish_date, author_id, thema_id) VALUES('Java', 1500, 2000, '12.08.2018', 2, 2)
INSERT INTO book(name, page, price, publish_date, author_id, thema_id) VALUES('Павлинка', 688, 700, '03.06.1969', 3, 1)

INSERT INTO sale(price, quantity, sale_date, book_id, shop_id) VALUES(2000, 4, '15.09.2022', 1, 1)
INSERT INTO sale(price, quantity, sale_date, book_id, shop_id) VALUES(20000, 10, '01.10.2022', 2, 2)
INSERT INTO sale(price, quantity, sale_date, book_id, shop_id) VALUES(3500, 5, '01.09.2022', 3, 3)

1) Показать все книги, количество страниц в которых больше 500, но меньше 650.
   SELECT * FROM book WHERE book.page BETWEEN 500 AND 750

2) Показать все книги, в которых первая буква названия либо «А», либо «З».
   SELECT * FROM book WHERE book.name LIKE('И%') OR book.name LIKE('П%')

3) Показать все книги жанра «Детектив», количество проданных книг более 30 экземпляров.
   SELECT * FROM book
   JOIN thema ON thema.id = book.thema_id AND thema.name = 'Поэзия'
   JOIN sale ON book.id = sale.book_id AND sale.quantity > 4

4) Показать все книги, в названии которых есть слово «Microsoft», но нет слова «Windows».
   SELECT * FROM book WHERE book.name LIKE('%Павлинка%') AND book.name NOT LIKE('%Java%')

5) Показать все книги (название, тематика, полное имя автора в одной ячейке), цена одной страницы которых меньше 65 копеек.
   SELECT CONCAT(book.name, ' ', thema.name, ' ', author.name, ' ', author.surname) FROM book, thema, author
   WHERE book.thema_id = thema.id AND author.id = book.author_id AND book.price / book.page < 1.2::MONEY

6) Показать все книги, название которых состоит из 4 слов.
   SELECT * FROM book WHERE CARDINALITY(STRING_TO_ARRAY(book.name, ' ')) = 2

7) Показать информацию о продажах в следующем виде:
   ▷ Название книги, но, чтобы оно не содержало букву «А».
   ▷ Тематика, но, чтобы не «Программирование».
   ▷ Автор, но, чтобы не «Герберт Шилдт».
   ▷ Цена, но, чтобы в диапазоне от 10 до 20 гривен.
   ▷ Количество продаж, но не менее 8 книг.
   ▷ Название магазина, который продал книгу, но он не
   должен быть в Украине или России
   SELECT book.name, thema.name, CONCAT(author.name, ' ', author.surname), book.price,sale.quantity FROM sale
   JOIN book ON sale.book_id = book.id AND book.name NOT LIKE('%a%')
   AND book.price BETWEEN 300::MONEY AND 1000::MONEY
   JOIN thema ON book.thema_id = thema.id AND thema.name != 'IT'
   JOIN author ON book.author_id = author.id AND author.name != 'Gerbert'

8) Показать следующую информацию в два столбца (числа
   в правом столбце приведены в качестве примера):
   ▷ Количество авторов: 14
   ▷ Количество книг: 47
   ▷ Средняя цена продажи: 85.43 грн.
   ▷ Среднее количество страниц: 650.6.
   SELECT 'Количество авторов', COUNT(*) FROM author
   UNION
   SELECT 'Количество книг', COUNT(*) FROM book
   UNION
   SELECT 'Средняя цена продажи', AVG(book.price::NUMERIC) FROM book
   UNION
   SELECT 'Среднее количество страниц', AVG(book.page) FROM book

9) Показать тематики книг и сумму страниц всех книг по каждой из них.
   SELECT thema.name, SUM(book.page) FROM thema, book WHERE book.thema_id = thema.id GROUP BY thema.name

10) Показать количество всех книг и сумму страниц этих книг по каждому из авторов.
    SELECT CONCAT(author.name, ' ', author.surname), COUNT(book.name), SUM(book.page) FROM book, author
    WHERE book.author_id = author.id GROUP BY author.id

11) Показать книгу тематики «Программирование» с наибольшим количеством страниц.
    SELECT book.name FROM book, thema WHERE book.thema_id = thema.id AND thema.name = 'IT'
    ORDER BY book.page DESC LIMIT 1

12) Показать среднее количество страниц по каждой тематике, которое не превышает 400.
    SELECT thema.name, AVG(book.page) FROM book, thema WHERE book.thema_id = thema.id GROUP BY thema.name
    HAVING AVG(book.page) < 600

13) Показать сумму страниц по каждой тематике, учитывая только книги с количеством страниц более 400, и чтобы
    тематики были «Программирование», «Администрирование» и «Дизайн».
    SELECT SUM(book.page), thema.name FROM book, thema
    WHERE book.thema_id = thema.id AND book.page > 300 AND thema.name IN('IT', 'Поэзия')
    GROUP BY thema.name

14) Показать информацию о работе магазинов: что, где, кем, когда и в каком количестве было продано.
    SELECT country.name, shop.name, book.name, sale.sale_date, sale.quantity FROM sale
    JOIN shop ON shop.id = sale.shop_id
    JOIN book ON book.id = sale.book_id
    JOIN country ON country.id = shop.country_id

15) Показать самый прибыльный магазин.
    SELECT shop.name FROM shop,sale WHERE shop.id = sale.shop_id ORDER BY sale.price DESC LIMIT 1
-- Create database NODO;

USE NODO;

DROP table IF EXISTS Persons;
-- DROP TABLE IF EXISTS PersonClones;
DROP TABLE IF EXISTS Countrys;
DROP TABLE IF EXISTS SUPPLIERS;

#xoa truong ten trong bang nhan vien
ALTER TABLE NHANVIEN  DROP Ten;
#them truong ten vao bang nhan  vien
ALTER TABLE NHANVIEN ADD Ten NVARCHAR(30);
#them truong ten vao dau bang nhan vien
ALTER TABLE NHANVIEN ADD Ten VARCHAR(40) FIRST; 
#them truong ten vao sau hodem
ALTER TABLE NHANVIEN ADD Ten VARCHAR(40) AFTER HoDem;
#doi ten bang 
ALTER TABLE NHANVIEN RENAME TO NHANVIENIT;

-- CREATE TABLE
CREATE TABLE SUPPLIERS (
    id INT,
    name NVARCHAR(40)
);
INSERT INTO nodo.suppliers VALUES (1, "VN"), (2, "US"), (3, "UK"), (4, "Lao"), (5, "Mianma");
-- CREATE TABLE 
CREATE TABLE Countrys(
  id int,
  name nvarchar(40),
  primary key(id)
);


-- CREATE TABLE 
CREATE TABLE Persons(
id int AUTO_INCREMENT,
fullName nvarchar(255),
age int DEFAULT 18,
country_id int,
primary key(id),
foreign key(country_id) references Countrys(id)
);
-- CREATE TABLE 
-- CREATE TABLE PersonClones(
-- id int,
-- fullName nvarchar(255),
-- age int,
-- primary key(id)
-- );


-- INIT DATA
insert into countrys values (1, "VN"), (2, "US"), (3, "UK"), (4, "MA");


-- INSERT ĐƠN & DEFAULT
INSERT INTO persons (fullName, age, country_id) value("Anh", DEFAULT, 1);

-- INSERT ĐA
insert into persons (fullName, age, country_id) values("Nam", 19, 2), ("Quân", 18, 3), ("Hoàng", 18, 1);

-- Insert vào một bảng sử dụng thông tin từ bảng khác
-- + cần chỉ định cụ thể các trường

-- INSERT INTO PersonClones (fullName, age) SELECT fullName, age FROM persons;
-- + toàn bộ các trường
INSERT INTO PersonClones SELECT * FROM Persons;



-- SELECT 
-- + SELECT LIMIT 
SELECT * FROM persons;
SELECT * FROM persons LIMIT 3;
SELECT * FROM persons LIMIT 2,3;
-- + SELECT OFFSET + lLIMIT
SELECT * FROM persons LIMIT 3 offset 2;

-- + SELECT + WHERE
select * from persons where id = 1;

-- SELECT INTO
-- SELECT (fullName, age) INTO PersonClones FROM person; 

-- SELECT MAX
SELECT max(age) from persons;  

-- SELECT MIN
SELECT min(age) from persons;

-- SELECT DISTINCT
SELECT DISTINCT age FROM persons;

-- SELECT GROUP BY
SELECT * FROM nodo.persons p join nodo.countrys c on p.id = c.id GROUP BY (p.id);

-- SELECT OR
SELECT * FROM nodo.persons p where p.id = 1 or p.id = 2;

-- SELECT AND
SELECT * FROM nodo.persons p where p.id = 1 and p.age = 20;

-- SELECT IN
SELECT * FROM nodo.persons p where p.id in (1,2);

-- SELECT NOT IN
SELECT * FROM nodo.persons p where p.id not in (1,2);

-- SELECT HAVING
SELECT 
    *
FROM
    nodo.persons p
        JOIN
    nodo.countrys c ON p.id = c.id
GROUP BY (p.id)
HAVING p.age > 18;

-- UNION
SELECT * FROM nodo.countrys
UNION
SELECT * FROM nodo.suppliers;

-- UNION ALL
SELECT * FROM nodo.countrys
UNION ALL
SELECT * FROM nodo.suppliers;


-- INNER JOIN 
SELECT c.name FROM nodo.countrys c JOIN nodo.suppliers s ON c.name = s.name;

-- LEFT JOIN 
SELECT * FROM nodo.countrys c LEFT JOIN nodo.suppliers s ON c.name = s.name;

-- RIGHT JOIN 
SELECT * FROM nodo.countrys c RIGHT JOIN nodo.suppliers s ON c.name = s.name;

-- FULL JOIN 
SELECT * FROM nodo.countrys c LEFT JOIN nodo.suppliers s ON c.name = s.name
UNION
SELECT * FROM nodo.countrys c RIGHT JOIN nodo.suppliers s ON c.name = s.name;

-- TÍCH ĐỀ CÁC countrys
SELECT * FROM nodo.persons;
SELECT * FROM nodo.countrys;
SELECT * FROM nodo.persons CROSS JOIN nodo.countrys;

-- SUB QUERY
SELECT * FROM nodo.suppliers s WHERE s.name IN (SELECT c.name FROM nodo.countrys c);



-- UPDATE ĐƠN
UPDATE nodo.countrys SET nodo.countrys.name = "00000" WHERE nodo.countrys.id = 1;
-- UPDATE ĐA
UPDATE nodo.persons SET nodo.persons.fullName = "Edit name", nodo.persons.age = 20 WHERE nodo.persons.id = 1;
SELECT * FROM nodo.countrys;

-- DELETE ĐƠN
DELETE FROM nodo.persons WHERE nodo.persons.id = 1;
DELETE FROM nodo.persons WHERE nodo.persons.age = 20 AND nodo.persons.fullName = "abc"; 

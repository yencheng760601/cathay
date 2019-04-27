DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
id int(6) AUTO_INCREMENT PRIMARY KEY ,
name varchar(10),
sex int(1),
mobile_phone_no varchar(20),
address varchar(40),
age int(3),
create_date date,
last_update_date date,
dept_no int(2)
) DEFAULT CHARSET=utf8
;
DROP TABLE IF EXISTS dept;

CREATE TABLE dept(
dept_no int(2) AUTO_INCREMENT PRIMARY KEY,
dept_name varchar(40)
) DEFAULT CHARSET=utf8;
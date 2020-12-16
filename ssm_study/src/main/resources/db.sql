create database chapter20_ssm;
use chapter20_ssm;
create table tb_loginUser
(
   userName varchar(30) primary key,
   loginPwd varchar(15) not null,
   userType int
);

insert into tb_loginUser(userName,loginPwd,userType) values('ace','123456',1);
create table tb_department
(
  id varchar(15) primary key,
  name varchar(30) not null unique
);
insert into tb_department(id,name) values('10001','Java开发部');
insert into tb_department(id,name) values('10002','测试部');
insert into tb_department(id,name) values('10003','Python开发部');
insert into tb_department(id,name) values('10004','BigData开发部');
insert into tb_department(id,name) values('10005','AI人工智能开发部');
create table tb_employee
(
  id varchar(15) primary key,
  name varchar(20) not null,
  gender boolean,
  hireDate date,
  salary int,
  dept_id varchar(15),
  constraint tb_employee_dept_id_FK FOREIGN KEY(dept_id) REFERENCES tb_department(id)
);

insert into tb_employee(id,name,gender,hireDate,salary,dept_id) values('11111','李晓明',true,'2003-3-5',8000,'10001');
insert into tb_employee(id,name,gender,hireDate,salary,dept_id) values('22222','应毅',true,'2004-3-5',10000,'10004');
insert into tb_employee(id,name,gender,hireDate,salary,dept_id) values('33333','李菲',false,'2006-3-5',8000,'10002');
insert into tb_employee(id,name,gender,hireDate,salary,dept_id) values('44444','圣文顺',true,'2004-3-5',8000,'10001');
insert into tb_employee(id,name,gender,hireDate,salary,dept_id) values('55555','吴德',true,'2003-3-5',8000,'10003');
create table blood_bank_admin (user_name varchar2(50) primary key ,password varchar2(20) not null);
select * from donor;

alter table client_side rename column las_tname to last_name ;

select * from medicalperson;

desc medicalperson
select * from blood_transaction;
select * from blooddonor;
select * from client_side;

select * from blood_details;
select * from blood_bank_admin;

drop table donor cascade constraints;


create table donor_details(

first_name varchar2(50) not null,
last_name varchar2(50) not null,
address varchar2(100) not null,
adharcard number(20)  primary key,
phone varchar2(20) not null,
age number (5) not null,
blood_type varchar2(5));

-----------------------
create table  medicalperson (mdpreson_id number(11) GENERATED ALWAYS AS IDENTITY START WITH 1 primary key,
first_name varchar2(50) not null,
last_name varchar2(50) not null,
address varchar2(100) not null,
email varchar2(100) unique ,
phone varchar2(20) not null,
age number (5) not null,
blood_type varchar2(5));
-------------------------
create table client_side (client_id number(11) GENERATED ALWAYS AS IDENTITY START WITH 1 primary key,
first_name varchar2(50) not null,
last_name varchar2(50) not null,
address varchar2(100) not null,
email varchar2(100) unique ,
phone varchar2(20) not null,
age number (5) not null,
blood_type varchar2(5));
---------------------------
create table blood_bank_admin (admin_id number(11) GENERATED ALWAYS AS IDENTITY START WITH 1 primary key,
user_name varchar2(50) unique,
password varchar2(50)not null);
--------------------------------
create table blood_details(blood_group varchar2(50) primary key,
accept_blood varchar2(50) not null ,
received varchar2(50));
---------------------------
create table blood_transaction (transact_id number(11) GENERATED ALWAYS AS IDENTITY START WITH 1 primary key ,
mdpreson_id number (11)not null,
date_out date not null, 
quantity int not null,
blood_type varchar2(5) not null,
blood_id number(11) not null,
 foreign key (mdpreson_id) references medicalperson(mdpreson_id),
 foreign key (blood_id) references blooddonor(blood_id));
---------------------------
create table  blooddonor (blood_id number(11)GENERATED ALWAYS AS IDENTITY START WITH 1 primary key,
donor_id  number (11)not null,
date_donated date not null,
quantity int not null ,
foreign key (donor_id) references donor(donor_id) );
-------------------
select * from donor;
desc donor
insert into donor (first_name,last_name,address,email,phone,age,blood_type,password)values('munis','waran','chennai','munisram6@gmail.com','9894688836',24,'O-','050476ram');
commit
delete from center;
create table center (center_id number(11) primary key ,
center_name varchar2(50) not null,
address varchar2(100) unique);
-------------------------
create table booking (book_id number(11)GENERATED ALWAYS AS IDENTITY START WITH 1 primary key,
adharcard number(20) not null,
 address varchar2(100) not null,
  book_date date not null ,
  blood_type varchar2(10) not null,
  foreign key (adharcard) references donor_details(adharcard) );
 ----------------------------
 
 select * from donor_details;
 
 select * from booking;
 desc donor_details
 select * from admin;
 select * from blood_details;
 
drop table   blood_details cascade constraints;

create table blood_details (blood_id number(12)GENERATED ALWAYS AS IDENTITY START WITH 1 primary key ,
blood_type varchar2(20) not null ,
adharcard number(20) not null ,
unit number(10) not null,
price number(11)not null);

desc blood_details
select * from blood_details;
select * from blood_stack;
select * from booking;
create table blood_stack(stack_id number(11)GENERATED ALWAYS AS IDENTITY START WITH 1 primary key ,
blood_type varchar2(20)unique ,
quantity number(11) not null );
insert into blood_stack (blood_type,quantity)values('ab+',1);


select MONTHS_BETWEEN(current_timestamp,'17-09-2021')*30
from dual;
create table seeker_details(id number(12)GENERATED ALWAYS AS IDENTITY START WITH 1 primary key ,
first_name varchar2(50)not null,
last_name varchar2(50) not null,
address varchar2(100) not null,
phone_number number(20) not null,
patient_id number(20) not null,
hospital_name varchar2(100) not null,
blood_type varchar2(20) not null,
unit number(11) not null);
select * from seeker_details;
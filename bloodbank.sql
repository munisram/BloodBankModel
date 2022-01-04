
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
donor_date date not null,
blood_type varchar2(5) not null);


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

--------------------------------
/*create table blood_details(blood_group varchar2(50) primary key,
accept_blood varchar2(50) not null ,
received varchar2(50));*/
---------------------------
/*create table blood_transaction (transact_id number(11) GENERATED ALWAYS AS IDENTITY START WITH 1 primary key ,
mdpreson_id number (11)not null,
date_out date not null, 
quantity int not null,
blood_type varchar2(5) not null,
blood_id number(11) not null,
 foreign key (mdpreson_id) references medicalperson(mdpreson_id),
 foreign key (blood_id) references blooddonor(blood_id));*/
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
--commit


-------------------------
create table booking (book_id number(11)GENERATED ALWAYS AS IDENTITY START WITH 1 primary key,
adharcard number(20) not null,
 address varchar2(100) not null,
  book_date date not null ,
  blood_type varchar2(10) not null,
  blood_collect_choice varchar2(100) not null,
  foreign key (adharcard) references donor_details(adharcard) );
 ----------------------------
 
 select * from donor_details;
 
 select * from booking;
 desc donor_details
 select * from admin;
 select * from blood_details;
 
drop table  blood_bank_admin cascade constraints;

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
quantity number(11) not null,
unit_price number(20) not null);
/
insert into blood_stack (blood_type,quantity,unit_price)values('ab-',1,1200);
/
update blood_stack set quantity=30 where blood_type='bombay';
select * from blood_stack;
--drop table blood_stack cascade constraints;

--select MONTHS_BETWEEN(current_timestamp,'17-09-2021')*30
--from dual;


create table seeker_details(id number(12)GENERATED ALWAYS AS IDENTITY START WITH 1 primary key ,
first_name varchar2(50)not null,
last_name varchar2(50) not null,
address varchar2(100) not null,
phone_number number(20) not null,
password varchar2(100) not null,
patient_id number(20) not null ,
hospital_name varchar2(100) not null,
blood_type varchar2(20) not null );


drop table seeker_details cascade constraints;
select * from seeker_details;
desc seeker_details



create table request_details (request_id number(11)GENERATED ALWAYS AS IDENTITY START WITH 1 primary key ,
hospital_name varchar2(100) not null,
blood_type varchar2(50) not null,
unit number(11) not null,
blood_collector_name varchar2(50) not null,
phone_number number(20) not null,
adharcard_number number(20) not null,
request_date date not null);

select * from request_details;
/
drop  table request_details cascade constraints;

desc request_details
commit;

create table billing (bill_id number(20) GENERATED ALWAYS AS IDENTITY START WITH 1 primary key,
blood_type varchar2(20) not null,
seeker_id number(20)not null,
quantity number(11) not null,
price number(20) not null);






desc billing

select * from admin ;






create table admin (admin_id number(12) GENERATED ALWAYS AS IDENTITY START WITH 100 primary key,
email varchar2(50) unique,
password varchar2(50) not null,
wallet number(20)  default 0 not null);


insert into admin (email,password)values('munisram6@gmail.com','050476ram',);

update  admin set wallet=2000 where email='munisram6@gmail.com';
select * from admin;
drop table admin cascade CONSTRAINT ;

select* from blood_stack;
insert into blood_stack v;
select * from blood_stack;
desc blood_stack
select * from seeker_details;
--desc seeker_details;
select * from donor_details;
select * from request_details;
select * from billing;
select * from booking;
desc booking;
select * from billing;

---------------------------
/
select * from admin;

desc booking
select * from blood_details;
select * from donor_details inner join booking on donor_details.adharcard=booking.adharcard
where BLOOD_COLLECT_CHOICE='home';

select * from blood_details;
select * from booking;
--truncate table seeker_details;
commit;
select * from  admin;


select book_date+90 from booking where adharcard=123456789012;

select * from booking where to_char(book_date,'dd-mm-yyyy')between '27-12-2019' and '27-12-2021';
/
select QUANTITY from blood_stack where blood_type='o-';
--truncate table seeker_details;
select * from seeker_details;
desc seeker_details
update  admin set wallet=10000 where password ='050476ram';

select * from booking;
select * from blood_details;

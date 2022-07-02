create database gym  
CREATE TABLE vip_user(
	id INT PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(20) NOT NULL UNIQUE,
	`password` VARCHAR(32) NOT NULL,
	email VARCHAR(200),
	reg_date DATETIME);
CREATE TABLE cardholder(
	card_id INT PRIMARY KEY  AUTO_INCREMENT,
	card_user VARCHAR(20) NOT NULL UNIQUE,
	sex VARCHAR(10) NOT NULL,
	age INT NOT NULL,
	phone VARCHAR(30) NOT NULL,
	birthday DATE NOT NULL,
	balance DOUBLE NOT NULL DEFAULT 0.0,
	card_date DATETIME,
	FOREIGN KEY(card_user) REFERENCES vip_user(username));
CREATE TABLE card_type(
	card_id INT PRIMARY KEY AUTO_INCREMENT UNIQUE,
	card_name VARCHAR(20) NOT NULL UNIQUE,
	card_price double NOT NULL,
	indate int not null,
	discount double not null);
create table coach( 
	id int PRIMARY KEY auto_increment,
	coach_name varchar(20) not null,
	coach_sex varchar(10) not null,
	coach_age int,
	coach_phone varchar(20) not null,
	pre_address varchar(50),
	hire_date date not null,
	coach_state varchar(10) not null default '正常',
	teaching_age int not null default 0,
	salary double not null default 0);
CREATE TABLE course( 
	id INT PRIMARY KEY AUTO_INCREMENT,
	course_name VARCHAR(20) NOT NULL,
	course_price VARCHAR(10) NOT NULL,
	taught VARCHAR(10) NOT NULL,
	teach_time VARCHAR(50) not null,
	teach_space varchar(20) not null,
	course_state varchar(20) not null default '正常'
	)
create table equipment(
	id int PRIMARY KEY AUTO_INCREMENT,
	equ_name varchar(32) not null,
	`account` int not null,
	purchase double not null,
	merchant varchar(32),
	buy_time date ,
	equ_state varchar(20) not null default '正常');
create table goods(
	id int PRIMARY KEY AUTO_INCREMENT,
	g_name varchar(32) not null,
	g_price double not null,
	g_account int not null,
	g_brand varchar(32));
create table lost(
	id INT PRIMARY KEY AUTO_INCREMENT,
	l_name VARCHAR(32) NOT NULL,
	l_describe VARCHAR(120),
	l_type VARCHAR(20),
	phone VARCHAR(20),
	pick_date DATE,
	get_date DATE,
	state VARCHAR(20)
	);
create table notice(
	id int PRIMARY KEY AUTO_INCREMENT,
	`type` varchar(20),
	release_date date not null,
	change_date date);
create table manager(
	id int auto_increment primary key,
	m_name varchar(32) not null,
	`password` varchar(20) not null,
	state varchar(20) not null default '正常');
create table coach_login(
	id int auto_increment PRIMARY KEY,
	coa_name varchar(20) not null, 
	`password` varchar(32) not null,
	state varchar(20) );
create table coach_appointment(id INT AUTO_INCREMENT PRIMARY KEY,
				coach_name varchar(20) not null,
				user_name varchar(20) not null,
				coach_phone varchar(20) not null,
				user_phone varchar(20) not null,
				leisure varchar(32) not null,
				price double not null default 0,
				state varchar(20) default '等待预约')

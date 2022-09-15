use FitApp;
create Table Runner(R_id numeric primary key,
R_name varchar(255),
R_City varchar(255),
Duration_In_days numeric);

Create table City(C_id numeric primary key,
C_name varchar(255),
C_Region varchar(255));

create table DailyActivity(
R_id numeric ,
C_id numeric,
foreign key (R_id) references Runner(R_id),
foreign key (C_id) references City(C_id),
Distance numeric,
D_id numeric primary key,
D_Date varchar(255));

desc City;
desc dailyactivity;




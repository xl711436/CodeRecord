


CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `pwd` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `teacher` (
`id` int(10) not null,
`name` varchar(30) default null,
primary key (`id`)
) engine=innodb default charset=utf8

insert into teacher(`id`,`name`) values(1,'秦老师');


CREATE TABLE student(
`id` int(10) not null,
`name` varchar(30) default null,
`tid` int(10) default null,
primary key (`id`),
key `fktid` (`tid`),
constraint `fktid` foreign key (`tid`) references `teacher`(`id`)
) engine=innodb default charset=utf8

insert into student (`id`,`name`,`tid`) values ('1','小明','1');
insert into student (`id`,`name`,`tid`) values ('2','小红','1');
insert into student (`id`,`name`,`tid`)  values ('3','小张','1');
insert into student (`id`,`name`,`tid`) values ('4','小李','1');
insert into student (`id`,`name`,`tid`) values ('5','小王','1');



CREATE TABLE blog(
`id` varchar(30) not null,
`title` varchar(30) not null,
`author` varchar(30) not null,
`create_time` datetime not null,
`views` int(30) not null,
primary key (`id`)
) engine=innodb default charset=utf8
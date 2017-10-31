drop table if exists person;

create table person (
    id int auto_increment comment '主键id',
    create_time timestamp default current_timestamp comment "创建时间",
    update_time timestamp default current_timestamp on update current_timestamp comment "修改时间",
    is_deleted tinyint default 0 comment '是否逻辑删除，0表示未删除，1表示已删除',
	name varchar(10) comment '姓名',
	age tinyint unsigned comment '年龄',
	primary key(id)
)engine=innodb charset=utf8 comment "人表，测试用";
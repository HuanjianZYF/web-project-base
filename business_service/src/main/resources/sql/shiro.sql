drop table if exists user;
drop table if exists role;
drop table if exists permission;

create table user (
    id int auto_increment comment '主键id',
    create_time timestamp default current_timestamp comment "创建时间",
    update_time timestamp default current_timestamp on update current_timestamp comment "修改时间",
    is_deleted tinyint default 0 comment '是否逻辑删除，0表示未删除，1表示已删除',
    phone varchar(11) not null comment '手机号',
    password varchar(20) comment '密码',
    nick_name varchar(30) not null comment '昵称',
    avatar_url varchar(100) not null comment '头像',   
    primary key(id),
    index idx_phone(phone)
) charset=utf8 ENGINE=InnoDB;

create table role(
	id int auto_increment comment '主键id',
    create_time timestamp default current_timestamp comment "创建时间",
    update_time timestamp default current_timestamp on update current_timestamp comment "修改时间",
    is_deleted tinyint default 0 comment '是否逻辑删除，0表示未删除，1表示已删除',
	phone varchar(11) not null comment '手机号',
	role_name varchar(100) not null comment '角色名',
	primary key(id),
	index idx_phone(phone)
) charset=utf8 ENGINE=InnoDB;

create table permission(
  id int auto_increment comment '主键id',
  create_time timestamp default current_timestamp comment "创建时间",
  update_time timestamp default current_timestamp on update current_timestamp comment "修改时间",
  is_deleted tinyint default 0 comment '是否逻辑删除，0表示未删除，1表示已删除',
  role_name varchar(100) not null comment '角色名',
  permission varchar(100) not null comment '权限名',
  primary key(id),
  index idx_role_name(role_name)
) charset=utf8 ENGINE=InnoDB;

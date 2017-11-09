drop table if exists users;
drop table if exists user_roles;
drop table if exists roles_permissions;

create table users (
    id int auto_increment comment '主键id',
    create_time timestamp default current_timestamp comment "创建时间",
    update_time timestamp default current_timestamp on update current_timestamp comment "修改时间",
    is_deleted tinyint default 0 comment '是否逻辑删除，0表示未删除，1表示已删除',
    user_name varchar(100) not null comment '用户名',
    password varchar(100) not null comment '密码',
    password_salt varchar(100) comment '加密盐',
    primary key(id),
    index idx_username(username)
) charset=utf8 ENGINE=InnoDB;

create table user_roles(
	id int auto_increment comment '主键id',
    create_time timestamp default current_timestamp comment "创建时间",
    update_time timestamp default current_timestamp on update current_timestamp comment "修改时间",
    is_deleted tinyint default 0 comment '是否逻辑删除，0表示未删除，1表示已删除',
	user_name varchar(100) not null comment '用户名',
	role_name varchar(100) not null comment '角色名',
	primary key(id),
	unique index unidx_user_roles(username, role_name)
) charset=utf8 ENGINE=InnoDB;

create table roles_permissions(
  id int auto_increment comment '主键id',
  create_time timestamp default current_timestamp comment "创建时间",
  update_time timestamp default current_timestamp on update current_timestamp comment "修改时间",
  is_deleted tinyint default 0 comment '是否逻辑删除，0表示未删除，1表示已删除',
  role_name varchar(100) not null comment '角色名',
  permission varchar(100) not null comment '权限名',
  primary key(id),
  unique index unidx_roles_permissions(role_name, permission)
) charset=utf8 ENGINE=InnoDB;

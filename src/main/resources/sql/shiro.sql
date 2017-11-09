drop table if exists users;
drop table if exists user_roles;
drop table if exists roles_permissions;

create table users (
    id int auto_increment comment '����id',
    create_time timestamp default current_timestamp comment "����ʱ��",
    update_time timestamp default current_timestamp on update current_timestamp comment "�޸�ʱ��",
    is_deleted tinyint default 0 comment '�Ƿ��߼�ɾ����0��ʾδɾ����1��ʾ��ɾ��',
    user_name varchar(100) not null comment '�û���',
    password varchar(100) not null comment '����',
    password_salt varchar(100) comment '������',
    primary key(id),
    index idx_username(username)
) charset=utf8 ENGINE=InnoDB;

create table user_roles(
	id int auto_increment comment '����id',
    create_time timestamp default current_timestamp comment "����ʱ��",
    update_time timestamp default current_timestamp on update current_timestamp comment "�޸�ʱ��",
    is_deleted tinyint default 0 comment '�Ƿ��߼�ɾ����0��ʾδɾ����1��ʾ��ɾ��',
	user_name varchar(100) not null comment '�û���',
	role_name varchar(100) not null comment '��ɫ��',
	primary key(id),
	unique index unidx_user_roles(username, role_name)
) charset=utf8 ENGINE=InnoDB;

create table roles_permissions(
  id int auto_increment comment '����id',
  create_time timestamp default current_timestamp comment "����ʱ��",
  update_time timestamp default current_timestamp on update current_timestamp comment "�޸�ʱ��",
  is_deleted tinyint default 0 comment '�Ƿ��߼�ɾ����0��ʾδɾ����1��ʾ��ɾ��',
  role_name varchar(100) not null comment '��ɫ��',
  permission varchar(100) not null comment 'Ȩ����',
  primary key(id),
  unique index unidx_roles_permissions(role_name, permission)
) charset=utf8 ENGINE=InnoDB;

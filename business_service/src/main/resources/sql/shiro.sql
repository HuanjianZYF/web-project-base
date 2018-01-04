drop table if exists user;
drop table if exists role;
drop table if exists permission;

create table user (
    id int auto_increment comment '����id',
    create_time timestamp default current_timestamp comment "����ʱ��",
    update_time timestamp default current_timestamp on update current_timestamp comment "�޸�ʱ��",
    is_deleted tinyint default 0 comment '�Ƿ��߼�ɾ����0��ʾδɾ����1��ʾ��ɾ��',
    phone varchar(11) not null comment '�ֻ���',
    password varchar(20) comment '����',
    nick_name varchar(30) not null comment '�ǳ�',
    avatar_url varchar(100) not null comment 'ͷ��',   
    primary key(id),
    index idx_phone(phone)
) charset=utf8 ENGINE=InnoDB;

create table role(
	id int auto_increment comment '����id',
    create_time timestamp default current_timestamp comment "����ʱ��",
    update_time timestamp default current_timestamp on update current_timestamp comment "�޸�ʱ��",
    is_deleted tinyint default 0 comment '�Ƿ��߼�ɾ����0��ʾδɾ����1��ʾ��ɾ��',
	phone varchar(11) not null comment '�ֻ���',
	role_name varchar(100) not null comment '��ɫ��',
	primary key(id),
	index idx_phone(phone)
) charset=utf8 ENGINE=InnoDB;

create table permission(
  id int auto_increment comment '����id',
  create_time timestamp default current_timestamp comment "����ʱ��",
  update_time timestamp default current_timestamp on update current_timestamp comment "�޸�ʱ��",
  is_deleted tinyint default 0 comment '�Ƿ��߼�ɾ����0��ʾδɾ����1��ʾ��ɾ��',
  role_name varchar(100) not null comment '��ɫ��',
  permission varchar(100) not null comment 'Ȩ����',
  primary key(id),
  index idx_role_name(role_name)
) charset=utf8 ENGINE=InnoDB;

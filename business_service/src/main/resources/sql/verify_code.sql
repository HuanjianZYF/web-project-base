drop table if exists verify_code;

create table verify_code (
	id int auto_increment comment '����id',
    create_time timestamp default current_timestamp comment "����ʱ��",
    	update_time timestamp default current_timestamp on update current_timestamp comment "�޸�ʱ��",
    	is_deleted tinyint default 0 comment '�Ƿ��߼�ɾ����0��ʾδɾ����1��ʾ��ɾ��',
	phone varchar(11) not null unique comment '�ֻ���',
	code varchar(6) not null comment '6λ��֤��',
	send_time timestamp default current_timestamp not null comment '��֤�뷢��ʱ��',

	primary key(id),
	unique index uk_idx_phone(phone)
)ENGINE=InnoDB charset=utf8 comment "��֤��";
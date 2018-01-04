drop table if exists verify_code;

create table verify_code (
	id int auto_increment comment '主键id',
    create_time timestamp default current_timestamp comment "创建时间",
    	update_time timestamp default current_timestamp on update current_timestamp comment "修改时间",
    	is_deleted tinyint default 0 comment '是否逻辑删除，0表示未删除，1表示已删除',
	phone varchar(11) not null unique comment '手机号',
	code varchar(6) not null comment '6位验证码',
	send_time timestamp default current_timestamp not null comment '验证码发送时间',

	primary key(id),
	unique index uk_idx_phone(phone)
)ENGINE=InnoDB charset=utf8 comment "验证码";
create table usuarios(
	id serial primary key ,
	login varchar(100) not null,
	senha varchar(100) not null
)
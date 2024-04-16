create table remedio(
	id serial  primary key ,
	nome varchar(100) not null,
	via varchar(100) not null,
	lote varchar(100) not null,
	validade varchar(100) not null,
	quantidade integer not null,
	laboratorio varchar(100) not null
	
)
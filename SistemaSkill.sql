PRAGMA foreign_keys =on;

create table usuario(
id serial primary key,
email varchar(50) not null unique,
password varchar(50) not null
);

create table Skill(
id serial primary key,
imagem text not null,
nome text not null,
descricao text not null
);

create table usuario_skill(
id serial primary key,
nivel text not null,
skill_id integer,
usuario_id integer,
foreign key (usuario_id) references usuario(id),
foreign key (skill_id) references skill(id)
);

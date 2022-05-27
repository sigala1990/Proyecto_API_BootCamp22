use `heroku_daf29cddeb9aff5`;

drop table if exists usuario;
create table usuario (
id int auto_increment primary key,
nombre nvarchar(250),
email nvarchar(250)
);

drop table if exists editorial;
create table editorial (
id int auto_increment primary key,
nombre nvarchar(250));

drop table if exists libro;
create table libro (
id int auto_increment primary key,
autor nvarchar(250),
titulo nvarchar(250),
isbn nvarchar(250),
edad int,
categoria nvarchar(50),
duracion_reserva_dias int,
cantidad_veces_reservado int,
usuario_id int,
editorial_id int,
url_img nvarchar(200),
foreign key (editorial_id) references editorial(id) on delete cascade on update cascade,
foreign key (usuario_id) references usuario (id)on delete cascade on update cascade);

drop table if exists prestar;
create table prestar (
id int auto_increment primary key,
fecha_inicio datetime,
fecha_fin datetime,
usuario_id int,
libro_id int,
foreign key (usuario_id) references usuario (id)on delete cascade on update cascade,
foreign key (libro_id) references libro (id)on delete cascade on update cascade);

drop table if exists valorar;
create table valorar (
id int auto_increment primary key,
fecha datetime,
comentario nvarchar(1000),
usuario_id int,
libro_id int,
foreign key (usuario_id) references usuario(id)on delete cascade on update cascade,
foreign key (libro_id) references libro (id)on delete cascade on update cascade);

drop table if exists notificar;
create table notificar(
id int auto_increment primary key,
mensaje nvarchar(500),
fecha datetime,
usuario_emisor_id int,
usuario_receptor_id int,
foreign key (usuario_emisor_id) references usuario(id)on delete cascade  on update cascade,
foreign key (usuario_receptor_id) references usuario(id)on delete cascade on update cascade);

drop table if exists prestacion;
create table prestacion(
id int auto_increment primary key,
usuario_prestacion_id int,
libro_prestacion_id int,
prestar_id int,
foreign key (usuario_prestacion_id) references usuario(id)on delete cascade  on update cascade,
foreign key (prestar_id) references prestar(id)on delete cascade  on update cascade,
foreign key (libro_prestacion_id) references libro(id)on delete cascade on update cascade);


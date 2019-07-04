/*==============================================================*/
/* Nom de SGBD :  MySQL 5.0                                     */
/* Date de création :  03/07/2019 15:34:08                      */
/*==============================================================*/


/*==============================================================*/
/* Table : agencies                                             */
/*==============================================================*/
create table agencies
(
   agencies_id          int not null auto_increment,
   agencies_name        varchar(254),
   town                 varchar(254),
   quarter              varchar(254),
   primary key (agencies_id)
);

/*==============================================================*/
/* Table : bus_trips                                            */
/*==============================================================*/
create table bus_trips
(
   id_                  int not null,
   trips_id             int not null,
   primary key (id_, trips_id)
);

/*==============================================================*/
/* Table : buses                                                */
/*==============================================================*/
create table buses
(
   id_                  int not null auto_increment,
   bus_number           varchar(254),
   colour               varchar(254),
   num_of_sits          int,
   primary key (id_)
);

/*==============================================================*/
/* Table : mails                                                */
/*==============================================================*/
create table mails
(
   mails_id             int not null auto_increment,
   users_id             int,
   use_users_id         int not null,
   id_                  int,
   trips_id             int,
   mails_type           varchar(254),
   receiver_name        varchar(254),
   receiver_number      varchar(254),
   mail_state           varchar(254),
   mails_name           varchar(254),
   sender_name          varchar(254),
   sender_number        varchar(254),
   primary key (mails_id)
);

/*==============================================================*/
/* Table : operations                                           */
/*==============================================================*/
create table operations
(
   id_operations        int not null auto_increment,
   users_id             int,
   operations_name      varchar(254),
   operation_target     varchar(254),
   operation_date       datetime,
   primary key (id_operations)
);

/*==============================================================*/
/* Table : priviledges                                          */
/*==============================================================*/
create table priviledges
(
   users_id             int not null,
   idmenu               int not null,
   primary key (users_id, idmenu)
);

/*==============================================================*/
/* Table : reservations                                         */
/*==============================================================*/
create table reservations
(
   users_id             int not null,
   trips_id             int not null,
   reservation_date     datetime,
   quantity             int,
   primary key (users_id, trips_id)
);

/*==============================================================*/
/* Table : trips                                                */
/*==============================================================*/
create table trips
(
   trips_id             int not null auto_increment,
   agencies_id          int not null,
   users_id             int not null,
   age_agencies_id      int not null,
   departure            datetime,
   arrival              datetime,
   depart_agency        varchar(254),
   arrival_agency       varchar(254),
   trips_type           varchar(254),
   price                varchar(254),
   primary key (trips_id)
);

/*==============================================================*/
/* Table : users                                                */
/*==============================================================*/
create table users
(
   users_id             int not null auto_increment,
   agencies_id          int,
   use_users_id         int,
   first_name           varchar(254),
   last_name            varchar(254),
   lusers_ogin          varchar(254),
   users_password       varchar(254),
   users_role           varchar(254),
   users_status         varchar(254),
   email                varchar(254),
   id_card              varchar(254),
   gender               varchar(254),
   phone_num            varchar(254),
   adresse              varchar(254),
   photo                varchar(254),
   primary key (users_id)
);

/*==============================================================*/
/* Table : users_menu                                           */
/*==============================================================*/
create table users_menu
(
   idmenu               int not null auto_increment,
   use_idmenu           int,
   menu_name            varchar(254),
   menu_key             varchar(254),
   primary key (idmenu)
);

alter table bus_trips add constraint fk_has foreign key (id_)
      references buses (id_) on delete restrict on update restrict;

alter table bus_trips add constraint fk_has2 foreign key (trips_id)
      references trips (trips_id) on delete restrict on update restrict;

alter table mails add constraint fk_association_13 foreign key (id_, trips_id)
      references bus_trips (id_, trips_id) on delete restrict on update restrict;

alter table mails add constraint fk_users_maildischarge foreign key (users_id)
      references users (users_id) on delete restrict on update restrict;

alter table mails add constraint fk_users_mailsent foreign key (use_users_id)
      references users (users_id) on delete restrict on update restrict;

alter table operations add constraint fk_users_operations foreign key (users_id)
      references users (users_id) on delete restrict on update restrict;

alter table priviledges add constraint fk_accessed foreign key (idmenu)
      references users_menu (idmenu) on delete restrict on update restrict;

alter table priviledges add constraint fk_has_access foreign key (users_id)
      references users (users_id) on delete restrict on update restrict;

alter table reservations add constraint fk_is_reserved foreign key (trips_id)
      references trips (trips_id) on delete restrict on update restrict;

alter table reservations add constraint fk_reserves foreign key (users_id)
      references users (users_id) on delete restrict on update restrict;

alter table trips add constraint fk_agencies_tripdeparture foreign key (age_agencies_id)
      references agencies (agencies_id) on delete restrict on update restrict;

alter table trips add constraint fk_buses_triparrival foreign key (agencies_id)
      references agencies (agencies_id) on delete restrict on update restrict;

alter table trips add constraint fk_users_trips foreign key (users_id)
      references users (users_id) on delete restrict on update restrict;

alter table users add constraint fk_agencies_users foreign key (agencies_id)
      references agencies (agencies_id) on delete restrict on update restrict;

alter table users add constraint fk_parentusers_childusers foreign key (use_users_id)
      references users (users_id) on delete restrict on update restrict;

alter table users_menu add constraint fk_parentmenu_childmenu foreign key (use_idmenu)
      references users_menu (idmenu) on delete restrict on update restrict;


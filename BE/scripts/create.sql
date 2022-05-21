drop table if exists photos cascade;
drop sequence if exists photos_id_seq;
create sequence photos_id_seq start 1 increment 1;
create table photos (
                        photo_id int8 not null,
                        photo oid,
                        primary key (photo_id)
);
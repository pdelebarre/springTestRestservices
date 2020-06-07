\c
create table public.users
(
    id   uuid
        constraint users_pk
            primary key,
    name varchar not null
)
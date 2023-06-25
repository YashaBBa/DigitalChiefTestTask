create table digitachief.hibernate_sequence
(
    next_val bigint null

);


create table digitachief.university
(
    id                 int          not null
        primary key,
    city               varchar(255) null,
    country            varchar(255) null,
    founding_date      date         null,
    number_of_students int          null,
    name               varchar(255) null
);

create table digitachief.faculty
(
    id                int          not null
        primary key,
    count_of_students int          null,
    dean_name         varchar(255) null,
    name              varchar(255) null,
    founding_date     date         null,
    min_score         int          null,
    univers_id        int          null,
    constraint FKndt0speqadi7j5em94rncdeag
        foreign key (univers_id) references digitachief.university (id)
            on update cascade on delete cascade
);

create table digitachief.speciality
(
    id                int          not null
        primary key,
    count_of_students int          null,
    degree_level      varchar(255) null,
    founding_date     date         null,
    min_score         int          null,
    name              varchar(255) null,
    faculties_id      int          null,
    constraint FKhrpc3dyk1mmt3iff1j7yaa9gj
        foreign key (faculties_id) references digitachief.faculty (id)
            on update cascade on delete cascade
);


create sequence hibernate_sequence start with 1 increment by 1;
create table action
(
    id   bigint not null,
    name varchar(255),
    spel varchar(255),
    primary key (id)
);
create table deferred_events
(
    jpa_repository_state_id bigint not null,
    deferred_events         varchar(255)
);
create table guard
(
    id   bigint not null,
    name varchar(255),
    spel varchar(255),
    primary key (id)
);
create table state
(
    id                bigint not null,
    initial_state     boolean,
    kind              integer,
    machine_id        varchar(255),
    region            varchar(255),
    state             varchar(255),
    submachine_id     varchar(255),
    initial_action_id bigint,
    parent_state_id   bigint,
    primary key (id)
);
create table state_entry_actions
(
    jpa_repository_state_id bigint not null,
    entry_actions_id        bigint not null,
    primary key (jpa_repository_state_id, entry_actions_id)
);
create table state_exit_actions
(
    jpa_repository_state_id bigint not null,
    exit_actions_id         bigint not null,
    primary key (jpa_repository_state_id, exit_actions_id)
);
create table state_state_actions
(
    jpa_repository_state_id bigint not null,
    state_actions_id        bigint not null,
    primary key (jpa_repository_state_id, state_actions_id)
);
create table state_machine
(
    machine_id            varchar(255) not null,
    state                 varchar(255),
    state_machine_context blob,
    primary key (machine_id)
);
create table transition
(
    id         bigint not null,
    event      varchar(255),
    kind       integer,
    machine_id varchar(255),
    guard_id   bigint,
    source_id  bigint,
    target_id  bigint,
    primary key (id)
);
create table transition_actions
(
    jpa_repository_transition_id bigint not null,
    actions_id                   bigint not null,
    primary key (jpa_repository_transition_id, actions_id)
);
alter table deferred_events
    add constraint fk_state_deferred_events foreign key (jpa_repository_state_id) references state;
alter table state
    add constraint fk_state_initial_action foreign key (initial_action_id) references action;
alter table state
    add constraint fk_state_parent_state foreign key (parent_state_id) references state;
alter table state_entry_actions
    add constraint fk_state_entry_actions_a foreign key (entry_actions_id) references action;
alter table state_entry_actions
    add constraint fk_state_entry_actions_s foreign key (jpa_repository_state_id) references state;
alter table state_exit_actions
    add constraint fk_state_exit_actions_a foreign key (exit_actions_id) references action;
alter table state_exit_actions
    add constraint fk_state_exit_actions_s foreign key (jpa_repository_state_id) references state;
alter table state_state_actions
    add constraint fk_state_state_actions_a foreign key (state_actions_id) references action;
alter table state_state_actions
    add constraint fk_state_state_actions_s foreign key (jpa_repository_state_id) references state;
alter table transition
    add constraint fk_transition_guard foreign key (guard_id) references guard;
alter table transition
    add constraint fk_transition_source foreign key (source_id) references state;
alter table transition
    add constraint fk_transition_target foreign key (target_id) references state;
alter table transition_actions
    add constraint fk_transition_actions_a foreign key (actions_id) references action;
alter table transition_actions
    add constraint fk_transition_actions_t foreign key (jpa_repository_transition_id) references transition;

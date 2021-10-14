BEGIN TRANSACTION;

create table tournaments(
        tournament_ID serial primary key,
        tournament_name varchar (64) not null,
        tournament_description varchar (255),
        host_ID int not null,
        tournament_size int not null,
        tournament_date date not null,
        image varchar(255),
        foreign key (host_ID) references users (user_id)
        );
create table tournaments_users(
        tournament_ID int not null,
        user_ID int not null,
        constraint pk_tournaments_users primary key (tournament_ID, user_ID),
        constraint fk_tournament_ID foreign key (tournament_ID) references tournaments (tournament_ID),
        constraint fk_user_ID foreign key (user_ID) references users (user_ID)
        );
create table teams(
        team_ID serial primary key,
        tournament_ID int not null,
        team_name varchar(64) not null,
        foreign key (tournament_ID) references tournaments (tournament_ID)
        );
create table teams_users(
        team_id int not null,
        user_id int not null,
        constraint pk_teams_users primary key (team_id, user_id),
        constraint fk_team_id foreign key (team_id) references teams (team_id),
        constraint fk_user_id foreign key (user_id) references users (user_id)
        );
create table matches(
        match_id int not null,
        tournament_id int not null,
        home_id int,
        away_id int,
        winner_id int,
        next_match int,
        constraint pk_matches primary key (match_id, tournament_id),
        constraint fk_tournament_id foreign key (tournament_id) references tournaments (tournament_id)
        );
        create table invites(
        invite_id serial primary key,
        sent_user_id int not null,
        received_user_id int not null,
        tournament_id int not null,
        status_id int not null,
        constraint fk_sent_user_id foreign key (sent_user_id) references users (user_id),
        constraint fk_received_user_id foreign key (received_user_id) references users (user_id),
        constraint fk_tournament_id foreign key (tournament_id) references tournaments (tournament_id),
         foreign key (status_id) references status_types (status_id)
        );
        
COMMIT TRANSACTION;
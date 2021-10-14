package com.techelevator.dao;

import com.techelevator.model.Team;

import java.util.List;

public interface TeamDao {

    List<Team> findAllTeams();

    List<Team> findTeamsByTournamentID(int tournamentID);

    Team findTeamByID(int teamID);

    Team findTeamByName(String teamName);

    void createTeam(Team team);


}

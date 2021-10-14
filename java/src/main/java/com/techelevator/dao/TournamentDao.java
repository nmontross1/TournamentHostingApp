package com.techelevator.dao;

import com.techelevator.model.Tournament;

import java.util.List;

public interface TournamentDao {

    List<Tournament> findAllTournaments();

    Tournament findTournamentByID(int tournamentID);

    void createTournament(Tournament tournament);

    Tournament findTournamentByName(String tournamentName);

    void removeTournament(int tournamentID);

    List<Tournament> findMyTournamentsByUserID(int userID);

    List<Tournament> findTournamentBySearch(String searchText);

    void addUsersToFirstRound(List<Integer> userIDList, int tournamentID);

    void addUserToTournament(int userID, int tournamentID);
}

package com.techelevator.dao;

import com.techelevator.model.Match;
import com.techelevator.model.User;

import java.util.List;

public interface MatchDao {

    List<Match> findAllMatches();

    Match findMatchByID(int matchID, int tournamentID);

    void createMatch(Match match);

    Match assignWinner(int matchID, int winnerID, int tournamentID);

    Match assignHomeTeam(int previousMatchID, int tournamentID);

    Match assignAwayTeam(int previousMatchID, int tournamentID);

    Integer nextMatch(int currentMatchID, int tournamentID);

    List<Match> findMatchesByTournament(int tournamentID);

    void createAllMatches(int bracketSize, int tournamentID);

    List<String> getTournamentWinners(int tournamentID);

    void assignWinners(int tournamentID, String[] winners);
}

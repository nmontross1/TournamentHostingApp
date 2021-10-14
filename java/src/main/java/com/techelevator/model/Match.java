package com.techelevator.model;

public class Match {

    private int matchID;
    private int tournamentID;
    private int homeID;
    private int awayID;
    private int winnerID;
    private int nextMatchID;

    public Match() {
    }

    public Match(int matchID, int tournamentID, int homeID, int awayID) {
        this.matchID = matchID;
        this.tournamentID = tournamentID;
        this.homeID = homeID;
        this.awayID = awayID;
    }

    public Match(int matchID, int tournamentID) {
        this.matchID = matchID;
        this.tournamentID = tournamentID;
    }

    public int getMatchID() {
        return matchID;
    }

    public void setMatchID(int matchID) {
        this.matchID = matchID;
    }

    public int getTournamentID() {
        return tournamentID;
    }

    public void setTournamentID(int tournamentID) {
        this.tournamentID = tournamentID;
    }

    public int getHomeID() {
        return homeID;
    }

    public void setHomeID(int homeID) {
        this.homeID = homeID;
    }

    public int getAwayID() {
        return awayID;
    }

    public void setAwayID(int awayID) {
        this.awayID = awayID;
    }

    public int getWinnerID() {
        return winnerID;
    }

    public void setWinnerID(int winnerID) {
        this.winnerID = winnerID;
    }

    public int getNextMatchID() {
        return nextMatchID;
    }

    public void setNextMatchID(int nextMatchID) {
        this.nextMatchID = nextMatchID;
    }
}

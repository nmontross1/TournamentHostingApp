package com.techelevator.model;

public class Team {

    private int teamID;
    private int tournamentID;
    private String teamName;

    public Team() {
    }

    public Team(int teamID, int tournamentID, String teamName) {
        this.teamID = teamID;
        this.tournamentID = tournamentID;
        this.teamName = teamName;
    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public int getTournamentID() {
        return tournamentID;
    }

    public void setTournamentID(int tournamentID) {
        this.tournamentID = tournamentID;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}

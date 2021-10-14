package com.techelevator.model;

import java.time.LocalDate;

public class Tournament {

        private int tournamentID;
        private String tournamentName;
        private String tournamentDescription;
        private int tournamentHostID;
        private int bracketSize;
        private String image;
        private LocalDate tournamentDate;

    public Tournament() {
    }

    public Tournament(String tournamentName, String tournamentDescription, int tournamentHostID, int bracketSize, LocalDate tournamentDate, String image) {
        this.tournamentName = tournamentName;
        this.tournamentDescription = tournamentDescription;
        this.tournamentHostID = tournamentHostID;
        this.bracketSize = bracketSize;
        this.tournamentDate = tournamentDate;
        this.image = image;

    }

    public LocalDate getTournamentDate() {
        return tournamentDate;
    }

    public void setTournamentDate(LocalDate tournamentDate) {
        this.tournamentDate = tournamentDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getTournamentID() {
        return tournamentID;
    }

    public void setTournamentID(int tournamentID) {
        this.tournamentID = tournamentID;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public String getTournamentDescription() {
        return tournamentDescription;
    }

    public void setTournamentDescription(String tournamentDescription) {
        this.tournamentDescription = tournamentDescription;
    }

    public int getTournamentHostID() {
        return tournamentHostID;
    }

    public void setTournamentHostID(int tournamentHostID) {
        this.tournamentHostID = tournamentHostID;
    }

    public int getBracketSize() {
        return bracketSize;
    }

    public void setBracketSize(int bracketSize) {
        this.bracketSize = bracketSize;
    }
}

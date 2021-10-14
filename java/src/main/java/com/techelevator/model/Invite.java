package com.techelevator.model;

public class Invite {
    private int inviteID;
    private int sentUserID;
    private int receivedUserID;
    private int tournamentID;
    private int statusID;

    public Invite() {
    }

    public Invite(int inviteID, int sentUserID, int receivedUserID, int tournamentID, int statusID) {
        this.inviteID = inviteID;
        this.sentUserID = sentUserID;
        this.receivedUserID = receivedUserID;
        this.tournamentID = tournamentID;
        this.statusID = statusID;
    }

    public Invite(int sentUserID, int receivedUserID, int tournamentID, int statusID) {
        this.sentUserID = sentUserID;
        this.receivedUserID = receivedUserID;
        this.tournamentID = tournamentID;
        this.statusID = statusID;
    }

    public int getInviteID() {
        return inviteID;
    }

    public void setInviteID(int inviteID) {
        this.inviteID = inviteID;
    }

    public int getSentUserID() {
        return sentUserID;
    }

    public void setSentUserID(int sentUserID) {
        this.sentUserID = sentUserID;
    }

    public int getReceivedUserID() {
        return receivedUserID;
    }

    public void setReceivedUserID(int receivedUserID) {
        this.receivedUserID = receivedUserID;
    }

    public int getTournamentID() {
        return tournamentID;
    }

    public void setTournamentID(int tournamentID) {
        this.tournamentID = tournamentID;
    }

    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }
}

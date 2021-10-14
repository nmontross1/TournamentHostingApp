package com.techelevator.dao;

import com.techelevator.model.Invite;

import java.util.List;

public interface InviteDao {

    List<Invite> findAllInvites();

    List<Invite> findPendingInvitesByReceiverID(int receiverID);

    List<Invite> findInvitesBySenderID(int senderID);

    Invite findInvitebyID(int inviteID);

    void changeStatusToAccepted(int inviteID);

    void changeStatusToRejected(int inviteID);

    void createInvite(Invite invite);

    void createInvites(int senderID, Integer[] selectedUserIDs, int tournamentID);
}

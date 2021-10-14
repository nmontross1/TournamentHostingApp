package com.techelevator.controller;

import com.techelevator.dao.*;
import com.techelevator.model.Invite;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
@PreAuthorize("isAuthenticated()")

public class InviteController {
    @Autowired
    MatchDao matchDao;
    @Autowired
    TeamDao teamDao;
    @Autowired
    TournamentDao tournamentDao;
    @Autowired
    UserDao userDao;
    @Autowired
    InviteDao inviteDao;

    @GetMapping(path = {"/allinvites", "/"})
    public List<Invite> returnInviteData(){
        List<Invite> allInvites = inviteDao.findAllInvites();
        logTimestamp("Getting all invites");
        return allInvites;
    }

    @GetMapping("/receivedInvites/{receiverID}")
    public List<Invite> receievedInvites(@PathVariable int receiverID){
        List<Invite> receivedInvites = inviteDao.findPendingInvitesByReceiverID(receiverID);
        logTimestamp("Getting all invites received by user " + receiverID);
        return receivedInvites;
    }

    @GetMapping("/sentInvites/{senderID}")
    public List<Invite> sentInvites(@PathVariable int senderID){
        List<Invite> sentInvites = inviteDao.findInvitesBySenderID(senderID);
        logTimestamp("Getting all invites sent by user " + senderID);
        return sentInvites;
    }

    @GetMapping("/invites/{inviteID}")
    public Invite returnInviteByID(@PathVariable int inviteID){
        Invite invite = inviteDao.findInvitebyID(inviteID);
        logTimestamp("Returning Invite " + inviteID);
        return invite;
    }

    @PutMapping("/acceptInvite/{inviteID}")
    public void changeStatusToAccepted(@PathVariable int inviteID){
        inviteDao.changeStatusToAccepted(inviteID);
        logTimestamp("Changing status to accepted for invite " + inviteID);
    }

    @PutMapping("/rejectInvite/{inviteID}")
    public void changeStatusToRejected(@PathVariable int inviteID){
        inviteDao.changeStatusToRejected(inviteID);
        logTimestamp("Changing status to rejected for invite " + inviteID);
    }

    @PostMapping("/createInvite")
    public void createInvite(@RequestBody Invite invite){
        inviteDao.createInvite(invite);
        logTimestamp("Creating invite " + invite.getInviteID());
    }

    @GetMapping("/getUsers")
    public List<User> getAllUsers(){
       List<User> userList = userDao.findAll();
        logTimestamp("Finding all users");
        return userList;
    }

    @GetMapping("/getUser/{userID}")
    public User getUserByID(@PathVariable long userID){
        User user = userDao.getUserById(userID);
        logTimestamp("Getting user with ID " + userID);
        return  user;
    }

    @PostMapping("/createInvites/{senderID}/{tournamentID}")
    public void createInvites(@PathVariable(name = "senderID") int senderID,
                              @PathVariable(name = "tournamentID") int tournamentID,
                              @RequestBody Integer[] selectedUserIDs){
        inviteDao.createInvites(senderID, selectedUserIDs, tournamentID);
        logTimestamp("User " + senderID +" is inviting users " + selectedUserIDs);
    }

    static void logTimestamp(String msg) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(msg + " at " + timestamp);
    }
}

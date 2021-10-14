package com.techelevator.controller;

import com.techelevator.dao.MatchDao;
import com.techelevator.dao.TeamDao;
import com.techelevator.dao.TournamentDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Tournament;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class TournamentHostingController {

    @Autowired
    MatchDao matchDao;
    @Autowired
    TeamDao teamDao;
    @Autowired
    TournamentDao tournamentDao;
    @Autowired
    UserDao userDao;

    @GetMapping(path= {"/allTournaments", "/"})
    @PreAuthorize("permitAll()")
    public List<Tournament> returnTournamentData(){
        List<Tournament> allTournaments = tournamentDao.findAllTournaments();
        logTimestamp("Getting all Tournaments");
        return allTournaments;
    }

    @GetMapping("/tournamentByUser/{userID}")
    public List<Tournament> returnAllTournamentsByUserID(@PathVariable int userID){
        List<Tournament> usersTournaments = tournamentDao.findMyTournamentsByUserID(userID);
        logTimestamp("Getting all tournaments that user " + userID + " hosts or participates in");
        return usersTournaments;
    }

    @GetMapping("/tournament/{tournamentID}")
    public Tournament returnTournamentByID(@PathVariable int tournamentID){

        Tournament tournament = tournamentDao.findTournamentByID(tournamentID);
        logTimestamp("Returning Tournament " + tournamentID);
        return tournament;
    }

    @GetMapping("/tournamentName/{name}")
    public Tournament returnTournamentByName(@PathVariable String tournamentString){
        Tournament tournament = tournamentDao.findTournamentByName(tournamentString);
        logTimestamp("Returning Tournament with name " + tournamentString);
        return tournament;
    }

    @GetMapping("/tournamentBySearch/{searchText}")
    public List <Tournament> returnTournamentsByName(@PathVariable String searchText){
        List <Tournament> tournament = tournamentDao.findTournamentBySearch(searchText);
        logTimestamp("Returning Tournament with name " + searchText);
        return tournament;
    }


    @PreAuthorize("permitAll()")
    @PostMapping("/createTournament")
    public void createTournament(@RequestBody Tournament newTournament){
        tournamentDao.createTournament(newTournament);
        Tournament createdTournament = tournamentDao.findTournamentByName(newTournament.getTournamentName());
       matchDao.createAllMatches(createdTournament.getBracketSize(), createdTournament.getTournamentID());

        logTimestamp("Creating new tournament " + newTournament.getTournamentName() + " and all associated matches");

    }

    @DeleteMapping("/removeTournament/{id}")
    public void removeTournament(@PathVariable int tournamentID, Principal principal){
        tournamentDao.removeTournament(tournamentID);
        logTimestamp(principal.getName() + "removed tournament " + tournamentID);
    }

    @PostMapping("/addUsersToFirstRound/{tournamentID}")
    public void addUsersToFirstRound(@PathVariable int tournamentID){
        List<User> userList = userDao.getUsersByTournament(tournamentID);
        List<Integer> idList = new ArrayList<>();
        for (User user:userList){
            Integer i = user.getId().intValue();
            idList.add(i);
        }
        tournamentDao.addUsersToFirstRound(idList, tournamentID);
        logTimestamp("Adding users to the first round in tournament " + tournamentID);
    }

    @PostMapping("/addUserToTournament/{userID}/{tournamentID}")
    public void addUserToTournament(@PathVariable(name = "userID") int userID,
                                    @PathVariable(name = "tournamentID") int tournamentID){
        tournamentDao.addUserToTournament(userID, tournamentID);

        List<User> userList = userDao.getUsersByTournament(tournamentID);
        List<Integer> idList = new ArrayList<>();
        for (User user:userList){
            Integer i = user.getId().intValue();
            idList.add(i);
        }
        tournamentDao.addUsersToFirstRound(idList, tournamentID);
        logTimestamp("Adding user " + userID + " to tournament " + tournamentID + " and placing in first round");
    }

    @GetMapping("/dummy")
    public List<User> dummyMethod(){
        List<User> allUsers = userDao.findAll();
        logTimestamp("Getting all users");
        return allUsers;
    }

    static void logTimestamp(String msg) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(msg + " at " + timestamp);
    }
}

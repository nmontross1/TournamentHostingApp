package com.techelevator.controller;

import com.techelevator.dao.MatchDao;
import com.techelevator.dao.TeamDao;
import com.techelevator.dao.TournamentDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Match;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;



import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
@PreAuthorize("isAuthenticated()")


public class MatchController {

    @Autowired
    MatchDao matchDao;
    @Autowired
    TeamDao teamDao;
    @Autowired
    TournamentDao tournamentDao;
    @Autowired
    UserDao userDao;

    @GetMapping(path = {"/allMatches", "/"})
    public List<Match> returnMatchData(){
        List<Match> allMatches = matchDao.findAllMatches();
        logTimeStamp("Getting all Matches");
        return allMatches;
    }

    @GetMapping("tournament/{tournamentID}/matches")
    public List<Match> returnMatchesByTournamentID(@PathVariable int tournamentID){
        List<Match> matchList = matchDao.findMatchesByTournament(tournamentID);
        logTimeStamp("Getting matches in tournament " + tournamentID);
        return matchList;
    }

    @GetMapping("/tournament/{tournamentID}/match/{matchID}")
    public Match returnMatchByID(@PathVariable(name = "tournamentID") int tournamentID,
                                 @PathVariable(name = "matchID") int matchID){
        Match match = matchDao.findMatchByID(matchID, tournamentID);
        logTimeStamp("Returning Match " + matchID + " in tournament " + tournamentID);
        return match;
    }

    @PostMapping("/createMatch")
    public void createMatch(@RequestBody Match newMatch){
        matchDao.createMatch(newMatch);
        logTimeStamp("Creating match " + newMatch.getMatchID());
    }

    @PutMapping("/tournament/{tournamentID}/match/{matchID}/winner/{winnerID}")
    public Match assignWinnerByID(@PathVariable(name = "tournamentID") int tournamentID,
                                  @PathVariable(name = "matchID") int matchID,
                                  @PathVariable(name = "winnerID") int winnerID){
        matchDao.assignWinner(matchID, winnerID, tournamentID);
        logTimeStamp("Assigning winner to match " + matchID + " in tournament " + tournamentID);
        return matchDao.findMatchByID(matchID, tournamentID);
    }

    @PutMapping("/tournament{tournamentID}/nextMatch/{matchID}")
    public Match assignNextMatch(@PathVariable(name = "tournamentID") int tournamentID,
                                 @PathVariable(name = "matchID") int matchID){
        matchDao.nextMatch(matchID, tournamentID);
        logTimeStamp("Assigning next match to " + matchID + " in tournament " + tournamentID);
        return matchDao.findMatchByID(matchID, tournamentID);
    }

    @PutMapping("/tournament{tournamentID}/progressWinner/{matchID}")
    public Match progressWinner(@PathVariable(name = "tournamentID") int tournamentID,
                                @PathVariable(name = "matchID") int matchID){
        if (matchID%2 ==1) {
            matchDao.assignHomeTeam(matchID, tournamentID);
            logTimeStamp("Progressing winner of match " + matchID + " as next home team");
        }
        else if (matchID%2 == 0){
            matchDao.assignAwayTeam(matchID, tournamentID);
            logTimeStamp("Progressing winner of match " + matchID + " as next away team");
        }
        return matchDao.findMatchByID(matchDao.findMatchByID(matchID, tournamentID).getWinnerID(), tournamentID);
    }

    @GetMapping("/usersInTournament/{tournamentID}")
    public List<User> getUsersInTournament(@PathVariable int tournamentID){
        List<User> userList = userDao.getUsersByTournament(tournamentID);
        logTimeStamp("Finding all users in tournament " + tournamentID);
        return  userList;
    }

    @GetMapping("/getTournamentWinners/{tournamentID}")
    public List<String> getTournamentWinners(@PathVariable int tournamentID){
        List<String> userList = matchDao.getTournamentWinners(tournamentID);
        logTimeStamp("Getting tournament winners in tournament " + tournamentID);
        return userList;
    }

    @PutMapping("/assignWinners/{tournamentID}")
    public void assignWinners(@PathVariable int tournamentID, @RequestBody String[] winners){
        matchDao.assignWinners(tournamentID, winners);
        logTimeStamp("Assigning Winners to tournament " + tournamentID);
    }

    static void logTimeStamp(String msg){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(msg + " at " + timestamp);
    }
}

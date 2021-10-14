package com.techelevator.controller;

import com.techelevator.dao.MatchDao;
import com.techelevator.dao.TeamDao;
import com.techelevator.dao.TournamentDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
@PreAuthorize("isAuthenticated()")


public class TeamController {

    @Autowired
    MatchDao matchDao;
    @Autowired
    TeamDao teamDao;
    @Autowired
    TournamentDao tournamentDao;
    @Autowired
    UserDao userDao;

    @GetMapping(path = {"/allTeams", "/"})
    public List<Team> returnTeamData(){
        List<Team> allTeams = teamDao.findAllTeams();
        logTimeStamp("Getting all teams");
        return allTeams;
    }

    @GetMapping("/team/{teamID}")
    public Team returnTeamByID(@PathVariable int teamID){
        Team team = teamDao.findTeamByID(teamID);
        logTimeStamp("Returning Team " + teamID);
        return team;
    }

    @GetMapping("/teamsInTournament/{tournamentID}")
    public List<Team> returnTeamsInTournamentByTournamentID(@PathVariable int tournamentID){
        List<Team> tournamentTeams = teamDao.findTeamsByTournamentID(tournamentID);
        logTimeStamp("Returning teams in tournament " + tournamentID);
        return tournamentTeams;
    }

    @GetMapping("/teamName/{teamName}")
    public Team returnTeamByName(@PathVariable String teamName){
        Team team = teamDao.findTeamByName(teamName);
        logTimeStamp("Returning team with name " + teamName);
        return team;
    }

    @PostMapping("/createTeam")
    public void createTeam(@RequestBody Team newTeam){
        teamDao.createTeam(newTeam);
        logTimeStamp("Creating new team " + newTeam.getTeamID());
    }


    static void logTimeStamp(String msg){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(msg + " at " + timestamp);
    }
}

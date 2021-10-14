package com.techelevator.dao;

import com.techelevator.model.Team;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTeamDao implements TeamDao{

    private JdbcTemplate jdbcTemplate;
    public JdbcTeamDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public List<Team> findAllTeams() {
        String sql = "SELECT * FROM teams";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        List<Team> teamList = new ArrayList<>();
        while (results.next()){
            Team team = mapRowToTeam(results);
            teamList.add(team);
        }
        return teamList;
    }

    @Override
    public List<Team> findTeamsByTournamentID(int tournamentID) {
        String sql = "SELECT * FROM teams where tournament_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, tournamentID);
        List<Team> teamList = new ArrayList<>();
        while (results.next()){
            Team team = mapRowToTeam(results);
            teamList.add(team);
        }
        return teamList;
    }

    @Override
    public Team findTeamByID(int teamID) {
        String sql = "SELECT * FROM teams where team_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, teamID);
        if (results.next()){
            return mapRowToTeam(results);
        }
        return null;
    }

    @Override
    public Team findTeamByName(String teamName) {
        String sql = "SELECT * FROM teams WHERE team_name ILIKE ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, teamName);
        if (results.next()){
            return mapRowToTeam(results);
        }
        return null;
    }

    @Override
    public void createTeam(Team team) {
        String sql = "INSERT INTO teams (team_id, team_name, tournament_id) " +
                "values(?, ?, ?)";
        jdbcTemplate.update(sql, team.getTeamID(), team.getTeamName(), team.getTournamentID());;
    }

    private Team mapRowToTeam(SqlRowSet results){
        Team team = new Team();
        team.setTeamID(results.getInt("team_id"));
        team.setTeamName(results.getString("team_name"));
        team.setTournamentID(results.getInt("tournament_id"));
        return team;
    }
}

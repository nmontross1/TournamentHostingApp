package com.techelevator.dao;

import com.techelevator.model.Match;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMatchDao implements MatchDao{

    private JdbcTemplate jdbcTemplate;
    public JdbcMatchDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Match> findAllMatches() {
        String sql = "SELECT * from matches";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        List<Match> matchList = new ArrayList<>();
        while (results.next()){
            Match match = mapRowToMatch(results);
            matchList.add(match);
        }
        return matchList;
    }

    @Override
    public List<Match> findMatchesByTournament(int tournamentID) {
        String sql = "SELECT * FROM matches WHERE tournament_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        List<Match> matchList = new ArrayList<>();
        while (results.next()){
            Match match = mapRowToMatch(results);
            matchList.add(match);
        }
        return matchList;
    }

    @Override
    public Match findMatchByID(int matchID, int tournamentID) {
        String sql = "SELECT * FROM matches where match_id = ? and tournament_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, matchID, tournamentID);
        if (results.next()) {
            return mapRowToMatch(results);
        }
        return null;
    }



    @Override
    public void createMatch(Match match) {
        String sql = "INSERT INTO matches (match_id, tournament_id) values(?, ?)";
        jdbcTemplate.update(sql, match.getMatchID(), match.getTournamentID());

    }

    @Override
    public Match assignWinner(int matchID, int winnerID, int tournamentID) {
        String sql = "UPDATE matches SET winner_id = ? WHERE match_id = ? and tournament_id = ?";
        jdbcTemplate.update(sql, winnerID, matchID, tournamentID);
        return findMatchByID(matchID, tournamentID);
    }

    @Override
    public Match assignHomeTeam(int previousMatchID, int tournamentID) {
        Match previousMatch = findMatchByID(previousMatchID, tournamentID);

        String sql = "UPDATE matches SET home_id = ? WHERE match_id = ? and tournament_id = ?";
        jdbcTemplate.update(sql, previousMatch.getWinnerID(), previousMatch.getNextMatchID(), tournamentID);
        return findMatchByID(previousMatch.getMatchID(), tournamentID);
    }

    @Override
    public Match assignAwayTeam(int previousMatchID, int tournamentID) {
        Match previousMatch = findMatchByID(previousMatchID, tournamentID);
        String sql = "UPDATE matches SET away_id = ? WHERE match_id = ? and tournament_id = ?";
        jdbcTemplate.update(sql, previousMatch.getWinnerID(), previousMatch.getNextMatchID(), tournamentID);
        return findMatchByID(previousMatch.getMatchID(), tournamentID);
    }

    @Override
    public Integer nextMatch(int currentMatchID, int tournamentID) {
        //JdbcTournamentDao tournamentDao = new JdbcTournamentDao();
        //int tournamentSize = tournamentDao.findTournamentByID(tournamentID).getTournamentSize();
        String sql = "Select tournament_size from tournaments where tournament_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, tournamentID);
        Integer tournamentSize = null;
        if (results.next()){
            tournamentSize = results.getInt("tournament_size");
        }
        Integer nextMatch = null;
        if (currentMatchID == tournamentSize -1){
            nextMatch = 0;
        }
        else if (currentMatchID <= tournamentSize/2){
            nextMatch = tournamentSize/2 + currentMatchID/2 + currentMatchID%2;
        }
        else if (currentMatchID <= tournamentSize*3/4){
            nextMatch = tournamentSize*3/4 +(currentMatchID - tournamentSize / 2)/2 + ((currentMatchID - tournamentSize /2)%2);
        }
        else if (currentMatchID <= tournamentSize *7/8){
            nextMatch = tournamentSize*7/8 + (currentMatchID - tournamentSize * 3/4)/2 + ((currentMatchID - tournamentSize *3/4)%2);
        }
        else if (currentMatchID <= tournamentSize *15/16){
            nextMatch = tournamentSize*15/16 + (currentMatchID - tournamentSize * 7/8)/2 + ((currentMatchID - tournamentSize * 7/8)%2);
        }
        else if (currentMatchID <= tournamentSize * 31/32) {
            nextMatch = tournamentSize * 31/32 + (currentMatchID - tournamentSize * 15/16)/2 + ((currentMatchID - tournamentSize * 15/16)%2);
        }
        else if (currentMatchID >= tournamentSize -3){
            nextMatch = tournamentSize -1;
        }
        String sql2 = "UPDATE matches SET next_match = ? where match_id = ? and tournament_id = ?";
        if (nextMatch > 0){
            jdbcTemplate.update(sql2, nextMatch, currentMatchID, tournamentID);
        }
        return nextMatch;
    }

    public void createAllMatches(int bracketSize, int tournamentID){
        for (int i = 0; i < bracketSize-1; i++){
            Match match = new Match(i+1, tournamentID);
            createMatch(match);
            if (i < bracketSize-2) {
                int nextMatch = nextMatch(i + 1, tournamentID);
            }
        }
    }

    @Override
    public List<String> getTournamentWinners(int tournamentID) {
        String sql3 = "SELECT tournament_size FROM tournaments WHERE tournament_id = ?";
        SqlRowSet results3 = jdbcTemplate.queryForRowSet(sql3, tournamentID);
        Integer bracketSize = null;
        if (results3.next()){
            bracketSize = results3.getInt("tournament_size");
        }
        List<Integer> idList = new ArrayList<>();
        for (int i = 0; i <bracketSize; i++) {
            String sql = "SELECT winner_id from matches where tournament_id = ? and match_id = ?";

            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, tournamentID, i+1);
            while (results.next()){
                idList.add(results.getInt("winner_id"));
            }
        }

        List<String> usernameList = new ArrayList<>();
        for(Integer userID: idList){
            String sql2 = "SELECT username FROM users WHERE user_id = ?";
            SqlRowSet results2 = jdbcTemplate.queryForRowSet(sql2, userID);
            while (results2.next()){
                usernameList.add(results2.getString("username"));
            }
        }
        return usernameList;
    }

    @Override
    public void assignWinners(int tournamentID, String[] winners) {
        String sql3 = "SELECT tournament_size FROM tournaments WHERE tournament_id = ?";
        SqlRowSet results3 = jdbcTemplate.queryForRowSet(sql3, tournamentID);
        Integer bracketSize = null;
        if (results3.next()){
            bracketSize = results3.getInt("tournament_size");
        }
        String sql = "SELECT * FROM users WHERE username = ?";
        Integer[] idList = new Integer[bracketSize];


        for(int i = 0; i < winners.length; i++){
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, winners[i]);
            while (results.next()){
                long num = Long.valueOf(results.getLong("user_id"));
                Integer id =(int)num;
                idList[i]=id;
            }
            Integer matchID = (i+1);

            String sql2 = "UPDATE matches SET winner_id = ? where tournament_id = ? and match_id = ?";
            jdbcTemplate.update(sql2, idList[i], tournamentID, matchID);
            if (matchID%2 ==1 && matchID != bracketSize-1) {
                assignHomeTeam(matchID, tournamentID);
            }
            else if (matchID%2 == 0) {
                assignAwayTeam(matchID, tournamentID);
            }
        }

    }


    private Match mapRowToMatch(SqlRowSet results){
        Match match = new Match();
        match.setMatchID(results.getInt("match_id"));
        match.setTournamentID(results.getInt("tournament_id"));
        match.setHomeID(results.getInt("home_id"));
        match.setAwayID(results.getInt("away_id"));
        match.setWinnerID(results.getInt("winner_id"));
        match.setNextMatchID(results.getInt("next_match"));

        return match;
    }
}

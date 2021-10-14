package com.techelevator.dao;

import com.techelevator.model.Tournament;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class JdbcTournamentDao implements TournamentDao{

    private JdbcTemplate jdbcTemplate;
    public JdbcTournamentDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }



    @Override
    public List<Tournament> findAllTournaments() {
        String sql = "SELECT tournament_id, tournament_name, tournament_description, " +
                "host_id, tournament_size, tournament_date, image FROM tournaments";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        List<Tournament> tournamentList = new ArrayList<>();
        while (results.next()){
            Tournament tournament = mapRowToTournament(results);
            tournamentList.add(tournament);
        }
        return tournamentList;
    }

    @Override
    public Tournament findTournamentByID(int tournamentID) {
        String sql = "SELECT * FROM tournaments WHERE tournament_ID = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, tournamentID);
        if (rowSet.next()){
            return mapRowToTournament(rowSet);
        }
        return null;
    }



    @Override
    public Tournament findTournamentByName(String tournamentName) {
        String sql = "SELECT * FROM tournaments WHERE tournament_name ILIKE ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, tournamentName);
        if(rowSet.next()){
            return mapRowToTournament(rowSet);
        }
        return null;
    }

    @Override
    public void removeTournament(int tournamentID) {
        String sql = "delete from tournaments where tournament_ID = ?";
        jdbcTemplate.update(sql, tournamentID);
    }

    @Override
    public List<Tournament> findMyTournamentsByUserID(int userID) {
        String sql = "SELECT tournament_id FROM tournaments_users where user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userID);
        List<Integer> tournamentIDList = new ArrayList<>();
        while (results.next()){
            tournamentIDList.add(results.getInt("tournament_id"));
        }
        String sql2 = "SELECT tournament_id, tournament_name, tournament_description, " +
                        "host_id, tournament_size, tournament_date, image FROM tournaments where tournament_id = ?";
        List<Tournament> tournamentList = new ArrayList<>();
        for (Integer id: tournamentIDList){
            SqlRowSet results2 = jdbcTemplate.queryForRowSet(sql2, id);
            if(results2.next()){
                tournamentList.add(mapRowToTournament(results2));
            }
        }
        String sql3 = "SELECT tournament_id, tournament_name, tournament_description, " +
        "host_id, tournament_size, tournament_date, image FROM tournaments where host_id = ?";
        SqlRowSet results3 = jdbcTemplate.queryForRowSet(sql3, userID);

            while (results3.next()){
                boolean isDuplicate = tournamentIDList.contains(results3.getInt("tournament_id"));

                if(!isDuplicate){
                    tournamentList.add(mapRowToTournament(results3));
                }

            }
            return tournamentList;
    }





    @Override
    public List<Tournament> findTournamentBySearch(String searchText) {
        return null;
    }

    @Override
    public void createTournament(Tournament tournament) {
        System.out.println(tournament.getTournamentName() + tournament.getBracketSize() + tournament.getTournamentHostID() + tournament.getTournamentDate());
        String sql = "INSERT INTO tournaments (tournament_name, tournament_description, "+
                "host_id, tournament_size, tournament_date, image) values(?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, tournament.getTournamentName(), tournament.getTournamentDescription(),
         tournament.getTournamentHostID(), tournament.getBracketSize(),tournament.getTournamentDate(), tournament.getImage());

  //      int tournamentID = jdbcTemplate.queryForObject(sql, Integer.class, tournament.getTournamentName(), tournament.getTournamentDescription(),
  //              tournament.getTournamentHostID(), tournament.getBracketSize(),tournament.getTournamentDate(), tournament.getImage());

    }

    @Override
    public void addUsersToFirstRound(List<Integer> userIDList, int tournamentID){
        String sql = "SELECT tournament_size FROM tournaments WHERE tournament_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, tournamentID);
        Integer bracketSize = null;
        if (results.next()){
            bracketSize = results.getInt("tournament_size");
        }
        for (int i = 0; i < userIDList.size(); i++) {
            if (i >= bracketSize){
                break;
            }
            if(i%2 ==0) {
                String sql2 = "UPDATE matches SET home_id = ? WHERE match_id = ? and tournament_id = ?";
                jdbcTemplate.update(sql2, userIDList.get(i),i/2+1, tournamentID);
            }
            else{
                String sql3 = "UPDATE matches SET away_id = ? WHERE match_id = ? and tournament_id = ?";
                jdbcTemplate.update(sql3, userIDList.get(i), i/2+1, tournamentID);
            }
        }
    }

    @Override
    public void addUserToTournament(int userID, int tournamentID){
        String sql = "INSERT INTO tournaments_users (user_id, tournament_id) values(?, ?)";
        jdbcTemplate.update(sql, userID, tournamentID);

    }


    private Tournament mapRowToTournament(SqlRowSet rowSet){
        Tournament tournament = new Tournament();
        tournament.setTournamentID(rowSet.getInt("tournament_id"));
        tournament.setTournamentName(rowSet.getString("tournament_name"));
        tournament.setTournamentDescription(rowSet.getString("tournament_description"));
        tournament.setTournamentHostID(rowSet.getInt("host_id"));
        tournament.setBracketSize(rowSet.getInt("tournament_size"));
        tournament.setImage(rowSet.getString("image"));
        tournament.setTournamentDate(Objects.requireNonNull(rowSet.getDate("tournament_date")).toLocalDate());
        return tournament;
    }
}

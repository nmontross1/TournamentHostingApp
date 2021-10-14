package com.techelevator.dao;

import com.techelevator.model.Invite;
import org.springframework.data.relational.core.sql.In;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcInviteDao implements InviteDao{

    private JdbcTemplate jdbcTemplate;
    public JdbcInviteDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public List<Invite> findAllInvites() {
        String sql = "SELECT * FROM invites";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        List<Invite> inviteList = new ArrayList<>();
        while (results.next()){
            Invite invite = mapRowToInvite(results);
            inviteList.add(invite);
        }
        return inviteList;
    }

    @Override
    public List<Invite> findPendingInvitesByReceiverID(int receiverID) {
        String sql = "SELECT * FROM invites WHERE received_user_id = ? and status_id = 2";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, receiverID);
        List<Invite> inviteList = new ArrayList<>();
        while (results.next()){
            Invite invite = mapRowToInvite(results);
            inviteList.add(invite);
        }
        return inviteList;
    }

    @Override
    public List<Invite> findInvitesBySenderID(int senderID) {
        String sql = "SELECT * FROM invites where sent_user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, senderID);
        List<Invite> inviteList = new ArrayList<>();
        while (results.next()){
            Invite invite = mapRowToInvite(results);
            inviteList.add(invite);
        }
        return inviteList;
    }

    @Override
    public Invite findInvitebyID(int inviteID) {
        String sql = "SELECT * FROM invites WHERE invite_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, inviteID);
        if(results.next()){
            return mapRowToInvite(results);
        }
        return null;
    }

    @Override
    public void changeStatusToAccepted(int inviteID) {
        String sql = "UPDATE invites SET status_id = 3 WHERE invite_id = ?";
        jdbcTemplate.update(sql, inviteID);
    }

    @Override
    public void changeStatusToRejected(int inviteID) {
        String sql = "UPDATE invites SET status_id = 1 WHERE invite_id = ?";
        jdbcTemplate.update(sql, inviteID);

    }

    @Override
    public void createInvite(Invite invite) {
        String sql = "INSERT INTO invites (sent_user_id, received_user_id, tournament_id, status_id) " +
                "values(?, ?, ?, ?)";
        jdbcTemplate.update(sql, invite.getSentUserID(), invite.getReceivedUserID(),
                invite.getTournamentID(), invite.getStatusID());

        //int inviteID = jdbcTemplate.queryForObject(sql, Integer.class, invite.getReceivedUserID(), invite.getSentUserID(),
          //      invite.getTournamentID(), invite.getTournamentID());
    }

    @Override
    public void createInvites(int senderID, Integer[] selectedUserIDs, int tournamentID) {
        for (int i = 0; i <selectedUserIDs.length; i++){
            Invite invite = new Invite(senderID, selectedUserIDs[i], tournamentID, 2);
            createInvite(invite);
        }

    }

    private Invite mapRowToInvite(SqlRowSet rowSet){
        Invite invite = new Invite();
        invite.setInviteID(rowSet.getInt("invite_id"));
        invite.setSentUserID(rowSet.getInt("sent_user_id"));
        invite.setReceivedUserID(rowSet.getInt("received_user_id"));
        invite.setTournamentID(rowSet.getInt("tournament_id"));
        invite.setStatusID(rowSet.getInt("status_id"));
        return invite;
    }
}

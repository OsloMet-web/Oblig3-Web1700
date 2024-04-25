package org.example.wpoblig3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class TicketReporsitory {
    @Autowired
    private JdbcTemplate db;

    private String filmName;
    private String forNavn;
    private String etterNavn;
    private int count;
    private String email;
    private String telNummer;

    public void addTicket(Ticket ticket) {
        String sql  = "INSERT INTO Ticket (filmName, forNavn, etterNavn,count,email,telNummer) VALUES (?, ?, ?, ?, ?,?)";
        db.update(sql, ticket.getFilmName(), ticket.getForNavn(), ticket.getEtterNavn(), ticket.getCount(), ticket.getEmail(), ticket.getTelNummer());
    }

    public void deleteTicket(Ticket ticket) {
        String sql  = "DELETE FROM Ticket WHERE Id = ?";
        db.update(sql, ticket.getId());
    }

    public void deleteAllTickets() {
        String sql  = "DELETE FROM Ticket";
        db.update(sql);
    }

    public List<Ticket> getAllTickets() {
        String sql  = "SELECT * FROM Ticket";
        return db.query(sql, new BeanPropertyRowMapper<Ticket>(Ticket.class));
    }
}

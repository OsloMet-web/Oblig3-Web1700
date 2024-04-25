package org.example.wpoblig3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private TicketReporsitory ticketReporsitory;

    @GetMapping("/")
    public String home() {

        return "Hello World";
    }

    @PostMapping("/addTicket")
    public void addTicket(Ticket ticket) {
        ticketReporsitory.addTicket(ticket);
    }

    @GetMapping("/deleteTicket")
    public void deleteTicket(Ticket ticket) {
        ticketReporsitory.deleteTicket(ticket);
    }
    @GetMapping("/deleteAllTickets")
    public void deleteAllTickets() {
        ticketReporsitory.deleteAllTickets();
    }

    @GetMapping("/getAllTickets")
    public List<Ticket> getAllTickets() {
        return ticketReporsitory.getAllTickets();
    }



}

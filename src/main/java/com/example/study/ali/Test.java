package com.example.study.ali;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: caoyangfan
 * @create: 2019-10-18 17:27
 **/
public class Test {
}


class Ticket implements  Comparable<Ticket>{
    private String from;
    private String to;
    private String time;
    private double price;

    Ticket(String from,String to,String time,double price){
        this.from = from;
        this.to = to;
        this.time = time;
        this.price = price;
    }
    public String getFrom(){
        return this.from;
    }
    public String getTo(){
        return this.to;
    }
    public String getTime(){
        return this.time;
    }
    public double getPrice(){
        return this.price;
    }

    @Override
    public int compareTo(Ticket o) {
        return (this.price - o.getPrice() > 0 ? 1:-1);
    }
}

class TicketManager{

    private List<Ticket> tickets;

    TicketManager(){}

    TicketManager(List<Ticket> tickets){
        this.tickets = tickets;
    }
    public Ticket search(String from, String to, String time){
        if(from == null || to == null || time == null){
            return null;
        }
        Collections.sort(tickets);
        for(int i = 1;i< tickets.size();i++){
            Ticket ticket = tickets.get(i);
            if(ticket.getFrom().equals(from) && ticket.getTo().equals(to) && ticket.getTime().equals(time)){
                return ticket;
            }
        }
        return null;
    }
    public static void main(String[] args){
        List<Ticket> ticketLists = new ArrayList<>();
        ticketLists.add(new Ticket("北京","杭州","2019-10-18", 1100.00));
        ticketLists.add(new Ticket("北京","杭州","2019-10-17", 1200.00));
        ticketLists.add(new Ticket("北京","杭州","2019-10-16", 1110.00));
        ticketLists.add(new Ticket("北京","上海","2019-10-17", 1200.00));
        TicketManager ticketManager = new TicketManager(ticketLists);
        Ticket ticket = ticketManager.search("北京","杭州","2019-10-18");
        System.out.println(ticket.getPrice());
    }
}
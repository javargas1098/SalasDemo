/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.demo.sala.model;

import org.example.demo.sala.persistence.CinemaException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class PlaceFunction {
    
    private Movie movie;
    private List<List<AtomicBoolean>> seats=new ArrayList<>();
    private String date;
    
    public PlaceFunction(){}

    
    public PlaceFunction(Movie movie, String date) {
        this.movie = movie;
        this.date = date;
        //10x20
        for (int i = 0; i < 10; i++) {
            List<AtomicBoolean> row = new ArrayList<>(Arrays.asList(new AtomicBoolean[20]));
            for (int j = 0; j < 20; j++) {
                Random r = new Random();
                if (r.nextInt() % 2 == 0) {
                    row.set(j, new AtomicBoolean(true));
                } else {
                    row.set(j, new AtomicBoolean(false));
                }
            }
            //Collections.fill(row, new AtomicBoolean(true));
            this.seats.add(row);
        }

    }
    
    public void buyTicket(int row,int col) throws CinemaException {
        if (seats.get(row).get(col).equals(true)){
            seats.get(row).set(col, new AtomicBoolean(false));
        }else{
            throw new CinemaException("Seat booked");
        }
    }

    public List<List<AtomicBoolean>> getSeats() {
        return this.seats;
    }
    
    public Movie getMovie() {
        return movie;
    }

    synchronized public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getDate() {
        return date;
    }

    synchronized public void setDate(String date) {
        this.date = date;
    }
    
}

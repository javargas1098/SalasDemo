/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.demo.sala.persistence;

import org.example.demo.sala.model.Place;

import java.util.Set;


public interface SalaPersitence {
    
    /**
     * 
     * @param row the row of the seat
     * @param col the column of the seat
     * @param cinema the cinema's name
     * @param date the date of the function
     * @param movieName the name of the movie
     * 
     * @throws CinemaException if the seat is occupied,
     *    or any other low-level persistence error occurs.
     */
    public void buyTicket(int row, int col, String cinema, String date, String movieName) throws CinemaException;



    /**
     * 
     * @param name name of the cinema
     * @return Cinema of the given name
     * @throws  CinemaPersistenceException if there is no such cinema
     */
    public Place getSala(String name) throws CinemaPersistenceException;


    public Set<Place> getAllSalas();


    
}

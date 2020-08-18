/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.demo.sala.services;

import org.example.demo.sala.model.Place;
import org.example.demo.sala.persistence.CinemaException;
import org.example.demo.sala.persistence.CinemaPersistenceException;
import org.example.demo.sala.persistence.SalaPersitence;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 *
 */

@Service
public class SalaServices {
	
    @Autowired
    @Qualifier("inMemoryCinemaPersistence")
    SalaPersitence cps;



    public Set<Place> getAllSalas(){
        return cps.getAllSalas();
    }
    
    /**
     * 
     * @param name cinema's name
     * @return the cinema of the given name created by the given author
     * @throws CinemaException
     */
    public Place getSalaByName(String name) throws CinemaException, CinemaPersistenceException{
        return cps.getSala(name);
    }
    
    
    public void buyTicket(int row, int col, String cinema, String date, String movieName) throws CinemaException{
        cps.buyTicket(row, col, cinema, date, movieName);
    }

}

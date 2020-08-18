/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.demo.sala.persistence.impl;

import org.example.demo.sala.model.Place;
import org.example.demo.sala.model.PlaceFunction;
import org.example.demo.sala.model.Movie;
import org.example.demo.sala.persistence.CinemaException;
import org.example.demo.sala.persistence.CinemaPersistenceException;
import org.example.demo.sala.persistence.SalaPersitence;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;


@Component("inMemoryCinemaPersistence")
public class InMemorySalaPersistence implements SalaPersitence {

	private final Map<String, Place> cinemas = new HashMap<>();

	public InMemorySalaPersistence() {
		// load stub data
		// Cinema 1
		String functionDate = "2018-12-18 15:30", functionDate2 = "2018-12-20 11:15";
		List<PlaceFunction> functions = new ArrayList<>();
		PlaceFunction funct1 = new PlaceFunction(new Movie("SuperHeroes Movie", "Action"), functionDate);
		PlaceFunction funct2 = new PlaceFunction(new Movie("The Night", "Horror"), functionDate2);
		functions.add(funct1);
		functions.add(funct2);
		Place c = new Place("cinemaX", functions);

		// Cinema 2
		String functionDate3 = "2019-03-10 02:45";
		List<PlaceFunction> functions2 = new ArrayList<>();
		PlaceFunction funct2_1 = new PlaceFunction(new Movie("Inception", "Action"), functionDate3);
		PlaceFunction funct2_2 = new PlaceFunction(new Movie("Batman", "Action"), functionDate3);
		PlaceFunction funct2_3 = new PlaceFunction(new Movie("American pie 1", "Comedy"), functionDate3);
		functions2.add(funct2_1);
		functions2.add(funct2_2);
		functions2.add(funct2_3);
		Place c2 = new Place("cineColombia", functions2);

		cinemas.put("cinemaX", c);
		cinemas.put("cineColombia", c2);

	}

	@Override
	public void buyTicket(int row, int col, String cinema, String date, String movieName) throws CinemaException {
		if (cinemas.containsKey(cinema)) {
			Place cine = cinemas.get(cinema);
			for (PlaceFunction cf : cine.getFunctions()) {
				if (cf.getMovie().getName().equals(movieName) && cf.getDate().equals(date)) {
					cf.buyTicket(row, col);
				}
			}
		}
	}


	@Override
	public Place getSala(String name) throws CinemaPersistenceException {
		if (!cinemas.containsKey(name)) {
			throw new CinemaPersistenceException("The cinema doesn't exists :" + name);
		}
		return cinemas.get(name);
	}

	@Override
	public Set<Place> getAllSalas() {
		Set<Place> cinemasAll = new HashSet<Place>();
		for (Map.Entry<String, Place> e : cinemas.entrySet()) {
			cinemasAll.add(e.getValue());
		}
		return cinemasAll;
	}




}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.demo.sala.controllers;


import java.util.logging.Level;
import java.util.logging.Logger;


import org.example.demo.sala.persistence.CinemaException;
import org.example.demo.sala.persistence.CinemaPersistenceException;
import org.example.demo.sala.services.SalaServices;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/cinemas")
public class
APIController {

	@Autowired
	SalaServices salaServices;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAllCinemas(){
		try {
			return new ResponseEntity<>(salaServices.getAllSalas(), HttpStatus.ACCEPTED);
		} catch (Exception ex) {
			Logger.getLogger(APIController.class.getName()).log(Level.SEVERE, null, ex);
			return new ResponseEntity<>("Error, no cinemas were found", HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/{cinemaname}",method = RequestMethod.GET)
	public ResponseEntity<?> getCinemaByName(@PathVariable String cinemaname) {
		try {
			return new ResponseEntity<>(salaServices.getSalaByName(cinemaname), HttpStatus.ACCEPTED);
		} catch (CinemaException ex) {
			Logger.getLogger(APIController.class.getName()).log(Level.SEVERE, null, ex);
			return new ResponseEntity<>("Error, the cinema doesn't exist", HttpStatus.NOT_FOUND);
		} catch (CinemaPersistenceException ex) {
			Logger.getLogger(APIController.class.getName()).log(Level.SEVERE, null, ex);
			return new ResponseEntity<>("Error, the persistance of cinema has been violated", HttpStatus.NOT_FOUND);
		}
	}


	@RequestMapping(value = "/{cine}/{moviename}/{row}/{col}/{date}",method = RequestMethod.POST)
	public ResponseEntity<?> buyTickes(@PathVariable String cine,@PathVariable String moviename,@PathVariable int row,@PathVariable int col,@PathVariable String date) {
		try {
			salaServices.buyTicket(row,col,cine,date,moviename);
			return new ResponseEntity<>("reserva exitosa" ,HttpStatus.ACCEPTED);
		} catch (CinemaException ex) {
			Logger.getLogger(APIController.class.getName()).log(Level.SEVERE, null, ex);
			return new ResponseEntity<>("Error, the cinema doesn't exist", HttpStatus.NOT_FOUND);
		}
	}


	
}

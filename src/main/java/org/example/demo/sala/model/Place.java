/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.demo.sala.model;

import java.util.List;

public class Place {
    private String name;
    private List<PlaceFunction> functions;
    
    
    public Place(){}
    
    public Place(String name, List<PlaceFunction> functions){
        this.name=name;
        this.functions=functions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PlaceFunction> getFunctions() {
        return this.functions;
    }

    public void setFunctions(List<PlaceFunction> functions) {
        this.functions = functions;
    }
}

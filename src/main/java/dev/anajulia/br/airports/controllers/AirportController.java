/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.anajulia.br.airports.controllers;

import dev.anajulia.br.airports.DTO.AirportMinDTO;
import dev.anajulia.br.airports.entities.Airport;
import dev.anajulia.br.airports.services.AirportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sesidevb
 */
@RestController
public class AirportController {
    
    @Autowired
    private AirportService airportService;
    
    @GetMapping ("/airport")
    public List<Airport>findAll(){
        List<Airport> result = airportService.findAll();
        return result;
    }
   
 @GetMapping ("/country/{countryName}")
 public ResponseEntity<List<AirportMinDTO>> FindByCountryIgnoreCase(@PathVariable String countryName){
     
     
     List<AirportMinDTO> result = airportService.findByCountry(countryName);
     if (result.isEmpty()){
         //Ops.. lista vazia...
         //notFound devolve 404
         return ResponseEntity.notFound().build();
         
     } else {
         // Eba! Tem dados!
         // ok devolve 200
         return ResponseEntity.ok(result);
        }   
    }
    public AirportService getAirportService (){
      return airportService;  
    }
 @GetMapping("/iatacode/{iataCode}")
 public ResponseEntity<Airport> findByIataCode(@PathVariable String iataCode){
     Airport result = airportService.findByIataCode(iataCode);
     
     if(result == null){
         return ResponseEntity.notFound().build();
         
     }else{
        return ResponseEntity.ok(result); 
       
     }
 }
}


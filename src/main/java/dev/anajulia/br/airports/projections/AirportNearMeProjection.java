/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dev.anajulia.br.airports.projections;

import dev.anajulia.br.airports.DTO.AirportNearMeDTO;

/**
 *
 * @author sesidevb
 */
public interface AirportNearMeProjection {

    long getId();

    String getName();

    String getCity();

    String getIataCode();

    double getLatitude();

    double getLongitude();

    double getAltitude();

    double getDistanciaKM();

}

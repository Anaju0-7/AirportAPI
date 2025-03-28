package dev.anajulia.br.airports.services;


import dev.anajulia.br.airports.DTO.AirportMinDTO;
import dev.anajulia.br.airports.DTO.AirportNearMeDTO;
import dev.anajulia.br.airports.entities.Airport;
import dev.anajulia.br.airports.projections.AirportNearMeProjection;
import dev.anajulia.br.airports.repositories.AirportRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportService {
    
    @Autowired
    private AirportRepository airportRepository;
    
    public List<Airport> findAll(){
        
        List<Airport> result = airportRepository.findAll();
        return result;
  
    }

        
    public List<Airport> findByCity(String city){
        List<Airport> result = airportRepository.findByCityIgnoreCase(city);
        return result;
   
   }
    
   public List<AirportMinDTO> findByCountry(String country){
       List<Airport> resultAirport = airportRepository.findByCountryIgnoreCase(country); 
    
       List<AirportMinDTO> resultDTO = resultAirport.stream()
               .map(x -> new AirportMinDTO(x)).toList();
       
       return resultDTO;
   }
    public Airport findByIataCode(String iataCode){
        Airport result = airportRepository.findByIataCode(iataCode);
        return result;
    }   


public List<AirportNearMeDTO>findNearMe(double latitude, double longitude){
    List<AirportNearMeProjection> resultNearMeAirport = airportRepository.findNearMe(latitude, longitude);

    List<AirportNearMeDTO> resultDTO = resultNearMeAirport.stream()
            .map(x -> new AirportNearMeDTO(x)).toList();

    return resultDTO;

}
}
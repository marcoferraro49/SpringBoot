package co.develhope.customqueries01.controllers;

import co.develhope.customqueries01.entities.Flight;
import co.develhope.customqueries01.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping
    public List<Flight> createFlight(){
        return flightService.create();
    }

    @GetMapping
    public List<Flight> getAll(){
        return flightService.getAllFlights();
    }
}

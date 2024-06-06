package co.develhope.customqueries02.controllers;

import co.develhope.customqueries02.entities.Flight;
import co.develhope.customqueries02.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping
    public List<Flight> createFlight(){
        return  flightService.createFlight();
    }

    @PostMapping("/{n}")
    public List<Flight> createFlightWithN(@PathVariable int n){
        return flightService.createByN(n);
    }

    @GetMapping("/paged")
    public Page<Flight> getAll(@RequestParam int page, @RequestParam int size){
        return  flightService.getAllPaged(page, size);
    }

    @GetMapping("ontime")
    public List<Flight> getAllONTIME(){
        return flightService.getAllOnTime();
    }

    @GetMapping("/status")
    public List<Flight> getFlightsByStatus(@RequestParam String p1, @RequestParam String p2) {
        return flightService.getFlightsByStatus(p1, p2);
    }
}

package co.develhope.customqueries01.services;

import co.develhope.customqueries01.entities.Flight;
import co.develhope.customqueries01.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    private static final Random random = new Random();

    public List<Flight> create(){
        List<Flight> flights = new ArrayList<>();
        Random random = new Random();

        for(int i = 0; i<50; i++){
            Flight newFlight = new Flight(
                    random.ints(97, 122 + 1)
                            .limit(10)
                            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                            .toString(),
                    random.ints(97, 122 + 1)
                            .limit(3)
                            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                            .toString(),
                    random.ints(97, 122 + 1)
                            .limit(3)
                            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                            .toString(),
                    Flight.Status.ONTIME);
            flights.add(newFlight);
        }
        return flightRepository.saveAll(flights);
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }
}

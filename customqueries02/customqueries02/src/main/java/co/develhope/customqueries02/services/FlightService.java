package co.develhope.customqueries02.services;

import co.develhope.customqueries02.entities.Flight;
import co.develhope.customqueries02.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> createFlight(){
        List<Flight> flights = new ArrayList<>();
        Random random = new Random();

        for(int i = 0; i<100; i++){
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
                    Flight.Status.getRandomStatus()
            );
            flights.add(newFlight);
        }
        return flightRepository.saveAll(flights);
    }

    public List<Flight> createByN(int n){
        List<Flight> flights = new ArrayList<>();
        Random random = new Random();

        for(int i = 0; i<n; i++){
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
                    Flight.Status.getRandomStatus()
            );
            flights.add(newFlight);
        }
        return flightRepository.saveAll(flights);
    }

    public Page<Flight> getAllPaged(int page, int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by("fromAirport").ascending());
        return flightRepository.findAll(pageable);
    }

    public List<Flight> getAllOnTime(){
        List<Flight> flights = flightRepository.findAll();
        List<Flight> onTimeFlight = new ArrayList<>();
        for (Flight f : flights){
            if(f.getStatus().equals(Flight.Status.ONTIME)){
                onTimeFlight.add(f);
            }
        }
        return onTimeFlight;
    }

    public List<Flight> getFlightsByStatus(String p1, String p2) {
        Flight.Status status1 = Flight.Status.valueOf(p1.toUpperCase());
        Flight.Status status2 = Flight.Status.valueOf(p2.toUpperCase());
        return flightRepository.findByStatusIn(status1, status2);
    }
}

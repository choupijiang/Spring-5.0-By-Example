package springfive.airline.airlinebooking.domain.service;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import springfive.airline.airlinebooking.domain.Booking;
import springfive.airline.airlinebooking.domain.repository.BookingRepository;

@Service
public class BookingService {

  private final BookingRepository bookingRepository;

  private final FareService fareService;

  public BookingService(BookingRepository bookingRepository,
      FareService fareService) {
    this.bookingRepository = bookingRepository;
    this.fareService = fareService;
  }

  public Flux<Booking> bookings(){
    return this.bookingRepository.findAll();
  }

  public Flux<Booking> bookingsOfFlight(@NonNull String flightId){
    return bookingRepository.findByFlightId(flightId);
  }

}

package se.wigell.wtravels.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.wigell.wtravels.entity.BookingEntity;
import se.wigell.wtravels.entity.DestinationEntity;
import se.wigell.wtravels.service.BookingService;
import se.wigell.wtravels.service.DestinationServices;

import java.util.List;

// TODO -- define service funktions

@RestController
@RequestMapping("/api/v1/trips")
public class TripController {
    private static final Logger logger =  LogManager.getLogger(TripController.class);
    private final DestinationServices destinationServices;
    private final BookingService bookingService;
    @Autowired
    public TripController(DestinationServices destinationServices, BookingService bookingService) {
        this.destinationServices = destinationServices;
        this.bookingService = bookingService;
    }

    @GetMapping
    public ResponseEntity<List<DestinationEntity>> listAllTrips(@RequestParam (value = "search", required = false, defaultValue = "") String search) {
        logger.info("-- Controller -- listAllTrips: find all cutomer from Service");

        if(!search.isEmpty() || !search.isBlank()){
            System.out.println("seach not null:" + search);
            return new ResponseEntity<>(destinationServices.findAllDestinationBySearch(search), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(destinationServices.findAllDestination(), HttpStatus.OK);
        }

    }



    @GetMapping("/{tripId}")
    public ResponseEntity<BookingEntity> getTripByBookingId(@PathVariable Long tripId){
        logger.info("-- Controller -- getTripByBookingId: List  booking that have ID: " + tripId);
        BookingEntity bookingEntity = bookingService.ListBookingById(tripId);
        return new ResponseEntity<>(bookingEntity, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<BookingEntity> BookNewTrip(@RequestBody BookingEntity bookingEntity){
        logger.info("-- Controller -- BookNewTrip: ");

        return new ResponseEntity<>(bookingService.BookNewTrip(bookingEntity), HttpStatus.OK);
    }

    @PutMapping("/{custId}")
    public ResponseEntity<String> updateDestination(@PathVariable Long custId, @RequestBody BookingEntity bookingEntity){
        logger.info("updateDestination() - get updateDestination");
        BookingEntity booking = bookingService.customerUppdateBooking(custId,bookingEntity);
        if( booking == null){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body("Cant update Destine  :-(  Something IS Wrong With Input:  ");
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Your info is updated: " + booking);
    }
}

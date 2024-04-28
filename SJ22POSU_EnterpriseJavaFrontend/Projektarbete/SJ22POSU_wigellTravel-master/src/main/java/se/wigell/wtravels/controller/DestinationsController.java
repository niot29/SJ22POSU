package se.wigell.wtravels.controller;

import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import se.wigell.wtravels.entity.DestinationEntity;
import se.wigell.wtravels.service.DestinationServices;

import java.util.List;

@RestController
@RequestMapping("/api/v1/destinations")
@CrossOrigin("http://localhost:3000")
public class DestinationsController {
    private static final Logger logger = LogManager.getLogger(CutomserController.class);
    private final DestinationServices destinationServices;
    @Autowired
    public DestinationsController(DestinationServices destinationServices) {
        this.destinationServices = destinationServices;
    }

    /**
     * This Endpoint is not needed for this proj
     * Main endpoint path is /api/v1/trips
     * @return
     */
    @GetMapping
    public ResponseEntity<List<DestinationEntity>> listAllDestination() {
        logger.info("-- Controller -- listAllDestination: find all cutomer from Service");
        return new ResponseEntity<>(destinationServices.findAllDestination(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addDestination(@Valid @RequestBody DestinationEntity destination) {
        logger.info("-- Controller -- addDestination: Save destination info and return id");
        destination.setId(0L);
        Long destId = destinationServices.addNewDestination(destination);
        if (destId == null) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body("Cant Add destination Something IS Wrong With Input:  ");
        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Destination is Added ID:  " + destId);
    }

    @DeleteMapping("/{destinationId}")
    public ResponseEntity<String> deleteDestinationWithId(@PathVariable Long destinationId) {
        logger.info("-- Controller -- RemoveCustomerById: delete customer by id");
        Boolean deletStatus = destinationServices.removeDestinationById(destinationId);
        if (deletStatus == null) {
            ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body("Cant Delete Customer Something IS Wrong With Input:  ");
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Customer is Delete ID:  " + destinationId);
    }


    //--TODO Need to look into how to update on correct way
    @PutMapping("/{destinationId}")
    public ResponseEntity<DestinationEntity> updateDestination(@PathVariable Long destinationId, @Valid @RequestBody DestinationEntity destination) {
        logger.info("-- Controller --  add/update Cutomer: Save cutomer info and return id");
        DestinationEntity destinationEntity = destinationServices.updateDestinatio(destinationId, destination);
        if (destinationEntity == null) {
            ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body("Cant update Customer cant find :  ");
        }
        return new ResponseEntity<>(destinationEntity, HttpStatus.ACCEPTED);
    }

}

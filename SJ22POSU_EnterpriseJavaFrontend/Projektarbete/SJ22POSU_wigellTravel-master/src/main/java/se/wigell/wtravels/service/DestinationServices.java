package se.wigell.wtravels.service;

import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.wigell.wtravels.entity.AddressEntity;
import se.wigell.wtravels.entity.CustomerEntity;
import se.wigell.wtravels.entity.DestinationEntity;
import se.wigell.wtravels.repository.DestinationRepository;

import java.util.List;

@Service
public class DestinationServices {
    private static final Logger logger = LogManager.getLogger(DestinationServices.class);

    private final DestinationRepository destinationRepository;
    @Autowired
    public DestinationServices(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    public List<DestinationEntity> findAllDestination() {
        logger.info("-- Service -- findAllDestination: find all destination from db");
        return destinationRepository.findAll();
    }

    public List<DestinationEntity> findAllDestinationBySearch(String searchString) {
        logger.info("-- Service -- findAllDestinationBySearch: find all destination from db");
        return destinationRepository.findByDestHotelNamn(searchString);
    }

    @Transactional
    public Long addNewDestination(DestinationEntity destinationEntity){
        logger.info("-- Service -- addNewDestination: Save destination info and return id");

        return destinationRepository.saveAndFlush(destinationEntity).getId();
    }

    @Transactional
    public Boolean removeDestinationById(Long destinationId) {
        logger.info("-- Service -- removeDestinationById: delete destination by id");
        DestinationEntity destinationEntity = destinationRepository.findById(destinationId).get();
        if (destinationEntity == null) {
            logger.info("-- Service -- removeDestinationById: Cant find destination in system, with ID " + destinationId);
            return false;
        }
        destinationRepository.deleteById(destinationId);
        return true;
    }

    @Transactional
    public DestinationEntity updateDestinatio(Long destinationId, DestinationEntity destination) {
        logger.info("-- Service -- add/update updateDestinatio: Save cutomer info and return id");

        if(!destinationRepository.existsById(destinationId)){
            logger.warn("-- Service -- add/update updateDestinatio: Cant find customer by ID");
            return null;
        }

        DestinationEntity destinationEntity = destinationRepository.findById(destinationId).get();
        Long addressId = destinationEntity.getDestination_address_id().getId();
        AddressEntity destAddress = destination.getDestination_address_id();
        destAddress.setId(addressId);

        // Set customer id, if there no id the methon will create a new customer instead for update.
        destination.setId(destinationId);
        destination.setDestination_address_id(destAddress);
        return destinationRepository.save(destination);
    }


}

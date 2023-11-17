package se.wigell.wtravels.service;

import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.wigell.wtravels.entity.AddressEntity;
import se.wigell.wtravels.entity.AuthEntity;
import se.wigell.wtravels.entity.CustomerEntity;
import se.wigell.wtravels.repository.CustomerRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class CustomerServices {

    private static final Logger logger = LogManager.getLogger(CustomerServices.class);
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServices(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public List<CustomerEntity> findAllCutomer() {
        logger.info("-- Service -- findAllCutomer: find all cutomer from db");
        return customerRepository.findAll();
    }

    private String getToDayDateReturnAsString(){
        logger.info("-- Service -- getToDayDateReturnAsString: Get today date");

        // get and format today
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String today = now.format(dtf);  //2022-12-09 18:25:58
        return today;
    }

    private String passwordHandler(){
        logger.info("-- Service -- passwordHandler: ???? Mayby handler user password ..?");
        return "pass";
    }


    @Transactional
    public Long addCutomer(CustomerEntity customer) {
        logger.info("-- Service -- addCutomer: Save cutomer info and return id");
        logger.info("-- Service -- addCutomer: As default will set Customer status ti active");

        //check så email is not empty and set account to active in status
        if(customer.getEmail().isEmpty()){
            return null;
        }
        customer.setCutomerStatus(1);
        AuthEntity authEntity = new AuthEntity();
        authEntity.setLoginNamne(customer.getEmail());
        authEntity.setLoginStatus(1);
        authEntity.setLoginCreateDate(getToDayDateReturnAsString());
        authEntity.setLoginPassword(passwordHandler());
        customer.setAuthEntity(authEntity);

        return customerRepository.saveAndFlush(customer).getId();
    }

    @Transactional
    public CustomerEntity updateCutomer(Long customerId, CustomerEntity customer) {
        logger.info("-- Service -- add/update Cutomer: Save cutomer info and return id");
        if(!customerRepository.existsById(customerId)){
            logger.warn("-- Service -- add/update Cutomer: Cant find customer by ID");
            return null;
        }
        CustomerEntity customerEntity = customerRepository.findById(customerId).get();


        Long addressId = customerEntity.getCutomer_address().getId();
        AddressEntity customerAddress = customer.getCutomer_address();
        customerAddress.setId(addressId);


        // Set customer id, if there no id the methon will create a new customer instead for update.
        customer.setId(customerId);
        customer.setCutomer_address(customerAddress);
        return customerRepository.save(customer);
    }

    @Transactional
    public Boolean removeCustomerById(Long customerId) {
        logger.info("-- Service -- RemoveCustomerById: delete customer by id");
        CustomerEntity customerEntity = customerRepository.findById(customerId).get();
        if (customerEntity == null) {
            logger.info("-- Service -- RemoveCustomerById: Cant find customer in system, with ID " + customerId);
            return false;
        }
        customerRepository.deleteById(customerId);
        return true;
    }


}

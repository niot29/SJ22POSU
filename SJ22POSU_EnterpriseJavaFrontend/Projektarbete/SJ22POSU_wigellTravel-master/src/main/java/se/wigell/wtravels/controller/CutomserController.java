package se.wigell.wtravels.controller;

import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import se.wigell.wtravels.entity.CustomerEntity;
import se.wigell.wtravels.service.CustomerServices;

import java.util.List;

@Controller
@RequestMapping("/api/v1/customers")
public class CutomserController {
    private static final Logger logger = LogManager.getLogger(CutomserController.class);

    private final CustomerServices customerServices;
    @Autowired
    public CutomserController(CustomerServices customerServices) {
        this.customerServices = customerServices;
    }


    @GetMapping
    public ResponseEntity<List<CustomerEntity>> listAllCutonmer() {
        logger.info("-- Controller -- findAllCutomer: find all cutomer from Service");
        return new ResponseEntity<>(customerServices.findAllCutomer(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addCustomer(@Valid @RequestBody CustomerEntity customer) {
        logger.info("-- Controller -- addCutomer: Save cutomer info and return id");
        System.out.println(customer);
        logger.info("-- Controller -- addCutomer: Save cutomer info and return id");
        customer.setId(0);
        Long custId = customerServices.addCutomer(customer);
        if (custId == null) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body("Cant Add Customer Something IS Wrong With Input:  ");
        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Customer is Added ID:  " + custId);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<String> deleteCustomerWithId(@PathVariable Long customerId) {
        logger.info("-- Controller -- RemoveCustomerById: delete customer by id");
        Boolean deletStatus = customerServices.removeCustomerById(customerId);
        if (deletStatus == null) {
            ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body("Cant Delete Customer Something IS Wrong With Input:  ");
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Customer is Delete ID:  " + customerId);
    }


    //--TODO Need to look into how to update on correct way
    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerEntity> updateCustomer(@PathVariable Long customerId, @Valid @RequestBody CustomerEntity customer) {
        logger.info("-- Controller --  add/update Cutomer: Save cutomer info and return id");
        CustomerEntity customerEntity = customerServices.updateCutomer(customerId, customer);
        if (customerEntity == null) {
            ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body("Cant update Customer cant find :  ");
        }
        return new ResponseEntity<>(customerEntity, HttpStatus.ACCEPTED);
    }

    public void defaultAddAdmimUser(){
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setFirstName("Adminsitrator");
        customerEntity.setLastName("kung admin");
        customerEntity.setUserName("ADMIN");
        System.out.println(customerEntity);

        Long custId = customerServices.addCutomer(customerEntity);
    }

}






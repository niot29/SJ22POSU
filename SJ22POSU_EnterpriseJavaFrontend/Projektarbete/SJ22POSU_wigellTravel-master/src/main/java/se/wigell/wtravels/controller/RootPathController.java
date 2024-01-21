package se.wigell.wtravels.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.wigell.wtravels.entity.CurrencyEntity;
import se.wigell.wtravels.service.CurrencyService;

@RestController
@RequestMapping("/")
public class RootPathController {
    private static final Logger logger =  LogManager.getLogger(RootPathController.class);
    CurrencyService currencyService;

    public RootPathController(CurrencyService currencyService){
        this.currencyService = currencyService;
    }

    @GetMapping("")
    public String getTestRespose(){
        logger.info("getTestRespose() - test root path respose");
        return "getTestRespose() - test root path respose";
    }
    @PostMapping
    public ResponseEntity<CurrencyEntity> setCorrencyConversion(@RequestBody CurrencyEntity currency){
        logger.info("------------- setCorrencyConversion(): " + currency);
        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
        logger.fatal("fatal");
       //return currencyService.convertCurrency(currency);
        return new ResponseEntity<>(currencyService.convertCurrency(currency), HttpStatus.CREATED);
    }
}

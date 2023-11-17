package se.wigell.wtravels.service;

import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Null;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.wigell.wtravels.entity.*;
import se.wigell.wtravels.repository.BookingRepository;
import se.wigell.wtravels.repository.CustomerRepository;
import se.wigell.wtravels.repository.DestinationRepository;

@Service
public class BookingService {
    private static final Logger logger = LogManager.getLogger(BookingService.class);

    private final BookingRepository bookingRepository;
    private final DestinationRepository destinationRepository;
    private final CustomerRepository customerRepository;
    private final CurrencyService currencyService;

    @Autowired
    public BookingService(BookingRepository bookingRepository, DestinationRepository destinationRepository, CustomerRepository customerRepository, CurrencyService currencyService) {
        this.bookingRepository = bookingRepository;
        this.destinationRepository = destinationRepository;
        this.customerRepository = customerRepository;
        this.currencyService = currencyService;
    }

    public BookingEntity ListBookingById(Long bookId) {
        logger.info("-- Service -- ListBookingById Booking: List  booking that have ID: " + bookId);
        return bookingRepository.findById(bookId).get();
    }

    @Transactional
    public BookingEntity BookNewTrip(BookingEntity bookingEntity) {
        logger.info("-- Service -- BookNewTrip Booking: Save Booking info and return id");
        CustomerEntity customer = customerRepository.findById(bookingEntity.getBooking_Customer_id().getId()).get();
        DestinationEntity destination = destinationRepository.findById(bookingEntity.getBooking_Destination_id().getId()).get();

        if (customer == null || destination == null) {
            logger.warn("-- Service -- BookNewTrip Booking: CustomerEntity or DestinationEntity return NULL");
            return null;
        }
        // Masking customer login info by remove/set cutomer auth o null
        customer.setAuthEntity(null);
        bookingEntity.setBooking_Customer_id(customer);
        bookingEntity.setBooking_Destination_id(destination);

        //get SEK price on week and concert to PLN
        CurrencyEntity sendCurrencySekToPln = new CurrencyEntity((long) bookingEntity.getBooking_Destination_id().getPriceWeek(), "SEK", "PLN");
        CurrencyEntity getCurrencySekToPln = currencyService.convertCurrency(sendCurrencySekToPln);

        bookingEntity.setTotalPricePLN((int) (getCurrencySekToPln.getConverted_value() * bookingEntity.getStay_week()));
        bookingEntity.setTotalPriceSEK(bookingEntity.getBooking_Destination_id().getPriceWeek() * bookingEntity.getStay_week());
        bookingEntity.setBookStatus(1);
        return bookingRepository.save(bookingEntity);
    }

    public BookingEntity customerUppdateBooking(Long custId, BookingEntity booking) {
        logger.info("-- Service -- customerUppdateBooking Booking: " + custId);
        BookingEntity bookingEntity = bookingRepository.findById(custId).get();
        if (bookingEntity == null) {
            return null;
        }
        //System.out.println(bookingEntity.getBooking_Destination_id().getId());
        //System.out.println(booking.getBooking_Destination_id().getId());
        bookingEntity.setDeparture_date(booking.getDeparture_date());
        bookingEntity.setStay_week(booking.getStay_week());

        DestinationEntity destination = new DestinationEntity();
        Long newDestId = booking.getBooking_Destination_id().getId();
        if (destinationRepository.existsById(newDestId)) {
            logger.info("-- Service -- customerUppdateBooking Booking: check if destination exists");
            destination = destinationRepository.findById(newDestId).get();
        }else {
            logger.warn("-- Service -- customerUppdateBooking Booking: check if destination exists");
            return null;
        }
        bookingEntity.setBooking_Destination_id(destination);

        bookingEntity.setBookStatus(booking.getBookStatus());

        return bookingEntity;

    }


}

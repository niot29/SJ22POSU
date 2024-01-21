package se.wigell.wtravels;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import se.wigell.wtravels.controller.CutomserController;
import se.wigell.wtravels.entity.*;
import se.wigell.wtravels.service.CustomerServices;
import se.wigell.wtravels.service.DestinationServices;

@SpringBootApplication
public class WtravelsApplication {
	private static final Logger logger = LogManager.getLogger(WtravelsApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(WtravelsApplication.class, args);

	}
	@Bean
	public CommandLineRunner commandLineRunner(CustomerServices customerServices, DestinationServices destinationServices) {
		return runner -> {
			createCutomer(customerServices);
			createTempDestinations(destinationServices);
		};
	}
	private void createCutomer(CustomerServices customerServices) {
		CustomerEntity customer = new CustomerEntity("admin","Admin","Administrator","a.a@a.com","123456789","2022",1);
		RolsEnum rolsEnum = RolsEnum.ADMIN;
		AuthEntity authEntity = new AuthEntity();
		authEntity.setLoginRole(rolsEnum);
		customer.setAuthEntity(authEntity);
		logger.info("Create Admini User: " + customer.getAuthEntity());
		customerServices.addCutomer(customer);

		for (int i = 0 ; i < 5 ; i++){
			CustomerEntity loopMembers = new CustomerEntity("Anv0" + i,"Kungen0" + i,"LanstName" + i,"0" + i + "@nowhere.du","123456789" + i,"2023-11-0" + i,1);
			AddressEntity addressEntity = new AddressEntity("AnkeBorg01" +i, 12312, "Stockholm","swe");

			RolsEnum userRole = RolsEnum.USER;
			AuthEntity authUserEntity = new AuthEntity();
			authUserEntity.setLoginRole(userRole);

			loopMembers.setCutomer_address(addressEntity);
			loopMembers.setAuthEntity(authUserEntity);
			logger.info("Create Admini User: " + loopMembers.getAuthEntity());
			customerServices.addCutomer(loopMembers);
		}
	}

	private void createTempDestinations(DestinationServices destinationServices){
		for (int i = 0 ; i < 5 ; i++) {
			DestinationEntity destinationEntity = new DestinationEntity("HotelFubar0" + i, "I think it a nice Hotel", 100 + i, 1);
			AddressEntity addressEntity = new AddressEntity("BörnBorgvägen10" + i, 12312, "Stockholm", "swe");
			destinationEntity.setDestination_address_id(addressEntity);
			destinationServices.addNewDestination(destinationEntity);
		}
	}
}

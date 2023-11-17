package se.wigell.wtravels;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.wigell.wtravels.controller.CutomserController;

@SpringBootApplication
public class WtravelsApplication {
	private static final Logger logger = LogManager.getLogger(WtravelsApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(WtravelsApplication.class, args);
	}

}

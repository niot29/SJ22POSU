package se.wigellgrp.sj23posu_wigellgrp;

import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import se.wigellgrp.sj23posu_wigellgrp.entity.Address;
import se.wigellgrp.sj23posu_wigellgrp.entity.Members;
import se.wigellgrp.sj23posu_wigellgrp.service.MembersService;

@SpringBootApplication
public class Sj23PosuWigellGrpApplication {
    public static void main(String[] args) {
        SpringApplication.run(Sj23PosuWigellGrpApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(MembersService membersService) {
        return runner -> {
            createTestMember(membersService);
        };
    }


    private void createTestMember(MembersService membersService) {
        Members members = new Members("SnyggNils","Kungen","SomeMail@nowhere.du","1234567890","2023-11-11");
        System.out.println(members);
        Address address = new Address("AnkeBorg", 12312, "Stockholm");
        System.out.println(address);
        members.setAddress(address);
        membersService.save(members);

        for (int i = 0 ; i < 5 ; i++){
            Members loopMembers = new Members("Anv0" + i,"Kungen0" + i,"0" + i + "@nowhere.du","123456789" + i,"2023-11-0" + i);
            Address loopAddress = new Address("AnkeBorg01" +i, 12312, "Stockholm");
            loopMembers.setAddress(loopAddress);
            membersService.save(loopMembers);
        }




    }


}

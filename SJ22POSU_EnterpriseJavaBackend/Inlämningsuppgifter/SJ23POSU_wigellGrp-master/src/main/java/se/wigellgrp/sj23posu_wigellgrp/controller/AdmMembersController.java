package se.wigellgrp.sj23posu_wigellgrp.controller;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.wigellgrp.sj23posu_wigellgrp.entity.Address;
import se.wigellgrp.sj23posu_wigellgrp.entity.Members;
import se.wigellgrp.sj23posu_wigellgrp.service.MembersService;

import java.util.List;

@RestController
@RequestMapping("/admin/members")
public class AdmMembersController {
    private final Logger logger = LoggerFactory.getLogger(AdmMembersController.class);
    private final MembersService membersService;

    @Autowired
    public AdmMembersController(MembersService membersService) {
        this.membersService = membersService;
    }

    @GetMapping
    public ResponseEntity<List<Members>> findAll() {
        return new ResponseEntity<>(membersService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{membersId}")
    public ResponseEntity<Members> findById(@PathVariable Long membersId) {
        Members members = membersService.findById(membersId);
        if (members == null) {
            logger.error("Member id not found - " + membersId);
        }
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addMembers(@RequestBody @Valid Members members) {
        logger.info("Add new member: ");
        /**
         *   id have to be 0 or funkt just will update object with the same id.
         *   check Service resopose.
         */

        members.setId(0);
        Members members1 = membersService.save(members);

        if(members1 == null){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body("Cant Add member no Address define:  ");
        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Member is Added:  " + members1);
    }

    @PutMapping("/{membersId}")
    public ResponseEntity<Members> updateMember(@RequestBody Members members) {
        logger.info("Add new member: " + members.getId());
        membersService.save(members);
        return new ResponseEntity<>(membersService.save(members), HttpStatus.CREATED);
    }



    @DeleteMapping("/{membersId}")
    public ResponseEntity<String> deleteMember(@PathVariable Long membersId) {
        Members members = membersService.findById(membersId);
        if (members == null) {
            logger.error("Member is not found - " + membersId);
            throw new RuntimeException("Member is not found - " + membersId);
        }
        membersService.deleteById(members.getId());
        return new ResponseEntity<>("Delete member id - " + membersId, HttpStatus.OK);
    }

/*
    @GetMapping("/add")
    public ResponseEntity<Members> add() {
        Members members = new Members();
        members.setFirstName("Nils");
        members.setLastName("Ottosson");
        members.setEmail("Some@mail.com");
        members.setDateOfBirth("1975-03-29");
        System.out.println(members);

        Address address = new Address("AnkeBorg", 12312, "Stockholm");
        members.setAddress(address);
        return new ResponseEntity<>(membersService.save(members), HttpStatus.CREATED);


    }
*/
}

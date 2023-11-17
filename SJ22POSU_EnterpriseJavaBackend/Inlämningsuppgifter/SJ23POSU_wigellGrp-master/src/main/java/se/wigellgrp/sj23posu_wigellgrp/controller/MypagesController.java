package se.wigellgrp.sj23posu_wigellgrp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import se.wigellgrp.sj23posu_wigellgrp.entity.Members;
import se.wigellgrp.sj23posu_wigellgrp.service.MembersService;

import java.util.List;

@RestController
@RequestMapping("/mypages/members")
public class MypagesController {
    private final Logger logger = LoggerFactory.getLogger(MypagesController.class);
    private final MembersService membersService;

    @Autowired
    public MypagesController(MembersService membersService){
        this.membersService = membersService;
    }

    @GetMapping
    public ResponseEntity<List<Members>>  findAll(){
        return new ResponseEntity<> (membersService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{membersId}")
    public ResponseEntity<Members> updateMember(@RequestBody Members currentUser, Authentication authentication){
        logger.info("Add new member: " + currentUser.getId());
        logger.info(("currentUser login user: " + authentication.getDetails()));
        logger.info(("currentUser login user: " + authentication.getName()));

        return new ResponseEntity<>(membersService.save(currentUser), HttpStatus.OK);
    }

}

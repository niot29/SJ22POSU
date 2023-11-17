package se.wigellgrp.sj23posu_wigellgrp.service;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.wigellgrp.sj23posu_wigellgrp.dao.MembersDAO;
import se.wigellgrp.sj23posu_wigellgrp.entity.Address;
import se.wigellgrp.sj23posu_wigellgrp.entity.Members;

import java.util.List;
@Service
public class MembersServiceImpl implements MembersService{
    private final Logger logger = LoggerFactory.getLogger(MembersServiceImpl.class);

    private final MembersDAO membersDAO;
    @Autowired
    public MembersServiceImpl(MembersDAO membersDAO){
        this.membersDAO = membersDAO;
    }

    @Override
    public List<Members> findAll() {
        return membersDAO.findAll();
    }

    @Override
    public Members findById(Long id) {
        return membersDAO.findById(id);
    }

    @Override
    @Transactional
    public Members save(Members members) {
        /**
         * Check inf Adress input data have Address info.
         * if not return NULL
         * if input data have Address id, then check if system can recive address info from system.
         * If theirs is data from system then add to Member object
         *
         */
        if(members.getAddress() == null){
            logger.warn("Address field is empty: ");
            return null;
        } else if (members.getAddress().getId() != null) {
            logger.info("Address by adress ID: " + members.getAddress().getId());

            Address  address = findAddressById(members.getAddress().getId());
            if(address == null){
                return null;
            }else {
                members.setAddress(address);
            }
        }
        return membersDAO.save(members);

    }

    @Override
    @Transactional
    public void deleteById(long id) {
        membersDAO.deleteById(id);

    }

    @Override
    public List<Address> findMemberInAddressByMemberId(Long id) {
        return null;
    }

    @Override
    public Members findMemberByIdJoinFetch(Long id) {
        return membersDAO.findMemberByIdJoinFetch(id);
    }

    @Override
    public void updateAddress(Address address) {
        membersDAO.updateAddress(address);
    }

    @Override
    public Address findAddressById(Long id) {
        return membersDAO.findAddressById(id);
    }
}

package se.wigellgrp.sj23posu_wigellgrp.dao;

import se.wigellgrp.sj23posu_wigellgrp.entity.Address;
import se.wigellgrp.sj23posu_wigellgrp.entity.Members;

import java.util.List;

public interface MembersDAO {

    List<Members> findAll();

    Members findById(Long id);

    Members save(Members members);

    void deleteById(long id);

    List<Address> findMemberInAddressByMemberId(Long id);

    Members findMemberByIdJoinFetch(long ig);

    void updateAddress(Address address);

    Address findAddressById(Long id);

}

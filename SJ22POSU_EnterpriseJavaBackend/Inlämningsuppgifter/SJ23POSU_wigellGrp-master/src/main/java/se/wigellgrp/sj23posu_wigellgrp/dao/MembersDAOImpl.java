package se.wigellgrp.sj23posu_wigellgrp.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import se.wigellgrp.sj23posu_wigellgrp.entity.Address;
import se.wigellgrp.sj23posu_wigellgrp.entity.Members;

import java.util.List;

@Repository
public class MembersDAOImpl implements MembersDAO{
    private final Logger logger = LoggerFactory.getLogger(MembersDAOImpl.class);
    private EntityManager entityManager;

     @Autowired
    public MembersDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    public List<Members> findAll() {

        TypedQuery<Members> query = entityManager.createQuery("from Members", Members.class);
        List<Members> members = query.getResultList();
        return members;
    }

    @Override
    public Members findById(Long id) {
        return entityManager.find(Members.class,id);
    }

    // save and Update
    @Override
    public Members save(Members members) {
        //Members dbMembers = entityManager.merge(members);
        //entityManager.persist(members);
        return entityManager.merge(members);
    }

    @Override
    public void deleteById(long id) {
        Members members = entityManager.find(Members.class,id);
        entityManager.remove(members);
    }

    @Override
    public List<Address> findMemberInAddressByMemberId(Long id) {
        TypedQuery<Address> query = entityManager.createQuery("from Members where address.id = :data", Address.class);
        query.setParameter("data",id);
        List<Address> addresses = query.getResultList();
        return addresses ;
    }

    @Override
    public Members findMemberByIdJoinFetch(long id) {
         TypedQuery<Members> query = entityManager.createQuery("select m from Members m JOIN FETCH m.address where m.id = :data", Members.class);
         query.setParameter("data",id);
         Members members = query.getSingleResult();
        return members;
    }

    @Override
    public void updateAddress(Address address) {
         entityManager.merge(address);
    }

    @Override
    public Address findAddressById(Long id) {
        return entityManager.find(Address.class,id);
    }
}

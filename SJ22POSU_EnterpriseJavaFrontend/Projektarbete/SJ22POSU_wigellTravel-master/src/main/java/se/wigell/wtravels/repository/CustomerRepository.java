package se.wigell.wtravels.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.wigell.wtravels.entity.CustomerEntity;

import java.util.List;
@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    List<CustomerEntity> findAll();

    //CustomerEntity findById(Long entityId);

   // Long saveAndFlush(CustomerEntity entity);

    void delete(CustomerEntity entity);

 }

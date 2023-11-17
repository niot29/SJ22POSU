package se.wigell.wtravels.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.wigell.wtravels.entity.BookingEntity;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity,Long> {

    //Not use in the project
    List<BookingEntity> findByBookStatus(int status);
}

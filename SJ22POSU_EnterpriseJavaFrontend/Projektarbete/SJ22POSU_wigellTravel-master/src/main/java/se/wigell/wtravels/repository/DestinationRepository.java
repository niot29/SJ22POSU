package se.wigell.wtravels.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.wigell.wtravels.entity.BookingEntity;
import se.wigell.wtravels.entity.DestinationEntity;

import java.util.List;

@Repository
public interface DestinationRepository  extends JpaRepository<DestinationEntity, Long> {
    List<DestinationEntity>  findByDestHotelNamn(String seachString);
}

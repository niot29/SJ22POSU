package se.wigell.wtravels.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.wigell.wtravels.entity.DestinationEntity;

@Repository
public interface DestinationRepository  extends JpaRepository<DestinationEntity, Long> {
}

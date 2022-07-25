package peaksoft.airbnb_j.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.airbnb_j.models.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
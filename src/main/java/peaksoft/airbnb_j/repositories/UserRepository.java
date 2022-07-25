package peaksoft.airbnb_j.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.airbnb_j.models.auth.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
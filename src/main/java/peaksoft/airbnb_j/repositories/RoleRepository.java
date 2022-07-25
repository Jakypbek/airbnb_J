package peaksoft.airbnb_j.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.airbnb_j.models.auth.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
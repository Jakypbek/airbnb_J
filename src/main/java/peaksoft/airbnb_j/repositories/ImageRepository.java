package peaksoft.airbnb_j.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.airbnb_j.models.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {


}

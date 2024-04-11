package api.inatro.inatro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.inatro.inatro.model.vehicle.vehicle;

public interface vehicleRepository extends JpaRepository<vehicle, Long> {
    
}

package ProductRental.com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ProductRental.com.example.demo.Model.Rental;

@Repository
public interface rentalRepository extends JpaRepository<Rental, Long> {
    
}

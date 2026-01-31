package ProductRental.com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ProductRental.com.example.demo.Model.Rental;
import ProductRental.com.example.demo.repository.rentalRepository;

@RestController
@RequestMapping("/rentals")
public class RentalController {

    @Autowired
    private rentalRepository rentalRepository;

    @GetMapping
    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Rental> getRentalById(@PathVariable Long id) {
        return rentalRepository.findById(id);
    }

    @PostMapping
    public Rental createRental(@RequestBody Rental rental) {
        return rentalRepository.save(rental);
    }

    @PutMapping("/{id}")
    public Rental updateRental(@PathVariable Long id, @RequestBody Rental updatedRental) {
        return rentalRepository.findById(id)
                .map(rental -> {
                    rental.setStartDate(updatedRental.getStartDate());
                    rental.setEndDate(updatedRental.getEndDate());
                    rental.setTotalCost(updatedRental.getTotalCost());
                    rental.setProduct(updatedRental.getProduct());
                    rental.setUser(updatedRental.getUser());
                    return rentalRepository.save(rental);
                })
                .orElseGet(() -> {
                    updatedRental.setId(id);
                    return rentalRepository.save(updatedRental);
                });
    }

    @DeleteMapping("/{id}")
    public String deleteRental(@PathVariable Long id) {
        rentalRepository.deleteById(id);
        return "Rental deleted with id: " + id;
    }
}

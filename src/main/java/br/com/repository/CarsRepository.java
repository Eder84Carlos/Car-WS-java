package br.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.model.Cars;

public interface CarsRepository extends JpaRepository<Cars, Long> {

}

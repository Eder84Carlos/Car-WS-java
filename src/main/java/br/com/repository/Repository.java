package br.com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.model.Cars;
import br.com.model.Factories;

public interface Repository extends JpaRepository<Factories, Long> {

	@Query("select p from Factories p where p.country_code like %?1% group by Factories")
	public Optional<Factories> findByCountryCode(String country_code);

	public void save(Cars cars); 

}

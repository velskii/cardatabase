package com.packt.cardatabase.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CarRepository extends CrudRepository<Car, Long> {

//	List<Car> findByBrand(String brand);
	List<Car> findByColor(@Param("color") String color);

	List<Car> findByYear(int year);

	// and, or
	List<Car> findByBrandAndModel(String brand, String model);

	List<Car> findByBrandOrColor(String brand, String color);

	// order by
	List<Car> findByBrandOrderByYearAsc(String brand);

	// Fetch cars by brand using SQL
	@Query("select c from Car c where c.brand = ?1")
	List<Car> findByBrand(@Param("brand") String brand);

	@Query("select c from Car c where c.brand like %?1")
	List<Car> findByBrandEndsWith(String brand);

}

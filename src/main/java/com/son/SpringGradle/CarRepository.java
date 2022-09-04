package com.son.SpringGradle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
//	Car findByName(String name); // implementado em tempo de execução, não precisa implementar.
}

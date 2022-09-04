package com.son.SpringGradle;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {

	// Trabalhando com a injeção de dependência(DI)
	// ===========================================
	@Autowired
	private CarRepository carRepository;

	public CarController(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	// ===========================================
	@GetMapping
	@ResponseBody
	public List<Car> findAll() {
		return this.carRepository.findAll();
	}
	
	@GetMapping("{id}")
	@ResponseBody
	public Optional<Car> findById(@PathVariable("id") Long id) {
		return this.carRepository.findById(id);
	}

	@PostMapping
	@ResponseBody // Pega o valor que acabei de criar e transf em JSON e devolva ao usuário.
	@ResponseStatus(code = HttpStatus.CREATED) // 201 - informando que essa vai ser a msg 
	public Car create(@RequestBody Car car) {
		return this.carRepository.save(car);
	}

}

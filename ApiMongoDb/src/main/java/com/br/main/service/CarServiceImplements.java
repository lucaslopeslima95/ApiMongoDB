package com.br.main.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.br.main.model.Car;
import com.br.main.model.Log;
import com.br.main.repository.CarRepository;

@Service
public class CarServiceImplements implements CarService {


	private CarRepository carRepository;

	private LogServiceImplements logService;
	Queue<Car> queuecar = new LinkedList<>();

	public CarServiceImplements(CarRepository carRepository, LogServiceImplements logService) {
		this.carRepository = carRepository;
		this.logService = logService;
	}

	@Override
	public List<Car> listAll() {
		
		return this.carRepository.findAll();
	}

	@Override
	public void registerCar(Car car) {
		Car carSaved = new RestTemplate().postForObject("http://api-test.bhut.com.br:3000/api/cars", car, Car.class);
		queuecar.add(carSaved);
		generateLog(carSaved);
	}

	public ResponseEntity<String> webhook() {
		return new ResponseEntity<String>("O " + queuecar.poll().getTitle() + " foi cadastrado com sucesso ",
				HttpStatus.OK);
	}

	public void generateLog(Object obj) {
		
		if (obj instanceof Car) {
			Log log = new Log();
			log.setCar_id(((Car) obj).getId());
		} else {
			((Log) obj).setCar_id("Log de Consulta");
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String dateFormated = now.format(formatter);
		((Log) obj).setData_hora(dateFormated);
		
		this.logService.registerLog((Log) obj);
	}
}

package com.br.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.br.main.model.Car;
@Service
public interface CarService {
	public List<Car> listAll();
	public void registerCar(Car car);
}

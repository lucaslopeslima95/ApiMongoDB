package com.br.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.br.main.model.Log;
import com.br.main.service.LogService;

@RestController
@RequestMapping("/api")
public class LogController {

	public LogController(LogService logService) {
		this.logService = logService;
	}

	private LogService logService;
	
	@GetMapping(value="/logs")
	public List<Log> listAll() {
		return this.logService.listAll(); 
	}
	@PostMapping
	public Log registerLog(@RequestBody Log log) {
		return this.logService.registerLog(log);
	}
}

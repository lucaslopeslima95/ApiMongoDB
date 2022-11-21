package com.br.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.br.main.model.Log;

@Service
public interface LogService {
	public List<Log> listAll();
	public Log registerLog(Log log);
}

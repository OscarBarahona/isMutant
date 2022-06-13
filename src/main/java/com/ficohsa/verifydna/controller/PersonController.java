package com.ficohsa.verifydna.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ficohsa.verifydna.dto.DNA;
import com.ficohsa.verifydna.dto.Stats;
import com.ficohsa.verifydna.entity.Person;
import com.ficohsa.verifydna.exceptions.AppServiceException;
import com.ficohsa.verifydna.service.IVerifyService;
import com.ficohsa.verifydna.util.AppUtil;
import com.ficohsa.verifydna.util.ConstantUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(tags = "Mutant")
@RequestMapping("/mutant")
public class PersonController {
	final Logger log = LoggerFactory.getLogger(PersonController.class);
	@Autowired
	IVerifyService service;

	@ApiOperation(value = "Guardar ADN")
	@ApiResponses(value = {
			@ApiResponse(code = ConstantUtils.API_RESPONSE_CODE_OK_KEY_CREATE, message = ConstantUtils.API_RESPONSE_CODE_OK_VALUE, response = String.class) })
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> isMutant(@RequestBody DNA dna) {
		StopWatch time = new StopWatch();
		log.info("Iniciando Servicio {}", dna);
		time.start();
		try {
			String cadena = AppUtil.conversionSave(dna.getAdn());
			Person p = service.findByDNA(cadena);
			log.info("Persona {}", p);
			boolean isMutant = (p != null ? p.isMutant() : service.isMutant(dna.getAdn()));
			p = p != null ? service.save(cadena, isMutant) : p;
			log.info("Detalle de la persona {}", p);
			log.info("isMutant {}", isMutant);
			time.stop();
			if (isMutant) {
				log.info("Tiempo de ejecucion  Millis OK {}", time.getTotalTimeMillis());
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				log.info("Tiempo de ejecucion  Millis FORBIDDEN {}", time.getTotalTimeMillis());
				return new ResponseEntity<>(HttpStatus.FORBIDDEN);
			}
		} catch (AppServiceException e) {
			time.stop();
			log.info("Tiempo de ejecucion  Millis  AppServiceException {}", time.getTotalTimeMillis());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			log.info("Tiempo de ejecucion  Millis Exception {}", time.getTotalTimeMillis());
			time.stop();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "Guardar ADN")
	@ApiResponses(value = {
			@ApiResponse(code = ConstantUtils.API_RESPONSE_CODE_OK_KEY_CREATE, message = ConstantUtils.API_RESPONSE_CODE_OK_VALUE, response = String.class) })
	@GetMapping(value = "/stats", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Stats> stats() {
		StopWatch time = new StopWatch();
		log.info("Iniciando Servicio stats");
		time.start();
		try {
			Stats s = service.stats();
			log.info("Tiempo de ejecucion  NanosSeg  Ok {}", time.getTotalTimeNanos());
			return ResponseEntity.ok(s);
		} catch (Exception e) {
			log.info("Tiempo de ejecucion  NanosSeg  Exception {}", time.getTotalTimeMillis());
			return ResponseEntity.badRequest().build();
		}
	}

}

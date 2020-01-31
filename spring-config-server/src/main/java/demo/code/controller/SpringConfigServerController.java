package demo.code.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class SpringConfigServerController {

	@Value("${HOME}")
	private String home;

	@GetMapping("/healthcheck")
	public ResponseEntity<String> getConfigServerHealth(){
		
		return new ResponseEntity<>("Good: "+home, HttpStatus.OK);
	}
}

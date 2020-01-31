package demo.code.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Value;

@RestController
@RequestMapping("/v1")
public class SpringConfigClientController {
	
	@Value("${loginuser.name}")
	String userName;
	
	@Value("${loginuser.password}")
	String password;
	
	@GetMapping("/getUserDetails")
	public ResponseEntity<String> getUserDetails(){
		
		 return new ResponseEntity<>("Hello "+userName+"! I know your password: "+password, HttpStatus.OK);
	}

}

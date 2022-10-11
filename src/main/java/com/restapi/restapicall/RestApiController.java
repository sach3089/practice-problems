package com.restapi.restapicall;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestApiController {

	
	@GetMapping("/getEmailId/users/{id}")
	public ResponseEntity<Object> getAllEmails(@PathVariable int id){
		
		String uri = "https://reqres.in/api/users/"+id;
		Map<String, Map<String, Object>> response = (Map<String, Map<String, Object>>) new RestTemplate().getForObject(uri , Object.class);
		return new ResponseEntity<Object>(response.get("data").get("email"), HttpStatus.OK);
	}
}

package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class HelloController {
	@Value("${environment.name}")
	private String environmentName; 
	@SuppressWarnings("unchecked")
	@GetMapping()
    ResponseEntity<Map<String,String>> test(){
		Map map = new HashMap<String,String>();
		map.put("Status","Up Up");
		map.put("environment",environmentName);
    	return ResponseEntity.ok().body(map);
    }
	@GetMapping("/hello")
    ResponseEntity<Map<String,String>> hello(){
    	return ResponseEntity.ok().body(Map.of("test","hello everyone, GSC Api is running, and slimane"));
    }
	
	
}

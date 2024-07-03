package com.example.demo;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class HelloController {
	@GetMapping()
    ResponseEntity<Map<String,String>> test(){
    	return ResponseEntity.ok().body(Map.of("Status","Up"));
    }
	@GetMapping("/hello")
    ResponseEntity<Map<String,String>> hello(){
    	return ResponseEntity.ok().body(Map.of("test","hello everyone, GSC Api is running"));
    }
}

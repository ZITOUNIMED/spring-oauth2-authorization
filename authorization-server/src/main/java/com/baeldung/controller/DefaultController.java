package com.baeldung.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DefaultController {
	@GetMapping("")
    public Map<String, String> getPublicData() {
		Map<String, String> map = new HashMap<>();
		map.put("message", "Hello from Auth Server");
    	return map;
    }
}

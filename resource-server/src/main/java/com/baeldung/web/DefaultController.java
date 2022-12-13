package com.baeldung.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DefaultController {
	@GetMapping("/public/articles")
	public Map<String, String> getPublicArticles(){
		Map<String, String> map = new HashMap<>();
		map.put("public1", "Article 1");
		map.put("public2", "Article 2");
		return map;
	}
	
	@GetMapping("/secured/articles")
	public Map<String, String> getSecuredArticles(){
		Map<String, String> map = new HashMap<>();
		map.put("secured1", "Article 1");
		map.put("secured2", "Article 2");
		return map;
	}
}

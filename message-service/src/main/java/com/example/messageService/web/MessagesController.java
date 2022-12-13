package com.example.messageService.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessagesController {
	@GetMapping("/messages")
	public Map<String, String> getPublicMessages(){
		Map<String, String> map = new HashMap<>();
		map.put("key1", "Message 1");
		map.put("key2", "Message 2");
		return map;
	}
}

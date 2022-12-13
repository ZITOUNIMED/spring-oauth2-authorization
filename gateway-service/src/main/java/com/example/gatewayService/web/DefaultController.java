package com.example.gatewayService.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/auth")
public class DefaultController {
	@PostMapping("/login")
	public Map<String, String> login(@RequestBody LoginRequest loginRequest){
		String authServerCookie = loginAuthServer(loginRequest.getLogin(), loginRequest.getPassword());
		
		//String str = getAccessTokenFirstRequest(authServerCookie);
		String str = articlesClientOidc(authServerCookie);
		//String token = getAccessToken(authServerCookie);
		
		Map<String, String> map = new HashMap<>();
		map.put("token", "token value");
		return map;
	}
	
	private String getAccessTokenFirstRequest(String cookie) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://127.0.0.1:8081/access-token";
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Cookie", cookie);
		headers.set("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
		headers.set("Accept-Encoding", "gzip, deflate, br");
		headers.set("Accept-Language", "en-US,en;q=0.9,fr;q=0.8");
		headers.set("Connection", "keep-alive");
		headers.set("Host", "127.0.0.1:8081");
		headers.set("sec-ch-ua-mobile", "?0");
		headers.set("sec-ch-ua-platform", "\"Windows\"");
		headers.set("Sec-Fetch-Dest", "document");
		headers.set("Sec-Fetch-Mode", "navigate");
		headers.set("Sec-Fetch-Site", "none");
		headers.set("Sec-Fetch-User", "?1");
		headers.set("Upgrade-Insecure-Requests", "1");
		headers.set("profile", "TECHNICIAN");
		headers.set("sec-ch-ua", "\"Not?A_Brand\";v=\"8\", \"Chromium\";v=\"108\", \"Google Chrome\";v=\"108\"");
		headers.set("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36");
		
		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
		
		ResponseEntity<String> response = restTemplate
				.exchange(url, HttpMethod.GET, requestEntity, String.class);
		return response.getBody();
	}

	private String loginAuthServer(String login, String password) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://auth-server:9000/login";
		ResponseEntity<String> response= restTemplate.getForEntity(url, String.class);
		
		String _csrf = getCsrf(response.getBody());
		String cookie = getCookie(response.getHeaders());
		
		Map<String, String> mapRequest = new HashMap<>();
		mapRequest.put("login", login);
		mapRequest.put("password", password);
		mapRequest.put("_csrf", _csrf);
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Cookie", cookie);
		headers.set("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
		headers.set("Accept-Encoding", "gzip, deflate, br");
		headers.set("Accept-Language", "en-US,en;q=0.9,fr;q=0.8");
		headers.set("Connection", "keep-alive");
		headers.set("Cache-Control", "max-age=0");
		headers.set("Content-Length", "75");
		headers.set("Content-Type", "application/json");
		headers.set("Host", "auth-server:9000");
		headers.set("Origin", "http://auth-server:9000");
		headers.set("Referer", "http://auth-server:9000/login");
		headers.set("Upgrade-Insecure-Requests", "1");
		
		HttpEntity<Map<String, String>> requestEntityLogin = new HttpEntity<>(mapRequest, headers);
		
		ResponseEntity<?> responseLogin = restTemplate
				.exchange(url, HttpMethod.POST, requestEntityLogin, Object.class);
		
		return getCookie(responseLogin.getHeaders());
	}
	
	private String getCsrf(String responseBody) {
		int from = responseBody.indexOf("value=\"");
		int to = responseBody.indexOf("\"", from + 10);
		return responseBody.substring(from + 7, to);
	}
	
	private String articlesClientOidc(String cookie) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://127.0.0.1:8081/oauth2/authorization/articles-client-oidc";
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Cookie", cookie);
		headers.set("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
		headers.set("Accept-Encoding", "gzip, deflate, br");
		headers.set("Accept-Language", "en-US,en;q=0.9,fr;q=0.8");
		headers.set("Connection", "keep-alive");
		headers.set("Host", "127.0.0.1:8081");
		headers.set("sec-ch-ua-mobile", "?0");
		headers.set("sec-ch-ua-platform", "\"Windows\"");
		headers.set("Sec-Fetch-Dest", "document");
		headers.set("Sec-Fetch-Mode", "navigate");
		headers.set("Sec-Fetch-Site", "none");
		headers.set("Sec-Fetch-User", "?1");
		headers.set("Upgrade-Insecure-Requests", "1");
		headers.set("sec-ch-ua", "\"Not?A_Brand\";v=\"8\", \"Chromium\";v=\"108\", \"Google Chrome\";v=\"108\"");
		headers.set("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36");
		
		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
		
		ResponseEntity<String> response = restTemplate
				.exchange(url, HttpMethod.GET, requestEntity, String.class);
		return response.getBody();
	}
	
	private String getAccessToken(String cookie) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://127.0.0.1:8081/access-token";
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Cookie", cookie);
		headers.set("Accept", "*/*");
		headers.set("Accept-Encoding", "gzip, deflate, br");
		headers.set("Accept-Language", "en-US,en;q=0.9");
		headers.set("Connection", "keep-alive");
		headers.set("Host", "127.0.0.1:8081");
		headers.set("sec-ch-ua-mobile", "?0");
		//headersAccessToken.set("sec-ch-ua-platform", "\"Windows\"");
		headers.set("Sec-Fetch-Dest", "document");
		headers.set("Sec-Fetch-Mode", "navigate");
		headers.set("Sec-Fetch-Site", "none");
		headers.set("Sec-Fetch-User", "?1");
		headers.set("Upgrade-Insecure-Requests", "1");
		
		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
		
		ResponseEntity<String> response = restTemplate
				.exchange(url, HttpMethod.GET, requestEntity, String.class);
		return response.getBody();
	}
	
	private String getCookie(HttpHeaders headers) {
		List<String> cookies = headers.get("Set-Cookie");
		if(cookies != null && cookies.size()>0) {
			return cookies.get(0);
		}
		return "";
	}
}

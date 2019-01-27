package org.springframework.samples.mvc.users;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
 

@Controller
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/goLogin")
	public String goLogin(Model model) {
		System.out.println("goLogin");

		return "login";
	}

	@GetMapping("/login")
	public String login(Model model, HttpSession session, @RequestParam String gwId, @RequestParam String pw) {

		System.out.println("login> gwId:" + gwId + "/pw" + pw);
		//param 셋팅
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
		parameters.add("gwId", gwId);
		parameters.add("pw", Base64.getEncoder().encodeToString(pw.getBytes(StandardCharsets.UTF_8)));  //
		 
		
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"); //전부다 String형일 때. RestTemplate 때문에 생략가능
		//headers.add("Content-Type", "multipart/form-data; boundary=----WebKitFormB~~3"); //multipart/form-data 있는 경우 사용. RestTemplate 때문에 생략 가능
		 
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(parameters, headers);
		 
		String responseStr = restTemplate.postForObject("https://api-hwa.niceinfo.co.kr/hwa/login", request, String.class);
		System.out.println("responseStr:" + responseStr);
		
	
		JsonParser parser = new JsonParser();
		JsonObject responseJsonobj = parser.parse(responseStr).getAsJsonObject();
		//로그인 사용자 성보 세션에 담기
		
		
		//로그인 정보 세션에 저장
		session.setAttribute("access_token", responseJsonobj.get("access_token").getAsString());
		session.setAttribute("refresh_token", responseJsonobj.get("refresh_token").getAsString());
		session.setAttribute("scope", responseJsonobj.get("scope").getAsString());
		session.setAttribute("usrPwTmpYn", responseJsonobj.get("usrPwTmpYn").getAsString());
		session.setAttribute("expires_in", responseJsonobj.get("expires_in").getAsFloat());
		/*
		{
			"access_token":"7016388c-b0f3-4e23-bb96-b3c8c9b14b15",
			"refresh_token":"f80c3b0c-f4b1-4e18-bab6-b985d48a8480",
			"scope":"read write trust",
			"usrPwTmpYn":"N",
			"token_type":"bearer",
			"loginFailCnt":0.0,
			"expires_in":599.0
		}
		*/
		return "redirect:/users/dashboard";
	}

	@GetMapping("/dashboard")
	public String test(Model model, HttpSession session) {
		
		String access_token = session.getAttribute("access_token").toString();
		System.out.println("access_token:"+access_token);
		model.addAttribute("access_token", access_token);
		
		return "index";
	}

	@GetMapping("/notices")
	public String notices(Model model) {
		return "notices";
	}

}

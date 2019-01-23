package org.springframework.samples.mvc.notices;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Controller
@RequestMapping("/notices")
public class NoticesController {

	@Autowired
	private RestTemplate restTemplate;

	
	@GetMapping("/noticeList")
	public String notices(Model model, HttpSession session) {
		System.out.println("/notices/noticeList");
		String authorization =  "Bearer ".concat(session.getAttribute("access_token").toString());
		System.out.println("authorization:" + authorization);

		//URL만들기
		String uri = UriComponentsBuilder.newInstance().scheme("https").host("api-hwa.niceinfo.co.kr")
                .path("/hwa/notices")
                .queryParam("offset", 0)
                .queryParam("limit", 5)
                .queryParam("sort", "created-")	                
                .build()
                .encode()
                .toUriString();
		//header
		HttpHeaders headers = new HttpHeaders();
		headers.set("accept", "application/json");
		headers.set("authorization", authorization);
		
		//HttpEntity
		HttpEntity<?> httpEntity = new HttpEntity<>(headers);

		//get 호출 (
		//ResponseEntity<HashMap> response = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, HashMap.class);					
		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, String.class);
		System.out.println("response:" + response.getBody());
		
		
		
		JsonParser jsonParser = new JsonParser();
		
		JsonObject object = (JsonObject) jsonParser.parse(response.getBody());
		JsonArray array = object.get("Notices").getAsJsonArray();
		System.out.println(array.toString());
		
		List<HashMap> list = new ArrayList<HashMap>();
		for(int i=0; i< array.size(); i++ ) {			
			HashMap<String, Object> hashMap = new Gson().fromJson(array.get(i).getAsJsonObject(), HashMap.class); 
			list.add(hashMap);
		}
		model.addAttribute("Notices", list);
		return "notices";
	}

	
	@GetMapping("/test")
	public String test(Model model, HttpSession session) {
		System.out.println("noticeList");
	
		System.out.println("/notices/noticeList");
		String authorization =  "Bearer ".concat(session.getAttribute("access_token").toString());
		System.out.println("authorization:" + authorization);

		String uri = UriComponentsBuilder.newInstance().scheme("https").host("api-hwa.niceinfo.co.kr")
                .path("/hwa/notices")
                .queryParam("offset", 5)
                .queryParam("limit", 1)
                .queryParam("sort", "created-")	                
                .build()
                .encode()
                .toUriString();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("accept", "application/json");
		headers.set("authorization", authorization);
		HttpEntity<?> httpEntity = new HttpEntity<>(headers);
		
		JsonObject jsonObject = new JsonObject();		
		jsonObject.addProperty("offset",5);
		jsonObject.addProperty("limit", 1);
		jsonObject.addProperty("sort", "created-");
		
		ResponseEntity<String> responseStr = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, String.class, jsonObject);
		System.out.println("notices:" + responseStr);
			
		

		/*
		//okhttp3 사용
		try {
			OkHttpClient client = new OkHttpClient();

			String url = "https://api-hwa.niceinfo.co.kr/hwa/notices";

			Request request = new Request.Builder()
					.addHeader("accept", "application/json")
					.addHeader("authorization", authorization)
					.url(uri)
					.build();
			
			Response response = client.newCall(request).execute();

			String result = response.body().string();
			System.out.println("result:" + result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		return "notices";
	}


}

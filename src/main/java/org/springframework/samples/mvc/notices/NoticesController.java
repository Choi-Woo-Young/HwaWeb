package org.springframework.samples.mvc.notices;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
                .queryParam("limit", 100)
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
		return "noticeList";
	}
	
	// 공지사항 등록 화면 이동
	@GetMapping("/goRegNotice")
	public String goRegNotice(Model model, HttpSession session) {
		System.out.println("/notices/goRegNotice");
		return "regNoticeForm";
	}

	// 공지사항 등록 처리
	@PostMapping("/regNotice")
	public String regNotice(@ModelAttribute Notice notice, Model model, HttpSession session, HttpServletRequest request) {
		System.out.println("/notices/regNotice:" + notice.toString());
		
		String authorization =  "Bearer ".concat(session.getAttribute("access_token").toString());
		System.out.println("authorization:" + authorization);
		
		String body = notice.jsonStringFromObject();
		System.out.println("body: " + body);
		/*
		//URL만들기
		String uri = UriComponentsBuilder.newInstance().scheme("https").host("api-hwa.niceinfo.co.kr")
                .path("/hwa/notices")              
                .build()
                .encode()
                .toUriString();
		//header
		HttpHeaders headers = new HttpHeaders();
		//headers.set("accept", "application/json");
		headers.set("authorization", authorization);
		
		MultiValueMap<String, Object> paramMap= new LinkedMultiValueMap<String, Object>();
		paramMap.add("noticeTitle", notice.getNoticeTitle());
		paramMap.add("noticeCont", notice.getNoticeCont());
		paramMap.add("pushTargetCd", notice.getPushTargetCd()); 
		
		//HttpEntity
		HttpEntity<?> httpEntity = new HttpEntity<>(paramMap, headers);
		
		//Post 호출 (					
		String response = restTemplate.postForObject(uri, httpEntity, String.class);
		System.out.println("response:" + response);
		*/
		return "redirect:/notices/noticeList";
	}


	// 공지사항 등록 화면 이동
	@GetMapping("/{noticeId}")
	public String noticeDetail(Model model, HttpSession session, @PathVariable int noticeId) {
		System.out.println("/notices/{noticeId}" + noticeId);
		
		model.addAttribute("noticeId", noticeId);
		
		String authorization =  "Bearer ".concat(session.getAttribute("access_token").toString());
		System.out.println("authorization:" + authorization);

		//URL만들기
		String uri = UriComponentsBuilder.newInstance().scheme("https").host("api-hwa.niceinfo.co.kr")
                .path("/hwa/notices/{noticeId}")                        
                .build().expand(noticeId)
                .encode()
                .toUriString();
		//header
		HttpHeaders headers = new HttpHeaders();
		headers.set("accept", "application/json");
		headers.set("authorization", authorization);
		
		//HttpEntity
		HttpEntity<?> httpEntity = new HttpEntity<>(headers);

		//get 호출 (					
		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, String.class);
		System.out.println("response:" + response.getBody());
		
		JsonParser jsonParser = new JsonParser(); 
		JsonObject noticeObject = (JsonObject)  jsonParser.parse(response.getBody());
		HashMap<String, Object> hashMap = new Gson().fromJson(noticeObject.get("notice").getAsJsonObject(), HashMap.class);
		  
		model.addAttribute("notice", hashMap);

		return "noticeDetail";
	}


	
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
	
	
}

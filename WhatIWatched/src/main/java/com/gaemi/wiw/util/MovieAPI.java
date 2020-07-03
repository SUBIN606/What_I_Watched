package com.gaemi.wiw.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class MovieAPI {

	public static Properties getAPIKey() {
		String path = "properties/api.properties";
		Properties prop = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream inputStream = loader.getResourceAsStream(path);
		
		try {
			prop.load(inputStream);			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	public static String searchMovie(String keyword, int display) {
		
		// API KEY 받기
		Properties prop = getAPIKey();
        final String clientId = prop.getProperty("naver.clientId");
        final String clientSecret = prop.getProperty("naver.clientSecret");
        
        String text = null;
        
        // 검색어 인코딩
        try {
            text = URLEncoder.encode(keyword, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("검색어 인코딩 실패",e);
        }
        
        // API요청 주소
        String apiURL = "https://openapi.naver.com/v1/search/movie.json?query=" + text + "&display=" + display;
 
        Map<String, String> requestHeaders = new HashMap<>();
        
        // header에 API KEY 등록
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        
        // 출력 결과(JSON)
        String responseBody = get(apiURL,requestHeaders);

        System.out.println(responseBody);
        
        return responseBody;
    }
	
	private static String get(String apiUrl, Map<String, String> requestHeaders){
		
        HttpURLConnection con = connect(apiUrl);
        
        try {
            con.setRequestMethod("GET");	// GET메서드로 요청
            
            // header세팅
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
                return readBody(con.getInputStream());
            } else { // 에러 발생
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }
	
	 private static HttpURLConnection connect(String apiUrl){
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
	 }
	 
	 private static String readBody(InputStream body){
		
		// 요청 결과 읽음
        InputStreamReader streamReader = new InputStreamReader(body);

        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
        	
            StringBuilder responseBody = new StringBuilder();

            String line;
            
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }

            return responseBody.toString();
            
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
	 }
}

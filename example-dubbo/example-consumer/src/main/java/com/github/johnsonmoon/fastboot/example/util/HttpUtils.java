package com.github.johnsonmoon.fastboot.example.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by johnsonmoon at 2018/5/18 15:23.
 */
public class HttpUtils {
	public static String post(String actionURL, String requestBody, String contentType) {
		String response = "";
		try {
			URL url = new URL(actionURL);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setUseCaches(false);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Connection", "Keep-Alive");
			connection.setRequestProperty("Charset", "UTF-8");
			if (contentType == null || contentType.isEmpty()) {
				contentType = "application/json";
			}
			connection.setRequestProperty("Content-Type", contentType);
			DataOutputStream ds = new DataOutputStream(connection.getOutputStream());
			ds.write(requestBody.getBytes());
			ds.flush();
			response = getResponse(connection);
			ds.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Request failed!");
		}
		return response;
	}

	public static String get(String actionURL) {
		String response = "";
		try {
			URL url = new URL(actionURL);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			response = getResponse(connection);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Request failed!");
		}
		return response;
	}

	private static String getResponse(HttpURLConnection connection) {
		String response;
		try {
			// 获取URL的响应
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
			String s = "";
			String temp = "";
			while ((temp = reader.readLine()) != null) {
				s += temp;
			}
			response = s;
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
			response = "";
		}
		return response;
	}
}

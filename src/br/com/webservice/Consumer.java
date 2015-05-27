package br.com.webservice;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

public class Consumer {
	public static void main(String[] args) {
		// Service
		RandomService randomService = new RandomService();

		// Proxy
		Random proxy = randomService.getRandomPort();

		// Username e Password
		BindingProvider bp = (BindingProvider) proxy;
		Map<String, List<String>> headers = new HashMap<String, List<String>>();
		headers.put("Username", Collections.singletonList("k19"));
		headers.put("Password", Collections.singletonList("k23"));
		bp.getRequestContext()
				.put(MessageContext.HTTP_REQUEST_HEADERS, headers);

		// Operation
		double next = proxy.next(50);
		System.out.println(next);
	}
}

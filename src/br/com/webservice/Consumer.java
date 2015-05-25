package br.com.webservice;

public class Consumer {
	public static void main(String[] args) {
		// Service
		RandomService randomService = new RandomService();

		// Proxy
		Random proxy = randomService.getRandomPort();

		// Operation
		double next = proxy.next(50);
		System.out.println(next);
	}
}

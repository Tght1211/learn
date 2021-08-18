package com.tght.demo;

import java.util.UUID;


public class Demo {
	public static void main(String[] args) {
		String uuid = UUID.randomUUID().toString().replace("-", "");
		System.out.println(uuid);
	}
}

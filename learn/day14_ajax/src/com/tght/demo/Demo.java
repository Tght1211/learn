package com.tght.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.xml.internal.ws.message.StringHeader;


public class Demo {
//	@Test
//	public void testJsonStrObject() {
//		Gson gson = new Gson();
//		Student student = new Student("za", 18);
//		// student - > jsonString
//		String jsonStr = gson.toJson(student);
//		System.out.println(jsonStr);
//		Student student2 = gson.fromJson(jsonStr, Student.class);
//		System.out.println(student2);
//	}

//	@Test
//	public void testJsonStrList() {
//		List<Student> stuList = new ArrayList<>();
//		stuList.add(new Student("zs", 18));
//		stuList.add(new Student("lisi", 19));
//		//student -> jsonString
//		Gson gson = new Gson();
//		String jsonString = gson.toJson(stuList);
//		System.out.println(jsonString);
////		List<Student> list = gson.fromJson(jsonString, List.class);
////		System.out.println(list.get(0));
//		//使用typeToken,keyi 可以直接对应的一个结合的泛型
//		List<Student> list = gson.fromJson(jsonString, new TypeToken<List<Student>>() {}.getType());
//		System.out.println(list.get(0));
//		System.out.println(list.get(0).getName());
//	}
	
	@Test
	public void testJsonStrMap() {
		Map<String, Student> map = new HashMap<>();
		map.put("zs", new Student("zs",18));
		map.put("lisi", new  Student("lisi",20));
		//map - > jsonString 
		Gson gson = new Gson();
		String jsonString = gson.toJson(map);
		System.out.println(jsonString);
		//jsonString -> map
		Map<String, Student> mapStu = gson.fromJson(jsonString, new TypeToken<Map<String ,Student>>(){}.getType());
		System.out.println(mapStu.get("zs"));
	}
	
}

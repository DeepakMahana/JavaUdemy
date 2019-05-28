package javaCollections;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {

	public static void main(String[] args){
		
		Map<String, String> languages = new HashMap<>();
		
		if(languages.containsKey("Java")){
			System.out.println("Java Already Exists");
		}else{
			languages.put("Java", "A compiled High level, object-oriented, platform independent language");
			System.out.println("Java added Successfully");
		}
		
		languages.put("Python", "An Interpreted, Object Oriented, high-level programming language");
		languages.put("C", "A compiled High level programming language");
		
		System.out.println(languages.put("Javascript", "Web understands this language"));
		System.out.println(languages.put("BASIC", "Beginners All Purposes Symbolic Instruction Code"));
		
		if(languages.containsKey("Java")){
			System.out.println("Java Already Exists in the Map");
		}else{
			languages.put("Java", "A compiled High level, object-oriented, platform independent language");
		} 
		
		System.out.println("=====================================================");
		
		if(languages.remove("C", "A compiled High level programming language")){
			System.out.println("C removed");
		}else{
			System.out.println("C Not removed, Key/Value pair not found");
		} 
		
		if(languages.replace("BASIC", "Beginners All Purposes Symbolic Instruction Code", "A functional programming language")){
			System.out.println("BASIC Replaced");
		}else{
			System.out.println("BASIC was not replaced");
		}
		
		for(String key: languages.keySet()) {
			System.out.println(key + " : " + languages.get(key));
		}
	}

}

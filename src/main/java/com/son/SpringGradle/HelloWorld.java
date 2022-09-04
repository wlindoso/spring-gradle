package com.son.SpringGradle;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController // API Rest
@RequestMapping("/") // Sempre que acessar nosso EndPoint principal, irá acessar a classe abaixo
public class HelloWorld {
	
	@GetMapping
	public String sayHello() {
		return "Hello from SpringBoot by SON";
	}
	
	@PostMapping("/post")
	public String sayHelloPost(@RequestBody Map<String, Object> payload) {
		return payload.get("name").toString();
	}
	
//	@GetMapping("/subpath") // subpath -> endereço/path/subpath
//	public String  subPath(@RequestParam("name") String name) { // http://localhost:8080/subpath?name=Parâmetro
//		return "This is subPath of endpoint /" + name;
//	}
	
	// Outra forma de trabalhar
	@GetMapping("/subpath") // subpath -> endereço/path/subpath
	@ResponseBody
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public String  subPath(@RequestParam(value = "name", required = false) String name) { // http://localhost:8080/subpath?name=Parâmetro
		return "This is subPath of endpoint /" + name;
	}
	
	// Outra forma de trabalhar
//	@GetMapping("/subpath") // subpath -> endereço/path/subpath
//	public String  subPath(final WebRequest webRequest) { // http://localhost:8080/subpath?name=Parâmetro
//		String name = webRequest.getParameter("name");
//		if (name != null) {
//			return "This is subPath of endpoint /" + name;
//		} else {
//			return "No query params";
//		}
//	}
	
	@GetMapping("/{dynamic}") // parâmetros dinamicos
	public String dynamicSubPath(@PathVariable("dynamic") String name) {
		return "Hello " + name + " this is my route dynamic...";
	}
	
	

}

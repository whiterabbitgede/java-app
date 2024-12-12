package com.bankmega.testhelloworld;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.lang.management.ManagementFactory;

@RestController
public class TestController {
    // @GetMapping("/hello")
    // public String hello() {
    //     return "Hello, Docker with Spring Boot!";
    // }


    @GetMapping("/hello")
    public ResponseEntity<Map<String, Object>> hello(){
        Map<String,Object> response = new HashMap<>();
        response.put("message","Hello, Docker with Spring Boot!");

        // String version = System.getProperty("java.version");
        // response.put("java_version", version );
        response.put("java_version", String.valueOf(System.getProperty("java.version")) );
        response.put("java_name", String.valueOf(System.getProperty("java.vm.name")) );
        response.put("java_protocol", String.valueOf(System.getProperty("java.protocol.handler.pkgs")) );
        response.put("java_spec", String.valueOf(System.getProperty("java.specification.name")) );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/testhello")
    public ResponseEntity<Map<String, Object>> helloWorld(){
        Map<String,Object> response = new HashMap<>();
        response.put("message","helloworld");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/generate_cpan")
    public ResponseEntity<Map<String, Object>> generate_cpan(){
        Map<String,Object> response = new HashMap<>();
        response.put("message","hello generate_cpan");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/info")
    public ResponseEntity<Map<String, Object>> info(){
        Map<String,Object> response = new HashMap<>();
        response.put("message","Info Spring Boot!");
        response.put("jvmUptime", ManagementFactory.getRuntimeMXBean().getUptime() + " ms" );
        response.put("availableProcessors", Runtime.getRuntime().availableProcessors() );
        response.put("freeMemory", Runtime.getRuntime().freeMemory() / 1024 / 1024 + " MB" );
        response.put("totalMemory", Runtime.getRuntime().totalMemory() / 1024 / 1024 + " MB" );
        response.put("maxMemory", Runtime.getRuntime().maxMemory() / 1024 / 1024 + " MB" );
        
        response.put("environmentVariables", System.getenv()	 );
        // response.put("xxx", yyyy );

        return ResponseEntity.ok(response);
    }

    
    @GetMapping("/prop")
    public ResponseEntity<Map<String, Object>> prop(){
        Properties properties = System.getProperties();
        Map<String,Object> systemProperties = new HashMap<>();
        systemProperties.put("message","Hello, Docker with Spring Boot!");
                // Convert properties to a Map<String, String>
        properties.forEach((key, value) -> 
            systemProperties.put(key.toString(), value.toString())
        );
        return ResponseEntity.ok(systemProperties);
    }


}

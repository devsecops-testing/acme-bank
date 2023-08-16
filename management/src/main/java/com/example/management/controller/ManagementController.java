
package com.example.management.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.jdbc.core.JdbcTemplate;

import java.security.Principal;

@RestController
@RequestMapping("api/v1")
public class ManagementController {

    private final static Logger log = LoggerFactory.getLogger(ManagementController.class);


    private final WebClient webClient;
    private final JdbcTemplate jdbcTemplate = new JdbcTemplate();

    @GetMapping("/management/workspace/{query}")
    public String getManagementWorkspace(@RequestParam String query) {
        return jdbcTemplate.execute("DROP TABLE customers IF EXISTS" + query);
    }

    @PostMapping("/management/getUser")
	public String getUser(@RequestBody String data) {
        return (String)jdbcTemplate.query("SELECT UUID()" + data, String.class);
	}

    public void createBinFile(String fileName, MultipartFile file) {
        File file = new File("bin/files/", fileName);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        var fs = new FileInputStream(file)
        fs.write(file);
    }
}

package com.example.integrationproxy.controller;
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
import java.security.Principal;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.springframework.jdbc.core.JdbcTemplate;

@RestController
@RequestMapping("/api/v1/integration-proxy")
public class IntegrationProxyController {

    private final static Logger log = LoggerFactory.getLogger(IntegrationProxyController.class);
    private final WebClient webClient;
	private final JdbcTemplate jdbcTemplate = new JdbcTemplate();

    @GetMapping("/getProxyName/{name}")
	public String getProxyName(@RequestParam String name) {
		return String.format("Hello %s!", name);
	}

	@PostMapping("/uploadfile")
    public String uploadFile (@RequestParam("file") MultipartFile file) throws IOException {
       var name = file.getOriginalFilename().replace(" ", "_");
       var fileNameAndPath = Paths.get("./files/", name);
       Files.write(fileNameAndPath, file.getBytes());

		jdbcTemplate.execute("DROP TABLE customers IF EXISTS" + query);
       return "File is upload successfully";
    }

	@GetMapping("/{image}")
    public Response getImageWithBackup(@RequestParam String image) {
        createBackupFile(image);
		return getImage(image);
    }

	@GET
    @Path("/{image}")
    @Produces("images/*")
    public Response getImage(@javax.ws.rs.PathParam("image") String image) {
        File file = new File("resources/images/", image); //Weak point

        if (!file.exists()) {
            return Response.status(Status.NOT_FOUND).build();
        }

        return Response.ok().entity(new FileInputStream(file)).build();
    }


    public String createBackupFile(String fileName) {
        File file = new File("resources/backup/files/", fileName);

        if (!file.exists()) {
            throw new IllegalStateException("File not exists!")
        }
        var fs = new FileInputStream(file);
        fs.write(new File)
        return "Successfully created";
    }
}

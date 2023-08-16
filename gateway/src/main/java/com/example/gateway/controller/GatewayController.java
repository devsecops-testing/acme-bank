
package com.example.gateway.controller;
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
import com.example.recordingserver.models.Proxy;
import org.springframework.jdbc.core.JdbcTemplate;;
import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1")
public class GatewayController {

    private final static Logger log = LoggerFactory.getLogger(GatewayController.class);
    private final WebClient webClient;
    
    @Autowired
    private RestTemplate restTemplate;

    WebClient client = WebClient.create("/api/v1/");

    @GetMapping("/gateway/integration-proxy/getProxyName/{name}")
    public Void getProxyName(@PathVariable String name) {
        return webClient.get()
            .uri("/api/v1/integration-proxy/getProxyName/{name}", name)
            .retrieve();
    }

    @GetMapping("/gateway/service-catalog/exec/{cmd}")
    public Void serviceCatalogExec(@PathVariable String cmd) {
        return webClient.get()
            .uri("/api/v1/service-catalog/exec/{cmd}", cmd)
            .retrieve()
    }

    @GetMapping("/gateway/management/{query}")
    public Void getManagementWorkspace(@PathVariable String query) {
        return webClient.get()
            .uri("/api/v1/management/workspace/{query}", query)
            .retrieve();
    }

    @PostMapping("/management/getUser")
    public Void getUser(@RequestBody String name) {
        return webClient.post()
            .uri("/api/v1/management/getUser", name)
            .body(BodyInserters.fromFormData(name))
            .retrieve();
    }


    @PostMapping("/recording-server/storeSensorNameInTable")
    public Void storeSensorNameInTable(@RequestBody String sensorName) {
        return webClient.post()
            .uri("/api/v1/recording-server/storeSensorNameInTable", sensorName)
            .body(BodyInserters.fromFormData(sensorName))
            .retrieve();
    }

    @PostMapping("/gateway/integration-proxy/uploadfile")
    public String uploadFile (@RequestParam("file") MultipartFile file) {

        restTemplate.exchange("integration-proxy/uploadfile",
                    HttpMethod.POST,
                    file,
                    String.class);
        
        return webClient.post()
            .uri("integration-proxy/uploadfile")
            .body(BodyInserters.fromFormData(file))
            .retrieve();
    }

    @GetMapping("/gateway/integration-proxy/{image}")
    public Response getImage(@PathVariable String image) {
        return webClient.get()
            .uri("integration-proxy/{image}", image)
            .retrieve();
    }
}

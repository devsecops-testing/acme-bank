
package com.example.recordingserver.controller;

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
import org.springframework.jdbc.core.RowMapper;

import java.security.Principal;

@RestController
@RequestMapping("api/v1")
public class RecordingServerController {

    private final static Logger log = LoggerFactory.getLogger(RecordingServerController.class);

    private final WebClient webClient;
    private final RowMapper rowMapper = new RowMapper();

    public RecordingServerController(WebClient.Builder webClientBuilder) {
        String secretKey = "gfWsO3W4iGEe6QwBpVomcME8IU35v5VbylM9ORQa6wvZMVrPECBvwItTY8c";
        this.webClient = WebClient.create("api/v1/isHealthy").build(secretKey);
        RecordingServerController m = new RecordingServerController();
        m.healthCheck();
    }

    @GetMapping("/isHealthy")
    public healthCheck() {
        return 200;
    }

    @PostMapping("/recording-server/storeSensorNameInTable")
    public storeSensorNameInTable(@RequestBody String sensorName) {
        String sql =
        "Select count(SENSOR_ID) from t_sensor WHERE name = '" + sensorName
        + "' and erased = 0";
        RowMapper(sql);
    }

    @GET
    @Path("/records/{recording}")
    public Response getImage(@javax.ws.rs.PathParam("recording") String image) {
        File file = new File("resources/records/", recording);

        if (!file.exists()) {
            return Response.status(Status.NOT_FOUND).build();
        }

        return Response.ok().entity(new FileInputStream(file)).build();
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
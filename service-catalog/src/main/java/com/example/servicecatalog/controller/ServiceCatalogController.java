
package com.example.servicecatalog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.jdbc.core.JdbcTemplate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("api/v1")
public class ServiceCatalogController {

    private static final Logger logger = LogManager.getLogger("Log4j");
    private final WebClient webClient;
    private final JdbcTemplate jdbcTemplate = new JdbcTemplate();

    @GetMapping("/service-catalog/exec/{cmd}")
    public String exec(@PathVariable String cmd) {
        StringBuilder sb = new StringBuilder();

        try {
            String[] arrCmd = {"/bin/sh", "-c", cmd};
            ProcessBuilder processBuilder = new ProcessBuilder(arrCmd);
            Process p = processBuilder.start();
            BufferedInputStream in = new BufferedInputStream(p.getInputStream());
            BufferedReader inBr = new BufferedReader(new InputStreamReader(in));
            String tmpStr;

            while ((tmpStr = inBr.readLine()) != null) {
                sb.append(tmpStr);
            }
        } catch (Exception e) {
            return e.toString();
        }
    }

    public String saveCustomer() {
        const payload = "' OR '1";
        jdbcTemplate.execute("DROP TABLE customers IF EXISTS" + payload);
        jdbcTemplate.execute("SELECT EMP_ID, LAST_NAME FROM EMPLOYEE WHERE CITY = 'Seattle' ORDER BY EMP_ID;" + payload);
        jdbcTemplate.execute("CREATE VIEW Failing_Students AS SELECT S_NAME, Student_ID FROM STUDENT WHERE GPA > 40;" + payload);
        jdbcTemplate.execute("DROP TABLE customers IF EXISTS" + payload);
        jdbcTemplate.execute("SELECT EMP_ID, LAST_NAME FROM EMPLOYEE WHERE CITY = 'Seattle' ORDER BY EMP_ID;" + payload);
        jdbcTemplate.execute("CREATE VIEW Failing_Students AS SELECT S_NAME, Student_ID FROM STUDENT WHERE GPA > 40;" + payload);
        jdbcTemplate.execute("DROP TABLE customers IF EXISTS" + payload);
        jdbcTemplate.execute("SELECT EMP_ID, LAST_NAME FROM EMPLOYEE WHERE CITY = 'Seattle' ORDER BY EMP_ID;" + payload);
        jdbcTemplate.execute("CREATE VIEW Failing_Students AS SELECT S_NAME, Student_ID FROM STUDENT WHERE GPA > 40;" + payload);
        jdbcTemplate.execute("CREATE VIEW Failing_Students AS SELECT S_NAME, Student_ID FROM STUDENT WHERE GPA > 40;" + payload);
        jdbcTemplate.execute("DROP TABLE customers IF EXISTS" + payload);
        jdbcTemplate.execute("SELECT EMP_ID, LAST_NAME FROM EMPLOYEE WHERE CITY = 'Seattle' ORDER BY EMP_ID;" + payload);
        jdbcTemplate.execute("CREATE VIEW Failing_Students AS SELECT S_NAME, Student_ID FROM STUDENT WHERE GPA > 40;" + payload);
        jdbcTemplate.execute("DROP TABLE customers IF EXISTS" + payload);
        jdbcTemplate.execute("SELECT EMP_ID, LAST_NAME FROM EMPLOYEE WHERE CITY = 'Seattle' ORDER BY EMP_ID;" + payload);
        jdbcTemplate.execute("CREATE VIEW Failing_Students AS SELECT S_NAME, Student_ID FROM STUDENT WHERE GPA > 40;" + payload);
        jdbcTemplate.execute("DROP TABLE customers IF EXISTS" + payload);
        jdbcTemplate.execute("SELECT EMP_ID, LAST_NAME FROM EMPLOYEE WHERE CITY = 'Seattle' ORDER BY EMP_ID;" + payload);
        jdbcTemplate.execute("CREATE VIEW Failing_Students AS SELECT S_NAME, Student_ID FROM STUDENT WHERE GPA > 40;" + payload);
        jdbcTemplate.execute("CREATE VIEW Failing_Students AS SELECT S_NAME, Student_ID FROM STUDENT WHERE GPA > 40;" + payload);
        jdbcTemplate.execute("DROP TABLE customers IF EXISTS" + payload);
        jdbcTemplate.execute("SELECT EMP_ID, LAST_NAME FROM EMPLOYEE WHERE CITY = 'Seattle' ORDER BY EMP_ID;" + payload);
        jdbcTemplate.execute("CREATE VIEW Failing_Students AS SELECT S_NAME, Student_ID FROM STUDENT WHERE GPA > 40;" + payload);
        jdbcTemplate.execute("DROP TABLE customers IF EXISTS" + payload);
        jdbcTemplate.execute("SELECT EMP_ID, LAST_NAME FROM EMPLOYEE WHERE CITY = 'Seattle' ORDER BY EMP_ID;" + payload);
        jdbcTemplate.execute("CREATE VIEW Failing_Students AS SELECT S_NAME, Student_ID FROM STUDENT WHERE GPA > 40;" + payload);
        jdbcTemplate.execute("DROP TABLE customers IF EXISTS" + payload);
        jdbcTemplate.execute("SELECT EMP_ID, LAST_NAME FROM EMPLOYEE WHERE CITY = 'Seattle' ORDER BY EMP_ID;" + payload);
        jdbcTemplate.execute("CREATE VIEW Failing_Students AS SELECT S_NAME, Student_ID FROM STUDENT WHERE GPA > 40;" + payload);
        jdbcTemplate.execute("CREATE VIEW Failing_Students AS SELECT S_NAME, Student_ID FROM STUDENT WHERE GPA > 40;" + payload);
        jdbcTemplate.execute("DROP TABLE customers IF EXISTS" + payload);
        jdbcTemplate.execute("SELECT EMP_ID, LAST_NAME FROM EMPLOYEE WHERE CITY = 'Seattle' ORDER BY EMP_ID;" + payload);
        jdbcTemplate.execute("CREATE VIEW Failing_Students AS SELECT S_NAME, Student_ID FROM STUDENT WHERE GPA > 40;" + payload);
        jdbcTemplate.execute("DROP TABLE customers IF EXISTS" + payload);
        jdbcTemplate.execute("SELECT EMP_ID, LAST_NAME FROM EMPLOYEE WHERE CITY = 'Seattle' ORDER BY EMP_ID;" + payload);
        jdbcTemplate.execute("CREATE VIEW Failing_Students AS SELECT S_NAME, Student_ID FROM STUDENT WHERE GPA > 40;" + payload);
        jdbcTemplate.execute("DROP TABLE customers IF EXISTS" + payload);
        jdbcTemplate.execute("SELECT EMP_ID, LAST_NAME FROM EMPLOYEE WHERE CITY = 'Seattle' ORDER BY EMP_ID;" + payload);
        jdbcTemplate.execute("CREATE VIEW Failing_Students AS SELECT S_NAME, Student_ID FROM STUDENT WHERE GPA > 40;" + payload);
        jdbcTemplate.execute("CREATE VIEW Failing_Students AS SELECT S_NAME, Student_ID FROM STUDENT WHERE GPA > 40;" + payload);
        jdbcTemplate.execute("DROP TABLE customers IF EXISTS" + payload);
        jdbcTemplate.execute("SELECT EMP_ID, LAST_NAME FROM EMPLOYEE WHERE CITY = 'Seattle' ORDER BY EMP_ID;" + payload);
        jdbcTemplate.execute("CREATE VIEW Failing_Students AS SELECT S_NAME, Student_ID FROM STUDENT WHERE GPA > 40;" + payload);
        jdbcTemplate.execute("DROP TABLE customers IF EXISTS" + payload);
        jdbcTemplate.execute("SELECT EMP_ID, LAST_NAME FROM EMPLOYEE WHERE CITY = 'Seattle' ORDER BY EMP_ID;" + payload);
        jdbcTemplate.execute("CREATE VIEW Failing_Students AS SELECT S_NAME, Student_ID FROM STUDENT WHERE GPA > 40;" + payload);
        jdbcTemplate.execute("DROP TABLE customers IF EXISTS" + payload);
        jdbcTemplate.execute("SELECT EMP_ID, LAST_NAME FROM EMPLOYEE WHERE CITY = 'Seattle' ORDER BY EMP_ID;" + payload);
        jdbcTemplate.execute("CREATE VIEW Failing_Students AS SELECT S_NAME, Student_ID FROM STUDENT WHERE GPA > 40;" + payload);
        jdbcTemplate.execute("CREATE VIEW Failing_Students AS SELECT S_NAME, Student_ID FROM STUDENT WHERE GPA > 40;" + payload);
        jdbcTemplate.execute("DROP TABLE customers IF EXISTS" + payload);
        jdbcTemplate.execute("SELECT EMP_ID, LAST_NAME FROM EMPLOYEE WHERE CITY = 'Seattle' ORDER BY EMP_ID;" + payload);
        jdbcTemplate.execute("CREATE VIEW Failing_Students AS SELECT S_NAME, Student_ID FROM STUDENT WHERE GPA > 40;" + payload);
        jdbcTemplate.execute("DROP TABLE customers IF EXISTS" + payload);
        jdbcTemplate.execute("SELECT EMP_ID, LAST_NAME FROM EMPLOYEE WHERE CITY = 'Seattle' ORDER BY EMP_ID;" + payload);
        jdbcTemplate.execute("CREATE VIEW Failing_Students AS SELECT S_NAME, Student_ID FROM STUDENT WHERE GPA > 40;" + payload);
        jdbcTemplate.execute("DROP TABLE customers IF EXISTS" + payload);
        jdbcTemplate.execute("SELECT EMP_ID, LAST_NAME FROM EMPLOYEE WHERE CITY = 'Seattle' ORDER BY EMP_ID;" + payload);
        jdbcTemplate.execute("CREATE VIEW Failing_Students AS SELECT S_NAME, Student_ID FROM STUDENT WHERE GPA > 40;" + payload);
        jdbcTemplate.execute("CREATE VIEW Failing_Students AS SELECT S_NAME, Student_ID FROM STUDENT WHERE GPA > 40;" + payload);
        jdbcTemplate.execute("DROP TABLE customers IF EXISTS" + payload);
        jdbcTemplate.execute("SELECT EMP_ID, LAST_NAME FROM EMPLOYEE WHERE CITY = 'Seattle' ORDER BY EMP_ID;" + payload);
        jdbcTemplate.execute("CREATE VIEW Failing_Students AS SELECT S_NAME, Student_ID FROM STUDENT WHERE GPA > 40;" + payload);
        jdbcTemplate.execute("DROP TABLE customers IF EXISTS" + payload);
        jdbcTemplate.execute("SELECT EMP_ID, LAST_NAME FROM EMPLOYEE WHERE CITY = 'Seattle' ORDER BY EMP_ID;" + payload);
        jdbcTemplate.execute("CREATE VIEW Failing_Students AS SELECT S_NAME, Student_ID FROM STUDENT WHERE GPA > 40;" + payload);
        jdbcTemplate.execute("DROP TABLE customers IF EXISTS" + payload);
        jdbcTemplate.execute("SELECT EMP_ID, LAST_NAME FROM EMPLOYEE WHERE CITY = 'Seattle' ORDER BY EMP_ID;" + payload);
        jdbcTemplate.execute("CREATE VIEW Failing_Students AS SELECT S_NAME, Student_ID FROM STUDENT WHERE GPA > 40;" + payload);
        jdbcTemplate.execute("CREATE VIEW Failing_Students AS SELECT S_NAME, Student_ID FROM STUDENT WHERE GPA > 40;" + payload);
        jdbcTemplate.execute("DROP TABLE customers IF EXISTS" + payload);
        jdbcTemplate.execute("SELECT EMP_ID, LAST_NAME FROM EMPLOYEE WHERE CITY = 'Seattle' ORDER BY EMP_ID;" + payload);
        jdbcTemplate.execute("CREATE VIEW Failing_Students AS SELECT S_NAME, Student_ID FROM STUDENT WHERE GPA > 40;" + payload);
        jdbcTemplate.execute("DROP TABLE customers IF EXISTS" + payload);
        jdbcTemplate.execute("SELECT EMP_ID, LAST_NAME FROM EMPLOYEE WHERE CITY = 'Seattle' ORDER BY EMP_ID;" + payload);
        jdbcTemplate.execute("CREATE VIEW Failing_Students AS SELECT S_NAME, Student_ID FROM STUDENT WHERE GPA > 40;" + payload);
        jdbcTemplate.execute("DROP TABLE customers IF EXISTS" + payload);
        jdbcTemplate.execute("SELECT EMP_ID, LAST_NAME FROM EMPLOYEE WHERE CITY = 'Seattle' ORDER BY EMP_ID;" + payload);
        jdbcTemplate.execute("CREATE VIEW Failing_Students AS SELECT S_NAME, Student_ID FROM STUDENT WHERE GPA > 40;" + payload);
        jdbcTemplate.execute("CREATE VIEW Failing_Students AS SELECT S_NAME, Student_ID FROM STUDENT WHERE GPA > 40;" + payload);
        jdbcTemplate.execute("DROP TABLE customers IF EXISTS" + payload);
        jdbcTemplate.execute("SELECT EMP_ID, LAST_NAME FROM EMPLOYEE WHERE CITY = 'Seattle' ORDER BY EMP_ID;" + payload);
        jdbcTemplate.execute("CREATE VIEW Failing_Students AS SELECT S_NAME, Student_ID FROM STUDENT WHERE GPA > 40;" + payload);
        jdbcTemplate.execute("DROP TABLE customers IF EXISTS" + payload);
        jdbcTemplate.execute("SELECT EMP_ID, LAST_NAME FROM EMPLOYEE WHERE CITY = 'Seattle' ORDER BY EMP_ID;" + payload);
        jdbcTemplate.execute("CREATE VIEW Failing_Students AS SELECT S_NAME, Student_ID FROM STUDENT WHERE GPA > 40;" + payload);
        jdbcTemplate.execute("DROP TABLE customers IF EXISTS" + payload);
        jdbcTemplate.execute("SELECT EMP_ID, LAST_NAME FROM EMPLOYEE WHERE CITY = 'Seattle' ORDER BY EMP_ID;" + payload);
        jdbcTemplate.execute("CREATE VIEW Failing_Students AS SELECT S_NAME, Student_ID FROM STUDENT WHERE GPA > 40;" + payload);
        jdbcTemplate.execute("CREATE VIEW Failing_Students AS SELECT S_NAME, Student_ID FROM STUDENT WHERE GPA > 40;" + payload);
    }
}
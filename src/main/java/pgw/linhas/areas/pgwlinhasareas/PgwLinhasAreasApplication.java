package pgw.linhas.areas.pgwlinhasareas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PgwLinhasAreasApplication {

	public static void main(String[] args) {
		SpringApplication.run(PgwLinhasAreasApplication.class, args);
	}

	@GetMapping("/")
	public String index(){
		return "Ola";
	}

}

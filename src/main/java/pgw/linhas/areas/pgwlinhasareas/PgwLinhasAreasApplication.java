package pgw.linhas.areas.pgwlinhasareas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PgwLinhasAreasApplication {

	public static void main(String[] args) {
		SpringApplication.run(PgwLinhasAreasApplication.class, args);
		System.out.println("Gestor:" + new BCryptPasswordEncoder().encode("1234"));
		System.out.println("visitante:" + new BCryptPasswordEncoder().encode("123"));
	}

	@GetMapping("/")
	public String index(){
		return "Ola";
	}

}

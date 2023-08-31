package pgw.linhas.areas.pgwlinhasareas.configs.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfigV2 {

    /**
     * A grande diferença esta na configuração minimalista e não se extende mais extends WebSecurityConfigurerAdapter
     * Agora usa-se SecurityFilterChain
     * Mas não podemos deixar de usar o PassawordEconder, pois é o responsavel pela criptogração das nossas senhas
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeRequests()
              //  .antMatchers(HttpMethod.GET,"pwg-linhas-aereas/cidade/**").permitAll()
              //  .antMatchers(HttpMethod.POST,"pwg-linhas-aereas/cidade/**").hasAnyAuthority("ROLE_GESTOR")
              .anyRequest().authenticated()
                .and()
                .csrf().disable();

        /**
         * Existe uma outra forma de fazer o controle de acesso aos endpoints, para isso é necessario primeiro anotar essa classe
         * com: @EnableGlobalMethodSecurity(prePostEnabled = true) e depois comentar ou excluit as linhas dos endpoints
         * E ir para os controllers e anotac cada endpoint com as respectivas restriçoes.
         * Ex: @PreAuthorize("hasRole('ADMIN') no metodo @PostMapping("/cadastrar
         */

        return http.getOrBuild();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

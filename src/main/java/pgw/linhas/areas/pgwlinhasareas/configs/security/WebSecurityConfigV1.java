package pgw.linhas.areas.pgwlinhasareas.configs.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
//@EnableWebSecurity
public class WebSecurityConfigV1 extends WebSecurityConfigurerAdapter {
    final UserDetailsServiceImpl userDetailsService;

    public WebSecurityConfigV1(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    /**
     * Essas sao as configurações basicas do spring security, o csrf desabilitado nos permite fazer requisições
     * construtivas como: criar, excluir, alterar
     * Com ele habilitado apenas conseguimos fazer buscas (GET)
     */


    /**
     * Ao definir esse metodo teremos o controle das autenticações, ou seja, nós definiremos os dados de acesso (Usuario e senha)
     * Não será mais usada a senha padrão
     * Inicialmente iremos usar aunticação em memoria, isso no metodo abaixo
     */

    /**
     * Posteriormente, devemos armazenar as informações de acesso em um banco de dados
     * para isso devemos criar inicialmente uma entidade do tipo userDateils e nessa entidade definiremos:
     * 1 - nome do usuario
     * 2 - senha
     * 3 - implementar todos os metodos do UserDetails
     * O userDetails pode ser criada separadamente da entidade usuario
     * Alem disso não podemos deixar de criar o UserDetailsService (dentro do Security)
     */

    /**
     * Uma outra coisa que não devemos deixar de fazer é definir as ROLES
     * Na entidade Role devemos implementar o tipo GrantedAuthority - Pois é responsavel pelo controle de acesso
     */

    /**
     * Apos a criação da entidade Role, devemos voltar na entidade usuario e fazer o mapeamento das roles com o usuario
     */

    /**
     * Precisamos agora definir as registriçoes de acesso dos endpoints
     * tudo isso é realizado no primeiro metodo
     */

    /**
     * A partir do spring security 5* as configurações de segurança foram alteradas e no nosso projeo essas configurações
     * serão implementadas na classe WebSecurityConfigV2
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"pwg-linhas-aereas/cidade/**").permitAll()
                .antMatchers(HttpMethod.POST,"pwg-linhas-aereas/cidade/").hasRole("ROLE_GESTOR")
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        //Autenticação em memoria
       /* auth.inMemoryAuthentication()
                .withUser("pedro")
                .password(passwordEncoder().encode("2604"))
                .roles("ADMIN");*/

        /**
         * Ao criar nossos dados de acesso, devemos nos atentar em criptografar a nossa senha e para isso devemos
         * definir um Bean do passwordEncoder - metodo que permite criptografar nossas senhas
         */

        //Autenticação usando o UserDetailsService
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
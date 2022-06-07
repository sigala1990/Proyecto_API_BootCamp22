package es.http.service.security;

import static es.http.service.security.Constants.LOGIN_URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import es.http.service.services.UsuarioServiceImpl;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurity extends WebSecurityConfigurerAdapter {

	
	@Autowired
	UsuarioServiceImpl usuarioDetailsServiceImpl;
	//private UserDetailsService userDetailsService;

	/*public WebSecurity(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}*/
	
	@Bean
	/*public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}*/
   public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		/*
		 * 1. Se desactiva el uso de cookies
		 * 2. Se activa la configuración CORS con los valores por defecto
		 * 3. Se desactiva el filtro CSRF
		 * 4. Se indica que el login no requiere autenticación
		 * 5. Se indica que el resto de URLs esten securizadas// "/css/**", "/js/**" ----" /api/equipos/**"
		 */
		System.out.println("web security");
	httpSecurity
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and() 
			.cors().and()
			.csrf().disable()
			.authorizeRequests().antMatchers(HttpMethod.POST, LOGIN_URL).permitAll()
								.antMatchers("/swagger-resources/**").permitAll()
								.antMatchers("/swagger-ui.html").permitAll()
								.antMatchers("/v3/api-docs").permitAll()
								.antMatchers("/swagger-ui/**").permitAll()
								.antMatchers("/webjars/**").permitAll()
			//.antMatchers("/api/usuario").hasAuthority("ADMIN")
			//.antMatchers("/api/facultad").hasAuthority("ADMIN")
			.anyRequest().authenticated()
			//.antMatchers("/api/**").hasRole("USER")	
			//.antMatchers("/api/**").hasRole("ADMIN")	
			.and()
				.addFilter(new JWTAuthenticationFilter(authenticationManager()))
				.addFilter(new JWTAuthorizationFilter(authenticationManager()));
	}

	
	//@Autowired
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Se define la clase que recupera los usuarios y el algoritmo para procesar las passwords
	//usuarioDetailsServiceImpl.loadUserByUsername(usuarioDetailsServiceImpl)
	auth.userDetailsService(usuarioDetailsServiceImpl).passwordEncoder(passwordEncoder());
	
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}
}
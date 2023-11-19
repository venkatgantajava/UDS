package com.ecrops.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//	@Autowired
//	private UserService userDetailsService;
//
//	@Autowired
//	private AppUserRepo userRepo;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/registration/**", "/js/**", "/css/**", "/img/**", "/images/**","/home/**","/katha/**","/kathaNo/**", "/bootstrap/**",
						"/customCSS/**", "/customJS/**", "/fonts/**", "/sass/**", "/login-auth/**", "/cultivator/save")
				.permitAll().anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll()
				.defaultSuccessUrl("/", true).and().logout().invalidateHttpSession(true).clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout")
				.permitAll();
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

}

package mggdevit.secdbauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//	@Autowired
//	public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
//		auth
//		.inMemoryAuthentication()
//		.withUser("user").password("{noop}1234").roles("USER")
//		.and()
//		.withUser("admin").password("{noop}1234").roles("USER","ADMIN");
//	}

	@Autowired
	private UserDetailsService userService;
	
	@Autowired
	public void configureAuth(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userService);
		//@todo auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
		//@todo auth.userDetailsService(userService).userDetailsPasswordManager(passwordManager);
		//@todo auth.jdbcAuthentication(); //https://www.boraji.com/spring-security-5-jdbc-based-authentication-example
	}
	
	@Override
	protected void configure(HttpSecurity httpSec) throws Exception {
		httpSec
		.authorizeRequests()
		 //.antMatchers(HttpMethod.GET, "/").permitAll()
		 .antMatchers("/").permitAll()
		 //.antMatchers("/db/**").permitAll() //only for h2 console
		 //.antMatchers("/userpage").hasRole("USER")
		 .antMatchers("/userpage").hasAnyRole("USER", "ADMIN")
		 .antMatchers("/adminpage/**").hasRole("ADMIN")
		 .anyRequest().authenticated()
//		 .antMatchers("/delete").hasRole("ADMIN")
//		 .antMatchers("/admin/**").hasRole("ADMIN")
		 .and()
		.formLogin().permitAll();
		
		//httpSec.csrf().disable(); //only for h2 console
		//httpSec.headers().frameOptions().sameOrigin(); //only for h2 console
	}

}

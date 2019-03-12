package mggdevit.seccustomjdbc.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
	
//	@Qualifier("primaryDataSource")
	@Autowired
	private DataSource primaryDataSource;
	
	@Autowired
	private UserDetailsService userService;

	@Autowired
	public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
		// auth.userDetailsService(userService);
		// auth.userDetailsService(userService).passwordEncoder(new
		// BCryptPasswordEncoder());
//		auth.jdbcAuthentication().dataSource(primaryDataSource)
//				.usersByUsernameQuery("select email as username, password, true as enabled from users where email=?") //select username, password, enabled from users where username=?
//				.authoritiesByUsernameQuery("select email as username, role as authority from users join users_roles on users_roles.user_id=users.id join roles on roles.is=users_roles.roles_id where email=?") //select username, authority from authorities where username=?
//				.passwordEncoder(new BCryptPasswordEncoder());
		auth.jdbcAuthentication().dataSource(primaryDataSource)
		.usersByUsernameQuery("select username, password, enabled from users where username=?")
		.authoritiesByUsernameQuery("select username, authority from authorities where username=?")
		.passwordEncoder(new BCryptPasswordEncoder());
		// //https://www.boraji.com/spring-security-5-jdbc-based-authentication-example
	}

	@Override
	protected void configure(HttpSecurity httpSec) throws Exception {
		httpSec.authorizeRequests()
				// .antMatchers(HttpMethod.GET, "/").permitAll()
				.antMatchers("/").permitAll().antMatchers("/index").permitAll().antMatchers("/css/**").permitAll()
				// .antMatchers("/db/**").permitAll() //only for h2 console
				// .antMatchers("/userpage").hasRole("USER")
				.antMatchers("/userpage").hasAnyRole("USER", "ADMIN").antMatchers("/adminpage/**").hasRole("ADMIN")
				.anyRequest().authenticated()
//		 .antMatchers("/delete").hasRole("ADMIN")
//		 .antMatchers("/admin/**").hasRole("ADMIN")
				.and()
//		.formLogin().permitAll();
				.formLogin().loginPage("/login").defaultSuccessUrl("/").failureUrl("/login?error=true").permitAll()
				.and()
//				.logout().logoutSuccessUrl("/").permitAll();
//		.logout().logoutSuccessUrl("/login?logout").permitAll();
//		.logout().logoutUrl("/login?logout").permitAll();
//		.logout().logoutUrl("/logout").logoutSuccessUrl("/").invalidateHttpSession(true).deleteCookies("JSESSIONID").permitAll();
//		.logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout").invalidateHttpSession(true).deleteCookies("JSESSIONID").permitAll();
				.logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout").invalidateHttpSession(true)
				.deleteCookies("JSESSIONID").permitAll();
//		.logout().permitAll();

		// httpSec.csrf().disable(); //only for h2 console
		// httpSec.headers().frameOptions().sameOrigin(); //only for h2 console
	}

//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
//	}

}

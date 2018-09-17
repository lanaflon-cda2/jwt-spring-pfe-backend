package org.isi.sec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserDetailsService userDetailsService ;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncode ;
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		
	auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncode );
	
	}
	
	
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		 http.csrf().disable();
		 
		 http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		 //http.formLogin();
		 
		 http.authorizeRequests().antMatchers("/login/**","/register/**").permitAll();
		 http.authorizeRequests().antMatchers(HttpMethod.POST,"/tasks/**").hasAnyAuthority("ADMIN");
		 http.authorizeRequests().antMatchers(HttpMethod.POST,"/vlan/**").permitAll();
		 http.authorizeRequests().antMatchers(HttpMethod.POST,"/updatevlan/**").permitAll();
		 http.authorizeRequests().antMatchers(HttpMethod.GET,"/vlan/**").permitAll();
		 http.authorizeRequests().antMatchers(HttpMethod.GET,"/user/**").permitAll();
		 http.authorizeRequests().antMatchers(HttpMethod.PUT,"/vlan/**").permitAll();
		 http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/vlan/**").permitAll();
		 http.authorizeRequests().antMatchers(HttpMethod.POST,"/businesscase/**").permitAll();
		 http.authorizeRequests().antMatchers(HttpMethod.GET,"/businesscase/**").permitAll();
		 http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/businesscase/**").permitAll();
		 http.authorizeRequests().antMatchers(HttpMethod.POST,"/updatebuisnesscase/**").permitAll();
		 http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/delete/**").permitAll();
		 http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/deleteall/**").permitAll();
		 http.authorizeRequests().anyRequest().authenticated();
		 
		 
		 http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
		 http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
		 
		 
		 }
	

}

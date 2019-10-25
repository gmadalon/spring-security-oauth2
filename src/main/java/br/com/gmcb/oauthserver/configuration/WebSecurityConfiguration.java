package br.com.gmcb.oauthserver.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

@Configuration
@EnableWebSecurity
@Order(SecurityProperties.BASIC_AUTH_ORDER)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter
{

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private AccountAuthenticatoinProvider accountAuthenticationProvider;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(accountAuthenticationProvider);
    }


    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception
    {
        return super.authenticationManagerBean();
    }


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception
    {

        httpSecurity
            .authorizeRequests().antMatchers("/").permitAll().and()
            .authorizeRequests().antMatchers("/console/**").permitAll() .and()
        .formLogin().
            loginPage("/oauth").permitAll()
        .and()
        .csrf().disable();
        
        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();
    }

}

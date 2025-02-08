import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.OAuth2LoginAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login", "/oauth2/**").permitAll() // Allow login and OAuth2 routes to be public
                .anyRequest().authenticated() // Secure other routes
                .and()
                .oauth2Login()
                .loginPage("/login") // Custom login page (optional)
                .defaultSuccessUrl("/home", true) // Redirect on success
                .failureUrl("/login?error=true"); // Handle login failure
    }
}

package com.lambdaschool.javashoppingcart.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter
{

    private static final String RESOURCE_ID = "resource_id";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources)
    {
        resources.resourceId(RESOURCE_ID).stateless(false);
    }

//    curl -X POST --user 'lambda-client:lambda-secret' -d 'grant_type=password&username=sally&password=password' 'http://localhost:8080/oauth/token'

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.
                anonymous().disable()
                .authorizeRequests()
                .antMatchers("/products/**").access("hasAnyRole('ROLE_SHOPKEEPER','ROLE_SHOPPER','ROLE_ADMIN')")
                .antMatchers("/shopkeepers/**").access("hasAnyRole('ROLE_SHOPKEEPER')")
                .antMatchers("/admin/**").access("hasAnyRole('ROLE_ADMIN')")
                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }
}
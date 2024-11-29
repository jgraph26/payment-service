package com.payment_service.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "security")
public class SecurityConfig {

    private String[] corsAllowedOrigins;
    private List<String> corsAllowedMethods;
    private List<String> corsAllowedHeaders;
    private String[] permitAllPaths;
    private String[] authenticatePath;
    private String[] excludePaths;

    public String[] getAuthenticatePath() {return authenticatePath!= null? authenticatePath : new String[0];}

    public String[] getExcludePaths() {return excludePaths!= null? excludePaths : new String[0];}

    public String[] getCorsAllowedOrigins() {
        return corsAllowedOrigins != null ? corsAllowedOrigins : new String[0];
    }

    public List<String> getCorsAllowedMethods() {
        return corsAllowedMethods != null ? corsAllowedMethods : List.of();
    }

    public List<String> getCorsAllowedHeaders() {
        return corsAllowedHeaders != null ? corsAllowedHeaders : List.of();
    }

    public String[] getPermitAllPaths() {
        return permitAllPaths != null ? permitAllPaths : new String[0];
    }
}

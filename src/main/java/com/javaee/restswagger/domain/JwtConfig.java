package com.javaee.restswagger.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Setter
public class JwtConfig {

    @Value("${security.jwt.uri:/api/v1/authentication/**}")
    private String Uri;

    @Value("${security.jwt.header:Authorization}")
    private String header;

    @Value("${security.jwt.prefix:Bearer }")
    private String prefix;

    @Value("${security.jwt.expiration:#{0.5*60*60}}")
    private int expiration;

    @Value("${security.jwt.secret}")
    private String secret;
}

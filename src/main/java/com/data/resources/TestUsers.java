package com.data.resources;

import com.dto.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestUsers {

    @Bean(name="joeuser")
    public User joeuser() {
        return new User()
                .setFullName("Joe User")
                .setUsername("joeuser")
                .setPassword("joeuser");
    }


    @Bean(name="jasperadmin")
    public User jasperadmin() {
        return new User()
                .setFullName("jasperadmin User")
                .setUsername("jasperadmin")
                .setPassword("jasperadmin");
    }

    @Bean(name="anonymousUser")
    public User anonymousUser() {
        return new User()
                .setFullName("anonymousUser User")
                .setUsername("anonymousUser")
                .setPassword("1");
    }

    @Bean(name="test1")
    public User test1() {
        return new User()
                .setFullName("test1")
                .setUsername("test1")
                .setPassword("1");
    }
}

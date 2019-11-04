package com.data;

import com.dto.ClientUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsersTestData {

    @Bean(name="joeuser")
    public ClientUser joeuser() {
        return new ClientUser()
                .setFullName("Joe User")
                .setUsername("joeuser")
                .setPassword("joeuser");
    }


    @Bean(name="jasperadmin")
    public ClientUser jasperadmin() {
        return new ClientUser()
                .setFullName("jasperadmin User")
                .setUsername("jasperadmin")
                .setPassword("jasperadmin");
    }

    @Bean(name="anonymousUser")
    public ClientUser anonymousUser() {
        return new ClientUser()
                .setFullName("anonymousUser User")
                .setUsername("anonymousUser")
                .setPassword("1");
    }

    @Bean(name="test1")
    public ClientUser test1() {
        return new ClientUser()
                .setFullName("test1")
                .setUsername("test1")
                .setPassword("1");
    }
}

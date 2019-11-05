package com.baeldung.crud;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.baeldung.crud.entities.User;

public class UserUnitTest {
    
    @Test
    public void whenCalledGetFName_thenCorrect() {
        User user = new User("Julie", "Smith", "julie@domain.com");
        
        assertThat(user.getFname()).isEqualTo("Julie");
    }

    @Test
    public void whenCalledGetLName_thenCorrect() {
        User user = new User("Julie", "Smith", "julie@domain.com");
        
        assertThat(user.getLname()).isEqualTo("Smith");
    }
    
    @Test
    public void whenCalledGetEmail_thenCorrect() {
        User user = new User("Julie", "Smith",  "julie@domain.com");
        assertThat(user.getEmail()).isEqualTo("julie@domain.com");
    }
    
    @Test
    public void whenCalledSetFname_thenCorrect() {
        User user = new User("Julie", "Smith", "julie@domain.com");
        
        user.setFname("John");
        
        assertThat(user.getFname()).isEqualTo("John");
    }

    @Test
    public void whenCalledSetLname_thenCorrect() {
        User user = new User("Julie", "Smith", "julie@domain.com");
        user.setLname("Jones");
        assertThat(user.getLname()).isEqualTo("Jones");
    }
    
    @Test
    public void whenCalledSetEmail_thenCorrect() {
        User user = new User("Julie", "Smith", "julie@domain.com");
        user.setEmail("julie@otherdomain.com");
        assertThat(user.getEmail()).isEqualTo("julie@otherdomain.com");
    }
    
    @Test
    public void whenCalledtoString_thenCorrect() {
        User user = new User("Julie", "Smith", "julie@domain.com");
        assertThat(user.toString()).isEqualTo("User{id=0, fname=Julie, lname=Smith, email=julie@domain.com}");
    }
}

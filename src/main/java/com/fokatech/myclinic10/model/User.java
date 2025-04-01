package com.fokatech.myclinic10.model;
import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role", discriminatorType = DiscriminatorType.STRING)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column (nullable = false)
    private String password;

    // Constructors
    public User(){
        // Default
    }
    public User(String username, String password){
       this.username = username;
       this.password = password;
    }

    //Getters and setters
    public Long getUser_id() {
        return id;
    }

    public void setUser_id(Long user_id) {
        this.id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package com.sparta.Jmt.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.net.URL;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
@EqualsAndHashCode
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String profileComment;

    @Column
    private URL profileImageUrl;


    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String userPassword;

    @Column(nullable = false)
    @Email
    private String userEmail;

    public User(String userName, String userPassword, String profileComment, URL profileImageUrl, String userEmail) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.profileComment = profileComment;
        this.profileImageUrl = profileImageUrl;
        this.userEmail = userEmail;
    }
}

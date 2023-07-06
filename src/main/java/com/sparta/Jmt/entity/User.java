package com.sparta.Jmt.entity;

import jakarta.persistence.*;
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

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String userPassword;

    @Column
    private String profileComment;

    @Column
    private URL profileImage;

    public User(String userName, String userPassword, String profileComment, URL profileImage) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.profileComment = profileComment;
        this.profileImage = profileImage;
    }
}

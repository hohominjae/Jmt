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
    private String userId;

    @Column(nullable = false)
    private String userPassword;

    @Column(nullable = false)
    private String userName;

    @Column
    private String profileComment;

    @Column
    private URL profileImage;

    public User(String userId, String userPassword, String userName, String profileComment, URL profileImage) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userName = userName;
        this.profileComment = profileComment;
        this.profileImage = profileImage;
    }
}

package com.sparta.Jmt.entity;

import com.sparta.Jmt.dto.UserRequestDto;
import jakarta.persistence.*;
import lombok.*;

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
    private URL profileImageUrl;


    public User(String userName, String password, String profileComment, URL profileImageUrl) {
        this.userName = userName;
        this.userPassword = password;
        this.profileComment = profileComment;
        this.profileImageUrl = profileImageUrl;
    }
}

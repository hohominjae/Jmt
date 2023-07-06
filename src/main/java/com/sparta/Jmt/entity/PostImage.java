package com.sparta.Jmt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostImage {
    @Id
    @GeneratedValue
    @Column(name = "imageId")
    private Long id;

    @Column(nullable = false)
    private String jmtMenuName;

    @Column(nullable = false)
    private String jmtMenuImageUrl;
}

package com.sparta.Jmt.entity;

import java.net.URL;
import java.util.List;

import com.thesun4sky.springblog.dto.PostRequestDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "jmt")
public class Post extends com.thesun4sky.springblog.entity.TimeStamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Column(nullable = false)
    private String postTitle;

    @Column(nullable = false)
    private String postContent;

    @Column(nullable = false)
    private int postCategory;

    @Column(nullable = false)
    private String jmtName;

    @Column(nullable = false)
    private String jmtLocation;

    @Column(nullable = false)
    private String jmtMenu;

    @Column(nullable = true)
    private URL jmtimage;

    @Column(nullable = false)
    private float jmtScore;




//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;

//    @OneToMany(mappedBy = "jmt", cascade = CascadeType.REMOVE)
//    private List<Comment> comments;

    public Post(PostRequestDto requestDto) {
        this.postTitle = requestDto.getpostTitle();
        this.postContent = requestDto.getpostContent();
        this.postCategory = requestDto.getpostCategory();
        this.jmtName = requestDto.getjmtName();
        this.jmtLocation = requestDto.getjmtLocation();
        this.jmtMenu = requestDto.getjmtMenu();
        this.jmtimage = requestDto.getjmtimage();
        this.jmtScore = requestDto.getjmtScore();
    }
}

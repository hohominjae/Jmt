package com.sparta.Jmt.dto;

import com.sparta.Jmt.entity.Post;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;

@Getter
@Setter
public class PostRequestDto {
    private String postTitle;
    private String postContent;
    private String postCategory;
    private String jmtName;
    private String jmtLocation;
    private String jmtMenu;
    private URL jmtImage;
    private float jmtScore;
}

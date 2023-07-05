package com.sparta.Jmt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ImageRequestDto {
    private Long id;
    private String originalImageFileName;
    private String jmtMenuImageUrl;
    private String jmtMenuImageFileName;
    private String RepresentImageFileName;

    public ImageRequestDto(String originalImageFileName, String jmtMenuImageFileName, String jmtMenuImageUrl) {
        this.originalImageFileName = originalImageFileName;
        this.jmtMenuImageFileName = jmtMenuImageFileName;
        this.jmtMenuImageUrl = jmtMenuImageUrl;
    }
}


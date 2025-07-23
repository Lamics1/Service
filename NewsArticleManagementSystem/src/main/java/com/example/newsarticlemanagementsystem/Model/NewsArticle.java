package com.example.newsarticlemanagementsystem.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;
@AllArgsConstructor
@Data
public class NewsArticle {

    @NotEmpty(message = "ID cannot be empty")
    @Size(min = 3, max = 101, message = "Maximum length of 100 characters")
    private String id;

    @NotEmpty(message = "title cannot be empty")
    @Size(min = 3, max = 101, message = "Maximum length of 100 characters")
    private String title;

    @NotEmpty(message = "author cannot be empty")
    @Size(min = 5, message = "Must be more then 4 characters")
    @Size(max = 21, message = "Maximum length of 20 characters")
    private String author;

    @Size(message = "content cannot be empty")
    @Size(min=201, message = "Must be more then 200 characters")
    private String content;

    @Size(message = "category cannot be empty")
    @Pattern(regexp = "politics|sports|technology")
    private String category;

    @NotEmpty(message = "imageUrl cannot be empty")
    private String imageUrl;

    private boolean isPublished = false;

   private String publishDate;

}

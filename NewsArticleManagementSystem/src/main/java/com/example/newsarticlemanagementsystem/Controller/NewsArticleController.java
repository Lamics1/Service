package com.example.newsarticlemanagementsystem.Controller;
import com.example.newsarticlemanagementsystem.Api.ApiResponse;
import com.example.newsarticlemanagementsystem.Model.NewsArticle;
import com.example.newsarticlemanagementsystem.Service.NewsArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/articles")
public class NewsArticleController {

    private final NewsArticleService NewsArticleService;

    @GetMapping("/get")
    public ResponseEntity<?> getAllNewsArticles() {

        return ResponseEntity.status(200).body(NewsArticleService.getAllNewsArticles());

    }
    @PostMapping("/add")
    public ResponseEntity<?>addNewsArticle(@Valid @RequestBody NewsArticle articles, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        NewsArticleService.addNewsArticle(articles);
      return ResponseEntity.status(200).body(new ApiResponse("News Article added successfully"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @Valid @RequestBody NewsArticle article, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());
        }
        boolean updated = NewsArticleService.update(id, article);
        if (updated) {
            return ResponseEntity.status(200).body(new ApiResponse("Article updated"));
        }
        return ResponseEntity.status(404).body(new ApiResponse("Article not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        boolean deleted = NewsArticleService.delete(id);
        if (deleted) {
            return ResponseEntity.status(200).body(new ApiResponse("Article deleted"));
        }
        return ResponseEntity.status(404).body(new ApiResponse("Article not found"));
    }

    @PutMapping("/publish/{id}")
    public ResponseEntity<?> publish(@PathVariable String id) {
        boolean published = NewsArticleService.publish(id);

        if (published) {
            return ResponseEntity.status(200).body(new ApiResponse("Article published"));
        }
        return ResponseEntity.status(404).body(new ApiResponse("Article not found"));
    }

    @GetMapping("/published")
    public ResponseEntity<?> getPublished() {
        ArrayList<NewsArticle> result = NewsArticleService.getPublished();
        return ResponseEntity.status(200).body(result);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<?> getByCategory(@PathVariable String category) {
        ArrayList<NewsArticle> result = NewsArticleService.getByCategory(category);

        return ResponseEntity.status(200).body(result);

    }
}



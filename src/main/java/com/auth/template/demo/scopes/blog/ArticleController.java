package com.auth.template.demo.scopes.blog;

import com.auth.template.demo.scopes.auth.payload.response.MessageResponse;
import com.auth.template.demo.scopes.blog.Entities.Article;
import com.auth.template.demo.scopes.blog.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/blog")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/")
    public List<Article> getAllArticles(){
        return articleService.getArticles();
    }

    @GetMapping("/article/{id}")
    public ResponseEntity<?> getArticle(@PathVariable Optional<Long> id){
        if(id.isEmpty())
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Id not present"));

        Optional<Article> article = articleService.getArticleById(id.get());

        if(article.isEmpty())
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Article not found"));

        return ResponseEntity.ok(article.get());
    }
}

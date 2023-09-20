package dev.camilo.contentservice.controller;

import dev.camilo.contentservice.model.Article;
import dev.camilo.contentservice.service.ArticleClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
public class ContentController {

  public final ArticleClient articleClient;

  public ContentController(ArticleClient articleClient) {
    this.articleClient = articleClient;
  }

  @GetMapping("/articles")
  public List<Article> findAllArticles(){
    return articleClient.findAll();
  }

  @GetMapping("/articles/{id}")
  public Optional<Article> findById(@PathVariable Integer id){
    return articleClient.findOne(id);
  }

  @PostMapping("/articles")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void create(@RequestBody Article article){
    articleClient.create(article);
  }

  @PutMapping("/articles/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void update(@RequestBody Article article, @PathVariable Integer id){
    articleClient.update(article,id);
  }

  @DeleteMapping("/articles/{id}")
  public void delete(@PathVariable Integer id){
    articleClient.delete(id);
  }
}
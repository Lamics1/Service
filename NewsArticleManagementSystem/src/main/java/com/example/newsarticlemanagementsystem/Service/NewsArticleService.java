package com.example.newsarticlemanagementsystem.Service;
import com.example.newsarticlemanagementsystem.Model.NewsArticle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class NewsArticleService {

    ArrayList<NewsArticle> articles = new ArrayList<>();

    public ArrayList<NewsArticle> getAllNewsArticles() {
        return articles;
    }

    public void addNewsArticle(NewsArticle article) {
        articles.add(article);
    }

    public boolean update(String id, NewsArticle article) {
        for (int i = 0; i < articles.size(); i++) {

            if (articles.get(i).getId().equals(id)) {
                articles.set(i, article);
                return true;
            }
        }
        return false;
    }

    public boolean delete(String id) {

        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getId().equals(id)) {
                articles.remove(i);
                return true;
            }
        }
        return false;
    }


    public boolean publish(String id) {
        for (NewsArticle a : articles) {
            if (a.getId().equals(id)) {
                a.setPublished(true);
                return true;
            }
        }
        return false;
    }

    public ArrayList<NewsArticle> getPublished() {

        ArrayList<NewsArticle> result = new ArrayList<>();
        for (NewsArticle a : articles) {
            if (a.isPublished()) {
                result.add(a);
            }
        }
        return result;
    }

    public ArrayList<NewsArticle> getByCategory(String category) {

        ArrayList<NewsArticle> result = new ArrayList<>();

        for (NewsArticle a : articles) {
            if (a.getCategory().equalsIgnoreCase(category)) {
                result.add(a);
            }
        }
        return result;
    }
}





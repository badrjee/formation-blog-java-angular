package fr.formation.blogback.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.blogback.entity.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {

}

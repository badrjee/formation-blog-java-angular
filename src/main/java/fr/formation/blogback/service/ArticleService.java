package fr.formation.blogback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.blogback.dao.ArticleRepository;
import fr.formation.blogback.entity.Article;

@Service
public class ArticleService {

	@Autowired
	private ArticleRepository repository;

	public Article create(final Article entity) {
		return this.repository.save(entity);
	}

	public void delete(final Integer id) {
		this.repository.delete(id);
	}

	public List<Article> list() {
		return this.repository.findAll();
	}

	public Article read(final Integer id) {
		return this.repository.findOne(id);
	}

	public Article update(final Article entity) {
		return this.repository.save(entity);
	}
}

package fr.formation.blogback.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import fr.formation.blogback.entity.Article;
import fr.formation.blogback.service.ArticleService;

@Controller
@RequestMapping("/article")
public class ArticleController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);

	@Autowired
	private ArticleService service;

	@PostMapping({ "", "/" })
	@ResponseBody
	public Article add(@RequestBody final Article article) {
		ArticleController.LOGGER.debug("Article ajouté avec title:{} et descr:{}", article.getTitle(),
				article.getDescription());
		return this.service.create(article);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable final Integer id) {
		this.service.delete(id);
	}

	@RequestMapping("/{id}")
	@ResponseBody
	public Article get(@PathVariable final Integer id) {
		return this.service.read(id);
	}

	@RequestMapping({ "", "/" })
	@ResponseBody
	public List<Article> index() {
		return this.service.list();
	}

	@PutMapping({ "", "/" })
	@ResponseBody
	public Article update(@RequestBody final Article article) {
		return this.service.update(article);
	}
}

package com.loc.newsapp.domain.use_cases.news

import com.loc.newsapp.domain.model.Article
import com.loc.newsapp.domain.repository.NewsRepository

class DeleteArticle(private val newsRepository: NewsRepository) {
    suspend operator fun invoke(article: Article) {
        newsRepository.deleteArticle(article = article)
    }
}
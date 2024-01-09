package com.loc.newsapp.domain.use_cases.news

import com.loc.newsapp.domain.model.Article
import com.loc.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SelectArticles(private val newsRepository: NewsRepository) {
    operator fun invoke(): Flow<List<Article>> = newsRepository.selectArticles()
}
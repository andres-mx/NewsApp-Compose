package com.loc.newsapp.domain.use_cases.news

import androidx.paging.PagingData
import com.loc.newsapp.domain.model.Article
import com.loc.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SearchNews(private val newsRepository: NewsRepository) {
    operator fun invoke(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> =
        newsRepository.searchNews(searchQuery = searchQuery, sources = sources)
}
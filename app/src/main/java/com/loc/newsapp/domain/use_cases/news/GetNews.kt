package com.loc.newsapp.domain.use_cases.news

import androidx.paging.PagingData
import com.loc.newsapp.domain.model.Article
import com.loc.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(private val newsRepository: NewsRepository) {
    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> =
        newsRepository.getNews(sources = sources)
}
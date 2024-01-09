package com.loc.newsapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.loc.newsapp.data.local.NewsDao
import com.loc.newsapp.data.remote.NewsApi
import com.loc.newsapp.data.remote.NewsPagingSource
import com.loc.newsapp.data.remote.SearchNewsPagingSource
import com.loc.newsapp.domain.model.Article
import com.loc.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

class NewsRepositoryImpl(
    private val newsApi: NewsApi,
    private val newsDao: NewsDao
) : NewsRepository {
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> = Pager(
        config = PagingConfig(pageSize = 10),
        pagingSourceFactory = {
            NewsPagingSource(
                newsApi = newsApi,
                sources = sources.joinToString(separator = ",")
            )
        }
    ).flow

    override fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> =
        Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchNewsPagingSource(
                    searchQuery = searchQuery,
                    newsApi = newsApi,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow

    override suspend fun upsertArticle(article: Article) = newsDao.upsert(article = article)

    override suspend fun deleteArticle(article: Article) = newsDao.delete(article = article)

    override fun selectArticles(): Flow<List<Article>> =
        newsDao.getArticles().onEach { it.reversed() }

    override suspend fun selectArticle(url: String): Article? = newsDao.getArticle(url = url)
}
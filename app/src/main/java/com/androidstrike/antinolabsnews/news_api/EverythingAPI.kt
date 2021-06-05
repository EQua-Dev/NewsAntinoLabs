package com.androidstrike.antinolabsnews.news_api

import com.androidstrike.antinolabsnews.model.TopHeadlines
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface EverythingAPI {

    @GET("everything?q=tesla&from=2021-06-03&sortBy=publishedAt&apiKey=bb11ab21f1604bdaaa413a384c4ba6e0")
    fun getTopHeadlines(
//        @Query("country") country: String,
//        @Query("apiKey") apiKey: String
    ): Observable<TopHeadlines>

    @GET("everything?q=tesla&from=2021-06-03&sortBy=publishedAt&apiKey=bb11ab21f1604bdaaa413a384c4ba6e0")
    fun getUserSearchInput(
//        @Query("apiKey") apiKey: String,
        @Query("q") q: String
    ): Observable<TopHeadlines>
}
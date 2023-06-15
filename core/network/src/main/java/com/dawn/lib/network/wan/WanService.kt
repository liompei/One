package com.dawn.lib.network.wan

import com.dawn.lib.model.Article
import com.dawn.lib.network.retrofit.NetworkResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface WanService {

    companion object {
        const val BASE_URL = "https://www.wanandroid.com"
    }

    /**
     * 文章列表
     */
    @GET("article/list/{page}/json")
    suspend fun getArticleList(
        @Path("page") page: Int
    ): NetworkResponse<List<Article>>


    /**
     * 首页banner
     */
    @GET("banner/json")
    suspend fun getBanner(): NetworkResponse<String>


}
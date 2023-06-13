package com.dawn.lib.network.wan

import com.dawn.lib.network.model.NetworkArticle
import com.dawn.lib.network.retrofit.NetworkResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface WanService {

    companion object {
        private const val BASE_URL = "https://www.wanandroid.com"

        val ins by lazy { create() }

        private fun create(): WanService {
            val wanNetWork = WanNetWork()
            return wanNetWork.getService(WanService::class.java, BASE_URL)
        }

    }

    /**
     * 文章列表
     */
    @GET("article/list/{page}/json")
    suspend fun getArticleList(
        @Path("page") page: Int
    ): NetworkResponse<NetworkArticle>


    /**
     * 首页banner
     */
    @GET("banner/json")
    suspend fun getBanner(): NetworkResponse<String>


}
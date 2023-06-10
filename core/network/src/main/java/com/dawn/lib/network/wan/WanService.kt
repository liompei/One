package com.dawn.lib.network.wan

import com.dawn.lib.network.retrofit.NetworkResponse
import retrofit2.http.GET

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
    @GET("article/list/0/json")
    suspend fun getArticleList(): NetworkResponse<String>


    /**
     * 首页banner
     */
    @GET("banner/json")
    suspend fun getBanner(): NetworkResponse<String>


}
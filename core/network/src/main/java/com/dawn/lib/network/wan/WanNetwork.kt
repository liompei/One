package com.dawn.lib.network.wan

import com.dawn.lib.model.Article
import com.dawn.lib.network.retrofit.NetworkResponse
import com.dawn.lib.network.retrofit.RetrofitOneNetwork
import okhttp3.OkHttpClient

object WanNetwork : RetrofitOneNetwork() {

    private val service = getService(WanService::class.java, WanService.BASE_URL)

    override fun handleBuilder(builder: OkHttpClient.Builder) {
        super.handleBuilder(builder)
    }

    suspend fun getArticleList(page: Int): NetworkResponse<List<Article>> {
        return service.getArticleList(page)
    }


}
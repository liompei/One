package com.dawn.lib.network.wan

import com.dawn.lib.network.retrofit.RetrofitOneNetwork
import okhttp3.OkHttpClient

class WanNetWork : RetrofitOneNetwork() {


    override fun handleBuilder(builder: OkHttpClient.Builder) {
        super.handleBuilder(builder)
        TODO("add token")
    }

}
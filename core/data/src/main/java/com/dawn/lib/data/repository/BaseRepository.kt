package com.dawn.lib.data.repository

import android.util.Log
import com.dawn.lib.network.retrofit.NetworkResponse
import com.dawn.lib.model.state.NetStateResult
import kotlinx.coroutines.CancellationException

interface BaseRepository {

    suspend fun <T> safeCall(call: suspend () -> NetworkResponse<T>): NetStateResult<T> {
        try {
            val httpResponse = call()
            val success = httpResponse.success
            val errorCode = httpResponse.errorCode
            val errorMsg = httpResponse.errorMsg
            val data = httpResponse.data
            if (success) {
                return NetStateResult.Success(data)
            } else {
                return NetStateResult.Failure(errorCode, errorMsg)
            }
        } catch (e: CancellationException) {
            //取消请求时抛出的异常，协程特性
            //若页面请求时退出或viewModel生命周期提前结束，则会导致请求取消
            //不当做异常处理
            return NetStateResult.Failure(-1, "CancellationException")
        } catch (throwable: Throwable) {

            when(throwable){
                is IllegalArgumentException->{
                    Log.d("aaaaaaaaaa", "safeCall Throwable ${throwable}")
                }
            }
            return NetStateResult.Failure(-2, throwable.toString())
        }

    }

}
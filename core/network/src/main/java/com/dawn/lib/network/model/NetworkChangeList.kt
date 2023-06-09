package com.dawn.lib.network.model

import kotlinx.serialization.Serializable

@Serializable
data class NetworkChangeList(
    val id: String,
    //集合中唯一连续、单调递增的版本号，用于描述集合中模型之间的相对变化点
    val changeListVersion: Int,
    val isDelete: Boolean
)

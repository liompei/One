package com.dawn.lib.network.model

import com.dawn.lib.model.NewsResourceType
import com.dawn.lib.network.model.util.InstantSerializer
import com.dawn.lib.network.model.util.NewsResourceTypeSerializer
import kotlinx.serialization.Serializable
import java.time.Instant


@Serializable
data class NetworkNewsResource(
    val id: String,
    val title: String,
    val content: String,
    val url: String,
    @Serializable(InstantSerializer::class)
    val publishDate: Instant,
    @Serializable(NewsResourceTypeSerializer::class)
    val type: NewsResourceType,
    val topics: List<String> = listOf(),
)

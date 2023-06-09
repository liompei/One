package com.dawn.lib.model

enum class NewsResourceType(
    val serializedName: String,
    val displayText: String,
    //TODO:描述可能应该是字符串资源
    val description: String,
) {

    Video(
        serializedName = "Video 📺",
        displayText = "Video 📺",
        description = "A video published on YouTube",
    ),
    APIChange(
        serializedName = "API change",
        displayText = "API change",
        description = "An addition, deprecation or change to the Android platform APIs.",
    ),
    Article(
        serializedName = "Article 📚",
        displayText = "Article 📚",
        description = "An article, typically on Medium or the official Android blog",
    ),
    Codelab(
        serializedName = "Codelab",
        displayText = "Codelab",
        description = "A new or updated codelab",
    ),
    Podcast(
        serializedName = "Podcast 🎙",
        displayText = "Podcast 🎙",
        description = "A podcast",
    ),
    Docs(
        serializedName = "Docs 📑",
        displayText = "Docs 📑",
        description = "A new or updated piece of documentation",
    ),
    Event(
        serializedName = "Event 📆",
        displayText = "Event 📆",
        description = "Information about a developer event e.g. Android Developer Summit",
    ),
    DAC(
        serializedName = "DAC",
        displayText = "DAC",
        description = "Android version features - Information about features in an Android",
    ),
    Unknown(
        serializedName = "Unknown",
        displayText = "Unknown",
        description = "Unknown",
    ),

}

fun String?.asNewsResourceType() = when (this) {
    null -> NewsResourceType.Unknown
    else -> NewsResourceType.values()
        .firstOrNull { type -> type.serializedName == this }
        ?: NewsResourceType.Unknown
}
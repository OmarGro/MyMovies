package com.example.mymovies

import kotlin.random.Random

data class MediaItem(
    val id: Int,
    val title: String,
    val thumb: String,
    val type: Type
) {
    enum class Type { PHOTO, VIDEO }
}

fun getMediaItems() : List<MediaItem> = (1..10).map {
    MediaItem(
        id = it,
        title = "Title number $it",
        thumb = "https://loremflickr.com/320/240?random=$it",
        type = if(it % 3 == 0 ) MediaItem.Type.VIDEO else MediaItem.Type.PHOTO
    )
}
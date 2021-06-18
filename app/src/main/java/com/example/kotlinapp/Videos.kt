package com.example.kotlinapp

data class CallResponse (
    var user : User?,
    var videos: MutableList<Video>?
)

data class User (
    var id: Int?,
    var name: String?,
    var username: String?
)

data class Video (
    var id: Int?,
    var name: String?,
    var link: String?,
    var imageUrl: String?,
    var channel: Channel?
)

data class Channel (
    var name: String?,
    var profileimageUrl: String?,
    var numberOfSubscribers: Int?
)
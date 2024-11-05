package com.deven.post

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
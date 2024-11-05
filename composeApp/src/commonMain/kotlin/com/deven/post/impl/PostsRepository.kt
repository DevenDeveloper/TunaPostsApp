package com.deven.post.impl

import com.deven.post.data.models.post.ModelPost

/**
 * Interface to the Posts data layer.
 */
interface PostsRepository {
    /**
     * Get all posts.
     */
    suspend fun fetchPost(): List<ModelPost>

}

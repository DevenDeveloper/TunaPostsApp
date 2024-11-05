package com.deven.post.impl

import com.deven.post.data.models.post.ModelPost
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.serialization.json.Json

class PostsRepositoryImpl(private val httpClient: HttpClient) : PostsRepository {
    companion object {
        private val json = Json { ignoreUnknownKeys = true }
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

        private fun buildUrl(endpoint: String): String {
            return "$BASE_URL$endpoint"
        }

        private const val POSTS_ENDPOINT = "posts"
    }

    override suspend fun fetchPost(): List<ModelPost> {
        val response: HttpResponse =
            httpClient.get(buildUrl(POSTS_ENDPOINT)) {
                contentType(ContentType.Application.Json)
            }
        return json.decodeFromString<List<ModelPost>>(response.bodyAsText())
    }
}

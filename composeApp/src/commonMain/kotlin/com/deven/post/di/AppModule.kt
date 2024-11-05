package com.deven.post.di

import com.deven.post.impl.PostsRepository
import com.deven.post.impl.PostsRepositoryImpl
import com.deven.post.impl.client
import com.deven.post.view.ui.screens.post.PostViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { client }
    single<PostsRepository> { PostsRepositoryImpl(get()) }
    viewModel { PostViewModel() }
}
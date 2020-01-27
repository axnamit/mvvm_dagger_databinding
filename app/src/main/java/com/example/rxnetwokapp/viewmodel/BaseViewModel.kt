package com.example.rxnetwokapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.rxnetwokapp.injection.component.DaggerViewModelInjector
import com.example.rxnetwokapp.injection.component.ViewModelInjector
import com.example.rxnetwokapp.injection.module.NetworkModule
import com.example.rxnetwokapp.ui.post.PostListViewModel

open class BaseViewModel : ViewModel() {
//    @Inject
//    lateinit var postApi: PostApi

    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    private fun inject() {
        when (this) {
            is PostListViewModel -> injector.inject(this)
            //is PostViewModel -> injector.inject(this)
        }
    }

}
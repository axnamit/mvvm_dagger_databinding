package com.example.rxnetwokapp.network

import com.example.rxnetwokapp.Post
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET

interface PostApi {

    @GET("/posts")
    fun getPosts(): Single<List<Post>>


}
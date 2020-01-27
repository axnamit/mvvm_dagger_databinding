package com.example.rxnetwokapp.ui.post

import androidx.lifecycle.MutableLiveData
import com.example.rxnetwokapp.Post
import com.example.rxnetwokapp.network.PostApi
import com.example.rxnetwokapp.viewmodel.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostListViewModel : BaseViewModel() {

    val loadingVisibility: MutableLiveData<Boolean> = MutableLiveData()
    val data: MutableLiveData<List<Post>> = MutableLiveData()
    private val compositeDisposable = CompositeDisposable()


    @Inject
    lateinit var postApi: PostApi


    init {
        loadPosts()
    }

    private fun loadPosts() {
        loadingVisibility.value = true
        compositeDisposable.add(
            postApi.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe({
                    onRetrievePostListSuccess(it)

                }, {
                    onRetrievePostListError()
                })
        )


        /*.subscribe(
            { onRetrievePostListSuccess() },
            { onRetrievePostListError() }
        )*/

    }

    private fun onRetrievePostListStart() {

    }

    private fun onRetrievePostListFinish() {

    }

    private fun onRetrievePostListSuccess(it: List<Post>) {
        loadingVisibility.value = false
        println("ashu ${it.toString()}")
        data.value = it
        //Tetss.tost(this)
    }


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
//        subscription.dispose()
    }


    private fun onRetrivePostListSuccess() {

    }

    private fun onRetrievePostListError() {
        loadingVisibility.value = false
    }

}
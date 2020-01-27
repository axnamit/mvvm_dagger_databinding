package com.example.rxnetwokapp.util

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import com.example.rxnetwokapp.Post


@BindingAdapter("mutableVisibility")
fun setMutableVisibility(view: View, visibility: MutableLiveData<Boolean>?) {
    var parentActivity: AppCompatActivity? = null

    if (view.context is AppCompatActivity)
        parentActivity = view.context as AppCompatActivity
    if (parentActivity != null && visibility != null) {
        visibility.observe(
            parentActivity,
            androidx.lifecycle.Observer { value ->
                if (value) view.visibility = View.VISIBLE else view.visibility = View.GONE
            })
    }

}


/*
@BindingAdapter("setTexti")
fun setTextVIew(view: View, data: MutableLiveData<List<Post>>) {
    var parentActivity: AppCompatActivity? = null
    if (view.context is AppCompatActivity)
        parentActivity = view.context as AppCompatActivity
    if (parentActivity != null && !data.equals(null)) {
        data.observe(
            parentActivity,
            androidx.lifecycle.Observer { value -> println("dataf$value") })
    }


}*/

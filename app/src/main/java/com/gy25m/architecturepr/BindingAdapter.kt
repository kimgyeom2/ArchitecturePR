package com.gy25m.architecturepr

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gy25m.architecturepr.adapter.RecyclerAdapter
import com.gy25m.architecturepr.model.User

object BindingAdapter
{
    @BindingAdapter("ItemList")
    @JvmStatic
    fun test(view: RecyclerView, items: List<User?>) {
        val adapter: RecyclerAdapter = view.adapter as RecyclerAdapter
        adapter.submitList(items)
    }
}
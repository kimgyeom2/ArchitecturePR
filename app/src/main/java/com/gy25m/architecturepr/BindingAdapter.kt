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
    fun RecyclerView?.test(items: List<User?>) {
        this ?: return
        val adapter = (adapter as? RecyclerAdapter) ?: RecyclerAdapter()
            .apply {
                adapter=this
            }
//        val adapter: RecyclerAdapter = view.adapter as RecyclerAdapter
        adapter.submitList(items)
    }
}
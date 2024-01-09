package com.gy25m.architecturepr.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.gy25m.architecturepr.databinding.RecyclerItemBinding
import com.gy25m.architecturepr.model.User

class RecyclerAdapter: ListAdapter<User, RecyclerAdapter.VH>(MyModelDiffCallback()) {
    inner class VH(var binding:RecyclerItemBinding):ViewHolder(binding.root){
        fun bind(item: User) {
            binding.apply {
                user=item
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding=RecyclerItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return VH(binding)


    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(getItem(position))
        holder.binding.layout.setOnClickListener {
            Log.i("zz","clicked $position")
        }
    }

    class MyModelDiffCallback : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            // 아이템 동일성 체크
            return oldItem.id.toString() == newItem.id.toString()
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            // 아이템 내용 동일성 체크
            return oldItem.body == newItem.body
        }
    }
}
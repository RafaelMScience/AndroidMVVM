package com.rafaelm.androidmvvm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.rafaelm.androidmvvm.databinding.ItemListBinding


class MainAdapter(
    var users: List<User>,
    var viewModel: MainViewModel
) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {


    inner class MainViewHolder(var binding: ItemListBinding) :
        ViewHolder(binding.root) {
        fun setBinding(
            user: User,
            viewModel: MainViewModel
        ) {
            binding.user = user
            binding.viewModel = viewModel
            binding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemListBinding>(layoutInflater, R.layout.item_list, parent, false)
        return MainViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val user = users[position]
        holder.setBinding(user, viewModel)
    }
}
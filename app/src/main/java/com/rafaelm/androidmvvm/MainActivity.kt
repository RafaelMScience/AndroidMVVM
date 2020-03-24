package com.rafaelm.androidmvvm

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.rafaelm.androidmvvm.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), MainNavigator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        viewModel.setNavigator(this)
        viewModel.getUser().observe(this, Observer { user ->
            binding.recyclerView.adapter = MainAdapter(user, viewModel)
        })

    }

    override fun onItemClick(user: User) {
        AlertDialog.Builder(this).setMessage(user.name + "\n" + user.email).show()
    }
}


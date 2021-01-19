package com.heartbeat.develop.urancompanytesttask.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.heartbeat.develop.model.Exhibit
import com.heartbeat.develop.urancompanytesttask.App
import com.heartbeat.develop.urancompanytesttask.R
import com.heartbeat.develop.urancompanytesttask.di.module.viewmodel.ViewModelFactory
import com.heartbeat.develop.urancompanytesttask.ui.viewmodel.ExhibitsViewModel
import com.heartbeat.develop.urancompanytesttask.ui.widget.ExhibitWidget
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var viewModel: ExhibitsViewModel

    private val recyclerView: RecyclerView by lazy { findViewById(R.id.recyclerView) }
    private val adapter: ExhibitsAdapter by lazy { ExhibitsAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (applicationContext as App).diComponent.inject(this)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        viewModel = ViewModelProvider(this, viewModelFactory).get(ExhibitsViewModel::class.java)
        viewModel.exhibitsLiveData.observe(this, adapter::updateList)
    }

    private fun initRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
    }

    private inner class ExhibitsAdapter(var exhibits: List<Exhibit> = listOf()) :
        RecyclerView.Adapter<ExhibitWidget>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExhibitWidget {
            return ExhibitWidget(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.widget_exhibit_item, parent, false)
            )
        }

        override fun onBindViewHolder(holder: ExhibitWidget, position: Int) {
            holder.onBindView(exhibits[position])
        }

        override fun getItemCount(): Int = exhibits.size

        fun updateList(exhibits: List<Exhibit>) {
            this.exhibits = exhibits
            notifyDataSetChanged()
        }
    }
}
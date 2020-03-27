package com.cypherx.coronavirus.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cypherx.coronavirus.model.IndiaState
import com.cypherx.coronavirus.model.IndiaStateResult


class ListAdapter(private val list: List<IndiaStateResult>)
    : RecyclerView.Adapter<IndiaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IndiaViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return IndiaViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: IndiaViewHolder, position: Int) {
        val state: IndiaStateResult = list[position]
        holder.bind(state)
    }

    override fun getItemCount(): Int = list.size

}
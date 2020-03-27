package com.cypherx.coronavirus.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cypherx.coronavirus.R
import com.cypherx.coronavirus.model.IndiaState
import com.cypherx.coronavirus.model.IndiaStateResult

class IndiaViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_india_item, parent, false)) {
    private var mstateTextView: TextView? = null
    private var mconfiemTextView: TextView? = null
    private var mdeathTextView: TextView? = null
    private var mrecoveredTextView: TextView? = null
    private var mhelplineTextView: TextView? = null



    init {
        mstateTextView = itemView.findViewById(R.id.state_nameTextView)
        mconfiemTextView = itemView.findViewById(R.id.confirmedNumberTextView)
        mdeathTextView = itemView.findViewById(R.id.deathsTextViewNumber)
        mrecoveredTextView = itemView.findViewById(R.id.recoveredTextViewNumber)
        mhelplineTextView = itemView.findViewById(R.id.helplineTextViewNumber)
    }

    fun bind(state: IndiaStateResult) {
        mstateTextView?.text = state.state_name
        mconfiemTextView?.text = state.total_case
        mdeathTextView?.text = state.total_deaths
        mrecoveredTextView?.text = state.total_recovered
        mhelplineTextView?.text = state.helpline_number
    }

}
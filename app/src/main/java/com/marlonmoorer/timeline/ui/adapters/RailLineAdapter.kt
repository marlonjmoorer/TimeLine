package com.marlonmoorer.timeline.ui.adapters

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.marlonmoorer.timeline.R
import com.marlonmoorer.timeline.api.models.Line
import com.marlonmoorer.timeline.api.models.LineStyle
import com.marlonmoorer.timeline.databinding.ItemLineBinding

class RailLineAdapter:RecyclerView.Adapter<RailLineAdapter.ViewHolder>(){

    private var lines:List<Line> = mutableListOf()
    override fun getItemCount()=lines.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(lines[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewDataBinding=ItemLineBinding.inflate(LayoutInflater.from(parent.getContext()), parent,false)
        return  ViewHolder(viewDataBinding)
    }

    fun setLines(lines:List<Line>){
        this.lines=lines
    }


    inner class  ViewHolder(val binding:ItemLineBinding):RecyclerView.ViewHolder(binding.root){

        init {
            binding.root.setOnClickListener {

            }
        }

        fun bind(model:Line){
           binding.line=model

        }

    }
}
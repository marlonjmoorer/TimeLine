package com.marlonmoorer.timeline.ui.fragments

import android.arch.lifecycle.Observer
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.marlonmoorer.timeline.R
import com.marlonmoorer.timeline.getViewModel
import com.marlonmoorer.timeline.ui.adapters.RailLineAdapter
import com.marlonmoorer.timeline.ui.viewModels.RailLinesViewModel
import kotlinx.android.synthetic.main.fragment_metro_rails.view.*

class RailLinesFragment:Fragment(){

    private lateinit var viewModel: RailLinesViewModel

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        viewModel=getViewModel()
        viewModel.loadRalLines().observe(this, Observer {railLines->
            railLines?.let { railLineAdapter.setLines(it) }
        })
    }

    private lateinit var  railLineAdapter: RailLineAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        railLineAdapter=RailLineAdapter()
        return  inflater.inflate(R.layout.fragment_metro_rails,container,false).apply {
            rails.apply {
                adapter=railLineAdapter
                layoutManager=LinearLayoutManager(context)
            }
        }
    }



}
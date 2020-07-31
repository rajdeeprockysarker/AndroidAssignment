package com.raj.androidassignment.view


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.raj.androidassignment.R
import com.raj.androidassignment.databinding.FragmentCanadaListBinding
import com.raj.androidassignment.model.RowsItem
import com.raj.androidassignment.newslistadapter.NewsRecyclerAdapter
import com.raj.androidassignment.newsviewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_canada_list.*


class NewsListFragment : Fragment(){

    lateinit var fragmentCanadaListBinding:FragmentCanadaListBinding
    private val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


      //  return inflater.inflate(R.layout.fragment_canada_list, container, false)

        fragmentCanadaListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_canada_list, container, false)
        fragmentCanadaListBinding.listfragment=this
        return fragmentCanadaListBinding.getRoot();

    }


    @SuppressLint("WrongConstant")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // Initialize a new linear layout manager
        var linearLayoutManager : LinearLayoutManager = LinearLayoutManager(
            activity?.applicationContext, // Context
            LinearLayout.VERTICAL, // Orientation
            false // Reverse layout
        )

        list.layoutManager=linearLayoutManager


        viewModel.getUserData()
        // Observe if data is updated then reload list value and change bar title
        viewModel.userData.observe(this, Observer {


            it?.let {
                // Load List
                list.adapter=
                    NewsRecyclerAdapter(
                        activity?.applicationContext!!,
                        it.rows as ArrayList<RowsItem>
                    );
                // Load Title
                (activity as MainActivity).setTitle(it.title)
                // Hide ProgressBar
                progressBar.visibility=View.GONE
            }


        })

    }

    fun floatingButtonPressed(){
        // Show ProgressBar
        progressBar.visibility=View.VISIBLE
        // Empty List Load
        list.adapter=
            NewsRecyclerAdapter(
                activity?.applicationContext!!,
                ArrayList<RowsItem>()
            )
        // Request for new data
        viewModel.getUserData()
    }

}
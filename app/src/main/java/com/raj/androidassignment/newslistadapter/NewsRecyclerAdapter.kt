package com.raj.androidassignment.newslistadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.raj.androidassignment.R
import com.raj.androidassignment.databinding.CustomViewBinding
import com.raj.androidassignment.model.RowsItem


import kotlinx.android.synthetic.main.custom_view.view.*


class NewsRecyclerAdapter(
    val cntx: Context,
    val list: ArrayList<RowsItem>
) :
    RecyclerView.Adapter<NewsRecyclerAdapter.ViewHolder>() {

    lateinit var requestOptions: RequestOptions
    lateinit var customViewBinding: CustomViewBinding
    lateinit var mRowsItem:RowsItem
    init {
        requestOptions = RequestOptions()
        requestOptions.placeholder(R.drawable.loading)
        requestOptions.error(R.drawable.noimage)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflate the custom view from xml layout file

        customViewBinding = DataBindingUtil.inflate(LayoutInflater.from(parent?.context), R.layout.custom_view, parent, false)

        this.mRowsItem= RowsItem()
        customViewBinding.newsmodel=this.mRowsItem

        // Return the view holder
        return ViewHolder(
            customViewBinding.getRoot()
        )
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        this.mRowsItem=list.get(position)
        customViewBinding.newsmodel=this.mRowsItem
        // Load Image with Glide
        Glide.with(holder?.image.context)
            .load(list.get(position).imageHref?.replace( cntx.resources.getString(R.string.http), cntx.resources.getString(R.string.https)))
            .apply(requestOptions) /// Placeholder
            .override(cntx.resources.getInteger(R.integer.image_height), cntx.resources.getInteger(R.integer.image_width))
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(holder?.image);

    }


    override fun getItemCount(): Int {

        return list.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.tv_title
        val description = itemView.tv_description
        val image = itemView.imagev
        val listRow = itemView.listRow
    }


    // This two methods useful for avoiding duplicate item
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}
package com.arpit.newsapp.responseheadline

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arpit.newsapp.R
import kotlinx.android.synthetic.main.headline_include.view.*

class HeadlineAdapter(var list: List<ArticlesItem>) : RecyclerView.Adapter<HeadlineAdapter.UserViewHolder>() {

    var onItemClick: ((user: ArticlesItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.headline_include, parent, false)
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) =
        holder.bind(list[position])

//    fun swapData(data: List<ArticlesItem>) {
//        this.list = data
//        notifyDataSetChanged()
//    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: ArticlesItem) {
            itemView.apply {
                title.text = user.title.toString()
                description.text = user.description.toString()
                content.text = user.content.toString()

                setOnClickListener {
                    // TODO: Handle on click
                    onItemClick?.invoke(user)
                }
            }
        }
    }
}
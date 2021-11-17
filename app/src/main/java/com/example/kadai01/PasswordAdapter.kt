package com.example.kadai01

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.realm.OrderedRealmCollection
import io.realm.RealmRecyclerViewAdapter

class PasswordAdapter(data: OrderedRealmCollection<Password>) :
    RealmRecyclerViewAdapter<Password, PasswordAdapter.ViewHolder>(data,true) {
    private var listener: ((Long?) -> Unit)? = null
    fun setOnItemCliskListener(listener:(Long?) -> Unit) {
        this.listener=listener
    }

    init {
        setHasStableIds(true)
    }

    class ViewHolder(cell: View) : RecyclerView.ViewHolder(cell) {
        val title: TextView = cell.findViewById(android.R.id.text1)
        val user: TextView =cell.findViewById(android.R.id.text2)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PasswordAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(android.R.layout.simple_list_item_2,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PasswordAdapter.ViewHolder, position: Int) {
        val password: Password? =getItem(position)
        holder.title.text = password?.title
        holder.user.text = password?.user
        holder.itemView.setOnClickListener{ listener?.invoke(password?.id)}
    }

    override fun getItemId(position: Int): Long {
        return getItem(position)?.id ?: 0
    }
}
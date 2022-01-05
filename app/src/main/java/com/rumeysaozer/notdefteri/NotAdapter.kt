package com.rumeysaozer.notdefteri

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotAdapter ( val context: Context, val ıNoteClick: INotClick): RecyclerView.Adapter<NotAdapter.NotHolder>(){
    private val notlar = ArrayList<Notlar>()
  class NotHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val title = itemView.findViewById<TextView>(R.id.title)
        val notTv = itemView.findViewById<TextView>(R.id.not)
        val tarih = itemView.findViewById<TextView>(R.id.date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotHolder {
       val itemView = LayoutInflater.from(parent.context).inflate(R.layout.not_rv, parent,false)
        return NotHolder(itemView)
    }

    override fun onBindViewHolder(holder: NotHolder, position: Int) {
        holder.title.setText(notlar.get(position).title)
        holder.notTv.setText(notlar.get(position).not)
        holder.tarih.setText(notlar.get(position).date)
    }

    override fun getItemCount(): Int {
        return notlar.size
    }
    fun updateList(newList : List<Notlar>){
        notlar.clear()
        notlar.addAll(newList)
        notifyDataSetChanged()
    }


}

interface INotClick{
    fun onNotClick(not: Notlar)

}
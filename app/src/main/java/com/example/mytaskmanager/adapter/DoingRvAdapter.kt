package com.example.mytaskmanager.adapter

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.mytaskmanager.R
import com.example.mytaskmanager.model.Assignment
import kotlinx.android.synthetic.main.item_doing_rv.view.*
import java.util.zip.Inflater

class DoingRvAdapter internal constructor(context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var assignments = emptyList<Assignment>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = inflater.inflate(R.layout.item_doing_rv,parent,false)
        return AssignmentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return assignments.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val current = assignments[position]
        holder.itemView.title.text = current.title
        holder.itemView.describe.text = current.description
        holder.itemView.time.text = current.time.toString()
        holder.itemView.notice.visibility = current.noticeTime?: View.GONE
    }

    inner class AssignmentViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val title:TextView = itemView.findViewById(R.id.title)
        val desc:TextView = itemView.findViewById(R.id.describe)
        val time:TextView = itemView.findViewById(R.id.time)
        val notice: ImageView = itemView.findViewById(R.id.notice)
        val checkStatus:ImageView = itemView.findViewById(R.id.checkStatus)
    }

    internal fun setAssignments(assignments: List<Assignment>) {
        this.assignments = assignments
        notifyDataSetChanged()
    }
}
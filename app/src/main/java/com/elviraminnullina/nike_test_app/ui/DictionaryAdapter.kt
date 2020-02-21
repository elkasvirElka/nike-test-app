package com.elviraminnullina.nike_test_app.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.elviraminnullina.nike_test_app.R
import com.elviraminnullina.nike_test_app.data.model.DefinitionModel

class DictionaryAdapter(private var definitionList: ArrayList<DefinitionModel> = ArrayList()) :
    RecyclerView.Adapter<DictionaryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.view_definition_item,
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return definitionList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = definitionList[position]
        holder.bind(data)
    }

    fun addList(list: List<DefinitionModel>) {
        definitionList.addAll(list)
        notifyDataSetChanged()
    }

    fun setList(list: ArrayList<DefinitionModel>) {
        definitionList = list
        notifyDataSetChanged()
    }

    fun sortBy(thumbUp: Boolean) {
        if (thumbUp) {
            definitionList.sortByDescending { x -> x.thumbs_up }
        } else {
            definitionList.sortByDescending { x -> x.thumbs_down }
        }
        notifyDataSetChanged()
    }

    inner class ViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private val definitionTextView: AppCompatTextView =
            itemView.findViewById(R.id.definition_textView)
        private val thumbUpTextView: AppCompatTextView =
            itemView.findViewById(R.id.thumb_up_textView)
        private val thumbDownTextView: AppCompatTextView =
            itemView.findViewById(R.id.thumb_down_textView)

        fun bind(data: DefinitionModel) {
            definitionTextView.text = data.definition
            thumbUpTextView.text = data.thumbs_up.toString()
            thumbDownTextView.text = data.thumbs_down.toString()
        }
    }
}
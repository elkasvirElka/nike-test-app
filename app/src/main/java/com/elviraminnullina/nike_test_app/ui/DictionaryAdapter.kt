package com.elviraminnullina.nike_test_app.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.elviraminnullina.nike_test_app.R
import com.elviraminnullina.nike_test_app.data.model.DefinitionModel

class DictionaryAdapter(private val definitionList: ArrayList<DefinitionModel> = ArrayList()) :
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


    inner class ViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private val definition_textView: AppCompatTextView =
            itemView.findViewById(R.id.definition_textView)
        //  val content: TextView = itemView.findViewById(R.id.content)

        fun bind(data: DefinitionModel) {
            definition_textView.text = data.definition
        }
    }


}
package com.example.myapplication.ui.professorsList.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.common.entity.Professor
import com.example.myapplication.R
import com.example.myapplication.ui.professorsList.viewholder.ProfessorViewHolder

class ProfessorAdapter(
    callback: DiffUtil.ItemCallback<Professor>,
    private val onClickListener: OnClickListener
) : ListAdapter<Professor, ProfessorViewHolder>(callback) {

    interface OnClickListener {
        fun onClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfessorViewHolder {
        return ProfessorViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_professor, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ProfessorViewHolder, position: Int) {
        holder.fillData(currentList[position], position)
        holder.setOnClickListener(onClickListener)
    }
}
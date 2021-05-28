package com.example.myapplication.ui.professorsList.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.common.entity.Professor
import com.example.myapplication.R
import com.example.myapplication.databinding.ItemProfessorBinding
import com.example.myapplication.ui.professorsList.viewholder.ProfessorViewHolder

class ProfessorAdapter(
    callback: DiffUtil.ItemCallback<Professor>,
    private val onItemClickListener: OnItemClickListener
) : ListAdapter<Professor, ProfessorViewHolder>(callback) {

    interface OnItemClickListener {
        fun onClick(professor: Professor)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfessorViewHolder {
        val itemBinding: ItemProfessorBinding =
            ItemProfessorBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ProfessorViewHolder(itemBinding,
            onItemClickListener
        )
    }

    override fun onBindViewHolder(holder: ProfessorViewHolder, position: Int) {
        holder.fillData(currentList[position])
    }
}
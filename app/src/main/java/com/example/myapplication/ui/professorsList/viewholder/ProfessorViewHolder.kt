package com.example.myapplication.ui.professorsList.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.common.entity.Professor
import com.example.myapplication.R
import com.example.myapplication.databinding.ItemProfessorBinding
import com.example.myapplication.ui.professorsList.adapter.ProfessorAdapter

class ProfessorViewHolder(
    private val itemProfessorBinding: ItemProfessorBinding,
    private val onItemClickListener: ProfessorAdapter.OnItemClickListener
) : RecyclerView.ViewHolder(itemProfessorBinding.root) {

    private lateinit var professor :Professor

    init {
        itemView.setOnClickListener {
            onItemClickListener.onClick(professor)
        }
    }

    fun fillData(professor: Professor) {
        this.professor = professor
        itemProfessorBinding.ivProfessorPhoto.setImageResource(R.drawable.ic_launcher_background)
        itemProfessorBinding.tvProfessorName.text = professor.name
        itemProfessorBinding.tvCourseTitle.text = professor.course
    }
}
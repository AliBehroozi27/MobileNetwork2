package com.example.myapplication.ui.professorsList.viewholder

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.common.entity.Professor
import com.example.myapplication.R
import com.example.myapplication.ui.professorsList.adapter.ProfessorAdapter

class ProfessorViewHolder(
    itemView: View,
    private val onItemClickListener: ProfessorAdapter.OnItemClickListener
) : RecyclerView.ViewHolder(itemView) {

    private var ivProfessorPhoto : AppCompatImageView = itemView.findViewById(R.id.ivProfessorPhoto)
    private var tvProfessorName : AppCompatTextView = itemView.findViewById(R.id.tvProfessorName)
    private var tvCourseTitle : AppCompatTextView = itemView.findViewById(R.id.tvCourseTitle)
    private lateinit var professor :Professor

    init {
        itemView.setOnClickListener {
            onItemClickListener.onClick(professor)
        }
    }

    fun fillData(professor: Professor) {
        this.professor = professor
        ivProfessorPhoto.setImageResource(R.drawable.ic_launcher_background)
        tvProfessorName.text = professor.name
        tvCourseTitle.text = professor.course
    }
}
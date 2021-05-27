package com.example.myapplication.ui.professorsList.viewholder

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.common.entity.Professor
import com.example.myapplication.R
import com.example.myapplication.ui.professorsList.adapter.ProfessorAdapter
import java.text.FieldPosition

class ProfessorViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {

    private var ivProfessorPhoto : AppCompatImageView = itemView.findViewById(R.id.ivProfessorPhoto)
    private var tvProfessorName : AppCompatTextView = itemView.findViewById(R.id.tvProfessorName)
    private var tvCourseTitle : AppCompatTextView = itemView.findViewById(R.id.tvCourseTitle)
    private var itemPosition = -1

    fun fillData(professor: Professor, position: Int) {
        itemPosition = position
        ivProfessorPhoto.setImageResource(R.drawable.ic_launcher_background)
        tvProfessorName.text = professor.name
        tvCourseTitle.text = professor.course
    }

    fun setOnClickListener(onClickListener: ProfessorAdapter.OnClickListener) {
        itemView.setOnClickListener {
            onClickListener.onClick(itemPosition)
        }
    }
}
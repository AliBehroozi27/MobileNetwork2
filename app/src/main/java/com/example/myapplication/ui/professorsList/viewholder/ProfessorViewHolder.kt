package com.example.myapplication.ui.professorsList.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.common.entity.Professor
import com.example.myapplication.R
import com.example.myapplication.databinding.ItemProfessorBinding
import com.example.myapplication.ui.professorsList.adapter.ProfessorAdapter
import com.squareup.picasso.Picasso

class ProfessorViewHolder(
    private val itemProfessorBinding: ItemProfessorBinding,
    private val onItemClickListener: ProfessorAdapter.OnItemClickListener
) : RecyclerView.ViewHolder(itemProfessorBinding.root) {

    companion object{
        private val IMAGE_HEIGHT = 150
        private val IMAGE_WIDTH = 150
    }

    private lateinit var professor :Professor

    init {
        itemView.setOnClickListener {
            onItemClickListener.onClick(professor)
        }
    }

    fun fillData(professor: Professor) {
        this.professor = professor

        Picasso
            .get()
            .load(professor.imageUrl)
            .resize(IMAGE_WIDTH,IMAGE_HEIGHT)
            .centerCrop()
            .placeholder(R.color.photo_background)
            .into(itemProfessorBinding.ivProfessorPhoto);

        itemProfessorBinding.tvProfessorName.text = professor.name
        itemProfessorBinding.tvCourseTitle.text = professor.course
    }
}
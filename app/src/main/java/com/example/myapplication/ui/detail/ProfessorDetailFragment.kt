package com.example.myapplication.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myapplication.databinding.FragmentProfessorDetailBinding
import com.example.myapplication.ui.util.loadFrom
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfessorDetailFragment: Fragment() {

    lateinit var binding: FragmentProfessorDetailBinding

    private val viewModel by viewModels<ProfessorDetailViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfessorDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.professor.observe(viewLifecycleOwner, { professor ->
            with (binding) {
                ivHeaderPhoto.loadFrom(professor.imageUrl)
                toolbar.title = professor.name
                tvCourseTitle.text = professor.course
                tvMostRecentDegree.text = professor.mostRecentDegree
                tvMostRecentPlaceOfStudy.text = professor.mostRecentPlaceOfStudy
            }
        })
    }
}
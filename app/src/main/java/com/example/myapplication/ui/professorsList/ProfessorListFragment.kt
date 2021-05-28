package com.example.myapplication.ui.professorsList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common.entity.Professor
import com.example.myapplication.R
import com.example.myapplication.ui.professorsList.adapter.ProfessorAdapter
import com.example.myapplication.ui.util.ViewState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_professor_list.*

@AndroidEntryPoint
class ProfessorListFragment : Fragment() {

    companion object {
        fun newInstance(): ProfessorListFragment {
            return ProfessorListFragment()
        }
    }

    private var listAdapter: ProfessorAdapter? = null
    private val viewModel by viewModels<ProfessorListViewModel>()
    private val itemClickListener = object : ProfessorAdapter.OnItemClickListener {
        override fun onClick(professor: Professor) {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_professor_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUi()
        observe()
    }

    private fun setupUi() {
        (activity as AppCompatActivity?)?.supportActionBar?.title =
            resources.getString(R.string.professors_list)

        setupList()
    }

    private fun observe() {
        viewModel.viewStateLiveData.observe(viewLifecycleOwner, {
            when (it) {
                ViewState.DATA -> setDataState()
                ViewState.EMPTY -> setEmptyState()
                ViewState.LOADING -> setLoadingState()
                ViewState.ERROR -> setErrorState()
            }
        })

        viewModel.professorsLiveData.observe(viewLifecycleOwner, {
            listAdapter!!.submitList(it)
        })

        viewModel.errorMessageLiveData.observe(viewLifecycleOwner, {
            tvStatus.text = it
        })
    }

    private fun setupList() {
        if (listAdapter == null) {
            listAdapter = ProfessorAdapter(viewModel.diffCallback, itemClickListener)
        }
        rvList.layoutManager = LinearLayoutManager(context)
        rvList.adapter = listAdapter
    }

    private fun setDataState() {
        rvList.visibility = VISIBLE
        progressBar.visibility = GONE
        tvStatus.visibility = GONE
    }

    private fun setEmptyState() {
        rvList.visibility = GONE
        progressBar.visibility = GONE
        tvStatus.visibility = VISIBLE

        tvStatus.text = resources.getString(R.string.no_items)
    }

    private fun setErrorState() {
        rvList.visibility = GONE
        progressBar.visibility = GONE
        tvStatus.visibility = VISIBLE
    }

    private fun setLoadingState() {
        rvList.visibility = GONE
        progressBar.visibility = VISIBLE
        tvStatus.visibility = GONE
    }
}
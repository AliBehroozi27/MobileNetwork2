package com.example.myapplication.ui.professorsList

import android.os.Bundle
import android.view.*
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common.entity.Professor
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentProfessorDetailBinding
import com.example.myapplication.databinding.FragmentProfessorListBinding
import com.example.myapplication.ui.professorsList.adapter.ProfessorAdapter
import com.example.myapplication.ui.util.ViewState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_professor_list.*

@AndroidEntryPoint
class ProfessorListFragment : Fragment() {

    private lateinit var binding: FragmentProfessorListBinding
    private var listAdapter: ProfessorAdapter? = null
    private val viewModel by viewModels<ProfessorListViewModel>()
    private val itemClickListener = object : ProfessorAdapter.OnItemClickListener {
        override fun onClick(professor: Professor) {
            findNavController().navigate(R.id.action_professorListFragment_to_professorDetailFragment)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.option_about_us -> {
                findNavController().navigate(R.id.action_professorListFragment_to_aboutFragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfessorListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.mainToolbar)
        setupUi()
        observe()
    }

    private fun setupUi() {
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

    override fun onDestroyView() {
        // Prevent memory leak when fragment is detached but not destroyed
        listAdapter = null
        super.onDestroyView()
    }
}
package com.example.mytaskmanager.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.mytaskmanager.R
import com.example.mytaskmanager.adapter.DoingRvAdapter
import com.example.mytaskmanager.viewmodel.AssignmentViewModel
import kotlinx.android.synthetic.main.fragment_doing.*

class DoingFragment : Fragment() {

    private lateinit var assignmentViewModel: AssignmentViewModel

    val options = navOptions {
        anim {
            enter = R.anim.slide_in_right
            exit = R.anim.slide_out_left
            popEnter = R.anim.slide_in_left
            popExit = R.anim.slide_out_right
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_doing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        val adapter = activity?.let { DoingRvAdapter(it) }
        doingRv.adapter = adapter
        doingRv.layoutManager = LinearLayoutManager(activity)
        assignmentViewModel = ViewModelProviders.of(this).get(AssignmentViewModel::class.java)
        assignmentViewModel.allAssignments.observe(this, Observer { assignments ->
            assignments?.let { adapter?.setAssignments(it) }
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() = DoingFragment()
    }
}

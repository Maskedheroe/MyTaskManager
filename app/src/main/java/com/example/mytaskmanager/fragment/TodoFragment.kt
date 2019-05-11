package com.example.mytaskmanager.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mytaskmanager.MainActivity

import com.example.mytaskmanager.R
import kotlinx.android.synthetic.main.fragment_todo.*

class TodoFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_todo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        toMapBtn.setOnClickListener{
            activity?.let {
                    it1 -> MainActivity.start(it1)

            }
            Log.d("hello","tomap")
        }
    }



    companion object {
        @JvmStatic
        fun newInstance() = TodoFragment()
    }
}

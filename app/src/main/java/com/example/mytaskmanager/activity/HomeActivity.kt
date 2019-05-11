package com.example.mytaskmanager.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.mytaskmanager.fragment.TodoFragment
import com.example.mytaskmanager.R
import kotlinx.android.synthetic.main.activity_home.*
import com.example.mytaskmanager.adapter.FragmentViewPagerAdapter
import com.example.mytaskmanager.Global
import com.example.mytaskmanager.MainActivity
import com.example.mytaskmanager.fragment.DoingFragment
import com.example.mytaskmanager.fragment.DoneFragment
import com.google.android.material.tabs.TabLayout




class HomeActivity : AppCompatActivity() {

    private var fragmentList: ArrayList<Fragment> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initTab()
        initViewpager()
    }

    private fun initViewpager() {
        val todoFragment = TodoFragment()
        val doingFragment = DoingFragment()
        val doneFragment = DoneFragment()

        fragmentList.add(todoFragment)
        fragmentList.add(doingFragment)
        fragmentList.add(doneFragment)

        val adapter = FragmentViewPagerAdapter(supportFragmentManager,this,fragmentList,Global.titleList)
        viewPager.adapter = adapter
        navTabLayout.setupWithViewPager(viewPager)
    }

    private fun initTab() {
        for (i in Global.titleList) {
            navTabLayout.addTab(navTabLayout.newTab().setText(i))
        }

        var listener = object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {

                customToolbar.setTitle(tab?.text.toString())

                when (tab?.position) {
                    0 -> {
                        customToolbar.setRightButton(R.drawable.plus,true)
//                        customToolbar.setRightClickListener(View.OnClickListener {
//                            NewAssignmentActivity.start(this@HomeActivity)
//                        })
                    }

                    1 -> {
                        customToolbar.setRightButton(null,false)
                    }

                    2 -> {
                        customToolbar.setRightButton(null,false)
                    }
                }

            }
        }

        navTabLayout.addOnTabSelectedListener(listener)
    }


}

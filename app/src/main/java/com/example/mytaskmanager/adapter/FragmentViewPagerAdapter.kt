package com.example.mytaskmanager.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

open class FragmentViewPagerAdapter(
    fm: FragmentManager?,
    context: Context,
    list: List<Fragment>,
    title: List<String>) : FragmentStatePagerAdapter(fm) {

    var fragmentList = list
    var titleList = title

    override fun getItem(position: Int): Fragment {
        return fragmentList.get(position)
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titleList[position]
    }
}
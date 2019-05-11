package com.example.mytaskmanager.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.baidu.location.BDAbstractLocationListener
import com.baidu.location.BDLocation
import com.baidu.location.LocationClient
import com.baidu.location.LocationClientOption
import com.baidu.mapapi.map.BaiduMap
import com.baidu.mapapi.map.MapView
import com.baidu.mapapi.map.MyLocationConfiguration
import com.baidu.mapapi.map.MyLocationData

import com.example.mytaskmanager.R



class MapFragment : Fragment() {


    private lateinit var mapView: MapView
    private lateinit var mBaiduMap: BaiduMap

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_map, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mapView = view.findViewById(R.id.mapView)
        mBaiduMap = mapView.map
        mBaiduMap.mapType = BaiduMap.MAP_TYPE_NORMAL

        initLocation()
    }

    private fun initLocation() {
        mBaiduMap.isMyLocationEnabled = true
        val mLocationClient = LocationClient(activity)
        val mLocationClientOption = LocationClientOption()
        mLocationClientOption.openGps = true
        mLocationClientOption.setCoorType("bd09ll")
        mLocationClientOption.setScanSpan(3000)
        mLocationClientOption.setIsNeedAddress(true)
        mLocationClientOption.priority = LocationClientOption.GpsFirst
        mLocationClientOption.locationMode = LocationClientOption.LocationMode.Hight_Accuracy
        mLocationClient.locOption = mLocationClientOption
        val mCurrentMode = MyLocationConfiguration.LocationMode.FOLLOWING
        val myLocationConfiguration = MyLocationConfiguration(mCurrentMode,true,null)
        mBaiduMap.setMyLocationConfiguration(myLocationConfiguration)
        val myLocationListener = object : BDAbstractLocationListener() {
            override fun onReceiveLocation(location: BDLocation?) {
                if (location == null || mapView == null) {
                    return
                }
                val locData = MyLocationData.Builder()
                    .accuracy(location.radius)
                    .direction(location.direction)
                    .latitude(location.latitude)
                    .longitude(location.longitude)
                    .build()
                mBaiduMap.setMyLocationData(locData)
            }
        }
        mLocationClient.registerLocationListener(myLocationListener)
        mLocationClient.start()
    }

    companion object {
        @JvmStatic
        fun newInstance() = MapFragment()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mBaiduMap.setCompassEnable(false)
        mapView.onDestroy()
    }

}

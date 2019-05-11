package com.example.mytaskmanager.utils

import android.content.Context
import com.baidu.trace.Trace
import com.baidu.trace.LBSTraceClient
import com.baidu.trace.model.PushMessage
import com.baidu.trace.model.OnTraceListener





class LocationTraceUtils {
    val serviceID: Long = 212434
    var entityName = "myTaskManager"
    var isNeedObjectStorage = false
    var mTrace = Trace(serviceID, entityName, isNeedObjectStorage)

    // 定位周期(单位:秒)
    val gatherInterval = 5
    // 打包回传周期(单位:秒)
    val packInterval = 10




    fun initTrace(context: Context) {
        var mTraceClient = LBSTraceClient(context)
        // 设置定位和打包周期
        mTraceClient.setInterval(gatherInterval, packInterval)
        mTraceClient.startTrace(mTrace,mTraceListener)
        mTraceClient.startGather(mTraceListener)
    }

    // 初始化轨迹服务监听器
    var mTraceListener: OnTraceListener = object : OnTraceListener {
        override fun onBindServiceCallback(status: Int, message: String?) {

        }

        override fun onInitBOSCallback(status: Int, message: String?) {

        }

        // 开启服务回调
        override fun onStartTraceCallback(status: Int, message: String) {}

        // 停止服务回调
        override fun onStopTraceCallback(status: Int, message: String) {}

        // 开启采集回调
        override fun onStartGatherCallback(status: Int, message: String) {}

        // 停止采集回调
        override fun onStopGatherCallback(status: Int, message: String) {}

        // 推送回调
        override fun onPushCallback(messageNo: Byte, message: PushMessage) {}
    }


}
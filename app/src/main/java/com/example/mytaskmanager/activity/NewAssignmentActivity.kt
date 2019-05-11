package com.example.mytaskmanager.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mytaskmanager.R

class NewAssignmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_assignment)
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context,NewAssignmentActivity::class.java)
            context.startActivity(intent)
        }
    }
}

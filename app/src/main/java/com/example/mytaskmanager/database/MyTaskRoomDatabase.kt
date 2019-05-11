package com.example.mytaskmanager.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mytaskmanager.model.Assignment
import com.example.mytaskmanager.dao.AssignmentDao

@Database(entities = [Assignment::class], version = 1)
public abstract class MyTaskRoomDatabase: RoomDatabase() {
    abstract fun assignmentDao(): AssignmentDao

    companion object {
        @Volatile
        private var INSTANCE: MyTaskRoomDatabase? = null

        fun getDatabase(context: Context): MyTaskRoomDatabase {

            val tempInstance = INSTANCE
            if (tempInstance != null) return tempInstance

            synchronized(this) {
                val instance =
                    Room.databaseBuilder(context,
                        MyTaskRoomDatabase::class.java,
                        "AppDatabase"
                    ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
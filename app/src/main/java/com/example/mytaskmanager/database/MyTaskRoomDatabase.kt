package com.example.mytaskmanager.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.mytaskmanager.model.Assignment
import com.example.mytaskmanager.dao.AssignmentDao
import com.example.mytaskmanager.model.AssignmentStatus
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Assignment::class], version = 1)
public abstract class MyTaskRoomDatabase: RoomDatabase() {

    abstract fun assignmentDao(): AssignmentDao

    companion object {
        @Volatile
        private var INSTANCE: MyTaskRoomDatabase? = null

        fun getDatabase(context: Context,scope: CoroutineScope): MyTaskRoomDatabase {

            val tempInstance = INSTANCE
            if (tempInstance != null) return tempInstance

            synchronized(this) {
                val instance =
                    Room.databaseBuilder(context,
                        MyTaskRoomDatabase::class.java,
                        "AppDatabase"
                    ).addCallback(MyTaskDatabaseCallback(scope))
                        .build()
                INSTANCE = instance
                return instance
            }
        }

        private class MyTaskDatabaseCallback(private val scope: CoroutineScope): RoomDatabase.Callback(){
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populaateDatabase(database.assignmentDao())
                    }
                }
            }
        }

        private fun populaateDatabase(assignmentDao: AssignmentDao) {
            assignmentDao.deleteAllAssignment()
            var assignment = Assignment(1,"测试任务",System.currentTimeMillis(),"这里是描述内容啊大啊阿萨阿达是啊啊啊啊啊啊大大是、",null,2)
            assignmentDao.insert(assignment)
            assignment = Assignment(1,"测试任务2",System.currentTimeMillis(),"这里是描述内容啊大啊阿萨阿达是啊啊啊啊啊啊大大是、",null,2)
            assignmentDao.insert(assignment)
        }
    }



}
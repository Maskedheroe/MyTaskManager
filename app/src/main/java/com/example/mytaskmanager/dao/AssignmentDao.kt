package com.example.mytaskmanager.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mytaskmanager.model.Assignment
import com.example.mytaskmanager.model.AssignmentStatus

@Dao
interface AssignmentDao {
    @Query("SELECT * from assignment_table ORDER BY time")
    fun getAllAssignment(): LiveData<List<Assignment>>
    @Insert
    fun insert(assignment: Assignment)
    @Query("DELETE FROM assignment_table")
    fun deleteAllAssignment()
    @Query("DELETE FROM assignment_table WHERE code = (:mCode)")
    fun deleteAssignment(mCode: Long)
    @Query("SELECT * from assignment_table WHERE status = (:status)")
    fun getTypeAssignment(status: AssignmentStatus): LiveData<List<Assignment>>
}
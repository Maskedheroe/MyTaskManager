package com.example.mytaskmanager.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.mytaskmanager.dao.AssignmentDao
import com.example.mytaskmanager.model.Assignment
import com.example.mytaskmanager.model.AssignmentStatus

class AssignmentRepository(private val assignmentDao: AssignmentDao) {
    val allAssignments: LiveData<List<Assignment>> = assignmentDao.getAllAssignment()
    val doingAssignments: LiveData<List<Assignment>> = assignmentDao.getTypeAssignment(2)
    val doneAssignments: LiveData<List<Assignment>> = assignmentDao.getTypeAssignment(3)
    val todoAssignments: LiveData<List<Assignment>> = assignmentDao.getTypeAssignment(1)

    @WorkerThread
    suspend fun insert(assignment: Assignment) {
        assignmentDao.insert(assignment)
    }



}
package com.example.mytaskmanager.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.mytaskmanager.database.MyTaskRoomDatabase
import com.example.mytaskmanager.model.Assignment
import com.example.mytaskmanager.repository.AssignmentRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class AssignmentViewModel(application: Application): AndroidViewModel(application) {
    private var parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Main
    private val scope = CoroutineScope(coroutineContext)
    private val repository: AssignmentRepository
    val allAssignments: LiveData<List<Assignment>>
    val todoAssignments: LiveData<List<Assignment>>
    val doingAssignments: LiveData<List<Assignment>>
    val doneAssignments: LiveData<List<Assignment>>

    init {
        val assignmentDao = MyTaskRoomDatabase.getDatabase(application,scope).assignmentDao()
        repository = AssignmentRepository(assignmentDao)
        allAssignments = repository.allAssignments
        todoAssignments = repository.todoAssignments
        doingAssignments = repository.doingAssignments
        doneAssignments = repository.doneAssignments
    }

    fun insert(assignment: Assignment) = scope.launch(Dispatchers.IO){
        repository.insert(assignment)
    }

    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }

}
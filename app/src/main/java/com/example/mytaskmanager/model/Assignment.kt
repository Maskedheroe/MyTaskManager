package com.example.mytaskmanager.model
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "assignment_table")
data class Assignment(
    @PrimaryKey @ColumnInfo(name = "code")val code: Long,
    @ColumnInfo(name = "title")val title: String,
    @ColumnInfo(name = "time")val time: Int,
    @ColumnInfo(name = "description")val description: String?,
    @ColumnInfo(name = "notice")val noticeTime: Int?,
    @ColumnInfo(name = "status")val status:AssignmentStatus)


enum class AssignmentStatus(status: Int) {
    TODO(1),
    DOING(2),
    DONE(3)
}
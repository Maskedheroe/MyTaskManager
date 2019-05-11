package com.example.mytaskmanager.model
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "assignment_table")
data class Assignment(
    @PrimaryKey @ColumnInfo(name = "code")var code: Long,
    @ColumnInfo(name = "title")var title: String,
    @ColumnInfo(name = "time")var time: Long,
    @ColumnInfo(name = "description")var description: String?,
    @ColumnInfo(name = "notice")var noticeTime: Int?,
    @ColumnInfo(name = "status")var status: Int)


enum class AssignmentStatus(status: Int) {
    TODO(1),
    DOING(2),
    DONE(3)
}
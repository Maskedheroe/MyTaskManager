package com.example.mytaskmanager

class Global {
    companion object {
        val titleList = listOf("Todo","Doing","Done")
    }

}

enum class TabString(val string: String) {
    TODO("Todo"),
    DOING("Doing"),
    DONE("Done")
}
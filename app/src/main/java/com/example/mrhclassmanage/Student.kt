package com.example.mrhclassmanage

/**
 * Simple model for student information used across activities.
 */
data class Student(
    val id: String,
    val name: String,
    val gender: String,
    val className: String
) {
    override fun toString(): String {
        return "学号:$id\n姓名:$name\n性别:$gender\n班级:$className"
    }
}

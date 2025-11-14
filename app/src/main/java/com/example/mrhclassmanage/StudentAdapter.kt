package com.example.mrhclassmanage

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

/**
 * Minimal adapter that renders student information with blue text.
 */
class StudentAdapter(
    context: Context,
    private val students: List<Student>
) : ArrayAdapter<Student>(context, 0, students) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(
            R.layout.item_student,
            parent,
            false
        )
        val student = students[position]
        val infoView = view.findViewById<TextView>(R.id.studentInfo)
        infoView.text = student.toString()
        return view
    }
}

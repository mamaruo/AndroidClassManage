package com.example.mrhclassmanage

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val students = mutableListOf(
        Student(id = "2023110001", name = "张三", gender = "男", className = "软件一班"),
        Student(id = "2023110002", name = "李四", gender = "女", className = "软件二班"),
        Student(id = "2023111001", name = "李贵", gender = "男", className = "网工1班"),
        Student(id = "2023111002", name = "冯朝", gender = "男", className = "网工2班"),
        Student(id = "2023111003", name = "朱贵", gender = "女", className = "网工3班")
    )

    private lateinit var studentAdapter: StudentAdapter

    private val addStudentLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                appendStudentFromResult(result.data)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "Mamaruo2023110224"

        val listView = findViewById<ListView>(R.id.listStudents)
        studentAdapter = StudentAdapter(this, students)
        listView.adapter = studentAdapter

        val addButton = findViewById<Button>(R.id.btnAddStudent)
        addButton.setOnClickListener {
            val intent = Intent(this, AddStudentActivity::class.java)
            addStudentLauncher.launch(intent)
        }
    }

    private fun appendStudentFromResult(data: Intent?) {
        data ?: return
        val studentId = data.getStringExtra(AddStudentActivity.EXTRA_ID)?.trim().orEmpty()
        val studentName = data.getStringExtra(AddStudentActivity.EXTRA_NAME)?.trim().orEmpty()
        val studentGender = data.getStringExtra(AddStudentActivity.EXTRA_GENDER)?.trim().orEmpty()
        val studentClass = data.getStringExtra(AddStudentActivity.EXTRA_CLASS)?.trim().orEmpty()
        if (studentId.isBlank() || studentName.isBlank() || studentGender.isBlank() || studentClass.isBlank()) {
            return
        }
        students.add(
            Student(
                id = studentId,
                name = studentName,
                gender = studentGender,
                className = studentClass
            )
        )
        studentAdapter.notifyDataSetChanged()
    }
}
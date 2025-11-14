package com.example.mrhclassmanage

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddStudentActivity : AppCompatActivity() {

    private lateinit var idInput: EditText
    private lateinit var nameInput: EditText
    private lateinit var genderInput: EditText
    private lateinit var classInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)
        supportActionBar?.title = "新增学生"

        idInput = findViewById(R.id.inputStudentId)
        nameInput = findViewById(R.id.inputStudentName)
        genderInput = findViewById(R.id.inputStudentGender)
        classInput = findViewById(R.id.inputStudentClass)

        findViewById<Button>(R.id.btnConfirm).setOnClickListener { submitStudent() }
        findViewById<Button>(R.id.btnCancel).setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }
    }

    private fun submitStudent() {
        val studentId = idInput.text.toString().trim()
        val studentName = nameInput.text.toString().trim()
        val studentGender = genderInput.text.toString().trim()
        val studentClass = classInput.text.toString().trim()
        if (studentId.isBlank() || studentName.isBlank() || studentGender.isBlank() || studentClass.isBlank()) {
            Toast.makeText(this, "请填写完整信息", Toast.LENGTH_SHORT).show()
            return
        }
        val data = Intent().apply {
            putExtra(EXTRA_ID, studentId)
            putExtra(EXTRA_NAME, studentName)
            putExtra(EXTRA_GENDER, studentGender)
            putExtra(EXTRA_CLASS, studentClass)
        }
        setResult(RESULT_OK, data)
        finish()
    }

    companion object {
        const val EXTRA_ID = "extra_student_id"
        const val EXTRA_NAME = "extra_student_name"
        const val EXTRA_GENDER = "extra_student_gender"
        const val EXTRA_CLASS = "extra_student_class"
    }
}

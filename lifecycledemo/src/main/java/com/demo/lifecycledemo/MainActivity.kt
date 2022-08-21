package com.demo.lifecycledemo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.demo.lifecycledemo.student.StudentViewModel

class MainActivity : AppCompatActivity() {
    companion object {
        fun actionStart(context: Context) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }

    lateinit var editTv: EditText
    lateinit var submitBt: Button
    lateinit var scoreTv: TextView
    lateinit var studentViewModel: StudentViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        studentViewModel = ViewModelProvider(this).get(StudentViewModel::class.java)

        editTv = findViewById(R.id.editTv)
        submitBt = findViewById(R.id.submitBt)
        scoreTv = findViewById(R.id.scoreTv)

        studentViewModel.newScore.observe(this){
            scoreTv.text=it.toString()
        }
        submitBt.setOnClickListener {
            var studentId = editTv.text.trim().toString()
            studentViewModel.setStudentId(studentId.toInt())
        }
    }
}
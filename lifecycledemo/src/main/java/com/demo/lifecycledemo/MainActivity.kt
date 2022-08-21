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
import com.demo.lifecycledemo.databinding.ActivityMainBinding
import com.demo.lifecycledemo.student.StudentViewModel

class MainActivity : AppCompatActivity() {
    companion object {
        fun actionStart(context: Context) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }


    lateinit var studentViewModel: StudentViewModel
    lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        studentViewModel = ViewModelProvider(this).get(StudentViewModel::class.java)

        studentViewModel.newScore.observe(this) {
            activityMainBinding.scoreTv.text = it.toString()
        }
        activityMainBinding.submitBt.setOnClickListener {
            var studentId = activityMainBinding.editTv.text.trim().toString()
            studentViewModel.setStudentId(studentId.toInt())
        }
    }
}
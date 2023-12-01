package com.example.todolist

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : ComponentActivity() {
    private lateinit var todoAdapter: TodoAdapter
    private lateinit var player: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        val notificationListenerIntent = Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS)
        startActivity(notificationListenerIntent)
        applicationContext
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdapter = TodoAdapter(mutableListOf())

        rvTodoItems.adapter = todoAdapter
        rvTodoItems.layoutManager = LinearLayoutManager(this)

        btnTodoAdd.setOnClickListener {
            val todoTitle = etTodoTitle.text.toString()
            if (todoTitle.isNotEmpty()) {
                val todo = Todo(todoTitle, false)
                todoAdapter.addTodo(todo)
                etTodoTitle.text.clear()
            }
        }

        deleteDoneTodos.setOnClickListener {
            todoAdapter.deleteFinished()
            player.stop()
        }
    }
}
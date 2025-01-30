package com.example.taskmanagerapp.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.taskmanagerapp.R

class AddTaskFragment : Fragment(R.layout.fragment_add_task) {

    private val taskViewModel: TaskViewModel by activityViewModels() // Shared ViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editTextTask: EditText = view.findViewById(R.id.editTextTask)
        val buttonAdd: Button = view.findViewById(R.id.buttonAdd)

        buttonAdd.setOnClickListener {
            val task = editTextTask.text.toString()
            if (task.isNotEmpty()) {
                taskViewModel.addTask(task) // Save task in ViewModel
                Toast.makeText(requireContext(), "Task Added: $task", Toast.LENGTH_SHORT).show()
                editTextTask.text.clear()
            } else {
                Toast.makeText(requireContext(), "Please enter a task!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

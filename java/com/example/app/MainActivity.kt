package com.example.app

import DatabaseHelper
import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.app.ui.theme.AppTheme


class MainActivity : ComponentActivity() {
    lateinit var btn: Button
    lateinit var view: Button
    lateinit var nm: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val databaseHelper = DatabaseHelper(this)

        btn = findViewById(R.id.submit)
        view = findViewById(R.id.view)
        nm = findViewById(R.id.name)

        btn.setOnClickListener {
            try {
                val ctf = CtfModel(nm.text.toString())
                val dbh = DatabaseModel(this@MainActivity)
                dbh.add(ctf)
                Toast.makeText(this@MainActivity, "Added Successfully", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                println(e)
            }
        }

        view.setOnClickListener {
            val myDb = DatabaseModel(this@MainActivity)
            val res = myDb.getAllData()
            if (res.count == 0) {
                showMessage("Error", "Nothing found")
                return@setOnClickListener
            }
            val buffer = StringBuffer()
            while (res.moveToNext()) {
                buffer.append("Name :" + res.getString(0) + "\n\n")
            }
            showMessage("DETAILS", buffer.toString())
        }
    }

    private fun showMessage(title: String, message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setCancelable(true)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.show()
    }
}

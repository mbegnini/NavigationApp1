package br.com.navigationapp1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result: ActivityResult ->
            if(result.resultCode == Activity.RESULT_OK) {
                val intent = result.data
                val message = intent?.getStringExtra("MESSAGE")
                Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            }
    }

    fun openSecondActivity(view: View){
        val editText: EditText = findViewById(R.id.mainActivityEditText)
        val message = editText.text.toString()
        val intent = Intent(this, SecondActivity::class.java).apply {
            putExtra("MESSAGE",message)
        }
        startForResult.launch(intent)
    }
}
package br.com.navigationapp1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val message = intent.getStringExtra("MESSAGE")
        val textView = findViewById<TextView>(R.id.secondActivityTextView)
        textView.setText(message)
    }

    fun finishActivity(view: View){
        val intent = Intent()
        intent.putExtra("MESSAGE","mensagem de retorno da activity 2")
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}
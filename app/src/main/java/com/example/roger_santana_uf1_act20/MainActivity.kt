package com.example.roger_santana_uf1_act20
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var statusTextView: TextView
    private lateinit var downloadButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        statusTextView = findViewById(R.id.statusTextView)
        downloadButton = findViewById(R.id.downloadButton)

        downloadButton.setOnClickListener {
            startDownload()
        }
    }

    private fun startDownload() {

        statusTextView.text = "Descarregant..."


        CoroutineScope(Dispatchers.IO).launch {

            val delayTime = (2000..5000).random().toLong()
            delay(delayTime)

            withContext(Dispatchers.Main) {
                statusTextView.text = "Descarregat correctament!"
            }
        }
    }
}
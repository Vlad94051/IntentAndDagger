package ru.tms.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainActivity: AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainViewModel

    init {
        MainApplication.appComponent?.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<Button>(R.id.bt).setOnClickListener{
            startSendIntent()
        }

        findViewById<Button>(R.id.btCall).setOnClickListener{
            startCallIntent()
        }
    }

    override fun onStart() {
        super.onStart()
        initObservers()
    }

    private fun initObservers() {
        viewModel.source.observe(this) { sources ->
            Log.e("!!!SOURCES:", "$sources")
        }
    }

   private fun startSendIntent() {
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, "Hello world")
        }
        startActivity(Intent.createChooser(intent,"Hello"))
    }

    private fun startCallIntent(){
        val intentPhone = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:5556737")
        }
        startActivity(Intent.createChooser(intentPhone, "Title some text"))
    }
}
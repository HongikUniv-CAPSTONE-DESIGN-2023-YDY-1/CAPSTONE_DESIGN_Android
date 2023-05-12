package com.example.pta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pta.databinding.ActivityCameraSearchBinding

class CameraSearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCameraSearchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCameraSearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
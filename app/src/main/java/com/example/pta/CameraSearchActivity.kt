package com.example.pta
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.FileProvider
import com.example.pta.databinding.ActivityCameraSearchBinding
import java.io.File

import android.graphics.BitmapFactory


class CameraSearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCameraSearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCameraSearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageUriString = intent.getStringExtra("imageUri")
        if (imageUriString != null) {
            val imageFile = File(imageUriString)
            val imageUri = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                FileProvider.getUriForFile(this, "com.example.pta.fileprovider", imageFile)
            } else {
                Uri.fromFile(imageFile)
            }

            val bitmap = BitmapFactory.decodeFile(imageFile.path)
            binding.imageView2.setImageBitmap(bitmap)
        }
    }
}

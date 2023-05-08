package com.example.pta.ui.camera


import android.Manifest
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import androidx.camera.core.ImageCapture
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.pta.PermissionUtil
import com.example.pta.databinding.FragmentCameraBinding
import java.io.File
import java.util.concurrent.ExecutorService


class CameraFragment : Fragment() {

    private var _binding: FragmentCameraBinding? = null
    private val binding get() = _binding!!
    private var imageCapture: ImageCapture? = null

    private lateinit var outputDirectory: File
    private lateinit var cameraExecutor: ExecutorService

    private lateinit var cameraAnimationListener: Animation.AnimationListener

    private var savedUri: Uri? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val cameraViewModel =
            ViewModelProvider(this).get(CameraViewModel::class.java)
        _binding = FragmentCameraBinding.inflate(inflater, container, false)
        val root: View = binding.root






        return root
    }
    private fun permissionCheck() {
        var permissionList =
            listOf(Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE)
        if (!PermissionUtil.checkPermission(this, permissionList)) {
            PermissionUtil.requestPermission(this, permissionList)


        } else {
           openCamera()
        }



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
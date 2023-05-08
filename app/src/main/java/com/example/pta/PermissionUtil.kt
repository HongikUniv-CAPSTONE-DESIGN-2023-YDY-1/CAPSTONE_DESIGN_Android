package com.example.pta


import android.content.Context
import android.content.pm.PackageManager
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.pta.ui.camera.CameraFragment

object PermissionUtil {

    private var permissionLauncher: ActivityResultLauncher<Array<String>>? = null

    fun checkPermission(context: CameraFragment, permissionList: List<String>): Boolean {
        for (permission in permissionList) {
            if (ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_DENIED) {
                return false
            }
        }
        return true
    }

    fun requestPermission(fragment: Fragment, permissionList: List<String>, onGranted: () -> Unit, onDenied: () -> Unit) {
        val permissions = permissionList.toTypedArray()
        permissionLauncher = fragment.registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            val isGranted = permissions.all { it.value == true }
            if (isGranted) {
                onGranted()
            } else {
                onDenied()
            }
        }
        permissionLauncher?.launch(permissions)
    }
}


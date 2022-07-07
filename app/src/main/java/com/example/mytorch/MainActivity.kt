package com.example.mytorch

import android.content.Context
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnTurnOn).setOnClickListener {
            openFlashLight(true)
        }

        findViewById<Button>(R.id.btnTurnOff).setOnClickListener {
            openFlashLight(false)
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun openFlashLight( flashLightStatus: Boolean = false) {
        val cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        val cameraId = cameraManager.cameraIdList[0]
        try {
            cameraManager.setTorchMode(cameraId, flashLightStatus)
        } catch (e: CameraAccessException) {
            Log.d("Error", e.toString())
        }
    }

}
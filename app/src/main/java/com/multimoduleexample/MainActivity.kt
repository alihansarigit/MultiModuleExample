package com.multimoduleexample

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.network.api.ResponseApi
import com.network.viewmodel.AppService
import com.ui.CustomButton
import com.ui.CustomEditText
import com.ui.CustomTextView
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), SensorEventListener {

    lateinit var parent:LinearLayout
    lateinit var button:CustomButton
    lateinit var editText:CustomEditText
    lateinit var textView:CustomTextView
    var running = false
    var sensorManager: SensorManager? = null
    lateinit var viewModel: AppService
    //lateinit var viewModel:HomeViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      //  sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        button = findViewById(R.id.btnSend)
        editText = findViewById(R.id.actMain_edt_message)
        textView = findViewById(R.id.actMain_txt_stepCounter)

        viewModel = ViewModelProvider(this).get(AppService::class.java)


        //TODO İlk elemanın kullanıcı adını EditText'e yazdır.
        //TODO Unit test için -> edit text içinde yazan değerle aynı mı diye kontrol ettir.
        //TODO Unit test için -> MockService Appserviceten miras alıcak. Hazır responseu kullanıcaz.

        button.onClick = View.OnClickListener {
            viewModel.getUsers().observe(this, Observer{ response ->
                when(response){
                    is ResponseApi.success->{
                        Toast.makeText(this@MainActivity, response.data.get(0)?.name, Toast.LENGTH_SHORT).show()
                    }
                    is ResponseApi.loading->{
                        Toast.makeText(this@MainActivity, "Loading", Toast.LENGTH_SHORT).show()
                    }
                    is ResponseApi.error->{
                        Toast.makeText(this@MainActivity, response.message, Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACTIVITY_RECOGNITION) == PackageManager.PERMISSION_DENIED){
            //ask for permission
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    requestPermissions(arrayOf(Manifest.permission.ACTIVITY_RECOGNITION),0)
                }
        }
    }

    suspend fun getUsers(){

//        RetrofitClient.retrofitInstance.getUsers()?.let { it->
//            it.let { test ->
//                //success
//                Toast.makeText(this, test.get(0)?.name, Toast.LENGTH_SHORT).show()
//            }
//        }?: kotlin.run {
//            // error
//            Toast.makeText(this, "" , Toast.LENGTH_SHORT).show()
//        }
        //-----
//        AppService().getUsers()?.let { it->
//            it.let { test ->
//                //success
//                Toast.makeText(this, test[0].name , Toast.LENGTH_SHORT).show()
//            } ?: kotlin.run {
//                //error
//            }
//        }
    }

    override fun onResume() {
        super.onResume()
//        running = true
//        val stepsSensor = sensorManager?.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)
//
//        if (stepsSensor == null) {
//            Toast.makeText(this, "No Step Counter Sensor !", Toast.LENGTH_SHORT).show()
//        } else {
//            sensorManager?.registerListener(this, stepsSensor, SensorManager.SENSOR_DELAY_UI)
//        }
    }

    override fun onPause() {
        super.onPause()
//        running = false
//        sensorManager?.unregisterListener(this)
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        Toast.makeText(this, "geldi", Toast.LENGTH_SHORT).show()
    }

    override fun onSensorChanged(event: SensorEvent) {
        if (running) {
            Toast.makeText(this, event.values[0].toString(), Toast.LENGTH_SHORT).show()
            textView.setText("" + event.values[0])
        }
    }
}
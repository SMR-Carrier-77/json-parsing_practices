package com.example.jsonparsing_practices

import android.location.Address
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.jsonparsing_practices.databinding.ActivityMainBinding
import org.json.JSONObject
import kotlin.math.log




class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnload.setOnClickListener {
            binding.progressbar.visibility = View.VISIBLE


            val queue = Volley.newRequestQueue(this)
            val url = "https://arsarkar.xyz/SMR_practices/info.json"

            // Corrected here 👇
            val stringRequest = StringRequest(
                Request.Method.GET, url,
                { response ->
                    // Show the JSON response in a TextView
                    binding.progressbar.visibility=View.GONE
                    Log.d("sserversre", response)
                    var jsonObject: JSONObject= JSONObject(response)
                    var Name: String= jsonObject.getString("name")
                    var Mobile: String= jsonObject.getString("mobile")
                    var Email: String= jsonObject.getString("email")
                    var Address: String= jsonObject.getString("address")

                    binding.textView1.text=Name
                    binding.textView2.text=Mobile
                    binding.textView3.text=Email
                    binding.textView4.text=Address


                },
                {
                    binding.btnload.text = "Volley error!"
                 binding.progressbar.visibility=View.GONE
                }
            )

            // Add the request to the RequestQueue
            queue.add(stringRequest)
        }
    }
}



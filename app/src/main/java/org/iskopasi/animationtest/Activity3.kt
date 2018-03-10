package org.iskopasi.animationtest

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.iskopasi.animationtest.databinding.Activity3Binding

class Activity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: Activity3Binding = DataBindingUtil.setContentView(this, R.layout.activity_3)

        binding.button.setOnClickListener({
            val intent = Intent(this, Activity4::class.java)
            startActivity(intent)
        })
    }
}
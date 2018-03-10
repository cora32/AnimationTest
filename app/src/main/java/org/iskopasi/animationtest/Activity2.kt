package org.iskopasi.animationtest

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.iskopasi.animationtest.databinding.Activity2Binding

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: Activity2Binding = DataBindingUtil.setContentView(this, R.layout.activity_2)
        binding.button.setOnClickListener({
            //            var bundle: Bundle? = null
//
//            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                val options = ActivityOptions.makeSceneTransitionAnimation(this, binding.iv, getString(R.string.iv_transition))
//                bundle = options.toBundle()
//            }
//
            val intent = Intent(this, Activity3::class.java)
//            if (bundle == null) {
//                startActivity(intent)
//            } else {
//                startActivity(intent, bundle)
//            }
            startActivity(intent)
            overridePendingTransition(R.anim.anim1, R.anim.anim2)
        })
    }
}
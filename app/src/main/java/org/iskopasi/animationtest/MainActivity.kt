package org.iskopasi.animationtest

import android.animation.ObjectAnimator
import android.app.ActivityOptions
import android.content.Intent
import android.databinding.DataBindingUtil
import android.graphics.drawable.Animatable
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.AccelerateDecelerateInterpolator
import org.iskopasi.animationtest.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.iv.post({
            val topOffset = resources.getDimension(R.dimen.offset)
            val anim1 = ObjectAnimator.ofFloat(binding.iv, "y", binding.iv.y, topOffset)
            anim1.duration = 600
            anim1.interpolator = AccelerateDecelerateInterpolator()
            anim1.start()

            val anim11 = binding.iv.animate()
            anim11.duration = 600
            anim11.scaleX(0.5f)
            anim11.scaleY(0.5f)
            anim11.interpolator = AccelerateDecelerateInterpolator()
            anim11.start()

            val anim2 = binding.button.animate()
            anim2.duration = 1000
            anim2.alpha(1f)
            anim2.start()
        })

        binding.button.setOnClickListener({
            var bundle: Bundle? = null

            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val options = ActivityOptions.makeSceneTransitionAnimation(this, binding.iv, getString(R.string.iv_transition))
                bundle = options.toBundle()
            }

            val intent = Intent(this, Activity2::class.java)
            if (bundle == null) {
                startActivity(intent)
            } else {
                startActivity(intent, bundle)
            }
        })

        (binding.vec.drawable as Animatable).start()
    }
}

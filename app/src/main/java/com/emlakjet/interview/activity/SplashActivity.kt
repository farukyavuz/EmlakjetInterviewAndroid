package com.emlakjet.interview.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.emlakjet.interview.R

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val handler = Handler()
        handler.postDelayed({
            val i = Intent(this, NoticesActivity::class.java)
            startActivity(i)
            finish()
        }, 1000)
    }
}

package com.zihuan.zimageutils

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zihuan.view.zimglibrary.ImageConfig
import com.zihuan.view.zimglibrary.loader
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ImageConfig.mContext = applicationContext
        ImageConfig.setConfig {
        }
        iv_test.loader("https://avatars3.githubusercontent.com/u/31381762?s=40&v=4")
    }
}

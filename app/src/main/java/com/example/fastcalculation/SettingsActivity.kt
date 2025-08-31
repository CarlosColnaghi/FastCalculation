package com.example.fastcalculation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fastcalculation.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {
    private val activitySettingsBinding: ActivitySettingsBinding by lazy {
        ActivitySettingsBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activitySettingsBinding.root)
    }
}
package com.example.fastcalculation

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.fastcalculation.Extras.EXTRA_SETTINGS
import com.example.fastcalculation.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity(), OnPlayGame {
    private val activityGameActivity: ActivityGameBinding by lazy{
        ActivityGameBinding.inflate(layoutInflater)
    }
    private lateinit var settings: Settings

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityGameActivity.root)

        setSupportActionBar(activityGameActivity.gameToolbarInclude.gameToolbar)
        supportActionBar?.apply{
            title = getString(R.string.app_name)
            subtitle = getString(R.string.game)
        }
        settings = intent.getParcelableExtra(EXTRA_SETTINGS) ?: Settings()
        supportFragmentManager.beginTransaction().replace(R.id.gameFrameLayout, WelcomeFragment.newInstance(settings)).commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_game, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.restartGameMenu -> {
                onPlayGame()
                true
            }
            R.id.exitGameMenu -> {
                finish()
                true
            }
            else -> false
        }
    }

    override fun onPlayGame() {
        supportFragmentManager.beginTransaction().replace(R.id.gameFrameLayout, GameFragment.newInstance(settings)).commit()
    }
}
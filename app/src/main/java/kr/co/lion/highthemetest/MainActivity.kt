package kr.co.lion.highthemetest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import kr.co.lion.highthemetest.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    private val app = HighThemeTestApp.getInstance()

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        if(app.getThemePrefs() == "basic"){
            binding.basicBtn.isChecked = true
        } else if(app.getThemePrefs() == "night"){
            binding.darkBtn.isChecked = true
        } else if(app.getThemePrefs() == "high"){
            binding.highBtn.isChecked = true
        } else {
            binding.systemBtn.isChecked = true
        }

        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.basicBtn -> {
                    app.setThemePrefs("basic")
                }
                R.id.darkBtn -> {
                    app.setThemePrefs("night")
                }
                R.id.highBtn -> {
                    app.setThemePrefs("high")
                }
                R.id.systemBtn -> {
                    app.delThemePrefs()
                }
            }
        }

        binding.checkButton.setOnClickListener {
            Log.d("theme", app.getThemePrefs().toString())
            recreate()
        }

        binding.buttonActivity.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }
}

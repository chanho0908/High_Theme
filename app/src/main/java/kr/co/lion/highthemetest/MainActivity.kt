package kr.co.lion.highthemetest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import kr.co.lion.highthemetest.PreferenceUtil.delThemePrefs
import kr.co.lion.highthemetest.PreferenceUtil.getThemePrefs
import kr.co.lion.highthemetest.PreferenceUtil.setThemePrefs
import kr.co.lion.highthemetest.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        if(getThemePrefs() == "basic"){
            binding.basicBtn.isChecked = true
        } else if(getThemePrefs() == "night"){
            binding.darkBtn.isChecked = true
        } else if(getThemePrefs() == "high"){
            binding.highBtn.isChecked = true
        } else {
            binding.systemBtn.isChecked = true
        }

        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.basicBtn -> {
                    setThemePrefs("basic")
                }
                R.id.darkBtn -> {
                    setThemePrefs("night")
                }
                R.id.highBtn -> {
                    setThemePrefs("high")
                }
                R.id.systemBtn -> {
                    delThemePrefs()
                }
            }
        }

        binding.checkButton.setOnClickListener {
            Log.d("theme", getThemePrefs().toString())
            recreate()
        }

        binding.buttonActivity.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }
}

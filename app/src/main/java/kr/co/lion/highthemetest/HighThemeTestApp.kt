package kr.co.lion.highthemetest

import android.app.Application
import android.app.UiModeManager
import android.content.Context
import android.content.SharedPreferences

class HighThemeTestApp: Application() {
    init {
        instance = this
    }

    companion object {

        private var instance : HighThemeTestApp? = null

        fun context(): Context {
            return instance!!.applicationContext
        }

        fun getInstance(): HighThemeTestApp {
            return instance!!
        }

    }

    fun getApplicationPrefs(key: String): SharedPreferences {
        return context().getSharedPreferences(key, MODE_PRIVATE)
    }

    fun setThemePrefs(theme: String) {
        val prefs = getApplicationPrefs("theme_prefs")
        prefs.edit().putString("theme", theme).apply()
    }

    fun getThemePrefs(): String? {
        val prefs = getApplicationPrefs("theme_prefs")
        return prefs.getString("theme", "")
    }

    fun delThemePrefs() {
        val prefs = getApplicationPrefs("theme_prefs")
        prefs.edit().remove("theme").apply()
    }

    fun getNightMode(): Boolean {
        val uiModeManager = context().getSystemService(Context.UI_MODE_SERVICE) as UiModeManager
        val nightMode = uiModeManager.nightMode
        val nightModeCheck = false

        when(nightMode){
            UiModeManager.MODE_NIGHT_YES -> {
                setThemePrefs("basic")
                return true
            }
            UiModeManager.MODE_NIGHT_NO -> {
                setThemePrefs("basic")
                return false
            }
        }

        return nightModeCheck
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
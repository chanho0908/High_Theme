package kr.co.lion.highthemetest

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.annotation.StyleRes

object PreferenceUtil {

    private lateinit var app: Context

    fun init(context: Context) {
        app = context
    }

    fun getApplicationPrefs(key: String): SharedPreferences{
        return app.getSharedPreferences(key, MODE_PRIVATE)
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
}





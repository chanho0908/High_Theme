package kr.co.lion.highthemetest

import android.app.UiModeManager
import android.content.Context
import androidx.core.content.ContextCompat.getSystemService
import kr.co.lion.highthemetest.PreferenceUtil.setThemePrefs

object ThemeUtil {
    private lateinit var app: Context

    fun init(context: Context) {
        app = context
    }

    fun getNightMode(): Boolean {
        val uiModeManager = app.getSystemService(Context.UI_MODE_SERVICE) as UiModeManager
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

}
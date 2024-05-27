package kr.co.lion.highthemetest

import android.app.Application

class HighThemeTestApp: Application() {
    override fun onCreate() {
        super.onCreate()
        PreferenceUtil.init(this)
        ThemeUtil.init(this)
    }
}
package uz.gita.historyofsports

import android.app.Application

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        SharedPref.init(this)
    }

}
package com.ericampire.smsreader.application

import android.app.Application
import android.content.IntentFilter
import com.ericampire.smsreader.application.receiver.SmsReceiver

class App : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
package com.ericampire.smsreader.application.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsMessage
import android.widget.Toast


class SmsReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action.equals("android.provider.Telephony.SMS_RECEIVED")) {
            val bundle = intent.extras
            if (bundle != null) {
                val pdus =
                    bundle["pdus"] as Array<Any>?
                val messages: Array<SmsMessage?> = arrayOfNulls<SmsMessage>(pdus!!.size)
                for (i in pdus.indices) {
                    messages[i] = SmsMessage.createFromPdu(pdus[i] as ByteArray)
                }
                if (messages.size > -1) {
                    val messageBody: String = messages[0]!!.messageBody
                    val phoneNumber: String = messages[0]!!.displayOriginatingAddress
                    Toast.makeText(context, "Expediteur : $phoneNumber", Toast.LENGTH_LONG).show()
                    Toast.makeText(context, "Message : $messageBody", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}

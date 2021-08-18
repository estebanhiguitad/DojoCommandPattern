package command.ceiba.com.co.dojocommandpattern

import android.app.Application
import android.util.Log
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging

class CommandPattern : Application() {
    override fun onCreate() {
        super.onCreate()

        FirebaseMessaging.getInstance().token
            .addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Log.i(TAG, "getInstanceId failed", task.exception)
                    return@OnCompleteListener
                }
                val token = task.result
                val msg = "token de firebase $token"
                Log.d(TAG, msg)
            })
    }

    companion object {
        private const val TAG = "CommandPattern"
    }
}
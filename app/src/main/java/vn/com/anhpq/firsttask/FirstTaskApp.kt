package vn.com.anhpq.firsttask

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log

class FirstTaskApp : Application(), Application.ActivityLifecycleCallbacks {
    companion object {
        private val TAG = FirstTaskApp::class.simpleName
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "<------------------OnCrate------------------>")
    }

    override fun onActivityPaused(activity: Activity) {
        Log.d(TAG, "<------------------onActivityPaused------------------>")
    }

    override fun onActivityStarted(activity: Activity) {
        Log.d(TAG, "<------------------onActivityStarted------------------>")
    }

    override fun onActivityDestroyed(activity: Activity) {
        Log.d(TAG, "<------------------onActivityDestroyed------------------>")
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        Log.d(TAG, "<------------------onActivitySaveInstanceState------------------>")
    }

    override fun onActivityStopped(activity: Activity) {
        Log.d(TAG, "<------------------onActivityStopped------------------>")
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        Log.d(TAG, "<------------------onActivityCreated------------------>")
    }

    override fun onActivityResumed(activity: Activity) {
        Log.d(TAG, "<------------------onActivityResumed------------------>")
    }
}
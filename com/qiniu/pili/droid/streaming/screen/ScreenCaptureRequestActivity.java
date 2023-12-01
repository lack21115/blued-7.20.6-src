package com.qiniu.pili.droid.streaming.screen;

import a.a.a.a.a.e.e;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.projection.MediaProjectionManager;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/screen/ScreenCaptureRequestActivity.class */
public class ScreenCaptureRequestActivity extends Activity {
    public static final String ACTION_REQUEST_SCREEN_CAPTURE_RESULT = "intent.ACTION_REQUEST_SCREEN_CAPTURE_RESULT";
    public static final String KEY_RESULT_CODE = "extra.KEY_RESULT_CODE";
    public static final String KEY_RESULT_DATA = "extra.KEY_RESULT_DATA";
    public static final int REQUEST_SCREEN_CAPTURE_CODE = 1234;
    public static final String TAG = "ScreenCaptureRequestActivity";

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1234) {
            e.g.c(TAG, "send broadcast handle screen capturer");
            Intent intent2 = new Intent(ACTION_REQUEST_SCREEN_CAPTURE_RESULT);
            intent2.putExtra(KEY_RESULT_CODE, i2);
            intent2.putExtra(KEY_RESULT_DATA, intent);
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent2);
        } else {
            e.g.d(TAG, "unknown request code");
        }
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        e.g.c(TAG, "request screen capturer permission");
        startActivityForResult(((MediaProjectionManager) getSystemService(Context.MEDIA_PROJECTION_SERVICE)).createScreenCaptureIntent(), REQUEST_SCREEN_CAPTURE_CODE);
    }
}

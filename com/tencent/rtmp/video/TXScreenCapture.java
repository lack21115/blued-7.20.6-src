package com.tencent.rtmp.video;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Bundle;
import android.view.MotionEvent;
import com.bytedance.applog.tracker.Tracker;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videoproducer.capture.bd;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/video/TXScreenCapture.class */
public class TXScreenCapture {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/video/TXScreenCapture$TXScreenCaptureAssistantActivity.class */
    public static class TXScreenCaptureAssistantActivity extends Activity {
        private static final int REQUEST_CODE = 100;
        private static final String TAG = "TXScreenCaptureAssistantActivity";
        private MediaProjectionManager mMediaProjectionManager;

        @Override // android.app.Activity, android.view.Window.Callback
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            Tracker.dispatchTouchEvent(motionEvent);
            return super.dispatchTouchEvent(motionEvent);
        }

        @Override // android.app.Activity
        public void onActivityResult(int i, int i2, Intent intent) {
            MediaProjection mediaProjection;
            LiteavLog.i(TAG, "onActivityResult ".concat(String.valueOf(this)));
            try {
                mediaProjection = this.mMediaProjectionManager.getMediaProjection(i2, intent);
            } catch (Exception e) {
                LiteavLog.e(TAG, "onActivityResult mMediaProjectionManager.getMediaProjection fail.", e);
                mediaProjection = null;
            }
            bd.a(this).a(mediaProjection);
            finish();
        }

        @Override // android.app.Activity
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            LiteavLog.i(TAG, "onCreate ".concat(String.valueOf(this)));
            requestWindowFeature(1);
            MediaProjectionManager mediaProjectionManager = (MediaProjectionManager) getSystemService(Context.MEDIA_PROJECTION_SERVICE);
            this.mMediaProjectionManager = mediaProjectionManager;
            try {
                startActivityForResult(mediaProjectionManager.createScreenCaptureIntent(), 100);
            } catch (Exception e) {
                LiteavLog.e(TAG, "Start permission activity failed. ".concat(String.valueOf(e)));
                bd.a(this).a((MediaProjection) null);
                finish();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.app.Activity
        public void onDestroy() {
            super.onDestroy();
            LiteavLog.i(TAG, "onDestroy ".concat(String.valueOf(this)));
        }
    }
}

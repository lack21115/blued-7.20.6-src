package com.blued.android.module.external_sense_library.display;

import android.util.Log;
import com.sensetime.stmobile.STStickerEvent;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/display/STStickerEventCallback.class */
public class STStickerEventCallback {
    private static String TAG = "STStickerEventCallback";
    private STStickerEvent.StickerEventListener mStickerEventDefaultListener = new STStickerEvent.StickerEventListener() { // from class: com.blued.android.module.external_sense_library.display.STStickerEventCallback.1
        public void onAnimationEvent(String str, int i, int i2, int i3, int i4, long j) {
            if (str == null) {
                return;
            }
            String str2 = STStickerEventCallback.TAG;
            Log.e(str2, "onAnimationEvent " + str);
            if (i2 == 1) {
                Log.e(STStickerEventCallback.TAG, "onAnimationEvent: ST_AS_PAUSED_FIRST_FRAME");
            } else if (i2 == 3) {
                Log.e(STStickerEventCallback.TAG, "onAnimationEvent: ST_AS_PAUSED");
            }
            if (i2 == 2) {
                Log.e(STStickerEventCallback.TAG, "onAnimationEvent: ST_AS_PLAYING");
            } else if (i2 == 4) {
                Log.e(STStickerEventCallback.TAG, "onAnimationEvent: ST_AS_PAUSED_LAST_FRAME");
            } else if (i2 == 5) {
                Log.e(STStickerEventCallback.TAG, "onAnimationEvent: ST_AS_INVISIBLE");
            }
        }

        public void onKeyFrameEvent(String str, int i) {
            if (str == null) {
                return;
            }
            String str2 = STStickerEventCallback.TAG;
            Log.e(str2, "onKeyFrameEvent materialName:" + str + " frame: " + i);
        }

        public void onPackageEvent(String str, int i, int i2, int i3) {
            if (str == null) {
                return;
            }
            String str2 = STStickerEventCallback.TAG;
            Log.e(str2, "onPackageEvent " + str);
            if (i2 == 1) {
                Log.e(STStickerEventCallback.TAG, "onPackageEvent: package begin");
            } else if (i2 == 2) {
                Log.e(STStickerEventCallback.TAG, "onPackageEvent: package end");
            }
        }
    };

    public STStickerEventCallback() {
        String str = TAG;
        Log.e(str, "getInstance: " + STStickerEvent.getInstance());
        if (STStickerEvent.getInstance() != null) {
            STStickerEvent.getInstance().setStickerEventListener(this.mStickerEventDefaultListener);
        }
    }
}

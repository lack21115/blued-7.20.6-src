package com.qiniu.pili.droid.streaming;

import a.a.a.a.a.l.c;
import android.app.Activity;
import android.content.Intent;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/PLScreenYUVCapturer.class */
public class PLScreenYUVCapturer {
    public static final int REQUEST_CODE = 2008;
    public c mScreenYUVCapturerCore = new c();

    public boolean isCapturing() {
        return this.mScreenYUVCapturerCore.d();
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        return this.mScreenYUVCapturerCore.a(i, i2, intent);
    }

    public void prepare(ScreenSetting screenSetting, PLScreenYUVCapturerListener pLScreenYUVCapturerListener) {
        synchronized (this) {
            this.mScreenYUVCapturerCore.a(screenSetting, pLScreenYUVCapturerListener);
        }
    }

    public void release() {
        this.mScreenYUVCapturerCore.c();
    }

    public void requestScreenCapture(Activity activity) {
        this.mScreenYUVCapturerCore.a(activity);
    }

    public void start() {
        this.mScreenYUVCapturerCore.a();
    }

    public void stop() {
        this.mScreenYUVCapturerCore.b();
    }
}

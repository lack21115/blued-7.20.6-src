package com.qiniu.pili.droid.shortvideo;

import android.app.Activity;
import android.content.Intent;
import com.qiniu.pili.droid.shortvideo.core.QosManager;
import com.qiniu.pili.droid.shortvideo.core.g;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLScreenRecorder.class */
public final class PLScreenRecorder {
    public static final int REQUEST_CODE = 2008;
    private g mScreenRecorderCore;

    public PLScreenRecorder(Activity activity) {
        this.mScreenRecorderCore = new g(activity);
    }

    public void inputAudioFrame(byte[] bArr, long j) {
        this.mScreenRecorderCore.a(bArr, j);
    }

    public boolean isRecording() {
        return this.mScreenRecorderCore.d();
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        return this.mScreenRecorderCore.a(i, i2, intent);
    }

    public boolean prepare(PLScreenRecorderSetting pLScreenRecorderSetting, PLMicrophoneSetting pLMicrophoneSetting) {
        return this.mScreenRecorderCore.a(pLScreenRecorderSetting, pLMicrophoneSetting);
    }

    public void requestScreenRecord() {
        this.mScreenRecorderCore.a();
    }

    public void setAudioFrameListener(PLAudioFrameListener pLAudioFrameListener) {
        this.mScreenRecorderCore.a(pLAudioFrameListener);
    }

    public void setRecordStateListener(PLScreenRecordStateListener pLScreenRecordStateListener) {
        this.mScreenRecorderCore.a(pLScreenRecordStateListener);
    }

    public void start() {
        this.mScreenRecorderCore.b();
        QosManager.a().a(this.mScreenRecorderCore.e());
    }

    public void stop() {
        this.mScreenRecorderCore.c();
    }
}

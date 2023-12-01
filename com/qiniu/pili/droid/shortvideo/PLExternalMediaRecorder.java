package com.qiniu.pili.droid.shortvideo;

import android.content.Context;
import com.qiniu.pili.droid.shortvideo.core.QosManager;
import com.qiniu.pili.droid.shortvideo.core.d;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLExternalMediaRecorder.class */
public class PLExternalMediaRecorder {
    private d mExternalMediaRecorderCore;

    public PLExternalMediaRecorder(Context context) {
        this.mExternalMediaRecorderCore = new d(context);
    }

    public void inputAudioFrame(byte[] bArr, int i, long j) {
        this.mExternalMediaRecorderCore.a(bArr, i, j);
    }

    public void inputVideoFrame(byte[] bArr, int i, int i2, int i3, long j) {
        this.mExternalMediaRecorderCore.a(bArr, i, i2, i3, j);
    }

    public boolean isRecording() {
        return this.mExternalMediaRecorderCore.c();
    }

    public boolean prepare(PLVideoEncodeSetting pLVideoEncodeSetting, PLAudioEncodeSetting pLAudioEncodeSetting, PLRecordSetting pLRecordSetting) {
        return this.mExternalMediaRecorderCore.a(pLVideoEncodeSetting, pLAudioEncodeSetting, pLRecordSetting);
    }

    public void setRecordStateListener(PLExternalRecordStateListener pLExternalRecordStateListener) {
        this.mExternalMediaRecorderCore.a(pLExternalRecordStateListener);
    }

    public void start() {
        this.mExternalMediaRecorderCore.a();
        QosManager.a().a(QosManager.KeyPoint.record_external_media);
        QosManager.a().a(this.mExternalMediaRecorderCore.d());
    }

    public void stop() {
        this.mExternalMediaRecorderCore.b();
    }
}

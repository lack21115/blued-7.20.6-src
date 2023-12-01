package com.qiniu.pili.droid.shortvideo;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import com.qiniu.pili.droid.shortvideo.core.QosManager;
import com.qiniu.pili.droid.shortvideo.core.f;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLImageRotateRecorder.class */
public final class PLImageRotateRecorder {
    private f mImageRotateRecorderCore = new f();

    public boolean beginSection() {
        return beginSection(null);
    }

    public boolean beginSection(String str) {
        QosManager.a().a(this.mImageRotateRecorderCore.h());
        QosManager.a().a(QosManager.KeyPoint.record_image_rotate);
        QosManager.a().a(QosManager.KeyPoint.record_section);
        return this.mImageRotateRecorderCore.a(str);
    }

    public void cancelConcat() {
        this.mImageRotateRecorderCore.o();
    }

    public void concatSections(PLVideoSaveListener pLVideoSaveListener) {
        this.mImageRotateRecorderCore.a(pLVideoSaveListener);
    }

    public boolean deleteAllSections() {
        return this.mImageRotateRecorderCore.n();
    }

    public boolean deleteLastSection() {
        return this.mImageRotateRecorderCore.m();
    }

    public void destroy() {
        destroy(true);
    }

    public void destroy(boolean z) {
        this.mImageRotateRecorderCore.b(z);
    }

    public boolean endSection() {
        QosManager.a().a(this.mImageRotateRecorderCore.h());
        return this.mImageRotateRecorderCore.c();
    }

    public int getMusicPosition() {
        return this.mImageRotateRecorderCore.p();
    }

    public void mute(boolean z) {
        this.mImageRotateRecorderCore.a(z);
        QosManager.a().a(QosManager.KeyPoint.record_mute);
    }

    public void pause() {
        this.mImageRotateRecorderCore.k();
    }

    public void prepare(Context context, PLImageRotateSetting pLImageRotateSetting, PLMicrophoneSetting pLMicrophoneSetting, PLVideoEncodeSetting pLVideoEncodeSetting, PLAudioEncodeSetting pLAudioEncodeSetting, PLRecordSetting pLRecordSetting) {
        this.mImageRotateRecorderCore.a(context, pLImageRotateSetting, pLMicrophoneSetting, pLVideoEncodeSetting, pLAudioEncodeSetting, pLRecordSetting);
        QosManager.a().a(QosManager.KeyPoint.record_microphone_capture);
    }

    public void resume() {
        this.mImageRotateRecorderCore.j();
    }

    public final void setAudioFrameListener(PLAudioFrameListener pLAudioFrameListener) {
        this.mImageRotateRecorderCore.a(pLAudioFrameListener);
    }

    public void setMusicAsset(AssetFileDescriptor assetFileDescriptor) {
        this.mImageRotateRecorderCore.a(assetFileDescriptor);
        QosManager.a().a(QosManager.KeyPoint.record_audio_mix);
    }

    public void setMusicFile(String str) {
        this.mImageRotateRecorderCore.b(str);
        QosManager.a().a(QosManager.KeyPoint.record_audio_mix);
    }

    public void setMusicPosition(int i) {
        this.mImageRotateRecorderCore.a(i);
    }

    public void setRecordSpeed(double d) {
        this.mImageRotateRecorderCore.a(d);
        QosManager.a().a(QosManager.KeyPoint.record_speed);
    }

    public final void setRecordStateListener(PLRecordStateListener pLRecordStateListener) {
        this.mImageRotateRecorderCore.a(pLRecordStateListener);
    }
}

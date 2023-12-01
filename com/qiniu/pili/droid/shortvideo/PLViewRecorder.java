package com.qiniu.pili.droid.shortvideo;

import android.content.res.AssetFileDescriptor;
import android.view.View;
import com.qiniu.pili.droid.shortvideo.core.QosManager;
import com.qiniu.pili.droid.shortvideo.core.t;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLViewRecorder.class */
public final class PLViewRecorder {
    private t mViewRecorderCore = new t();

    public boolean beginSection() {
        return beginSection(null);
    }

    public boolean beginSection(String str) {
        QosManager.a().a(QosManager.KeyPoint.record_microphone_capture);
        QosManager.a().a(QosManager.KeyPoint.record_section);
        return this.mViewRecorderCore.a(str);
    }

    public void cancelConcat() {
        this.mViewRecorderCore.o();
    }

    public void concatSections(PLVideoSaveListener pLVideoSaveListener) {
        this.mViewRecorderCore.a(pLVideoSaveListener);
    }

    public boolean deleteAllSections() {
        return this.mViewRecorderCore.n();
    }

    public boolean deleteLastSection() {
        return this.mViewRecorderCore.m();
    }

    public void destroy() {
        destroy(true);
    }

    public void destroy(boolean z) {
        this.mViewRecorderCore.b(z);
    }

    public boolean endSection() {
        QosManager.a().a(this.mViewRecorderCore.h());
        return this.mViewRecorderCore.c();
    }

    public long getCurrentSectionDurationMs() {
        return this.mViewRecorderCore.u();
    }

    public int getMusicPosition() {
        return this.mViewRecorderCore.p();
    }

    public void mute(boolean z) {
        this.mViewRecorderCore.a(z);
        QosManager.a().a(QosManager.KeyPoint.record_mute);
    }

    public void pause() {
        this.mViewRecorderCore.k();
    }

    public void prepare(View view, PLMicrophoneSetting pLMicrophoneSetting, PLVideoEncodeSetting pLVideoEncodeSetting, PLAudioEncodeSetting pLAudioEncodeSetting, PLRecordSetting pLRecordSetting) {
        this.mViewRecorderCore.a(view, pLMicrophoneSetting, pLVideoEncodeSetting, pLAudioEncodeSetting, pLRecordSetting);
    }

    public void resume() {
        this.mViewRecorderCore.j();
    }

    public final void setAudioFrameListener(PLAudioFrameListener pLAudioFrameListener) {
        this.mViewRecorderCore.a(pLAudioFrameListener);
    }

    public void setMusicAsset(AssetFileDescriptor assetFileDescriptor) {
        this.mViewRecorderCore.a(assetFileDescriptor);
        QosManager.a().a(QosManager.KeyPoint.record_audio_mix);
    }

    public void setMusicFile(String str) {
        this.mViewRecorderCore.b(str);
        QosManager.a().a(QosManager.KeyPoint.record_audio_mix);
    }

    public void setMusicPosition(int i) {
        this.mViewRecorderCore.a(i);
    }

    public void setRecordSpeed(double d) {
        this.mViewRecorderCore.a(d);
        QosManager.a().a(QosManager.KeyPoint.record_speed);
    }

    public final void setRecordStateListener(PLRecordStateListener pLRecordStateListener) {
        this.mViewRecorderCore.a(pLRecordStateListener);
    }
}

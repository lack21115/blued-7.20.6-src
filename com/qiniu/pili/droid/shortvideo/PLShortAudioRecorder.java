package com.qiniu.pili.droid.shortvideo;

import android.content.Context;
import com.qiniu.pili.droid.shortvideo.core.QosManager;
import com.qiniu.pili.droid.shortvideo.core.j;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLShortAudioRecorder.class */
public final class PLShortAudioRecorder {
    private j mShortAudioRecorderCore = new j();

    public boolean beginSection() {
        return beginSection(null);
    }

    public boolean beginSection(String str) {
        QosManager.a().a(QosManager.KeyPoint.record_audio_only);
        QosManager.a().a(QosManager.KeyPoint.record_section);
        return this.mShortAudioRecorderCore.a(str);
    }

    public void cancelConcat() {
        this.mShortAudioRecorderCore.o();
    }

    public void concatSections(PLVideoSaveListener pLVideoSaveListener) {
        this.mShortAudioRecorderCore.a(pLVideoSaveListener);
    }

    public boolean deleteAllSections() {
        return this.mShortAudioRecorderCore.n();
    }

    public boolean deleteLastSection() {
        return this.mShortAudioRecorderCore.m();
    }

    public void destroy() {
        destroy(true);
    }

    public void destroy(boolean z) {
        this.mShortAudioRecorderCore.b(z);
    }

    public boolean endSection() {
        QosManager.a().a(this.mShortAudioRecorderCore.h());
        return this.mShortAudioRecorderCore.c();
    }

    public void pause() {
        this.mShortAudioRecorderCore.k();
    }

    public void prepare(Context context, PLMicrophoneSetting pLMicrophoneSetting, PLAudioEncodeSetting pLAudioEncodeSetting, PLRecordSetting pLRecordSetting) {
        this.mShortAudioRecorderCore.a(context, pLMicrophoneSetting, pLAudioEncodeSetting, pLRecordSetting);
        QosManager.a().a(QosManager.KeyPoint.record_microphone_capture);
    }

    public boolean recoverFromDraft(Context context, PLDraft pLDraft) {
        QosManager.a().a(QosManager.KeyPoint.draftbox);
        return this.mShortAudioRecorderCore.a(context, pLDraft.getDraft());
    }

    public void resume() {
        this.mShortAudioRecorderCore.j();
    }

    public boolean saveToDraftBox(String str) {
        QosManager.a().a(QosManager.KeyPoint.draftbox);
        return this.mShortAudioRecorderCore.c(str);
    }

    public final void setAudioFrameListener(PLAudioFrameListener pLAudioFrameListener) {
        this.mShortAudioRecorderCore.a(pLAudioFrameListener);
    }

    public final void setRecordStateListener(PLRecordStateListener pLRecordStateListener) {
        this.mShortAudioRecorderCore.a(pLRecordStateListener);
    }
}

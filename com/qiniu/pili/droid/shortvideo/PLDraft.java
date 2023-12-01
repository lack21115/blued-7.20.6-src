package com.qiniu.pili.droid.shortvideo;

import com.qiniu.pili.droid.shortvideo.f.b;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLDraft.class */
public class PLDraft {
    private b mDraft;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PLDraft(b bVar) {
        this.mDraft = bVar;
    }

    private boolean isIndexValid(int i) {
        return i >= 0 && i < this.mDraft.b().size();
    }

    public PLAudioEncodeSetting getAudioEncodeSetting() {
        return this.mDraft.f();
    }

    public PLCameraSetting getCameraSetting() {
        return this.mDraft.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b getDraft() {
        return this.mDraft;
    }

    public PLFaceBeautySetting getFaceBeautySetting() {
        return this.mDraft.g();
    }

    public PLMicrophoneSetting getMicrophoneSetting() {
        return this.mDraft.d();
    }

    public PLRecordSetting getRecordSetting() {
        return this.mDraft.h();
    }

    public int getSectionCount() {
        return this.mDraft.b().size();
    }

    public long getSectionDuration(int i) {
        if (isIndexValid(i)) {
            return this.mDraft.b().get(i).e;
        }
        return -1L;
    }

    public String getSectionFilePath(int i) {
        if (isIndexValid(i)) {
            return this.mDraft.b().get(i).f13864a.getAbsolutePath();
        }
        return null;
    }

    public long getSectionStartTime(int i) {
        if (isIndexValid(i)) {
            return this.mDraft.b().get(i).d;
        }
        return -1L;
    }

    public String getTag() {
        return this.mDraft.a();
    }

    public PLVideoEncodeSetting getVideoEncodeSetting() {
        return this.mDraft.e();
    }
}

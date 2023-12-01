package com.qiniu.pili.droid.shortvideo;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLRecordStateListener.class */
public interface PLRecordStateListener {
    void onDurationTooShort();

    void onError(int i);

    void onReady();

    void onRecordCompleted();

    void onRecordStarted();

    void onRecordStopped();

    void onSectionDecreased(long j, long j2, int i);

    void onSectionIncreased(long j, long j2, int i);

    void onSectionRecording(long j, long j2, int i);
}

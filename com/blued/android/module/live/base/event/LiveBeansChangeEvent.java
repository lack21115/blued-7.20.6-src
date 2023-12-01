package com.blued.android.module.live.base.event;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/event/LiveBeansChangeEvent.class */
public class LiveBeansChangeEvent {
    public long currentScore;
    public String roomId;
    public long totalScore;

    public LiveBeansChangeEvent(String str, long j, long j2) {
        this.roomId = str;
        this.currentScore = j;
        this.totalScore = j2;
    }
}

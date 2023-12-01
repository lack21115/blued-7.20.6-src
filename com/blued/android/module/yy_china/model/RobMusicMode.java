package com.blued.android.module.yy_china.model;

import kotlin.Metadata;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/RobMusicMode.class */
public final class RobMusicMode {
    private int countDown;
    private String file;
    private boolean isHostPlay;
    private YYBorImJsonMode msg;
    private YYBorImJsonBodyMode status;
    private long time;

    public final int getCountDown() {
        return this.countDown;
    }

    public final String getFile() {
        return this.file;
    }

    public final YYBorImJsonMode getMsg() {
        return this.msg;
    }

    public final YYBorImJsonBodyMode getStatus() {
        return this.status;
    }

    public final long getTime() {
        return this.time;
    }

    public final boolean isHostPlay() {
        return this.isHostPlay;
    }

    public final void setCountDown(int i) {
        this.countDown = i;
    }

    public final void setFile(String str) {
        this.file = str;
    }

    public final void setHostPlay(boolean z) {
        this.isHostPlay = z;
    }

    public final void setMsg(YYBorImJsonMode yYBorImJsonMode) {
        this.msg = yYBorImJsonMode;
    }

    public final void setStatus(YYBorImJsonBodyMode yYBorImJsonBodyMode) {
        this.status = yYBorImJsonBodyMode;
    }

    public final void setTime(long j) {
        this.time = j;
    }
}

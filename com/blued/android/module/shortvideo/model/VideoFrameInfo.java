package com.blued.android.module.shortvideo.model;

import java.io.Serializable;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/model/VideoFrameInfo.class */
public class VideoFrameInfo implements Serializable {
    public int index;
    public String path;
    public long time;

    public String toString() {
        return "VideoFrameInfo{index='" + this.index + "', path='" + this.path + "', time='" + this.time + "'}";
    }
}

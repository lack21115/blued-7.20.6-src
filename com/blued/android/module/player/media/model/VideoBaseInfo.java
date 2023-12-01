package com.blued.android.module.player.media.model;

import java.io.Serializable;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/player/media/model/VideoBaseInfo.class */
public class VideoBaseInfo implements Serializable {
    public String a;
    public String b;
    public long c = 0;
    private int d;
    private int e;

    public int a() {
        return this.d;
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(VideoBaseInfo videoBaseInfo) {
        this.a = videoBaseInfo.a;
        this.b = videoBaseInfo.b;
        this.d = videoBaseInfo.d;
        this.e = videoBaseInfo.e;
        this.c = videoBaseInfo.c;
    }

    public int b() {
        return this.e;
    }

    public void b(int i) {
        this.e = i;
    }
}

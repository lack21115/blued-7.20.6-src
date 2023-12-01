package com.blued.android.module.player.media.model;

import android.view.View;
import com.tencent.rtmp.TXLiveBase;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/player/media/model/VideoPlayConfig.class */
public class VideoPlayConfig extends VideoBaseInfo {
    private static int A = 1;
    public static boolean d = false;
    private static int z = 1;
    public int e;
    public int f;
    public View.OnClickListener g;
    public View.OnLongClickListener h;
    public String i;
    public boolean j = false;
    public boolean k = true;
    public boolean l = false;
    public boolean m = true;
    public boolean n = false;
    public boolean o = false;
    public boolean p = true;
    public boolean q = false;
    public boolean r = true;
    public boolean s = true;
    public boolean t = true;
    public boolean u = false;
    public boolean v = false;
    public boolean w = true;
    public boolean x = false;
    public MediaInfo y;

    public VideoPlayConfig() {
        TXLiveBase.setLogLevel(0);
    }

    public static int c() {
        return z;
    }

    public static void c(int i) {
        z = i;
    }

    public void a(VideoPlayConfig videoPlayConfig) {
        super.a((VideoBaseInfo) videoPlayConfig);
        this.i = videoPlayConfig.i;
        this.j = videoPlayConfig.j;
        this.l = videoPlayConfig.l;
        this.m = videoPlayConfig.m;
        this.n = videoPlayConfig.n;
        this.o = videoPlayConfig.o;
        this.p = videoPlayConfig.p;
        this.q = videoPlayConfig.q;
        this.r = videoPlayConfig.r;
        this.s = videoPlayConfig.s;
        this.t = videoPlayConfig.t;
        this.u = videoPlayConfig.u;
        this.v = videoPlayConfig.v;
        this.y = videoPlayConfig.y;
        this.w = videoPlayConfig.w;
    }
}

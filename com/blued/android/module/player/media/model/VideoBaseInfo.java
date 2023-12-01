package com.blued.android.module.player.media.model;

import java.io.Serializable;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/player/media/model/VideoBaseInfo.class */
public class VideoBaseInfo implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public String f15652a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public long f15653c = 0;
    private int d;
    private int e;

    public int a() {
        return this.d;
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(VideoBaseInfo videoBaseInfo) {
        this.f15652a = videoBaseInfo.f15652a;
        this.b = videoBaseInfo.b;
        this.d = videoBaseInfo.d;
        this.e = videoBaseInfo.e;
        this.f15653c = videoBaseInfo.f15653c;
    }

    public int b() {
        return this.e;
    }

    public void b(int i) {
        this.e = i;
    }
}

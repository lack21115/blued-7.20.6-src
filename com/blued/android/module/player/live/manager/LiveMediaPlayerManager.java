package com.blued.android.module.player.live.manager;

import android.util.Log;
import com.blued.android.module.player.media.model.VideoPlayConfig;
import com.blued.android.module.player.txplayer.view.BlLiveView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/player/live/manager/LiveMediaPlayerManager.class */
public class LiveMediaPlayerManager {

    /* renamed from: a  reason: collision with root package name */
    private AbsLiveManager f15629a;

    public void a(OnMediaPlayerListener onMediaPlayerListener) {
        AbsLiveManager absLiveManager = this.f15629a;
        if (absLiveManager != null) {
            absLiveManager.a(onMediaPlayerListener);
        }
    }

    public void a(String str, BlLiveView blLiveView) throws Exception {
        if (this.f15629a == null && VideoPlayConfig.c() == 1) {
            this.f15629a = new LiveMediaPlayerManagerTX();
            Log.d("liveMediaPlayerManager", "tencent player");
        }
        this.f15629a.a(str, blLiveView);
    }

    public boolean a() {
        AbsLiveManager absLiveManager = this.f15629a;
        if (absLiveManager != null) {
            return absLiveManager.a();
        }
        return false;
    }

    public void b() {
        AbsLiveManager absLiveManager = this.f15629a;
        if (absLiveManager != null) {
            absLiveManager.b();
        }
    }

    public void c() {
        AbsLiveManager absLiveManager = this.f15629a;
        if (absLiveManager != null) {
            absLiveManager.c();
        }
    }

    public void d() {
        AbsLiveManager absLiveManager = this.f15629a;
        if (absLiveManager != null) {
            absLiveManager.d();
        }
    }

    public void e() {
        AbsLiveManager absLiveManager = this.f15629a;
        if (absLiveManager != null) {
            absLiveManager.e();
        }
    }

    public void f() {
        AbsLiveManager absLiveManager = this.f15629a;
        if (absLiveManager != null) {
            absLiveManager.f();
        }
    }

    public void g() {
        AbsLiveManager absLiveManager = this.f15629a;
        if (absLiveManager != null) {
            absLiveManager.g();
        }
    }

    public void h() {
        AbsLiveManager absLiveManager = this.f15629a;
        if (absLiveManager != null) {
            absLiveManager.h();
            this.f15629a = null;
        }
    }

    public void i() {
        AbsLiveManager absLiveManager = this.f15629a;
        if (absLiveManager != null) {
            absLiveManager.i();
        }
    }

    public void j() {
        AbsLiveManager absLiveManager = this.f15629a;
        if (absLiveManager != null) {
            absLiveManager.j();
        }
    }
}

package com.blued.android.module.live_china.manager;

import android.view.View;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.view.livegame.GameVideoView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/RecordingPlayerManager.class */
public class RecordingPlayerManager {

    /* renamed from: a  reason: collision with root package name */
    private GameVideoView f13815a;
    private View b;

    public RecordingPlayerManager(GameVideoView gameVideoView, View view) {
        this.f13815a = gameVideoView;
        this.b = view;
        d();
    }

    private void d() {
        this.f13815a.a(this.b);
    }

    public void a() {
        this.f13815a.a();
        Logger.a("rrb", "onStart");
    }

    public void a(int i, int i2, boolean z, int i3) {
        this.f13815a.a(i, i2, z, i3);
        Logger.a("ddrb", "setSurfaceWidthHeight width = ", Integer.valueOf(i), " -- height = ", i2 + " landLayout:" + z + "  screen:" + i3);
    }

    public void a(String str) {
        this.f13815a.setVideoPath(str);
    }

    public void b() {
        this.f13815a.b();
        Logger.a("rrb", "onPause");
    }

    public void c() {
        this.f13815a.c();
        Logger.a("rrb", "onDestroy");
    }
}

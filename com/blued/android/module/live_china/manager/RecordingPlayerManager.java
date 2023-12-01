package com.blued.android.module.live_china.manager;

import android.view.View;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.view.livegame.GameVideoView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/RecordingPlayerManager.class */
public class RecordingPlayerManager {
    private GameVideoView a;
    private View b;

    public RecordingPlayerManager(GameVideoView gameVideoView, View view) {
        this.a = gameVideoView;
        this.b = view;
        d();
    }

    private void d() {
        this.a.a(this.b);
    }

    public void a() {
        this.a.a();
        Logger.a("rrb", "onStart");
    }

    public void a(int i, int i2, boolean z, int i3) {
        this.a.a(i, i2, z, i3);
        Logger.a("ddrb", "setSurfaceWidthHeight width = ", Integer.valueOf(i), " -- height = ", i2 + " landLayout:" + z + "  screen:" + i3);
    }

    public void a(String str) {
        this.a.setVideoPath(str);
    }

    public void b() {
        this.a.b();
        Logger.a("rrb", "onPause");
    }

    public void c() {
        this.a.c();
        Logger.a("rrb", "onDestroy");
    }
}

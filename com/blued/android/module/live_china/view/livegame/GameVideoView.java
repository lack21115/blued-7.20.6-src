package com.blued.android.module.live_china.view.livegame;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.blued.android.module.player.live.view.AbsVideoView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/livegame/GameVideoView.class */
public class GameVideoView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public static int f15340a = 0;
    public static boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private AbsVideoView f15341c;
    private Context d;

    public GameVideoView(Context context) {
        super(context);
        a(context);
    }

    public GameVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public GameVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    public GameVideoView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(context);
    }

    private void d() {
        if (this.f15341c == null) {
            this.f15341c = new GameVideoPlayer(this.d);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            if (getChildCount() > 0) {
                removeAllViews();
            }
            addView(this.f15341c, layoutParams);
        }
    }

    public void a() {
        AbsVideoView absVideoView = this.f15341c;
        if (absVideoView != null) {
            absVideoView.a();
        }
    }

    public void a(int i, int i2, boolean z, int i3) {
        b = z;
        f15340a = i3;
        AbsVideoView absVideoView = this.f15341c;
        if (absVideoView != null) {
            absVideoView.a(i, i2);
        }
    }

    public void a(Context context) {
        this.d = context;
    }

    public void a(View view) {
        d();
        AbsVideoView absVideoView = this.f15341c;
        if (absVideoView != null) {
            absVideoView.a(view);
        }
    }

    public void b() {
        AbsVideoView absVideoView = this.f15341c;
        if (absVideoView != null) {
            absVideoView.b();
        }
    }

    public void c() {
        AbsVideoView absVideoView = this.f15341c;
        if (absVideoView != null) {
            absVideoView.c();
            this.f15341c = null;
        }
    }

    public void setVideoPath(String str) {
        AbsVideoView absVideoView = this.f15341c;
        if (absVideoView != null) {
            absVideoView.setVideoPath(str);
        }
    }
}

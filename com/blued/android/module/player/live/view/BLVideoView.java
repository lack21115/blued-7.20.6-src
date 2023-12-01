package com.blued.android.module.player.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

@Deprecated
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/player/live/view/BLVideoView.class */
public class BLVideoView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f15633a = false;
    private AbsVideoView b;

    /* renamed from: c  reason: collision with root package name */
    private Context f15634c;

    public BLVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public BLVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    public void a(Context context) {
        this.f15634c = context;
    }

    public void setVideoPath(String str) {
        AbsVideoView absVideoView = this.b;
        if (absVideoView != null) {
            absVideoView.setVideoPath(str);
        }
    }
}

package com.blued.android.module.player.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

@Deprecated
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/player/live/view/BLVideoView.class */
public class BLVideoView extends FrameLayout {
    public static boolean a = false;
    private AbsVideoView b;
    private Context c;

    public BLVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public BLVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    public void a(Context context) {
        this.c = context;
    }

    public void setVideoPath(String str) {
        AbsVideoView absVideoView = this.b;
        if (absVideoView != null) {
            absVideoView.setVideoPath(str);
        }
    }
}

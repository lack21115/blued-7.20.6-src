package com.blued.android.module.player.txplayer.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import com.blued.android.module.player.media.model.VideoPlayConfig;
import com.tencent.rtmp.ui.TXCloudVideoView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/player/txplayer/view/BlLiveView.class */
public class BlLiveView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private Context f15685a;

    public BlLiveView(Context context) {
        super(context);
        this.f15685a = context;
    }

    public BlLiveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15685a = context;
    }

    public BlLiveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15685a = context;
    }

    public BlLiveView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f15685a = context;
    }

    public void a() {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (VideoPlayConfig.c() != 1 || !(childAt instanceof SurfaceView)) {
                return;
            }
            removeAllViews();
        }
        if (VideoPlayConfig.c() == 1) {
            TXCloudVideoView tXCloudVideoView = new TXCloudVideoView(this.f15685a);
            tXCloudVideoView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(tXCloudVideoView);
            return;
        }
        SurfaceView surfaceView = new SurfaceView(this.f15685a);
        surfaceView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(surfaceView);
    }
}

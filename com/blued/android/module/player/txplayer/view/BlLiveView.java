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
    private Context a;

    public BlLiveView(Context context) {
        super(context);
        this.a = context;
    }

    public BlLiveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = context;
    }

    public BlLiveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = context;
    }

    public BlLiveView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.a = context;
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
            TXCloudVideoView tXCloudVideoView = new TXCloudVideoView(this.a);
            tXCloudVideoView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(tXCloudVideoView);
            return;
        }
        SurfaceView surfaceView = new SurfaceView(this.a);
        surfaceView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(surfaceView);
    }
}

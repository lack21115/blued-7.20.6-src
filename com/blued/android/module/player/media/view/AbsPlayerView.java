package com.blued.android.module.player.media.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.blued.android.core.utils.Log;
import com.blued.android.module.player.media.manager.BLVideoViewCache;
import com.blued.android.module.player.media.model.VideoPlayConfig;
import com.blued.android.module.player.media.utils.Utils;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/player/media/view/AbsPlayerView.class */
public class AbsPlayerView extends LinearLayout {
    protected Context a;
    protected LayoutInflater b;
    protected View c;
    protected AbBaseVideoView d;
    protected View e;
    protected ImageView f;
    protected ImageView g;
    protected View h;
    protected FrameLayout i;
    protected VideoPlayConfig j;
    protected String k;
    protected BLVideoViewCache l;

    public AbsPlayerView(Context context) {
        this(context, null);
    }

    public AbsPlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AbsPlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = context;
        BLVideoViewCache bLVideoViewCache = new BLVideoViewCache();
        this.l = bLVideoViewCache;
        bLVideoViewCache.a(Utils.a(context));
    }

    private boolean b(VideoPlayConfig videoPlayConfig) {
        boolean z;
        boolean z2 = false;
        if (videoPlayConfig == null) {
            Log.c("AbsPlayerView", "  initPlayData mVideoPlayConfig == null!!!");
            return false;
        }
        if (TextUtils.isEmpty(videoPlayConfig.b)) {
            Log.c("AbsPlayerView", "  initPlayData videoUrl == null!!!");
            z = false;
        } else {
            z = true;
        }
        if (!videoPlayConfig.j) {
            if (videoPlayConfig.e != 0) {
                if (videoPlayConfig.f == 0) {
                    return false;
                }
            }
            return z2;
        }
        z2 = z;
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(AbBaseVideoView abBaseVideoView) {
        if (abBaseVideoView == null) {
            return;
        }
        ViewParent parent = abBaseVideoView.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            Log.c("AbsPlayerView", "removeVideoView: " + parent);
            ((ViewGroup) parent).removeView(abBaseVideoView);
        }
        this.f.setVisibility(0);
        Log.b("AbsPlayerView", "removeVideoView");
    }

    public void a(String str) {
        Log.c("AbsPlayerView", "preloadVideo: url = " + str);
        if (this.j == null || TextUtils.isEmpty(str)) {
            Log.d("AbsPlayerView", "preloadVideo discard, mPlayConfig is null!");
            return;
        }
        AbBaseVideoView b = b(str);
        VideoPlayConfig videoPlayConfig = new VideoPlayConfig();
        videoPlayConfig.a(this.j);
        videoPlayConfig.b = str;
        b.a(videoPlayConfig);
        b.a(true);
        b.a();
    }

    public boolean a() {
        return b() && this.d.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(VideoPlayConfig videoPlayConfig) {
        if (b(videoPlayConfig)) {
            this.j = videoPlayConfig;
            this.k = videoPlayConfig.i;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbBaseVideoView b(String str) {
        AbBaseVideoView a = this.l.a(str);
        AbBaseVideoView abBaseVideoView = a;
        if (a == null) {
            abBaseVideoView = this.l.a(str, getContext());
        }
        if (abBaseVideoView.getParent() != null) {
            ((ViewGroup) abBaseVideoView.getParent()).removeView(abBaseVideoView);
        }
        return abBaseVideoView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b() {
        AbBaseVideoView abBaseVideoView;
        return this.i.getChildCount() > 0 && (abBaseVideoView = this.d) != null && abBaseVideoView.getParent() != null && this.d.getParent().equals(this.i);
    }
}

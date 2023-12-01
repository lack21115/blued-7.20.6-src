package com.blued.android.module.player.media.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.Log;
import com.blued.android.module.player.media.model.VideoPlayConfig;
import com.blued.android.module.player.media.utils.Utils;
import com.blued.android.module.player.media.view.PLVideoPageView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/player/media/view/AbBaseVideoView.class */
public abstract class AbBaseVideoView extends FrameLayout {
    public static String a = "PLVideoPageView";
    protected String b;
    protected VideoPlayConfig c;
    protected String d;
    protected OnVideoStatusListener e;
    protected PLVideoPageView.OnSeekListener f;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/player/media/view/AbBaseVideoView$OnVideoStatusListener.class */
    public interface OnVideoStatusListener {
        void a();

        void a(int i, int i2);

        void b();

        void c();

        void d();
    }

    public AbBaseVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AbBaseVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public abstract void a();

    public void a(float f, float f2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(final int i, final int i2, final View view) {
        AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.player.media.view.AbBaseVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AbBaseVideoView.this.c == null) {
                    return;
                }
                String str = AbBaseVideoView.a;
                Log.c(str, "onVideoSizeChanged: width = " + i + ", height = " + i2);
                String str2 = AbBaseVideoView.a;
                Log.c(str2, "onVideoSizeChanged: mwidth = " + AbBaseVideoView.this.c.e + ", mHeight = " + AbBaseVideoView.this.c.f);
                if (i != 0) {
                    AbBaseVideoView.this.c.a(i);
                }
                if (i2 != 0) {
                    AbBaseVideoView.this.c.b(i2);
                }
                if (AbBaseVideoView.this.c.e == 0) {
                    AbBaseVideoView.this.c.e = AbBaseVideoView.this.c.a();
                }
                if (AbBaseVideoView.this.c.f == 0) {
                    AbBaseVideoView.this.c.f = AbBaseVideoView.this.c.b();
                }
                if (AbBaseVideoView.this.c.j) {
                    Utils.a(AbBaseVideoView.this.c);
                } else {
                    Utils.b(AbBaseVideoView.this.c);
                }
                if (i == 0 || i2 == 0 || AbBaseVideoView.this.c.e == 0 || AbBaseVideoView.this.c.f == 0) {
                    return;
                }
                String str3 = AbBaseVideoView.a;
                Log.c(str3, "onVideoSizeChanged: mwidth = " + AbBaseVideoView.this.c.e + ", mHeight = " + AbBaseVideoView.this.c.f);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(AbBaseVideoView.this.c.e, AbBaseVideoView.this.c.f);
                layoutParams.gravity = 17;
                view.setLayoutParams(layoutParams);
                if (AbBaseVideoView.this.e != null) {
                    AbBaseVideoView.this.e.a(AbBaseVideoView.this.c.e, AbBaseVideoView.this.c.f);
                }
            }
        });
    }

    public abstract void a(long j);

    public void a(VideoPlayConfig videoPlayConfig) {
        this.c = videoPlayConfig;
    }

    public abstract void a(boolean z);

    public abstract void b();

    public void c() {
        if (this.e != null) {
            this.e = null;
        }
        if (this.f != null) {
            this.f = null;
        }
    }

    public abstract void d();

    public boolean e() {
        return false;
    }

    public abstract void f();

    public long getCurrentPosition() {
        return -1L;
    }

    public long getDuration() {
        return -1L;
    }

    public String getPlayUrl() {
        return this.d;
    }

    public String getSetUrl() {
        VideoPlayConfig videoPlayConfig = this.c;
        return videoPlayConfig != null ? videoPlayConfig.b : "";
    }

    public abstract void setMute(boolean z);

    public void setOnVideoStatusListener(OnVideoStatusListener onVideoStatusListener) {
        this.e = onVideoStatusListener;
    }

    public void setSeekListener(PLVideoPageView.OnSeekListener onSeekListener) {
        this.f = onSeekListener;
    }
}

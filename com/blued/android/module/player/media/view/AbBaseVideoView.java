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

    /* renamed from: a  reason: collision with root package name */
    public static String f15658a = "PLVideoPageView";
    protected String b;

    /* renamed from: c  reason: collision with root package name */
    protected VideoPlayConfig f15659c;
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
                if (AbBaseVideoView.this.f15659c == null) {
                    return;
                }
                String str = AbBaseVideoView.f15658a;
                Log.c(str, "onVideoSizeChanged: width = " + i + ", height = " + i2);
                String str2 = AbBaseVideoView.f15658a;
                Log.c(str2, "onVideoSizeChanged: mwidth = " + AbBaseVideoView.this.f15659c.e + ", mHeight = " + AbBaseVideoView.this.f15659c.f);
                if (i != 0) {
                    AbBaseVideoView.this.f15659c.a(i);
                }
                if (i2 != 0) {
                    AbBaseVideoView.this.f15659c.b(i2);
                }
                if (AbBaseVideoView.this.f15659c.e == 0) {
                    AbBaseVideoView.this.f15659c.e = AbBaseVideoView.this.f15659c.a();
                }
                if (AbBaseVideoView.this.f15659c.f == 0) {
                    AbBaseVideoView.this.f15659c.f = AbBaseVideoView.this.f15659c.b();
                }
                if (AbBaseVideoView.this.f15659c.j) {
                    Utils.a(AbBaseVideoView.this.f15659c);
                } else {
                    Utils.b(AbBaseVideoView.this.f15659c);
                }
                if (i == 0 || i2 == 0 || AbBaseVideoView.this.f15659c.e == 0 || AbBaseVideoView.this.f15659c.f == 0) {
                    return;
                }
                String str3 = AbBaseVideoView.f15658a;
                Log.c(str3, "onVideoSizeChanged: mwidth = " + AbBaseVideoView.this.f15659c.e + ", mHeight = " + AbBaseVideoView.this.f15659c.f);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(AbBaseVideoView.this.f15659c.e, AbBaseVideoView.this.f15659c.f);
                layoutParams.gravity = 17;
                view.setLayoutParams(layoutParams);
                if (AbBaseVideoView.this.e != null) {
                    AbBaseVideoView.this.e.a(AbBaseVideoView.this.f15659c.e, AbBaseVideoView.this.f15659c.f);
                }
            }
        });
    }

    public abstract void a(long j);

    public void a(VideoPlayConfig videoPlayConfig) {
        this.f15659c = videoPlayConfig;
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
        VideoPlayConfig videoPlayConfig = this.f15659c;
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

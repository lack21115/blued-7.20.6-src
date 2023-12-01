package com.tencent.liteav.videobase.videobase;

import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.CommonUtil;
import com.tencent.liteav.base.util.n;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;

@JNINamespace("liteav::video")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/videobase/DisplayTarget.class */
public class DisplayTarget {
    private int mHeight;
    private Surface mSurface;
    private WeakReference<SurfaceView> mSurfaceView;
    private a mTargetType;
    private WeakReference<TextureView> mTextureView;
    private WeakReference<TXCloudVideoView> mTxCloudVideoView;
    private final com.tencent.liteav.base.util.b mUIHandler;
    private int mWidth;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/videobase/DisplayTarget$a.class */
    public enum a {
        TEXTUREVIEW,
        SURFACEVIEW,
        SURFACE,
        TXCLOUDVIEW
    }

    public DisplayTarget(Surface surface, int i, int i2) {
        this.mUIHandler = new com.tencent.liteav.base.util.b(Looper.getMainLooper());
        this.mSurface = surface;
        this.mWidth = i;
        this.mHeight = i2;
        this.mTargetType = a.SURFACE;
    }

    public DisplayTarget(SurfaceView surfaceView) {
        this.mUIHandler = new com.tencent.liteav.base.util.b(Looper.getMainLooper());
        this.mTargetType = a.SURFACEVIEW;
        this.mSurfaceView = new WeakReference<>(surfaceView);
    }

    public DisplayTarget(TextureView textureView) {
        this.mUIHandler = new com.tencent.liteav.base.util.b(Looper.getMainLooper());
        this.mTargetType = a.TEXTUREVIEW;
        this.mTextureView = new WeakReference<>(textureView);
    }

    public DisplayTarget(DisplayTarget displayTarget) {
        this.mUIHandler = new com.tencent.liteav.base.util.b(Looper.getMainLooper());
        this.mSurface = displayTarget.mSurface;
        this.mWidth = displayTarget.mWidth;
        this.mHeight = displayTarget.mHeight;
        this.mTargetType = displayTarget.mTargetType;
        this.mTextureView = displayTarget.mTextureView;
        this.mSurfaceView = displayTarget.mSurfaceView;
        this.mTxCloudVideoView = displayTarget.mTxCloudVideoView;
    }

    public DisplayTarget(TXCloudVideoView tXCloudVideoView) {
        this.mUIHandler = new com.tencent.liteav.base.util.b(Looper.getMainLooper());
        this.mTxCloudVideoView = new WeakReference<>(tXCloudVideoView);
        this.mTargetType = a.TXCLOUDVIEW;
    }

    private void addVideoView() {
        runOnUIThread(c.a(this));
    }

    public static DisplayTarget createDisplayTarget(TXCloudVideoView tXCloudVideoView) {
        return new DisplayTarget(tXCloudVideoView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$addVideoView$1(DisplayTarget displayTarget) {
        TXCloudVideoView tXCloudVideoView;
        if (displayTarget.getType() == a.TXCLOUDVIEW && (tXCloudVideoView = displayTarget.getTXCloudVideoView()) != null && tXCloudVideoView.getVideoView() == null) {
            tXCloudVideoView.addVideoView(new TextureView(tXCloudVideoView.getContext()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$removeVideoView$2(DisplayTarget displayTarget) {
        TXCloudVideoView tXCloudVideoView;
        if (displayTarget.getType() == a.TXCLOUDVIEW && (tXCloudVideoView = displayTarget.getTXCloudVideoView()) != null) {
            tXCloudVideoView.removeVideoView();
        }
    }

    private void removeVideoView() {
        runOnUIThread(d.a(this));
    }

    private void runOnUIThread(Runnable runnable) {
        if (Looper.myLooper() == this.mUIHandler.getLooper()) {
            runnable.run();
        } else {
            this.mUIHandler.post(runnable);
        }
    }

    private void setVisibility(View view, int i) {
        if (view == null) {
            return;
        }
        runOnUIThread(b.a(view, i));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DisplayTarget displayTarget = (DisplayTarget) obj;
        return this.mWidth == displayTarget.mWidth && this.mHeight == displayTarget.mHeight && this.mTargetType == displayTarget.mTargetType && CommonUtil.equals(getTXCloudVideoView(), displayTarget.getTXCloudVideoView()) && CommonUtil.equals(getTextureView(), displayTarget.getTextureView()) && CommonUtil.equals(getSurfaceView(), displayTarget.getSurfaceView()) && CommonUtil.equals(this.mSurface, displayTarget.mSurface);
    }

    public int getHeight() {
        return this.mHeight;
    }

    public n getSize() {
        View view;
        WeakReference<TextureView> weakReference;
        int i;
        WeakReference<SurfaceView> weakReference2;
        int i2 = 0;
        if (this.mTargetType == a.SURFACE) {
            i2 = this.mWidth;
            i = this.mHeight;
        } else {
            if (this.mTargetType == a.SURFACEVIEW && (weakReference2 = this.mSurfaceView) != null) {
                view = weakReference2.get();
            } else if (this.mTargetType != a.TEXTUREVIEW || (weakReference = this.mTextureView) == null) {
                view = null;
                if (this.mTargetType == a.TXCLOUDVIEW) {
                    WeakReference<TXCloudVideoView> weakReference3 = this.mTxCloudVideoView;
                    view = null;
                    if (weakReference3 != null) {
                        view = weakReference3.get();
                    }
                }
            } else {
                view = weakReference.get();
            }
            if (view != null) {
                i2 = view.getWidth();
                i = view.getHeight();
            } else {
                i = 0;
            }
        }
        return new n(i2, i);
    }

    public Surface getSurface() {
        return this.mSurface;
    }

    public SurfaceView getSurfaceView() {
        WeakReference<SurfaceView> weakReference = this.mSurfaceView;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public TXCloudVideoView getTXCloudVideoView() {
        WeakReference<TXCloudVideoView> weakReference = this.mTxCloudVideoView;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public TextureView getTextureView() {
        WeakReference<TextureView> weakReference = this.mTextureView;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public a getType() {
        return this.mTargetType;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void hideAll() {
        setVisibility(getTextureView(), 8);
        setVisibility(getSurfaceView(), 8);
        setVisibility(getTXCloudVideoView(), 8);
        removeVideoView();
    }

    public void setSurfaceView(SurfaceView surfaceView) {
        this.mSurfaceView = new WeakReference<>(surfaceView);
        this.mTargetType = a.SURFACEVIEW;
    }

    public void setTextureView(TextureView textureView) {
        this.mTextureView = new WeakReference<>(textureView);
        this.mTargetType = a.TEXTUREVIEW;
    }

    public void showAll() {
        addVideoView();
        setVisibility(getTextureView(), 0);
        setVisibility(getSurfaceView(), 0);
        setVisibility(getTXCloudVideoView(), 0);
    }

    public String toString() {
        return "DisplayTarget{mTargetType=" + this.mTargetType + ", mTXCloudVideoView=" + getTXCloudVideoView() + ", mTextureView=" + getTextureView() + ", mSurfaceView=" + getSurfaceView() + ", mSurface=" + this.mSurface + ", mWidth=" + this.mWidth + ", mHeight=" + this.mHeight + '}';
    }
}

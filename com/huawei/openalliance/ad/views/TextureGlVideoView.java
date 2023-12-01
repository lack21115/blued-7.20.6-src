package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.splash.R;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/TextureGlVideoView.class */
public class TextureGlVideoView extends BaseGlVideoView {
    private final int q;
    private SurfaceTexture r;
    private boolean s;
    private Surface t;

    public TextureGlVideoView(Context context) {
        super(context);
        this.q = hashCode();
        this.s = false;
    }

    public TextureGlVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.q = hashCode();
        this.s = false;
    }

    public TextureGlVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.q = hashCode();
        this.s = false;
    }

    private void i() {
        Surface surface = this.t;
        if (surface != null) {
            surface.release();
            this.t = null;
        }
        SurfaceTexture surfaceTexture = this.r;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.r = null;
        }
    }

    @Override // com.huawei.openalliance.ad.views.BaseVideoView
    protected void Code(Context context) {
        LayoutInflater.from(context).inflate(R.layout.hiad_view_video, this);
        this.b = (TextureView) findViewById(R.id.hiad_id_video_texture_view);
        this.b.setSurfaceTextureListener(this);
    }

    @Override // com.huawei.openalliance.ad.views.BaseGlVideoView
    protected String getLogTag() {
        return "TextureGlVideoView" + this.q;
    }

    public boolean h() {
        return this.s;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.openalliance.ad.views.BaseVideoView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ge.V(getLogTag(), "onAttachedToWindow");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.openalliance.ad.views.BaseVideoView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ge.V(getLogTag(), "onDetachedFromWindow");
        i();
    }

    @Override // com.huawei.openalliance.ad.views.BaseVideoView, android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.s = true;
        i();
        this.r = surfaceTexture;
        Surface surface = new Surface(surfaceTexture);
        this.t = surface;
        Code(surface);
    }

    @Override // com.huawei.openalliance.ad.views.BaseVideoView, android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.s = false;
        i();
        return true;
    }

    @Override // com.huawei.openalliance.ad.views.BaseVideoView, android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        V(i, i2);
    }
}

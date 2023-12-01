package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.views.BaseVideoView;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/VideoView.class */
public class VideoView extends BaseVideoView {
    private static final String Code = "VideoView";

    public VideoView(Context context) {
        super(context);
    }

    public VideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.huawei.openalliance.ad.views.BaseVideoView
    public void B() {
        super.B();
        if (this.g != null) {
            this.g.release();
        }
        this.g = null;
        this.h = null;
    }

    @Override // com.huawei.openalliance.ad.views.BaseVideoView
    protected void Code(Context context) {
        LayoutInflater.from(context).inflate(R.layout.hiad_view_video, this);
        this.b = (TextureView) findViewById(R.id.hiad_id_video_texture_view);
        this.b.setSurfaceTextureListener(this);
    }

    public Bitmap getSurfaceBitmap() {
        return this.b.getBitmap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.openalliance.ad.views.BaseVideoView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        S();
    }

    @Override // com.huawei.openalliance.ad.views.BaseVideoView, android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        ge.V(Code, "onSurfaceTextureAvailable width: %d height: %d", Integer.valueOf(i), Integer.valueOf(i2));
        this.d = true;
        if (this.g == null || this.h != surfaceTexture) {
            if (this.g != null) {
                ge.V(Code, "release old surface when onSurfaceTextureAvailable");
                this.g.release();
            }
            if (this.h != null) {
                ge.V(Code, "release old SurfaceTexture when onSurfaceTextureAvailable");
                this.h.release();
            }
            this.g = new Surface(surfaceTexture);
            this.e.Code(this.g);
            this.h = surfaceTexture;
        }
        if (this.l == null) {
            this.l = new BaseVideoView.h(this.o);
            this.e.Code(this.l);
        }
        if (this.f9396c) {
            Code(this.i);
        }
    }

    @Override // com.huawei.openalliance.ad.views.BaseVideoView, android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        ge.V(Code, "onSurfaceTextureDestroyed");
        this.d = false;
        if (this.k) {
            L();
        }
        d();
        if (this.g != null) {
            ge.V(Code, "release old surface when onSurfaceTextureDestroyed");
            this.g.release();
            this.g = null;
        }
        if (this.h != null) {
            ge.V(Code, "release old surfaceTexture when onSurfaceTextureDestroyed");
            this.h.release();
            this.h = null;
            return true;
        }
        return true;
    }
}

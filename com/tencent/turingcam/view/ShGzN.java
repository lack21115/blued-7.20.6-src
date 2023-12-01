package com.tencent.turingcam.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingcam/view/ShGzN.class */
public class ShGzN extends TextureView implements TextureView.SurfaceTextureListener {

    /* renamed from: a  reason: collision with root package name */
    private spXPg f26144a;
    private AtomicBoolean b;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingcam/view/ShGzN$spXPg.class */
    public interface spXPg {
        void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2);

        boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture);
    }

    public ShGzN(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    public ShGzN(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new AtomicBoolean(false);
        a();
    }

    private void a() {
        setSurfaceTextureListener(this);
    }

    public void a(spXPg spxpg) {
        this.f26144a = spxpg;
    }

    @Override // android.view.TextureView
    public Bitmap getBitmap() {
        if (this.b.get()) {
            return super.getBitmap();
        }
        return null;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        spXPg spxpg = this.f26144a;
        if (spxpg != null) {
            spxpg.onSurfaceTextureAvailable(surfaceTexture, i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.b.set(false);
        spXPg spxpg = this.f26144a;
        if (spxpg != null) {
            spxpg.onSurfaceTextureDestroyed(surfaceTexture);
            return false;
        }
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.b.set(true);
    }
}

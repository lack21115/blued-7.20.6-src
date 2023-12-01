package pl.droidsonroids.gif;

import android.graphics.Canvas;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import pl.droidsonroids.gif.GifTextureView;

/* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/PlaceholderDrawingSurfaceTextureListener.class */
class PlaceholderDrawingSurfaceTextureListener implements TextureView.SurfaceTextureListener {

    /* renamed from: a  reason: collision with root package name */
    private final GifTextureView.PlaceholderDrawListener f44167a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlaceholderDrawingSurfaceTextureListener(GifTextureView.PlaceholderDrawListener placeholderDrawListener) {
        this.f44167a = placeholderDrawListener;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Surface surface = new Surface(surfaceTexture);
        Canvas lockCanvas = surface.lockCanvas(null);
        this.f44167a.a(lockCanvas);
        surface.unlockCanvasAndPost(lockCanvas);
        surface.release();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}

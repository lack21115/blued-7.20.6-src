package com.tencent.liteav.videoconsumer.renderer;

import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.rtmp.ui.TXCloudVideoView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/renderer/b.class */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final a f36816a;
    private final DisplayTarget b;

    private b(a aVar, DisplayTarget displayTarget) {
        this.f36816a = aVar;
        this.b = displayTarget;
    }

    public static Runnable a(a aVar, DisplayTarget displayTarget) {
        return new b(aVar, displayTarget);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a aVar = this.f36816a;
        DisplayTarget displayTarget = this.b;
        if (displayTarget == null) {
            if (aVar.a()) {
                if (aVar.e.getType() == DisplayTarget.a.SURFACE) {
                    aVar.a((Surface) null);
                } else if (aVar.e.getType() == DisplayTarget.a.SURFACEVIEW) {
                    aVar.a((SurfaceView) null);
                } else if (aVar.e.getType() == DisplayTarget.a.TEXTUREVIEW) {
                    aVar.a((TextureView) null);
                } else if (aVar.e.getType() == DisplayTarget.a.TXCLOUDVIEW) {
                    if (aVar.f36813a != null) {
                        aVar.f36813a.a();
                    }
                    aVar.b();
                    aVar.c();
                }
                aVar.e = null;
            }
        } else if (displayTarget.getType() == DisplayTarget.a.SURFACEVIEW) {
            aVar.a(displayTarget.getSurfaceView());
            aVar.e = displayTarget;
        } else if (displayTarget.getType() == DisplayTarget.a.TEXTUREVIEW) {
            aVar.a(displayTarget.getTextureView());
            aVar.e = displayTarget;
        } else if (displayTarget.getType() == DisplayTarget.a.SURFACE) {
            aVar.a(displayTarget.getSurface());
            aVar.a(displayTarget.getWidth(), displayTarget.getHeight());
            aVar.e = displayTarget;
        } else if (displayTarget.getType() == DisplayTarget.a.TXCLOUDVIEW) {
            TXCloudVideoView tXCloudVideoView = displayTarget.getTXCloudVideoView();
            if (tXCloudVideoView == null) {
                if (aVar.a()) {
                    if (aVar.f36813a != null) {
                        aVar.f36813a.a();
                    }
                    aVar.b();
                    aVar.c();
                }
                aVar.e = displayTarget;
                return;
            }
            DisplayTarget displayTarget2 = new DisplayTarget(displayTarget);
            SurfaceView surfaceView = tXCloudVideoView.getSurfaceView();
            TextureView videoView = tXCloudVideoView.getVideoView();
            if (surfaceView != null) {
                displayTarget2.setSurfaceView(surfaceView);
                aVar.a(surfaceView);
            } else if (videoView != null) {
                displayTarget2.setTextureView(videoView);
                aVar.a(videoView);
            } else {
                LiteavLog.e("VideoRenderer.DisplayViewWrapper", "surfaceView and textureView is null.");
            }
            aVar.e = displayTarget2;
        }
    }
}

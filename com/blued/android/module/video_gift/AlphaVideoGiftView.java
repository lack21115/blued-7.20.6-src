package com.blued.android.module.video_gift;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaDataSource;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.anythink.china.common.a.a;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.core.utils.Md5;
import com.blued.android.module.video_gift.AlphaMovieView;
import com.blued.android.module.video_gift.FitViewHelper;
import com.blued.android.module.video_gift.GLTextureView;
import java.io.File;
import java.io.FileDescriptor;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/video_gift/AlphaVideoGiftView.class */
public class AlphaVideoGiftView extends AlphaMovieView implements LifecycleObserver {

    /* renamed from: a  reason: collision with root package name */
    private static final String f16069a = AlphaVideoGiftView.class.getSimpleName();
    private static Handler b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    private Lifecycle f16070c;
    private OnVideoStateChangedListener d;
    private Status e;
    private String f;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/video_gift/AlphaVideoGiftView$OnVideoStateChangedListener.class */
    public interface OnVideoStateChangedListener {
        void a();

        void b();

        void c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/video_gift/AlphaVideoGiftView$Status.class */
    public enum Status {
        EMPTY,
        LOADING,
        PLAYING
    }

    public AlphaVideoGiftView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16070c = null;
        this.d = null;
        this.e = Status.EMPTY;
        this.f = "";
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final Context context, final IRequestHost iRequestHost, final String str) {
        AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.video_gift.AlphaVideoGiftView.5
            @Override // java.lang.Runnable
            public void run() {
                IRequestHost iRequestHost2 = iRequestHost;
                if (iRequestHost2 == null || iRequestHost2.isActive()) {
                    AlphaVideoGiftView.this.a(context, str);
                }
            }
        });
    }

    private void m() {
        setLooping(false);
        setOnVideoEndedListener(new AlphaMovieView.OnVideoEndedListener() { // from class: com.blued.android.module.video_gift.AlphaVideoGiftView.1
            @Override // com.blued.android.module.video_gift.AlphaMovieView.OnVideoEndedListener
            public void a() {
                AlphaVideoGiftView.this.setVisibility(8);
                AlphaVideoGiftView.this.a(0);
                AlphaVideoGiftView.b.postDelayed(new Runnable() { // from class: com.blued.android.module.video_gift.AlphaVideoGiftView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AlphaVideoGiftView.this.f();
                        AlphaVideoGiftView.this.e = Status.EMPTY;
                        if (AlphaVideoGiftView.this.d != null) {
                            AlphaVideoGiftView.this.d.b();
                        }
                    }
                }, 100L);
            }
        });
        setOnVideoErrorListener(new AlphaMovieView.OnVideoErrorListener() { // from class: com.blued.android.module.video_gift.AlphaVideoGiftView.2
            @Override // com.blued.android.module.video_gift.AlphaMovieView.OnVideoErrorListener
            public void a() {
                AlphaVideoGiftView.this.e = Status.EMPTY;
                if (AlphaVideoGiftView.this.d != null) {
                    AlphaVideoGiftView.this.d.c();
                }
            }
        });
        setOnVideoStartedListener(new AlphaMovieView.OnVideoStartedListener() { // from class: com.blued.android.module.video_gift.AlphaVideoGiftView.3
            @Override // com.blued.android.module.video_gift.AlphaMovieView.OnVideoStartedListener
            public void a() {
                AlphaVideoGiftView.this.e = Status.PLAYING;
            }
        });
    }

    private void n() {
        OnVideoStateChangedListener onVideoStateChangedListener = this.d;
        if (onVideoStateChangedListener != null) {
            onVideoStateChangedListener.a();
        }
        setVisibility(0);
        try {
            c();
        } catch (Exception e) {
            this.e = Status.EMPTY;
            e.printStackTrace();
        }
    }

    @Override // com.blued.android.module.video_gift.AlphaMovieView, com.blued.android.module.video_gift.GLTextureView
    public /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // com.blued.android.module.video_gift.AlphaMovieView
    public /* bridge */ /* synthetic */ void a(int i) {
        super.a(i);
    }

    @Override // com.blued.android.module.video_gift.GLTextureView
    public /* bridge */ /* synthetic */ void a(int i, int i2, int i3, int i4, int i5, int i6) {
        super.a(i, i2, i3, i4, i5, i6);
    }

    @Override // com.blued.android.module.video_gift.AlphaMovieView
    public /* bridge */ /* synthetic */ void a(Context context, Uri uri) {
        super.a(context, uri);
    }

    public void a(final Context context, final IRequestHost iRequestHost, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(context.getExternalCacheDir(), "gift");
        if (!file.exists()) {
            file.mkdirs();
        }
        final File file2 = new File(file, Md5.a(str));
        if (file2.exists()) {
            b(context, iRequestHost, file2.getPath());
            return;
        }
        final String str2 = file2.getPath() + a.e;
        FileDownloader.a(str, str2, new FileHttpResponseHandler() { // from class: com.blued.android.module.video_gift.AlphaVideoGiftView.4
            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            /* renamed from: a */
            public void onSuccess(File file3) {
                if (file3 != null && file3.exists() && file3.renameTo(file2) && file2.exists()) {
                    AlphaVideoGiftView.this.b(context, iRequestHost, file2.getPath());
                }
            }

            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFinish() {
                new File(str2).deleteOnExit();
            }
        }, iRequestHost);
    }

    public void a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str) || Status.EMPTY != this.e) {
            return;
        }
        this.e = Status.LOADING;
        this.f = str;
        a(context, Uri.parse(str));
        n();
    }

    @Override // com.blued.android.module.video_gift.GLTextureView
    public /* bridge */ /* synthetic */ void a(SurfaceTexture surfaceTexture) {
        super.a(surfaceTexture);
    }

    @Override // com.blued.android.module.video_gift.GLTextureView
    public /* bridge */ /* synthetic */ void a(SurfaceTexture surfaceTexture, int i, int i2, int i3) {
        super.a(surfaceTexture, i, i2, i3);
    }

    @Override // com.blued.android.module.video_gift.AlphaMovieView, com.blued.android.module.video_gift.GLTextureView
    public /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    @Override // com.blued.android.module.video_gift.GLTextureView
    public /* bridge */ /* synthetic */ void b(SurfaceTexture surfaceTexture) {
        super.b(surfaceTexture);
    }

    @Override // com.blued.android.module.video_gift.AlphaMovieView
    public /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.blued.android.module.video_gift.AlphaMovieView
    public /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @Override // com.blued.android.module.video_gift.AlphaMovieView
    public /* bridge */ /* synthetic */ void e() {
        super.e();
    }

    @Override // com.blued.android.module.video_gift.AlphaMovieView
    public /* bridge */ /* synthetic */ void f() {
        super.f();
    }

    @Override // com.blued.android.module.video_gift.AlphaMovieView
    public /* bridge */ /* synthetic */ void g() {
        super.g();
    }

    @Override // com.blued.android.module.video_gift.AlphaMovieView
    public /* bridge */ /* synthetic */ int getCurrentPosition() {
        return super.getCurrentPosition();
    }

    @Override // com.blued.android.module.video_gift.GLTextureView
    public /* bridge */ /* synthetic */ int getDebugFlags() {
        return super.getDebugFlags();
    }

    @Override // com.blued.android.module.video_gift.AlphaMovieView
    public /* bridge */ /* synthetic */ MediaPlayer getMediaPlayer() {
        return super.getMediaPlayer();
    }

    @Override // com.blued.android.module.video_gift.GLTextureView
    public /* bridge */ /* synthetic */ boolean getPreserveEGLContextOnPause() {
        return super.getPreserveEGLContextOnPause();
    }

    @Override // com.blued.android.module.video_gift.GLTextureView
    public /* bridge */ /* synthetic */ int getRenderMode() {
        return super.getRenderMode();
    }

    @Override // com.blued.android.module.video_gift.AlphaMovieView
    public /* bridge */ /* synthetic */ AlphaMovieView.PlayerState getState() {
        return super.getState();
    }

    @Override // com.blued.android.module.video_gift.AlphaMovieView
    public /* bridge */ /* synthetic */ boolean h() {
        return super.h();
    }

    public void i() {
        if (TextUtils.isEmpty(this.f)) {
            return;
        }
        File file = new File(this.f);
        if (file.exists()) {
            file.delete();
        }
    }

    @Override // com.blued.android.module.video_gift.GLTextureView
    public /* bridge */ /* synthetic */ void j() {
        super.j();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    protected void onEventDestroy() {
        g();
        this.e = Status.EMPTY;
        Lifecycle lifecycle = this.f16070c;
        if (lifecycle != null) {
            lifecycle.removeObserver(this);
            this.f16070c = null;
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    protected void onEventPause() {
        b();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    protected void onEventResume() {
        a();
        if (h()) {
            c();
        }
    }

    @Override // com.blued.android.module.video_gift.GLTextureView, android.view.View.OnLayoutChangeListener
    public /* bridge */ /* synthetic */ void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        super.onLayoutChange(view, i, i2, i3, i4, i5, i6, i7, i8);
    }

    @Override // com.blued.android.module.video_gift.GLTextureView, android.view.TextureView.SurfaceTextureListener
    public /* bridge */ /* synthetic */ void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        super.onSurfaceTextureAvailable(surfaceTexture, i, i2);
    }

    @Override // com.blued.android.module.video_gift.GLTextureView, android.view.TextureView.SurfaceTextureListener
    public /* bridge */ /* synthetic */ boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return super.onSurfaceTextureDestroyed(surfaceTexture);
    }

    @Override // com.blued.android.module.video_gift.GLTextureView, android.view.TextureView.SurfaceTextureListener
    public /* bridge */ /* synthetic */ void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        super.onSurfaceTextureSizeChanged(surfaceTexture, i, i2);
    }

    @Override // com.blued.android.module.video_gift.GLTextureView, android.view.TextureView.SurfaceTextureListener
    public /* bridge */ /* synthetic */ void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        super.onSurfaceTextureUpdated(surfaceTexture);
    }

    @Override // com.blued.android.module.video_gift.GLTextureView
    public /* bridge */ /* synthetic */ void setDebugFlags(int i) {
        super.setDebugFlags(i);
    }

    @Override // com.blued.android.module.video_gift.GLTextureView
    public /* bridge */ /* synthetic */ void setEGLConfigChooser(GLTextureView.EGLConfigChooser eGLConfigChooser) {
        super.setEGLConfigChooser(eGLConfigChooser);
    }

    @Override // com.blued.android.module.video_gift.GLTextureView
    public /* bridge */ /* synthetic */ void setEGLConfigChooser(boolean z) {
        super.setEGLConfigChooser(z);
    }

    @Override // com.blued.android.module.video_gift.GLTextureView
    public /* bridge */ /* synthetic */ void setEGLContextClientVersion(int i) {
        super.setEGLContextClientVersion(i);
    }

    @Override // com.blued.android.module.video_gift.GLTextureView
    public /* bridge */ /* synthetic */ void setEGLContextFactory(GLTextureView.EGLContextFactory eGLContextFactory) {
        super.setEGLContextFactory(eGLContextFactory);
    }

    @Override // com.blued.android.module.video_gift.GLTextureView
    public /* bridge */ /* synthetic */ void setEGLWindowSurfaceFactory(GLTextureView.EGLWindowSurfaceFactory eGLWindowSurfaceFactory) {
        super.setEGLWindowSurfaceFactory(eGLWindowSurfaceFactory);
    }

    @Override // com.blued.android.module.video_gift.GLTextureView
    public /* bridge */ /* synthetic */ void setGLWrapper(GLTextureView.GLWrapper gLWrapper) {
        super.setGLWrapper(gLWrapper);
    }

    public void setLifecycle(Lifecycle lifecycle) {
        if (lifecycle != null) {
            this.f16070c = lifecycle;
            lifecycle.addObserver(this);
        }
    }

    @Override // com.blued.android.module.video_gift.AlphaMovieView
    public /* bridge */ /* synthetic */ void setLooping(boolean z) {
        super.setLooping(z);
    }

    @Override // com.blued.android.module.video_gift.AlphaMovieView
    public /* bridge */ /* synthetic */ void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        super.setOnErrorListener(onErrorListener);
    }

    @Override // com.blued.android.module.video_gift.AlphaMovieView
    public /* bridge */ /* synthetic */ void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        super.setOnSeekCompleteListener(onSeekCompleteListener);
    }

    @Override // com.blued.android.module.video_gift.AlphaMovieView
    public /* bridge */ /* synthetic */ void setOnVideoEndedListener(AlphaMovieView.OnVideoEndedListener onVideoEndedListener) {
        super.setOnVideoEndedListener(onVideoEndedListener);
    }

    @Override // com.blued.android.module.video_gift.AlphaMovieView
    public /* bridge */ /* synthetic */ void setOnVideoErrorListener(AlphaMovieView.OnVideoErrorListener onVideoErrorListener) {
        super.setOnVideoErrorListener(onVideoErrorListener);
    }

    @Override // com.blued.android.module.video_gift.AlphaMovieView
    public /* bridge */ /* synthetic */ void setOnVideoStartedListener(AlphaMovieView.OnVideoStartedListener onVideoStartedListener) {
        super.setOnVideoStartedListener(onVideoStartedListener);
    }

    public void setOnVideoStateChangedListener(OnVideoStateChangedListener onVideoStateChangedListener) {
        this.d = onVideoStateChangedListener;
    }

    @Override // com.blued.android.module.video_gift.GLTextureView
    public /* bridge */ /* synthetic */ void setPreserveEGLContextOnPause(boolean z) {
        super.setPreserveEGLContextOnPause(z);
    }

    @Override // com.blued.android.module.video_gift.GLTextureView
    public /* bridge */ /* synthetic */ void setRenderMode(int i) {
        super.setRenderMode(i);
    }

    @Override // com.blued.android.module.video_gift.GLTextureView
    public /* bridge */ /* synthetic */ void setRenderer(GLTextureView.Renderer renderer) {
        super.setRenderer(renderer);
    }

    @Override // com.blued.android.module.video_gift.AlphaMovieView
    public /* bridge */ /* synthetic */ void setScaleType(FitViewHelper.ScaleType scaleType) {
        super.setScaleType(scaleType);
    }

    @Override // com.blued.android.module.video_gift.AlphaMovieView
    public /* bridge */ /* synthetic */ void setScreenOnWhilePlaying(boolean z) {
        super.setScreenOnWhilePlaying(z);
    }

    @Override // com.blued.android.module.video_gift.AlphaMovieView
    public /* bridge */ /* synthetic */ void setVideoByUrl(String str) {
        super.setVideoByUrl(str);
    }

    @Override // com.blued.android.module.video_gift.AlphaMovieView
    public /* bridge */ /* synthetic */ void setVideoFromAssets(String str) {
        super.setVideoFromAssets(str);
    }

    @Override // com.blued.android.module.video_gift.AlphaMovieView
    public /* bridge */ /* synthetic */ void setVideoFromFile(FileDescriptor fileDescriptor) {
        super.setVideoFromFile(fileDescriptor);
    }

    @Override // com.blued.android.module.video_gift.AlphaMovieView
    public /* bridge */ /* synthetic */ void setVideoFromMediaDataSource(MediaDataSource mediaDataSource) {
        super.setVideoFromMediaDataSource(mediaDataSource);
    }
}

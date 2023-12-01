package com.blued.android.module.video_gift;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.View;
import com.blued.android.module.video_gift.FitViewHelper;
import com.blued.android.module.video_gift.VideoRenderer;
import java.io.FileDescriptor;
import java.util.HashMap;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/video_gift/AlphaMovieView.class */
class AlphaMovieView extends GLTextureView {

    /* renamed from: a  reason: collision with root package name */
    private VideoRenderer f16059a;
    private Surface b;

    /* renamed from: c  reason: collision with root package name */
    private MediaPlayer f16060c;
    private OnVideoStartedListener d;
    private OnVideoEndedListener e;
    private OnVideoErrorListener f;
    private boolean g;
    private boolean h;
    private FitViewHelper i;
    private PlayerState j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.video_gift.AlphaMovieView$6  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/video_gift/AlphaMovieView$6.class */
    public static /* synthetic */ class AnonymousClass6 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f16066a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[PlayerState.values().length];
            f16066a = iArr;
            try {
                iArr[PlayerState.PREPARED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f16066a[PlayerState.PAUSED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f16066a[PlayerState.STOPPED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/video_gift/AlphaMovieView$OnVideoEndedListener.class */
    public interface OnVideoEndedListener {
        void a();
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/video_gift/AlphaMovieView$OnVideoErrorListener.class */
    public interface OnVideoErrorListener {
        void a();
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/video_gift/AlphaMovieView$OnVideoStartedListener.class */
    public interface OnVideoStartedListener {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/video_gift/AlphaMovieView$PlayerState.class */
    public enum PlayerState {
        NOT_PREPARED,
        PREPARED,
        STARTED,
        PAUSED,
        STOPPED,
        RELEASE
    }

    public AlphaMovieView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = PlayerState.NOT_PREPARED;
        if (isInEditMode()) {
            return;
        }
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        setEGLContextClientVersion(2);
        a(8, 8, 8, 8, 16, 0);
        this.i = new FitViewHelper();
        k();
        this.f16059a = new VideoRenderer();
        b(context, attributeSet);
        m();
        setRenderer(this.f16059a);
        bringToFront();
        setPreserveEGLContextOnPause(true);
        setOpaque(false);
    }

    private void a(MediaMetadataRetriever mediaMetadataRetriever) {
        try {
            int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18)) / 2;
            int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            if (this.i != null) {
                this.i.a((parseInt * 1.0f) / parseInt2, 0, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.h = true;
        i();
        if (this.g) {
            n();
        }
    }

    private void a(final MediaPlayer.OnPreparedListener onPreparedListener) {
        if (this.f16060c != null) {
            if (this.j == PlayerState.NOT_PREPARED || this.j == PlayerState.STOPPED) {
                this.f16060c.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.blued.android.module.video_gift.AlphaMovieView.4
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        AlphaMovieView.this.j = PlayerState.PREPARED;
                        onPreparedListener.onPrepared(mediaPlayer);
                    }
                });
                try {
                    this.f16060c.prepareAsync();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void b(Context context, AttributeSet attributeSet) {
        this.f16059a.a(context.getString(R.string.video_gift_shader));
    }

    private void i() {
        requestLayout();
        invalidate();
    }

    private void k() {
        this.f16060c = new MediaPlayer();
        setScreenOnWhilePlaying(true);
        setLooping(false);
        this.f16060c.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.blued.android.module.video_gift.AlphaMovieView.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                AlphaMovieView.this.j = PlayerState.PAUSED;
                if (AlphaMovieView.this.e != null) {
                    AlphaMovieView.this.e.a();
                }
            }
        });
    }

    private void m() {
        VideoRenderer videoRenderer = this.f16059a;
        if (videoRenderer != null) {
            videoRenderer.a(new VideoRenderer.OnSurfacePrepareListener() { // from class: com.blued.android.module.video_gift.AlphaMovieView.2
                @Override // com.blued.android.module.video_gift.VideoRenderer.OnSurfacePrepareListener
                public void a(Surface surface) {
                    AlphaMovieView.this.b = surface;
                    AlphaMovieView.this.g = true;
                    AlphaMovieView.this.f16060c.setSurface(surface);
                    if (AlphaMovieView.this.h) {
                        AlphaMovieView.this.n();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        a(new MediaPlayer.OnPreparedListener() { // from class: com.blued.android.module.video_gift.AlphaMovieView.3
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                AlphaMovieView.this.c();
            }
        });
    }

    private void o() {
        k();
        Surface surface = this.b;
        if (surface != null) {
            this.f16060c.setSurface(surface);
        }
        OnVideoErrorListener onVideoErrorListener = this.f;
        if (onVideoErrorListener != null) {
            onVideoErrorListener.a();
        }
    }

    @Override // com.blued.android.module.video_gift.GLTextureView
    public void a() {
        super.a();
    }

    public void a(int i) {
        this.f16060c.seekTo(i);
    }

    public void a(Context context, Uri uri) {
        f();
        try {
            this.f16060c.setDataSource(context, uri);
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(context, uri);
            a(mediaMetadataRetriever);
        } catch (Exception e) {
            Log.e("VideoSurfaceView", e.getMessage(), e);
            o();
        }
    }

    @Override // com.blued.android.module.video_gift.GLTextureView
    public void b() {
        super.b();
        d();
    }

    public void c() {
        if (this.f16060c != null) {
            int i = AnonymousClass6.f16066a[this.j.ordinal()];
            if (i == 1) {
                this.f16060c.start();
                this.j = PlayerState.STARTED;
                OnVideoStartedListener onVideoStartedListener = this.d;
                if (onVideoStartedListener != null) {
                    onVideoStartedListener.a();
                }
            } else if (i == 2) {
                this.f16060c.start();
                this.j = PlayerState.STARTED;
            } else if (i != 3) {
            } else {
                a(new MediaPlayer.OnPreparedListener() { // from class: com.blued.android.module.video_gift.AlphaMovieView.5
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        AlphaMovieView.this.f16060c.start();
                        AlphaMovieView.this.j = PlayerState.STARTED;
                        if (AlphaMovieView.this.d != null) {
                            AlphaMovieView.this.d.a();
                        }
                    }
                });
            }
        }
    }

    public void d() {
        if (this.f16060c == null || this.j != PlayerState.STARTED) {
            return;
        }
        this.f16060c.pause();
        this.j = PlayerState.PAUSED;
    }

    public void e() {
        if (this.f16060c != null) {
            if (this.j == PlayerState.STARTED || this.j == PlayerState.PAUSED) {
                this.f16060c.stop();
                this.j = PlayerState.STOPPED;
            }
        }
    }

    public void f() {
        if (this.f16060c != null) {
            if (this.j == PlayerState.STARTED || this.j == PlayerState.PAUSED || this.j == PlayerState.STOPPED) {
                this.f16060c.reset();
                this.j = PlayerState.NOT_PREPARED;
            }
        }
    }

    public void g() {
        if (this.f16060c != null) {
            this.b.release();
            this.f16060c.release();
            this.j = PlayerState.RELEASE;
        }
    }

    public int getCurrentPosition() {
        return this.f16060c.getCurrentPosition();
    }

    public MediaPlayer getMediaPlayer() {
        return this.f16060c;
    }

    public PlayerState getState() {
        return this.j;
    }

    public boolean h() {
        return this.j == PlayerState.PAUSED;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (this.i == null) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        this.i.a(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.i.a(), mode), View.MeasureSpec.makeMeasureSpec(this.i.b(), mode2));
    }

    public void setLooping(boolean z) {
        this.f16060c.setLooping(z);
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.f16060c.setOnErrorListener(onErrorListener);
    }

    public void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.f16060c.setOnSeekCompleteListener(onSeekCompleteListener);
    }

    public void setOnVideoEndedListener(OnVideoEndedListener onVideoEndedListener) {
        this.e = onVideoEndedListener;
    }

    public void setOnVideoErrorListener(OnVideoErrorListener onVideoErrorListener) {
        this.f = onVideoErrorListener;
    }

    public void setOnVideoStartedListener(OnVideoStartedListener onVideoStartedListener) {
        this.d = onVideoStartedListener;
    }

    public void setScaleType(FitViewHelper.ScaleType scaleType) {
        FitViewHelper fitViewHelper = this.i;
        if (fitViewHelper != null) {
            fitViewHelper.a(scaleType);
            i();
        }
    }

    public void setScreenOnWhilePlaying(boolean z) {
        this.f16060c.setScreenOnWhilePlaying(z);
    }

    public void setVideoByUrl(String str) {
        f();
        try {
            this.f16060c.setDataSource(str);
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str, new HashMap());
            a(mediaMetadataRetriever);
        } catch (Exception e) {
            Log.e("VideoSurfaceView", e.getMessage(), e);
            o();
        }
    }

    public void setVideoFromAssets(String str) {
        f();
        try {
            AssetFileDescriptor openFd = getContext().getAssets().openFd(str);
            this.f16060c.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
            a(mediaMetadataRetriever);
        } catch (Exception e) {
            Log.e("VideoSurfaceView", e.getMessage(), e);
            o();
        }
    }

    public void setVideoFromFile(FileDescriptor fileDescriptor) {
        f();
        try {
            this.f16060c.setDataSource(fileDescriptor);
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(fileDescriptor);
            a(mediaMetadataRetriever);
        } catch (Exception e) {
            Log.e("VideoSurfaceView", e.getMessage(), e);
            o();
        }
    }

    public void setVideoFromMediaDataSource(MediaDataSource mediaDataSource) {
        f();
        this.f16060c.setDataSource(mediaDataSource);
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(mediaDataSource);
        a(mediaMetadataRetriever);
    }
}

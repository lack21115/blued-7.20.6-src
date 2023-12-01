package com.soft.blued.ui.video;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.soft.blued.utils.Logger;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/video/SurfaceVideoView.class */
public class SurfaceVideoView extends SurfaceView implements SurfaceHolder.Callback {

    /* renamed from: a  reason: collision with root package name */
    MediaState f20754a;
    OnStateChangeListener b;

    /* renamed from: c  reason: collision with root package name */
    private MediaPlayer f20755c;
    private Context d;
    private int e;
    private int f;
    private int g;
    private int h;
    private MediaPlayer.OnInfoListener i;
    private MediaPlayer.OnBufferingUpdateListener j;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/video/SurfaceVideoView$MediaState.class */
    public enum MediaState {
        INIT,
        PREPARING,
        PLAYING,
        PAUSE,
        RELEASE
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/video/SurfaceVideoView$OnStateChangeListener.class */
    public interface OnStateChangeListener {
        void a();

        void a(int i, int i2);

        void b();

        void c();

        void d();

        void e();
    }

    public SurfaceVideoView(Context context) {
        super(context);
        this.i = new MediaPlayer.OnInfoListener() { // from class: com.soft.blued.ui.video.SurfaceVideoView.1
            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                Logger.a("dddrb", "onInfo what = ", Integer.valueOf(i));
                if (SurfaceVideoView.this.b != null) {
                    SurfaceVideoView.this.b.b();
                    if (i == 701) {
                        SurfaceVideoView.this.b.c();
                        return false;
                    } else if (i == 702) {
                        SurfaceVideoView.this.b.b();
                        return false;
                    } else {
                        return false;
                    }
                }
                return false;
            }
        };
        this.j = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.soft.blued.ui.video.SurfaceVideoView.2
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                Logger.a("ddrb", "onBufferingUpdate", Integer.valueOf(i));
                if (SurfaceVideoView.this.b == null || SurfaceVideoView.this.f20754a != MediaState.PLAYING) {
                    return;
                }
                SurfaceVideoView.this.b.a(SurfaceVideoView.this.f20755c.getDuration(), SurfaceVideoView.this.f20755c.getCurrentPosition());
            }
        };
        this.d = context;
        a();
        Logger.a("dddrb", "Context context");
    }

    public SurfaceVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = new MediaPlayer.OnInfoListener() { // from class: com.soft.blued.ui.video.SurfaceVideoView.1
            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                Logger.a("dddrb", "onInfo what = ", Integer.valueOf(i));
                if (SurfaceVideoView.this.b != null) {
                    SurfaceVideoView.this.b.b();
                    if (i == 701) {
                        SurfaceVideoView.this.b.c();
                        return false;
                    } else if (i == 702) {
                        SurfaceVideoView.this.b.b();
                        return false;
                    } else {
                        return false;
                    }
                }
                return false;
            }
        };
        this.j = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.soft.blued.ui.video.SurfaceVideoView.2
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                Logger.a("ddrb", "onBufferingUpdate", Integer.valueOf(i));
                if (SurfaceVideoView.this.b == null || SurfaceVideoView.this.f20754a != MediaState.PLAYING) {
                    return;
                }
                SurfaceVideoView.this.b.a(SurfaceVideoView.this.f20755c.getDuration(), SurfaceVideoView.this.f20755c.getCurrentPosition());
            }
        };
        this.d = context;
        a();
        Logger.a("dddrb", "Context context, AttributeSet attrs");
    }

    private void c() {
        synchronized (this) {
            if (this.e != 0 && this.f != 0 && this.g != 0 && this.h != 0) {
                float min = Math.min(this.e / this.g, this.f / this.h);
                Logger.b("SurfaceVideoView", "resetViewSize before data: mVideoWidth:", Integer.valueOf(this.e), "   mVideoHeight:", Integer.valueOf(this.f), "   mSurfaceWidth:", Integer.valueOf(this.g), "   mSurfaceHeight:", Integer.valueOf(this.h));
                Logger.b("SurfaceVideoView", "====ratio:", Float.valueOf(min));
                this.g = (int) Math.ceil(this.e / min);
                this.h = (int) Math.ceil(this.f / min);
            }
            Logger.b("SurfaceVideoView", "resetViewSize after data: mVideoWidth:", Integer.valueOf(this.e), "   mVideoHeight:", Integer.valueOf(this.f), "   mSurfaceWidth:", Integer.valueOf(this.g), "   mSurfaceHeight:", Integer.valueOf(this.h));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        synchronized (this) {
            if (this.e != 0 && this.f != 0 && this.g != 0) {
                float f = this.g / this.e;
                Logger.b("SurfaceVideoView", "fillWidth before data: mVideoWidth:", Integer.valueOf(this.e), "   mVideoHeight:", Integer.valueOf(this.f), " mSurfaceWidth:", Integer.valueOf(this.g), "   mSurfaceHeight:", Integer.valueOf(this.h), "   ratioW:", Float.valueOf(f));
                float f2 = this.f * f;
                Logger.b("SurfaceVideoView", "to fill width to get height:", Float.valueOf(f2));
                if (this.h - f2 <= 0.0f || f2 / this.h < 0.8d) {
                    this.h = (int) f2;
                    Logger.b("SurfaceVideoView", "only fill width");
                    Logger.b("SurfaceVideoView", "fillWidth after data: mVideoWidth:", Integer.valueOf(this.e), "   mVideoHeight:", Integer.valueOf(this.f), " mSurfaceWidth:", Integer.valueOf(this.g), "   mSurfaceHeight:", Integer.valueOf(this.h));
                } else {
                    this.g = LiveFloatManager.a().E();
                    this.h = LiveFloatManager.a().F();
                    Logger.b("SurfaceVideoView", "go to fill screen");
                    c();
                }
            }
        }
    }

    public void a() {
        this.g = LiveFloatManager.a().E();
        this.h = LiveFloatManager.a().F();
        getHolder().addCallback(this);
        getHolder().setType(3);
    }

    public void a(String str, boolean z) {
        if (this.f20754a == MediaState.PREPARING) {
            b();
            return;
        }
        try {
            this.f20755c.reset();
            this.f20755c.setLooping(z);
            this.f20755c.setDataSource(str);
            this.f20755c.prepareAsync();
            this.f20754a = MediaState.PREPARING;
        } catch (Exception e) {
            Logger.a("ddrb", "e = ", e, "mediaPlayer = ", this.f20755c);
            e.printStackTrace();
            OnStateChangeListener onStateChangeListener = this.b;
            if (onStateChangeListener != null) {
                onStateChangeListener.e();
            }
        }
    }

    public void b() {
        ThreadManager.a().a(new ThreadExecutor("SurfaceVideoStop") { // from class: com.soft.blued.ui.video.SurfaceVideoView.3
            public void execute() {
                try {
                    try {
                    } catch (Exception e) {
                        SurfaceVideoView.this.f20754a = MediaState.INIT;
                        if (SurfaceVideoView.this.b == null) {
                            return;
                        }
                    }
                    if (SurfaceVideoView.this.f20754a == MediaState.INIT) {
                        if (SurfaceVideoView.this.b != null) {
                            SurfaceVideoView.this.b.d();
                        }
                    } else if (SurfaceVideoView.this.f20754a == MediaState.PREPARING) {
                        SurfaceVideoView.this.f20755c.reset();
                        SurfaceVideoView.this.f20754a = MediaState.INIT;
                        System.out.println("prepare->reset");
                        if (SurfaceVideoView.this.b != null) {
                            SurfaceVideoView.this.b.d();
                        }
                    } else if (SurfaceVideoView.this.f20754a == MediaState.PAUSE) {
                        SurfaceVideoView.this.f20755c.stop();
                        SurfaceVideoView.this.f20755c.reset();
                        SurfaceVideoView.this.f20754a = MediaState.INIT;
                        System.out.println("pause->init");
                        if (SurfaceVideoView.this.b != null) {
                            SurfaceVideoView.this.b.d();
                        }
                    } else if (SurfaceVideoView.this.f20754a != MediaState.PLAYING) {
                        if (SurfaceVideoView.this.b == null) {
                            return;
                        }
                        SurfaceVideoView.this.b.d();
                    } else {
                        SurfaceVideoView.this.f20755c.pause();
                        SurfaceVideoView.this.f20755c.stop();
                        SurfaceVideoView.this.f20755c.reset();
                        SurfaceVideoView.this.f20754a = MediaState.INIT;
                        System.out.println("playing->init");
                        if (SurfaceVideoView.this.b != null) {
                            SurfaceVideoView.this.b.d();
                        }
                    }
                } catch (Throwable th) {
                    if (SurfaceVideoView.this.b != null) {
                        SurfaceVideoView.this.b.d();
                    }
                    throw th;
                }
            }
        });
    }

    public MediaPlayer getMediaPlayer() {
        return this.f20755c;
    }

    public MediaState getState() {
        return this.f20754a;
    }

    public void setOnStateChangeListener(OnStateChangeListener onStateChangeListener) {
        this.b = onStateChangeListener;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (this.f20755c == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f20755c = mediaPlayer;
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.soft.blued.ui.video.SurfaceVideoView.4
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer2) {
                    mediaPlayer2.start();
                    SurfaceVideoView.this.f20754a = MediaState.PLAYING;
                    Logger.a("ddrb", "start");
                    if (SurfaceVideoView.this.b != null) {
                        SurfaceVideoView.this.b.b();
                    }
                }
            });
            this.f20755c.setOnInfoListener(this.i);
            Logger.a("dddrb", "setOnInfoListener");
            this.f20755c.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.soft.blued.ui.video.SurfaceVideoView.5
                @Override // android.media.MediaPlayer.OnErrorListener
                public boolean onError(MediaPlayer mediaPlayer2, int i, int i2) {
                    mediaPlayer2.release();
                    SurfaceVideoView.this.f20754a = MediaState.INIT;
                    if (SurfaceVideoView.this.b != null) {
                        SurfaceVideoView.this.b.e();
                        return false;
                    }
                    return false;
                }
            });
            this.f20755c.setOnBufferingUpdateListener(this.j);
            this.f20755c.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.soft.blued.ui.video.SurfaceVideoView.6
                @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
                public void onVideoSizeChanged(MediaPlayer mediaPlayer2, int i, int i2) {
                    SurfaceVideoView.this.e = i;
                    SurfaceVideoView.this.f = i2;
                    SurfaceVideoView.this.d();
                    if (SurfaceVideoView.this.e == 0 || SurfaceVideoView.this.f == 0 || SurfaceVideoView.this.g == 0 || SurfaceVideoView.this.h == 0) {
                        return;
                    }
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(SurfaceVideoView.this.g, SurfaceVideoView.this.h);
                    layoutParams.gravity = 17;
                    SurfaceVideoView.this.setLayoutParams(layoutParams);
                }
            });
        }
        this.f20755c.setDisplay(surfaceHolder);
        this.f20754a = MediaState.INIT;
        Logger.a("dddrb", "setDisplay");
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        OnStateChangeListener onStateChangeListener = this.b;
        if (onStateChangeListener != null) {
            onStateChangeListener.a();
        }
    }
}

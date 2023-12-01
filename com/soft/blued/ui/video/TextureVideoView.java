package com.soft.blued.ui.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.soft.blued.utils.Logger;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/video/TextureVideoView.class */
public class TextureVideoView extends TextureView implements TextureView.SurfaceTextureListener {

    /* renamed from: a  reason: collision with root package name */
    MediaState f34455a;
    OnStateChangeListener b;

    /* renamed from: c  reason: collision with root package name */
    private MediaPlayer f34456c;
    private Context d;
    private MediaPlayer.OnInfoListener e;
    private MediaPlayer.OnBufferingUpdateListener f;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/video/TextureVideoView$MediaState.class */
    public enum MediaState {
        INIT,
        PREPARING,
        PLAYING,
        PAUSE,
        RELEASE
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/video/TextureVideoView$OnStateChangeListener.class */
    public interface OnStateChangeListener {
        void a();

        void a(int i, int i2);

        void b();

        void c();

        void d();

        void e();
    }

    public TextureVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = new MediaPlayer.OnInfoListener() { // from class: com.soft.blued.ui.video.TextureVideoView.1
            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                Logger.a("ddrb", "onInfo");
                if (TextureVideoView.this.b != null) {
                    TextureVideoView.this.b.b();
                    if (i == 701) {
                        TextureVideoView.this.b.c();
                        return false;
                    } else if (i == 702) {
                        TextureVideoView.this.b.b();
                        return false;
                    } else {
                        return false;
                    }
                }
                return false;
            }
        };
        this.f = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.soft.blued.ui.video.TextureVideoView.2
            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                Logger.a("ddrb", "onBufferingUpdate");
                if (TextureVideoView.this.b == null || TextureVideoView.this.f34455a != MediaState.PLAYING || TextureVideoView.this.f34456c == null) {
                    return;
                }
                TextureVideoView.this.b.a(TextureVideoView.this.f34456c.getDuration(), TextureVideoView.this.f34456c.getCurrentPosition());
            }
        };
        this.d = context;
        a();
    }

    public void a() {
        setSurfaceTextureListener(this);
    }

    public void a(String str) {
        if (this.f34455a == MediaState.PREPARING) {
            b();
            return;
        }
        MediaPlayer mediaPlayer = this.f34456c;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.reset();
        this.f34456c.setLooping(true);
        try {
            this.f34456c.setDataSource(str);
            this.f34456c.prepareAsync();
            this.f34455a = MediaState.PREPARING;
        } catch (Exception e) {
            e.printStackTrace();
            if (this.b != null) {
                Logger.a("ddrb", "play =", e);
                this.b.e();
            }
        }
        Logger.a("ddrb", "play end");
    }

    public void b() {
        if (this.f34456c == null) {
            return;
        }
        ThreadManager.a().a(new ThreadExecutor("TextureVideoStop") { // from class: com.soft.blued.ui.video.TextureVideoView.5
            @Override // com.blued.android.framework.pool.ThreadExecutor
            public void execute() {
                try {
                    try {
                    } catch (Exception e) {
                        TextureVideoView.this.f34456c.reset();
                        TextureVideoView.this.f34455a = MediaState.INIT;
                        if (TextureVideoView.this.b == null) {
                            return;
                        }
                    }
                    if (TextureVideoView.this.f34455a == MediaState.INIT) {
                        if (TextureVideoView.this.b != null) {
                            TextureVideoView.this.b.d();
                        }
                    } else if (TextureVideoView.this.f34455a == MediaState.PREPARING) {
                        TextureVideoView.this.f34456c.reset();
                        TextureVideoView.this.f34455a = MediaState.INIT;
                        System.out.println("prepare->reset");
                        if (TextureVideoView.this.b != null) {
                            TextureVideoView.this.b.d();
                        }
                    } else if (TextureVideoView.this.f34455a == MediaState.PAUSE) {
                        TextureVideoView.this.f34456c.stop();
                        TextureVideoView.this.f34456c.reset();
                        TextureVideoView.this.f34455a = MediaState.INIT;
                        System.out.println("pause->init");
                        if (TextureVideoView.this.b != null) {
                            TextureVideoView.this.b.d();
                        }
                    } else if (TextureVideoView.this.f34455a != MediaState.PLAYING) {
                        if (TextureVideoView.this.b == null) {
                            return;
                        }
                        TextureVideoView.this.b.d();
                    } else {
                        TextureVideoView.this.f34456c.pause();
                        TextureVideoView.this.f34456c.stop();
                        TextureVideoView.this.f34456c.reset();
                        TextureVideoView.this.f34455a = MediaState.INIT;
                        System.out.println("playing->init");
                        if (TextureVideoView.this.b != null) {
                            TextureVideoView.this.b.d();
                        }
                    }
                } catch (Throwable th) {
                    if (TextureVideoView.this.b != null) {
                        TextureVideoView.this.b.d();
                    }
                    throw th;
                }
            }
        });
    }

    public MediaPlayer getMediaPlayer() {
        return this.f34456c;
    }

    public MediaState getState() {
        return this.f34455a;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Surface surface = new Surface(surfaceTexture);
        if (this.f34456c == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f34456c = mediaPlayer;
            mediaPlayer.setVolume(0.0f, 0.0f);
        }
        this.f34456c.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.soft.blued.ui.video.TextureVideoView.3
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer2) {
                mediaPlayer2.start();
                TextureVideoView.this.f34455a = MediaState.PLAYING;
                AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.video.TextureVideoView.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (TextureVideoView.this.b != null) {
                            TextureVideoView.this.b.b();
                        }
                    }
                }, 300L);
            }
        });
        this.f34456c.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.soft.blued.ui.video.TextureVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer2, int i3, int i4) {
                TextureVideoView.this.f34455a = MediaState.INIT;
                if (TextureVideoView.this.b != null) {
                    TextureVideoView.this.b.e();
                    return false;
                }
                return false;
            }
        });
        this.f34456c.setOnInfoListener(this.e);
        this.f34456c.setOnBufferingUpdateListener(this.f);
        this.f34456c.setSurface(surface);
        this.f34455a = MediaState.INIT;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        OnStateChangeListener onStateChangeListener = this.b;
        if (onStateChangeListener != null) {
            onStateChangeListener.a();
            return false;
        }
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void setOnStateChangeListener(OnStateChangeListener onStateChangeListener) {
        this.b = onStateChangeListener;
    }
}

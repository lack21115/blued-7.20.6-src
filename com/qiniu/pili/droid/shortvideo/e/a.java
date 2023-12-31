package com.qiniu.pili.droid.shortvideo.e;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.transcoder.audio.d;
import java.io.IOException;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/e/a.class */
public class a implements MediaPlayer.OnCompletionListener {

    /* renamed from: a  reason: collision with root package name */
    private MediaPlayer f13949a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private AssetFileDescriptor f13950c;
    private Handler g;
    private boolean d = true;
    private d e = new d(0, 0);
    private boolean f = false;
    private float h = 1.0f;

    private void h() {
        Handler handler = this.g;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.g = null;
        }
    }

    private void i() {
        long b = this.e.b();
        if (b > 0) {
            if (b > this.f13949a.getDuration()) {
                h();
                return;
            }
            Handler handler = this.g;
            if (handler == null) {
                this.g = new Handler();
            } else {
                handler.removeCallbacksAndMessages(null);
            }
            this.g.postDelayed(new Runnable() { // from class: com.qiniu.pili.droid.shortvideo.e.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!a.this.d) {
                        a.this.e();
                        return;
                    }
                    a aVar = a.this;
                    aVar.a(aVar.e.a());
                }
            }, this.e.c());
        }
    }

    private void j() {
        if (this.f13949a != null) {
            e.k.d("AudioPlayer", "media player already inited");
            return;
        }
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.f13949a = mediaPlayer;
        mediaPlayer.setOnCompletionListener(this);
        try {
            if (!g()) {
                this.f13949a.setDataSource(this.b);
            } else if (this.f13950c.getDeclaredLength() < 0) {
                this.f13949a.setDataSource(this.f13950c.getFileDescriptor());
            } else {
                this.f13949a.setDataSource(this.f13950c.getFileDescriptor(), this.f13950c.getStartOffset(), this.f13950c.getLength());
            }
            this.f13949a.prepare();
            this.f13949a.setVolume(this.h, this.h);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int a() {
        MediaPlayer mediaPlayer = this.f13949a;
        if (mediaPlayer == null) {
            e.k.d("AudioPlayer", "not playing !");
            return -1;
        }
        int duration = mediaPlayer.getDuration();
        e eVar = e.k;
        eVar.b("AudioPlayer", "duration: " + duration);
        return duration;
    }

    public void a(float f) {
        MediaPlayer mediaPlayer = this.f13949a;
        if (mediaPlayer == null) {
            e.k.d("AudioPlayer", "not playing !");
            return;
        }
        this.h = f;
        mediaPlayer.setVolume(f, f);
        e eVar = e.k;
        eVar.b("AudioPlayer", "set volume: " + f);
    }

    public void a(long j) {
        e.k.c("AudioPlayer", "seekTo +");
        if (this.f13949a == null) {
            e.k.d("AudioPlayer", "not playing !");
            return;
        }
        if (Build.VERSION.SDK_INT < 26) {
            this.f13949a.seekTo((int) j);
        } else {
            this.f13949a.seekTo((int) j, 3);
        }
        if (!this.f) {
            i();
        }
        e eVar = e.k;
        eVar.c("AudioPlayer", "seekTo: " + j);
    }

    public void a(AssetFileDescriptor assetFileDescriptor) {
        this.f13950c = assetFileDescriptor;
        this.b = null;
        j();
    }

    public void a(d dVar) {
        this.e = dVar;
        MediaPlayer mediaPlayer = this.f13949a;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        i();
    }

    public void a(String str) {
        this.b = str;
        this.f13950c = null;
        j();
    }

    public void a(boolean z) {
        this.d = z;
    }

    public void b() {
        this.f = false;
        j();
        this.f13949a.start();
        a(this.e.a());
    }

    public boolean c() {
        MediaPlayer mediaPlayer = this.f13949a;
        if (mediaPlayer != null) {
            return mediaPlayer.isPlaying();
        }
        return false;
    }

    public void d() {
        e.k.c("AudioPlayer", "stop +");
        h();
        MediaPlayer mediaPlayer = this.f13949a;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.stop();
        this.f13949a.release();
        this.f13949a = null;
        e.k.c("AudioPlayer", "stop -");
    }

    public void e() {
        e.k.c("AudioPlayer", "pause +");
        MediaPlayer mediaPlayer = this.f13949a;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            e.k.d("AudioPlayer", "not playing !");
            return;
        }
        this.f13949a.pause();
        this.f = true;
        e.k.c("AudioPlayer", "pause -");
    }

    public void f() {
        e.k.c("AudioPlayer", "resume +");
        MediaPlayer mediaPlayer = this.f13949a;
        if (mediaPlayer == null || mediaPlayer.isPlaying()) {
            e.k.d("AudioPlayer", "not in pause state !");
            return;
        }
        this.f13949a.start();
        this.f = false;
        h();
        e.k.c("AudioPlayer", "resume -");
    }

    public boolean g() {
        return this.f13950c != null;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        if (!this.d) {
            this.f = true;
        } else if (this.f) {
        } else {
            this.f13949a.start();
            if (Build.VERSION.SDK_INT < 26) {
                this.f13949a.seekTo((int) this.e.a());
            } else {
                this.f13949a.seekTo((int) this.e.a(), 3);
            }
        }
    }
}

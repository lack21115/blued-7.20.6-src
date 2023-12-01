package com.blued.android.module.live_china.view;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.player.live.manager.LiveMediaPlayerManager;
import com.blued.android.module.player.live.manager.OnMediaPlayerListener;
import com.blued.android.module.player.txplayer.view.BlLiveView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveAutoPlayer.class */
public class LiveAutoPlayer {
    private String a;
    private BlLiveView c;
    private LiveAutoPlayerListener d;
    private OnMediaPlayerListener e = new OnMediaPlayerListener() { // from class: com.blued.android.module.live_china.view.LiveAutoPlayer.1
        @Override // com.blued.android.module.player.live.manager.OnMediaPlayerListener
        public void a() {
            Logger.c("LiveAutoPlayer", "onMediaBufferStart");
            if (LiveAutoPlayer.this.d != null) {
                LiveAutoPlayer.this.d.a();
            }
        }

        @Override // com.blued.android.module.player.live.manager.OnMediaPlayerListener
        public void a(int i, int i2) {
            Logger.b("LiveAutoPlayer", "onSizeChange: w = " + i + ", h = " + i2);
            if (LiveAutoPlayer.this.d != null) {
                LiveAutoPlayer.this.d.a(i, i2);
            }
        }

        @Override // com.blued.android.module.player.live.manager.OnMediaPlayerListener
        public void a(Bitmap bitmap) {
            if (LiveAutoPlayer.this.d != null) {
                LiveAutoPlayer.this.d.a(bitmap);
            }
        }

        @Override // com.blued.android.module.player.live.manager.OnMediaPlayerListener
        public void b() {
            Logger.c("LiveAutoPlayer", "onMediaBufferEnd");
            if (LiveAutoPlayer.this.d != null) {
                LiveAutoPlayer.this.d.b();
            }
        }

        @Override // com.blued.android.module.player.live.manager.OnMediaPlayerListener
        public void c() {
            Logger.b("LiveAutoPlayer", "onMediaVideoStart");
            if (LiveAutoPlayer.this.d != null) {
                LiveAutoPlayer.this.d.c();
            }
        }

        @Override // com.blued.android.module.player.live.manager.OnMediaPlayerListener
        public void d() {
            if (LiveAutoPlayer.this.d != null) {
                LiveAutoPlayer.this.d.d();
            }
        }

        @Override // com.blued.android.module.player.live.manager.OnMediaPlayerListener
        public void e() {
            Logger.b("LiveAutoPlayer", "onCompletion");
            if (LiveAutoPlayer.this.d != null) {
                LiveAutoPlayer.this.d.e();
            }
        }
    };
    private LiveMediaPlayerManager b = new LiveMediaPlayerManager();

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveAutoPlayer$LiveAutoPlayerListener.class */
    public interface LiveAutoPlayerListener {
        void a();

        void a(int i, int i2);

        void a(Bitmap bitmap);

        void b();

        void c();

        void d();

        void e();
    }

    public void a(LiveAutoPlayerListener liveAutoPlayerListener) {
        this.d = liveAutoPlayerListener;
    }

    public void a(String str, BlLiveView blLiveView) {
        if (TextUtils.isEmpty(str)) {
            Logger.b("LiveAutoPlayer", "prepare discard, mVideoPath is empty");
        } else if (blLiveView == null) {
            Logger.b("LiveAutoPlayer", "prepare discard, mPlayView is null");
        } else {
            Logger.b("LiveAutoPlayer", "prepare mVideoPath = ", str);
            this.a = str;
            this.c = blLiveView;
            if (!a()) {
                this.b = new LiveMediaPlayerManager();
            }
            try {
                Logger.b("LiveAutoPlayer", "prepare play");
                this.c.a();
                this.b.a(this.a, this.c);
                this.b.a(this.e);
                this.b.f();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean a() {
        return this.b != null;
    }

    public boolean b() {
        LiveMediaPlayerManager liveMediaPlayerManager = this.b;
        return liveMediaPlayerManager != null && liveMediaPlayerManager.a();
    }

    public void c() {
        if (a()) {
            Logger.b("LiveAutoPlayer", "start");
            this.b.c();
        }
    }

    public void d() {
        if (a()) {
            this.b.d();
        }
    }

    public void e() {
        if (a() && this.b.a()) {
            try {
                this.b.b();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void f() {
        if (a()) {
            Logger.b("LiveAutoPlayer", "release player");
            this.b.d();
            this.b.h();
            this.b = null;
        }
    }
}

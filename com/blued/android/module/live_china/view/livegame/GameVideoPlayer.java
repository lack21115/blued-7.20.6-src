package com.blued.android.module.live_china.view.livegame;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.Log;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.player.live.view.AbsVideoView;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayer;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/livegame/GameVideoPlayer.class */
public class GameVideoPlayer extends AbsVideoView {
    private static final String a = GameVideoPlayer.class.getSimpleName();
    private SurfaceView b;
    private Surface c;
    private TXLivePlayer d;
    private int e;
    private String f;
    private int g;
    private int h;
    private int i;
    private int j;
    private SurfaceHolder.Callback k;
    private ITXLivePlayListener l;

    public GameVideoPlayer(Context context) {
        super(context);
        this.e = 1;
        this.k = new SurfaceHolder.Callback() { // from class: com.blued.android.module.live_china.view.livegame.GameVideoPlayer.1
            int a;
            int b;

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                String str = GameVideoPlayer.a;
                Log.c(str, "surfaceChanged mSurfaceHeight" + GameVideoPlayer.this.h + "mSurfaceWidth " + GameVideoPlayer.this.g);
                if (this.b == i3 && this.a == i2) {
                    return;
                }
                GameVideoPlayer.this.d.setSurfaceSize(GameVideoPlayer.this.g, GameVideoPlayer.this.h);
                GameVideoPlayer.this.d.setSurface(GameVideoPlayer.this.c);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                GameVideoPlayer.this.c = surfaceHolder.getSurface();
                this.a = GameVideoPlayer.this.g;
                this.b = GameVideoPlayer.this.h;
                GameVideoPlayer.this.d.setSurface(GameVideoPlayer.this.c);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                if (GameVideoPlayer.this.c != null) {
                    GameVideoPlayer.this.c.release();
                }
            }
        };
        this.l = new ITXLivePlayListener() { // from class: com.blued.android.module.live_china.view.livegame.GameVideoPlayer.2
            public void onNetStatus(Bundle bundle) {
            }

            /* JADX WARN: Removed duplicated region for block: B:21:0x00ed  */
            /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onPlayEvent(int r5, android.os.Bundle r6) {
                /*
                    Method dump skipped, instructions count: 246
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.view.livegame.GameVideoPlayer.AnonymousClass2.onPlayEvent(int, android.os.Bundle):void");
            }
        };
        a(context);
    }

    public GameVideoPlayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = 1;
        this.k = new SurfaceHolder.Callback() { // from class: com.blued.android.module.live_china.view.livegame.GameVideoPlayer.1
            int a;
            int b;

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                String str = GameVideoPlayer.a;
                Log.c(str, "surfaceChanged mSurfaceHeight" + GameVideoPlayer.this.h + "mSurfaceWidth " + GameVideoPlayer.this.g);
                if (this.b == i3 && this.a == i2) {
                    return;
                }
                GameVideoPlayer.this.d.setSurfaceSize(GameVideoPlayer.this.g, GameVideoPlayer.this.h);
                GameVideoPlayer.this.d.setSurface(GameVideoPlayer.this.c);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                GameVideoPlayer.this.c = surfaceHolder.getSurface();
                this.a = GameVideoPlayer.this.g;
                this.b = GameVideoPlayer.this.h;
                GameVideoPlayer.this.d.setSurface(GameVideoPlayer.this.c);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                if (GameVideoPlayer.this.c != null) {
                    GameVideoPlayer.this.c.release();
                }
            }
        };
        this.l = new ITXLivePlayListener() { // from class: com.blued.android.module.live_china.view.livegame.GameVideoPlayer.2
            public void onNetStatus(Bundle bundle) {
            }

            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onPlayEvent(int r5, android.os.Bundle r6) {
                /*
                    Method dump skipped, instructions count: 246
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.view.livegame.GameVideoPlayer.AnonymousClass2.onPlayEvent(int, android.os.Bundle):void");
            }
        };
        a(context);
    }

    public GameVideoPlayer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = 1;
        this.k = new SurfaceHolder.Callback() { // from class: com.blued.android.module.live_china.view.livegame.GameVideoPlayer.1
            int a;
            int b;

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i22, int i3) {
                String str = GameVideoPlayer.a;
                Log.c(str, "surfaceChanged mSurfaceHeight" + GameVideoPlayer.this.h + "mSurfaceWidth " + GameVideoPlayer.this.g);
                if (this.b == i3 && this.a == i22) {
                    return;
                }
                GameVideoPlayer.this.d.setSurfaceSize(GameVideoPlayer.this.g, GameVideoPlayer.this.h);
                GameVideoPlayer.this.d.setSurface(GameVideoPlayer.this.c);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                GameVideoPlayer.this.c = surfaceHolder.getSurface();
                this.a = GameVideoPlayer.this.g;
                this.b = GameVideoPlayer.this.h;
                GameVideoPlayer.this.d.setSurface(GameVideoPlayer.this.c);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                if (GameVideoPlayer.this.c != null) {
                    GameVideoPlayer.this.c.release();
                }
            }
        };
        this.l = new ITXLivePlayListener() { // from class: com.blued.android.module.live_china.view.livegame.GameVideoPlayer.2
            public void onNetStatus(Bundle bundle) {
            }

            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onPlayEvent(int r5, android.os.Bundle r6) {
                /*
                    Method dump skipped, instructions count: 246
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.view.livegame.GameVideoPlayer.AnonymousClass2.onPlayEvent(int, android.os.Bundle):void");
            }
        };
        a(context);
    }

    private void a(Context context) {
        this.b = new SurfaceView(context);
        this.b.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.b);
        this.b.getHolder().addCallback(this.k);
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str) || !(str.startsWith("http://") || str.startsWith("https://") || str.startsWith("rtmp://") || str.startsWith(BridgeUtil.SPLIT_MARK))) {
            Log.c(a, "url is invalid");
            return false;
        }
        if (str.startsWith("rtmp://")) {
            this.e = 0;
        } else if ((!str.startsWith("http://") && !str.startsWith("https://")) || !str.contains(".flv")) {
            Log.c(a, "url is invalide");
            return false;
        } else {
            this.e = 1;
        }
        this.f = str;
        return true;
    }

    private void f() {
        if (this.d == null) {
            TXLivePlayer tXLivePlayer = new TXLivePlayer(AppInfo.d());
            this.d = tXLivePlayer;
            tXLivePlayer.enableHardwareDecode(false);
        }
        this.g = AppInfo.m;
        this.h = AppInfo.l;
        g();
        this.d.setSurface(this.c);
        this.d.setSurfaceSize(this.g, this.h);
        this.d.setPlayListener(this.l);
    }

    private void g() {
        synchronized (this) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(this.g, this.h);
            } else {
                layoutParams.width = this.g;
                layoutParams.height = this.h;
            }
            if (GameVideoView.a == 0) {
                layoutParams.gravity = 17;
            } else if (GameVideoView.b) {
                layoutParams.gravity = 17;
            } else {
                layoutParams.gravity = 48;
            }
            this.b.setLayoutParams(layoutParams);
        }
    }

    @Override // com.blued.android.module.player.live.view.AbsVideoView
    public void a() {
        if (TextUtils.isEmpty(this.f)) {
            return;
        }
        this.d.startPlay(this.f, this.e);
    }

    @Override // com.blued.android.module.player.live.view.AbsVideoView
    public void a(int i, int i2) {
        this.g = i;
        this.h = i2;
        String str = a;
        Log.a(str, "setSurfaceWidthHeight width = " + i + " -- height = " + i2);
        d();
    }

    @Override // com.blued.android.module.player.live.view.AbsVideoView
    public void a(View view) {
        f();
    }

    @Override // com.blued.android.module.player.live.view.AbsVideoView
    public void b() {
        TXLivePlayer tXLivePlayer = this.d;
        if (tXLivePlayer != null) {
            tXLivePlayer.pause();
        }
    }

    @Override // com.blued.android.module.player.live.view.AbsVideoView
    public void c() {
        TXLivePlayer tXLivePlayer = this.d;
        if (tXLivePlayer != null) {
            tXLivePlayer.setPlayListener((ITXLivePlayListener) null);
            this.d.stopPlay(true);
        }
        Surface surface = this.c;
        if (surface != null) {
            surface.release();
        }
        this.d = null;
    }

    @Override // com.blued.android.module.player.live.view.AbsVideoView
    public void d() {
        float f;
        synchronized (this) {
            if (this.i != 0 && this.j != 0 && this.g != 0 && this.h != 0) {
                float f2 = this.i / this.g;
                float f3 = this.j / this.h;
                if (GameVideoView.a == 0) {
                    f = Math.min(f2, f3);
                } else {
                    f = f2;
                    if (GameVideoView.b) {
                        f = Math.max(f2, f3);
                    }
                }
                String str = a;
                Log.c(str, "before data: mVideoWidth:" + this.i + "   mVideoHeight:" + this.j + " mSurfaceWidth:" + this.g + "   mSurfaceHeight:" + this.h);
                String str2 = a;
                StringBuilder sb = new StringBuilder();
                sb.append("====ratio:");
                sb.append(f);
                Log.c(str2, sb.toString());
                this.g = (int) Math.ceil((double) (((float) this.i) / f));
                this.h = (int) Math.ceil((double) (((float) this.j) / f));
            }
            String str3 = a;
            Log.c(str3, "after data: mVideoWidth:" + this.i + "   mVideoHeight:" + this.j + " mSurfaceWidth:" + this.g + "   mSurfaceHeight:" + this.h);
            g();
        }
    }

    @Override // com.blued.android.module.player.live.view.AbsVideoView
    public void setVideoPath(String str) {
        a(str);
        a();
    }
}

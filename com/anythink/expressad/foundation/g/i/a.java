package com.anythink.expressad.foundation.g.i;

import android.media.MediaPlayer;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/i/a.class */
public final class a {
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private MediaPlayer f7942c;
    private volatile boolean d;
    private volatile MediaPlayer.OnPreparedListener f;

    /* renamed from: a  reason: collision with root package name */
    Object f7941a = new Object();
    private volatile boolean e = false;

    private void a(MediaPlayer.OnPreparedListener onPreparedListener) {
        synchronized (this.f7941a) {
            this.f = onPreparedListener;
        }
    }

    private void a(MediaPlayer mediaPlayer, String str) {
        this.f7942c = mediaPlayer;
        this.b = str;
        this.d = true;
        this.f7942c.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.anythink.expressad.foundation.g.i.a.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer mediaPlayer2) {
                synchronized (a.this.f7941a) {
                    a.a(a.this);
                    if (a.this.f != null) {
                        a.this.f.onPrepared(mediaPlayer2);
                    }
                }
            }
        });
        try {
            this.f7942c.prepareAsync();
        } catch (Throwable th) {
        }
    }

    private boolean a() {
        boolean z;
        synchronized (this.f7941a) {
            z = this.d;
        }
        return z;
    }

    static /* synthetic */ boolean a(a aVar) {
        aVar.e = true;
        return true;
    }

    private boolean b() {
        boolean z;
        synchronized (this.f7941a) {
            z = this.e;
        }
        return z;
    }

    private String c() {
        return this.b;
    }

    private MediaPlayer d() {
        return this.f7942c;
    }
}

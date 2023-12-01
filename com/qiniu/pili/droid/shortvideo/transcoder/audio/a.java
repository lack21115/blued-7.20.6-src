package com.qiniu.pili.droid.shortvideo.transcoder.audio;

import android.content.res.AssetFileDescriptor;
import com.qiniu.pili.droid.shortvideo.f.g;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/transcoder/audio/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f14122a;
    private AssetFileDescriptor b;
    private int e = 0;
    private boolean f = true;

    /* renamed from: c  reason: collision with root package name */
    private d f14123c = new d(0, 0);
    private c d = new c(1.0f, 1.0f);

    public String a() {
        return this.f14122a;
    }

    public void a(int i) {
        this.e = i;
    }

    public void a(AssetFileDescriptor assetFileDescriptor) {
        this.b = assetFileDescriptor;
        this.f14122a = null;
        this.f14123c = new d(0L, g.a((Object) assetFileDescriptor));
    }

    public void a(c cVar) {
        this.d = cVar;
    }

    public void a(d dVar) {
        this.f14123c = dVar;
    }

    public void a(String str) {
        this.f14122a = str;
        this.b = null;
        this.f14123c = new d(0L, g.a((Object) str));
    }

    public void a(boolean z) {
        this.f = z;
    }

    public boolean b() {
        return this.f;
    }

    public AssetFileDescriptor c() {
        return this.b;
    }

    public boolean d() {
        return this.b != null;
    }

    public d e() {
        return this.f14123c;
    }

    public c f() {
        return this.d;
    }
}

package com.opos.exoplayer.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/g.class */
public class g implements v {

    /* renamed from: a  reason: collision with root package name */
    private final Context f25415a;
    private final com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> b;

    /* renamed from: c  reason: collision with root package name */
    private final int f25416c;
    private final long d;

    public g(Context context) {
        this(context, null);
    }

    public g(Context context, com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> bVar) {
        this(context, bVar, 0);
    }

    public g(Context context, com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> bVar, int i) {
        this(context, bVar, i, 5000L);
    }

    public g(Context context, com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> bVar, int i, long j) {
        this.f25415a = context;
        this.b = bVar;
        this.f25416c = i;
        this.d = j;
    }

    protected void a(Context context, Handler handler, int i, ArrayList<s> arrayList) {
    }

    protected void a(Context context, com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> bVar, long j, Handler handler, com.opos.exoplayer.core.video.f fVar, int i, ArrayList<s> arrayList) {
        arrayList.add(new com.opos.exoplayer.core.video.c(context, com.opos.exoplayer.core.d.c.f25262a, j, bVar, false, handler, fVar, 50));
        if (i == 0) {
            return;
        }
        int size = arrayList.size();
        int i2 = size;
        if (i == 2) {
            i2 = size - 1;
        }
        try {
            arrayList.add(i2, (s) Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(Boolean.TYPE, Long.TYPE, Handler.class, com.opos.exoplayer.core.video.f.class, Integer.TYPE).newInstance(true, Long.valueOf(j), handler, fVar, 50));
            com.opos.cmn.an.f.a.a("DefaultRenderersFactory", "Loaded LibvpxVideoRenderer.");
        } catch (ClassNotFoundException e) {
        } catch (Exception e2) {
            throw new RuntimeException("Error instantiating VP9 extension", e2);
        }
    }

    protected void a(Context context, com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.d> bVar, com.opos.exoplayer.core.a.d[] dVarArr, Handler handler, com.opos.exoplayer.core.a.e eVar, int i, ArrayList<s> arrayList) {
        int i2;
        int i3;
        arrayList.add(new com.opos.exoplayer.core.a.i(com.opos.exoplayer.core.d.c.f25262a, bVar, true, handler, eVar, com.opos.exoplayer.core.a.c.a(context), dVarArr));
        if (i == 0) {
            return;
        }
        int size = arrayList.size();
        int i4 = size;
        if (i == 2) {
            i4 = size - 1;
        }
        try {
            try {
                i2 = i4 + 1;
            } catch (ClassNotFoundException e) {
            }
            try {
                try {
                    arrayList.add(i4, (s) Class.forName("com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer").getConstructor(Handler.class, com.opos.exoplayer.core.a.e.class, com.opos.exoplayer.core.a.d[].class).newInstance(handler, eVar, dVarArr));
                    com.opos.cmn.an.f.a.a("DefaultRenderersFactory", "Loaded LibopusAudioRenderer.");
                } catch (ClassNotFoundException e2) {
                    i4 = i2;
                    i2 = i4;
                    try {
                        i3 = i2 + 1;
                        arrayList.add(i2, (s) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, com.opos.exoplayer.core.a.e.class, com.opos.exoplayer.core.a.d[].class).newInstance(handler, eVar, dVarArr));
                        com.opos.cmn.an.f.a.a("DefaultRenderersFactory", "Loaded LibflacAudioRenderer.");
                        i2 = i3;
                        arrayList.add(i2, (s) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, com.opos.exoplayer.core.a.e.class, com.opos.exoplayer.core.a.d[].class).newInstance(handler, eVar, dVarArr));
                        com.opos.cmn.an.f.a.a("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
                        return;
                    } catch (Exception e3) {
                        throw new RuntimeException("Error instantiating FLAC extension", e3);
                    }
                }
                arrayList.add(i2, (s) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, com.opos.exoplayer.core.a.e.class, com.opos.exoplayer.core.a.d[].class).newInstance(handler, eVar, dVarArr));
                com.opos.cmn.an.f.a.a("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
                return;
            } catch (ClassNotFoundException e4) {
                return;
            } catch (Exception e5) {
                throw new RuntimeException("Error instantiating FFmpeg extension", e5);
            }
            try {
                i3 = i2 + 1;
                try {
                    arrayList.add(i2, (s) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, com.opos.exoplayer.core.a.e.class, com.opos.exoplayer.core.a.d[].class).newInstance(handler, eVar, dVarArr));
                    com.opos.cmn.an.f.a.a("DefaultRenderersFactory", "Loaded LibflacAudioRenderer.");
                    i2 = i3;
                } catch (ClassNotFoundException e6) {
                    i2 = i3;
                }
            } catch (ClassNotFoundException e7) {
            }
        } catch (Exception e8) {
            throw new RuntimeException("Error instantiating Opus extension", e8);
        }
    }

    protected void a(Context context, com.opos.exoplayer.core.f.j jVar, Looper looper, int i, ArrayList<s> arrayList) {
        arrayList.add(new com.opos.exoplayer.core.f.k(jVar, looper));
    }

    protected void a(Context context, com.opos.exoplayer.core.metadata.e eVar, Looper looper, int i, ArrayList<s> arrayList) {
        arrayList.add(new com.opos.exoplayer.core.metadata.f(eVar, looper));
    }

    protected com.opos.exoplayer.core.a.d[] a() {
        return new com.opos.exoplayer.core.a.d[0];
    }

    @Override // com.opos.exoplayer.core.v
    public s[] a(Handler handler, com.opos.exoplayer.core.video.f fVar, com.opos.exoplayer.core.a.e eVar, com.opos.exoplayer.core.f.j jVar, com.opos.exoplayer.core.metadata.e eVar2) {
        ArrayList<s> arrayList = new ArrayList<>();
        a(this.f25415a, this.b, this.d, handler, fVar, this.f25416c, arrayList);
        a(this.f25415a, this.b, a(), handler, eVar, this.f25416c, arrayList);
        a(this.f25415a, jVar, handler.getLooper(), this.f25416c, arrayList);
        a(this.f25415a, eVar2, handler.getLooper(), this.f25416c, arrayList);
        a(this.f25415a, handler, this.f25416c, arrayList);
        return (s[]) arrayList.toArray(new s[arrayList.size()]);
    }
}

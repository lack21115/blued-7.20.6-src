package com.anythink.expressad.exoplayer;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/f.class */
public final class f implements ab {

    /* renamed from: a  reason: collision with root package name */
    public static final long f4488a = 5000;
    public static final int b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static final int f4489c = 1;
    public static final int d = 2;
    protected static final int e = 50;
    private static final String f = "DefaultRenderersFactory";
    private final Context g;
    private final com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> h;
    private final int i;
    private final long j;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/f$a.class */
    public @interface a {
    }

    public f(Context context) {
        this(context, 0);
    }

    public f(Context context, int i) {
        this(context, null, i, 5000L);
    }

    public f(Context context, int i, long j) {
        this(context, null, i, j);
    }

    @Deprecated
    private f(Context context, com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar) {
        this(context, gVar, (byte) 0);
    }

    @Deprecated
    private f(Context context, com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar, byte b2) {
        this(context, gVar, 0, 5000L);
    }

    @Deprecated
    private f(Context context, com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar, int i, long j) {
        this.g = context;
        this.i = i;
        this.j = j;
        this.h = gVar;
    }

    private static void a() {
    }

    private static void a(Context context, com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar, long j, Handler handler, com.anythink.expressad.exoplayer.l.h hVar, int i, ArrayList<y> arrayList) {
        arrayList.add(new com.anythink.expressad.exoplayer.l.e(context, com.anythink.expressad.exoplayer.f.c.f4494a, j, gVar, handler, hVar, 50));
        if (i == 0) {
            return;
        }
        int size = arrayList.size();
        int i2 = size;
        if (i == 2) {
            i2 = size - 1;
        }
        try {
            arrayList.add(i2, (y) Class.forName("com.anythink.expressad.exoplayer.ext.vp9.LibvpxVideoRenderer").getConstructor(Boolean.TYPE, Long.TYPE, Handler.class, com.anythink.expressad.exoplayer.l.h.class, Integer.TYPE).newInstance(Boolean.TRUE, Long.valueOf(j), handler, hVar, 50));
            Log.i(f, "Loaded LibvpxVideoRenderer.");
        } catch (ClassNotFoundException e2) {
        } catch (Exception e3) {
            throw new RuntimeException("Error instantiating VP9 extension", e3);
        }
    }

    private static void a(Context context, com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar, com.anythink.expressad.exoplayer.b.f[] fVarArr, Handler handler, com.anythink.expressad.exoplayer.b.g gVar2, int i, ArrayList<y> arrayList) {
        int i2;
        int i3;
        arrayList.add(new com.anythink.expressad.exoplayer.b.o(context, com.anythink.expressad.exoplayer.f.c.f4494a, gVar, handler, gVar2, com.anythink.expressad.exoplayer.b.c.a(context), fVarArr));
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
            } catch (ClassNotFoundException e2) {
            }
            try {
                try {
                    arrayList.add(i4, (y) Class.forName("com.anythink.expressad.exoplayer.ext.opus.LibopusAudioRenderer").getConstructor(Handler.class, com.anythink.expressad.exoplayer.b.g.class, com.anythink.expressad.exoplayer.b.f[].class).newInstance(handler, gVar2, fVarArr));
                    Log.i(f, "Loaded LibopusAudioRenderer.");
                } catch (ClassNotFoundException e3) {
                    i4 = i2;
                    i2 = i4;
                    try {
                        i3 = i2 + 1;
                        arrayList.add(i2, (y) Class.forName("com.anythink.expressad.exoplayer.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, com.anythink.expressad.exoplayer.b.g.class, com.anythink.expressad.exoplayer.b.f[].class).newInstance(handler, gVar2, fVarArr));
                        Log.i(f, "Loaded LibflacAudioRenderer.");
                        i2 = i3;
                        arrayList.add(i2, (y) Class.forName("com.anythink.expressad.exoplayer.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, com.anythink.expressad.exoplayer.b.g.class, com.anythink.expressad.exoplayer.b.f[].class).newInstance(handler, gVar2, fVarArr));
                        Log.i(f, "Loaded FfmpegAudioRenderer.");
                        return;
                    } catch (Exception e4) {
                        throw new RuntimeException("Error instantiating FLAC extension", e4);
                    }
                }
                arrayList.add(i2, (y) Class.forName("com.anythink.expressad.exoplayer.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, com.anythink.expressad.exoplayer.b.g.class, com.anythink.expressad.exoplayer.b.f[].class).newInstance(handler, gVar2, fVarArr));
                Log.i(f, "Loaded FfmpegAudioRenderer.");
                return;
            } catch (ClassNotFoundException e5) {
                return;
            } catch (Exception e6) {
                throw new RuntimeException("Error instantiating FFmpeg extension", e6);
            }
            try {
                i3 = i2 + 1;
                try {
                    arrayList.add(i2, (y) Class.forName("com.anythink.expressad.exoplayer.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, com.anythink.expressad.exoplayer.b.g.class, com.anythink.expressad.exoplayer.b.f[].class).newInstance(handler, gVar2, fVarArr));
                    Log.i(f, "Loaded LibflacAudioRenderer.");
                    i2 = i3;
                } catch (ClassNotFoundException e7) {
                    i2 = i3;
                }
            } catch (ClassNotFoundException e8) {
            }
        } catch (Exception e9) {
            throw new RuntimeException("Error instantiating Opus extension", e9);
        }
    }

    private static void a(com.anythink.expressad.exoplayer.g.f fVar, Looper looper, ArrayList<y> arrayList) {
        arrayList.add(new com.anythink.expressad.exoplayer.g.g(fVar, looper));
    }

    private static com.anythink.expressad.exoplayer.b.f[] b() {
        return new com.anythink.expressad.exoplayer.b.f[0];
    }

    @Override // com.anythink.expressad.exoplayer.ab
    public final y[] a(Handler handler, com.anythink.expressad.exoplayer.l.h hVar, com.anythink.expressad.exoplayer.b.g gVar, com.anythink.expressad.exoplayer.g.f fVar, com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar2) {
        if (gVar2 == null) {
            gVar2 = this.h;
        }
        ArrayList arrayList = new ArrayList();
        Context context = this.g;
        long j = this.j;
        int i = this.i;
        arrayList.add(new com.anythink.expressad.exoplayer.l.e(context, com.anythink.expressad.exoplayer.f.c.f4494a, j, gVar2, handler, hVar, 50));
        if (i != 0) {
            int size = arrayList.size();
            int i2 = size;
            if (i == 2) {
                i2 = size - 1;
            }
            try {
                arrayList.add(i2, (y) Class.forName("com.anythink.expressad.exoplayer.ext.vp9.LibvpxVideoRenderer").getConstructor(Boolean.TYPE, Long.TYPE, Handler.class, com.anythink.expressad.exoplayer.l.h.class, Integer.TYPE).newInstance(Boolean.TRUE, Long.valueOf(j), handler, hVar, 50));
                Log.i(f, "Loaded LibvpxVideoRenderer.");
            } catch (ClassNotFoundException e2) {
            } catch (Exception e3) {
                throw new RuntimeException("Error instantiating VP9 extension", e3);
            }
        }
        Context context2 = this.g;
        com.anythink.expressad.exoplayer.b.f[] fVarArr = new com.anythink.expressad.exoplayer.b.f[0];
        int i3 = this.i;
        arrayList.add(new com.anythink.expressad.exoplayer.b.o(context2, com.anythink.expressad.exoplayer.f.c.f4494a, gVar2, handler, gVar, com.anythink.expressad.exoplayer.b.c.a(context2), fVarArr));
        if (i3 != 0) {
            int size2 = arrayList.size();
            int i4 = size2;
            if (i3 == 2) {
                i4 = size2 - 1;
            }
            try {
                try {
                    y yVar = (y) Class.forName("com.anythink.expressad.exoplayer.ext.opus.LibopusAudioRenderer").getConstructor(Handler.class, com.anythink.expressad.exoplayer.b.g.class, com.anythink.expressad.exoplayer.b.f[].class).newInstance(handler, gVar, fVarArr);
                    int i5 = i4 + 1;
                    try {
                        arrayList.add(i4, yVar);
                        Log.i(f, "Loaded LibopusAudioRenderer.");
                        i4 = i5;
                    } catch (ClassNotFoundException e4) {
                        i4 = i5;
                    }
                } catch (ClassNotFoundException e5) {
                }
                try {
                    try {
                        y yVar2 = (y) Class.forName("com.anythink.expressad.exoplayer.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, com.anythink.expressad.exoplayer.b.g.class, com.anythink.expressad.exoplayer.b.f[].class).newInstance(handler, gVar, fVarArr);
                        int i6 = i4 + 1;
                        try {
                            arrayList.add(i4, yVar2);
                            Log.i(f, "Loaded LibflacAudioRenderer.");
                            i4 = i6;
                        } catch (ClassNotFoundException e6) {
                            i4 = i6;
                        }
                    } catch (Exception e7) {
                        throw new RuntimeException("Error instantiating FLAC extension", e7);
                    }
                } catch (ClassNotFoundException e8) {
                }
                try {
                    arrayList.add(i4, (y) Class.forName("com.anythink.expressad.exoplayer.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, com.anythink.expressad.exoplayer.b.g.class, com.anythink.expressad.exoplayer.b.f[].class).newInstance(handler, gVar, fVarArr));
                    Log.i(f, "Loaded FfmpegAudioRenderer.");
                } catch (ClassNotFoundException e9) {
                } catch (Exception e10) {
                    throw new RuntimeException("Error instantiating FFmpeg extension", e10);
                }
            } catch (Exception e11) {
                throw new RuntimeException("Error instantiating Opus extension", e11);
            }
        }
        arrayList.add(new com.anythink.expressad.exoplayer.g.g(fVar, handler.getLooper()));
        return (y[]) arrayList.toArray(new y[arrayList.size()]);
    }
}

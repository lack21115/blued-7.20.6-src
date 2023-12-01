package com.anythink.expressad.exoplayer.k;

import android.media.TtmlUtils;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import com.anythink.expressad.exoplayer.a.b;
import com.anythink.expressad.exoplayer.ae;
import com.anythink.expressad.exoplayer.h.t;
import com.anythink.expressad.exoplayer.i.e;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/k/i.class */
public final class i implements com.anythink.expressad.exoplayer.a.b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4813a = "EventLogger";
    private static final int b = 3;

    /* renamed from: c  reason: collision with root package name */
    private static final NumberFormat f4814c;
    private final com.anythink.expressad.exoplayer.i.e d;
    private final ae.b e = new ae.b();
    private final ae.a f = new ae.a();
    private final long g = SystemClock.elapsedRealtime();

    static {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        f4814c = numberFormat;
        numberFormat.setMinimumFractionDigits(2);
        f4814c.setMaximumFractionDigits(2);
        f4814c.setGroupingUsed(false);
    }

    private i(com.anythink.expressad.exoplayer.i.e eVar) {
        this.d = eVar;
    }

    private static String a(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "?" : "ENDED" : "READY" : "BUFFERING" : "IDLE";
    }

    private static String a(int i, int i2) {
        return i < 2 ? "N/A" : i2 != 0 ? i2 != 8 ? i2 != 16 ? "?" : "YES" : "YES_NOT_SEAMLESS" : "NO";
    }

    private static String a(long j) {
        return j == com.anythink.expressad.exoplayer.b.b ? "?" : f4814c.format(((float) j) / 1000.0f);
    }

    private static String a(com.anythink.expressad.exoplayer.i.f fVar, com.anythink.expressad.exoplayer.h.ae aeVar, int i) {
        return a((fVar == null || fVar.f() != aeVar || fVar.c(i) == -1) ? false : true);
    }

    private static String a(boolean z) {
        return z ? "[X]" : "[ ]";
    }

    private void a(b.a aVar, String str) {
        Log.d(f4813a, b(aVar, str));
    }

    private void a(b.a aVar, String str, Exception exc) {
        a(aVar, "internalError", str, exc);
    }

    private void a(b.a aVar, String str, String str2) {
        Log.d(f4813a, b(aVar, str, str2));
    }

    private void a(b.a aVar, String str, String str2, Throwable th) {
        a(b(aVar, str, str2), th);
    }

    private void a(b.a aVar, String str, Throwable th) {
        a(b(aVar, str), th);
    }

    private static void a(com.anythink.expressad.exoplayer.g.a aVar, String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= aVar.a()) {
                return;
            }
            Log.d(f4813a, str + aVar.a(i2));
            i = i2 + 1;
        }
    }

    private static void a(String str) {
        Log.d(f4813a, str);
    }

    private static void a(String str, Throwable th) {
        Log.e(f4813a, str, th);
    }

    private static String b(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? "?" : "YES" : "NO_EXCEEDS_CAPABILITIES" : "NO_UNSUPPORTED_DRM" : "NO_UNSUPPORTED_TYPE" : "NO";
    }

    private String b(b.a aVar, String str) {
        return str + " [" + i(aVar) + "]";
    }

    private String b(b.a aVar, String str, String str2) {
        return str + " [" + i(aVar) + ", " + str2 + "]";
    }

    private static String c(int i) {
        return i != 0 ? i != 1 ? i != 2 ? "?" : "ALL" : "ONE" : "OFF";
    }

    private static String d(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? "?" : "INTERNAL" : "AD_INSERTION" : "SEEK_ADJUSTMENT" : "SEEK" : "PERIOD_TRANSITION";
    }

    private static String e(int i) {
        return i != 0 ? i != 1 ? i != 2 ? "?" : "DYNAMIC" : "RESET" : "PREPARED";
    }

    private static String f(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                if (i >= 10000) {
                                    return "custom (" + i + ")";
                                }
                                return "?";
                            }
                            return "none";
                        }
                        return TtmlUtils.TAG_METADATA;
                    }
                    return "text";
                }
                return "video";
            }
            return "audio";
        }
        return "default";
    }

    private String i(b.a aVar) {
        String str = "window=" + aVar.f4316c;
        String str2 = str;
        if (aVar.d != null) {
            String str3 = str + ", period=" + aVar.d.f4645a;
            str2 = str3;
            if (aVar.d.a()) {
                str2 = (str3 + ", adGroup=" + aVar.d.b) + ", ad=" + aVar.d.f4646c;
            }
        }
        return a(aVar.f4315a - this.g) + ", " + a(aVar.f) + ", " + str2;
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a() {
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(b.a aVar) {
        a(aVar, "seekStarted");
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(b.a aVar, int i) {
        int c2 = aVar.b.c();
        int b2 = aVar.b.b();
        StringBuilder sb = new StringBuilder("timelineChanged [");
        sb.append(i(aVar));
        sb.append(", periodCount=");
        sb.append(c2);
        sb.append(", windowCount=");
        sb.append(b2);
        sb.append(", reason=");
        sb.append(i != 0 ? i != 1 ? i != 2 ? "?" : "DYNAMIC" : "RESET" : "PREPARED");
        Log.d(f4813a, sb.toString());
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= Math.min(c2, 3)) {
                break;
            }
            aVar.b.a(i3, this.f, false);
            Log.d(f4813a, "  period [" + a(com.anythink.expressad.exoplayer.b.a(this.f.d)) + "]");
            i2 = i3 + 1;
        }
        if (c2 > 3) {
            Log.d(f4813a, "  ...");
        }
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= Math.min(b2, 3)) {
                break;
            }
            aVar.b.a(i5, this.e, false);
            Log.d(f4813a, "  window [" + a(com.anythink.expressad.exoplayer.b.a(this.e.i)) + ", " + this.e.d + ", " + this.e.e + "]");
            i4 = i5 + 1;
        }
        if (b2 > 3) {
            Log.d(f4813a, "  ...");
        }
        Log.d(f4813a, "]");
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(b.a aVar, int i, int i2) {
        a(aVar, "viewportSizeChanged", i + ", " + i2);
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(b.a aVar, int i, long j, long j2) {
        a(aVar, "audioTrackUnderrun", i + ", " + j + ", " + j2 + "]", (Throwable) null);
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(b.a aVar, int i, com.anythink.expressad.exoplayer.m mVar) {
        a(aVar, "decoderInputFormatChanged", f(i) + ", " + com.anythink.expressad.exoplayer.m.c(mVar));
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(b.a aVar, int i, String str) {
        a(aVar, "decoderInitialized", f(i) + ", " + str);
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(b.a aVar, NetworkInfo networkInfo) {
        a(aVar, "networkTypeChanged", networkInfo == null ? "none" : networkInfo.toString());
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(b.a aVar, Surface surface) {
        a(aVar, "renderedFirstFrame", surface.toString());
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(b.a aVar, com.anythink.expressad.exoplayer.g.a aVar2) {
        Log.d(f4813a, "metadata [" + i(aVar) + ", ");
        a(aVar2, "  ");
        Log.d(f4813a, "]");
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(b.a aVar, com.anythink.expressad.exoplayer.g gVar) {
        a(b(aVar, "playerFailed"), gVar);
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(b.a aVar, t.c cVar) {
        a(aVar, "downstreamFormatChanged", com.anythink.expressad.exoplayer.m.c(cVar.f4668c));
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(b.a aVar, com.anythink.expressad.exoplayer.i.g gVar) {
        com.anythink.expressad.exoplayer.i.e eVar = this.d;
        e.a a2 = eVar != null ? eVar.a() : null;
        if (a2 == null) {
            a(aVar, "tracksChanged", "[]");
            return;
        }
        Log.d(f4813a, "tracksChanged [" + i(aVar) + ", ");
        int a3 = a2.a();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= a3) {
                break;
            }
            com.anythink.expressad.exoplayer.h.af b2 = a2.b(i2);
            com.anythink.expressad.exoplayer.i.f a4 = gVar.a(i2);
            if (b2.b > 0) {
                Log.d(f4813a, "  Renderer:" + i2 + " [");
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= b2.b) {
                        break;
                    }
                    com.anythink.expressad.exoplayer.h.ae a5 = b2.a(i4);
                    int i5 = a5.f4578a;
                    int a6 = a2.a(i2, i4);
                    String str = i5 < 2 ? "N/A" : a6 != 0 ? a6 != 8 ? a6 != 16 ? "?" : "YES" : "YES_NOT_SEAMLESS" : "NO";
                    Log.d(f4813a, "    Group:" + i4 + ", adaptive_supported=" + str + " [");
                    int i6 = 0;
                    while (true) {
                        int i7 = i6;
                        if (i7 < a5.f4578a) {
                            String a7 = a((a4 == null || a4.f() != a5 || a4.c(i7) == -1) ? false : true);
                            String b3 = b(a2.a(i2, i4, i7));
                            Log.d(f4813a, "      " + a7 + " Track:" + i7 + ", " + com.anythink.expressad.exoplayer.m.c(a5.a(i7)) + ", supported=" + b3);
                            i6 = i7 + 1;
                        }
                    }
                    Log.d(f4813a, "    ]");
                    i3 = i4 + 1;
                }
                if (a4 != null) {
                    int i8 = 0;
                    while (true) {
                        int i9 = i8;
                        if (i9 >= a4.g()) {
                            break;
                        }
                        com.anythink.expressad.exoplayer.g.a aVar2 = a4.a(i9).f;
                        if (aVar2 != null) {
                            Log.d(f4813a, "    Metadata [");
                            a(aVar2, "      ");
                            Log.d(f4813a, "    ]");
                            break;
                        }
                        i8 = i9 + 1;
                    }
                }
                Log.d(f4813a, "  ]");
            }
            i = i2 + 1;
        }
        com.anythink.expressad.exoplayer.h.af b4 = a2.b();
        if (b4.b > 0) {
            Log.d(f4813a, "  Renderer:None [");
            int i10 = 0;
            while (true) {
                int i11 = i10;
                if (i11 >= b4.b) {
                    break;
                }
                Log.d(f4813a, "    Group:" + i11 + " [");
                com.anythink.expressad.exoplayer.h.ae a8 = b4.a(i11);
                int i12 = 0;
                while (true) {
                    int i13 = i12;
                    if (i13 < a8.f4578a) {
                        String a9 = a(false);
                        String b5 = b(0);
                        Log.d(f4813a, "      " + a9 + " Track:" + i13 + ", " + com.anythink.expressad.exoplayer.m.c(a8.a(i13)) + ", supported=" + b5);
                        i12 = i13 + 1;
                    }
                }
                Log.d(f4813a, "    ]");
                i10 = i11 + 1;
            }
            Log.d(f4813a, "  ]");
        }
        Log.d(f4813a, "]");
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(b.a aVar, com.anythink.expressad.exoplayer.v vVar) {
        a(aVar, "playbackParameters", af.a("speed=%.2f, pitch=%.2f, skipSilence=%s", Float.valueOf(vVar.b), Float.valueOf(vVar.f4902c), Boolean.valueOf(vVar.d)));
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(b.a aVar, IOException iOException) {
        a(aVar, "loadError", (Exception) iOException);
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(b.a aVar, Exception exc) {
        a(aVar, "drmSessionManagerError", exc);
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(b.a aVar, boolean z) {
        a(aVar, "shuffleModeEnabled", Boolean.toString(z));
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void a(b.a aVar, boolean z, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(z);
        sb.append(", ");
        sb.append(i != 1 ? i != 2 ? i != 3 ? i != 4 ? "?" : "ENDED" : "READY" : "BUFFERING" : "IDLE");
        a(aVar, "state", sb.toString());
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void b() {
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void b(b.a aVar) {
        a(aVar, "seekProcessed");
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void b(b.a aVar, int i) {
        a(aVar, "positionDiscontinuity", i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? "?" : "INTERNAL" : "AD_INSERTION" : "SEEK_ADJUSTMENT" : "SEEK" : "PERIOD_TRANSITION");
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void b(b.a aVar, int i, int i2) {
        a(aVar, "videoSizeChanged", i + ", " + i2);
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void b(b.a aVar, t.c cVar) {
        a(aVar, "upstreamDiscarded", com.anythink.expressad.exoplayer.m.c(cVar.f4668c));
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void b(b.a aVar, boolean z) {
        a(aVar, "loading", Boolean.toString(z));
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void c() {
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void c(b.a aVar) {
        a(aVar, "mediaPeriodCreated");
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void c(b.a aVar, int i) {
        a(aVar, "repeatMode", i != 0 ? i != 1 ? i != 2 ? "?" : "ALL" : "ONE" : "OFF");
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void d() {
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void d(b.a aVar) {
        a(aVar, "mediaPeriodReleased");
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void d(b.a aVar, int i) {
        a(aVar, "decoderEnabled", f(i));
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void e(b.a aVar) {
        a(aVar, "mediaPeriodReadingStarted");
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void e(b.a aVar, int i) {
        a(aVar, "decoderDisabled", f(i));
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void f(b.a aVar) {
        a(aVar, "drmKeysLoaded");
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void f(b.a aVar, int i) {
        a(aVar, "audioSessionId", Integer.toString(i));
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void g(b.a aVar) {
        a(aVar, "drmKeysRestored");
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void g(b.a aVar, int i) {
        a(aVar, "droppedFrames", Integer.toString(i));
    }

    @Override // com.anythink.expressad.exoplayer.a.b
    public final void h(b.a aVar) {
        a(aVar, "drmKeysRemoved");
    }
}

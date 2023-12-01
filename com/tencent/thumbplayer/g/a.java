package com.tencent.thumbplayer.g;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.view.Surface;
import com.tencent.thumbplayer.g.b;
import com.tencent.thumbplayer.g.b.c;
import com.tencent.thumbplayer.g.b.d;
import com.tencent.thumbplayer.g.b.e;
import com.tencent.thumbplayer.g.b.f;
import com.tencent.thumbplayer.g.b.g;
import com.tencent.thumbplayer.g.f.a;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/g/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final a f25623a = new a();
    private static boolean e = false;
    private static boolean f = true;
    private boolean d;
    private com.tencent.thumbplayer.g.f.b b = com.tencent.thumbplayer.g.f.b.e;

    /* renamed from: c  reason: collision with root package name */
    private boolean f25624c = true;
    private final HashMap<b, c> g = new HashMap<>();
    private final com.tencent.thumbplayer.g.e.a h = new com.tencent.thumbplayer.g.e.a();
    private final com.tencent.thumbplayer.g.d.a i = new com.tencent.thumbplayer.g.d.a();
    private final com.tencent.thumbplayer.g.d.a j = new com.tencent.thumbplayer.g.d.a();
    private boolean k = true;

    public static a a() {
        return f25623a;
    }

    private c a(MediaFormat mediaFormat, b bVar) {
        if (com.tencent.thumbplayer.g.h.b.a()) {
            com.tencent.thumbplayer.g.h.b.b("TCodecManager", "createDirectCodecWrapper mediaFormat:" + mediaFormat + " createBy:" + bVar.a() + " nameOrType:" + bVar.l());
        }
        return bVar.a() == b.EnumC0853b.CreateByName ? new d(MediaCodec.createByCodecName(bVar.l())) : new d(MediaCodec.createDecoderByType(bVar.l()));
    }

    private c a(MediaFormat mediaFormat, b bVar, Surface surface) {
        boolean b = bVar.b();
        if (com.tencent.thumbplayer.g.h.b.a()) {
            com.tencent.thumbplayer.g.h.b.b("TCodecManager", "getCodec isVideo:" + b + " codecFinalReuseEnable:" + bVar.f25625a);
        }
        if (Build.VERSION.SDK_INT < 23 || !bVar.f25625a) {
            bVar.b = false;
            if (com.tencent.thumbplayer.g.h.b.a()) {
                com.tencent.thumbplayer.g.h.b.b("TCodecManager", "getCodec return DirectCodecWrapper for mediaFormat:" + mediaFormat + " codecFinalReuseEnable:false surface:" + surface);
            }
            return a(mediaFormat, bVar);
        }
        e a2 = e.a(mediaFormat);
        c a3 = a(b, a2);
        e.a(a2.f25635a);
        if (a3 != null) {
            a.b b2 = a3.b(a2);
            if (b2 == a.b.KEEP_CODEC_RESULT_YES_WITHOUT_RECONFIGURATION || b2 == a.b.KEEP_CODEC_RESULT_YES_WITH_RECONFIGURATION) {
                if (com.tencent.thumbplayer.g.h.b.a()) {
                    com.tencent.thumbplayer.g.h.b.b("TCodecManager", "getCodec reuse, isVideo:" + b + " reuseType:" + b2);
                }
                a3.b();
                a3.c();
                bVar.b = true;
                return a3;
            } else if (b2 == a.b.KEEP_CODEC_RESULT_NO && com.tencent.thumbplayer.g.h.b.a()) {
                com.tencent.thumbplayer.g.h.b.d("TCodecManager", "getCodec not reuse, isVideo:" + b + " reuseType:" + b2);
            }
        }
        if (com.tencent.thumbplayer.g.h.b.a()) {
            com.tencent.thumbplayer.g.h.b.b("TCodecManager", "getCodec not reuse, for can't find reUseAble CodecWrapper. isVideo:".concat(String.valueOf(b)));
        }
        bVar.b = false;
        c b3 = b(mediaFormat, bVar);
        b3.b();
        this.g.put(bVar, b3);
        return b3;
    }

    private c a(boolean z, e eVar) {
        return (z ? this.i : this.j).a(eVar);
    }

    private c b(MediaFormat mediaFormat, b bVar) {
        if (com.tencent.thumbplayer.g.h.b.a()) {
            com.tencent.thumbplayer.g.h.b.b("TCodecManager", "createNewReuseCodecWrapper mediaFormat:" + mediaFormat + " createBy:" + bVar.a() + " nameOrType:" + bVar.l());
        }
        String string = mediaFormat.getString(MediaFormat.KEY_MIME);
        e a2 = e.a(mediaFormat);
        com.tencent.thumbplayer.g.f.a.a(a2, mediaFormat);
        return f.a(bVar.a() == b.EnumC0853b.CreateByName ? MediaCodec.createByCodecName(bVar.l()) : MediaCodec.createDecoderByType(string), string, a2);
    }

    public static void b() {
    }

    private void c(c cVar) {
        if (e()) {
            if (cVar instanceof g) {
                this.i.a((f) cVar);
            } else if (cVar instanceof com.tencent.thumbplayer.g.b.a) {
                this.j.a((f) cVar);
            }
        }
    }

    public static boolean c() {
        return f;
    }

    public final c a(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i, b bVar) {
        if (com.tencent.thumbplayer.g.h.b.a()) {
            com.tencent.thumbplayer.g.h.b.b("TCodecManager", "configureStart videoPoolInfo:" + this.i.a() + ", audioPoolInfo:" + this.j.a());
        }
        this.d = true;
        this.k = true;
        c a2 = a(mediaFormat, bVar, surface);
        c(a2);
        a2.a(bVar.c());
        a2.a(mediaFormat, surface, mediaCrypto, i);
        if (com.tencent.thumbplayer.g.h.b.a()) {
            com.tencent.thumbplayer.g.h.b.b("TCodecManager", "configureEnd   videoPoolInfo:" + this.i.a() + ", audioPoolInfo:" + this.j.a());
        }
        return a2;
    }

    public final void a(c cVar) {
        if (e()) {
            if (cVar instanceof g) {
                this.i.b((f) cVar);
            } else if (cVar instanceof com.tencent.thumbplayer.g.b.a) {
                this.j.b((f) cVar);
            }
        }
    }

    public final void a(com.tencent.thumbplayer.g.h.a aVar) {
        com.tencent.thumbplayer.g.h.b.a(aVar);
    }

    public final void a(boolean z) {
        com.tencent.thumbplayer.g.h.b.a(z);
    }

    public final boolean a(b bVar, Surface surface) {
        boolean e2 = e();
        boolean d = bVar.d();
        boolean b = bVar.b();
        boolean z = e2 && d;
        boolean z2 = Build.VERSION.SDK_INT >= 23 && !com.tencent.thumbplayer.g.h.c.a();
        if (com.tencent.thumbplayer.g.h.b.a()) {
            com.tencent.thumbplayer.g.h.b.b("TCodecManager", "reuseEnable getCodec isVideo:" + b + " reuseEnable:" + z + " globalReuseEnable:" + e2 + " mediaCodecReuseEnable:" + d + " canUseSetOutputSurfaceAPI:" + z2 + " ,surface:" + surface);
        }
        return z && b && z2 && surface != null;
    }

    public final void b(c cVar) {
        if (e()) {
            if (cVar instanceof g) {
                this.i.c((f) cVar);
            } else if (cVar instanceof com.tencent.thumbplayer.g.b.a) {
                this.j.c((f) cVar);
            }
        }
    }

    public final com.tencent.thumbplayer.g.f.b d() {
        return this.b;
    }

    public final boolean e() {
        return this.f25624c;
    }

    public final boolean f() {
        return this.k;
    }
}

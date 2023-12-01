package com.tencent.thumbplayer.g.d;

import com.tencent.thumbplayer.g.b.e;
import com.tencent.thumbplayer.g.b.f;
import com.tencent.thumbplayer.g.h.d;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/g/d/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final b f25647a = new b(2, "keep");
    private final b b = new b(Integer.MAX_VALUE, "running");

    public a() {
        this.f25647a.a(new c() { // from class: com.tencent.thumbplayer.g.d.a.2
            @Override // com.tencent.thumbplayer.g.d.c
            public void a(f fVar) {
                if (com.tencent.thumbplayer.g.h.b.a()) {
                    com.tencent.thumbplayer.g.h.b.b("CodecWrapperManager", "onErase codecWrapper:".concat(String.valueOf(fVar)));
                }
                fVar.i();
            }
        });
    }

    public final f a(e eVar) {
        f a2 = this.f25647a.a(eVar);
        if (com.tencent.thumbplayer.g.h.b.a()) {
            com.tencent.thumbplayer.g.h.b.b("CodecWrapperManager", "obtainCodecWrapper codecWrapper:".concat(String.valueOf(a2)));
        }
        return a2;
    }

    public final String a() {
        return "runningPool:" + this.b + " keepPool:" + this.f25647a;
    }

    public final void a(final f fVar) {
        if (com.tencent.thumbplayer.g.h.b.a()) {
            com.tencent.thumbplayer.g.h.b.b("CodecWrapperManager", "transToRunning codecWrapper:".concat(String.valueOf(fVar)));
        }
        this.f25647a.b(fVar);
        this.b.a(fVar);
        d.b(new Runnable() { // from class: com.tencent.thumbplayer.g.d.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.thumbplayer.g.a.a h = fVar.h();
                if (h != null) {
                    h.onTransToRunningPool();
                }
            }
        });
    }

    public final void b(f fVar) {
        if (com.tencent.thumbplayer.g.h.b.a()) {
            com.tencent.thumbplayer.g.h.b.b("CodecWrapperManager", "removeFromRunning codecWrapper:".concat(String.valueOf(fVar)));
        }
        this.b.b(fVar);
    }

    public final void c(f fVar) {
        if (com.tencent.thumbplayer.g.h.b.a()) {
            com.tencent.thumbplayer.g.h.b.b("CodecWrapperManager", "transTokeep codecWrapper:".concat(String.valueOf(fVar)));
        }
        this.b.b(fVar);
        this.f25647a.a(fVar);
        com.tencent.thumbplayer.g.a.a h = fVar.h();
        if (h != null) {
            h.onTransToKeepPool();
        }
    }
}

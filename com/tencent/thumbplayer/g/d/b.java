package com.tencent.thumbplayer.g.d;

import android.text.TextUtils;
import com.tencent.thumbplayer.g.b.e;
import com.tencent.thumbplayer.g.b.f;
import com.tencent.thumbplayer.g.f.a;
import com.tencent.thumbplayer.g.f.b;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/g/d/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private c f39341a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final String f39342c;
    private final CopyOnWriteArraySet<f> d = new CopyOnWriteArraySet<>();

    public b(int i, String str) {
        this.b = i;
        this.f39342c = str;
    }

    private f a(f fVar, Iterator it) {
        while (it.hasNext()) {
            f fVar2 = (f) it.next();
            if (TextUtils.equals(fVar.m(), fVar2.m())) {
                return fVar2;
            }
        }
        return null;
    }

    private f b() {
        Iterator<f> it = this.d.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    private final f b(e eVar) {
        Iterator<f> it = this.d.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!next.b && next.a(eVar) != a.b.KEEP_CODEC_RESULT_NO) {
                return next;
            }
            next.k();
            if (next.l()) {
                b(next);
            }
        }
        return null;
    }

    private f c(f fVar) {
        f a2;
        return (com.tencent.thumbplayer.g.a.a().d().d != b.a.SAME || (a2 = a(fVar, this.d.iterator())) == null) ? b() : a2;
    }

    public final f a(e eVar) {
        f b = b(eVar);
        if (com.tencent.thumbplayer.g.h.b.a()) {
            com.tencent.thumbplayer.g.h.b.b("CodecWrapperPool", "obtain codecWrapper:".concat(String.valueOf(b)));
        }
        if (b != null) {
            this.d.remove(b);
            return b;
        }
        return null;
    }

    public final void a(f fVar) {
        if (a()) {
            b(c(fVar));
        }
        this.d.add(fVar);
    }

    public final void a(c cVar) {
        this.f39341a = cVar;
    }

    public final boolean a() {
        return this.d.size() == this.b;
    }

    public final void b(f fVar) {
        if (this.d.remove(fVar)) {
            c cVar = this.f39341a;
            if (cVar != null) {
                cVar.a(fVar);
                return;
            }
            return;
        }
        com.tencent.thumbplayer.g.h.b.d("CodecWrapperPool", "pool:" + this.f39342c + " remove " + fVar + " not found");
    }

    public final String toString() {
        return "size:" + this.d.size() + " elements:" + this.d;
    }
}

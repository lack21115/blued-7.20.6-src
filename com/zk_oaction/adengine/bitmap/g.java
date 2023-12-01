package com.zk_oaction.adengine.bitmap;

import android.graphics.Bitmap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/bitmap/g.class */
public class g extends c implements h, i {
    private com.zk_oaction.adengine.lk_sdkwrapper.d e;
    private HashMap<String, f> f = new HashMap<>();
    private HashSet<e> g = new HashSet<>();

    public e a(int i, int i2, Bitmap.Config config) {
        e eVar = new e(i, i2, config);
        this.g.add(eVar);
        return eVar;
    }

    @Override // com.zk_oaction.adengine.bitmap.c
    public void a() {
        Iterator<e> it = this.g.iterator();
        while (it.hasNext()) {
            it.next().e();
        }
        super.a();
    }

    public void a(com.zk_oaction.adengine.lk_sdkwrapper.d dVar) {
        this.e = dVar;
    }

    @Override // com.zk_oaction.adengine.bitmap.h
    public void a(String str, float f, boolean z) {
        if (z) {
            try {
                f fVar = this.f.get(b(str, f));
                if (fVar != null) {
                    this.e.e().a(fVar);
                }
            } catch (Exception e) {
            }
        }
    }

    public f b(String str, float f, int i) {
        f fVar;
        synchronized (this) {
            a(str, f, i);
            String b = b(str, f);
            f fVar2 = this.f.get(b);
            fVar = fVar2;
            if (fVar2 == null) {
                fVar = new f(this, str, f);
                this.f.put(b, fVar);
            }
        }
        return fVar;
    }

    @Override // com.zk_oaction.adengine.bitmap.i
    public int c(String str, float f) {
        return a(str, f).d();
    }

    @Override // com.zk_oaction.adengine.bitmap.i
    public int d(String str, float f) {
        return a(str, f).c();
    }

    @Override // com.zk_oaction.adengine.bitmap.c
    public void d() {
        synchronized (this) {
            super.d();
            this.f = null;
            this.e = null;
        }
    }
}

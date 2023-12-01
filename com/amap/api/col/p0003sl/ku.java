package com.amap.api.col.p0003sl;

import java.io.File;

/* renamed from: com.amap.api.col.3sl.ku  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ku.class */
public final class ku extends ky {

    /* renamed from: a  reason: collision with root package name */
    private int f5288a;
    private String b;

    public ku(String str, ky kyVar) {
        super(kyVar);
        this.f5288a = 30;
        this.b = str;
    }

    private static int a(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return file.list().length;
            }
            return 0;
        } catch (Throwable th) {
            iw.c(th, "fus", "gfn");
            return 0;
        }
    }

    @Override // com.amap.api.col.p0003sl.ky
    protected final boolean c() {
        return a(this.b) >= this.f5288a;
    }
}

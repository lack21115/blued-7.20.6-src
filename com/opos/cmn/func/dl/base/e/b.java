package com.opos.cmn.func.dl.base.e;

import java.io.File;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/dl/base/e/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f24915a = d.class.getSimpleName();
    public File b;

    /* renamed from: c  reason: collision with root package name */
    public File f24916c;
    public com.opos.cmn.func.dl.base.a.b d;
    public List<c> e;
    public a f;

    public b(com.opos.cmn.func.dl.base.a.b bVar) {
        this.d = bVar;
        this.b = bVar.i;
        File file = bVar.j;
        this.f24916c = file;
        this.f = new d(this.b, file);
    }

    public static int a(long j, boolean z) {
        int i = 1;
        if (j > 1048576) {
            if (!z) {
                return 1;
            }
            long j2 = j / 1048576;
            int i2 = 1;
            if (j % 1048576 == 0) {
                i2 = 0;
            }
            long j3 = i2 + j2;
            long j4 = j3;
            if (j3 > 5) {
                j4 = 5;
            }
            i = (int) j4;
        }
        return i;
    }

    public static boolean a(long j, Boolean bool) {
        boolean z = j > 0 && bool.booleanValue();
        com.opos.cmn.an.f.a.b(f24915a, "supportMultBlock:".concat(String.valueOf(z)));
        return z;
    }
}

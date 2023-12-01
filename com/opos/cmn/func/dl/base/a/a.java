package com.opos.cmn.func.dl.base.a;

import android.content.Context;
import com.opos.cmn.func.dl.base.exception.DlException;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/dl/base/a/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    static final String f11187a = a.class.getSimpleName();
    b b;

    /* renamed from: c  reason: collision with root package name */
    Context f11188c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.opos.cmn.func.dl.base.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/dl/base/a/a$a.class */
    public static final class C0470a {

        /* renamed from: a  reason: collision with root package name */
        String f11189a;
        String b;

        /* renamed from: c  reason: collision with root package name */
        String f11190c;
        long d;
        boolean e;
        boolean f;

        C0470a() {
        }
    }

    public a(b bVar) {
        this.b = bVar;
        this.f11188c = bVar.f11201a;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0105 A[Catch: all -> 0x02d0, Exception -> 0x02d5, DlException -> 0x0320, TRY_ENTER, TryCatch #1 {DlException -> 0x0320, blocks: (B:3:0x0029, B:5:0x005d, B:7:0x0078, B:8:0x0083, B:9:0x0084, B:9:0x0084, B:10:0x0087, B:11:0x0094, B:13:0x0097, B:16:0x00aa, B:20:0x00c8, B:22:0x00d0, B:25:0x00e0, B:26:0x00ea, B:28:0x00ed, B:34:0x0114, B:36:0x013b, B:38:0x0143, B:40:0x0151, B:32:0x0105), top: B:90:0x0029, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0143 A[Catch: all -> 0x02d0, Exception -> 0x02d5, DlException -> 0x0320, TryCatch #1 {DlException -> 0x0320, blocks: (B:3:0x0029, B:5:0x005d, B:7:0x0078, B:8:0x0083, B:9:0x0084, B:9:0x0084, B:10:0x0087, B:11:0x0094, B:13:0x0097, B:16:0x00aa, B:20:0x00c8, B:22:0x00d0, B:25:0x00e0, B:26:0x00ea, B:28:0x00ed, B:34:0x0114, B:36:0x013b, B:38:0x0143, B:40:0x0151, B:32:0x0105), top: B:90:0x0029, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0297  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.opos.cmn.func.dl.base.a.a.C0470a a() {
        /*
            Method dump skipped, instructions count: 873
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.func.dl.base.a.a.a():com.opos.cmn.func.dl.base.a.a$a");
    }

    public final void a(boolean z) {
        b bVar = this.b;
        if (z) {
            bVar.n = true;
        }
        boolean z2 = true;
        if (!z) {
            z2 = true;
            if (!bVar.n) {
                z2 = bVar.q.i;
            }
        }
        if (!z2 && com.opos.cmn.an.h.c.a.c(this.f11188c)) {
            throw new DlException(1013);
        }
    }
}

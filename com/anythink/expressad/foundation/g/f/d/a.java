package com.anythink.expressad.foundation.g.f.d;

import com.anythink.expressad.foundation.g.f.i;
import com.anythink.expressad.foundation.g.f.k;
import java.io.File;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/f/d/a.class */
public class a extends i<Void> {

    /* renamed from: c  reason: collision with root package name */
    private static final String f5037c = a.class.getSimpleName();
    private File d;
    private File e;

    public a(File file, String str) {
        super(str);
        this.d = file;
        this.e = new File(file + ".tmp");
    }

    @Override // com.anythink.expressad.foundation.g.f.i
    public final k<Void> a(com.anythink.expressad.foundation.g.f.f.c cVar) {
        return !f() ? (!this.e.canRead() || this.e.length() <= 0) ? k.a(new com.anythink.expressad.foundation.g.f.a.a(4, cVar)) : this.e.renameTo(this.d) ? k.a(null, cVar) : k.a(new com.anythink.expressad.foundation.g.f.a.a(4, cVar)) : k.a(new com.anythink.expressad.foundation.g.f.a.a(-2, cVar));
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00dd, code lost:
        r9.b(r7);
     */
    @Override // com.anythink.expressad.foundation.g.f.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final byte[] a(com.anythink.expressad.foundation.g.f.f.b r8, com.anythink.expressad.foundation.g.f.c r9) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.foundation.g.f.d.a.a(com.anythink.expressad.foundation.g.f.f.b, com.anythink.expressad.foundation.g.f.c):byte[]");
    }

    @Override // com.anythink.expressad.foundation.g.f.i
    public final int j() {
        return 1;
    }
}

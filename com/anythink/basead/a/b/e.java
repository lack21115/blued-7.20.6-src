package com.anythink.basead.a.b;

import android.text.TextUtils;
import com.anythink.core.common.e.i;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/a/b/e.class */
public final class e extends com.anythink.core.common.res.image.b {
    private String a;
    private boolean b;
    private boolean j;
    private String k;
    private int l;
    private i m;

    public e(String str, boolean z, i iVar, String str2) {
        super(str2);
        this.m = iVar;
        this.a = str;
        this.b = z;
        this.j = TextUtils.equals(iVar.x(), str2);
        this.k = iVar.p();
        this.l = iVar.d();
    }

    @Override // com.anythink.core.common.res.image.b
    public final Map<String, String> a() {
        return null;
    }

    @Override // com.anythink.core.common.res.image.b
    public final void a(com.anythink.core.common.k.b.b bVar) {
        if (this.b) {
            com.anythink.core.common.k.b.a.a().a(bVar, 6);
        } else {
            com.anythink.core.common.k.b.a.a().a(bVar, 5);
        }
    }

    @Override // com.anythink.core.common.res.image.b
    public final void a(String str, String str2) {
        if (this.j) {
            com.anythink.core.common.j.c.a(this.a, this.k, this.c, "0", this.i, str2, this.e, 0L, this.l, this.h - this.f);
        }
        d.a().a(this.c, com.anythink.basead.c.f.a(str, str2));
    }

    @Override // com.anythink.core.common.res.image.b
    public final boolean a(InputStream inputStream) {
        com.anythink.basead.a.f.a();
        return com.anythink.basead.a.f.a(this.c, inputStream);
    }

    @Override // com.anythink.core.common.res.image.b
    public final void b() {
    }

    @Override // com.anythink.core.common.res.image.b
    public final void c() {
        if (this.j) {
            com.anythink.basead.a.b.a(30, this.m, new com.anythink.basead.c.i("", ""));
            com.anythink.core.common.j.c.a(this.a, this.k, this.c, "1", this.i, (String) null, this.e, this.g, this.l, this.h - this.f);
        }
        d.a().a(this.c, 100);
    }
}

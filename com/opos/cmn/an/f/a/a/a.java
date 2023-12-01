package com.opos.cmn.an.f.a.a;

import android.util.Log;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/f/a/a/a.class */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private com.opos.cmn.an.f.b.b f24507a;
    private int b = -1;

    private void a(int i, String str, String str2) {
        if (i == 1) {
            Log.v(str, str2);
        } else if (i == 2) {
            Log.d(str, str2);
        } else if (i == 3) {
            Log.i(str, str2);
        } else if (i == 4) {
            Log.w(str, str2);
        } else if (i != 5) {
        } else {
            Log.e(str, str2);
        }
    }

    @Override // com.opos.cmn.an.f.a.a.b
    public void a() {
    }

    @Override // com.opos.cmn.an.f.a.a.b
    public void a(int i) {
        this.b = i;
    }

    @Override // com.opos.cmn.an.f.a.a.b
    public void a(com.opos.cmn.an.f.a.b.d dVar) {
        if (dVar == null || dVar.b == null || dVar.f24518a == null) {
            return;
        }
        int i = dVar.d;
        try {
            if (!com.opos.cmn.an.f.a.c.b() || this.b == -1 || i < this.b) {
                return;
            }
            String a2 = com.opos.cmn.an.f.c.b.a(dVar);
            if (a2.length() <= 3072) {
                a(i, this.f24507a.f24530a, a2);
                return;
            }
            int length = a2.length();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (length <= i3) {
                    return;
                }
                int i4 = i3 + 3072;
                if (length <= i4) {
                    i4 = length;
                }
                a(i, this.f24507a.f24530a, a2.substring(i3, i4));
                i2 = i4;
            }
        } catch (Throwable th) {
        }
    }

    @Override // com.opos.cmn.an.f.a.a.b
    public void a(com.opos.cmn.an.f.b.b bVar) {
        int i;
        this.f24507a = bVar;
        try {
            if (com.opos.cmn.an.f.c.b.a()) {
                com.opos.cmn.an.f.a.c.a();
                i = 1;
            } else {
                i = this.f24507a.f24531c;
            }
            this.b = i;
        } catch (Throwable th) {
        }
    }

    @Override // com.opos.cmn.an.f.a.a.b
    public void a(com.opos.cmn.an.f.b.c cVar, com.opos.cmn.an.f.b.a aVar) {
        if (aVar != null) {
            aVar.onDontNeedUpload("basicLog cannot support upload log!");
        }
    }

    @Override // com.opos.cmn.an.f.a.a.b
    public void a(boolean z) {
    }
}

package com.opos.mobad.cmn.service.a;

import android.content.Context;
import android.text.TextUtils;
import com.opos.mobad.d.e;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/cmn/service/a/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f12229a;
    private static final byte[] b = new byte[0];

    /* renamed from: c  reason: collision with root package name */
    private Context f12230c;
    private final int d = 100;
    private Map<Integer, C0515a> e = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.opos.mobad.cmn.service.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/cmn/service/a/a$a.class */
    public class C0515a implements e {
        private c b;

        public C0515a(c cVar) {
            this.b = cVar;
        }

        @Override // com.opos.mobad.d.e
        public void a(int i, int i2, String str, String str2) {
            c cVar = this.b;
            if (cVar != null) {
                cVar.a(i, i2, str, str2);
            }
        }

        @Override // com.opos.mobad.d.e
        public void a(int i, int i2, String str, String str2, String str3) {
            c cVar = this.b;
            if (cVar != null) {
                cVar.a(i, i2, str, str2, str3);
            }
        }

        @Override // com.opos.mobad.d.e
        public void b(int i, int i2, String str, String str2) {
            c cVar = this.b;
            if (cVar != null) {
                cVar.b(i, i2, str, str2);
            }
        }

        @Override // com.opos.mobad.d.e
        public void c(int i, int i2, String str, String str2) {
            c cVar = this.b;
            if (cVar != null) {
                cVar.c(i, i2, str, str2);
            }
        }

        @Override // com.opos.mobad.d.e
        public void d(int i, int i2, String str, String str2) {
            c cVar = this.b;
            if (cVar != null) {
                cVar.d(i, i2, str, str2);
            }
        }

        @Override // com.opos.mobad.d.e
        public void e(int i, int i2, String str, String str2) {
            c cVar = this.b;
            if (cVar != null) {
                cVar.e(i, i2, str, str2);
                a.this.e.remove(Integer.valueOf(this.b.hashCode()));
            }
        }

        @Override // com.opos.mobad.d.e
        public void f(int i, int i2, String str, String str2) {
            c cVar = this.b;
            if (cVar != null) {
                cVar.f(i, i2, str, str2);
            }
        }
    }

    private a(Context context) {
        this.f12230c = context.getApplicationContext();
    }

    public static a a(Context context) {
        a aVar;
        a aVar2 = f12229a;
        if (aVar2 == null) {
            synchronized (b) {
                a aVar3 = f12229a;
                aVar = aVar3;
                if (aVar3 == null) {
                    aVar = new a(context);
                    f12229a = aVar;
                }
            }
            return aVar;
        }
        return aVar2;
    }

    public b a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (com.opos.cmn.an.d.b.a.a(com.opos.cmn.d.a.a(this.f12230c, str))) {
            return new b(105, 100);
        }
        int[] a2 = com.opos.mobad.d.b.a(this.f12230c).a(str, str2);
        return new b(a2[0], a2[1]);
    }

    public void a() {
        com.opos.mobad.d.b.a(this.f12230c).a();
    }

    public void a(int i, boolean z) {
        com.opos.mobad.d.b.a(this.f12230c).a(i, z);
    }

    public void a(c cVar) {
        if (cVar == null) {
            return;
        }
        com.opos.mobad.d.b.a(this.f12230c).a(this.e.remove(Integer.valueOf(cVar.hashCode())));
    }

    public void a(String str) {
        com.opos.mobad.d.b.a(this.f12230c).a(str);
    }

    public void a(String str, String str2, String str3, String str4, c cVar) {
        C0515a c0515a;
        if (cVar != null) {
            C0515a c0515a2 = new C0515a(cVar);
            this.e.put(Integer.valueOf(cVar.hashCode()), c0515a2);
            c0515a = c0515a2;
        } else {
            c0515a = null;
        }
        com.opos.mobad.d.b.a(this.f12230c).a(str, str2, str3, str4, c0515a);
    }

    public void b(String str) {
        com.opos.mobad.d.b.a(this.f12230c).b(str);
    }

    public void c(String str) {
        com.opos.mobad.d.b.a(this.f12230c).c(str);
    }
}

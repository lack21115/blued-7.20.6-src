package com.opos.mobad.service.c;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/c/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f13625a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private d f13626c;
    private a d;

    public static b a() {
        b bVar;
        b bVar2 = f13625a;
        if (bVar2 != null) {
            return bVar2;
        }
        synchronized (b.class) {
            try {
                b bVar3 = f13625a;
                bVar = bVar3;
                if (bVar3 == null) {
                    bVar = new b();
                    f13625a = bVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    private void b() {
        com.opos.cmn.an.f.a.a("Dynamic-Controller", "start to pre load mat");
        if (this.d.a()) {
            this.f13626c.a(this.d.b());
        } else {
            com.opos.cmn.an.f.a.a("Dynamic-Controller", "preload dynamic material but null map");
        }
    }

    public void a(int i) {
        StringBuilder sb;
        String str;
        if (this.d == null) {
            return;
        }
        com.opos.cmn.an.f.a.b("Dynamic-Controller", "loadMaterial template id = " + i);
        if (!this.d.a() || !this.d.a(i)) {
            sb = new StringBuilder();
            str = "no need load template id = ";
        } else if (com.opos.cmn.an.h.c.a.e(this.b)) {
            String b = this.d.b(i);
            if (!TextUtils.isEmpty(b)) {
                this.f13626c.c(b);
                return;
            }
            sb = new StringBuilder();
            sb.append("loadMaterial template id = ");
            sb.append(i);
            sb.append(", but null url");
            com.opos.cmn.an.f.a.b("Dynamic-Controller", sb.toString());
        } else {
            sb = new StringBuilder();
            str = "is not wifi do not download zip ";
        }
        sb.append(str);
        sb.append(i);
        com.opos.cmn.an.f.a.b("Dynamic-Controller", sb.toString());
    }

    public void a(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        this.f13626c = new d(applicationContext);
        this.d = new a();
    }

    public void a(Map<Integer, String> map) {
        a aVar = this.d;
        if (aVar == null) {
            return;
        }
        aVar.a(map);
        b();
    }

    public void b(Context context) {
        d.a(context);
    }

    public boolean b(int i) {
        a aVar = this.d;
        if (aVar == null) {
            return false;
        }
        return aVar.a(i);
    }

    public int c(int i) {
        if (this.d != null && b(i)) {
            String b = this.d.b(i);
            if (TextUtils.isEmpty(b)) {
                com.opos.cmn.an.f.a.b("Dynamic-Controller", "checkDyTemplateFileExist = " + i + ", but null url");
                return 2;
            } else if (this.f13626c.a(b)) {
                com.opos.cmn.an.f.a.b("Dynamic-Controller", "check select template = " + i);
                return 0;
            } else {
                return 3;
            }
        }
        return 1;
    }

    public String d(int i) {
        if (this.d != null && b(i)) {
            String b = this.d.b(i);
            if (TextUtils.isEmpty(b)) {
                com.opos.cmn.an.f.a.b("Dynamic-Controller", "getFilePath = " + i + ", but null url");
                return "";
            }
            return this.f13626c.b(b);
        }
        return "";
    }
}

package com.opos.mobad.cmn.service.b;

import android.content.Context;
import com.opos.cmn.an.j.b;
import com.opos.cmn.d.c;
import com.opos.cmn.i.a;
import com.opos.mobad.e.a.j;
import com.opos.mobad.e.a.m;
import com.opos.mobad.e.a.n;
import com.opos.mobad.service.i.d;
import java.io.File;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/cmn/service/b/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f12233a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private com.opos.cmn.i.a f12234c = new com.opos.cmn.i.a(new a.b() { // from class: com.opos.mobad.cmn.service.b.a.1
        @Override // com.opos.cmn.i.a.b
        public void a(a.InterfaceC0475a interfaceC0475a) {
            a aVar = a.this;
            aVar.a(c.a(aVar.b));
        }
    }, Integer.MAX_VALUE, Integer.MAX_VALUE);

    /* renamed from: com.opos.mobad.cmn.service.b.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/cmn/service/b/a$a.class */
    static class C0516a implements j {
        @Override // com.opos.mobad.e.a.j
        public void a(Context context, String str, String str2, String str3) {
        }

        @Override // com.opos.mobad.e.a.j
        public void a(Context context, Map<String, String> map) {
            try {
                com.opos.cmn.an.f.a.b("interaction", "dy-mat report", map);
                d.a().a(map);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("interaction", "", (Throwable) e);
            }
        }
    }

    private a() {
    }

    public static final a a() {
        a aVar;
        if (f12233a != null) {
            return f12233a;
        }
        synchronized (a.class) {
            try {
                aVar = f12233a;
                if (f12233a == null) {
                    aVar = new a();
                    f12233a = aVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    private File a(Context context, File file) {
        File file2 = new File(c.a(context));
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return new File(file2, b(file));
    }

    private String b(File file) {
        return file.getName() + "_" + System.currentTimeMillis();
    }

    private static void c(final File file) {
        b.c(new Runnable() { // from class: com.opos.mobad.cmn.service.b.a.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.d(file);
                    com.opos.cmn.an.f.a.b("interaction", "clear succ");
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.b("", "clear temp fail", e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles.length > 0) {
                int length = listFiles.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    d(listFiles[i2]);
                    i = i2 + 1;
                }
            }
        }
        file.delete();
    }

    public File a(Context context, String str) {
        File file;
        File file2 = new File(str);
        if (file2.exists()) {
            File a2 = a(context, file2);
            file = a2;
            if (!a2.exists()) {
                a2.mkdirs();
                return a2;
            }
        } else {
            file = null;
        }
        return file;
    }

    public void a(Context context, String str, String str2) {
        this.b = context;
        this.f12234c.a();
        n.a(context.getApplicationContext(), str, str2, new m.a().a(new C0516a()).a());
    }

    public void a(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                File file2 = new File(str + "_dirty");
                if (file2.exists()) {
                    com.opos.cmn.an.f.a.b("interaction", "rn but exists");
                } else if (!file.renameTo(file2)) {
                    com.opos.cmn.an.f.a.b("interaction", "rn fail");
                    return;
                }
                c(file2);
            }
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.b("interaction", "clear temp fail", th);
        }
    }
}

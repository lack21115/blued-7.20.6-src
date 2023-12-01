package com.igexin.push.e;

import android.content.ContentValues;
import android.text.TextUtils;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.core.ServiceManager;
import com.igexin.push.core.d;
import com.igexin.push.core.e.f;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/e/g.class */
public class g implements com.igexin.push.e.b.c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile g f23622a;
    private static String b = "Type10Task";

    /* renamed from: c  reason: collision with root package name */
    private SimpleDateFormat f23623c = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);

    static /* synthetic */ String a(String str) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date()) + "|" + com.igexin.push.core.e.A + "|" + com.igexin.push.core.e.f23495a + "|3|" + str + "|" + com.igexin.push.core.e.C + "|" + ServiceManager.getInstance().initType.first;
    }

    private static String b(String str) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date()) + "|" + com.igexin.push.core.e.A + "|" + com.igexin.push.core.e.f23495a + "|3|" + str + "|" + com.igexin.push.core.e.C + "|" + ServiceManager.getInstance().initType.first;
    }

    public static g c() {
        if (f23622a == null) {
            synchronized (g.class) {
                try {
                    if (f23622a == null) {
                        f23622a = new g();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f23622a;
    }

    private void f() {
        if (com.igexin.push.core.e.ax == 0) {
            return;
        }
        try {
            String format = this.f23623c.format(new Date(com.igexin.push.core.e.ax));
            String format2 = this.f23623c.format(new Date());
            Date parse = this.f23623c.parse(format);
            Date parse2 = this.f23623c.parse(format2);
            String str = b;
            com.igexin.c.a.c.a.b(str, " lastDateString = " + format + " ; nowDateString = " + format2);
            if (parse2.after(parse)) {
                d();
            }
        } catch (ParseException e) {
            com.igexin.c.a.c.a.a(e);
        }
    }

    @Override // com.igexin.push.e.b.c
    public final void a() {
        if (com.igexin.push.core.e.ax != 0) {
            try {
                String format = this.f23623c.format(new Date(com.igexin.push.core.e.ax));
                String format2 = this.f23623c.format(new Date());
                Date parse = this.f23623c.parse(format);
                Date parse2 = this.f23623c.parse(format2);
                String str = b;
                com.igexin.c.a.c.a.b(str, " lastDateString = " + format + " ; nowDateString = " + format2);
                if (parse2.after(parse)) {
                    d();
                }
            } catch (ParseException e) {
                com.igexin.c.a.c.a.a(e);
            }
        }
    }

    @Override // com.igexin.push.e.b.c
    public final void a(long j) {
    }

    @Override // com.igexin.push.e.b.c
    public final boolean b() {
        return com.igexin.push.config.d.q;
    }

    public final void d() {
        final long currentTimeMillis = System.currentTimeMillis();
        final String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(currentTimeMillis));
        if (!com.igexin.push.config.d.q) {
            com.igexin.c.a.c.a.b(b, "upload type10 enabel false");
            return;
        }
        int i = TextUtils.isEmpty(com.igexin.push.core.e.A) ? com.igexin.push.config.d.af * 1000 : 0;
        com.igexin.c.a.c.a.b(b, "upload type10 delay time = ".concat(String.valueOf(i)));
        com.igexin.push.core.d unused = d.a.f23474a;
        com.igexin.push.core.d.a(new com.igexin.push.e.b.f(i) { // from class: com.igexin.push.e.g.1
            @Override // com.igexin.push.e.b.f
            public final void b() {
                try {
                    synchronized (g.class) {
                        if (currentTimeMillis - com.igexin.push.core.e.ax <= 60000) {
                            com.igexin.c.a.c.a.b(g.b, "upload type10 in 1m");
                            return;
                        }
                        com.igexin.push.core.e.ax = currentTimeMillis;
                        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new f.AnonymousClass24(), false, true);
                        com.igexin.push.core.c.a.a();
                        String a2 = g.a(format);
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("type", (Integer) 10);
                        contentValues.put("data", a2);
                        contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
                        d.a.f23474a.i.a(com.igexin.push.core.b.ab, contentValues);
                        StringBuilder sb = new StringBuilder();
                        com.igexin.push.core.c.a.a();
                        List<com.igexin.push.core.b.c> c2 = com.igexin.push.core.c.a.c();
                        final ArrayList arrayList = new ArrayList();
                        for (com.igexin.push.core.b.c cVar : c2) {
                            arrayList.add(String.valueOf(cVar.f23433a));
                            sb.append(cVar.b);
                            sb.append("\n");
                        }
                        if (sb.length() > 0) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        com.igexin.c.a.c.a.b(g.b, "upload type10 data = ".concat(String.valueOf(sb)));
                        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.e.a.a(new com.igexin.push.core.h.e(SDKUrlConfig.getBiUploadServiceUrl(), sb.toString().getBytes()) { // from class: com.igexin.push.e.g.1.1
                            @Override // com.igexin.push.core.h.e, com.igexin.push.e.a.d
                            public final void a(byte[] bArr) throws Exception {
                                super.a(bArr);
                                com.igexin.push.core.c.a.a();
                                ArrayList arrayList2 = arrayList;
                                d.a.f23474a.i.a(com.igexin.push.core.b.ab, new String[]{"id"}, (String[]) arrayList2.toArray(new String[arrayList2.size()]));
                            }
                        }), false, true);
                    }
                } catch (Throwable th) {
                    com.igexin.c.a.c.a.a(th);
                }
            }

            @Override // com.igexin.c.a.d.a.e
            public final int c() {
                return 0;
            }
        });
    }
}

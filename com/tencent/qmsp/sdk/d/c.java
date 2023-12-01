package com.tencent.qmsp.sdk.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.google.android.material.timepicker.TimeModel;
import com.tencent.qmsp.sdk.a.f;
import com.tencent.qmsp.sdk.d.d;
import com.tencent.qmsp.sdk.f.g;
import com.tencent.qmsp.sdk.f.h;
import com.tencent.qmsp.sdk.f.k;
import com.umeng.analytics.pro.at;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/d/c.class */
public class c implements Handler.Callback {
    private SharedPreferences h;
    private com.tencent.qmsp.sdk.d.b i;

    /* renamed from: a  reason: collision with root package name */
    private ConcurrentHashMap<String, com.tencent.qmsp.sdk.b.b> f24891a = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    final Object f24892c = new Object();
    private int d = 0;
    private d.b e = null;
    private String f = "";
    private String g = "";
    private int j = 0;
    private Handler b = new Handler(com.tencent.qmsp.sdk.app.b.e().b(), this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/d/c$a.class */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/d/c$b.class */
    public class b implements com.tencent.qmsp.sdk.b.e {
        b() {
        }

        @Override // com.tencent.qmsp.sdk.b.e
        public void a(int i, JSONObject jSONObject) {
            if (i != 161 || jSONObject == null) {
                return;
            }
            c.this.a(i, jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.qmsp.sdk.d.c$c  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/d/c$c.class */
    public static class C0818c {

        /* renamed from: a  reason: collision with root package name */
        public int f24895a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        public String f24896c;
        public String d;
        public String e;
        public String f;
        public int g;
        public boolean h;
        public int i;
        public long j;
        public int k;

        public C0818c(int i, int i2, String str, String str2, String str3, String str4, int i3, boolean z, int i4, long j, int i5) {
            this.f24895a = i;
            this.b = i2;
            this.f24896c = str;
            this.d = str2;
            this.e = str3;
            this.f = str4;
            this.g = i3;
            this.h = z;
            this.i = i4;
            this.j = j;
            this.k = i5;
        }

        public String toString() {
            return "filePath=" + this.f24896c + ",fileName=" + this.d + ",fileId=" + this.b + ",fileUrl=" + this.e + ",fileHash=" + this.f + ",fileVersion=" + this.g + ",zipFlag=" + this.h + ",startTime=" + this.j + ",tryTimes=" + this.i + ",downloadFlag=" + this.k;
        }
    }

    public c(Context context) {
        this.h = null;
        this.i = null;
        this.h = context.getSharedPreferences(com.tencent.qmsp.sdk.c.b.f24856a + a(d.b), 0);
        this.i = new com.tencent.qmsp.sdk.d.b();
    }

    private int a(int i, String str) {
        String a2;
        try {
            if (i == 0) {
                g.a("Qp.QUM", 1, "No matched update from server.");
                return -1;
            } else if (this.h.getInt(a(d.d), 0) < i) {
                return 0;
            } else {
                String c2 = c();
                if (new File(c2).exists() && (a2 = com.tencent.qmsp.sdk.d.a.a(c2)) != null && a2.equalsIgnoreCase(str)) {
                    return (a2 == null || !a2.equalsIgnoreCase(str)) ? -1 : 1;
                }
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    private String a(byte[] bArr) {
        return h.a(bArr);
    }

    private void a(int i, int i2) {
        String appID;
        try {
            JSONObject a2 = com.tencent.qmsp.sdk.a.d.a(2);
            if (a2 == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.tencent.qmsp.sdk.a.e.a(20), i);
            jSONObject.put(com.tencent.qmsp.sdk.a.e.a(21), i2);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(com.tencent.qmsp.sdk.a.e.a(15), a2);
            jSONObject2.put(com.tencent.qmsp.sdk.a.e.a(16), jSONObject);
            StringBuilder sb = new StringBuilder();
            sb.append("[SFU] request : ");
            sb.append(jSONObject2.toString());
            g.d("Qp.QUM", 0, sb.toString());
            com.tencent.qmsp.sdk.b.g b2 = com.tencent.qmsp.sdk.b.g.b();
            appID = com.tencent.qmsp.sdk.app.a.getAppID();
            b2.a(2, appID, 2, jSONObject2, new b());
            a("0X80078AA", i, this.j, "", "");
            g.a("Qp.QUM", 1, String.format("[SFU] send update query: fileid=%d, localversion=%d", Integer.valueOf(i), Integer.valueOf(i2)));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(String str, int i, int i2, String str2, String str3) {
        String format = String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(i));
        d.b bVar = this.e;
        int i3 = bVar != null ? (int) bVar.b : 0;
        d.b bVar2 = this.e;
        String format2 = bVar2 != null ? String.format(TimeModel.NUMBER_FORMAT, Long.valueOf(bVar2.f24901a)) : "";
        g.a("Qp.QUM", 1, String.format("[SFU] report: actiontype=%s, actionname=%s, actionfrom=%d, actionresult=%d, sectionId=%s, reportId=%s, fileInfo: %s", str, str, Integer.valueOf(i3), Integer.valueOf(this.d), format2, format, "", ""));
        com.tencent.qmsp.sdk.a.g gVar = new com.tencent.qmsp.sdk.a.g();
        try {
            gVar.a(str).a(format).a(format2).a(this.d).a(i2).a(str2).a(str3);
            f.a(gVar.toString(), 2);
        } catch (Exception e) {
            e.printStackTrace();
            g.b(g.f24913a, 0, "onReport error! <JsonObject userData>!");
        }
    }

    private void a(boolean z, com.tencent.qmsp.sdk.b.b bVar) {
        int i;
        if (!z || bVar == null) {
            a(3);
            return;
        }
        File file = new File(bVar.b);
        C0818c c0818c = (C0818c) bVar.a();
        if (!file.exists() || c0818c == null) {
            a(3);
            return;
        }
        g.a("Qp.QUM", 1, String.format("[SFU] http download complete: %s, %s", bVar.b, c0818c.e));
        int i2 = c0818c.f24895a;
        if (i2 == 1) {
            File file2 = new File(c());
            new File(bVar.b).renameTo(file2);
            a("0X80078AC", c0818c.g, this.j, "", "");
            if (!this.i.a(file2.toString())) {
                a("0X80078AD", c0818c.g, this.j, c0818c.d, c0818c.e);
                g.a("Qp.QUM", 1, "[SFU] invalid config (sig not accepted)");
                a(1);
                return;
            }
            this.h.edit().putInt(a(d.d), c0818c.g).commit();
            if (this.i.a().isEmpty()) {
                g.a("Qp.QUM", 1, "[SFU] config ok but without any sections");
                i = 16;
            } else {
                i = 5;
            }
        } else if (i2 != 2) {
            return;
        } else {
            a("0X80078AE", c0818c.g, this.j, "", "");
            i = 7;
        }
        b(i);
    }

    private boolean a(C0818c c0818c) {
        Context context;
        if (c0818c == null) {
            return false;
        }
        if (c0818c.f24895a == 2 && c0818c.k != 1) {
            context = com.tencent.qmsp.sdk.app.a.getContext();
            if (!com.tencent.qmsp.sdk.f.f.b(context)) {
                g.a("Qp.QUM", 1, "[SFU] donot download file because not using wifi");
                com.tencent.qmsp.sdk.a.a.a(3, 3);
                return false;
            }
        }
        if (c0818c.i >= 3 || !this.f24891a.contains(c0818c.f.toLowerCase())) {
            com.tencent.qmsp.sdk.b.b bVar = new com.tencent.qmsp.sdk.b.b();
            bVar.f24838a = c0818c.e;
            bVar.b = c0818c.f24896c + c0818c.d;
            bVar.d = c0818c.d;
            bVar.f24839c = c0818c.f24896c;
            c0818c.i = c0818c.i + 1;
            bVar.a(c0818c);
            this.f24891a.put(c0818c.f.toLowerCase(), bVar);
            try {
                com.tencent.qmsp.sdk.b.d.a(bVar);
            } catch (IOException e) {
                e.printStackTrace();
            }
            g.a("Qp.QUM", 1, String.format("[SFU] begin http download %s", c0818c.e));
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00eb, code lost:
        if (r10.r == r12) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(com.tencent.qmsp.sdk.d.d.b r10) {
        /*
            Method dump skipped, instructions count: 271
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qmsp.sdk.d.c.a(com.tencent.qmsp.sdk.d.d$b):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x00f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(java.io.File r7, java.io.File r8) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qmsp.sdk.d.c.a(java.io.File, java.io.File):boolean");
    }

    private void b() {
        try {
            this.h.edit().putLong(a(d.f24898c), System.currentTimeMillis()).commit();
            b(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void b(int i) {
        int i2;
        int i3;
        int i4;
        g.a("Qp.QUM", 2, String.format("[SFU] update event: %d", Integer.valueOf(i)));
        try {
            if (i == 1) {
                if (this.d == 1) {
                    i2 = 17;
                    b(i2);
                }
                i2 = 14;
                b(i2);
            } else if (i == 2) {
                i();
            } else {
                switch (i) {
                    case 5:
                        if (d() && this.e != null) {
                            i2 = 6;
                            if (!e(this.e)) {
                                i2 = 15;
                            }
                            b(i2);
                        }
                        i2 = 16;
                        b(i2);
                    case 6:
                        if (this.e == null || !d(this.e)) {
                            i3 = 3;
                            a(i3);
                            return;
                        }
                        return;
                    case 7:
                        if (this.e != null && n(this.e)) {
                            i2 = 8;
                            b(i2);
                        }
                        a("0X80078AF", 0, this.j, "", "");
                        i3 = 4;
                        a(i3);
                        return;
                    case 8:
                        if (this.e != null && k(this.e)) {
                            i2 = 9;
                            b(i2);
                        }
                        a("0X80078B0", 0, this.j, "", "");
                        i3 = 5;
                        a(i3);
                        return;
                    case 9:
                        if (this.e != null && a(this.e)) {
                            i2 = 10;
                            b(i2);
                        }
                        a("0X80078B1", 0, this.j, "", "");
                        i3 = 6;
                        a(i3);
                        return;
                    case 10:
                        if (this.e != null && l(this.e)) {
                            i2 = 11;
                            b(i2);
                        }
                        i4 = 7;
                        c(i4);
                        i2 = 13;
                        b(i2);
                    case 11:
                        i4 = 8;
                        if (this.e != null) {
                            i4 = 8;
                            if (m(this.e)) {
                                i2 = 12;
                                b(i2);
                            }
                        }
                        c(i4);
                        i2 = 13;
                        b(i2);
                    case 12:
                        i3 = (this.e == null || !c(this.e)) ? 9 : 0;
                        a(i3);
                        return;
                    case 13:
                        if (this.e == null || !j(this.e)) {
                            a("0X80078B3", 0, this.j, "", "");
                            i3 = 10;
                        } else {
                            i3 = 0;
                        }
                        a(i3);
                        return;
                    case 14:
                        if (this.e != null) {
                            b(this.e);
                        }
                        i2 = 15;
                        b(i2);
                    case 15:
                        i(this.e);
                        this.e = null;
                        if (f()) {
                            i2 = 16;
                            b(i2);
                        }
                        i2 = 5;
                        b(i2);
                    case 16:
                        g();
                        i2 = 17;
                        b(i2);
                    case 17:
                        h();
                        return;
                    default:
                        return;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void b(com.tencent.qmsp.sdk.b.c cVar) {
        if (cVar == null) {
            return;
        }
        int i = cVar.f24840a;
        if (i == 2) {
            g.a("Qp.QUM", 1, String.format("[SFU] http download error=%d", Integer.valueOf(i)));
            return;
        }
        C0818c c0818c = (C0818c) cVar.b.a();
        if (c0818c == null) {
            return;
        }
        boolean z = cVar.f24840a == 0;
        if (!z) {
            try {
                if (c0818c.i < 3) {
                    g.a("Qp.QUM", 1, String.format("[SFU] retried to download, retry=%d, result=%b, url=%s", Integer.valueOf(c0818c.i), Boolean.valueOf(z), c0818c.e));
                    a(c0818c);
                    return;
                }
                File file = new File(cVar.b.b);
                if (file.exists()) {
                    file.delete();
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        this.f24891a.remove(c0818c.f.toLowerCase());
        a(z, cVar.b);
    }

    private void b(d.b bVar) {
        if (bVar != null) {
            g.a("Qp.QUM", 1, String.format("[SFU] cleanup: sid=%d", Long.valueOf(bVar.f24901a)));
            com.tencent.qmsp.sdk.f.d.a(g(bVar), false);
        }
    }

    private String c() {
        return e() + a(d.f24897a);
    }

    private void c(int i) {
        this.d = i;
    }

    private boolean c(d.b bVar) {
        return true;
    }

    private boolean d() {
        boolean z;
        this.e = null;
        List<d.b> a2 = this.i.a();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= a2.size()) {
                z = false;
                break;
            }
            d.b bVar = a2.get(i2);
            if (!bVar.a()) {
                if (bVar.m && bVar.l && bVar.n) {
                    this.e = bVar;
                    c(0);
                    g.a("Qp.QUM", 1, String.format("[SFU] next update: sid=%d", Long.valueOf(this.e.f24901a)));
                    z = true;
                    break;
                }
                g.d("Qp.QUM", 1, String.format("[SFU] not matched section: sid=%d, os: %b, qq:%b, cpu:%b", Long.valueOf(bVar.f24901a), Boolean.valueOf(bVar.m), Boolean.valueOf(bVar.l), Boolean.valueOf(bVar.n)));
                bVar.b();
            }
            i = i2 + 1;
        }
        g.a("Qp.QUM", 1, String.format("[SFU] get next section result? %b", Boolean.valueOf(z)));
        return z;
    }

    private boolean d(d.b bVar) {
        if (bVar != null) {
            g.a("Qp.QUM", 1, String.format("[SFU] download package: sid=%d", Long.valueOf(bVar.f24901a)));
            return a(new C0818c(2, 0, g(bVar), bVar.f24902c, bVar.e, bVar.d, 0, true, 0, System.currentTimeMillis(), bVar.u));
        }
        return false;
    }

    private String e() {
        String c2 = com.tencent.qmsp.sdk.a.b.c();
        File file = new File(c2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return c2;
    }

    private boolean e(d.b bVar) {
        if (bVar == null) {
            return false;
        }
        g.a("Qp.QUM", 1, String.format("[SFU] get different: sid=%d", Long.valueOf(bVar.f24901a)));
        List<d.a> list = bVar.o;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                g.a("Qp.QUM", 1, String.format("[SFU] need to update %d files of %d", Integer.valueOf(bVar.q.size()), Integer.valueOf(bVar.o.size())));
                return !bVar.q.isEmpty();
            }
            d.a aVar = list.get(i2);
            if (new File(aVar.f).exists()) {
                String a2 = com.tencent.qmsp.sdk.d.a.a(aVar.f);
                if (a2 == null || !a2.equalsIgnoreCase(aVar.b)) {
                    aVar.j = 1;
                    if (a2 == null) {
                        a2 = "";
                    }
                    aVar.f24900c = a2;
                    bVar.q.add(aVar);
                    bVar.r++;
                }
            } else {
                aVar.j = 2;
                bVar.q.add(aVar);
            }
            i = i2 + 1;
        }
    }

    private String f(d.b bVar) {
        String str = g(bVar) + "bak" + File.separator;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    private boolean f() {
        boolean z;
        List<d.b> a2 = this.i.a();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= a2.size()) {
                z = true;
                break;
            } else if (!a2.get(i2).a()) {
                z = false;
                break;
            } else {
                i = i2 + 1;
            }
        }
        g.a("Qp.QUM", 1, String.format("[SFU] all complete: %s", z ? "yes" : "no"));
        return z;
    }

    private String g(d.b bVar) {
        String str = e() + bVar.f24901a + File.separator;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    private void g() {
        g.a("Qp.QUM", 1, "[SFU] all sections update complete");
        try {
            if (!TextUtils.isEmpty(this.f)) {
                com.tencent.qmsp.sdk.c.f.i().e();
                this.h.edit().putString(a(d.e), this.f).putString(a(d.f), this.g).commit();
                a("0X80078B6", 0, this.j, this.f, this.g);
            }
            g.a("Qp.QUM", 1, String.format("[SFU] notify update complete: %s", this.f));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private String h(d.b bVar) {
        return g(bVar) + bVar.f24902c;
    }

    private void h() {
        synchronized (this.f24892c) {
            a("0X80078B5", 0, this.j, "", "");
            this.e = null;
            g.a("Qp.QUM", 1, "[SFU] update ended");
        }
    }

    private void i() {
        a(1, this.h.getInt(a(d.d), 0));
        this.h.edit().remove(a(d.e)).commit();
    }

    private void i(d.b bVar) {
        if (bVar != null) {
            g.a("Qp.QUM", 1, String.format("[SFU] update complete: sid=%d", Long.valueOf(bVar.f24901a)));
            bVar.b();
            if (j()) {
                this.f += String.format("#%d#", Long.valueOf(bVar.b));
                this.g += String.format("#%d#", Long.valueOf(bVar.f24901a));
            }
            a("0X80078B4", 0, this.j, "", "");
        }
    }

    private boolean j() {
        return this.d == 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x012e, code lost:
        if (r15 == r10.p.size()) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean j(com.tencent.qmsp.sdk.d.d.b r10) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qmsp.sdk.d.c.j(com.tencent.qmsp.sdk.d.d$b):boolean");
    }

    private boolean k(d.b bVar) {
        boolean z;
        if (bVar != null) {
            g.a("Qp.QUM", 1, String.format("[SFU] unzip package: sid=%d", Long.valueOf(bVar.f24901a)));
            String g = g(bVar);
            File file = new File(g);
            if (!file.exists()) {
                file.mkdir();
            }
            if (k.a(h(bVar), g) == 0) {
                z = true;
                g.a("Qp.QUM", 1, String.format("[SFU] unzip result: %b", Boolean.valueOf(z)));
                return z;
            }
        }
        z = false;
        g.a("Qp.QUM", 1, String.format("[SFU] unzip result: %b", Boolean.valueOf(z)));
        return z;
    }

    private boolean l(d.b bVar) {
        boolean z;
        if (bVar != null && !bVar.q.isEmpty()) {
            g.a("Qp.QUM", 1, String.format("[SFU] do update files: sid=%d", Long.valueOf(bVar.f24901a)));
            String g = g(bVar);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= bVar.q.size()) {
                    break;
                }
                d.a aVar = bVar.q.get(i2);
                File file = new File(g, aVar.b);
                File file2 = new File(aVar.f);
                if (file.exists() && file.canRead()) {
                    boolean a2 = a(file, file2);
                    boolean z2 = a2;
                    if (!a2) {
                        String str = aVar.f + ".1";
                        File file3 = new File(str);
                        aVar.j = 3;
                        aVar.g = str;
                        boolean a3 = a(file, file3);
                        g.a("Qp.QUM", 1, String.format("[SFU] copied failed, renamed to: %s", aVar.g));
                        z2 = a3;
                        if (a3) {
                            this.h.edit().putString(aVar.f, aVar.g).commit();
                            z2 = a3;
                        }
                    }
                    if (!z2) {
                        a("0X80078B2", (int) aVar.h, this.j, aVar.f24899a, aVar.b);
                        g.a("Qp.QUM", 1, String.format("[SFU] failed copied: %s", aVar.f));
                        break;
                    }
                    g.a("Qp.QUM", 1, String.format("[SFU] success copied: %s", aVar.f));
                    bVar.p.add(aVar);
                    bVar.s++;
                } else {
                    g.a("Qp.QUM", 1, String.format("[SFU] copied failed, src not existed or cannot read: %s", file.toString()));
                }
                i = i2 + 1;
            }
            g.a("Qp.QUM", 1, String.format("[SFU] update %d files of %d", Long.valueOf(bVar.s), Integer.valueOf(bVar.q.size())));
            if (bVar.s == bVar.q.size()) {
                z = true;
                g.a("Qp.QUM", 1, String.format("[SFU] update result: %b", Boolean.valueOf(z)));
                return z;
            }
        }
        z = false;
        g.a("Qp.QUM", 1, String.format("[SFU] update result: %b", Boolean.valueOf(z)));
        return z;
    }

    private boolean m(d.b bVar) {
        boolean z;
        d.a aVar;
        String a2;
        if (bVar != null) {
            g.a("Qp.QUM", 1, String.format("[SFU] verify: sid=%d", Long.valueOf(bVar.f24901a)));
            if (bVar.q.isEmpty()) {
                g.a("Qp.QUM", 1, String.format("[SFU] no diff: sid=%d", Long.valueOf(bVar.f24901a)));
            } else {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= bVar.q.size()) {
                        break;
                    }
                    aVar = bVar.q.get(i2);
                    a2 = com.tencent.qmsp.sdk.d.a.a(TextUtils.isEmpty(aVar.g) ? aVar.f : aVar.g);
                    if (a2 == null || !a2.equalsIgnoreCase(aVar.b)) {
                        break;
                    }
                    i = i2 + 1;
                }
                g.a("Qp.QUM", 1, String.format("[SFU] not matched: %s!=%s, sid=%d", a2, aVar.b, Long.valueOf(bVar.f24901a)));
            }
            z = true;
            g.a("Qp.QUM", 1, String.format("[SFU] verify result: %b", Boolean.valueOf(z)));
            return z;
        }
        z = false;
        g.a("Qp.QUM", 1, String.format("[SFU] verify result: %b", Boolean.valueOf(z)));
        return z;
    }

    private boolean n(d.b bVar) {
        boolean z;
        if (bVar != null) {
            g.a("Qp.QUM", 1, String.format("[SFU] verify package: sid=%d", Long.valueOf(bVar.f24901a)));
            String a2 = com.tencent.qmsp.sdk.d.a.a(h(bVar));
            if (a2 == null) {
                return false;
            }
            z = a2.equalsIgnoreCase(bVar.d);
        } else {
            z = false;
        }
        g.a("Qp.QUM", 1, String.format("[SFU] verify result: %b", Boolean.valueOf(z)));
        return z;
    }

    public void a() {
        boolean taskStatus;
        AtomicInteger atomUpdateInterval;
        AtomicInteger atomUpdateInterval2;
        AtomicInteger atomUpdateInterval3;
        long j;
        AtomicInteger atomUpdateInterval4;
        taskStatus = com.tencent.qmsp.sdk.app.a.getTaskStatus();
        if (!taskStatus) {
            g.a("Qp.QUM", 1, "[SFU] Plugin Update Task Finish！");
        } else if (!com.tencent.qmsp.sdk.c.f.i().a(1001).booleanValue()) {
            atomUpdateInterval4 = com.tencent.qmsp.sdk.app.a.getAtomUpdateInterval();
            a(atomUpdateInterval4.get());
        } else {
            long j2 = 0;
            long j3 = this.h.getLong(a(d.f24898c), 0L);
            long currentTimeMillis = System.currentTimeMillis() - j3;
            if (currentTimeMillis >= 0) {
                j2 = currentTimeMillis;
            }
            atomUpdateInterval = com.tencent.qmsp.sdk.app.a.getAtomUpdateInterval();
            long j4 = atomUpdateInterval.get();
            g.a("Qp.QUM", 2, String.format("[SFU] startSFU last time: %d, interval: %d", Long.valueOf(j3), Long.valueOf(j2)));
            atomUpdateInterval2 = com.tencent.qmsp.sdk.app.a.getAtomUpdateInterval();
            if (j2 >= atomUpdateInterval2.get()) {
                b();
                j = j4;
            } else {
                atomUpdateInterval3 = com.tencent.qmsp.sdk.app.a.getAtomUpdateInterval();
                j = atomUpdateInterval3.get() - j2;
                g.a("Qp.QUM", 0, "[SFU] next time: " + j);
            }
            a(j);
        }
    }

    protected void a(int i) {
        g.b("Qp.QUM", 2, String.format("[SFU] update error: %d", Integer.valueOf(i)));
        switch (i) {
            case 1:
                File file = new File(c());
                if (file.exists()) {
                    file.delete();
                    break;
                }
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
                c(i);
                break;
        }
        b(1);
    }

    public void a(int i, Object obj) {
        String format;
        try {
            JSONObject jSONObject = (JSONObject) obj;
            StringBuilder sb = new StringBuilder();
            sb.append("[SFU] rcv : ");
            sb.append(obj);
            g.a("Qp.QUM", 0, sb.toString());
            boolean z = false;
            if (jSONObject != null) {
                int optInt = jSONObject.optInt("st");
                int intValue = Integer.valueOf(jSONObject.optString("tsi")).intValue();
                this.j = intValue;
                a("0X80078B8", optInt, intValue, "", "");
                if (optInt == 0) {
                    int optInt2 = jSONObject.optInt("sc");
                    int optInt3 = jSONObject.optInt("fi");
                    int optInt4 = jSONObject.optInt("fv");
                    String str = (String) jSONObject.opt("fh");
                    String str2 = (String) jSONObject.opt("fu");
                    int optInt5 = jSONObject.optInt(at.g);
                    boolean z2 = optInt5 == 1;
                    int a2 = a(optInt4, str);
                    int i2 = 5;
                    g.a("Qp.QUM", 1, String.format("[SFU] resp: cmd=%d, status=%d, fileid=%d, fileversion=%d, md5=%s, url=%s, zipped: %d", Integer.valueOf(optInt2), Integer.valueOf(optInt), Integer.valueOf(optInt3), Integer.valueOf(optInt4), str, str2, Integer.valueOf(optInt5)));
                    if (a2 == 0) {
                        a("0X80078AB", optInt3, this.j, "", "");
                        g.a("Qp.QUM", 1, String.format("Need to update config file, fileid=%d", Integer.valueOf(optInt3)));
                        z = a(new C0818c(1, optInt3, e(), a(d.f24897a), str2, str, optInt4, z2, 0, System.currentTimeMillis(), 1));
                    } else if (a2 == 1) {
                        z = false;
                        if (this.i.a(new File(c()).toString())) {
                            if (this.i.a().isEmpty()) {
                                i2 = 16;
                            }
                            b(i2);
                            z = true;
                        }
                    } else {
                        format = "[SFU] NO Need UPDATE";
                    }
                } else {
                    format = String.format("[SFU] Server replied with error, status=%d", Integer.valueOf(optInt));
                }
                g.a("Qp.QUM", 1, format);
                z = false;
            }
            if (z) {
                return;
            }
            b(17);
        } catch (Exception e) {
            e.printStackTrace();
            b(17);
        }
    }

    public void a(long j) {
        com.tencent.qmsp.sdk.c.f.i().c().postDelayed(new a(), j);
    }

    public void a(com.tencent.qmsp.sdk.b.c cVar) {
        Handler handler = this.b;
        if (handler != null) {
            handler.obtainMessage(1052688, cVar).sendToTarget();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1052688) {
            return false;
        }
        b((com.tencent.qmsp.sdk.b.c) message.obj);
        return false;
    }
}

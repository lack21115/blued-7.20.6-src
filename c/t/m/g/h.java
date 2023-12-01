package c.t.m.g;

import android.net.wifi.ScanResult;
import android.os.Looper;
import android.os.Message;
import android.util.Base64;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/h.class */
public class h extends c2 implements s1, Runnable {
    public volatile r1 h;
    public File i;
    public volatile boolean e = false;
    public String j = "wf4_bf";
    public String k = "wf4";
    public StringBuilder l = new StringBuilder(100);
    public p0 g = new p0(8192, 5);
    public List<String> f = new ArrayList();

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/h$a.class */
    public class a implements t1 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ File f3824a;

        public a(h hVar, File file) {
            this.f3824a = file;
        }

        @Override // c.t.m.g.t1
        public void a(String str) {
            g3.a();
        }

        @Override // c.t.m.g.t1
        public void b(String str) {
            this.f3824a.delete();
            g3.a();
        }
    }

    public h(File file) {
        this.i = file;
        if (g3.a()) {
            this.i.getAbsolutePath();
        }
    }

    @Override // c.t.m.g.f2
    public int a(Looper looper) {
        a(100, 0L);
        return 0;
    }

    @Override // c.t.m.g.f2
    public String a() {
        return "WifiInfoPro";
    }

    public final String a(ScanResult scanResult) {
        this.l.setLength(0);
        try {
            StringBuilder sb = this.l;
            sb.append(scanResult.BSSID);
            sb.append(',');
            StringBuilder sb2 = this.l;
            sb2.append(Base64.encodeToString(scanResult.SSID.getBytes("UTF-8"), 2));
            sb2.append(',');
            StringBuilder sb3 = this.l;
            sb3.append(scanResult.frequency);
            sb3.append(',');
            this.l.append(Base64.encodeToString(scanResult.capabilities.getBytes("UTF-8"), 2));
        } catch (Throwable th) {
            this.l.setLength(0);
        }
        return this.l.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0141, code lost:
        if (c.t.m.g.j.g != false) goto L60;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01a3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01a4  */
    @Override // c.t.m.g.c2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.os.Message r9) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 650
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.h.a(android.os.Message):void");
    }

    public void a(List<ScanResult> list) {
        if (!b() || m3.a((Collection) list)) {
            return;
        }
        Message obtainMessage = d().obtainMessage(102);
        obtainMessage.obj = list;
        a(obtainMessage, 0L);
    }

    @Override // c.t.m.g.s1
    public byte[] a(byte[] bArr) {
        byte[] a2 = v2.a(r2.a(bArr), v2.a("fc_wf_up"));
        if (!m3.a(a2)) {
            byte[] encode = Base64.encode(a2, 2);
            if (!m3.a(encode)) {
                String str = new String(encode);
                try {
                    return (str + '$').getBytes("UTF-8");
                } catch (Throwable th) {
                }
            }
        }
        return new byte[0];
    }

    public final void b(List<String> list) throws IOException {
        if (this.e || m3.a((Collection) list) || m3.a(this.h)) {
            return;
        }
        long length = this.h.b().length();
        g3.a();
        if (length <= 51200) {
            StringBuilder sb = new StringBuilder(500);
            sb.append("1|");
            sb.append(list.size());
            for (String str : list) {
                sb.append('|');
                sb.append(str);
            }
            this.h.a(sb.toString());
        }
        list.clear();
    }

    @Override // c.t.m.g.f2
    public void c() {
        c3.b(d());
        a(101, 0L);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.e = true;
            if (this.h != null) {
                this.h.a();
                this.h = null;
            }
            File file = new File(this.i, this.k);
            if (g3.a()) {
                file.getName();
                file.length();
            }
            byte[] a2 = r2.a(z2.b(file));
            String str = j.h ? "https://testdatalbs.sparta.html5.qq.com/tr?wf4" : "https://analytics.map.qq.com/?wf4";
            String str2 = str;
            if (!j.e) {
                str2 = str.replace("https:", "http:");
            }
            j.k.a(str2, a2, new a(this, file));
            if (b()) {
                this.h = new r1(new File(this.i, this.k));
                this.h.a(this);
            }
        } catch (Throwable th) {
        }
        this.e = false;
    }
}

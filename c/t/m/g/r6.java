package c.t.m.g;

import android.Manifest;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.ContactsContract;
import androidx.core.content.PermissionChecker;
import c.t.m.g.d3;
import c.t.m.g.j3;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/r6.class */
public class r6 extends d2 {
    public static volatile r6 g;
    public static String h = "";
    public static volatile String i = "";
    public static final AtomicBoolean j = new AtomicBoolean(false);
    public a d;

    /* renamed from: c  reason: collision with root package name */
    public SimpleDateFormat f3917c = t2.b("HHmmss");
    public boolean e = false;
    public HashSet<String> f = new HashSet<>();

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/r6$a.class */
    public class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public StringBuffer f3918a;
        public long b;

        public a(Looper looper) {
            super(looper);
            this.f3918a = new StringBuffer(18432);
        }

        public void a() {
            StringBuffer stringBuffer = this.f3918a;
            stringBuffer.append('$');
            stringBuffer.append(r6.this.f3917c.format(new Date()) + ",LOC,shutdown");
            String stringBuffer2 = this.f3918a.toString();
            this.f3918a.setLength(0);
            r6.this.a(stringBuffer2, true);
            c3.b(r6.this.d);
        }

        public final void a(Message message) {
            switch (message.what) {
                case 101:
                    removeMessages(101);
                    this.b = System.currentTimeMillis();
                    String stringBuffer = this.f3918a.toString();
                    this.f3918a.setLength(0);
                    StringBuffer stringBuffer2 = this.f3918a;
                    stringBuffer2.append("LOC_CORE");
                    stringBuffer2.append(',');
                    stringBuffer2.append(r6.i());
                    if (!m3.a(stringBuffer)) {
                        this.f3918a.append(stringBuffer);
                    }
                    r6.this.b("SYSTEM", r6.j());
                    removeMessages(102);
                    c3.a(r6.this.d, 102, (long) com.igexin.push.config.c.l);
                    r6 r6Var = r6.this;
                    r6Var.b("PERMISSION", r6Var.a(q2.a()));
                    return;
                case 102:
                    removeMessages(102);
                    c3.a(r6.this.d, 102, (long) com.igexin.push.config.c.l);
                    r6 r6Var2 = r6.this;
                    r6Var2.b("PERMISSION", r6Var2.a(q2.a()));
                    return;
                case 103:
                    StringBuffer stringBuffer3 = this.f3918a;
                    stringBuffer3.append('$');
                    stringBuffer3.append((String) message.obj);
                    if (this.f3918a.length() < 18432 && System.currentTimeMillis() - this.b < 180000) {
                        return;
                    }
                    r6.this.a(this.f3918a.toString(), false);
                    this.f3918a.setLength(0);
                    c3.b(r6.this.d, 101);
                    return;
                case 104:
                    r6.this.a("", true);
                    return;
                case 105:
                    r6.this.a(this.f3918a.toString(), false);
                    this.f3918a.setLength(0);
                    c3.b(r6.this.d, 101);
                    return;
                case 106:
                    removeMessages(106);
                    this.f3918a.insert(0, (String) message.obj);
                    return;
                default:
                    return;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                a(message);
            } catch (Throwable th) {
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/r6$b.class */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public String f3920a;
        public boolean b;

        /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/r6$b$a.class */
        public class a implements d3.c {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ byte[] f3922a;
            public final /* synthetic */ boolean[] b;

            public a(b bVar, byte[] bArr, boolean[] zArr) {
                this.f3922a = bArr;
                this.b = zArr;
            }

            @Override // c.t.m.g.d3.c
            public void a(String str) {
                try {
                    File file = new File(q2.a().getExternalFilesDir("data").getAbsolutePath() + "/mllc");
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    z2.a(new File(file, "mllc_" + System.currentTimeMillis() + ".enc"), this.f3922a, true);
                } catch (Throwable th) {
                }
                this.b[0] = false;
            }

            @Override // c.t.m.g.d3.c
            public void b(String str) {
            }
        }

        public b(String str, boolean z) {
            this.f3920a = "";
            this.b = false;
            this.f3920a = str;
            this.b = z;
        }

        public final void a() {
            long j;
            boolean z;
            j3.a b = j3.b();
            try {
                File file = new File(q2.a().getExternalFilesDir("data").getAbsolutePath() + "/mllc");
                File[] listFiles = file.listFiles();
                if (m3.c(listFiles)) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                int length = listFiles.length;
                long j2 = 0;
                int i = 0;
                while (true) {
                    int i2 = i;
                    j = j2;
                    if (i2 >= length) {
                        break;
                    }
                    File file2 = listFiles[i2];
                    if (b != j3.a.NETWORK_WIFI && j2 >= 102400) {
                        j = j2;
                        break;
                    }
                    if (a(file2, currentTimeMillis)) {
                        byte[] b2 = z2.b(file2);
                        if (m3.a(b2)) {
                            z = true;
                        } else {
                            j2 += b2.length;
                            z = a(b2, false);
                            file2.getName();
                            int length2 = b2.length;
                        }
                        if (!z) {
                            z2.a(file.getAbsolutePath(), 10485760L);
                            j = j2;
                            break;
                        }
                        file2.delete();
                    }
                    i = i2 + 1;
                }
                r6.this.b("NET", b + ",up file len:" + j);
            } catch (Throwable th) {
            }
        }

        public final boolean a(File file, long j) {
            if (file == null || !file.exists()) {
                return false;
            }
            if (j - file.lastModified() >= ContactsContract.DeletedContacts.DAYS_KEPT_MILLISECONDS) {
                file.delete();
                return false;
            }
            return true;
        }

        public final boolean a(byte[] bArr, boolean z) {
            try {
                if (m3.a(bArr)) {
                    return true;
                }
                byte[] a2 = z ? s6.a(bArr, "0PEq^X$sjtWqEqa2$dg4TG2PT^4dFEep") : bArr;
                if (m3.a(a2)) {
                    return true;
                }
                r6.this.b("NET", "[src,enc]=[" + bArr.length + "," + a2.length + "],type=" + j3.a());
                boolean[] zArr = new boolean[1];
                zArr[0] = true;
                d3.a("https://analytics.map.qq.com/tr?mllc", a2, new a(this, a2, zArr));
                return zArr[0];
            } catch (Throwable th) {
                return false;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!m3.a(this.f3920a)) {
                try {
                    a(this.f3920a.getBytes("utf-8"), true);
                } catch (Exception e) {
                }
            }
            if (!this.b || r6.j.get()) {
                return;
            }
            r6.j.set(true);
            a();
            r6.j.set(false);
        }
    }

    public static void a(String str) {
        h = str;
    }

    public static void a(String str, String str2) {
        h().b(str, str2);
    }

    public static r6 h() {
        if (g == null) {
            synchronized (r6.class) {
                try {
                    if (g == null) {
                        g = new r6();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return g;
    }

    public static String i() {
        StringBuilder sb = new StringBuilder();
        sb.append(t2.b("yyyyMMdd-HHmmss").format(new Date()));
        sb.append(',');
        sb.append(q3.h());
        sb.append(',');
        sb.append(q3.j());
        sb.append(',');
        sb.append("");
        sb.append(',');
        sb.append(m3.a(i) ? "" : i);
        sb.append(',');
        sb.append(q3.i());
        sb.append(',');
        sb.append(q3.a());
        return sb.toString();
    }

    public static String j() {
        return q3.b() + ',' + h + ',' + q3.h() + ",," + Build.VERSION.SDK_INT + ',' + j3.a() + ',' + q3.m() + "," + q3.a();
    }

    @Override // c.t.m.g.e2
    public String a() {
        return "MllcPro";
    }

    public final String a(Context context) {
        int i2;
        int i3 = context.getApplicationInfo().targetSdkVersion;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            i2 = i6;
            if (i4 >= 7) {
                break;
            }
            try {
                int i7 = i6;
                if (!a(context, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_WIFI_STATE", Manifest.permission.CHANGE_WIFI_STATE, "android.permission.ACCESS_NETWORK_STATE", Manifest.permission.CHANGE_NETWORK_STATE, "android.permission.READ_PHONE_STATE"}[i4], i3)) {
                    i7 = i6 | (1 << i4);
                }
                i4++;
                i5 = i7;
            } catch (Throwable th) {
                i2 = -1;
            }
        }
        return Build.VERSION.SDK_INT + ContainerUtils.FIELD_DELIMITER + i3 + ContainerUtils.FIELD_DELIMITER + i2 + ContainerUtils.FIELD_DELIMITER + q6.a().b(context);
    }

    public void a(long j2) {
        a aVar;
        if (!b() || (aVar = this.d) == null) {
            return;
        }
        c3.a(aVar, 105, j2);
    }

    public final void a(String str, boolean z) {
        a3.a("th_loc_task_t_consume", new b(str, z));
    }

    public void a(boolean z) {
        this.e = z;
    }

    public final boolean a(Context context, String str, int i2) {
        boolean z = true;
        if (Build.VERSION.SDK_INT >= 23) {
            if (i2 < 23) {
                return PermissionChecker.checkSelfPermission(context, str) == 0;
            } else if (context.checkSelfPermission(str) == 0) {
                return true;
            } else {
                z = false;
            }
        }
        return z;
    }

    @Override // c.t.m.g.d2
    public int b(Looper looper) {
        if (this.e) {
            a aVar = new a(a3.b("th_loc_extra").getLooper());
            this.d = aVar;
            c3.b(aVar, 101);
        }
        this.f.clear();
        return 0;
    }

    public final void b(String str, String str2) {
        a aVar;
        if (!b() || (aVar = this.d) == null) {
            return;
        }
        Message obtainMessage = aVar.obtainMessage(103);
        obtainMessage.obj = this.f3917c.format(new Date()) + "," + str + "," + str2;
        obtainMessage.sendToTarget();
    }

    @Override // c.t.m.g.e2
    public void d() {
        a aVar = this.d;
        if (aVar != null) {
            aVar.a();
            this.d = null;
            a3.a("th_loc_extra");
        }
    }
}

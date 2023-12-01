package c.t.m.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.ContactsContract;
import android.text.TextUtils;
import c.t.m.g.j3;
import com.baidu.mobads.sdk.internal.bj;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.hms.utils.FileUtil;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/e.class */
public class e extends d2 {
    public static final String z = j.b() + i3.a(e.class.getName(), "SHA-256").substring(0, 8);

    /* renamed from: c  reason: collision with root package name */
    public Context f3789c;
    public final File d;
    public boolean e;
    public volatile Handler f;
    public long g;
    public long h;
    public int i;
    public int j;
    public long k;
    public long l;
    public long m;
    public long n;
    public boolean o;
    public boolean p;
    public boolean q;
    public long r;
    public volatile List<d> s;
    public volatile List<ScanResult> t;
    public volatile Location u;
    public h v;
    public g w;
    public f x;
    public BroadcastReceiver y;

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/e$a.class */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || !"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                return;
            }
            try {
                boolean booleanExtra = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);
                if (g3.a()) {
                    String str = "intent:" + intent + ",";
                }
                if (booleanExtra) {
                    return;
                }
                c3.a(e.this.f, 107, 2000L);
                if (e.this.w != null) {
                    e.this.w.c(2000L);
                }
            } catch (Throwable th) {
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/e$b.class */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ File f3791a;
        public final /* synthetic */ String b;

        /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/e$b$a.class */
        public class a implements t1 {
            public a() {
            }

            @Override // c.t.m.g.t1
            public void a(String str) {
            }

            @Override // c.t.m.g.t1
            public void b(String str) {
                b.this.f3791a.delete();
                if (g3.a()) {
                    b.this.f3791a.getName();
                }
            }
        }

        public b(e eVar, File file, String str) {
            this.f3791a = file;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                byte[] b = z2.b(this.f3791a);
                if (!m3.a(b)) {
                    j.k.a(this.b, b, new a());
                    return;
                }
                this.f3791a.delete();
                if (g3.a()) {
                    this.f3791a.getName();
                }
            } catch (Throwable th) {
                g3.a();
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/e$c.class */
    public class c extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public File f3793a;
        public BufferedOutputStream b;

        /* renamed from: c  reason: collision with root package name */
        public StringBuffer f3794c;
        public String d;
        public long e;

        public c(Looper looper) {
            super(looper);
            this.d = "";
            this.e = 0L;
        }

        public final void a() {
            File file = this.f3793a;
            if (file == null || !file.exists() || this.b == null || !e.z.equals(this.f3793a.getName())) {
                File d = d();
                this.f3793a = d;
                try {
                    boolean exists = d.exists();
                    this.b = new BufferedOutputStream(new FileOutputStream(this.f3793a, true), 1024);
                    if (exists) {
                        return;
                    }
                    p3.b("LocationSDK", "log_fc_create", Long.valueOf(System.currentTimeMillis()));
                } catch (Throwable th) {
                }
            }
        }

        public final void a(int i) {
            String str;
            File file;
            a();
            boolean z = true;
            if (m3.a((Collection) e.this.s)) {
                z = true;
            } else {
                long j = ((d) e.this.s.get(0)).e;
                if (this.e == j) {
                    z = false;
                }
                this.e = j;
            }
            if (i == 102) {
                str = k.a(j.i, e.this.u, null, e.this.s, z);
            } else {
                if (i == 101) {
                    List list = e.this.t;
                    if (!m3.a((Collection) list)) {
                        str = k.a(j.i, e.this.u, list, e.this.s, z);
                    }
                }
                str = "";
            }
            if (this.b == null || TextUtils.isEmpty(str) || str.length() < 25) {
                return;
            }
            String a2 = i3.a(str.substring(22).getBytes(), "SHA-256");
            if (this.d.equals(a2)) {
                return;
            }
            this.d = a2;
            if (this.f3794c == null) {
                this.f3794c = new StringBuffer(e.this.j);
            }
            StringBuffer stringBuffer = this.f3794c;
            stringBuffer.append(str);
            stringBuffer.append("\n");
            if (this.f3794c.length() > e.this.j || ((file = this.f3793a) != null && file.length() == 0)) {
                f();
                if (this.f3793a.length() > c()) {
                    c3.b(e.this.f, 106);
                }
            }
            if (g3.a()) {
                str.substring(0, 60);
                str.length();
            }
        }

        public final void a(int i, File file) {
            try {
                if (file.isFile()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    File file2 = new File(file.getAbsolutePath() + "." + currentTimeMillis + ".enc");
                    if (i == 4) {
                        byte[] b = z2.b(file);
                        if (!m3.a(b)) {
                            byte[] a2 = r2.a(b);
                            if (!m3.a(a2)) {
                                FileOutputStream fileOutputStream = new FileOutputStream(file2, true);
                                fileOutputStream.write(a2);
                                fileOutputStream.close();
                                file.delete();
                            }
                        }
                    } else {
                        file.renameTo(file2);
                    }
                    if (g3.a()) {
                        file.getName();
                        file2.getName();
                    }
                }
            } catch (Throwable th) {
                if (g3.a()) {
                    file.getName();
                }
            }
        }

        public final void a(long j, long j2) {
            long j3;
            File file = null;
            File[] listFiles = e.this.d == null ? null : e.this.d.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int length = listFiles.length;
            int i = 0;
            long j4 = 0;
            while (true) {
                j3 = j4;
                if (i >= length) {
                    break;
                }
                File file2 = listFiles[i];
                File file3 = file;
                long j5 = j3;
                if (file2.exists()) {
                    file3 = file;
                    j5 = j3;
                    if (file2.isFile()) {
                        if (e.z.equals(file2.getName())) {
                            file3 = file;
                            j5 = j3;
                        } else if (currentTimeMillis - file2.lastModified() > j || file2.length() == 0) {
                            if (g3.a()) {
                                file2.getName();
                                file2.length();
                            }
                            file2.delete();
                            j5 = j3;
                            file3 = file;
                        } else {
                            String name = file2.getName();
                            if (currentTimeMillis - file2.lastModified() <= bj.e || name.endsWith(".enc") || !name.startsWith(j.b())) {
                                long length2 = j3 + file2.length();
                                if (file != null) {
                                    file3 = file;
                                    j5 = length2;
                                    if (file.lastModified() <= file2.lastModified()) {
                                    }
                                }
                                file3 = file2;
                                j5 = length2;
                            } else {
                                a(j.a(name), file2);
                                file3 = file;
                                j5 = j3;
                            }
                        }
                    }
                }
                i++;
                file = file3;
                j4 = j5;
            }
            if (j3 < j2 || file == null) {
                return;
            }
            if (g3.a()) {
                file.getName();
                file.length();
            }
            file.delete();
        }

        public final void a(Message message) {
            File file;
            int i = message.what;
            switch (i) {
                case 101:
                case 102:
                    try {
                        a(i);
                        return;
                    } catch (Throwable th) {
                        return;
                    }
                case 103:
                    if (e.this.g()) {
                        String absolutePath = e.this.d.getAbsolutePath();
                        if (a(absolutePath)) {
                            return;
                        }
                        a(absolutePath.replaceAll("f_c", "d_c"));
                        return;
                    }
                    return;
                case 104:
                    b();
                    return;
                case 105:
                    try {
                        f();
                        if (this.f3794c != null) {
                            this.f3794c.setLength(0);
                        }
                    } catch (Throwable th2) {
                    }
                    this.f3793a = null;
                    z2.a(this.b);
                    a(e.this.n, e.this.k);
                    removeCallbacksAndMessages(null);
                    return;
                case 106:
                    a();
                    if (e.this.d == null || (file = this.f3793a) == null || !file.exists()) {
                        return;
                    }
                    f();
                    long longValue = ((Long) p3.a("LocationSDK", "log_fc_create", (Object) 0L)).longValue();
                    long currentTimeMillis = System.currentTimeMillis();
                    if (g3.a()) {
                        this.f3793a.length();
                        c();
                        long unused = e.this.m;
                    }
                    if (this.f3793a.length() > c() || currentTimeMillis - longValue > e.this.m) {
                        e();
                        a(e.this.n, e.this.k);
                        if (j.f) {
                            sendEmptyMessage(107);
                            return;
                        }
                        return;
                    }
                    return;
                case 107:
                    removeMessages(107);
                    e eVar = e.this;
                    eVar.a(eVar.f);
                    c3.a(e.this.f, 107, e.this.h);
                    return;
                default:
                    return;
            }
        }

        public final boolean a(long j) {
            try {
                SharedPreferences a2 = p3.a("LocationSDK");
                SharedPreferences.Editor edit = a2.edit();
                String string = a2.getString("log_up_fc_date", "");
                long j2 = a2.getLong("log_up_fc_size", 0L);
                String format = t2.b("yyyyMMdd").format(new Date());
                if (!format.equals(string)) {
                    edit.putString("log_up_fc_date", format);
                    edit.putLong("log_up_fc_size", j);
                } else if (j2 > e.this.l) {
                    return false;
                } else {
                    edit.putLong("log_up_fc_size", j + j2);
                }
                edit.apply();
                return true;
            } catch (Throwable th) {
                return true;
            }
        }

        public final boolean a(String str) {
            int i;
            File file = TextUtils.isEmpty(str) ? null : new File(str);
            File[] fileArr = null;
            if (file != null) {
                fileArr = null;
                if (file.exists()) {
                    fileArr = !file.isDirectory() ? null : file.listFiles();
                }
            }
            boolean z = false;
            if (fileArr == null || fileArr.length == 0) {
                if (fileArr == null || !str.endsWith("d_c")) {
                    return false;
                }
                file.delete();
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i2 = e.this.i;
            int i3 = 0;
            while (i3 < fileArr.length && i2 > 0) {
                File file2 = fileArr[i3];
                String name = (file2 != null && file2.exists() && file2.isFile()) ? file2.getName() : "";
                if (!name.startsWith(OapsKey.KEY_DOWNLOAD_COUNT) && !name.startsWith("fc")) {
                    i = i2;
                } else if (!str.endsWith("d_c") || (file2.length() != 0 && currentTimeMillis - file2.lastModified() <= e.this.n)) {
                    boolean z2 = (name.startsWith(j.b()) && name.endsWith(".enc")) || (name.startsWith("fc2") || name.startsWith("fc3"));
                    if (!z2) {
                        if (g3.a()) {
                            j.b();
                        }
                        z2 = name.startsWith(OapsKey.KEY_DOWNLOAD_COUNT) && System.currentTimeMillis() - file2.lastModified() > bj.e;
                    }
                    i = i2;
                    if (z2) {
                        i = i2;
                        if (a(file2.length())) {
                            if (g3.a()) {
                                file2.getName();
                                file2.length();
                            }
                            int a2 = j.a(name);
                            i = i2;
                            if (a2 > 0) {
                                String a3 = j.a(a2);
                                i = i2;
                                if (!TextUtils.isEmpty(a3)) {
                                    String str2 = a3;
                                    if (!j.e) {
                                        str2 = a3.replace("https:", "http:");
                                    }
                                    e.this.a(file2, str2);
                                    i = i2 - 1;
                                }
                            }
                        }
                    }
                } else {
                    file2.delete();
                    i = i2;
                }
                i3++;
                i2 = i;
            }
            if (i2 != e.this.i) {
                z = true;
            }
            return z;
        }

        public final void b() {
            try {
                if (this.b != null) {
                    this.b.flush();
                }
            } catch (Throwable th) {
                this.f3793a = null;
                z2.a(this.b);
            }
        }

        public final long c() {
            long j = j.f ? 51200L : 512000L;
            return e.this.g > j ? j : e.this.g;
        }

        public final File d() {
            File file = e.this.d;
            if (!file.exists()) {
                file.mkdirs();
            }
            return new File(file, e.z);
        }

        public final void e() {
            b();
            File file = this.f3793a;
            if (file == null || file.length() < 1024) {
                return;
            }
            z2.a(this.b);
            this.b = null;
            a(4, this.f3793a);
            this.f3793a = null;
            p3.b("LocationSDK", "log_fc_create", (Object) 0L);
        }

        public final void f() {
            StringBuffer stringBuffer = this.f3794c;
            if (stringBuffer == null || stringBuffer.length() == 0 || this.b == null) {
                return;
            }
            byte[] a2 = l.a(this.f3794c.toString());
            if (g3.a()) {
                this.f3794c.length();
                if (a2 != null) {
                    int length = a2.length;
                }
            }
            this.f3794c.setLength(0);
            if (a2 == null || a2.length == 0) {
                return;
            }
            try {
                this.b.write(a2);
                this.b.write(36);
                this.b.flush();
            } catch (Throwable th) {
                this.f3793a = null;
                z2.a(this.b);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                if (g3.a()) {
                    int i = message.what;
                }
                a(message);
            } catch (Throwable th) {
                g3.a();
            }
        }
    }

    public e(Context context, File file) {
        this.f3789c = null;
        this.g = 102400L;
        this.h = 3600000L;
        this.i = 1;
        this.j = 25600;
        this.k = 104857600L;
        this.l = 10485760L;
        this.m = 259200000L;
        this.n = ContactsContract.DeletedContacts.DAYS_KEPT_MILLISECONDS;
        this.o = true;
        this.p = false;
        this.q = false;
        this.r = 0L;
        this.y = new a();
        this.f3789c = context;
        this.d = file;
        this.e = false;
    }

    public e(Context context, String str) {
        this(context, new File(str + BridgeUtil.SPLIT_MARK + "f_c"));
    }

    public final long a(long j, long j2, long j3) {
        return Math.max(j2, Math.min(j, j3));
    }

    @Override // c.t.m.g.e2
    public String a() {
        return "DC_Pro";
    }

    public void a(int i, long j, Object obj) {
        g gVar;
        if ((i == 1 || i == 2) && (gVar = this.w) != null) {
            gVar.a(i, j, obj);
        }
    }

    public void a(int i, Location location) {
        g gVar = this.w;
        if (gVar != null) {
            gVar.a(i, location);
        }
        f fVar = this.x;
        if (fVar != null) {
            fVar.a(i, location);
        }
    }

    public void a(long j, int i, double d, double d2, double d3) {
        g gVar = this.w;
        if (gVar != null) {
            gVar.a(j, i, d, d2, d3);
        }
    }

    public void a(Location location, List<ScanResult> list, List<d> list2) {
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis();
            if (location != null && currentTimeMillis - location.getTime() <= 10000) {
                this.u = location;
                this.t = list;
                this.s = list2;
                if (g()) {
                    if (list == null) {
                        if (!m3.a((Collection) list2)) {
                            c3.b(this.f, 102);
                        }
                    } else if (!m3.a((Collection) list)) {
                        c3.b(this.f, 101);
                    }
                }
            }
        }
    }

    public final void a(Handler handler) {
        boolean z2;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.r < 60000) {
            return;
        }
        c3.b(handler, 106);
        try {
            j3.a b2 = j3.b();
            if (b2 == j3.a.NETWORK_NONE) {
                z2 = false;
            } else {
                z2 = true;
                if (b2 == j3.a.NETWORK_MOBILE) {
                    z2 = j.f;
                    if (!j.f && j.g && currentTimeMillis - ((Long) p3.a("LocationSDK", "log_fc_up_in_m", Long.valueOf(currentTimeMillis))).longValue() > 86400000) {
                        p3.b("LocationSDK", "log_fc_up_in_m", Long.valueOf(currentTimeMillis));
                        g3.a();
                        z2 = true;
                    }
                }
            }
            if (g3.a()) {
                String str = "network status:" + b2 + ",isUpload:" + z2;
            }
            if (z2 && g()) {
                c3.b(handler, 103);
                this.r = currentTimeMillis;
                g3.a();
            }
        } catch (Throwable th) {
        }
    }

    public final void a(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a3.a("th_loc_task_t_consume", new b(this, file, str));
    }

    public void a(String str, String str2) {
        if ("D_UP_INTERVAL".equals(str)) {
            this.h = Math.max(900000L, Long.parseLong(str2));
        } else if ("D_UP_USE_HTTPS".equals(str)) {
            j.e = Boolean.parseBoolean(str2);
        } else if ("D_MAX_1F_SIZE".equals(str)) {
            this.g = a(Long.parseLong(str2), FileUtil.LOCAL_REPORT_FILE_MAX_SIZE, 512000L);
        } else if ("D_NUM_UP".equals(str)) {
            this.i = (int) a(Long.parseLong(str2), 1L, 5L);
        } else if ("D_MAX_BUF_WF".equals(str)) {
            this.j = (int) a(Long.parseLong(str2), 5120L, 51200L);
        } else if ("D_MAX_FOLDER_SIZE".equals(str)) {
            this.k = a(Long.parseLong(str2), 10485760L, 209715200L);
        } else if ("D_MAX_SIZE_UP_1DAY".equals(str)) {
            this.l = Math.max(Long.parseLong(str2), 0L);
        } else if ("D_MAX_DAY_RENAME".equals(str)) {
            this.m = a(Long.parseLong(str2), 1L, 5L) * 24 * 60 * 60 * 1000;
        } else if ("D_MAX_DAY_DELETE".equals(str)) {
            this.n = a(Long.parseLong(str2), 1L, 30L) * 24 * 60 * 60 * 1000;
        } else if ("D_UP_WF_INFO".equals(str)) {
            this.o = Boolean.parseBoolean(str2);
        } else if ("D_UP_U_TRACK_INFO".equals(str)) {
            this.p = Boolean.parseBoolean(str2);
        } else if ("D_UP_GPS_FOR_NAVI".equals(str)) {
            this.q = Boolean.parseBoolean(str2);
        }
    }

    public void a(List<ScanResult> list) {
        h hVar = this.v;
        if (hVar != null) {
            hVar.a(list);
        }
    }

    @Override // c.t.m.g.d2
    public int b(Looper looper) {
        i();
        File file = this.d;
        this.e = file != null && (file.exists() || this.d.mkdirs());
        g3.a();
        if (this.e) {
            this.f = new c(looper);
            this.r = System.currentTimeMillis() - 40000;
            c3.a(this.f, 107, 300000L);
            try {
                this.f3789c.registerReceiver(this.y, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            } catch (Throwable th) {
                g3.a();
            }
        }
        if (this.e && this.o) {
            h hVar = new h(this.d);
            this.v = hVar;
            hVar.b(looper);
        }
        if (this.p) {
            g gVar = new g(this.d);
            this.w = gVar;
            gVar.b(looper);
        }
        if (this.q) {
            f fVar = new f();
            this.x = fVar;
            fVar.b(looper);
        }
        g3.a("FC", "systemInfo," + q3.a() + "," + q3.k());
        g3.a("FC", "start," + k3.a(this.o) + "," + k3.a(this.p) + "," + k3.a(this.q));
        return 0;
    }

    @Override // c.t.m.g.e2
    public void d() {
        try {
            this.f3789c.unregisterReceiver(this.y);
        } catch (Throwable th) {
        }
        h hVar = this.v;
        if (hVar != null) {
            hVar.a(100L);
            this.v = null;
        }
        g gVar = this.w;
        if (gVar != null) {
            gVar.a(100L);
            this.w = null;
        }
        f fVar = this.x;
        if (fVar != null) {
            fVar.f();
            this.x = null;
        }
        if (g()) {
            c3.b(this.f, 104);
            c3.b(this.f, 106);
            this.r = 0L;
            c3.b(this.f, 107);
            c3.a(this.f, 105, 200L);
            this.f = null;
        }
    }

    public final boolean g() {
        return this.e;
    }

    public final void i() {
        this.s = null;
        this.t = null;
        this.u = null;
        this.r = 0L;
    }
}

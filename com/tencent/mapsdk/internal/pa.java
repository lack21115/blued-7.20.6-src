package com.tencent.mapsdk.internal;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.google.android.material.timepicker.TimeModel;
import com.tencent.mapsdk.internal.ca;
import com.tencent.mapsdk.internal.da;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import java.io.File;
import java.io.FileFilter;
import java.lang.Thread;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/pa.class */
public class pa implements oa {
    public static Set<String> h;
    private static final int[] i;

    /* renamed from: a  reason: collision with root package name */
    private boolean f37687a;
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private int f37688c;
    private final Map<String, int[]> d = new HashMap();
    private final File e;
    private final Context f;
    private boolean g;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/pa$a.class */
    public class a implements FileFilter {
        public a() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Pattern.compile("log-.*.log").matcher(file.getName()).matches();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/pa$b.class */
    public class b implements Thread.UncaughtExceptionHandler {
        public b() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            pa paVar = pa.this;
            paVar.a(6, ma.f37643c, "UncaughtException: t[" + thread + "]", th);
            throw new RuntimeException(th);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/pa$c.class */
    public class c extends ca.i<Void> {
        public c() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() throws Exception {
            Calendar calendar = Calendar.getInstance();
            Date date = new Date();
            calendar.setTime(date);
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            sb.append("(");
            sb2.append("(");
            int i = 2;
            while (true) {
                int i2 = i;
                if (i2 == 0) {
                    break;
                }
                calendar.add(2, -1);
                String str = calendar.get(1) + "";
                String format = String.format(Locale.CHINA, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(calendar.get(2) + 1));
                sb.append(str);
                sb.append("|");
                sb2.append(format);
                sb2.append("|");
                String str2 = str + BridgeUtil.UNDERLINE_STR + format;
                File[] c2 = ga.c(pa.this.e, ".*" + str2 + ".*.log.*");
                if (c2 != null && c2.length > 0) {
                    if (ja.a(c2, pa.this.e, "archive-" + str2)) {
                        for (File file : c2) {
                            ga.d(file);
                        }
                    }
                }
                i = i2 - 1;
            }
            calendar.setTime(date);
            sb.deleteCharAt(sb.lastIndexOf("|")).append(")");
            sb2.deleteCharAt(sb2.lastIndexOf("|")).append(")");
            String str3 = "archive-" + sb.toString() + BridgeUtil.UNDERLINE_STR + sb2.toString() + ".zip";
            File[] c3 = ga.c(pa.this.e, "archive-.*.zip");
            if (c3 == null) {
                return null;
            }
            int length = c3.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length) {
                    return null;
                }
                File file2 = c3[i4];
                if (!file2.getName().matches(str3)) {
                    ga.d(file2);
                }
                i3 = i4 + 1;
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/pa$d.class */
    public class d implements Runnable {
        public final /* synthetic */ File b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f37692c;
        public final /* synthetic */ String d;

        public d(File file, String str, String str2) {
            this.b = file;
            this.f37692c = str;
            this.d = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            boolean z;
            File file = new File(this.b, this.f37692c + "-" + pa.d() + com.anythink.china.common.a.a.f);
            if (file.exists()) {
                str = this.d + "\n";
            } else {
                ga.b(file);
                str = pa.this.e() + this.d;
            }
            if (file.length() >= 2097152) {
                File file2 = null;
                int i = 1;
                while (true) {
                    int i2 = i;
                    z = false;
                    if (i2 > 500) {
                        break;
                    }
                    file2 = new File(file.getParent(), file.getName() + ".part" + i2);
                    if (!file2.exists()) {
                        z = true;
                        break;
                    }
                    i = i2 + 1;
                }
                if (z) {
                    ga.b(file, file2);
                    ga.b(file);
                }
            }
            ga.e(file, str);
        }
    }

    static {
        HashSet hashSet = new HashSet();
        h = hashSet;
        hashSet.add(ma.h);
        h.add("NetManager");
        h.add("asset");
        i = new int[]{2, 3, 4, 5, 6};
    }

    public pa(Context context, TencentMapOptions tencentMapOptions) {
        String[] debugTags;
        this.f = context;
        File file = new File(mc.a(context, tencentMapOptions).b().getAbsolutePath());
        this.e = ga.a(file, "logs");
        if (y9.d("4.5.9", "4.3.4", 3) < 0) {
            ga.a(file, new a());
        }
        if (tencentMapOptions != null && (debugTags = tencentMapOptions.getDebugTags()) != null) {
            a(true, debugTags);
        }
        h();
        if (mi.d) {
            Thread.setDefaultUncaughtExceptionHandler(new b());
        }
    }

    private void a(int i2, String str, String str2) {
        a(i2, str, str2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str, String str2, Throwable th) {
        String str3 = str;
        if (!ma.f37643c.equals(str)) {
            if (TextUtils.isEmpty(str)) {
                str3 = ma.f37643c;
            } else {
                str3 = "TMS-" + str;
            }
        }
        if (th != null) {
            switch (i2) {
                case 2:
                    Log.v(str3, str2, th);
                    break;
                case 3:
                    Log.d(str3, str2, th);
                    break;
                case 4:
                    Log.i(str3, str2, th);
                    break;
                case 5:
                    Log.w(str3, str2, th);
                    break;
                case 6:
                    Log.e(str3, str2, th);
                    break;
                case 7:
                    Log.wtf(str3, str2, th);
                    break;
            }
        } else {
            Log.println(i2, str3, str2);
        }
        if (this.g) {
            String str4 = str2;
            if (th != null) {
                str4 = str2 + " [error]:" + th.getMessage();
            }
            System.out.println("[" + str3 + "]:" + str4);
        }
    }

    public static String d() {
        return new SimpleDateFormat("yyyy_MM_dd", Locale.CHINA).format(new Date());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e() {
        return "###########\n" + ra.a(this.f, c7.a("", "")) + "\n###########\n";
    }

    public static String f() {
        return new SimpleDateFormat("yyyy_MM", Locale.CHINA).format(new Date());
    }

    public static String g() {
        return new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.CHINA).format(new Date());
    }

    private void h() {
        ca.a((ca.i) new c()).b((ca.d.b) null);
    }

    @Override // com.tencent.mapsdk.internal.oa
    public void a() {
    }

    @Override // com.tencent.mapsdk.internal.oa
    public void a(Context context, da.a aVar) {
        if (context != null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            long j = this.b;
            if (j != 0 && uptimeMillis - j >= 400) {
                this.f37688c = 0;
                this.b = 0L;
                this.f37687a = false;
                return;
            }
            this.b = uptimeMillis;
            this.f37688c++;
            String str = "触发调试模式" + this.f37688c + "次";
            int i2 = this.f37688c;
            if (i2 >= 5 && i2 < 10) {
                String str2 = "开发者调试在" + (10 - this.f37688c) + "次后开启";
                str = str2;
                if (aVar != null) {
                    aVar.a(str2, 1).b();
                    str = str2;
                }
            } else if (i2 == 10) {
                this.f37687a = true;
                str = "开发者调试已开启";
                if (aVar != null) {
                    aVar.a("开发者调试已开启", 1).b();
                    str = "开发者调试已开启";
                }
            }
            a(5, ma.f37643c, str);
        }
    }

    @Override // com.tencent.mapsdk.internal.oa
    public void a(File file, String str, String str2) {
        if (!b() || TextUtils.isEmpty(str2)) {
            return;
        }
        new Thread(new d(file, str, str2)).start();
    }

    @Override // com.tencent.mapsdk.internal.oa
    public void a(String str) {
        if (b()) {
            a(4, ma.f37643c, str);
        }
    }

    @Override // com.tencent.mapsdk.internal.oa
    public void a(String str, String str2) {
        a(this.e, str, str2);
    }

    @Override // com.tencent.mapsdk.internal.oa
    public void a(String str, String str2, Throwable th) {
        if (a(5, str)) {
            a(5, str, str2, th);
        }
    }

    @Override // com.tencent.mapsdk.internal.oa
    public void a(String str, Throwable th) {
        if (b()) {
            a(4, ma.f37643c, str, th);
        }
    }

    @Override // com.tencent.mapsdk.internal.oa
    public void a(boolean z) {
        this.g = z;
    }

    @Override // com.tencent.mapsdk.internal.oa
    public void a(boolean z, int i2, String... strArr) {
        if (strArr == null) {
            return;
        }
        int length = strArr.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                return;
            }
            String str = strArr[i4];
            this.d.remove(str);
            if (z) {
                this.d.put(str, new int[]{i2});
            }
            i3 = i4 + 1;
        }
    }

    @Override // com.tencent.mapsdk.internal.oa
    public void a(boolean z, String... strArr) {
        if (strArr == null) {
            return;
        }
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            String str = strArr[i3];
            this.d.remove(str);
            if (z) {
                this.d.put(str, i);
            }
            i2 = i3 + 1;
        }
    }

    @Override // com.tencent.mapsdk.internal.oa
    public boolean a(int i2, String str) {
        boolean z = true;
        if (!this.d.containsKey(str)) {
            if (!this.f37687a) {
                if (mi.d && !h.contains(str)) {
                    return true;
                }
                z = false;
            }
            return z;
        }
        int[] iArr = this.d.get(str);
        if (iArr == null) {
            return false;
        }
        int length = iArr.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                return false;
            }
            if (iArr[i4] == i2) {
                return true;
            }
            i3 = i4 + 1;
        }
    }

    @Override // com.tencent.mapsdk.internal.oa
    public void b(String str) {
        if (b()) {
            a(6, ma.f37643c, str);
        }
    }

    @Override // com.tencent.mapsdk.internal.oa
    public void b(String str, String str2, Throwable th) {
        if (a(3, str)) {
            a(3, str, str2, th);
        }
    }

    @Override // com.tencent.mapsdk.internal.oa
    public void b(String str, Throwable th) {
        if (b()) {
            a(3, ma.f37643c, str, th);
        }
    }

    @Override // com.tencent.mapsdk.internal.oa
    public boolean b() {
        return d(ma.f37643c);
    }

    @Override // com.tencent.mapsdk.internal.oa
    public String c() {
        return this.e.getAbsolutePath();
    }

    @Override // com.tencent.mapsdk.internal.oa
    public void c(String str) {
        if (b()) {
            a(2, ma.f37643c, str);
        }
    }

    @Override // com.tencent.mapsdk.internal.oa
    public void c(String str, String str2, Throwable th) {
        if (a(4, str)) {
            a(4, str, str2, th);
        }
    }

    @Override // com.tencent.mapsdk.internal.oa
    public void c(String str, Throwable th) {
        if (b()) {
            a(5, ma.f37643c, str, th);
        }
    }

    @Override // com.tencent.mapsdk.internal.oa
    public void d(String str, String str2) {
        if (a(3, str)) {
            a(3, str, str2);
        }
    }

    @Override // com.tencent.mapsdk.internal.oa
    public void d(String str, String str2, Throwable th) {
        if (a(6, str)) {
            a(6, str, str2, th);
        }
    }

    @Override // com.tencent.mapsdk.internal.oa
    public void d(String str, Throwable th) {
        if (b()) {
            a(2, ma.f37643c, str, th);
        }
    }

    @Override // com.tencent.mapsdk.internal.oa
    public boolean d(String str) {
        boolean z = true;
        if (this.d.containsKey(str)) {
            return true;
        }
        if (!this.f37687a) {
            if (mi.d && !h.contains(str)) {
                return true;
            }
            z = false;
        }
        return z;
    }

    @Override // com.tencent.mapsdk.internal.oa
    public void e(String str) {
        a(this.e, "tms", str);
    }

    @Override // com.tencent.mapsdk.internal.oa
    public void e(String str, String str2) {
        if (a(6, str)) {
            a(6, str, str2);
        }
    }

    @Override // com.tencent.mapsdk.internal.oa
    public void e(String str, String str2, Throwable th) {
        if (a(2, str)) {
            a(2, str, str2, th);
        }
    }

    @Override // com.tencent.mapsdk.internal.oa
    public void e(String str, Throwable th) {
        if (b()) {
            a(6, ma.f37643c, str, th);
        }
    }

    @Override // com.tencent.mapsdk.internal.oa
    public void f(String str) {
        if (b()) {
            a(3, ma.f37643c, str);
        }
    }

    @Override // com.tencent.mapsdk.internal.oa
    public void g(String str) {
        if (b()) {
            a(5, ma.f37643c, str);
        }
    }

    @Override // com.tencent.mapsdk.internal.oa
    public void i(String str, String str2) {
        if (a(4, str)) {
            a(4, str, str2);
        }
    }

    @Override // com.tencent.mapsdk.internal.oa
    public void v(String str, String str2) {
        if (a(2, str)) {
            a(2, str, str2);
        }
    }

    @Override // com.tencent.mapsdk.internal.oa
    public void w(String str, String str2) {
        if (a(5, str)) {
            a(5, str, str2);
        }
    }
}

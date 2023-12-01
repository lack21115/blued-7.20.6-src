package com.anythink.core.common.b;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.anythink.core.api.ATCustomAdapterConfig;
import com.anythink.core.api.ATDebuggerConfig;
import com.anythink.core.api.ATInitConfig;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATNetworkConfig;
import com.anythink.core.api.ATPrivacyConfig;
import com.anythink.core.api.AdError;
import com.anythink.core.api.DeviceInfoCallback;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.api.IATAdFilter;
import com.anythink.core.api.IExHandler;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.ai;
import com.anythink.core.common.e.ak;
import com.anythink.core.common.k.s;
import com.anythink.core.common.r;
import com.anythink.core.common.t;
import com.anythink.core.common.u;
import com.anythink.core.common.v;
import com.anythink.core.common.w;
import com.anythink.core.common.x;
import dalvik.system.DexFile;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/b/n.class */
public class n {
    public static final int a = 0;
    public static final int b = 1;
    private static volatile n j;
    private String F;
    private String G;
    private boolean I;
    private com.anythink.core.common.f.c K;
    private Location L;
    private JSONArray N;
    private List<String> O;
    private String Q;
    private ATDebuggerConfig R;
    private boolean S;
    private ConcurrentHashMap<String, IATAdFilter> W;
    private ATPrivacyConfig Y;
    private ak aa;
    Boolean c;
    WeakReference<Activity> e;
    private int f;
    private Context k;
    private String l;
    private String m;
    private String o;
    private ConcurrentHashMap<String, ATCustomAdapterConfig> r;
    private Map<String, Boolean> s;
    private String t;
    private BroadcastReceiver v;
    private String w;
    private String x;
    private String y;
    private IExHandler z;
    private final String g = "SDK.init";
    private final String h = "com.anythink.pd.ExHandler";
    private boolean i = false;
    private boolean B = false;
    private boolean C = false;
    private long D = 0;
    private long E = 0;
    private boolean J = false;
    private String M = "";
    private int T = 1;
    private boolean U = false;
    private boolean V = false;
    private String X = "";
    private int Z = 1;
    long d = 0;
    private Handler n = new Handler(Looper.getMainLooper());
    private ConcurrentHashMap<String, Map<String, Object>> q = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Object> p = new ConcurrentHashMap<>();
    private final String A = File.separator + "anythink.test";
    private boolean H = true;
    private ConcurrentHashMap<String, List<String>> P = new ConcurrentHashMap<>();
    private JSONObject u = new JSONObject();
    private long ab = System.currentTimeMillis();

    /* renamed from: com.anythink.core.common.b.n$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/b/n$1.class */
    final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.anythink.core.common.k.d.a(n.this.k);
                com.anythink.core.common.k.d.q(n.this.k);
            } catch (Exception e) {
            }
            if (n.this.A()) {
                String d = com.anythink.core.common.k.d.d(n.this.k);
                Log.i(g.n, "********************************** " + com.anythink.core.common.k.g.a() + " *************************************");
                Log.i(g.n, "GAID(ADID): " + com.anythink.core.common.k.d.f() + " , AndroidID: " + d);
                StringBuilder sb = new StringBuilder("********************************** ");
                sb.append(com.anythink.core.common.k.g.a());
                sb.append(" *************************************");
                Log.i(g.n, sb.toString());
                if (TextUtils.isEmpty(d)) {
                    return;
                }
                Log.i(g.n, "You can use \"ATSDK.setDebuggerConfig(context, \"" + d + "\",new ATDebuggerConfig.Builder(the NetworkFirmId you want to test).build());\" to open the debugger mode.");
            }
        }
    }

    /* renamed from: com.anythink.core.common.b.n$10  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/b/n$10.class */
    final class AnonymousClass10 extends BroadcastReceiver {
        AnonymousClass10() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (com.anythink.core.common.k.h.a(context)) {
                com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.b.n.10.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        u.a().b();
                    }
                });
                com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.b.n.10.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        t.a().b();
                    }
                });
                com.anythink.core.common.j.b.a().b();
                n nVar = n.this;
                nVar.a(context, nVar.p(), n.this.q());
            }
            if (TextUtils.equals(intent.getAction(), g.C)) {
                com.anythink.core.common.j.c.a(intent.getStringExtra(g.D));
            }
        }
    }

    /* renamed from: com.anythink.core.common.b.n$11  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/b/n$11.class */
    final class AnonymousClass11 implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;

        AnonymousClass11(Context context, String str) {
            this.a = context;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.c.a b = com.anythink.core.c.b.a(this.a.getApplicationContext()).b(this.b);
            if (b != null) {
                if (!b.G()) {
                    r.a(n.this.k).a(b);
                }
                if (com.anythink.core.c.b.a(this.a.getApplicationContext()).a(this.b)) {
                    return;
                }
                com.anythink.core.c.b.a(this.a.getApplicationContext());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.core.common.b.n$5  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/b/n$5.class */
    public final class AnonymousClass5 implements Runnable {
        final /* synthetic */ ATInitConfig a;
        final /* synthetic */ Context b;

        AnonymousClass5(ATInitConfig aTInitConfig, Context context) {
            this.a = aTInitConfig;
            this.b = context;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x00a8  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00cc  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00ed A[Catch: all -> 0x0153, TryCatch #1 {all -> 0x0153, blocks: (B:2:0x0000, B:4:0x000e, B:6:0x002f, B:24:0x008d, B:28:0x00ad, B:30:0x00c3, B:36:0x00d6, B:38:0x00ed, B:40:0x0145, B:22:0x0087, B:7:0x0039), top: B:48:0x0000 }] */
        /* JADX WARN: Removed duplicated region for block: B:45:0x015b  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void run() {
            /*
                Method dump skipped, instructions count: 352
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.b.n.AnonymousClass5.run():void");
        }
    }

    private n() {
    }

    static /* synthetic */ void N() {
        try {
            Object invoke = Class.forName("com.anythink.network.adx.AdxATInitManager").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            if (invoke == null || !(invoke instanceof ATInitMediation)) {
                return;
            }
            ((ATInitMediation) invoke).getResourceStatus();
        } catch (Throwable th) {
        }
    }

    private void O() {
        com.anythink.core.common.k.b.a.a().a(new AnonymousClass1());
    }

    private static void P() {
        try {
            Object invoke = Class.forName("com.anythink.network.adx.AdxATInitManager").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            if (invoke == null || !(invoke instanceof ATInitMediation)) {
                return;
            }
            ((ATInitMediation) invoke).getResourceStatus();
        } catch (Throwable th) {
        }
    }

    private void Q() {
        try {
            if (this.v != null) {
                this.k.unregisterReceiver(this.v);
                k.a(this.k).a(this.v);
            }
            this.v = null;
        } catch (Throwable th) {
        }
        try {
            this.v = new AnonymousClass10();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addAction(g.C);
            this.k.registerReceiver(this.v, intentFilter);
            k.a(this.k).a(this.v, intentFilter);
        } catch (Throwable th2) {
        }
    }

    private static boolean R() {
        return true;
    }

    private void S() {
        boolean z = false;
        if (this.k != null) {
            try {
                boolean exists = new File(this.k.getExternalFilesDir(null), this.A).exists();
                z = exists;
                if (!exists) {
                    try {
                        z = new File(this.k.getFilesDir(), this.A).exists();
                    } catch (Throwable th) {
                        th = th;
                        z = exists;
                        th.printStackTrace();
                        this.B = z;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                z = false;
            }
        }
        this.B = z;
    }

    private boolean T() {
        return this.H;
    }

    private long U() {
        return this.ab;
    }

    private static long a(long j2) {
        Date date = new Date(j2);
        return new Date(date.getYear(), date.getMonth(), date.getDate()).getTime();
    }

    public static n a() {
        if (j == null) {
            synchronized (n.class) {
                try {
                    if (j == null) {
                        j = new n();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return j;
    }

    private void a(Context context, ATNetworkConfig aTNetworkConfig) {
        ATNetworkConfig aTNetworkConfig2 = aTNetworkConfig;
        if (aTNetworkConfig == null) {
            aTNetworkConfig2 = new ATNetworkConfig();
        }
        List<ATInitConfig> aTInitConfigList = aTNetworkConfig2.getATInitConfigList();
        ArrayList arrayList = aTInitConfigList;
        if (aTInitConfigList == null) {
            arrayList = new ArrayList(2);
        }
        if (v()) {
            arrayList.clear();
        }
        boolean z = false;
        this.J = arrayList.size() > 0;
        ATInitConfig aTInitConfig = null;
        try {
            Constructor declaredConstructor = Class.forName("com.anythink.network.facebook.FacebookATInitConfig").asSubclass(ATInitConfig.class).getDeclaredConstructor(null);
            declaredConstructor.setAccessible(true);
            ATInitConfig aTInitConfig2 = (ATInitConfig) declaredConstructor.newInstance(new Object[0]);
            try {
                arrayList.add(0, aTInitConfig2);
            } catch (Throwable th) {
            }
            aTInitConfig = aTInitConfig2;
        } catch (Throwable th2) {
        }
        for (ATInitConfig aTInitConfig3 : arrayList) {
            if (aTInitConfig3 != null) {
                boolean z2 = z;
                if (aTInitConfig != null) {
                    z2 = z;
                    if (TextUtils.equals(aTInitConfig.getClass().getSimpleName(), aTInitConfig3.getClass().getSimpleName())) {
                        if (!z) {
                            z2 = true;
                        }
                    }
                }
                com.anythink.core.common.k.b.a.a().a(new AnonymousClass5(aTInitConfig3, context));
                z = z2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x018b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ void a(com.anythink.core.common.b.n r7, android.content.Context r8) {
        /*
            Method dump skipped, instructions count: 436
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.b.n.a(com.anythink.core.common.b.n, android.content.Context):void");
    }

    static /* synthetic */ void a(n nVar, Context context, ATNetworkConfig aTNetworkConfig) {
        ATNetworkConfig aTNetworkConfig2 = aTNetworkConfig;
        if (aTNetworkConfig == null) {
            aTNetworkConfig2 = new ATNetworkConfig();
        }
        List<ATInitConfig> aTInitConfigList = aTNetworkConfig2.getATInitConfigList();
        ArrayList arrayList = aTInitConfigList;
        if (aTInitConfigList == null) {
            arrayList = new ArrayList(2);
        }
        if (nVar.v()) {
            arrayList.clear();
        }
        boolean z = false;
        nVar.J = arrayList.size() > 0;
        ATInitConfig aTInitConfig = null;
        try {
            Constructor declaredConstructor = Class.forName("com.anythink.network.facebook.FacebookATInitConfig").asSubclass(ATInitConfig.class).getDeclaredConstructor(null);
            declaredConstructor.setAccessible(true);
            ATInitConfig aTInitConfig2 = (ATInitConfig) declaredConstructor.newInstance(new Object[0]);
            try {
                arrayList.add(0, aTInitConfig2);
            } catch (Throwable th) {
            }
            aTInitConfig = aTInitConfig2;
        } catch (Throwable th2) {
        }
        for (ATInitConfig aTInitConfig3 : arrayList) {
            if (aTInitConfig3 != null) {
                boolean z2 = z;
                if (aTInitConfig != null) {
                    z2 = z;
                    if (TextUtils.equals(aTInitConfig.getClass().getSimpleName(), aTInitConfig3.getClass().getSimpleName())) {
                        if (!z) {
                            z2 = true;
                        }
                    }
                }
                com.anythink.core.common.k.b.a.a().a(new AnonymousClass5(aTInitConfig3, context));
                z = z2;
            }
        }
    }

    static boolean a(Context context, List<String> list) {
        boolean z = true;
        if (list == null) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            try {
            } catch (Throwable th) {
                sb.append(", error: ");
                sb.append(th.getMessage());
            }
            if (context.getPackageManager().queryIntentActivities(new Intent(context, Class.forName(str)), 131072).size() <= 0) {
                sb.append(", ");
                sb.append(str);
                z = false;
            }
        }
        if (sb.length() > 2) {
            sb.delete(0, 2);
        }
        if (z) {
            Log.i(g.n, "Activities : VERIFIED");
            return z;
        }
        Log.e(g.n, "Activities : Missing " + sb.toString() + " declare in AndroidManifest");
        return z;
    }

    private void b(Context context, String str, String str2) {
        a(context.getApplicationContext(), str, str2);
        com.anythink.core.common.k.b.a.a().a(new AnonymousClass11(context, str));
    }

    static /* synthetic */ void b(n nVar) {
        boolean z = false;
        if (nVar.k != null) {
            try {
                boolean exists = new File(nVar.k.getExternalFilesDir(null), nVar.A).exists();
                z = exists;
                if (!exists) {
                    try {
                        z = new File(nVar.k.getFilesDir(), nVar.A).exists();
                    } catch (Throwable th) {
                        th = th;
                        z = exists;
                        th.printStackTrace();
                        nVar.B = z;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                z = false;
            }
        }
        nVar.B = z;
    }

    public static void b(Runnable runnable) {
        com.anythink.core.common.k.b.a.a().a(runnable);
    }

    static boolean b(Context context, List<String> list) {
        boolean z = true;
        if (list == null) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        PackageManager packageManager = context.getPackageManager();
        for (String str : list) {
            try {
            } catch (Throwable th) {
                sb.append(", error: ");
                sb.append(th.getMessage());
            }
            if (packageManager.queryIntentServices(new Intent(context, Class.forName(str)), 131072).size() <= 0) {
                sb.append(", ");
                sb.append(str);
                z = false;
            }
        }
        if (sb.length() > 2) {
            sb.delete(0, 2);
        }
        if (z) {
            Log.i(g.n, "Services : VERIFIED");
            return z;
        }
        Log.e(g.n, "Services : Missing " + sb.toString() + " declare in AndroidManifest");
        return z;
    }

    static boolean b(Map<String, Boolean> map) {
        boolean z = true;
        if (map == null) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : map.keySet()) {
            if (!map.get(str).booleanValue()) {
                sb.append(", ");
                sb.append(str);
                z = false;
            }
        }
        if (sb.length() > 2) {
            sb.delete(0, 2);
        }
        if (z) {
            Log.i(g.n, "Dependence Plugin: VERIFIED");
            return z;
        }
        Log.e(g.n, "Dependence Plugin: Missing ".concat(String.valueOf(sb)));
        return z;
    }

    private static boolean c(Context context) {
        ActivityManager.RunningAppProcessInfo next;
        try {
            Iterator<ActivityManager.RunningAppProcessInfo> it = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses().iterator();
            do {
                if (!it.hasNext()) {
                    return false;
                }
                next = it.next();
            } while (!next.processName.equals(context.getPackageName()));
            return next.importance == 100;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    static boolean c(Context context, List<String> list) {
        boolean z;
        PackageInfo packageInfo;
        boolean z2;
        if (list == null) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 8);
            z = true;
        } catch (Throwable th) {
            sb.append(", error: ");
            sb.append(th.getMessage());
            z = false;
            packageInfo = null;
        }
        if (packageInfo == null) {
            return false;
        }
        ProviderInfo[] providerInfoArr = packageInfo.providers;
        for (String str : list) {
            int length = providerInfoArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    z2 = false;
                    break;
                } else if (TextUtils.equals(providerInfoArr[i2].name, str)) {
                    z2 = true;
                    break;
                } else {
                    i = i2 + 1;
                }
            }
            if (!z2) {
                sb.append(", ");
                sb.append(str);
                z = false;
            }
        }
        if (sb.length() > 2) {
            sb.delete(0, 2);
        }
        if (z) {
            Log.i(g.n, "Providers : VERIFIED");
            return z;
        }
        Log.e(g.n, "Providers : Missing " + sb.toString() + " declare in AndroidManifest");
        return z;
    }

    public static void d(Runnable runnable) {
        com.anythink.core.common.k.b.a.a().a(runnable, 1000L);
    }

    private boolean d(Context context) {
        String d = com.anythink.core.common.k.d.d(context);
        if (TextUtils.isEmpty(d) || !d.equals(this.Q)) {
            String f = com.anythink.core.common.k.d.f();
            if (TextUtils.isEmpty(f) || !f.equals(this.Q)) {
                IExHandler b2 = a().b();
                return b2 != null && b2.checkDebuggerDevice(context, this.Q);
            }
            return true;
        }
        return true;
    }

    static boolean d(Context context, List<String> list) {
        boolean z = true;
        if (list == null || list.size() == 0) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            int size = list.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                String str = list.get(i2);
                if (TextUtils.isEmpty(applicationInfo.metaData.getString(str))) {
                    sb.append(", \"");
                    sb.append(str);
                    sb.append("\"");
                    z = false;
                }
                i = i2 + 1;
            }
            if (sb.length() > 2) {
                sb.delete(0, 2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            z = false;
        }
        if (z) {
            Log.i(g.n, "meta-data: VERIFIED");
            return z;
        }
        Log.e(g.n, "meta-data: Missing " + sb.toString() + " declare in AndroidManifest");
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0199  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e(android.content.Context r8) {
        /*
            Method dump skipped, instructions count: 452
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.b.n.e(android.content.Context):void");
    }

    private void e(boolean z) {
        this.U = z;
    }

    static boolean e(Context context, List<String> list) {
        int size;
        boolean z;
        boolean z2;
        if (list == null || (size = list.size()) == 0) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr == null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    z = false;
                    if (i2 >= size) {
                        break;
                    }
                    String str = list.get(i2);
                    if (i2 == 0) {
                        sb.append(str);
                    } else {
                        sb.append(", ");
                        sb.append(str);
                    }
                    i = i2 + 1;
                }
            } else {
                z = true;
                for (int i3 = 0; i3 < size; i3++) {
                    String str2 = list.get(i3);
                    int length = strArr.length;
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= length) {
                            z2 = false;
                            break;
                        } else if (TextUtils.equals(str2, strArr[i5])) {
                            z2 = true;
                            break;
                        } else {
                            i4 = i5 + 1;
                        }
                    }
                    if (!z2) {
                        if (sb.length() == 0) {
                            sb.append(str2);
                        } else {
                            sb.append(", ");
                            sb.append(str2);
                        }
                        z = false;
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            z = false;
        }
        if (z) {
            Log.i(g.n, "Permission: VERIFIED");
            return z;
        }
        Log.e(g.n, "Permission: Missing " + sb.toString() + " declare in AndroidManifest");
        return z;
    }

    static boolean h(String str) {
        try {
            Class.forName(str);
            Log.i(g.n, "SDK: VERIFIED");
            return true;
        } catch (Throwable th) {
            Log.i(g.n, "SDK: NOT VERIFIED");
            return false;
        }
    }

    public static void n(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e(g.n, "AdSourceId is empty");
            return;
        }
        try {
            if (Long.parseLong(str) == 0) {
                Log.e(g.n, "AdSourceId can't set 0");
            }
        } catch (Exception e) {
            Log.e(g.n, "AdSourceId '" + str + "' is not compliant");
        }
    }

    private Map<String, Object> q(String str) {
        if (this.q == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.q.get(str);
    }

    private void r(String str) {
        this.l = str;
        com.anythink.core.common.k.p.a(this.k, g.o, g.p, str);
    }

    private void s(String str) {
        this.m = str;
        com.anythink.core.common.k.p.a(this.k, g.o, g.q, str);
    }

    @Deprecated
    private void t(String str) {
        this.Q = str;
    }

    private String u(String str) {
        synchronized (this) {
            String optString = this.u.optString(str);
            if (TextUtils.isEmpty(optString)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(": sessionid is empty.");
                String x = x();
                String str2 = "";
                String str3 = x;
                if (TextUtils.isEmpty(x)) {
                    str3 = com.anythink.core.common.k.d.d(this.k) + com.anythink.core.common.k.d.f();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(new Random().nextInt(10000000));
                    str2 = sb2.toString();
                }
                long currentTimeMillis = System.currentTimeMillis();
                String a2 = com.anythink.core.common.k.f.a(str3 + str + str2 + currentTimeMillis);
                try {
                    this.u.put(str, a2);
                } catch (Exception e) {
                }
                com.anythink.core.common.k.p.a(this.k, g.o, g.o.g, this.u.toString());
                if (!TextUtils.isEmpty(x())) {
                    str2 = null;
                }
                com.anythink.core.common.j.c.a(str, "2", str2, String.valueOf(currentTimeMillis));
                return a2;
            }
            return optString;
        }
    }

    public final boolean A() {
        return this.B || this.C;
    }

    public final com.anythink.core.common.f.c B() {
        if (this.K == null) {
            this.K = new com.anythink.core.common.h.d();
        }
        return this.K;
    }

    public final boolean C() {
        return this.U;
    }

    public final boolean D() {
        return this.V;
    }

    public final Context E() {
        WeakReference<Activity> weakReference = this.e;
        return (weakReference == null || weakReference.get() == null) ? this.k : this.e.get();
    }

    public final Activity F() {
        WeakReference<Activity> weakReference = this.e;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.e.get();
    }

    public final String G() {
        return this.X;
    }

    public final boolean H() {
        Boolean bool = this.c;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Class.forName("com.reyun.mobdna.MobDNA");
            this.c = Boolean.TRUE;
        } catch (Throwable th) {
            this.c = Boolean.FALSE;
        }
        return this.c.booleanValue();
    }

    public final boolean I() {
        return this.J;
    }

    public final ATPrivacyConfig J() {
        return this.Y;
    }

    public final int K() {
        return this.Z;
    }

    public final ak L() {
        if (this.aa == null) {
            this.aa = new ak();
        }
        try {
            this.aa.a(com.anythink.core.common.k.d.s(a().k));
            this.aa.b(com.anythink.core.common.k.d.k());
            this.aa.c(com.anythink.core.common.k.d.m());
            this.aa.d(com.anythink.core.common.k.d.b(com.anythink.core.common.k.d.l()));
        } catch (Throwable th) {
        }
        return this.aa;
    }

    public final void M() {
        this.ab = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long a(Context context, String str, int i) {
        synchronized (this) {
            com.anythink.core.c.a b2 = com.anythink.core.c.b.a(context).b(str);
            String b3 = com.anythink.core.common.k.p.b(context, g.o, g.o.f, "");
            String b4 = com.anythink.core.common.k.p.b(context, g.o, g.o.g, "");
            long longValue = com.anythink.core.common.k.p.a(context, g.o, g.o.h, (Long) 0L).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = longValue;
            if (currentTimeMillis - longValue < 0) {
                j2 = 0;
            }
            if (currentTimeMillis - j2 <= (i == 0 ? b2.N() : b2.B())) {
                new StringBuilder("psid updataTime<=").append(b2.N());
                this.t = b3;
                if (!TextUtils.isEmpty(b4)) {
                    this.u = new JSONObject(b4);
                }
                new StringBuilder("psid :").append(this.t);
                return 0L;
            }
            new StringBuilder("psid updataTime>").append(b2.N());
            String x = x();
            String str2 = "";
            String str3 = x;
            if (TextUtils.isEmpty(x)) {
                str3 = com.anythink.core.common.k.d.d(context) + com.anythink.core.common.k.d.f();
                str2 = String.valueOf(new Random().nextInt(10000000));
            }
            this.t = com.anythink.core.common.k.f.a(str3 + str + str2 + currentTimeMillis);
            this.u = new JSONObject();
            com.anythink.core.common.k.p.a(context, g.o, g.o.f, this.t);
            com.anythink.core.common.k.p.a(context, g.o, g.o.g, "");
            com.anythink.core.common.k.p.a(context, g.o, g.o.h, currentTimeMillis);
            new StringBuilder("psid :").append(this.t);
            com.anythink.core.common.j.c.a((String) null, "1", str2, String.valueOf(currentTimeMillis));
            if (i == 0) {
                this.d = currentTimeMillis;
            }
            return currentTimeMillis;
        }
    }

    public final void a(int i) {
        if (i == 2) {
            this.T = 2;
        } else {
            this.T = 1;
        }
    }

    public final void a(Activity activity) {
        WeakReference<Activity> weakReference = this.e;
        if (weakReference == null || weakReference.get() == null) {
            this.e = new WeakReference<>(activity);
        }
    }

    public final void a(Context context) {
        if (context == null) {
            Log.w("SDK.init", "ATSDK.setContext() is null!");
        } else {
            this.k = context;
        }
    }

    public final void a(final Context context, final DeviceInfoCallback deviceInfoCallback) {
        if (this.I) {
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.b.n.3
                @Override // java.lang.Runnable
                public final void run() {
                    com.anythink.core.c.a b2 = com.anythink.core.c.b.a(context).b(n.a().p());
                    String F = b2 != null ? b2.F() : "";
                    boolean z = true;
                    if (!TextUtils.isEmpty(F)) {
                        try {
                            JSONObject jSONObject = new JSONObject(F);
                            z = true;
                            if (!jSONObject.isNull("a")) {
                                z = jSONObject.optInt("a") == 1;
                            }
                        } catch (Exception e) {
                            z = true;
                        }
                    }
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        IExHandler b3 = n.a().b();
                        if (b3 != null) {
                            b3.fillTestDeviceData(jSONObject2, b2);
                        }
                        jSONObject2.put("GAID", com.anythink.core.common.k.d.r(context));
                        jSONObject2.put("AndroidID", z ? com.anythink.core.common.k.d.d(context) : "");
                        jSONObject2.put("How to config TestMode", "Please visit the document center and learn more through： Integration(Basic) -> How To Test");
                        com.anythink.core.common.k.n.a("testModeDeviceInfo", jSONObject2.toString());
                        if (deviceInfoCallback != null) {
                            deviceInfoCallback.deviceInfo(jSONObject2.toString());
                        }
                    } catch (Throwable th) {
                    }
                }
            });
            return;
        }
        Log.e(g.n, "You should init SDK first.");
        if (deviceInfoCallback != null) {
            deviceInfoCallback.deviceInfo("You should init SDK first.");
        }
    }

    public final void a(Context context, String str, ATDebuggerConfig aTDebuggerConfig) {
        IExHandler b2;
        if (context == null) {
            if (A()) {
                Log.e("SDK.init", "setDebuggerConfig fail, because context is null.");
                return;
            }
            return;
        }
        if (a().k == null) {
            a().a(context.getApplicationContext());
        }
        this.Q = str;
        this.R = aTDebuggerConfig;
        String d = com.anythink.core.common.k.d.d(context);
        boolean z = true;
        if (TextUtils.isEmpty(d) || !d.equals(this.Q)) {
            String f = com.anythink.core.common.k.d.f();
            if ((TextUtils.isEmpty(f) || !f.equals(this.Q)) && ((b2 = a().b()) == null || !b2.checkDebuggerDevice(context, this.Q))) {
                z = false;
            }
        }
        this.S = z;
        if (TextUtils.isEmpty(this.Q)) {
            if (A()) {
                Log.e("SDK.init", "Setting Debugger's device fail, because deviceId is empty.");
            }
            this.S = false;
        } else if (!this.S) {
            if (A()) {
                Log.e("SDK.init", "The incoming device id does not match the current device id, and the debugger mode cannot take effect.");
            }
        } else {
            if (A()) {
                Log.i("SDK.init", "Setting Debugger's device success.");
            }
            if (this.R == null || !A()) {
                return;
            }
            Log.i("SDK.init", "Debugger config is in effect now.");
        }
    }

    public final void a(final Context context, final String str, final String str2) {
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.b.n.2
            @Override // java.lang.Runnable
            public final void run() {
                if (com.anythink.core.c.b.a(context).a(str)) {
                    com.anythink.core.c.b.a(context).a(str, str2);
                }
            }
        });
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x01eb -> B:35:0x0142). Please submit an issue!!! */
    public final void a(final Context context, final String str, String str2, final ATNetworkConfig aTNetworkConfig) {
        synchronized (this) {
            if (context == null) {
                return;
            }
            this.k = context.getApplicationContext();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (this.I) {
                    return;
                }
                this.I = true;
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    long longValue = com.anythink.core.common.k.p.a(context, g.o, g.o.k, (Long) 0L).longValue();
                    this.D = longValue;
                    if (longValue == 0) {
                        this.D = currentTimeMillis;
                        com.anythink.core.common.k.p.a(context, g.o, g.o.k, currentTimeMillis);
                    }
                    this.E = ((a(currentTimeMillis) - a(this.D)) / 86400000) + 1;
                    this.d = 0L;
                    com.anythink.core.a.a.a(context.getApplicationContext()).a();
                    this.Z = com.anythink.core.common.k.p.b(context, g.o, g.o.o, 1);
                    final Context applicationContext = context.getApplicationContext();
                    a(applicationContext);
                    this.l = str;
                    com.anythink.core.common.k.p.a(this.k, g.o, g.p, str);
                    this.m = str2;
                    com.anythink.core.common.k.p.a(this.k, g.o, g.q, str2);
                    this.U = com.anythink.core.common.k.h.a();
                    try {
                        if (this.v != null) {
                            this.k.unregisterReceiver(this.v);
                            k.a(this.k).a(this.v);
                        }
                        this.v = null;
                    } catch (Throwable th) {
                    }
                    try {
                        this.v = new AnonymousClass10();
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                        intentFilter.addAction(g.C);
                        this.k.registerReceiver(this.v, intentFilter);
                        k.a(this.k).a(this.v, intentFilter);
                    } catch (Throwable th2) {
                    }
                    com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.b.n.6
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                com.anythink.core.common.j.b.a().a(applicationContext);
                                n.this.a(applicationContext, str, 0);
                                n.a(n.this, context);
                                h.a(applicationContext).a();
                                n.b(n.this);
                                n.N();
                                com.anythink.core.common.a.j.a().b();
                                com.anythink.core.common.res.d.a(n.this.g()).b();
                            } catch (Exception e) {
                            }
                        }
                    });
                    ((Application) this.k).registerActivityLifecycleCallbacks(new f(c(this.k)));
                    a(new Runnable() { // from class: com.anythink.core.common.b.n.7
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.anythink.core.common.k.d.p(applicationContext);
                        }
                    }, 5000L);
                    com.anythink.core.common.k.b.a.a().a(new AnonymousClass1());
                    com.anythink.core.common.p.a().a(this.k);
                    com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.b.n.8
                        @Override // java.lang.Runnable
                        public final void run() {
                            n.this.b();
                            if (n.this.z != null) {
                                n.this.z.initDeviceInfo(context);
                            }
                            com.anythink.core.c.e.a(applicationContext).a();
                            com.anythink.core.common.k.d.r(n.this.k);
                            x.a(context);
                        }
                    });
                    com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.b.n.9
                        @Override // java.lang.Runnable
                        public final void run() {
                            n nVar = n.this;
                            n.a(nVar, nVar.k, aTNetworkConfig);
                        }
                    });
                    a(context.getApplicationContext(), str, str2);
                    com.anythink.core.common.k.b.a.a().a(new AnonymousClass11(context, str));
                } catch (Exception e) {
                }
            }
        }
    }

    public final void a(Context context, final String str, Map<String, Object> map) {
        if (A()) {
            Log.i(g.n, "Requesting placement(" + str + ") setting Info，please wait a moment.");
            new com.anythink.core.common.g.j(context, a().p(), a().q(), str, "", map, new HashMap(1)).a(0, new com.anythink.core.common.g.i() { // from class: com.anythink.core.common.b.n.13
                @Override // com.anythink.core.common.g.i
                public final void onLoadCanceled(int i) {
                }

                @Override // com.anythink.core.common.g.i
                public final void onLoadError(int i, String str2, AdError adError) {
                    Log.i(g.n, "********************************** Get Splash Config Start(" + str + ") *************************************");
                    Log.i(g.n, "This placement(" + str + ") request error:" + adError.printStackTrace());
                    StringBuilder sb = new StringBuilder("********************************** Get Splash Config End(");
                    sb.append(str);
                    sb.append(") *************************************");
                    Log.i(g.n, sb.toString());
                }

                @Override // com.anythink.core.common.g.i
                public final void onLoadFinish(int i, Object obj) {
                    com.anythink.core.c.d b2 = com.anythink.core.c.d.b((String) obj);
                    if (!"4".equals(String.valueOf(b2.X()))) {
                        Log.i(g.n, "********************************** Get Splash Config Start(" + str + ") *************************************");
                        Log.i(g.n, "This placement(" + str + ") does not belong to Splash!");
                        Log.i(g.n, "********************************** Get Splash Config End(" + str + ") *************************************");
                        return;
                    }
                    Log.i(g.n, "********************************** Get Splash Config Start(" + str + ") *************************************");
                    List<ai> F = b2.F();
                    if (F == null || F.size() == 0) {
                        Log.i(g.n, ErrorCode.getErrorCode(ErrorCode.noAdsourceConfig, "", "").getDesc());
                    } else {
                        for (ai aiVar : F) {
                            Log.i(g.n, "------------------------------------------------");
                            Log.i(g.n, "Network Firm Id:" + aiVar.c());
                            Log.i(g.n, "AdSource Id:" + aiVar.t());
                            Log.i(g.n, "Network Content:" + aiVar.g());
                            Log.i(g.n, "------------------------------------------------");
                        }
                    }
                    Log.i(g.n, "********************************** Get Splash Config End(" + str + ") *************************************");
                }

                @Override // com.anythink.core.common.g.i
                public final void onLoadStart(int i) {
                }
            });
            return;
        }
        Log.i(g.n, "********************************** Get Splash Config Start(" + str + ") *************************************");
        Log.i(g.n, "Only use in debug mode!");
        Log.i(g.n, "********************************** Get Splash Config End(" + str + ") *************************************");
    }

    public final void a(Location location) {
        synchronized (this) {
            this.L = location;
        }
    }

    public final void a(ATPrivacyConfig aTPrivacyConfig) {
        this.Y = aTPrivacyConfig;
    }

    public final void a(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.n.post(runnable);
        }
    }

    public final void a(Runnable runnable, long j2) {
        if (j2 > 0 || Looper.getMainLooper() != Looper.myLooper()) {
            this.n.postDelayed(runnable, j2);
        } else {
            runnable.run();
        }
    }

    public final void a(String str) {
        this.o = str;
    }

    public final void a(String str, ATCustomAdapterConfig aTCustomAdapterConfig) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (this.r == null) {
                this.r = new ConcurrentHashMap<>();
            }
            if (aTCustomAdapterConfig == null) {
                this.r.remove(str);
            } else {
                this.r.put(str, aTCustomAdapterConfig);
            }
        }
    }

    public final void a(final String str, final String str2, final String str3, final Map<String, Object> map) {
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.b.n.4
            @Override // java.lang.Runnable
            public final void run() {
                boolean z;
                if (!n.this.I) {
                    Log.e("SDK.init", "SDK should be inited first!");
                    return;
                }
                com.anythink.core.common.f b2 = v.a().b(str);
                com.anythink.core.c.d a2 = com.anythink.core.c.e.a(n.this.k).a(str);
                String b3 = w.a().b(str);
                String str4 = (TextUtils.isEmpty(str2) || !com.anythink.core.common.k.g.c(str2)) ? "" : str2;
                com.anythink.core.common.e.b bVar = null;
                if (b2 != null) {
                    z = b2.e();
                    bVar = b2.a(n.this.k, false, false, map);
                } else {
                    z = false;
                }
                if (bVar != null) {
                    com.anythink.core.common.e.e N = bVar.h().N();
                    N.d(1);
                    N.C = str4;
                    com.anythink.core.common.j.a.a(n.this.k).a(16, N);
                    return;
                }
                com.anythink.core.common.e.e a3 = s.a(TextUtils.isEmpty(b3) ? "" : b3, str, "", a2, "", 0, 0, 0, map);
                a3.d(z ? 3 : 2);
                if (a2 == null) {
                    a3.z(str3);
                }
                a3.C = str4;
                com.anythink.core.common.j.a.a(n.this.k).a(16, a3);
            }
        });
    }

    public final void a(String str, List<String> list) {
        this.P.put(str, list);
    }

    public final void a(String str, Map<String, Object> map) {
        if (map != null) {
            this.q.put(str, map);
        }
    }

    public final void a(String str, Map<String, Object> map, String... strArr) {
        com.anythink.core.common.e.e eVar;
        if (map == null || map.containsKey(ATInitMediation.KEY_LOCAL)) {
            return;
        }
        try {
            eVar = (com.anythink.core.common.e.e) map.get(g.k.h);
        } catch (Throwable th) {
            eVar = null;
        }
        map.remove(g.k.h);
        String jSONObject = new JSONObject(map).toString();
        Log.e(g.n, "Mismatched initialization parameters! server params: [" + str + "], " + jSONObject);
        com.anythink.core.common.k.p.a(this.k, g.x, str, jSONObject);
        if (eVar == null || strArr == null) {
            return;
        }
        String str2 = strArr[0];
        String str3 = null;
        try {
            if (strArr.length > 1) {
                str3 = strArr[1];
            }
            com.anythink.core.common.j.c.a(eVar, str2, str3);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void a(List<String> list) {
        try {
            this.O = list;
            if (list == null || list.isEmpty()) {
                this.N = null;
            } else {
                this.N = new JSONArray((Collection) list);
            }
        } catch (Exception e) {
        }
    }

    public final void a(Map<String, Object> map) {
        if (map != null && map.containsKey("channel")) {
            Object obj = map.get("channel");
            String obj2 = obj != null ? obj.toString() : "";
            this.F = obj2;
            if (!com.anythink.core.common.k.g.a(obj2)) {
                this.F = null;
                map.remove("channel");
            }
        }
        if (map != null && map.containsKey("sub_channel")) {
            Object obj3 = map.get("sub_channel");
            String obj4 = obj3 != null ? obj3.toString() : "";
            this.G = obj4;
            if (!com.anythink.core.common.k.g.b(obj4)) {
                this.G = null;
                map.remove("sub_channel");
            }
        }
        this.p.clear();
        if (map != null) {
            this.p.putAll(map);
        }
        if (!TextUtils.isEmpty(this.F)) {
            this.p.put("channel", this.F);
        }
        if (TextUtils.isEmpty(this.G)) {
            return;
        }
        this.p.put("sub_channel", this.G);
    }

    public final void a(boolean z) {
        synchronized (this) {
            this.M = z ? "1" : "2";
        }
    }

    public final void a(String... strArr) {
        synchronized (this) {
            if (strArr == null) {
                this.s = null;
                return;
            }
            this.s = new HashMap();
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                this.s.put(strArr[i2], Boolean.TRUE);
                i = i2 + 1;
            }
        }
    }

    public final void a(String[] strArr, IATAdFilter iATAdFilter) {
        ConcurrentHashMap<String, IATAdFilter> concurrentHashMap = this.W;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        if (this.W == null) {
            this.W = new ConcurrentHashMap<>();
        }
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            this.W.put(strArr[i2], iATAdFilter);
            i = i2 + 1;
        }
    }

    public final ATCustomAdapterConfig b(String str) {
        if (this.r == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.r.get(str);
    }

    public final IExHandler b() {
        synchronized (this) {
            if (this.i) {
                return this.z;
            }
            try {
                Constructor declaredConstructor = Class.forName("com.anythink.pd.ExHandler").asSubclass(IExHandler.class).getDeclaredConstructor(null);
                declaredConstructor.setAccessible(true);
                this.z = (IExHandler) declaredConstructor.newInstance(new Object[0]);
            } catch (Exception e) {
            }
            this.i = true;
            return this.z;
        }
    }

    public final void b(int i) {
        this.f = i;
    }

    public final void b(final Context context) {
        if (A()) {
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.b.n.12
                @Override // java.lang.Runnable
                public final void run() {
                    boolean z;
                    try {
                        LocalBroadcastManager.class.getName();
                        z = true;
                    } catch (Throwable th) {
                        z = false;
                    }
                    try {
                        LocalBroadcastManager.class.getName();
                        z = true;
                    } catch (Throwable th2) {
                    }
                    if (!z) {
                        try {
                            Log.e(g.n, "Missing: LocalBroadcastManager");
                        } catch (Exception e) {
                            return;
                        }
                    }
                    ArrayList<String> arrayList = new ArrayList();
                    Enumeration<String> entries = new DexFile(context.getPackageCodePath()).entries();
                    while (entries.hasMoreElements()) {
                        String nextElement = entries.nextElement();
                        if (nextElement.contains("com.anythink.network") && nextElement.contains("InitManager") && !nextElement.contains("$")) {
                            arrayList.add(nextElement);
                        }
                    }
                    Log.i(g.n, "********************************** Network Integration Status *************************************");
                    if (arrayList.size() != 0) {
                        Log.i(g.n, "----------------------------------------");
                    }
                    for (String str : arrayList) {
                        try {
                            Object invoke = Class.forName(str).getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
                            if (invoke != null && (invoke instanceof ATInitMediation)) {
                                ATInitMediation aTInitMediation = (ATInitMediation) invoke;
                                String networkName = aTInitMediation.getNetworkName();
                                if (!TextUtils.isEmpty(networkName)) {
                                    String networkVersion = aTInitMediation.getNetworkVersion();
                                    if (TextUtils.isEmpty(networkVersion)) {
                                        Log.i(g.n, "NetworkName: ".concat(String.valueOf(networkName)));
                                    } else {
                                        Log.i(g.n, "NetworkName: " + networkName + "  (v" + networkVersion + ")");
                                    }
                                    boolean h = n.h(aTInitMediation.getNetworkSDKClass());
                                    boolean b2 = n.b(aTInitMediation.getPluginClassStatus());
                                    boolean a2 = n.a(context, aTInitMediation.getActivityStatus());
                                    boolean b3 = n.b(context, aTInitMediation.getServiceStatus());
                                    boolean c = n.c(context, aTInitMediation.getProviderStatus());
                                    boolean d = n.d(context, aTInitMediation.getMetaValutStatus());
                                    boolean e2 = n.e(context, aTInitMediation.getPermissionStatus());
                                    aTInitMediation.getResourceStatus();
                                    if (h && b2 && a2 && b3 && c && d && e2) {
                                        Log.i(g.n, "Status: Success");
                                    } else {
                                        Log.e(g.n, "Status: Fail");
                                    }
                                    Log.i(g.n, "----------------------------------------");
                                }
                            }
                        } catch (Throwable th3) {
                        }
                    }
                    Log.i(g.n, "********************************** Network Integration Status *************************************");
                }
            });
        }
    }

    public final void b(String str, List<String> list) {
        ConcurrentHashMap<String, List<String>> concurrentHashMap = this.P;
        concurrentHashMap.put(str + "_network_firm", list);
    }

    public final void b(boolean z) {
        this.C = z;
    }

    public final String c() {
        return b() != null ? g.c.e : g.c.f;
    }

    public final void c(int i) {
        this.Z = i;
    }

    public final void c(Runnable runnable) {
        this.n.removeCallbacks(runnable);
    }

    public final void c(boolean z) {
        this.H = z;
    }

    public final boolean c(String str) {
        synchronized (this) {
            if (this.s == null) {
                return false;
            }
            return this.s.containsKey(str);
        }
    }

    public final long d(int i) {
        if (i == 1 || i == 4) {
            com.anythink.core.c.b.a(this.k);
            return com.anythink.core.c.b.a() * 1024;
        }
        return 26214400L;
    }

    public final String d() {
        return this.o;
    }

    public final Map<String, Object> d(String str) {
        HashMap hashMap = new HashMap();
        Map<String, Object> map = this.q.get(str);
        ConcurrentHashMap<String, Object> concurrentHashMap = this.p;
        if (concurrentHashMap != null) {
            hashMap.putAll(concurrentHashMap);
        }
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.remove("channel");
        hashMap.remove("sub_channel");
        Object obj = this.p.get("channel");
        Object obj2 = this.p.get("sub_channel");
        if (obj != null) {
            hashMap.put("channel", obj);
        }
        if (obj2 != null) {
            hashMap.put("sub_channel", obj2);
        }
        return hashMap;
    }

    public final void d(boolean z) {
        this.V = z;
    }

    public final int e() {
        return this.T;
    }

    public final void e(String str) {
        this.F = str;
        this.p.put("channel", str);
    }

    public final void f(String str) {
        this.G = str;
        this.p.put("sub_channel", str);
    }

    public final String[] f() {
        Set<String> keySet;
        int size;
        synchronized (this) {
            if (this.s == null || (size = (keySet = this.s.keySet()).size()) <= 0) {
                return null;
            }
            String[] strArr = new String[size];
            keySet.toArray(strArr);
            return strArr;
        }
    }

    public final Context g() {
        return this.k;
    }

    public final String g(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String optString = this.u.optString(str);
        if (TextUtils.isEmpty(optString)) {
            return u(str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(": sessionid exists.");
        return optString;
    }

    public final long h() {
        return this.D;
    }

    public final long i() {
        return this.E;
    }

    public final void i(String str) {
        this.x = str;
        com.anythink.core.common.k.p.a(this.k, g.w, g.o.l, str);
    }

    public final int j() {
        return this.f;
    }

    public final void j(String str) {
        this.y = str;
        com.anythink.core.common.k.p.a(this.k, g.w, g.o.m, str);
    }

    public final List<String> k() {
        return this.O;
    }

    public final void k(String str) {
        com.anythink.core.common.k.p.a(this.k, g.o, g.o.i, str);
        this.w = str;
    }

    public final List<String> l(String str) {
        return this.P.get(str);
    }

    public final JSONArray l() {
        return this.N;
    }

    public final List<String> m(String str) {
        ConcurrentHashMap<String, List<String>> concurrentHashMap = this.P;
        return concurrentHashMap.get(str + "_network_firm");
    }

    public final Map<String, Object> m() {
        return this.p;
    }

    public final String n() {
        Object obj = this.p.get("channel");
        return obj != null ? obj.toString() : "";
    }

    public final IATAdFilter o(String str) {
        ConcurrentHashMap<String, IATAdFilter> concurrentHashMap;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = this.W) == null) {
            return null;
        }
        return concurrentHashMap.get(str);
    }

    public final String o() {
        Object obj = this.p.get("sub_channel");
        return obj != null ? obj.toString() : "";
    }

    public final String p() {
        if (TextUtils.isEmpty(this.l)) {
            this.l = com.anythink.core.common.k.p.b(this.k, g.o, g.p, "");
        }
        return this.l;
    }

    public final void p(String str) {
        this.X = str;
    }

    public final String q() {
        if (TextUtils.isEmpty(this.m)) {
            this.m = com.anythink.core.common.k.p.b(this.k, g.o, g.q, "");
        }
        return this.m;
    }

    public final String r() {
        try {
            if (TextUtils.isEmpty(this.t)) {
                a(this.k, p(), 0);
            }
        } catch (Exception e) {
        }
        return this.t;
    }

    public final Location s() {
        return this.L;
    }

    public final String t() {
        return this.M;
    }

    public final boolean u() {
        return this.S;
    }

    public final boolean v() {
        return this.S && this.R != null;
    }

    public final ATDebuggerConfig w() {
        return this.R;
    }

    public final String x() {
        if (TextUtils.isEmpty(this.w)) {
            this.w = com.anythink.core.common.k.p.b(this.k, g.o, g.o.i, "");
        }
        return this.w;
    }

    public final String y() {
        if (TextUtils.isEmpty(this.x)) {
            this.x = com.anythink.core.common.k.p.b(this.k, g.w, g.o.l, "");
        }
        return this.x;
    }

    public final String z() {
        if (TextUtils.isEmpty(this.y)) {
            this.y = com.anythink.core.common.k.p.b(this.k, g.w, g.o.m, "");
        }
        return this.y;
    }
}

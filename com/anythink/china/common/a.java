package com.anythink.china.common;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.anythink.china.common.a.a;
import com.anythink.china.common.a.e;
import com.anythink.china.common.a.g;
import com.anythink.china.common.service.ApkDownloadService;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.i;
import com.anythink.core.common.k.h;
import com.anythink.core.common.m;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/china/common/a.class */
public class a implements g {
    public static final String a = a.class.getSimpleName();
    public static final String b = "action_offer_download_start";
    public static final String c = "action_offer_download_end";
    public static final String d = "action_offer_install_start";
    public static final String e = "action_offer_install_successful";
    public static final String f = "receiver_extra_offer_id";
    public static final String g = "receiver_extra_click_id";
    private static volatile a h;
    private Context i;
    private ConcurrentHashMap<String, e> n;
    private ConcurrentHashMap<String, e> o;
    private ConcurrentHashMap<String, e> p;
    private Map<String, e> q;
    private BroadcastReceiver t;
    private ApkDownloadService.a u;
    private BroadcastReceiver v;
    private final int r = 1;
    private long s = 604800000;
    private ServiceConnection w = new ServiceConnection() { // from class: com.anythink.china.common.a.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            String str = a.a;
            try {
                a.this.u = (ApkDownloadService.a) iBinder;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            String str = a.a;
            a.this.u = null;
        }
    };
    private List<e> j = Collections.synchronizedList(new LinkedList());
    private ConcurrentHashMap<String, e> k = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, e> l = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, a.InterfaceC0048a> m = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.china.common.a$3  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/china/common/a$3.class */
    public final class AnonymousClass3 implements a.InterfaceC0048a {
        AnonymousClass3() {
        }

        @Override // com.anythink.china.common.a.a.InterfaceC0048a
        public final void a(final e eVar, final long j) {
            String str = a.a;
            Log.i(str, "onSuccess: " + eVar.c);
            n.a().a(new Runnable() { // from class: com.anythink.china.common.a.3.2
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.m.remove(eVar.n);
                    a.this.k.remove(eVar.n);
                    if (a.this.n == null) {
                        a.this.n = new ConcurrentHashMap();
                    }
                    a.this.n.put(eVar.n, eVar);
                    Intent intent = new Intent();
                    intent.setAction(a.c);
                    intent.setPackage(a.this.i.getPackageName());
                    intent.putExtra(a.f, eVar.f);
                    intent.putExtra(a.g, eVar.m);
                    m.a(a.this.i).a(intent);
                    a.this.b(eVar);
                    com.anythink.china.common.b.a.a(a.this.i).c(eVar);
                    com.anythink.china.common.b.a.a(a.this.i).a(eVar);
                    com.anythink.core.common.j.c.a(eVar.a, eVar.f, eVar.b, 2, (String) null, j, eVar.h);
                    a.this.b();
                }
            });
        }

        @Override // com.anythink.china.common.a.a.InterfaceC0048a
        public final void a(final e eVar, final long j, final long j2) {
            String str = a.a;
            new StringBuilder("onStartBefore: ").append(eVar.b);
            n.a().a(new Runnable() { // from class: com.anythink.china.common.a.3.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (j < j2) {
                        a aVar = a.this;
                        aVar.d("正在下载： " + eVar.c);
                        com.anythink.china.common.b.a.a(a.this.i).c(eVar);
                        com.anythink.china.common.b.a.a(a.this.i).a(eVar, j, j2);
                    }
                    Intent intent = new Intent();
                    intent.setAction(a.b);
                    intent.setPackage(a.this.i.getPackageName());
                    intent.putExtra(a.f, eVar.f);
                    intent.putExtra(a.g, eVar.m);
                    m.a(a.this.i).a(intent);
                    com.anythink.core.common.j.c.a(eVar.a, eVar.f, eVar.b, 1, (String) null, 0L, j2);
                }
            });
        }

        @Override // com.anythink.china.common.a.a.InterfaceC0048a
        public final void a(final e eVar, final long j, final long j2, final int i) {
            String str = a.a;
            n.a().a(new Runnable() { // from class: com.anythink.china.common.a.3.5
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.k.remove(eVar.n);
                    com.anythink.china.common.b.a.a(a.this.i).c(eVar);
                    int i2 = i;
                    if (i2 == 2) {
                        String str2 = a.a;
                        Log.e(str2, "(" + eVar.c + ") pause download");
                        com.anythink.china.common.b.a.a(a.this.i).a(eVar, j, j2);
                        a.this.b();
                    } else if (i2 == 3) {
                        String str3 = a.a;
                        Log.e(str3, "(" + eVar.c + ") stop download");
                    }
                }
            });
        }

        @Override // com.anythink.china.common.a.a.InterfaceC0048a
        public final void a(final e eVar, final String str) {
            String str2 = a.a;
            Log.e(str2, "(" + eVar.c + ") download fail: " + str);
            n.a().a(new Runnable() { // from class: com.anythink.china.common.a.3.4
                @Override // java.lang.Runnable
                public final void run() {
                    a aVar = a.this;
                    aVar.d("下载失败： " + eVar.c);
                    a.this.m.remove(eVar.n);
                    a.this.k.remove(eVar.n);
                    if (a.this.q == null) {
                        a.this.q = Collections.synchronizedMap(new HashMap());
                    }
                    a.this.q.put(eVar.n, eVar);
                    com.anythink.china.common.b.a.a(a.this.i).c(eVar);
                    com.anythink.china.common.b.a.a(a.this.i).a(eVar, 0L, 100L);
                    com.anythink.core.common.j.c.a(eVar.a, eVar.f, eVar.b, 3, str, 0L, eVar.h);
                    a.this.b();
                }
            });
        }

        @Override // com.anythink.china.common.a.a.InterfaceC0048a
        public final void b(final e eVar, final long j, final long j2) {
            n.a().a(new Runnable() { // from class: com.anythink.china.common.a.3.3
                @Override // java.lang.Runnable
                public final void run() {
                    com.anythink.china.common.b.a.a(a.this.i).a(eVar, j, j2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.china.common.a$4  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/china/common/a$4.class */
    public final class AnonymousClass4 implements Runnable {
        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (a.this.q != null) {
                synchronized (a.this.q) {
                    Iterator it = a.this.q.entrySet().iterator();
                    while (it.hasNext()) {
                        e eVar = (e) ((Map.Entry) it.next()).getValue();
                        String str = a.a;
                        Log.i(str, "(" + eVar.c + ") retry to download");
                        eVar.e();
                        a.this.d(eVar);
                        it.remove();
                    }
                }
            }
        }
    }

    private a(Context context) {
        this.i = context.getApplicationContext();
        String a2 = com.anythink.china.common.c.b.a();
        if (!TextUtils.isEmpty(a2)) {
            File file = new File(a2);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        try {
            this.v = new BroadcastReceiver() { // from class: com.anythink.china.common.a.2
                @Override // android.content.BroadcastReceiver
                public final void onReceive(Context context2, Intent intent) {
                    try {
                        ConnectivityManager connectivityManager = (ConnectivityManager) context2.getSystemService("connectivity");
                        if (connectivityManager == null || !h.a("android.permission.ACCESS_NETWORK_STATE", context2)) {
                            return;
                        }
                        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                        if (h.a(context2) && activeNetworkInfo.getType() == 1) {
                            a.a(a.this);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            this.i.registerReceiver(this.v, intentFilter);
        } catch (Throwable th) {
        }
    }

    public static a a(Context context) {
        if (h == null) {
            synchronized (a.class) {
                try {
                    if (h == null) {
                        h = new a(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return h;
    }

    private void a(long j) {
        if (j > 0) {
            this.s = j;
        }
    }

    private static void a(e eVar, boolean z) {
        if (eVar.l != null) {
            eVar.l.a(eVar.j, eVar.a, eVar.b, z);
        }
    }

    static /* synthetic */ void a(a aVar) {
        com.anythink.core.common.k.b.a.a().a(new AnonymousClass4());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final String str) {
        n.a().a(new Runnable() { // from class: com.anythink.china.common.a.5
            @Override // java.lang.Runnable
            public final void run() {
                Toast.makeText(a.this.i, str, 0).show();
            }
        });
    }

    private void e(e eVar) {
        this.k.put(eVar.n, eVar);
        this.m.put(eVar.n, new AnonymousClass3());
        try {
            if (this.u != null) {
                this.u.a(eVar.n);
                return;
            }
            Intent intent = new Intent();
            intent.setClass(this.i, ApkDownloadService.class);
            intent.putExtra(ApkDownloadService.a, eVar.n);
            this.i.bindService(intent, this.w, 1);
        } catch (Throwable th) {
        }
    }

    private static String f(e eVar) {
        return com.anythink.china.common.c.b.a(eVar.n) + com.anythink.china.common.a.a.g;
    }

    private void g() {
        com.anythink.core.common.k.b.a.a().a(new AnonymousClass4());
    }

    private void h() {
        try {
            if (this.t != null) {
                return;
            }
            this.t = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
            intentFilter.addDataScheme("package");
            this.i.registerReceiver(this.t, intentFilter);
        } catch (Throwable th) {
        }
    }

    private void i() {
        try {
            if (this.t != null) {
                this.i.unregisterReceiver(this.t);
                this.t = null;
            }
        } catch (Throwable th) {
        }
    }

    @Override // com.anythink.china.common.a.g
    public final int a() {
        return 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0207 A[Catch: all -> 0x0286, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0286, blocks: (B:39:0x0172, B:42:0x0180, B:44:0x0192, B:47:0x019b, B:52:0x01c4, B:54:0x01d2, B:59:0x01e5, B:61:0x01f6, B:64:0x0207, B:65:0x0213, B:67:0x0221, B:68:0x022d, B:72:0x0240), top: B:80:0x0172 }] */
    @Override // com.anythink.china.common.a.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(android.content.Context r8, com.anythink.core.common.e.j r9, com.anythink.core.common.e.i r10, java.lang.String r11, java.lang.String r12, java.lang.Runnable r13, com.anythink.core.common.f.b r14) {
        /*
            Method dump skipped, instructions count: 676
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.china.common.a.a(android.content.Context, com.anythink.core.common.e.j, com.anythink.core.common.e.i, java.lang.String, java.lang.String, java.lang.Runnable, com.anythink.core.common.f.b):void");
    }

    @Override // com.anythink.china.common.a.g
    public final void a(e eVar) {
        if (eVar == null) {
            return;
        }
        if (this.k.containsKey(eVar.n)) {
            File file = new File(com.anythink.china.common.c.b.a(eVar.n) + com.anythink.china.common.a.a.e);
            File file2 = new File(com.anythink.china.common.c.b.a(eVar.n) + com.anythink.china.common.a.a.f);
            if (file.exists() && file2.exists()) {
                String str = a;
                Log.i(str, "(" + eVar.c + ") is downloading, do nothing");
                StringBuilder sb = new StringBuilder("正在下载中： ");
                sb.append(eVar.c);
                d(sb.toString());
                return;
            }
            this.k.remove(eVar.n);
        }
        int size = this.j.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                this.j.add(eVar);
                com.anythink.china.common.b.a.a(this.i).c(eVar);
                com.anythink.china.common.b.a.a(this.i).a(eVar, 0L, 100L, true);
                return;
            } else if (TextUtils.equals(eVar.n, this.j.get(i2).n)) {
                String str2 = a;
                Log.i(str2, "(" + eVar.c + ") is waiting for downloading, do nothing");
                StringBuilder sb2 = new StringBuilder("等待下载： ");
                sb2.append(eVar.c);
                d(sb2.toString());
                return;
            } else {
                i = i2 + 1;
            }
        }
    }

    @Override // com.anythink.china.common.a.g
    public final void a(String str, String str2) {
        e eVar;
        try {
            if (str2.equals(e.a.FAIL.toString()) && this.q != null && this.q.containsKey(str)) {
                e eVar2 = this.q.get(str);
                String str3 = a;
                Log.i(str3, "(" + eVar2.c + ") onCleanNotification: download fail");
                com.anythink.china.common.b.a.a(this.i).c(eVar2);
                this.q.remove(str);
            }
            if (str2.equals(e.a.FINISH.toString()) && this.n != null && this.n.containsKey(str)) {
                e eVar3 = this.n.get(str);
                String str4 = a;
                Log.i(str4, "(" + eVar3.c + ") onCleanNotification: download success");
                com.anythink.china.common.b.a.a(this.i).c(eVar3);
                this.n.remove(str);
            }
            if (str2.equals(e.a.INSTALLED.toString()) && this.p != null && this.p.containsKey(str)) {
                e eVar4 = this.p.get(str);
                String str5 = a;
                Log.i(str5, "(" + eVar4.c + ") onCleanNotification: install success");
                com.anythink.china.common.b.a.a(this.i).c(eVar4);
                this.p.remove(str);
            }
            if (!str2.equals(e.a.PAUSE.toString()) || (eVar = this.l.get(str)) == null) {
                return;
            }
            if (this.u != null) {
                this.u.c(eVar.n);
            }
            this.l.remove(str);
            String str6 = a;
            Log.i(str6, "(" + eVar.c + ") onCleanNotification: stop download");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.anythink.china.common.a.g
    public final void a(String str, String str2, int i) {
        e eVar;
        try {
            if (str2.equals(e.a.FAIL.toString())) {
                if (this.q != null) {
                    e remove = this.q.remove(str);
                    if (remove == null) {
                        com.anythink.china.common.b.a.a(this.i).a(i);
                        return;
                    }
                    remove.e();
                    Log.i(a, "(" + remove.c + ") onClickNotification: download fail to retry");
                    d(remove);
                }
            } else if (str2.equals(e.a.FINISH.toString())) {
                if (this.n != null) {
                    e eVar2 = this.n.get(str);
                    if (eVar2 == null) {
                        com.anythink.china.common.b.a.a(this.i).a(i);
                        return;
                    }
                    Log.i(a, "(" + eVar2.c + ") onClickNotification: start intall");
                    com.anythink.china.common.b.a.a(this.i).c(eVar2);
                    com.anythink.china.common.b.a.a(this.i).a(eVar2);
                    b(eVar2);
                }
            } else if (str2.equals(e.a.INSTALLED.toString())) {
                if (this.p != null) {
                    e eVar3 = this.p.get(str);
                    if (eVar3 == null) {
                        com.anythink.china.common.b.a.a(this.i).a(i);
                        return;
                    }
                    Log.i(a, "(" + eVar3.c + ") onClickNotification: start open");
                    com.anythink.china.common.b.a.a(this.i).c(eVar3);
                    a(eVar3, true);
                }
            } else if (str2.equals(e.a.LOADING.toString())) {
                e eVar4 = this.k.get(str);
                if (eVar4 == null) {
                    com.anythink.china.common.b.a.a(this.i).a(i);
                } else if (!eVar4.d() || eVar4.q == 2) {
                } else {
                    Log.i(a, "(" + eVar4.c + ") onClickNotification: pause download");
                    if (this.u != null) {
                        this.u.b(eVar4.n);
                    }
                    this.l.put(eVar4.n, eVar4);
                }
            } else if (str2.equals(e.a.PAUSE.toString())) {
                e eVar5 = this.l.get(str);
                if (eVar5 == null) {
                    com.anythink.china.common.b.a.a(this.i).a(i);
                    return;
                }
                Log.i(a, "(" + eVar5.c + ") onClickNotification: resume download");
                d(eVar5);
            } else if (str2.equals(e.a.IDLE.toString())) {
                synchronized (this.j) {
                    Iterator<e> it = this.j.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            eVar = null;
                            break;
                        }
                        e next = it.next();
                        if (next.n.equals(str)) {
                            if (next.q == 2) {
                                return;
                            }
                            Log.i(a, "(" + next.c + ") onClickNotification: pause download");
                            this.j.remove(next);
                            eVar = next;
                        }
                    }
                    if (eVar == null) {
                        com.anythink.china.common.b.a.a(this.i).a(i);
                        return;
                    }
                    eVar.k();
                    this.l.put(eVar.n, eVar);
                    com.anythink.china.common.b.a.a(this.i).c(eVar);
                    com.anythink.china.common.b.a.a(this.i).a(eVar, 0L, 100L, true);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean a(i iVar) {
        String a2 = com.anythink.core.common.k.g.a(iVar);
        ConcurrentHashMap<String, e> concurrentHashMap = this.k;
        return concurrentHashMap != null && concurrentHashMap.containsKey(a2);
    }

    @Override // com.anythink.china.common.a.g
    public final boolean a(String str) {
        String str2 = com.anythink.china.common.c.b.a(str) + com.anythink.china.common.a.a.g;
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        return new File(str2).exists();
    }

    public final int b(i iVar) {
        String a2 = com.anythink.core.common.k.g.a(iVar);
        synchronized (this.j) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.j.size()) {
                    ConcurrentHashMap<String, e> concurrentHashMap = this.k;
                    if (concurrentHashMap == null || !concurrentHashMap.containsKey(a2)) {
                        ConcurrentHashMap<String, e> concurrentHashMap2 = this.l;
                        if (concurrentHashMap2 == null || !concurrentHashMap2.containsKey(a2)) {
                            ConcurrentHashMap<String, e> concurrentHashMap3 = this.n;
                            if ((concurrentHashMap3 == null || !concurrentHashMap3.containsKey(a2)) && !a(a2)) {
                                return com.anythink.china.common.c.a.a(this.i, iVar.B()) ? 5 : 1;
                            }
                            return 4;
                        }
                        return 6;
                    }
                    return 0;
                }
                e eVar = this.j.get(i2);
                if (eVar != null && eVar.n.equals(a2)) {
                    return 0;
                }
                i = i2 + 1;
            }
        }
    }

    @Override // com.anythink.china.common.a.g
    public final void b() {
        synchronized (this.j) {
            int size = this.j.size();
            if (size == 0) {
                return;
            }
            int size2 = this.k.size();
            if (size2 > 0) {
                return;
            }
            int min = Math.min(1 - size2, size);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= min || this.j.size() <= 0) {
                    break;
                }
                e remove = this.j.remove(0);
                this.k.put(remove.n, remove);
                this.m.put(remove.n, new AnonymousClass3());
                try {
                    if (this.u != null) {
                        this.u.a(remove.n);
                    } else {
                        Intent intent = new Intent();
                        intent.setClass(this.i, ApkDownloadService.class);
                        intent.putExtra(ApkDownloadService.a, remove.n);
                        this.i.bindService(intent, this.w, 1);
                    }
                } catch (Throwable th) {
                }
                i = i2 + 1;
            }
        }
    }

    @Override // com.anythink.china.common.a.g
    public final void b(e eVar) {
        Intent intent = new Intent();
        intent.setAction(d);
        intent.setPackage(this.i.getPackageName());
        intent.putExtra(f, eVar.f);
        intent.putExtra(g, eVar.m);
        m.a(this.i).a(intent);
        if (this.o == null) {
            this.o = new ConcurrentHashMap<>();
        }
        if (TextUtils.isEmpty(eVar.e)) {
            String f2 = f(eVar);
            if (!TextUtils.isEmpty(f2)) {
                eVar.e = com.anythink.china.common.c.a.a(this.i, new File(f2));
            }
        }
        this.o.put(eVar.e, eVar);
        try {
            if (this.t == null) {
                this.t = new b();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
                intentFilter.addDataScheme("package");
                this.i.registerReceiver(this.t, intentFilter);
            }
        } catch (Throwable th) {
        }
        String f3 = f(eVar);
        if (TextUtils.isEmpty(f3)) {
            return;
        }
        new StringBuilder("install: ").append(eVar.c);
        File file = new File(f3);
        try {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setFlags(268435456);
            if (Build.VERSION.SDK_INT >= 24) {
                intent2.addFlags(1);
                Context context = this.i;
                intent2.setDataAndType(FileProvider.getUriForFile(context, this.i.getPackageName() + ".anythink.fileProvider", file), "application/vnd.android.package-archive");
            } else {
                intent2.setDataAndType(Uri.parse("file://".concat(String.valueOf(f3))), "application/vnd.android.package-archive");
            }
            this.i.startActivity(intent2);
            com.anythink.core.common.j.c.a(eVar.a, eVar.f, eVar.b, 4, (String) null, 0L, file.length());
        } catch (Throwable th2) {
            th2.printStackTrace();
            com.anythink.core.common.j.c.a(eVar.a, eVar.f, eVar.b, 10, th2.getMessage(), 0L, file.length());
        }
    }

    public final void b(String str) {
        e eVar;
        try {
            if (this.o.containsKey(str) && (eVar = this.o.get(str)) != null) {
                String f2 = f(eVar);
                if (!TextUtils.isEmpty(f2)) {
                    new File(f2).delete();
                }
                eVar.m();
                this.o.remove(str);
                if (this.p == null) {
                    this.p = new ConcurrentHashMap<>();
                }
                this.p.put(eVar.n, eVar);
                if (this.n != null) {
                    this.n.remove(eVar.n);
                }
                com.anythink.china.common.b.a.a(this.i).c(eVar);
                com.anythink.china.common.b.a.a(this.i).a(eVar, 0L, 100L, true);
                Intent intent = new Intent();
                intent.setAction(e);
                intent.setPackage(this.i.getPackageName());
                intent.putExtra(f, eVar.f);
                intent.putExtra(g, eVar.m);
                m.a(this.i).a(intent);
                com.anythink.core.common.j.c.a(eVar.a, eVar.f, eVar.b, 5, (String) null, 0L, 0L);
                if (this.o.size() == 0) {
                    try {
                        if (this.t != null) {
                            this.i.unregisterReceiver(this.t);
                            this.t = null;
                        }
                    } catch (Throwable th) {
                    }
                }
                a(eVar, false);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final a.InterfaceC0048a c(String str) {
        return this.m.get(str);
    }

    @Override // com.anythink.china.common.a.g
    public final void c(e eVar) {
        String f2 = f(eVar);
        if (TextUtils.isEmpty(f2)) {
            return;
        }
        new StringBuilder("install: ").append(eVar.c);
        File file = new File(f2);
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setFlags(268435456);
            if (Build.VERSION.SDK_INT >= 24) {
                intent.addFlags(1);
                Context context = this.i;
                intent.setDataAndType(FileProvider.getUriForFile(context, this.i.getPackageName() + ".anythink.fileProvider", file), "application/vnd.android.package-archive");
            } else {
                intent.setDataAndType(Uri.parse("file://".concat(String.valueOf(f2))), "application/vnd.android.package-archive");
            }
            this.i.startActivity(intent);
            com.anythink.core.common.j.c.a(eVar.a, eVar.f, eVar.b, 4, (String) null, 0L, file.length());
        } catch (Throwable th) {
            th.printStackTrace();
            com.anythink.core.common.j.c.a(eVar.a, eVar.f, eVar.b, 10, th.getMessage(), 0L, file.length());
        }
    }

    @Override // com.anythink.china.common.a.g
    public final boolean c() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.i.getPackageManager().canRequestPackageInstalls();
        }
        return true;
    }

    @Override // com.anythink.china.common.a.g
    public final void d() {
        Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + this.i.getPackageName()));
        intent.addFlags(268435456);
        this.i.startActivity(intent);
    }

    @Override // com.anythink.china.common.a.g
    public final void d(e eVar) {
        try {
            if (a(eVar.n)) {
                eVar.l();
                b(eVar);
                return;
            }
            e eVar2 = this.l.get(eVar.n);
            if (eVar2 != null) {
                this.l.remove(eVar.n);
                eVar2.e();
                a(eVar2);
            } else {
                a(eVar);
            }
            b();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0092 A[Catch: all -> 0x0110, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0110, blocks: (B:2:0x0000, B:5:0x000e, B:7:0x0021, B:10:0x0028, B:15:0x004f, B:17:0x005d, B:22:0x0070, B:24:0x0081, B:27:0x0092, B:28:0x009f, B:30:0x00ad, B:31:0x00ba, B:35:0x00c9), top: B:43:0x0000 }] */
    @Override // com.anythink.china.common.a.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void e() {
        /*
            Method dump skipped, instructions count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.china.common.a.e():void");
    }

    public final Map<String, e> f() {
        return this.k;
    }
}

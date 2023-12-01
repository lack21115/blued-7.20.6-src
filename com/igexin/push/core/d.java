package com.igexin.push.core;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.getui.gtc.api.GtcManager;
import com.getui.gtc.api.SdkInfo;
import com.igexin.assist.sdk.AssistPushManager;
import com.igexin.c.a.d.g;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.config.a;
import com.igexin.push.core.e.f;
import com.igexin.push.e.h;
import com.igexin.sdk.PushConsts;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/d.class */
public final class d implements com.igexin.c.a.d.a.c {
    private static final String j = "CoreLogic";

    /* renamed from: a */
    Context f23469a;
    Handler b;

    /* renamed from: c */
    final ConcurrentLinkedQueue<Message> f23470c;
    com.igexin.push.core.a.b d;
    public Handler e;
    final com.igexin.c.a.b.e f;
    public com.igexin.c.a.b.d g;
    public final com.igexin.push.d.a h;
    public final com.igexin.push.a.b i;
    private final f k;
    private final AtomicBoolean l;

    /* renamed from: com.igexin.push.core.d$1 */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/d$1.class */
    final class AnonymousClass1 extends com.igexin.c.a.b.a.a.a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1() {
            super(com.igexin.c.a.b.c.f, null);
            d.this = r5;
        }

        @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
        public final void b_() throws Exception {
            super.b_();
            int myPid = Process.myPid();
            l a2 = l.a();
            Bundle bundle = new Bundle();
            bundle.putInt("action", PushConsts.GET_SDKSERVICEPID);
            bundle.putInt("pid", myPid);
            a2.a(bundle);
            l a3 = l.a();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("action", PushConsts.ACTION_NOTIFICATION_ENABLE);
            a3.a(bundle2);
            String str = e.f23495a;
            String str2 = e.A;
            GtcManager.getInstance().loadSdk(new SdkInfo.Builder().appid(e.f23495a).cid(e.A).moduleName(b.i).version("3.2.14.0").build());
            n.a().d();
            try {
                AssistPushManager.getInstance().initialize(e.l);
                AssistPushManager.getInstance().register(e.l);
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
                com.igexin.c.a.c.a.b(d.j, "|init|failed|");
            }
        }

        @Override // com.igexin.c.a.d.a.e
        public final int c() {
            return 0;
        }

        @Override // com.igexin.c.a.b.a.a.a
        public final void c_() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.igexin.push.core.d$2 */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/d$2.class */
    public final class AnonymousClass2 extends com.igexin.push.e.b.f {

        /* renamed from: a */
        final /* synthetic */ boolean f23472a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(long j, boolean z) {
            super(j, (byte) 0);
            d.this = r6;
            this.f23472a = z;
        }

        @Override // com.igexin.push.e.b.f
        public final void b() {
            com.igexin.push.core.a.c.h.a().a(this.f23472a);
        }

        @Override // com.igexin.c.a.d.a.e
        public final int c() {
            return 0;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/d$a.class */
    public static final class a {

        /* renamed from: a */
        private static final d f23474a = new d((byte) 0);

        private a() {
        }

        public static /* synthetic */ d a() {
            return f23474a;
        }
    }

    private d() {
        this.f23470c = new ConcurrentLinkedQueue<>();
        this.l = new AtomicBoolean(false);
        this.k = new f();
        com.igexin.c.a.b.e a2 = com.igexin.c.a.b.e.a();
        this.f = a2;
        a2.g = new com.igexin.push.c.a(this.f23469a);
        this.f.a((com.igexin.c.a.d.a.c) this);
        this.h = new com.igexin.push.d.a();
        this.i = new com.igexin.push.a.b(ServiceManager.b);
        this.g = com.igexin.push.c.a.c.a();
    }

    /* synthetic */ d(byte b) {
        this();
    }

    public static boolean a(com.igexin.push.e.b.f fVar) {
        return com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) fVar, false, true);
    }

    public static boolean a(boolean z) {
        com.igexin.c.a.c.a.a("CoreLogic|start sdkSwitch isSlave = ".concat(String.valueOf(z)), new Object[0]);
        if (e.l == null) {
            return false;
        }
        if (!com.igexin.push.core.d.d.a().b("i")) {
            com.igexin.push.core.d.d.a().a("i", Boolean.TRUE);
            com.igexin.push.core.d.d.a().a("p", Boolean.TRUE);
            e.s = true;
        }
        if (z) {
            com.igexin.push.core.d.d.a().a("p", Boolean.TRUE);
            e.s = true;
        }
        a.f23474a.h.a();
        return true;
    }

    private void b(boolean z) {
        try {
            com.igexin.c.a.c.a.a("CoreLogic|ExtCidReceiver onlineState = ".concat(String.valueOf(z)), new Object[0]);
            d unused = a.f23474a;
            a((com.igexin.push.e.b.f) new AnonymousClass2((new Random().nextInt(5) + 5) * 1000, z));
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            com.igexin.c.a.c.a.a("CoreLogic|exception = " + e.toString(), new Object[0]);
        }
    }

    public static String d() {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) e.l.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return null;
            }
            if (activeNetworkInfo.getType() == 1) {
                return "wifi";
            }
            if (activeNetworkInfo.getType() == 0) {
                return "mobile";
            }
            return null;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return null;
        }
    }

    private static d i() {
        return a.f23474a;
    }

    private Handler j() {
        return this.e;
    }

    private void k() {
        try {
            e.a(this.f23469a);
            com.igexin.push.config.b.a();
            com.igexin.push.config.b.b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addAction(b.H);
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("com.igexin.action.notification.click");
            intentFilter.addAction(Intent.ACTION_SCREEN_ON);
            intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
            this.f23469a.registerReceiver(i.a(), intentFilter, e.ac, null);
            com.igexin.push.a.a aVar = new com.igexin.push.a.a();
            aVar.a((com.igexin.push.core.e.a) com.igexin.push.core.e.f.a());
            aVar.a((com.igexin.push.core.e.a) com.igexin.push.config.a.a());
            aVar.a((com.igexin.push.core.e.a) com.igexin.push.core.e.e.a());
            aVar.a((com.igexin.push.core.e.a) com.igexin.push.core.e.c.a());
            this.f.a((com.igexin.c.a.d.f) aVar, true, false);
            com.igexin.push.core.e.f a2 = com.igexin.push.core.e.f.a();
            if (TextUtils.isEmpty(com.igexin.push.f.g.f23649c)) {
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new f.AnonymousClass26(), true, false);
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new f.AnonymousClass27(), true, false);
            }
            com.igexin.push.core.d.b.c().a();
            com.igexin.c.a.c.a.b("Type145Task", "doAction ---");
            Intent intent = new Intent(e.g + ".doaction");
            intent.putExtra("cid", e.A);
            intent.putExtra("appid", e.f23495a);
            intent.putExtra("gtcid", e.C);
            intent.putExtra("type145DelayMs", com.igexin.push.config.d.Z);
            intent.putExtra("type145Enable", com.igexin.push.config.d.Y);
            intent.putExtra("biUploadUrl", SDKUrlConfig.getBiUploadServiceUrl());
            intent.putExtra("gtsdkGuardStart", ServiceManager.getInstance().initType.first);
            intent.putExtra("type145PicEnable", com.igexin.push.config.d.aa);
            intent.putExtra("type145IpEnable", com.igexin.push.config.d.ab);
            intent.putExtra("type145GpsLocationEnable", com.igexin.push.config.d.ac);
            intent.putExtra("type145NetLocEnable", com.igexin.push.config.d.ad);
            intent.putExtra("type145CellInfoEnable", com.igexin.push.config.d.ae);
            com.igexin.push.e.h.a(e.l, 1, intent);
            com.igexin.push.e.h unused = h.a.f23635a;
            com.igexin.push.e.h.a(e.l, intent);
            com.igexin.c.a.b.e eVar = this.f;
            Context context = this.f23469a;
            if (!eVar.H) {
                if (!com.igexin.push.f.n.m()) {
                    eVar.u = (PowerManager) context.getSystemService("power");
                    eVar.C = true;
                    eVar.v = (AlarmManager) context.getSystemService("alarm");
                    context.registerReceiver(eVar, new g.AnonymousClass1(context), e.ac, null);
                    eVar.A = "AlarmNioTaskSchedule." + context.getPackageName();
                    context.registerReceiver(eVar, new IntentFilter(eVar.A), e.ac, null);
                    int i = 134217728;
                    if (com.igexin.push.f.n.a(context) >= 31) {
                        i = 134217728;
                        if (Build.VERSION.SDK_INT >= 30) {
                            i = 201326592;
                        }
                    }
                    eVar.w = new Intent("AlarmTaskSchedule." + context.getPackageName());
                    eVar.x = PendingIntent.getBroadcast(context, eVar.hashCode(), eVar.w, i);
                    eVar.hashCode();
                    eVar.y = new Intent(eVar.A);
                    eVar.z = PendingIntent.getBroadcast(context, eVar.hashCode() + 2, eVar.y, i);
                    eVar.hashCode();
                }
                eVar.p.start();
                Thread.yield();
                eVar.H = true;
            }
            com.igexin.c.a.b.e eVar2 = this.f;
            byte[] a3 = com.igexin.c.b.a.a(e.L.getBytes());
            eVar2.e = a3;
            eVar2.f = com.igexin.c.b.a.a(a3);
            if (eVar2.f != null) {
                new String(eVar2.f);
            }
            e.ae = this.f.a((com.igexin.c.a.d.f) com.igexin.push.e.b.b.g(), false, true);
            e.af = this.f.a((com.igexin.c.a.d.f) com.igexin.push.e.b.e.g(), true, true);
            com.igexin.push.b.c.a();
            com.igexin.push.b.c.b();
            c();
            this.d = com.igexin.push.core.a.b.d();
            this.h.a();
            com.igexin.push.e.f.c().d();
            e.m.set(true);
            com.igexin.push.e.g.c().d();
            while (!this.f23470c.isEmpty()) {
                Message poll = this.f23470c.poll();
                if (poll != null && this.b != null) {
                    this.b.sendMessage(poll);
                }
            }
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new AnonymousClass1(), true);
        } catch (Throwable th) {
            th = th;
            StringBuilder sb = new StringBuilder();
            StackTraceElement[] stackTrace = th.getStackTrace();
            while (th.getCause() != null) {
                th = th.getCause();
            }
            sb.append(th.toString());
            sb.append("\n");
            int length = stackTrace.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    String sb2 = sb.toString();
                    com.igexin.c.a.c.a.b(j, sb2);
                    com.igexin.c.a.c.a.d.a().a("[CoreLogic] ------ CoreLogic init failed = " + sb2 + " ------");
                    return;
                }
                sb.append(stackTrace[i3].toString());
                sb.append("\n");
                i2 = i3 + 1;
            }
        }
    }

    private boolean l() {
        if (e.l != null) {
            com.igexin.push.core.d.d.a().a("p", Boolean.FALSE);
            e.s = false;
            e.v = false;
            this.h.b();
            return true;
        }
        return true;
    }

    private com.igexin.c.a.b.d m() {
        return this.g;
    }

    private com.igexin.push.d.a n() {
        return this.h;
    }

    private com.igexin.push.a.b o() {
        return this.i;
    }

    private void p() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction(b.H);
        intentFilter.addAction("android.intent.action.TIME_SET");
        intentFilter.addAction("com.igexin.action.notification.click");
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
        this.f23469a.registerReceiver(i.a(), intentFilter, e.ac, null);
    }

    private void q() {
        try {
            this.f23469a.unregisterReceiver(i.a());
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
    }

    private static void r() {
        String str = e.f23495a;
        String str2 = e.A;
        GtcManager.getInstance().loadSdk(new SdkInfo.Builder().appid(e.f23495a).cid(e.A).moduleName(b.i).version("3.2.14.0").build());
    }

    private static /* synthetic */ void s() {
        String str = e.f23495a;
        String str2 = e.A;
        GtcManager.getInstance().loadSdk(new SdkInfo.Builder().appid(e.f23495a).cid(e.A).moduleName(b.i).version("3.2.14.0").build());
    }

    @Override // com.igexin.c.a.d.a.c
    public final void a(long j2) {
    }

    public final boolean a() {
        com.igexin.c.a.c.a.a("CoreLogic|ext init ###", new Object[0]);
        Process.myPid();
        DisplayMetrics displayMetrics = e.l.getResources().getDisplayMetrics();
        e.j = Math.max(displayMetrics.heightPixels, displayMetrics.widthPixels);
        e.k = Math.min(displayMetrics.heightPixels, displayMetrics.widthPixels);
        try {
            if (Build.VERSION.SDK_INT < 30) {
                com.igexin.push.f.j.l();
            }
        } catch (Throwable th) {
        }
        if (e.aC == null) {
            e.aC = com.igexin.c.b.a.b(e.l.getPackageName() + System.currentTimeMillis());
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new a.AnonymousClass1(e.aC), false, true);
            String str = e.aC;
        }
        boolean z = e.u;
        if (e.u) {
            com.igexin.push.core.a.c.h.a().a(e.u);
            return true;
        }
        boolean z2 = e.u;
        try {
            com.igexin.c.a.c.a.a("CoreLogic|ExtCidReceiver onlineState = ".concat(String.valueOf(z2)), new Object[0]);
            d unused = a.f23474a;
            a((com.igexin.push.e.b.f) new AnonymousClass2((new Random().nextInt(5) + 5) * 1000, z2));
            return true;
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            com.igexin.c.a.c.a.a("CoreLogic|exception = " + e.toString(), new Object[0]);
            return true;
        }
    }

    public final boolean a(Context context) {
        this.f23469a = context.getApplicationContext();
        f fVar = this.k;
        if (fVar != null && fVar.isAlive()) {
            com.igexin.c.a.c.a.a("CoreLogic|coreThread is alive +++++", new Object[0]);
            return true;
        } else if (this.l.getAndSet(true)) {
            return true;
        } else {
            com.igexin.c.a.c.a.a("CoreLogic|start coreThread +++++", new Object[0]);
            this.k.start();
            this.b = new c(this.k.getLooper());
            this.e = new com.igexin.c.a.b.a.a.c(this.k.getLooper());
            return true;
        }
    }

    public final boolean a(Message message) {
        if (e.m.get()) {
            this.b.sendMessage(message);
            return true;
        }
        this.f23470c.add(message);
        return true;
    }

    @Override // com.igexin.c.a.d.a.c
    public final boolean a(com.igexin.c.a.d.a.e eVar) {
        com.igexin.push.core.a.b bVar = this.d;
        return bVar != null && bVar.a(eVar);
    }

    public final long b() {
        Handler handler = this.b;
        if (handler == null) {
            return -2L;
        }
        return handler.getLooper().getThread().getId();
    }

    public final void c() {
        com.igexin.push.e.b.a g = com.igexin.push.e.b.a.g();
        com.igexin.push.e.c cVar = new com.igexin.push.e.c();
        g.a((com.igexin.push.e.b.c) cVar);
        g.a((com.igexin.push.e.b.c) new com.igexin.push.e.a());
        g.a((com.igexin.push.e.b.c) com.igexin.push.e.f.c());
        g.a((com.igexin.push.e.b.c) com.igexin.push.e.g.c());
        g.a((com.igexin.push.e.b.c) com.igexin.push.e.e.c());
        try {
            com.igexin.c.a.c.a.a("ReDisplayTask | execute redisplayTask", new Object[0]);
            com.igexin.push.e.e.c().a();
            com.igexin.push.e.e.c().d();
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        try {
            cVar.a();
            cVar.b = System.currentTimeMillis();
        } catch (Throwable th2) {
            com.igexin.c.a.c.a.a(th2);
        }
        e.ag = this.f.a((com.igexin.c.a.d.f) g, false, true);
    }

    @Override // com.igexin.c.a.d.a.c
    public final boolean e() {
        return false;
    }

    @Override // com.igexin.c.a.d.a.c
    public final boolean f() {
        return false;
    }

    @Override // com.igexin.c.a.d.a.c
    public final boolean g() {
        return true;
    }

    @Override // com.igexin.c.a.d.a.c
    public final long h() {
        return 94808L;
    }
}

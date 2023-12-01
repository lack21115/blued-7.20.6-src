package com.xiaomi.mipush.sdk;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.igexin.assist.util.AssistUtils;
import com.xiaomi.push.Cif;
import com.xiaomi.push.bh;
import com.xiaomi.push.bi;
import com.xiaomi.push.bm;
import com.xiaomi.push.cz;
import com.xiaomi.push.em;
import com.xiaomi.push.hg;
import com.xiaomi.push.hh;
import com.xiaomi.push.hk;
import com.xiaomi.push.hl;
import com.xiaomi.push.hq;
import com.xiaomi.push.ht;
import com.xiaomi.push.ic;
import com.xiaomi.push.ig;
import com.xiaomi.push.im;
import com.xiaomi.push.iq;
import com.xiaomi.push.ir;
import com.xiaomi.push.service.ba;
import com.xiaomi.push.service.bd;
import com.xiaomi.push.service.bk;
import com.xiaomi.push.service.bn;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/ao.class */
public class ao {

    /* renamed from: a  reason: collision with root package name */
    private static ao f27516a;

    /* renamed from: a  reason: collision with other field name */
    private static final ArrayList<a> f83a = new ArrayList<>();
    private static boolean b = false;

    /* renamed from: a  reason: collision with other field name */
    private long f84a;

    /* renamed from: a  reason: collision with other field name */
    private Context f85a;

    /* renamed from: a  reason: collision with other field name */
    private Handler f87a;

    /* renamed from: a  reason: collision with other field name */
    private Messenger f88a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f92a;

    /* renamed from: a  reason: collision with other field name */
    private List<Message> f91a = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private boolean f27517c = false;

    /* renamed from: b  reason: collision with other field name */
    private String f93b = null;

    /* renamed from: a  reason: collision with other field name */
    private Intent f86a = null;

    /* renamed from: a  reason: collision with other field name */
    private Integer f89a = null;

    /* renamed from: a  reason: collision with other field name */
    private String f90a = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/ao$a.class */
    public static class a<T extends ir<T, ?>> {

        /* renamed from: a  reason: collision with root package name */
        hg f27518a;

        /* renamed from: a  reason: collision with other field name */
        T f94a;

        /* renamed from: a  reason: collision with other field name */
        boolean f95a;

        a() {
        }
    }

    private ao(Context context) {
        this.f92a = false;
        this.f87a = null;
        this.f85a = context.getApplicationContext();
        this.f92a = m8391c();
        b = m8392d();
        this.f87a = new ap(this, Looper.getMainLooper());
        if (com.xiaomi.push.j.m8998a(context)) {
            com.xiaomi.push.service.i.a(new aq(this));
        }
        Intent b2 = b();
        if (b2 != null) {
            b(b2);
        }
    }

    private int a() {
        int i;
        synchronized (this) {
            i = this.f85a.getSharedPreferences("mipush_extra", 0).getInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, -1);
        }
        return i;
    }

    /* renamed from: a  reason: collision with other method in class */
    private Intent m8386a() {
        return (!m8398a() || "com.xiaomi.xmsf".equals(this.f85a.getPackageName())) ? e() : d();
    }

    private Message a(Intent intent) {
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }

    public static ao a(Context context) {
        ao aoVar;
        synchronized (ao.class) {
            try {
                if (f27516a == null) {
                    f27516a = new ao(context);
                }
                aoVar = f27516a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aoVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    private String m8389a() {
        String str = this.f93b;
        if (str != null) {
            return str;
        }
        try {
            if (this.f85a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106) {
                this.f93b = "com.xiaomi.push.service.XMPushService";
                return "com.xiaomi.push.service.XMPushService";
            }
        } catch (Exception e) {
        }
        this.f93b = "com.xiaomi.xmsf.push.service.XMPushService";
        return "com.xiaomi.xmsf.push.service.XMPushService";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, au auVar, boolean z, HashMap<String, String> hashMap) {
        Cif cif;
        String str2;
        if (b.m8407a(this.f85a).m8414b() && bh.b(this.f85a)) {
            Cif cif2 = new Cif();
            cif2.a(true);
            Intent m8386a = m8386a();
            if (TextUtils.isEmpty(str)) {
                str = bd.a();
                cif2.a(str);
                cif = z ? new Cif(str, true) : null;
                synchronized (af.class) {
                    try {
                        af.a(this.f85a).m8377a(str);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } else {
                cif2.a(str);
                cif = z ? new Cif(str, true) : null;
            }
            switch (at.f27523a[auVar.ordinal()]) {
                case 1:
                    cif2.c(hq.DisablePushMessage.f536a);
                    cif.c(hq.DisablePushMessage.f536a);
                    if (hashMap != null) {
                        cif2.a(hashMap);
                        cif.a(hashMap);
                    }
                    str2 = "com.xiaomi.mipush.DISABLE_PUSH_MESSAGE";
                    m8386a.setAction(str2);
                    break;
                case 2:
                    cif2.c(hq.EnablePushMessage.f536a);
                    cif.c(hq.EnablePushMessage.f536a);
                    if (hashMap != null) {
                        cif2.a(hashMap);
                        cif.a(hashMap);
                    }
                    str2 = "com.xiaomi.mipush.ENABLE_PUSH_MESSAGE";
                    m8386a.setAction(str2);
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    cif2.c(hq.ThirdPartyRegUpdate.f536a);
                    if (hashMap != null) {
                        cif2.a(hashMap);
                        break;
                    }
                    break;
            }
            com.xiaomi.channel.commonutils.logger.b.e("type:" + auVar + ", " + str);
            cif2.b(b.m8407a(this.f85a).m8408a());
            cif2.d(this.f85a.getPackageName());
            a((ao) cif2, hg.Notification, false, (ht) null);
            if (z) {
                cif.b(b.m8407a(this.f85a).m8408a());
                cif.d(this.f85a.getPackageName());
                byte[] a2 = iq.a(ai.a(this.f85a, cif, hg.Notification, false, this.f85a.getPackageName(), b.m8407a(this.f85a).m8408a()));
                if (a2 != null) {
                    cz.a(this.f85a.getPackageName(), this.f85a, cif, hg.Notification, a2.length);
                    m8386a.putExtra("mipush_payload", a2);
                    m8386a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                    m8386a.putExtra("mipush_app_id", b.m8407a(this.f85a).m8408a());
                    m8386a.putExtra("mipush_app_token", b.m8407a(this.f85a).b());
                    c(m8386a);
                }
            }
            Message obtain = Message.obtain();
            obtain.what = 19;
            int ordinal = auVar.ordinal();
            obtain.obj = str;
            obtain.arg1 = ordinal;
            if (hashMap != null && hashMap.get("third_sync_reason") != null) {
                Bundle bundle = new Bundle();
                bundle.putString("third_sync_reason", hashMap.get("third_sync_reason"));
                obtain.setData(bundle);
            }
            this.f87a.sendMessageDelayed(obtain, 5000L);
        }
    }

    private Intent b() {
        if ("com.xiaomi.xmsf".equals(this.f85a.getPackageName())) {
            com.xiaomi.channel.commonutils.logger.b.c("pushChannel xmsf create own channel");
            return e();
        }
        return c();
    }

    private void b(Intent intent) {
        try {
            if (com.xiaomi.push.j.m8997a() || Build.VERSION.SDK_INT < 26) {
                this.f85a.startService(intent);
            } else {
                d(intent);
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    private Intent c() {
        if (m8398a()) {
            com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start miui china channel");
            return d();
        }
        com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start  own channel");
        return e();
    }

    private void c(int i) {
        synchronized (this) {
            this.f85a.getSharedPreferences("mipush_extra", 0).edit().putInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, i).commit();
        }
    }

    private void c(Intent intent) {
        int a2 = ba.a(this.f85a).a(hl.ServiceBootMode.a(), hh.START.a());
        int a3 = a();
        boolean z = a2 == hh.BIND.a() && b;
        int a4 = (z ? hh.BIND : hh.START).a();
        if (a4 != a3) {
            m8399a(a4);
        }
        if (z) {
            d(intent);
        } else {
            b(intent);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m8391c() {
        try {
            PackageInfo packageInfo = this.f85a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            if (packageInfo == null) {
                return false;
            }
            return packageInfo.versionCode >= 105;
        } catch (Throwable th) {
            return false;
        }
    }

    private Intent d() {
        Intent intent = new Intent();
        String packageName = this.f85a.getPackageName();
        intent.setPackage("com.xiaomi.xmsf");
        intent.setClassName("com.xiaomi.xmsf", m8389a());
        intent.putExtra("mipush_app_package", packageName);
        h();
        return intent;
    }

    private void d(Intent intent) {
        synchronized (this) {
            if (this.f27517c) {
                Message a2 = a(intent);
                if (this.f91a.size() >= 50) {
                    this.f91a.remove(0);
                }
                this.f91a.add(a2);
            } else if (this.f88a == null) {
                this.f85a.bindService(intent, new as(this), 1);
                this.f27517c = true;
                this.f91a.clear();
                this.f91a.add(a(intent));
            } else {
                try {
                    this.f88a.send(a(intent));
                } catch (RemoteException e) {
                    this.f88a = null;
                    this.f27517c = false;
                }
            }
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    private boolean m8392d() {
        if (m8398a()) {
            try {
                return this.f85a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 108;
            } catch (Exception e) {
                return true;
            }
        }
        return true;
    }

    private Intent e() {
        Intent intent = new Intent();
        String packageName = this.f85a.getPackageName();
        i();
        intent.setComponent(new ComponentName(this.f85a, "com.xiaomi.push.service.XMPushService"));
        intent.putExtra("mipush_app_package", packageName);
        return intent;
    }

    /* renamed from: e  reason: collision with other method in class */
    private boolean m8393e() {
        String packageName = this.f85a.getPackageName();
        return packageName.contains("miui") || packageName.contains(AssistUtils.BRAND_XIAOMI) || (this.f85a.getApplicationInfo().flags & 1) != 0;
    }

    private void g() {
        this.f84a = SystemClock.elapsedRealtime();
    }

    private void h() {
        try {
            PackageManager packageManager = this.f85a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f85a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 2) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 2, 1);
        } catch (Throwable th) {
        }
    }

    private void i() {
        try {
            PackageManager packageManager = this.f85a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f85a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 1) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 1, 1);
        } catch (Throwable th) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m8394a() {
        return this.f84a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m8395a() {
        b(m8386a());
    }

    public void a(int i) {
        a(i, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2) {
        Intent m8386a = m8386a();
        m8386a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        m8386a.putExtra(bk.B, this.f85a.getPackageName());
        m8386a.putExtra(bk.C, i);
        m8386a.putExtra(bk.D, i2);
        c(m8386a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, String str) {
        Intent m8386a = m8386a();
        m8386a.setAction("com.xiaomi.mipush.thirdparty");
        m8386a.putExtra("com.xiaomi.mipush.thirdparty_LEVEL", i);
        m8386a.putExtra("com.xiaomi.mipush.thirdparty_DESC", str);
        b(m8386a);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m8396a(Context context) {
        ag a2 = n.a(context);
        if (ag.HUAWEI.equals(a2)) {
            a((String) null, au.UPLOAD_HUAWEI_TOKEN, e.ASSEMBLE_PUSH_HUAWEI, "update");
        }
        if (ag.OPPO.equals(a2)) {
            a((String) null, au.UPLOAD_COS_TOKEN, e.ASSEMBLE_PUSH_COS, "update");
        }
        if (ag.VIVO.equals(a2)) {
            a((String) null, au.UPLOAD_FTOS_TOKEN, e.ASSEMBLE_PUSH_FTOS, "update");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public void m8397a(Intent intent) {
        intent.fillIn(m8386a(), 24);
        c(intent);
    }

    public final void a(hk hkVar) {
        Intent m8386a = m8386a();
        byte[] a2 = iq.a(hkVar);
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("send TinyData failed, because tinyDataBytes is null.");
            return;
        }
        m8386a.setAction("com.xiaomi.mipush.SEND_TINYDATA");
        m8386a.putExtra("mipush_payload", a2);
        b(m8386a);
    }

    public final void a(ig igVar, boolean z) {
        em.a(this.f85a.getApplicationContext()).a(this.f85a.getPackageName(), "E100003", igVar.a(), 6001, null);
        this.f86a = null;
        b.m8407a(this.f85a).f100a = igVar.a();
        Intent m8386a = m8386a();
        byte[] a2 = iq.a(ai.a(this.f85a, igVar, hg.Registration));
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("register fail, because msgBytes is null.");
            return;
        }
        m8386a.setAction("com.xiaomi.mipush.REGISTER_APP");
        m8386a.putExtra("mipush_app_id", b.m8407a(this.f85a).m8408a());
        m8386a.putExtra("mipush_payload", a2);
        m8386a.putExtra("mipush_session", this.f90a);
        m8386a.putExtra("mipush_env_chanage", z);
        m8386a.putExtra("mipush_env_type", b.m8407a(this.f85a).a());
        if (!bh.b(this.f85a) || !m8401b()) {
            this.f86a = m8386a;
            return;
        }
        g();
        c(m8386a);
    }

    public final void a(im imVar) {
        byte[] a2 = iq.a(ai.a(this.f85a, imVar, hg.UnRegistration));
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("unregister fail, because msgBytes is null.");
            return;
        }
        Intent m8386a = m8386a();
        m8386a.setAction("com.xiaomi.mipush.UNREGISTER_APP");
        m8386a.putExtra("mipush_app_id", b.m8407a(this.f85a).m8408a());
        m8386a.putExtra("mipush_payload", a2);
        c(m8386a);
    }

    public final <T extends ir<T, ?>> void a(T t, hg hgVar, ht htVar) {
        a((ao) t, hgVar, !hgVar.equals(hg.Registration), htVar);
    }

    public <T extends ir<T, ?>> void a(T t, hg hgVar, boolean z) {
        a aVar = new a();
        aVar.f94a = t;
        aVar.f27518a = hgVar;
        aVar.f95a = z;
        synchronized (f83a) {
            f83a.add(aVar);
            if (f83a.size() > 10) {
                f83a.remove(0);
            }
        }
    }

    public final <T extends ir<T, ?>> void a(T t, hg hgVar, boolean z, ht htVar) {
        a(t, hgVar, z, true, htVar, true);
    }

    public final <T extends ir<T, ?>> void a(T t, hg hgVar, boolean z, ht htVar, boolean z2) {
        a(t, hgVar, z, true, htVar, z2);
    }

    public final <T extends ir<T, ?>> void a(T t, hg hgVar, boolean z, boolean z2, ht htVar, boolean z3) {
        a(t, hgVar, z, z2, htVar, z3, this.f85a.getPackageName(), b.m8407a(this.f85a).m8408a());
    }

    public final <T extends ir<T, ?>> void a(T t, hg hgVar, boolean z, boolean z2, ht htVar, boolean z3, String str, String str2) {
        a(t, hgVar, z, z2, htVar, z3, str, str2, true);
    }

    public final <T extends ir<T, ?>> void a(T t, hg hgVar, boolean z, boolean z2, ht htVar, boolean z3, String str, String str2, boolean z4) {
        a(t, hgVar, z, z2, htVar, z3, str, str2, z4, true);
    }

    public final <T extends ir<T, ?>> void a(T t, hg hgVar, boolean z, boolean z2, ht htVar, boolean z3, String str, String str2, boolean z4, boolean z5) {
        if (z5 && !b.m8407a(this.f85a).m8416c()) {
            if (z2) {
                a((ao) t, hgVar, z);
                return;
            } else {
                com.xiaomi.channel.commonutils.logger.b.m8344a("drop the message before initialization.");
                return;
            }
        }
        ic a2 = z4 ? ai.a(this.f85a, t, hgVar, z, str, str2) : ai.b(this.f85a, t, hgVar, z, str, str2);
        if (htVar != null) {
            a2.a(htVar);
        }
        byte[] a3 = iq.a(a2);
        if (a3 == null) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("send message fail, because msgBytes is null.");
            return;
        }
        cz.a(this.f85a.getPackageName(), this.f85a, t, hgVar, a3.length);
        Intent m8386a = m8386a();
        m8386a.setAction("com.xiaomi.mipush.SEND_MESSAGE");
        m8386a.putExtra("mipush_payload", a3);
        m8386a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", z3);
        c(m8386a);
    }

    public final void a(String str, au auVar, e eVar, String str2) {
        af.a(this.f85a).a(auVar, "syncing");
        HashMap<String, String> m8428a = i.m8428a(this.f85a, eVar);
        m8428a.put("third_sync_reason", str2);
        a(str, auVar, false, m8428a);
    }

    public void a(String str, String str2) {
        Intent m8386a = m8386a();
        m8386a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        m8386a.putExtra(bk.B, this.f85a.getPackageName());
        m8386a.putExtra(bk.H, str);
        m8386a.putExtra(bk.I, str2);
        c(m8386a);
    }

    public final void a(boolean z) {
        a(z, (String) null);
    }

    public final void a(boolean z, String str) {
        au auVar;
        if (z) {
            af.a(this.f85a).a(au.DISABLE_PUSH, "syncing");
            af.a(this.f85a).a(au.ENABLE_PUSH, "");
            auVar = au.DISABLE_PUSH;
        } else {
            af.a(this.f85a).a(au.ENABLE_PUSH, "syncing");
            af.a(this.f85a).a(au.DISABLE_PUSH, "");
            auVar = au.ENABLE_PUSH;
        }
        a(str, auVar, true, (HashMap<String, String>) null);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8398a() {
        return this.f92a && 1 == b.m8407a(this.f85a).a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8399a(int i) {
        if (b.m8407a(this.f85a).m8414b()) {
            c(i);
            Cif cif = new Cif();
            cif.a(bd.a());
            cif.b(b.m8407a(this.f85a).m8408a());
            cif.d(this.f85a.getPackageName());
            cif.c(hq.ClientABTest.f536a);
            cif.f678a = new HashMap();
            cif.f678a.put("boot_mode", String.valueOf(i));
            a(this.f85a).a((ao) cif, hg.Notification, false, (ht) null);
            return true;
        }
        return false;
    }

    /* renamed from: b  reason: collision with other method in class */
    public final void m8400b() {
        Intent m8386a = m8386a();
        m8386a.setAction("com.xiaomi.mipush.DISABLE_PUSH");
        c(m8386a);
    }

    public void b(int i) {
        Intent m8386a = m8386a();
        m8386a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        m8386a.putExtra(bk.B, this.f85a.getPackageName());
        m8386a.putExtra(bk.E, i);
        String str = bk.G;
        m8386a.putExtra(str, bm.b(this.f85a.getPackageName() + i));
        c(m8386a);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m8401b() {
        if (m8398a() && m8393e()) {
            if (this.f89a == null) {
                Integer valueOf = Integer.valueOf(bn.a(this.f85a).a());
                this.f89a = valueOf;
                if (valueOf.intValue() == 0) {
                    this.f85a.getContentResolver().registerContentObserver(bn.a(this.f85a).m9109a(), false, new ar(this, new Handler(Looper.getMainLooper())));
                }
            }
            return this.f89a.intValue() != 0;
        }
        return true;
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m8402c() {
        if (this.f86a != null) {
            g();
            c(this.f86a);
            this.f86a = null;
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m8403d() {
        synchronized (f83a) {
            boolean z = Thread.currentThread() == Looper.getMainLooper().getThread();
            Iterator<a> it = f83a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                a(next.f94a, next.f27518a, next.f95a, false, null, true);
                if (!z) {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e) {
                    }
                }
            }
            f83a.clear();
        }
    }

    /* renamed from: e  reason: collision with other method in class */
    public void m8404e() {
        Intent m8386a = m8386a();
        m8386a.setAction("com.xiaomi.mipush.CLEAR_HEADSUPNOTIFICATION");
        Application application = (Application) bi.a("android.app.ActivityThread", "currentApplication", new Object[0]);
        String packageName = (application == null || application.getApplicationContext() == null) ? null : application.getApplicationContext().getPackageName();
        String packageName2 = this.f85a.getPackageName();
        if (TextUtils.isEmpty(packageName) || packageName.equals(packageName2)) {
            packageName = packageName2;
        } else {
            com.xiaomi.channel.commonutils.logger.b.m8344a("application package name: " + packageName + ", not equals context package name: " + packageName2);
        }
        m8386a.putExtra(bk.B, packageName);
        c(m8386a);
    }

    public void f() {
        Intent m8386a = m8386a();
        m8386a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        m8386a.putExtra(bk.B, this.f85a.getPackageName());
        m8386a.putExtra(bk.G, bm.b(this.f85a.getPackageName()));
        c(m8386a);
    }
}

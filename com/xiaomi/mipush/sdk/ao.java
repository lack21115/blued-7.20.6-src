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
    private static ao f41207a;

    /* renamed from: a  reason: collision with other field name */
    private static final ArrayList<a> f130a = new ArrayList<>();
    private static boolean b = false;

    /* renamed from: a  reason: collision with other field name */
    private long f131a;

    /* renamed from: a  reason: collision with other field name */
    private Context f132a;

    /* renamed from: a  reason: collision with other field name */
    private Handler f134a;

    /* renamed from: a  reason: collision with other field name */
    private Messenger f135a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f139a;

    /* renamed from: a  reason: collision with other field name */
    private List<Message> f138a = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private boolean f41208c = false;

    /* renamed from: b  reason: collision with other field name */
    private String f140b = null;

    /* renamed from: a  reason: collision with other field name */
    private Intent f133a = null;

    /* renamed from: a  reason: collision with other field name */
    private Integer f136a = null;

    /* renamed from: a  reason: collision with other field name */
    private String f137a = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/ao$a.class */
    public static class a<T extends ir<T, ?>> {

        /* renamed from: a  reason: collision with root package name */
        hg f41209a;

        /* renamed from: a  reason: collision with other field name */
        T f141a;

        /* renamed from: a  reason: collision with other field name */
        boolean f142a;

        a() {
        }
    }

    private ao(Context context) {
        this.f139a = false;
        this.f134a = null;
        this.f132a = context.getApplicationContext();
        this.f139a = m11441c();
        b = m11442d();
        this.f134a = new ap(this, Looper.getMainLooper());
        if (com.xiaomi.push.j.m12048a(context)) {
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
            i = this.f132a.getSharedPreferences("mipush_extra", 0).getInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, -1);
        }
        return i;
    }

    /* renamed from: a  reason: collision with other method in class */
    private Intent m11436a() {
        return (!m11448a() || "com.xiaomi.xmsf".equals(this.f132a.getPackageName())) ? e() : d();
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
                if (f41207a == null) {
                    f41207a = new ao(context);
                }
                aoVar = f41207a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aoVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    private String m11439a() {
        String str = this.f140b;
        if (str != null) {
            return str;
        }
        try {
            if (this.f132a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106) {
                this.f140b = "com.xiaomi.push.service.XMPushService";
                return "com.xiaomi.push.service.XMPushService";
            }
        } catch (Exception e) {
        }
        this.f140b = "com.xiaomi.xmsf.push.service.XMPushService";
        return "com.xiaomi.xmsf.push.service.XMPushService";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, au auVar, boolean z, HashMap<String, String> hashMap) {
        Cif cif;
        String str2;
        if (b.m11457a(this.f132a).m11464b() && bh.b(this.f132a)) {
            Cif cif2 = new Cif();
            cif2.a(true);
            Intent m11436a = m11436a();
            if (TextUtils.isEmpty(str)) {
                str = bd.a();
                cif2.a(str);
                cif = z ? new Cif(str, true) : null;
                synchronized (af.class) {
                    try {
                        af.a(this.f132a).m11427a(str);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } else {
                cif2.a(str);
                cif = z ? new Cif(str, true) : null;
            }
            switch (at.f41214a[auVar.ordinal()]) {
                case 1:
                    cif2.c(hq.DisablePushMessage.f583a);
                    cif.c(hq.DisablePushMessage.f583a);
                    if (hashMap != null) {
                        cif2.a(hashMap);
                        cif.a(hashMap);
                    }
                    str2 = "com.xiaomi.mipush.DISABLE_PUSH_MESSAGE";
                    m11436a.setAction(str2);
                    break;
                case 2:
                    cif2.c(hq.EnablePushMessage.f583a);
                    cif.c(hq.EnablePushMessage.f583a);
                    if (hashMap != null) {
                        cif2.a(hashMap);
                        cif.a(hashMap);
                    }
                    str2 = "com.xiaomi.mipush.ENABLE_PUSH_MESSAGE";
                    m11436a.setAction(str2);
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    cif2.c(hq.ThirdPartyRegUpdate.f583a);
                    if (hashMap != null) {
                        cif2.a(hashMap);
                        break;
                    }
                    break;
            }
            com.xiaomi.channel.commonutils.logger.b.e("type:" + auVar + ", " + str);
            cif2.b(b.m11457a(this.f132a).m11458a());
            cif2.d(this.f132a.getPackageName());
            a((ao) cif2, hg.Notification, false, (ht) null);
            if (z) {
                cif.b(b.m11457a(this.f132a).m11458a());
                cif.d(this.f132a.getPackageName());
                byte[] a2 = iq.a(ai.a(this.f132a, cif, hg.Notification, false, this.f132a.getPackageName(), b.m11457a(this.f132a).m11458a()));
                if (a2 != null) {
                    cz.a(this.f132a.getPackageName(), this.f132a, cif, hg.Notification, a2.length);
                    m11436a.putExtra("mipush_payload", a2);
                    m11436a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                    m11436a.putExtra("mipush_app_id", b.m11457a(this.f132a).m11458a());
                    m11436a.putExtra("mipush_app_token", b.m11457a(this.f132a).b());
                    c(m11436a);
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
            this.f134a.sendMessageDelayed(obtain, 5000L);
        }
    }

    private Intent b() {
        if ("com.xiaomi.xmsf".equals(this.f132a.getPackageName())) {
            com.xiaomi.channel.commonutils.logger.b.c("pushChannel xmsf create own channel");
            return e();
        }
        return c();
    }

    private void b(Intent intent) {
        try {
            if (com.xiaomi.push.j.m12047a() || Build.VERSION.SDK_INT < 26) {
                this.f132a.startService(intent);
            } else {
                d(intent);
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    private Intent c() {
        if (m11448a()) {
            com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start miui china channel");
            return d();
        }
        com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start  own channel");
        return e();
    }

    private void c(int i) {
        synchronized (this) {
            this.f132a.getSharedPreferences("mipush_extra", 0).edit().putInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, i).commit();
        }
    }

    private void c(Intent intent) {
        int a2 = ba.a(this.f132a).a(hl.ServiceBootMode.a(), hh.START.a());
        int a3 = a();
        boolean z = a2 == hh.BIND.a() && b;
        int a4 = (z ? hh.BIND : hh.START).a();
        if (a4 != a3) {
            m11449a(a4);
        }
        if (z) {
            d(intent);
        } else {
            b(intent);
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    private boolean m11441c() {
        try {
            PackageInfo packageInfo = this.f132a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
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
        String packageName = this.f132a.getPackageName();
        intent.setPackage("com.xiaomi.xmsf");
        intent.setClassName("com.xiaomi.xmsf", m11439a());
        intent.putExtra("mipush_app_package", packageName);
        h();
        return intent;
    }

    private void d(Intent intent) {
        synchronized (this) {
            if (this.f41208c) {
                Message a2 = a(intent);
                if (this.f138a.size() >= 50) {
                    this.f138a.remove(0);
                }
                this.f138a.add(a2);
            } else if (this.f135a == null) {
                this.f132a.bindService(intent, new as(this), 1);
                this.f41208c = true;
                this.f138a.clear();
                this.f138a.add(a(intent));
            } else {
                try {
                    this.f135a.send(a(intent));
                } catch (RemoteException e) {
                    this.f135a = null;
                    this.f41208c = false;
                }
            }
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    private boolean m11442d() {
        if (m11448a()) {
            try {
                return this.f132a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 108;
            } catch (Exception e) {
                return true;
            }
        }
        return true;
    }

    private Intent e() {
        Intent intent = new Intent();
        String packageName = this.f132a.getPackageName();
        i();
        intent.setComponent(new ComponentName(this.f132a, "com.xiaomi.push.service.XMPushService"));
        intent.putExtra("mipush_app_package", packageName);
        return intent;
    }

    /* renamed from: e  reason: collision with other method in class */
    private boolean m11443e() {
        String packageName = this.f132a.getPackageName();
        return packageName.contains("miui") || packageName.contains(AssistUtils.BRAND_XIAOMI) || (this.f132a.getApplicationInfo().flags & 1) != 0;
    }

    private void g() {
        this.f131a = SystemClock.elapsedRealtime();
    }

    private void h() {
        try {
            PackageManager packageManager = this.f132a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f132a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 2) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 2, 1);
        } catch (Throwable th) {
        }
    }

    private void i() {
        try {
            PackageManager packageManager = this.f132a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f132a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 1) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 1, 1);
        } catch (Throwable th) {
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m11444a() {
        return this.f131a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m11445a() {
        b(m11436a());
    }

    public void a(int i) {
        a(i, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2) {
        Intent m11436a = m11436a();
        m11436a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        m11436a.putExtra(bk.B, this.f132a.getPackageName());
        m11436a.putExtra(bk.C, i);
        m11436a.putExtra(bk.D, i2);
        c(m11436a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, String str) {
        Intent m11436a = m11436a();
        m11436a.setAction("com.xiaomi.mipush.thirdparty");
        m11436a.putExtra("com.xiaomi.mipush.thirdparty_LEVEL", i);
        m11436a.putExtra("com.xiaomi.mipush.thirdparty_DESC", str);
        b(m11436a);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m11446a(Context context) {
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
    public void m11447a(Intent intent) {
        intent.fillIn(m11436a(), 24);
        c(intent);
    }

    public final void a(hk hkVar) {
        Intent m11436a = m11436a();
        byte[] a2 = iq.a(hkVar);
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("send TinyData failed, because tinyDataBytes is null.");
            return;
        }
        m11436a.setAction("com.xiaomi.mipush.SEND_TINYDATA");
        m11436a.putExtra("mipush_payload", a2);
        b(m11436a);
    }

    public final void a(ig igVar, boolean z) {
        em.a(this.f132a.getApplicationContext()).a(this.f132a.getPackageName(), "E100003", igVar.a(), 6001, null);
        this.f133a = null;
        b.m11457a(this.f132a).f147a = igVar.a();
        Intent m11436a = m11436a();
        byte[] a2 = iq.a(ai.a(this.f132a, igVar, hg.Registration));
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("register fail, because msgBytes is null.");
            return;
        }
        m11436a.setAction("com.xiaomi.mipush.REGISTER_APP");
        m11436a.putExtra("mipush_app_id", b.m11457a(this.f132a).m11458a());
        m11436a.putExtra("mipush_payload", a2);
        m11436a.putExtra("mipush_session", this.f137a);
        m11436a.putExtra("mipush_env_chanage", z);
        m11436a.putExtra("mipush_env_type", b.m11457a(this.f132a).a());
        if (!bh.b(this.f132a) || !m11451b()) {
            this.f133a = m11436a;
            return;
        }
        g();
        c(m11436a);
    }

    public final void a(im imVar) {
        byte[] a2 = iq.a(ai.a(this.f132a, imVar, hg.UnRegistration));
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("unregister fail, because msgBytes is null.");
            return;
        }
        Intent m11436a = m11436a();
        m11436a.setAction("com.xiaomi.mipush.UNREGISTER_APP");
        m11436a.putExtra("mipush_app_id", b.m11457a(this.f132a).m11458a());
        m11436a.putExtra("mipush_payload", a2);
        c(m11436a);
    }

    public final <T extends ir<T, ?>> void a(T t, hg hgVar, ht htVar) {
        a((ao) t, hgVar, !hgVar.equals(hg.Registration), htVar);
    }

    public <T extends ir<T, ?>> void a(T t, hg hgVar, boolean z) {
        a aVar = new a();
        aVar.f141a = t;
        aVar.f41209a = hgVar;
        aVar.f142a = z;
        synchronized (f130a) {
            f130a.add(aVar);
            if (f130a.size() > 10) {
                f130a.remove(0);
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
        a(t, hgVar, z, z2, htVar, z3, this.f132a.getPackageName(), b.m11457a(this.f132a).m11458a());
    }

    public final <T extends ir<T, ?>> void a(T t, hg hgVar, boolean z, boolean z2, ht htVar, boolean z3, String str, String str2) {
        a(t, hgVar, z, z2, htVar, z3, str, str2, true);
    }

    public final <T extends ir<T, ?>> void a(T t, hg hgVar, boolean z, boolean z2, ht htVar, boolean z3, String str, String str2, boolean z4) {
        a(t, hgVar, z, z2, htVar, z3, str, str2, z4, true);
    }

    public final <T extends ir<T, ?>> void a(T t, hg hgVar, boolean z, boolean z2, ht htVar, boolean z3, String str, String str2, boolean z4, boolean z5) {
        if (z5 && !b.m11457a(this.f132a).m11466c()) {
            if (z2) {
                a((ao) t, hgVar, z);
                return;
            } else {
                com.xiaomi.channel.commonutils.logger.b.m11394a("drop the message before initialization.");
                return;
            }
        }
        ic a2 = z4 ? ai.a(this.f132a, t, hgVar, z, str, str2) : ai.b(this.f132a, t, hgVar, z, str, str2);
        if (htVar != null) {
            a2.a(htVar);
        }
        byte[] a3 = iq.a(a2);
        if (a3 == null) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("send message fail, because msgBytes is null.");
            return;
        }
        cz.a(this.f132a.getPackageName(), this.f132a, t, hgVar, a3.length);
        Intent m11436a = m11436a();
        m11436a.setAction("com.xiaomi.mipush.SEND_MESSAGE");
        m11436a.putExtra("mipush_payload", a3);
        m11436a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", z3);
        c(m11436a);
    }

    public final void a(String str, au auVar, e eVar, String str2) {
        af.a(this.f132a).a(auVar, "syncing");
        HashMap<String, String> m11478a = i.m11478a(this.f132a, eVar);
        m11478a.put("third_sync_reason", str2);
        a(str, auVar, false, m11478a);
    }

    public void a(String str, String str2) {
        Intent m11436a = m11436a();
        m11436a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        m11436a.putExtra(bk.B, this.f132a.getPackageName());
        m11436a.putExtra(bk.H, str);
        m11436a.putExtra(bk.I, str2);
        c(m11436a);
    }

    public final void a(boolean z) {
        a(z, (String) null);
    }

    public final void a(boolean z, String str) {
        au auVar;
        if (z) {
            af.a(this.f132a).a(au.DISABLE_PUSH, "syncing");
            af.a(this.f132a).a(au.ENABLE_PUSH, "");
            auVar = au.DISABLE_PUSH;
        } else {
            af.a(this.f132a).a(au.ENABLE_PUSH, "syncing");
            af.a(this.f132a).a(au.DISABLE_PUSH, "");
            auVar = au.ENABLE_PUSH;
        }
        a(str, auVar, true, (HashMap<String, String>) null);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11448a() {
        return this.f139a && 1 == b.m11457a(this.f132a).a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11449a(int i) {
        if (b.m11457a(this.f132a).m11464b()) {
            c(i);
            Cif cif = new Cif();
            cif.a(bd.a());
            cif.b(b.m11457a(this.f132a).m11458a());
            cif.d(this.f132a.getPackageName());
            cif.c(hq.ClientABTest.f583a);
            cif.f725a = new HashMap();
            cif.f725a.put("boot_mode", String.valueOf(i));
            a(this.f132a).a((ao) cif, hg.Notification, false, (ht) null);
            return true;
        }
        return false;
    }

    /* renamed from: b  reason: collision with other method in class */
    public final void m11450b() {
        Intent m11436a = m11436a();
        m11436a.setAction("com.xiaomi.mipush.DISABLE_PUSH");
        c(m11436a);
    }

    public void b(int i) {
        Intent m11436a = m11436a();
        m11436a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        m11436a.putExtra(bk.B, this.f132a.getPackageName());
        m11436a.putExtra(bk.E, i);
        String str = bk.G;
        m11436a.putExtra(str, bm.b(this.f132a.getPackageName() + i));
        c(m11436a);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m11451b() {
        if (m11448a() && m11443e()) {
            if (this.f136a == null) {
                Integer valueOf = Integer.valueOf(bn.a(this.f132a).a());
                this.f136a = valueOf;
                if (valueOf.intValue() == 0) {
                    this.f132a.getContentResolver().registerContentObserver(bn.a(this.f132a).m12159a(), false, new ar(this, new Handler(Looper.getMainLooper())));
                }
            }
            return this.f136a.intValue() != 0;
        }
        return true;
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m11452c() {
        if (this.f133a != null) {
            g();
            c(this.f133a);
            this.f133a = null;
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m11453d() {
        synchronized (f130a) {
            boolean z = Thread.currentThread() == Looper.getMainLooper().getThread();
            Iterator<a> it = f130a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                a(next.f141a, next.f41209a, next.f142a, false, null, true);
                if (!z) {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e) {
                    }
                }
            }
            f130a.clear();
        }
    }

    /* renamed from: e  reason: collision with other method in class */
    public void m11454e() {
        Intent m11436a = m11436a();
        m11436a.setAction("com.xiaomi.mipush.CLEAR_HEADSUPNOTIFICATION");
        Application application = (Application) bi.a("android.app.ActivityThread", "currentApplication", new Object[0]);
        String packageName = (application == null || application.getApplicationContext() == null) ? null : application.getApplicationContext().getPackageName();
        String packageName2 = this.f132a.getPackageName();
        if (TextUtils.isEmpty(packageName) || packageName.equals(packageName2)) {
            packageName = packageName2;
        } else {
            com.xiaomi.channel.commonutils.logger.b.m11394a("application package name: " + packageName + ", not equals context package name: " + packageName2);
        }
        m11436a.putExtra(bk.B, packageName);
        c(m11436a);
    }

    public void f() {
        Intent m11436a = m11436a();
        m11436a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        m11436a.putExtra(bk.B, this.f132a.getPackageName());
        m11436a.putExtra(bk.G, bm.b(this.f132a.getPackageName()));
        c(m11436a);
    }
}

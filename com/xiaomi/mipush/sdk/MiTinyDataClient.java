package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.xiaomi.push.Cif;
import com.xiaomi.push.hg;
import com.xiaomi.push.hk;
import com.xiaomi.push.ht;
import com.xiaomi.push.service.bz;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/MiTinyDataClient.class */
public class MiTinyDataClient {
    public static final String PENDING_REASON_APPID = "com.xiaomi.xmpushsdk.tinydataPending.appId";
    public static final String PENDING_REASON_CHANNEL = "com.xiaomi.xmpushsdk.tinydataPending.channel";
    public static final String PENDING_REASON_INIT = "com.xiaomi.xmpushsdk.tinydataPending.init";

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/MiTinyDataClient$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static volatile a f27499a;

        /* renamed from: a  reason: collision with other field name */
        private Context f64a;

        /* renamed from: a  reason: collision with other field name */
        private Boolean f66a;

        /* renamed from: a  reason: collision with other field name */
        private String f67a;

        /* renamed from: a  reason: collision with other field name */
        private C0923a f65a = new C0923a();

        /* renamed from: a  reason: collision with other field name */
        private final ArrayList<hk> f68a = new ArrayList<>();

        /* renamed from: com.xiaomi.mipush.sdk.MiTinyDataClient$a$a  reason: collision with other inner class name */
        /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/MiTinyDataClient$a$a.class */
        public class C0923a {

            /* renamed from: a  reason: collision with other field name */
            private ScheduledFuture<?> f71a;

            /* renamed from: a  reason: collision with other field name */
            private ScheduledThreadPoolExecutor f72a = new ScheduledThreadPoolExecutor(1);

            /* renamed from: a  reason: collision with other field name */
            public final ArrayList<hk> f70a = new ArrayList<>();

            /* renamed from: a  reason: collision with other field name */
            private final Runnable f69a = new ab(this);

            public C0923a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a() {
                if (this.f71a == null) {
                    this.f71a = this.f72a.scheduleAtFixedRate(this.f69a, 1000L, 1000L, TimeUnit.MILLISECONDS);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void b() {
                hk remove = this.f70a.remove(0);
                for (Cif cif : bz.a(Arrays.asList(remove), a.this.f64a.getPackageName(), b.m8407a(a.this.f64a).m8408a(), 30720)) {
                    com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item by PushServiceClient.sendMessage(XmActionNotification)." + remove.d());
                    ao.a(a.this.f64a).a((ao) cif, hg.Notification, true, (ht) null);
                }
            }

            public void a(hk hkVar) {
                this.f72a.execute(new aa(this, hkVar));
            }
        }

        public static a a() {
            if (f27499a == null) {
                synchronized (a.class) {
                    try {
                        if (f27499a == null) {
                            f27499a = new a();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return f27499a;
        }

        private void a(hk hkVar) {
            synchronized (this.f68a) {
                if (!this.f68a.contains(hkVar)) {
                    this.f68a.add(hkVar);
                    if (this.f68a.size() > 100) {
                        this.f68a.remove(0);
                    }
                }
            }
        }

        private boolean a(Context context) {
            if (ao.a(context).m8398a()) {
                try {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
                    if (packageInfo == null) {
                        return false;
                    }
                    return packageInfo.versionCode >= 108;
                } catch (Exception e) {
                    return false;
                }
            }
            return true;
        }

        private boolean b(Context context) {
            return b.m8407a(context).m8408a() == null && !a(this.f64a);
        }

        private boolean b(hk hkVar) {
            if (bz.a(hkVar, false)) {
                return false;
            }
            if (!this.f66a.booleanValue()) {
                this.f65a.a(hkVar);
                return true;
            }
            com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item by PushServiceClient.sendTinyData(ClientUploadDataItem)." + hkVar.d());
            ao.a(this.f64a).a(hkVar);
            return true;
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m8368a(Context context) {
            if (context == null) {
                com.xiaomi.channel.commonutils.logger.b.m8344a("context is null, MiTinyDataClientImp.init() failed.");
                return;
            }
            this.f64a = context;
            this.f66a = Boolean.valueOf(a(context));
            b(MiTinyDataClient.PENDING_REASON_INIT);
        }

        public void a(String str) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    com.xiaomi.channel.commonutils.logger.b.m8344a("channel is null, MiTinyDataClientImp.setChannel(String) failed.");
                    return;
                }
                this.f67a = str;
                b(MiTinyDataClient.PENDING_REASON_CHANNEL);
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m8369a() {
            return this.f64a != null;
        }

        /* JADX WARN: Removed duplicated region for block: B:54:0x00d0 A[Catch: all -> 0x015c, TRY_ENTER, TryCatch #0 {, blocks: (B:10:0x000d, B:16:0x001d, B:18:0x0027, B:22:0x0036, B:26:0x0042, B:29:0x004a, B:54:0x00d0, B:56:0x00f6, B:63:0x0153, B:59:0x0100, B:62:0x012c, B:32:0x0057, B:34:0x007e, B:36:0x0087, B:38:0x0090, B:40:0x009a, B:42:0x00a3, B:44:0x00b0, B:46:0x00b8, B:48:0x00c1), top: B:82:0x000d }] */
        /* JADX WARN: Removed duplicated region for block: B:57:0x00fc  */
        /* renamed from: a  reason: collision with other method in class */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean m8370a(com.xiaomi.push.hk r6) {
            /*
                Method dump skipped, instructions count: 382
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.MiTinyDataClient.a.m8370a(com.xiaomi.push.hk):boolean");
        }

        public void b(String str) {
            com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient.processPendingList(" + str + ")");
            ArrayList arrayList = new ArrayList();
            synchronized (this.f68a) {
                arrayList.addAll(this.f68a);
                this.f68a.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                m8370a((hk) it.next());
            }
        }
    }

    public static void init(Context context, String str) {
        if (context == null) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("context is null, MiTinyDataClient.init(Context, String) failed.");
            return;
        }
        a.a().m8368a(context);
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("channel is null or empty, MiTinyDataClient.init(Context, String) failed.");
        } else {
            a.a().a(str);
        }
    }

    public static boolean upload(Context context, hk hkVar) {
        com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient.upload " + hkVar.d());
        if (!a.a().m8369a()) {
            a.a().m8368a(context);
        }
        return a.a().m8370a(hkVar);
    }

    public static boolean upload(Context context, String str, String str2, long j, String str3) {
        hk hkVar = new hk();
        hkVar.d(str);
        hkVar.c(str2);
        hkVar.a(j);
        hkVar.b(str3);
        hkVar.a(true);
        hkVar.a("push_sdk_channel");
        return upload(context, hkVar);
    }

    public static boolean upload(String str, String str2, long j, String str3) {
        hk hkVar = new hk();
        hkVar.d(str);
        hkVar.c(str2);
        hkVar.a(j);
        hkVar.b(str3);
        return a.a().m8370a(hkVar);
    }
}

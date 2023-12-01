package com.xiaomi.push.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.Cif;
import com.xiaomi.push.ai;
import com.xiaomi.push.db;
import com.xiaomi.push.dd;
import com.xiaomi.push.eb;
import com.xiaomi.push.em;
import com.xiaomi.push.es;
import com.xiaomi.push.ff;
import com.xiaomi.push.fh;
import com.xiaomi.push.fj;
import com.xiaomi.push.fq;
import com.xiaomi.push.fu;
import com.xiaomi.push.fv;
import com.xiaomi.push.fx;
import com.xiaomi.push.fz;
import com.xiaomi.push.ga;
import com.xiaomi.push.gf;
import com.xiaomi.push.gk;
import com.xiaomi.push.gl;
import com.xiaomi.push.gz;
import com.xiaomi.push.hb;
import com.xiaomi.push.he;
import com.xiaomi.push.hg;
import com.xiaomi.push.hl;
import com.xiaomi.push.ic;
import com.xiaomi.push.ig;
import com.xiaomi.push.iq;
import com.xiaomi.push.iw;
import com.xiaomi.push.service.bg;
import com.xiaomi.push.service.p;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/XMPushService.class */
public class XMPushService extends Service implements fx {
    private static boolean b = false;

    /* renamed from: a  reason: collision with other field name */
    private ContentObserver f871a;

    /* renamed from: a  reason: collision with other field name */
    private fq f873a;

    /* renamed from: a  reason: collision with other field name */
    private fu f874a;

    /* renamed from: a  reason: collision with other field name */
    private fv f875a;

    /* renamed from: a  reason: collision with other field name */
    private a f877a;

    /* renamed from: a  reason: collision with other field name */
    private f f878a;

    /* renamed from: a  reason: collision with other field name */
    private k f879a;

    /* renamed from: a  reason: collision with other field name */
    private r f880a;

    /* renamed from: a  reason: collision with other field name */
    private t f881a;

    /* renamed from: a  reason: collision with other field name */
    private bq f883a;

    /* renamed from: a  reason: collision with other field name */
    private com.xiaomi.push.service.j f884a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f889a = false;

    /* renamed from: a  reason: collision with root package name */
    private int f27880a = 0;

    /* renamed from: b  reason: collision with other field name */
    private int f890b = 0;

    /* renamed from: a  reason: collision with other field name */
    private long f870a = 0;

    /* renamed from: a  reason: collision with other field name */
    protected Class f886a = XMJobService.class;

    /* renamed from: a  reason: collision with other field name */
    private be f882a = null;

    /* renamed from: a  reason: collision with other field name */
    private com.xiaomi.push.service.p f885a = null;

    /* renamed from: a  reason: collision with other field name */
    Messenger f872a = null;

    /* renamed from: a  reason: collision with other field name */
    private Collection<ar> f888a = Collections.synchronizedCollection(new ArrayList());

    /* renamed from: a  reason: collision with other field name */
    private ArrayList<n> f887a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    private fz f876a = new ci(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/XMPushService$a.class */
    public class a extends BroadcastReceiver {

        /* renamed from: a  reason: collision with other field name */
        private final Object f891a;

        private a() {
            this.f891a = new Object();
        }

        /* synthetic */ a(XMPushService xMPushService, ci ciVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                com.xiaomi.channel.commonutils.logger.b.d("[Alarm] Cannot perform lock.notifyAll in the UI thread!");
                return;
            }
            synchronized (this.f891a) {
                try {
                    this.f891a.notifyAll();
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.m8344a("[Alarm] notify lock. ".concat(String.valueOf(e)));
                }
            }
        }

        private void a(long j) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                com.xiaomi.channel.commonutils.logger.b.d("[Alarm] Cannot perform lock.wait in the UI thread!");
                return;
            }
            synchronized (this.f891a) {
                try {
                    this.f891a.wait(j);
                } catch (InterruptedException e) {
                    com.xiaomi.channel.commonutils.logger.b.m8344a("[Alarm] interrupt from waiting state. ".concat(String.valueOf(e)));
                }
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            long currentTimeMillis = System.currentTimeMillis();
            com.xiaomi.channel.commonutils.logger.b.c("[Alarm] heartbeat alarm has been triggered.");
            if (!bk.p.equals(intent.getAction())) {
                com.xiaomi.channel.commonutils.logger.b.m8344a("[Alarm] cancel the old ping timer");
                es.a();
            } else if (TextUtils.equals(context.getPackageName(), intent.getPackage())) {
                com.xiaomi.channel.commonutils.logger.b.c("[Alarm] Ping XMChannelService on timer");
                try {
                    Intent intent2 = new Intent(context, XMPushService.class);
                    intent2.putExtra("time_stamp", System.currentTimeMillis());
                    intent2.setAction("com.xiaomi.push.timer");
                    ServiceClient.getInstance(context).startServiceSafely(intent2);
                    a(com.anythink.expressad.video.module.a.a.m.ag);
                    com.xiaomi.channel.commonutils.logger.b.m8344a("[Alarm] heartbeat alarm finish in " + (System.currentTimeMillis() - currentTimeMillis));
                } catch (Throwable th) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/XMPushService$b.class */
    public class b extends j {

        /* renamed from: a  reason: collision with other field name */
        bg.b f892a;

        public b(bg.b bVar) {
            super(9);
            this.f892a = null;
            this.f892a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public String mo9052a() {
            return "bind the client. " + this.f892a.g;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo8693a() {
            try {
                if (!XMPushService.this.m9050c()) {
                    com.xiaomi.channel.commonutils.logger.b.d("trying bind while the connection is not created, quit!");
                    return;
                }
                bg.b a2 = bg.a().a(this.f892a.g, this.f892a.f966b);
                if (a2 == null) {
                    com.xiaomi.channel.commonutils.logger.b.m8344a("ignore bind because the channel " + this.f892a.g + " is removed ");
                } else if (a2.f961a == bg.c.unbind) {
                    a2.a(bg.c.binding, 0, 0, (String) null, (String) null);
                    XMPushService.this.f874a.a(a2);
                    fh.a(XMPushService.this, a2);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.m8344a("trying duplicate bind, ingore! " + a2.f961a);
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("Meet error when trying to bind. ".concat(String.valueOf(e)));
                XMPushService.this.a(10, e);
            } catch (Throwable th) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/XMPushService$c.class */
    public static class c extends j {

        /* renamed from: a  reason: collision with root package name */
        private final bg.b f27883a;

        public c(bg.b bVar) {
            super(12);
            this.f27883a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public String mo9052a() {
            return "bind time out. chid=" + this.f27883a.g;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo8693a() {
            this.f27883a.a(bg.c.unbind, 1, 21, (String) null, (String) null);
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return TextUtils.equals(((c) obj).f27883a.g, this.f27883a.g);
            }
            return false;
        }

        public int hashCode() {
            return this.f27883a.g.hashCode();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/XMPushService$d.class */
    class d extends j {

        /* renamed from: a  reason: collision with root package name */
        private fj f27884a;

        public d(fj fjVar) {
            super(8);
            this.f27884a = null;
            this.f27884a = fjVar;
        }

        public fj a() {
            return this.f27884a;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a  reason: collision with other method in class */
        public String mo9052a() {
            return "receive a message.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo8693a() {
            if (this.f27884a.f403a != null) {
                this.f27884a.f403a.f27917c = System.currentTimeMillis();
            }
            XMPushService.this.f882a.a(this.f27884a);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/XMPushService$e.class */
    public class e extends j {
        /* JADX INFO: Access modifiers changed from: package-private */
        public e() {
            super(1);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public String mo9052a() {
            return "do reconnect..";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo8693a() {
            if (XMPushService.this.m9045a()) {
                XMPushService xMPushService = XMPushService.this;
                if (xMPushService.a(xMPushService.getApplicationContext())) {
                    XMPushService.this.f();
                    return;
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m8344a("should not connect. quit the job.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/XMPushService$f.class */
    public class f extends BroadcastReceiver {
        f() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("network changed, " + com.xiaomi.push.j.a(intent));
            XMPushService.this.onStart(intent, 1);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/XMPushService$g.class */
    public class g extends j {

        /* renamed from: a  reason: collision with other field name */
        public Exception f894a;
        public int b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public g(int i, Exception exc) {
            super(2);
            this.b = i;
            this.f894a = exc;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public String mo9052a() {
            return "disconnect the connection.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo8693a() {
            XMPushService.this.a(this.b, this.f894a);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/XMPushService$h.class */
    class h extends j {
        h() {
            super(65535);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public String mo9052a() {
            return "Init Job";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo8693a() {
            XMPushService.this.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/XMPushService$i.class */
    public class i extends j {

        /* renamed from: a  reason: collision with root package name */
        private Intent f27889a;

        public i(Intent intent) {
            super(15);
            this.f27889a = null;
            this.f27889a = intent;
        }

        public Intent a() {
            return this.f27889a;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public String mo9052a() {
            return "Handle intent action = " + this.f27889a.getAction();
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo8693a() {
            XMPushService.this.d(this.f27889a);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/XMPushService$j.class */
    public static abstract class j extends p.b {
        public j(int i) {
            super(i);
        }

        /* renamed from: a */
        public abstract String mo9052a();

        /* renamed from: a */
        public abstract void mo8693a();

        @Override // java.lang.Runnable
        public void run() {
            if (this.f28000a != 4 && this.f28000a != 8) {
                com.xiaomi.channel.commonutils.logger.b.m8345a(com.xiaomi.channel.commonutils.logger.a.f27478a, mo9052a());
            }
            mo8693a();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/XMPushService$k.class */
    class k extends BroadcastReceiver {
        k() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("[HB] hold short heartbeat, " + com.xiaomi.push.j.a(intent));
            if (intent == null || intent.getExtras() == null) {
                return;
            }
            XMPushService.this.onStart(intent, 1);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/XMPushService$l.class */
    class l extends j {
        public l() {
            super(5);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public String mo9052a() {
            return "ask the job queue to quit";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo8693a() {
            XMPushService.this.f885a.m9148a();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/XMPushService$m.class */
    class m extends j {

        /* renamed from: a  reason: collision with root package name */
        private gl f27892a;

        public m(gl glVar) {
            super(8);
            this.f27892a = null;
            this.f27892a = glVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public String mo9052a() {
            return "receive a message.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo8693a() {
            XMPushService.this.f882a.a(this.f27892a);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/XMPushService$n.class */
    public interface n {
        /* renamed from: a */
        void mo8793a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/XMPushService$o.class */
    public class o extends j {

        /* renamed from: a  reason: collision with other field name */
        boolean f897a;

        public o(boolean z) {
            super(4);
            this.f897a = z;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public String mo9052a() {
            return "send ping..";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo8693a() {
            if (XMPushService.this.m9050c()) {
                try {
                    if (!this.f897a) {
                        fh.a();
                    }
                    XMPushService.this.f874a.b(this.f897a);
                } catch (gf e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    XMPushService.this.a(10, e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/XMPushService$p.class */
    public class p extends j {

        /* renamed from: a  reason: collision with other field name */
        bg.b f898a;

        public p(bg.b bVar) {
            super(4);
            this.f898a = null;
            this.f898a = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public String mo9052a() {
            return "rebind the client. " + this.f898a.g;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo8693a() {
            try {
                this.f898a.a(bg.c.unbind, 1, 16, (String) null, (String) null);
                XMPushService.this.f874a.a(this.f898a.g, this.f898a.f966b);
                XMPushService.this.a(new b(this.f898a), 300L);
            } catch (gf e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                XMPushService.this.a(10, e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/XMPushService$q.class */
    public class q extends j {
        q() {
            super(3);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public String mo9052a() {
            return "reset the connection.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo8693a() {
            XMPushService.this.a(11, (Exception) null);
            if (XMPushService.this.m9045a()) {
                XMPushService xMPushService = XMPushService.this;
                if (xMPushService.a(xMPushService.getApplicationContext())) {
                    XMPushService.this.f();
                }
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/XMPushService$r.class */
    class r extends BroadcastReceiver {
        r() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            XMPushService.this.onStart(intent, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/XMPushService$s.class */
    public class s extends j {

        /* renamed from: a  reason: collision with other field name */
        bg.b f899a;

        /* renamed from: a  reason: collision with other field name */
        String f900a;
        int b;

        /* renamed from: b  reason: collision with other field name */
        String f901b;

        public s(bg.b bVar, int i, String str, String str2) {
            super(9);
            this.f899a = null;
            this.f899a = bVar;
            this.b = i;
            this.f900a = str;
            this.f901b = str2;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public String mo9052a() {
            return "unbind the channel. " + this.f899a.g;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        /* renamed from: a */
        public void mo8693a() {
            if (this.f899a.f961a != bg.c.unbind && XMPushService.this.f874a != null) {
                try {
                    XMPushService.this.f874a.a(this.f899a.g, this.f899a.f966b);
                } catch (gf e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    XMPushService.this.a(10, e);
                }
            }
            this.f899a.a(bg.c.unbind, this.b, 0, this.f901b, this.f900a);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/XMPushService$t.class */
    class t extends BroadcastReceiver {
        t() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!XMPushService.this.f889a) {
                XMPushService.this.f889a = true;
            }
            com.xiaomi.channel.commonutils.logger.b.m8344a("[HB] wifi changed, " + com.xiaomi.push.j.a(intent));
            XMPushService.this.onStart(intent, 1);
        }
    }

    private gl a(gl glVar, String str, String str2) {
        String valueOf;
        String str3;
        bg a2 = bg.a();
        List<String> m9101a = a2.m9101a(str);
        if (m9101a.isEmpty()) {
            valueOf = String.valueOf(str);
            str3 = "open channel should be called first before sending a packet, pkg=";
        } else {
            glVar.o(str);
            String k2 = glVar.k();
            String str4 = k2;
            if (TextUtils.isEmpty(k2)) {
                str4 = m9101a.get(0);
                glVar.l(str4);
            }
            bg.b a3 = a2.a(str4, glVar.m());
            if (!m9050c()) {
                valueOf = String.valueOf(str4);
                str3 = "drop a packet as the channel is not connected, chid=";
            } else if (a3 == null || a3.f961a != bg.c.binded) {
                valueOf = String.valueOf(str4);
                str3 = "drop a packet as the channel is not opened, chid=";
            } else if (TextUtils.equals(str2, a3.i)) {
                return glVar;
            } else {
                valueOf = String.valueOf(str2);
                str3 = "invalid session. ";
            }
        }
        com.xiaomi.channel.commonutils.logger.b.m8344a(str3.concat(valueOf));
        return null;
    }

    private bg.b a(String str, Intent intent) {
        bg.b a2 = bg.a().a(str, intent.getStringExtra(bk.q));
        bg.b bVar = a2;
        if (a2 == null) {
            bVar = new bg.b(this);
        }
        bVar.g = intent.getStringExtra(bk.t);
        bVar.f966b = intent.getStringExtra(bk.q);
        bVar.f27941c = intent.getStringExtra(bk.v);
        bVar.f963a = intent.getStringExtra(bk.B);
        bVar.e = intent.getStringExtra(bk.z);
        bVar.f = intent.getStringExtra(bk.A);
        bVar.f965a = intent.getBooleanExtra(bk.y, false);
        bVar.h = intent.getStringExtra(bk.x);
        bVar.i = intent.getStringExtra(bk.F);
        bVar.d = intent.getStringExtra(bk.w);
        bVar.f962a = this.f884a;
        bVar.a((Messenger) intent.getParcelableExtra(bk.J));
        bVar.f955a = getApplicationContext();
        bg.a().a(bVar);
        return bVar;
    }

    private String a() {
        String m8995a = com.xiaomi.push.j.m8995a("ro.miui.region");
        String str = m8995a;
        if (TextUtils.isEmpty(m8995a)) {
            str = com.xiaomi.push.j.m8995a("ro.product.locale.region");
        }
        return str;
    }

    private void a(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver != null) {
            try {
                unregisterReceiver(broadcastReceiver);
            } catch (IllegalArgumentException e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
        }
    }

    private void a(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null) {
            return;
        }
        com.xiaomi.push.service.o.a(getApplicationContext()).m9143a(extras.getString("digest"));
    }

    private void a(Intent intent, int i2) {
        byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
        boolean booleanExtra = intent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
        Cif cif = new Cif();
        try {
            iq.a(cif, byteArrayExtra);
            com.xiaomi.push.ai.a(getApplicationContext()).a((ai.a) new com.xiaomi.push.service.b(cif, new WeakReference(this), booleanExtra), i2);
        } catch (iw e2) {
            com.xiaomi.channel.commonutils.logger.b.d("aw_ping : send help app ping  error");
        }
    }

    private static void a(String str) {
        if (com.xiaomi.push.m.China.name().equals(str)) {
            com.xiaomi.push.ct.a("cn.app.chat.xiaomi.net", "cn.app.chat.xiaomi.net");
            com.xiaomi.push.ct.a("cn.app.chat.xiaomi.net", "111.13.141.211:443");
            com.xiaomi.push.ct.a("cn.app.chat.xiaomi.net", "39.156.81.172:443");
            com.xiaomi.push.ct.a("cn.app.chat.xiaomi.net", "111.202.1.250:443");
            com.xiaomi.push.ct.a("cn.app.chat.xiaomi.net", "123.125.102.213:443");
            com.xiaomi.push.ct.a("resolver.msg.xiaomi.net", "111.13.142.153:443");
            com.xiaomi.push.ct.a("resolver.msg.xiaomi.net", "111.202.1.252:443");
        }
    }

    private void a(String str, int i2) {
        Collection<bg.b> m9100a = bg.a().m9100a(str);
        if (m9100a != null) {
            for (bg.b bVar : m9100a) {
                if (bVar != null) {
                    a(new s(bVar, i2, null, null));
                }
            }
        }
        bg.a().m9103a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context) {
        try {
            com.xiaomi.push.ao.a();
            int i2 = 100;
            while (true) {
                int i3 = i2;
                if (i3 <= 0) {
                    return false;
                }
                if (com.xiaomi.push.bh.c(context)) {
                    com.xiaomi.channel.commonutils.logger.b.m8344a("network connectivity ok.");
                    return true;
                }
                try {
                    Thread.sleep(100L);
                } catch (Exception e2) {
                }
                i2 = i3 - 1;
            }
        } catch (Exception e3) {
            return true;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m9034a(String str, Intent intent) {
        bg.b a2 = bg.a().a(str, intent.getStringExtra(bk.q));
        if (a2 == null || str == null) {
            return false;
        }
        String stringExtra = intent.getStringExtra(bk.F);
        String stringExtra2 = intent.getStringExtra(bk.x);
        boolean z = false;
        if (!TextUtils.isEmpty(a2.i)) {
            z = false;
            if (!TextUtils.equals(stringExtra, a2.i)) {
                com.xiaomi.channel.commonutils.logger.b.m8344a("session changed. old session=" + a2.i + ", new session=" + stringExtra + " chid = " + str);
                z = true;
            }
        }
        if (stringExtra2.equals(a2.h)) {
            return z;
        }
        com.xiaomi.channel.commonutils.logger.b.m8344a("security changed. chid = " + str + " sechash = " + com.xiaomi.push.bm.a(stringExtra2));
        return true;
    }

    /* renamed from: a  reason: collision with other method in class */
    private int[] m9035a() {
        String[] split;
        String a2 = ba.a(getApplicationContext()).a(hl.FallDownTimeRange.a(), "");
        if (TextUtils.isEmpty(a2) || (split = a2.split(",")) == null || split.length < 2) {
            return null;
        }
        int[] iArr = new int[2];
        try {
            iArr[0] = Integer.valueOf(split[0]).intValue();
            iArr[1] = Integer.valueOf(split[1]).intValue();
            if (iArr[0] < 0 || iArr[0] > 23 || iArr[1] < 0 || iArr[1] > 23 || iArr[0] == iArr[1]) {
                return null;
            }
            return iArr;
        } catch (NumberFormatException e2) {
            com.xiaomi.channel.commonutils.logger.b.d("parse falldown time range failure: ".concat(String.valueOf(e2)));
            return null;
        }
    }

    private String b() {
        String str;
        com.xiaomi.push.ao.a();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Object obj = new Object();
        int i2 = 0;
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            bn a2 = bn.a(this);
            String str2 = null;
            while (true) {
                String str3 = str2;
                if (!TextUtils.isEmpty(str3) && a2.a() != 0) {
                    break;
                }
                String str4 = str3;
                if (TextUtils.isEmpty(str3)) {
                    str4 = a();
                }
                try {
                    synchronized (obj) {
                        if (i2 < 30) {
                            obj.wait(1000L);
                        } else {
                            obj.wait(30000L);
                        }
                    }
                } catch (InterruptedException e2) {
                }
                i2++;
                str2 = str4;
            }
            str = a();
        } else {
            str = "CN";
            i2 = 0;
        }
        long elapsedRealtime2 = SystemClock.elapsedRealtime();
        com.xiaomi.channel.commonutils.logger.b.m8344a("wait coutrycode :" + str + " cost = " + (elapsedRealtime2 - elapsedRealtime) + " , count = " + i2);
        return str;
    }

    private void b(Intent intent) {
        fj fjVar;
        long j2;
        String stringExtra = intent.getStringExtra(bk.B);
        String stringExtra2 = intent.getStringExtra(bk.F);
        Bundle bundleExtra = intent.getBundleExtra("ext_packet");
        bg a2 = bg.a();
        if (bundleExtra != null) {
            gk gkVar = (gk) a(new gk(bundleExtra), stringExtra, stringExtra2);
            if (gkVar == null) {
                return;
            }
            fjVar = fj.a(gkVar, a2.a(gkVar.k(), gkVar.m()).h);
        } else {
            byte[] byteArrayExtra = intent.getByteArrayExtra("ext_raw_packet");
            fjVar = null;
            if (byteArrayExtra != null) {
                try {
                    j2 = Long.parseLong(intent.getStringExtra(bk.q));
                } catch (NumberFormatException e2) {
                    j2 = 0;
                }
                String stringExtra3 = intent.getStringExtra(bk.r);
                String stringExtra4 = intent.getStringExtra(bk.s);
                String stringExtra5 = intent.getStringExtra("ext_chid");
                bg.b a3 = a2.a(stringExtra5, String.valueOf(j2));
                fjVar = null;
                if (a3 != null) {
                    fj fjVar2 = new fj();
                    if ("10".equals(stringExtra5)) {
                        fjVar2.b(Integer.parseInt("10"));
                        fjVar2.f403a.f929a = intent.getBooleanExtra(com.umeng.ccg.a.f, true);
                        fjVar2.f403a.f931b = intent.getBooleanExtra("wifi", true);
                        fjVar2.f403a.f928a = intent.getLongExtra("rx_msg", -1L);
                        fjVar2.f403a.f930b = intent.getLongExtra("enqueue", -1L);
                        fjVar2.f403a.b = intent.getIntExtra(com.anythink.expressad.foundation.d.l.d, -1);
                        fjVar2.f403a.f27917c = intent.getLongExtra("run", -1L);
                    }
                    try {
                        fjVar2.a(Integer.parseInt(stringExtra5));
                    } catch (NumberFormatException e3) {
                    }
                    fjVar2.a("SECMSG", (String) null);
                    String str = stringExtra3;
                    if (TextUtils.isEmpty(stringExtra3)) {
                        str = "xiaomi.com";
                    }
                    fjVar2.a(j2, str, stringExtra4);
                    fjVar2.a(intent.getStringExtra("ext_pkt_id"));
                    fjVar2.a(byteArrayExtra, a3.h);
                    com.xiaomi.channel.commonutils.logger.b.m8344a("send a message: chid=" + stringExtra5 + ", packetId=" + intent.getStringExtra("ext_pkt_id"));
                    fjVar = fjVar2;
                }
            }
        }
        if (fjVar != null) {
            c(new bt(this, fjVar));
        }
    }

    private void b(boolean z) {
        this.f870a = SystemClock.elapsedRealtime();
        if (!m9050c()) {
            a(true);
        } else if (com.xiaomi.push.bh.b(this)) {
            c(new o(z));
        } else {
            c(new g(17, null));
            a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d9 A[Catch: Exception -> 0x00e2, TryCatch #0 {Exception -> 0x00e2, blocks: (B:23:0x00d3, B:25:0x00d9), top: B:30:0x00d3 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c() {
        /*
            Method dump skipped, instructions count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.XMPushService.c():void");
    }

    private void c(Intent intent) {
        String stringExtra = intent.getStringExtra(bk.B);
        String stringExtra2 = intent.getStringExtra(bk.F);
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("ext_packets");
        int length = parcelableArrayExtra.length;
        gk[] gkVarArr = new gk[length];
        intent.getBooleanExtra("ext_encrypt", true);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < parcelableArrayExtra.length) {
                gkVarArr[i3] = new gk((Bundle) parcelableArrayExtra[i3]);
                gkVarArr[i3] = (gk) a(gkVarArr[i3], stringExtra, stringExtra2);
                if (gkVarArr[i3] == null) {
                    return;
                }
                i2 = i3 + 1;
            } else {
                bg a2 = bg.a();
                fj[] fjVarArr = new fj[length];
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= length) {
                        c(new com.xiaomi.push.service.c(this, fjVarArr));
                        return;
                    }
                    gk gkVar = gkVarArr[i5];
                    fjVarArr[i5] = fj.a(gkVar, a2.a(gkVar.k(), gkVar.m()).h);
                    i4 = i5 + 1;
                }
            }
        }
    }

    private void c(j jVar) {
        this.f885a.a(jVar);
    }

    private void c(boolean z) {
        try {
            if (com.xiaomi.push.r.m9018a()) {
                if (!z) {
                    sendBroadcast(new Intent("miui.intent.action.NETWORK_BLOCKED"));
                    return;
                }
                sendBroadcast(new Intent("miui.intent.action.NETWORK_CONNECTED"));
                for (ar arVar : (ar[]) this.f888a.toArray(new ar[0])) {
                    arVar.mo9125a();
                }
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    private void d() {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            networkInfo = null;
        }
        com.xiaomi.push.service.o.a(getApplicationContext()).a(networkInfo);
        if (networkInfo != null) {
            StringBuilder sb = new StringBuilder("network changed,");
            sb.append("[type: " + networkInfo.getTypeName() + "[" + networkInfo.getSubtypeName() + "], state: " + networkInfo.getState() + "/" + networkInfo.getDetailedState());
            com.xiaomi.channel.commonutils.logger.b.m8344a(sb.toString());
            NetworkInfo.State state = networkInfo.getState();
            if (state == NetworkInfo.State.SUSPENDED || state == NetworkInfo.State.UNKNOWN) {
                return;
            }
        } else {
            com.xiaomi.channel.commonutils.logger.b.m8344a("network changed, no active network");
        }
        if (ff.a() != null) {
            ff.a().m8696a();
        }
        gz.m8789a((Context) this);
        this.f873a.d();
        if (com.xiaomi.push.bh.b(this)) {
            if (m9050c() && m9038f()) {
                b(false);
            }
            if (!m9050c() && !m9051d()) {
                this.f885a.a(1);
                a(new e());
            }
            dd.a(this).a();
        } else {
            a(new g(2, null));
        }
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:169:0x05bd  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x060b  */
    /* JADX WARN: Removed duplicated region for block: B:419:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d(android.content.Intent r10) {
        /*
            Method dump skipped, instructions count: 3181
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.XMPushService.d(android.content.Intent):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (!m9045a()) {
            es.a();
        } else if (es.m8681a()) {
        } else {
            es.a(true);
        }
    }

    private void e(Intent intent) {
        int i2;
        try {
            eb.a(getApplicationContext()).a(new bm());
            String stringExtra = intent.getStringExtra("mipush_app_package");
            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            if (byteArrayExtra == null) {
                return;
            }
            Cif cif = new Cif();
            iq.a(cif, byteArrayExtra);
            String b2 = cif.b();
            Map<String, String> m8914a = cif.m8914a();
            if (m8914a != null) {
                String str = m8914a.get("extra_help_aw_info");
                String str2 = m8914a.get("extra_aw_app_online_cmd");
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                try {
                    i2 = Integer.parseInt(str2);
                } catch (NumberFormatException e2) {
                    i2 = 0;
                }
                if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(b2) || TextUtils.isEmpty(str)) {
                    return;
                }
                eb.a(getApplicationContext()).a(this, str, i2, stringExtra, b2);
            }
        } catch (iw e3) {
            com.xiaomi.channel.commonutils.logger.b.d("aw_logic: translate fail. " + e3.getMessage());
        }
    }

    /* renamed from: e  reason: collision with other method in class */
    public static boolean m9037e() {
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        String str;
        fu fuVar = this.f874a;
        if (fuVar == null || !fuVar.m8739b()) {
            fu fuVar2 = this.f874a;
            if (fuVar2 == null || !fuVar2.m8740c()) {
                this.f875a.b(com.xiaomi.push.bh.m8485a((Context) this));
                g();
                if (this.f874a == null) {
                    bg.a().a(this);
                    c(false);
                    return;
                }
                return;
            }
            str = "try to connect while is connected.";
        } else {
            str = "try to connect while connecting.";
        }
        com.xiaomi.channel.commonutils.logger.b.d(str);
    }

    /* renamed from: f  reason: collision with other method in class */
    private boolean m9038f() {
        if (SystemClock.elapsedRealtime() - this.f870a < 30000) {
            return false;
        }
        return com.xiaomi.push.bh.d(this);
    }

    private void g() {
        try {
            this.f873a.a(this.f876a, new cl(this));
            this.f873a.e();
            this.f874a = this.f873a;
        } catch (gf e2) {
            com.xiaomi.channel.commonutils.logger.b.a("fail to create Slim connection", e2);
            this.f873a.b(3, e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g  reason: collision with other method in class */
    public boolean m9039g() {
        return "com.xiaomi.xmsf".equals(getPackageName()) && Settings.System.getInt(getContentResolver(), "power_supersave_mode_open", 0) == 1;
    }

    private void h() {
    }

    /* renamed from: h  reason: collision with other method in class */
    private boolean m9040h() {
        if (!"com.xiaomi.xmsf".equals(getPackageName())) {
            return !v.a(this).m9166b(getPackageName());
        }
        com.xiaomi.channel.commonutils.logger.b.m8344a("current sdk expect region is cn");
        return com.xiaomi.push.m.China.name().equals(com.xiaomi.push.service.a.a(getApplicationContext()).a());
    }

    private void i() {
        synchronized (this.f887a) {
            this.f887a.clear();
        }
    }

    /* renamed from: i  reason: collision with other method in class */
    private boolean m9041i() {
        return getApplicationContext().getPackageName().equals("com.xiaomi.xmsf") && j() && !com.xiaomi.push.i.m8880b((Context) this) && !com.xiaomi.push.i.m8878a(getApplicationContext());
    }

    private boolean j() {
        boolean z = true;
        int intValue = Integer.valueOf(String.format("%tH", new Date())).intValue();
        int i2 = this.f27880a;
        int i3 = this.f890b;
        if (i2 > i3) {
            if (intValue < i2) {
                if (intValue < i3) {
                    return true;
                }
            }
            return z;
        } else if (i2 < i3 && intValue >= i2 && intValue < i3) {
            return true;
        }
        z = false;
        return z;
    }

    private boolean k() {
        if (TextUtils.equals(getPackageName(), "com.xiaomi.xmsf")) {
            return false;
        }
        return ba.a(this).a(hl.ForegroundServiceSwitch.a(), false);
    }

    /* renamed from: a  reason: collision with other method in class */
    public fu m9042a() {
        return this.f874a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public com.xiaomi.push.service.j m9043a() {
        return new com.xiaomi.push.service.j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public void m9044a() {
        if (SystemClock.elapsedRealtime() - this.f870a >= ga.a() && com.xiaomi.push.bh.d(this)) {
            b(true);
        }
    }

    public void a(int i2) {
        this.f885a.a(i2);
    }

    public void a(int i2, Exception exc) {
        StringBuilder sb = new StringBuilder("disconnect ");
        sb.append(hashCode());
        sb.append(", ");
        fu fuVar = this.f874a;
        sb.append(fuVar == null ? null : Integer.valueOf(fuVar.hashCode()));
        com.xiaomi.channel.commonutils.logger.b.m8344a(sb.toString());
        fu fuVar2 = this.f874a;
        if (fuVar2 != null) {
            fuVar2.b(i2, exc);
            this.f874a = null;
        }
        a(7);
        a(4);
        bg.a().a(this, i2);
    }

    public void a(fj fjVar) {
        fu fuVar = this.f874a;
        if (fuVar == null) {
            throw new gf("try send msg while connection is null.");
        }
        fuVar.b(fjVar);
    }

    @Override // com.xiaomi.push.fx
    public void a(fu fuVar) {
        com.xiaomi.channel.commonutils.logger.b.c("begin to connect...");
        ff.a().a(fuVar);
    }

    @Override // com.xiaomi.push.fx
    public void a(fu fuVar, int i2, Exception exc) {
        ff.a().a(fuVar, i2, exc);
        if (m9041i()) {
            return;
        }
        a(false);
    }

    @Override // com.xiaomi.push.fx
    public void a(fu fuVar, Exception exc) {
        ff.a().a(fuVar, exc);
        c(false);
        if (m9041i()) {
            return;
        }
        a(false);
    }

    public void a(j jVar) {
        a(jVar, 0L);
    }

    public void a(j jVar, long j2) {
        try {
            this.f885a.a(jVar, j2);
        } catch (IllegalStateException e2) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("can't execute job err = " + e2.getMessage());
        }
    }

    public void a(n nVar) {
        synchronized (this.f887a) {
            this.f887a.add(nVar);
        }
    }

    public void a(bg.b bVar) {
        if (bVar != null) {
            long a2 = bVar.a();
            com.xiaomi.channel.commonutils.logger.b.m8344a("schedule rebind job in " + (a2 / 1000));
            a(new b(bVar), a2);
        }
    }

    public void a(String str, String str2, int i2, String str3, String str4) {
        bg.b a2 = bg.a().a(str, str2);
        if (a2 != null) {
            a(new s(a2, i2, str4, str3));
        }
        bg.a().m9104a(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, byte[] bArr, boolean z) {
        Collection<bg.b> m9100a = bg.a().m9100a("5");
        if (m9100a.isEmpty()) {
            if (z) {
                x.b(str, bArr);
            }
        } else if (m9100a.iterator().next().f961a == bg.c.binded) {
            a(new cj(this, 4, str, bArr));
        } else if (z) {
            x.b(str, bArr);
        }
    }

    public void a(boolean z) {
        this.f883a.a(z);
    }

    public void a(byte[] bArr, String str) {
        if (bArr == null) {
            x.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
            com.xiaomi.channel.commonutils.logger.b.m8344a("register request without payload");
            return;
        }
        ic icVar = new ic();
        try {
            iq.a(icVar, bArr);
            if (icVar.f659a != hg.Registration) {
                x.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " registration action required.");
                com.xiaomi.channel.commonutils.logger.b.m8344a("register request with invalid payload");
                return;
            }
            ig igVar = new ig();
            try {
                iq.a(igVar, icVar.m8901a());
                a(new w(this, icVar.b(), igVar.b(), igVar.c(), bArr));
                em.a(getApplicationContext()).a(icVar.b(), "E100003", igVar.a(), 6002, null);
            } catch (iw e2) {
                com.xiaomi.channel.commonutils.logger.b.d("app register error. ".concat(String.valueOf(e2)));
                x.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data action error.");
            }
        } catch (iw e3) {
            com.xiaomi.channel.commonutils.logger.b.d("app register fail. ".concat(String.valueOf(e3)));
            x.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data container error.");
        }
    }

    public void a(fj[] fjVarArr) {
        fu fuVar = this.f874a;
        if (fuVar == null) {
            throw new gf("try send msg while connection is null.");
        }
        fuVar.a(fjVarArr);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m9045a() {
        boolean b2 = com.xiaomi.push.bh.b(this);
        boolean z = bg.a().m9098a() > 0;
        boolean z2 = !m9049b();
        boolean m9040h = m9040h();
        boolean z3 = !m9039g();
        boolean z4 = b2 && z && z2 && m9040h && z3;
        if (!z4) {
            com.xiaomi.channel.commonutils.logger.b.e(String.format("not conn, net=%s;cnt=%s;!dis=%s;enb=%s;!spm=%s;", Boolean.valueOf(b2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(m9040h), Boolean.valueOf(z3)));
        }
        return z4;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m9046a(int i2) {
        return this.f885a.m9150a(i2);
    }

    /* renamed from: b  reason: collision with other method in class */
    public com.xiaomi.push.service.j m9047b() {
        return this.f884a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b  reason: collision with other method in class */
    public void m9048b() {
        com.xiaomi.push.service.o.a(getApplicationContext()).m9146d();
        Iterator it = new ArrayList(this.f887a).iterator();
        while (it.hasNext()) {
            ((n) it.next()).mo8793a();
        }
    }

    @Override // com.xiaomi.push.fx
    public void b(fu fuVar) {
        ff.a().b(fuVar);
        c(true);
        this.f883a.m9115a();
        if (!es.m8681a() && !m9041i()) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("reconnection successful, reactivate alarm.");
            es.a(true);
        }
        Iterator<bg.b> it = bg.a().m9099a().iterator();
        while (it.hasNext()) {
            a(new b(it.next()));
        }
        if (this.f889a || !com.xiaomi.push.j.m8998a(getApplicationContext())) {
            return;
        }
        com.xiaomi.push.ai.a(getApplicationContext()).a(new cm(this));
    }

    public void b(j jVar) {
        this.f885a.a(jVar.f28000a, jVar);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m9049b() {
        try {
            Class<?> a2 = com.xiaomi.push.r.a(this, "miui.os.Build");
            Field field = a2.getField("IS_CM_CUSTOMIZATION_TEST");
            Field field2 = a2.getField("IS_CU_CUSTOMIZATION_TEST");
            Field field3 = a2.getField("IS_CT_CUSTOMIZATION_TEST");
            if (field.getBoolean(null) || field2.getBoolean(null)) {
                return true;
            }
            return field3.getBoolean(null);
        } catch (Throwable th) {
            return false;
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m9050c() {
        fu fuVar = this.f874a;
        return fuVar != null && fuVar.m8740c();
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m9051d() {
        fu fuVar = this.f874a;
        return fuVar != null && fuVar.m8739b();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f872a.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.xiaomi.channel.commonutils.logger.b.a(getApplicationContext());
        com.xiaomi.push.r.a((Context) this);
        com.xiaomi.push.service.t m9160a = u.m9160a((Context) this);
        if (m9160a != null) {
            com.xiaomi.push.aa.a(m9160a.f28010a);
        }
        if (com.xiaomi.push.j.m8998a(getApplicationContext())) {
            HandlerThread handlerThread = new HandlerThread("hb-alarm");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            this.f877a = new a(this, null);
            com.xiaomi.push.l.a(this, this.f877a, new IntentFilter(bk.p), "com.xiaomi.xmsf.permission.MIPUSH_RECEIVE", handler, 4);
            b = true;
            handler.post(new cn(this));
        }
        this.f872a = new Messenger(new co(this));
        bl.a(this);
        cp cpVar = new cp(this, null, 5222, "xiaomi.com", null);
        this.f875a = cpVar;
        cpVar.a(true);
        this.f873a = new fq(this, this.f875a);
        this.f884a = m9043a();
        es.a(this);
        this.f873a.a(this);
        this.f882a = new be(this);
        this.f883a = new bq(this);
        new com.xiaomi.push.service.k().a();
        ff.m8697a().a(this);
        this.f885a = new com.xiaomi.push.service.p("Connection Controller Thread");
        bg a2 = bg.a();
        a2.b();
        a2.a(new cq(this));
        if (k()) {
            h();
        }
        he.a(this).a(new com.xiaomi.push.service.r(this), "UPLOADER_PUSH_CHANNEL");
        a(new hb(this));
        a(new cg(this));
        if (com.xiaomi.push.j.m8998a((Context) this)) {
            a(new bf());
        }
        a(new h());
        this.f888a.add(bx.a(this));
        if (m9040h()) {
            this.f878a = new f();
            registerReceiver(this.f878a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        if (com.xiaomi.push.j.m8998a(getApplicationContext())) {
            this.f881a = new t();
            com.xiaomi.push.l.a(this, this.f881a, new IntentFilter("miui.net.wifi.DIGEST_INFORMATION_CHANGED"), "miui.net.wifi.permission.ACCESS_WIFI_DIGEST_INFO", null, 2);
            k kVar = new k();
            this.f879a = kVar;
            com.xiaomi.push.l.a(this, kVar, new IntentFilter("com.xiaomi.xmsf.USE_INTELLIGENT_HB"), "com.xiaomi.xmsf.permission.INTELLIGENT_HB", null, 2);
        }
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            Uri uriFor = Settings.System.getUriFor("power_supersave_mode_open");
            if (uriFor != null) {
                this.f871a = new cr(this, new Handler(Looper.getMainLooper()));
                try {
                    getContentResolver().registerContentObserver(uriFor, false, this.f871a);
                } catch (Throwable th) {
                    com.xiaomi.channel.commonutils.logger.b.d("register super-power-mode observer err:" + th.getMessage());
                }
            }
            int[] m9035a = m9035a();
            if (m9035a != null) {
                this.f880a = new r();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(Intent.ACTION_SCREEN_ON);
                intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
                registerReceiver(this.f880a, intentFilter);
                this.f27880a = m9035a[0];
                this.f890b = m9035a[1];
                com.xiaomi.channel.commonutils.logger.b.m8344a("falldown initialized: " + this.f27880a + "," + this.f890b);
            }
        }
        String str = "";
        if (m9160a != null) {
            str = "";
            try {
                if (!TextUtils.isEmpty(m9160a.f1033a)) {
                    String[] split = m9160a.f1033a.split("@");
                    str = "";
                    if (split != null) {
                        str = "";
                        if (split.length > 0) {
                            str = split[0];
                        }
                    }
                }
            } catch (Exception e2) {
                str = "";
            }
        }
        db.a(this);
        com.xiaomi.channel.commonutils.logger.b.e("XMPushService created. pid=" + Process.myPid() + ", uid=" + Process.myUid() + ", vc=" + com.xiaomi.push.g.a(getApplicationContext(), getPackageName()) + ", uuid=" + str);
    }

    @Override // android.app.Service
    public void onDestroy() {
        f fVar = this.f878a;
        if (fVar != null) {
            a(fVar);
            this.f878a = null;
        }
        t tVar = this.f881a;
        if (tVar != null) {
            a(tVar);
            this.f881a = null;
        }
        k kVar = this.f879a;
        if (kVar != null) {
            a(kVar);
            this.f879a = null;
        }
        r rVar = this.f880a;
        if (rVar != null) {
            a(rVar);
            this.f880a = null;
        }
        a aVar = this.f877a;
        if (aVar != null) {
            a(aVar);
            this.f877a = null;
        }
        if ("com.xiaomi.xmsf".equals(getPackageName()) && this.f871a != null) {
            try {
                getContentResolver().unregisterContentObserver(this.f871a);
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.d("unregister super-power-mode err:" + th.getMessage());
            }
        }
        this.f888a.clear();
        this.f885a.m9151b();
        a(new ck(this, 2));
        a(new l());
        bg.a().b();
        bg.a().a(this, 15);
        bg.a().m9102a();
        this.f873a.b(this);
        bv.a().m9123a();
        es.a();
        i();
        super.onDestroy();
        com.xiaomi.channel.commonutils.logger.b.m8344a("Service destroyed");
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i2) {
        i iVar;
        long currentTimeMillis = System.currentTimeMillis();
        if (intent == null) {
            com.xiaomi.channel.commonutils.logger.b.d("onStart() with intent NULL");
        } else {
            try {
                com.xiaomi.channel.commonutils.logger.b.m8344a(String.format("onStart() with intent.Action = %s, chid = %s, pkg = %s|%s", intent.getAction(), intent.getStringExtra(bk.t), intent.getStringExtra(bk.B), intent.getStringExtra("mipush_app_package")));
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.d("onStart() cause error: " + th.getMessage());
                return;
            }
        }
        if (intent != null && intent.getAction() != null) {
            if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction()) || "com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                if (this.f885a.m9149a()) {
                    com.xiaomi.channel.commonutils.logger.b.d("ERROR, the job controller is blocked.");
                    bg.a().a(this, 14);
                    stopSelf();
                } else {
                    iVar = new i(intent);
                    a(iVar);
                }
            } else if (!"com.xiaomi.push.network_status_changed".equalsIgnoreCase(intent.getAction())) {
                if ("10".equals(intent.getStringExtra("ext_chid"))) {
                    intent.putExtra("rx_msg", System.currentTimeMillis());
                    intent.putExtra(com.umeng.ccg.a.f, com.xiaomi.push.s.a(getApplicationContext()));
                    intent.putExtra("wifi", com.xiaomi.push.bh.e(getApplicationContext()));
                }
                iVar = new i(intent);
                a(iVar);
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 50) {
            com.xiaomi.channel.commonutils.logger.b.c("[Prefs] spend " + currentTimeMillis2 + " ms, too more times.");
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        onStart(intent, i3);
        return 1;
    }
}

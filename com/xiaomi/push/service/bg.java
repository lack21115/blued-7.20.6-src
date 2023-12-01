package com.xiaomi.push.service;

import android.content.Context;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/bg.class */
public class bg {

    /* renamed from: a  reason: collision with root package name */
    private static bg f27939a;

    /* renamed from: a  reason: collision with other field name */
    private ConcurrentHashMap<String, HashMap<String, b>> f954a = new ConcurrentHashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private List<a> f953a = new ArrayList();

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/bg$a.class */
    public interface a {
        void a();
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/bg$b.class */
    public static class b {

        /* renamed from: a  reason: collision with other field name */
        public Context f955a;

        /* renamed from: a  reason: collision with other field name */
        Messenger f957a;

        /* renamed from: a  reason: collision with other field name */
        private XMPushService f959a;

        /* renamed from: a  reason: collision with other field name */
        public j f962a;

        /* renamed from: a  reason: collision with other field name */
        public String f963a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f965a;

        /* renamed from: b  reason: collision with other field name */
        public String f966b;

        /* renamed from: c  reason: collision with root package name */
        public String f27941c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;

        /* renamed from: a  reason: collision with other field name */
        c f961a = c.unbind;

        /* renamed from: a  reason: collision with root package name */
        private int f27940a = 0;

        /* renamed from: a  reason: collision with other field name */
        private final CopyOnWriteArrayList<a> f964a = new CopyOnWriteArrayList<>();
        c b = null;

        /* renamed from: b  reason: collision with other field name */
        private boolean f967b = false;

        /* renamed from: a  reason: collision with other field name */
        private XMPushService.c f958a = new XMPushService.c(this);

        /* renamed from: a  reason: collision with other field name */
        IBinder.DeathRecipient f956a = null;

        /* renamed from: a  reason: collision with other field name */
        final C0925b f960a = new C0925b();

        /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/bg$b$a.class */
        public interface a {
            void a(c cVar, c cVar2, int i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.xiaomi.push.service.bg$b$b  reason: collision with other inner class name */
        /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/bg$b$b.class */
        public class C0925b extends XMPushService.j {

            /* renamed from: a  reason: collision with other field name */
            String f968a;
            int b;

            /* renamed from: b  reason: collision with other field name */
            String f969b;

            /* renamed from: c  reason: collision with root package name */
            int f27943c;

            public C0925b() {
                super(0);
            }

            public XMPushService.j a(int i, int i2, String str, String str2) {
                this.b = i;
                this.f27943c = i2;
                this.f969b = str2;
                this.f968a = str;
                return this;
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public String mo9052a() {
                return "notify job";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public void mo8693a() {
                if (b.this.a(this.b, this.f27943c, this.f969b)) {
                    b.this.a(this.b, this.f27943c, this.f968a, this.f969b);
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.b(" ignore notify client :" + b.this.g);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/bg$b$c.class */
        public class c implements IBinder.DeathRecipient {

            /* renamed from: a  reason: collision with root package name */
            final Messenger f27944a;

            /* renamed from: a  reason: collision with other field name */
            final b f970a;

            c(b bVar, Messenger messenger) {
                this.f970a = bVar;
                this.f27944a = messenger;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                com.xiaomi.channel.commonutils.logger.b.b("peer died, chid = " + this.f970a.g);
                b.this.f959a.a(new bi(this, 0), 0L);
                if ("9".equals(this.f970a.g) && "com.xiaomi.xmsf".equals(b.this.f959a.getPackageName())) {
                    b.this.f959a.a(new bj(this, 0), 60000L);
                }
            }
        }

        public b() {
        }

        public b(XMPushService xMPushService) {
            this.f959a = xMPushService;
            a(new bh(this));
        }

        public static String a(String str) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            int lastIndexOf = str.lastIndexOf("/");
            return lastIndexOf != -1 ? str.substring(lastIndexOf + 1) : "";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, int i2, String str, String str2) {
            c cVar = this.f961a;
            this.b = cVar;
            if (i == 2) {
                this.f962a.a(this.f955a, this, i2);
            } else if (i == 3) {
                this.f962a.a(this.f955a, this, str2, str);
            } else if (i == 1) {
                boolean z = cVar == c.binded;
                if (!z && "wait".equals(str2)) {
                    this.f27940a++;
                } else if (z) {
                    this.f27940a = 0;
                    if (this.f957a != null) {
                        try {
                            this.f957a.send(Message.obtain(null, 16, this.f959a.f872a));
                        } catch (RemoteException e) {
                        }
                    }
                }
                this.f962a.a(this.f959a, this, z, i2, str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(int i, int i2, String str) {
            boolean z;
            StringBuilder sb;
            c cVar = this.b;
            if (cVar == null || !(z = this.f967b)) {
                return true;
            }
            if (cVar == this.f961a) {
                sb = new StringBuilder(" status recovered, don't notify client:");
            } else if (this.f957a != null && z) {
                com.xiaomi.channel.commonutils.logger.b.b("Peer alive notify status to client:" + this.g);
                return true;
            } else {
                sb = new StringBuilder("peer died, ignore notify ");
            }
            sb.append(this.g);
            com.xiaomi.channel.commonutils.logger.b.b(sb.toString());
            return false;
        }

        private boolean b(int i, int i2, String str) {
            if (i != 1) {
                return i != 2 ? i == 3 && !"wait".equals(str) : this.f959a.m9050c();
            } else if (this.f961a == c.binded || !this.f959a.m9050c() || i2 == 21) {
                return false;
            } else {
                return (i2 == 7 && "wait".equals(str)) ? false : true;
            }
        }

        public long a() {
            return (((long) ((Math.random() * 20.0d) - 10.0d)) + ((this.f27940a + 1) * 15)) * 1000;
        }

        public String a(int i) {
            return i != 1 ? i != 2 ? i != 3 ? "unknown" : "KICK" : "CLOSE" : "OPEN";
        }

        /* renamed from: a  reason: collision with other method in class */
        void m9106a() {
            try {
                Messenger messenger = this.f957a;
                if (messenger != null && this.f956a != null) {
                    messenger.getBinder().unlinkToDeath(this.f956a, 0);
                }
            } catch (Exception e) {
            }
            this.b = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(Messenger messenger) {
            m9106a();
            try {
                if (messenger == null) {
                    com.xiaomi.channel.commonutils.logger.b.b("peer linked with old sdk chid = " + this.g);
                    return;
                }
                this.f957a = messenger;
                this.f967b = true;
                this.f956a = new c(this, messenger);
                messenger.getBinder().linkToDeath(this.f956a, 0);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.b("peer linkToDeath err: " + e.getMessage());
                this.f957a = null;
                this.f967b = false;
            }
        }

        public void a(a aVar) {
            this.f964a.add(aVar);
        }

        public void a(c cVar, int i, int i2, String str, String str2) {
            Iterator<a> it = this.f964a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.a(this.f961a, cVar, i2);
                }
            }
            c cVar2 = this.f961a;
            if (cVar2 != cVar) {
                com.xiaomi.channel.commonutils.logger.b.m8344a(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", cVar2, cVar, a(i), bk.a(i2), str, str2, this.g));
                this.f961a = cVar;
            }
            if (this.f962a == null) {
                com.xiaomi.channel.commonutils.logger.b.d("status changed while the client dispatcher is missing");
            } else if (cVar == c.binding) {
            } else {
                int i3 = 0;
                if (this.b != null) {
                    boolean z = this.f967b;
                    i3 = !z ? 0 : (this.f957a == null || !z) ? 10100 : 1000;
                }
                this.f959a.b(this.f960a);
                if (b(i, i2, str2)) {
                    a(i, i2, str, str2);
                } else {
                    this.f959a.a(this.f960a.a(i, i2, str, str2), i3);
                }
            }
        }

        public void b(a aVar) {
            this.f964a.remove(aVar);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/bg$c.class */
    public enum c {
        unbind,
        binding,
        binded
    }

    private bg() {
    }

    public static bg a() {
        bg bgVar;
        synchronized (bg.class) {
            try {
                if (f27939a == null) {
                    f27939a = new bg();
                }
                bgVar = f27939a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bgVar;
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("@");
        String str2 = str;
        if (indexOf > 0) {
            str2 = str.substring(0, indexOf);
        }
        return str2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public int m9098a() {
        int size;
        synchronized (this) {
            size = this.f954a.size();
        }
        return size;
    }

    public b a(String str, String str2) {
        synchronized (this) {
            HashMap<String, b> hashMap = this.f954a.get(str);
            if (hashMap == null) {
                return null;
            }
            return hashMap.get(a(str2));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public ArrayList<b> m9099a() {
        ArrayList<b> arrayList;
        synchronized (this) {
            arrayList = new ArrayList<>();
            for (HashMap<String, b> hashMap : this.f954a.values()) {
                arrayList.addAll(hashMap.values());
            }
        }
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Collection<b> m9100a(String str) {
        synchronized (this) {
            if (this.f954a.containsKey(str)) {
                return ((HashMap) this.f954a.get(str).clone()).values();
            }
            return new ArrayList();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public List<String> m9101a(String str) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList();
            for (HashMap<String, b> hashMap : this.f954a.values()) {
                for (b bVar : hashMap.values()) {
                    if (str.equals(bVar.f963a)) {
                        arrayList.add(bVar.g);
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m9102a() {
        synchronized (this) {
            Iterator<b> it = m9099a().iterator();
            while (it.hasNext()) {
                it.next().m9106a();
            }
            this.f954a.clear();
        }
    }

    public void a(Context context) {
        synchronized (this) {
            for (HashMap<String, b> hashMap : this.f954a.values()) {
                for (b bVar : hashMap.values()) {
                    bVar.a(c.unbind, 1, 3, (String) null, (String) null);
                }
            }
        }
    }

    public void a(Context context, int i) {
        synchronized (this) {
            for (HashMap<String, b> hashMap : this.f954a.values()) {
                for (b bVar : hashMap.values()) {
                    bVar.a(c.unbind, 2, i, (String) null, (String) null);
                }
            }
        }
    }

    public void a(a aVar) {
        synchronized (this) {
            this.f953a.add(aVar);
        }
    }

    public void a(b bVar) {
        synchronized (this) {
            HashMap<String, b> hashMap = this.f954a.get(bVar.g);
            HashMap<String, b> hashMap2 = hashMap;
            if (hashMap == null) {
                hashMap2 = new HashMap<>();
                this.f954a.put(bVar.g, hashMap2);
            }
            hashMap2.put(a(bVar.f966b), bVar);
            com.xiaomi.channel.commonutils.logger.b.m8344a("add active client. " + bVar.f963a);
            for (a aVar : this.f953a) {
                aVar.a();
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m9103a(String str) {
        synchronized (this) {
            HashMap<String, b> hashMap = this.f954a.get(str);
            if (hashMap != null) {
                for (b bVar : hashMap.values()) {
                    bVar.m9106a();
                }
                hashMap.clear();
                this.f954a.remove(str);
            }
            for (a aVar : this.f953a) {
                aVar.a();
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m9104a(String str, String str2) {
        synchronized (this) {
            HashMap<String, b> hashMap = this.f954a.get(str);
            if (hashMap != null) {
                b bVar = hashMap.get(a(str2));
                if (bVar != null) {
                    bVar.m9106a();
                }
                hashMap.remove(a(str2));
                if (hashMap.isEmpty()) {
                    this.f954a.remove(str);
                }
            }
            for (a aVar : this.f953a) {
                aVar.a();
            }
        }
    }

    public void b() {
        synchronized (this) {
            this.f953a.clear();
        }
    }
}

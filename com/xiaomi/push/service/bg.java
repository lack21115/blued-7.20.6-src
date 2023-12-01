package com.xiaomi.push.service;

import android.content.Context;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
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
    private static bg f41630a;

    /* renamed from: a  reason: collision with other field name */
    private ConcurrentHashMap<String, HashMap<String, b>> f1001a = new ConcurrentHashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private List<a> f1000a = new ArrayList();

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/bg$a.class */
    public interface a {
        void a();
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/bg$b.class */
    public static class b {

        /* renamed from: a  reason: collision with other field name */
        public Context f1002a;

        /* renamed from: a  reason: collision with other field name */
        Messenger f1004a;

        /* renamed from: a  reason: collision with other field name */
        private XMPushService f1006a;

        /* renamed from: a  reason: collision with other field name */
        public j f1009a;

        /* renamed from: a  reason: collision with other field name */
        public String f1010a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f1012a;

        /* renamed from: b  reason: collision with other field name */
        public String f1013b;

        /* renamed from: c  reason: collision with root package name */
        public String f41632c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;

        /* renamed from: a  reason: collision with other field name */
        c f1008a = c.unbind;

        /* renamed from: a  reason: collision with root package name */
        private int f41631a = 0;

        /* renamed from: a  reason: collision with other field name */
        private final CopyOnWriteArrayList<a> f1011a = new CopyOnWriteArrayList<>();
        c b = null;

        /* renamed from: b  reason: collision with other field name */
        private boolean f1014b = false;

        /* renamed from: a  reason: collision with other field name */
        private XMPushService.c f1005a = new XMPushService.c(this);

        /* renamed from: a  reason: collision with other field name */
        IBinder.DeathRecipient f1003a = null;

        /* renamed from: a  reason: collision with other field name */
        final C1095b f1007a = new C1095b();

        /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/bg$b$a.class */
        public interface a {
            void a(c cVar, c cVar2, int i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.xiaomi.push.service.bg$b$b  reason: collision with other inner class name */
        /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/bg$b$b.class */
        public class C1095b extends XMPushService.j {

            /* renamed from: a  reason: collision with other field name */
            String f1015a;
            int b;

            /* renamed from: b  reason: collision with other field name */
            String f1016b;

            /* renamed from: c  reason: collision with root package name */
            int f41634c;

            public C1095b() {
                super(0);
            }

            public XMPushService.j a(int i, int i2, String str, String str2) {
                this.b = i;
                this.f41634c = i2;
                this.f1016b = str2;
                this.f1015a = str;
                return this;
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public String mo12102a() {
                return "notify job";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* renamed from: a */
            public void mo11743a() {
                if (b.this.a(this.b, this.f41634c, this.f1016b)) {
                    b.this.a(this.b, this.f41634c, this.f1015a, this.f1016b);
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.b(" ignore notify client :" + b.this.g);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/bg$b$c.class */
        public class c implements IBinder.DeathRecipient {

            /* renamed from: a  reason: collision with root package name */
            final Messenger f41635a;

            /* renamed from: a  reason: collision with other field name */
            final b f1017a;

            c(b bVar, Messenger messenger) {
                this.f1017a = bVar;
                this.f41635a = messenger;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                com.xiaomi.channel.commonutils.logger.b.b("peer died, chid = " + this.f1017a.g);
                b.this.f1006a.a(new bi(this, 0), 0L);
                if ("9".equals(this.f1017a.g) && "com.xiaomi.xmsf".equals(b.this.f1006a.getPackageName())) {
                    b.this.f1006a.a(new bj(this, 0), 60000L);
                }
            }
        }

        public b() {
        }

        public b(XMPushService xMPushService) {
            this.f1006a = xMPushService;
            a(new bh(this));
        }

        public static String a(String str) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            int lastIndexOf = str.lastIndexOf(BridgeUtil.SPLIT_MARK);
            return lastIndexOf != -1 ? str.substring(lastIndexOf + 1) : "";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, int i2, String str, String str2) {
            c cVar = this.f1008a;
            this.b = cVar;
            if (i == 2) {
                this.f1009a.a(this.f1002a, this, i2);
            } else if (i == 3) {
                this.f1009a.a(this.f1002a, this, str2, str);
            } else if (i == 1) {
                boolean z = cVar == c.binded;
                if (!z && "wait".equals(str2)) {
                    this.f41631a++;
                } else if (z) {
                    this.f41631a = 0;
                    if (this.f1004a != null) {
                        try {
                            this.f1004a.send(Message.obtain(null, 16, this.f1006a.f919a));
                        } catch (RemoteException e) {
                        }
                    }
                }
                this.f1009a.a(this.f1006a, this, z, i2, str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(int i, int i2, String str) {
            boolean z;
            StringBuilder sb;
            c cVar = this.b;
            if (cVar == null || !(z = this.f1014b)) {
                return true;
            }
            if (cVar == this.f1008a) {
                sb = new StringBuilder(" status recovered, don't notify client:");
            } else if (this.f1004a != null && z) {
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
                return i != 2 ? i == 3 && !"wait".equals(str) : this.f1006a.m12100c();
            } else if (this.f1008a == c.binded || !this.f1006a.m12100c() || i2 == 21) {
                return false;
            } else {
                return (i2 == 7 && "wait".equals(str)) ? false : true;
            }
        }

        public long a() {
            return (((long) ((Math.random() * 20.0d) - 10.0d)) + ((this.f41631a + 1) * 15)) * 1000;
        }

        public String a(int i) {
            return i != 1 ? i != 2 ? i != 3 ? "unknown" : "KICK" : "CLOSE" : "OPEN";
        }

        /* renamed from: a  reason: collision with other method in class */
        void m12156a() {
            try {
                Messenger messenger = this.f1004a;
                if (messenger != null && this.f1003a != null) {
                    messenger.getBinder().unlinkToDeath(this.f1003a, 0);
                }
            } catch (Exception e) {
            }
            this.b = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(Messenger messenger) {
            m12156a();
            try {
                if (messenger == null) {
                    com.xiaomi.channel.commonutils.logger.b.b("peer linked with old sdk chid = " + this.g);
                    return;
                }
                this.f1004a = messenger;
                this.f1014b = true;
                this.f1003a = new c(this, messenger);
                messenger.getBinder().linkToDeath(this.f1003a, 0);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.b("peer linkToDeath err: " + e.getMessage());
                this.f1004a = null;
                this.f1014b = false;
            }
        }

        public void a(a aVar) {
            this.f1011a.add(aVar);
        }

        public void a(c cVar, int i, int i2, String str, String str2) {
            Iterator<a> it = this.f1011a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.a(this.f1008a, cVar, i2);
                }
            }
            c cVar2 = this.f1008a;
            if (cVar2 != cVar) {
                com.xiaomi.channel.commonutils.logger.b.m11394a(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", cVar2, cVar, a(i), bk.a(i2), str, str2, this.g));
                this.f1008a = cVar;
            }
            if (this.f1009a == null) {
                com.xiaomi.channel.commonutils.logger.b.d("status changed while the client dispatcher is missing");
            } else if (cVar == c.binding) {
            } else {
                int i3 = 0;
                if (this.b != null) {
                    boolean z = this.f1014b;
                    i3 = !z ? 0 : (this.f1004a == null || !z) ? 10100 : 1000;
                }
                this.f1006a.b(this.f1007a);
                if (b(i, i2, str2)) {
                    a(i, i2, str, str2);
                } else {
                    this.f1006a.a(this.f1007a.a(i, i2, str, str2), i3);
                }
            }
        }

        public void b(a aVar) {
            this.f1011a.remove(aVar);
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
                if (f41630a == null) {
                    f41630a = new bg();
                }
                bgVar = f41630a;
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
    public int m12148a() {
        int size;
        synchronized (this) {
            size = this.f1001a.size();
        }
        return size;
    }

    public b a(String str, String str2) {
        synchronized (this) {
            HashMap<String, b> hashMap = this.f1001a.get(str);
            if (hashMap == null) {
                return null;
            }
            return hashMap.get(a(str2));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public ArrayList<b> m12149a() {
        ArrayList<b> arrayList;
        synchronized (this) {
            arrayList = new ArrayList<>();
            for (HashMap<String, b> hashMap : this.f1001a.values()) {
                arrayList.addAll(hashMap.values());
            }
        }
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Collection<b> m12150a(String str) {
        synchronized (this) {
            if (this.f1001a.containsKey(str)) {
                return ((HashMap) this.f1001a.get(str).clone()).values();
            }
            return new ArrayList();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public List<String> m12151a(String str) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList();
            for (HashMap<String, b> hashMap : this.f1001a.values()) {
                for (b bVar : hashMap.values()) {
                    if (str.equals(bVar.f1010a)) {
                        arrayList.add(bVar.g);
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m12152a() {
        synchronized (this) {
            Iterator<b> it = m12149a().iterator();
            while (it.hasNext()) {
                it.next().m12156a();
            }
            this.f1001a.clear();
        }
    }

    public void a(Context context) {
        synchronized (this) {
            for (HashMap<String, b> hashMap : this.f1001a.values()) {
                for (b bVar : hashMap.values()) {
                    bVar.a(c.unbind, 1, 3, (String) null, (String) null);
                }
            }
        }
    }

    public void a(Context context, int i) {
        synchronized (this) {
            for (HashMap<String, b> hashMap : this.f1001a.values()) {
                for (b bVar : hashMap.values()) {
                    bVar.a(c.unbind, 2, i, (String) null, (String) null);
                }
            }
        }
    }

    public void a(a aVar) {
        synchronized (this) {
            this.f1000a.add(aVar);
        }
    }

    public void a(b bVar) {
        synchronized (this) {
            HashMap<String, b> hashMap = this.f1001a.get(bVar.g);
            HashMap<String, b> hashMap2 = hashMap;
            if (hashMap == null) {
                hashMap2 = new HashMap<>();
                this.f1001a.put(bVar.g, hashMap2);
            }
            hashMap2.put(a(bVar.f1013b), bVar);
            com.xiaomi.channel.commonutils.logger.b.m11394a("add active client. " + bVar.f1010a);
            for (a aVar : this.f1000a) {
                aVar.a();
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m12153a(String str) {
        synchronized (this) {
            HashMap<String, b> hashMap = this.f1001a.get(str);
            if (hashMap != null) {
                for (b bVar : hashMap.values()) {
                    bVar.m12156a();
                }
                hashMap.clear();
                this.f1001a.remove(str);
            }
            for (a aVar : this.f1000a) {
                aVar.a();
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m12154a(String str, String str2) {
        synchronized (this) {
            HashMap<String, b> hashMap = this.f1001a.get(str);
            if (hashMap != null) {
                b bVar = hashMap.get(a(str2));
                if (bVar != null) {
                    bVar.m12156a();
                }
                hashMap.remove(a(str2));
                if (hashMap.isEmpty()) {
                    this.f1001a.remove(str);
                }
            }
            for (a aVar : this.f1000a) {
                aVar.a();
            }
        }
    }

    public void b() {
        synchronized (this) {
            this.f1000a.clear();
        }
    }
}

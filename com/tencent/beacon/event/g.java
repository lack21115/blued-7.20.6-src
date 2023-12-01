package com.tencent.beacon.event;

import com.tencent.beacon.base.net.call.JceRequestEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/event/g.class */
public class g implements com.tencent.beacon.a.a.d, Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final String f21364a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final com.tencent.beacon.event.a.a f21365c;
    private final Set<Long> d = new HashSet();
    private final Set<Long> e = new HashSet();
    private final List<Long> f = new ArrayList();
    private final String g;
    private boolean h;
    private int i;
    private boolean j;
    private String k;

    public g(int i, com.tencent.beacon.event.a.a aVar, boolean z) {
        this.b = i;
        this.f21365c = aVar;
        this.h = z;
        this.f21364a = z ? "t_r_e" : "t_n_e";
        this.i = z ? com.tencent.beacon.e.b.a().d() : com.tencent.beacon.e.b.a().c();
        this.g = "[EventReport (" + this.f21364a + ")]";
    }

    private void a(List<EventBean> list, Set<Long> set) {
        JceRequestEntity a2 = com.tencent.beacon.event.c.d.a(list, this.h);
        com.tencent.beacon.base.util.c.a(this.g, 2, "event request entity: %s", a2.toString());
        com.tencent.beacon.base.net.c.c().b(a2).a(new f(this, this.f21364a, this.f21365c, set, this.k));
    }

    private List<EventBean> b() {
        StringBuilder sb = new StringBuilder();
        for (Long l : this.d) {
            sb.append(l);
            sb.append(",");
        }
        return this.f21365c.a(this.f21364a, sb.length() > 0 ? sb.substring(0, sb.lastIndexOf(",")) : "", this.i);
    }

    private void c() {
        com.tencent.beacon.a.a.b.a().a(2, this);
    }

    public int a() {
        return this.i;
    }

    public void a(long j) {
        synchronized (this.f) {
            this.f.add(Long.valueOf(j));
            if (this.f.size() >= 10) {
                long j2 = 0;
                for (Long l : this.f) {
                    j2 += l.longValue();
                }
                StringBuilder sb = new StringBuilder();
                sb.append(j2 / this.f.size());
                sb.append("");
                com.tencent.beacon.a.b.f.e().a("703", sb.toString());
                this.f.clear();
            }
        }
    }

    @Override // com.tencent.beacon.a.a.d
    public void a(com.tencent.beacon.a.a.c cVar) {
        Map map;
        if (cVar.f21229a != 2 || (map = (Map) cVar.b.get("d_m")) == null) {
            return;
        }
        if (this.h) {
            this.i = com.tencent.beacon.base.util.b.a((String) map.get("realtimeUploadNum"), this.i, 24, 100);
        } else {
            this.i = com.tencent.beacon.base.util.b.a((String) map.get("normalUploadNum"), this.i, 24, 100);
        }
    }

    public void a(Set<Long> set) {
        synchronized (this.d) {
            this.d.removeAll(set);
            set.clear();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.j) {
            c();
            this.j = true;
        }
        if (!com.tencent.beacon.base.net.b.d.d() || com.tencent.beacon.base.net.c.c().d()) {
            com.tencent.beacon.a.b.a.a().a(this.b, false);
            return;
        }
        synchronized (this.d) {
            com.tencent.beacon.base.util.c.a(this.g, 0, "start read EventBean from DB.", new Object[0]);
            List<EventBean> b = b();
            if (b != null && !b.isEmpty()) {
                HashMap hashMap = new HashMap();
                for (EventBean eventBean : b) {
                    long cid = eventBean.getCid();
                    this.d.add(Long.valueOf(cid));
                    this.e.add(Long.valueOf(cid));
                    Map<String, String> eventValue = eventBean.getEventValue();
                    if (eventValue != null) {
                        String appKey = eventBean.getAppKey();
                        String str = (String) hashMap.get(appKey);
                        String str2 = str;
                        if (str == null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(appKey);
                            sb.append(": ");
                            str2 = sb.toString();
                        }
                        String str3 = eventValue.get("A100");
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str2);
                        sb2.append(str3);
                        sb2.append(", ");
                        hashMap.put(appKey, sb2.toString());
                    }
                }
                StringBuilder sb3 = new StringBuilder("--logID: \n");
                for (Map.Entry entry : hashMap.entrySet()) {
                    sb3.append((String) entry.getValue());
                    sb3.append("\n");
                }
                String sb4 = sb3.toString();
                this.k = sb4;
                com.tencent.beacon.base.util.c.a(this.g, 1, "send LogID: %s", sb4);
                a(b, this.e);
                b.clear();
                this.e.clear();
                return;
            }
            com.tencent.beacon.base.util.c.a(this.g, 1, "EventBean List == null. Task end!", new Object[0]);
            com.tencent.beacon.a.b.a.a().a(this.b, false);
        }
    }
}

package com.tencent.tmsbeacon.event;

import com.tencent.mapsdk.internal.lj;
import com.tencent.tmsbeacon.a.a.b;
import com.tencent.tmsbeacon.base.net.call.JceRequestEntity;
import com.tencent.tmsbeacon.base.util.c;
import com.tencent.tmsbeacon.event.a.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/event/g.class */
public class g implements com.tencent.tmsbeacon.a.a.d, Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final String f25882a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final a f25883c;
    private final Set<Long> d = new HashSet();
    private final Set<Long> e = new HashSet();
    private final String f;
    private boolean g;
    private int h;
    private boolean i;
    private String j;

    public g(int i, a aVar, boolean z) {
        this.b = i;
        this.f25883c = aVar;
        this.g = z;
        String str = z ? "t_r_e" : "t_n_e";
        this.f25882a = str;
        this.h = 48;
        this.f = "[EventReport (" + str + ")]";
    }

    private void a(List<EventBean> list) {
        HashMap hashMap = new HashMap();
        for (EventBean eventBean : list) {
            Map<String, String> eventValue = eventBean.getEventValue();
            if (eventValue != null) {
                String appKey = eventBean.getAppKey();
                String str = (String) hashMap.get(appKey);
                String str2 = str;
                if (str == null) {
                    str2 = appKey + ": ";
                }
                hashMap.put(appKey, str2 + eventValue.get("A100") + ", ");
            }
        }
        StringBuilder sb = new StringBuilder("--logID: \n");
        for (Map.Entry entry : hashMap.entrySet()) {
            sb.append((String) entry.getValue());
            sb.append("\n");
        }
        String sb2 = sb.toString();
        this.j = sb2;
        c.a(this.f, 1, "send LogID: %s", sb2);
    }

    private void a(List<EventBean> list, Set<Long> set) {
        JceRequestEntity a2 = com.tencent.tmsbeacon.event.c.d.a(list, this.g);
        c.a(this.f, 2, "event request entity: %s", a2.toString());
        com.tencent.tmsbeacon.base.net.c.c().b(a2).a(new lj(this, this.f25882a, this.f25883c, set, this.j));
    }

    private List<EventBean> b() {
        StringBuilder sb = new StringBuilder();
        for (Long l : this.d) {
            sb.append(l);
            sb.append(",");
        }
        return this.f25883c.a(this.f25882a, sb.length() > 0 ? sb.substring(0, sb.lastIndexOf(",")) : "", this.h);
    }

    private void c() {
        b.a().a(2, this);
    }

    public int a() {
        return this.h;
    }

    public void a(Set<Long> set) {
        synchronized (this.d) {
            this.d.removeAll(set);
            set.clear();
        }
    }

    @Override // com.tencent.tmsbeacon.a.a.d
    public void onEvent(com.tencent.tmsbeacon.a.a.c cVar) {
        Map map;
        if (cVar.f25769a != 2 || (map = (Map) cVar.b.get("d_m")) == null) {
            return;
        }
        if (this.g) {
            this.h = com.tencent.tmsbeacon.base.util.b.a((String) map.get("realtimeUploadNum"), this.h, 24, 100);
            return;
        }
        this.h = com.tencent.tmsbeacon.base.util.b.a((String) map.get("normalUploadNum"), this.h, 24, 100);
        c.a("normal uploadNum has changed to " + this.h, new Object[0]);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.i) {
            c();
            this.i = true;
        }
        if (!com.tencent.tmsbeacon.base.net.b.d.d() || com.tencent.tmsbeacon.base.net.c.c().d()) {
            com.tencent.tmsbeacon.a.b.a.a().a(this.b, false);
            return;
        }
        synchronized (this.d) {
            c.a(this.f, 0, "start read EventBean from DB.", new Object[0]);
            List<EventBean> b = b();
            if (b != null && !b.isEmpty()) {
                for (EventBean eventBean : b) {
                    long cid = eventBean.getCid();
                    this.d.add(Long.valueOf(cid));
                    this.e.add(Long.valueOf(cid));
                }
                a(b);
                a(b, this.e);
                b.clear();
                this.e.clear();
                return;
            }
            c.a(this.f, 1, "EventBean List == null. Task end!", new Object[0]);
            com.tencent.tmsbeacon.a.b.a.a().a(this.b, false);
        }
    }
}

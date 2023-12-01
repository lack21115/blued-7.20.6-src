package com.tencent.beacon.event;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.beacon.event.immediate.Beacon2MsfTransferArgs;
import com.tencent.beacon.event.immediate.Beacon2WnsTransferArgs;
import com.tencent.beacon.event.immediate.BeaconTransferArgs;
import com.tencent.beacon.event.open.EventResult;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/event/d.class */
public class d implements com.tencent.beacon.a.a.d, h {
    private final com.tencent.beacon.event.a.a b;

    /* renamed from: c  reason: collision with root package name */
    private final g f21360c;
    private final g d;
    private long e = 2000;
    private long f = 5000;

    /* renamed from: a  reason: collision with root package name */
    private final Handler f21359a = com.tencent.beacon.a.b.a.a().a(3000);

    public d() {
        com.tencent.beacon.event.a.a a2 = com.tencent.beacon.event.a.a.a();
        this.b = a2;
        this.f21360c = new g(2000, a2, true);
        this.d = new g(1000, this.b, false);
        com.tencent.beacon.a.a.b.a().a(11, this);
        com.tencent.beacon.a.a.b.a().a(2, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BeaconTransferArgs a(byte[] bArr, EventBean eventBean) {
        if (eventBean.getEventType() == 3) {
            return new Beacon2MsfTransferArgs(bArr);
        }
        Beacon2WnsTransferArgs beacon2WnsTransferArgs = new Beacon2WnsTransferArgs(bArr);
        beacon2WnsTransferArgs.setAppkey(eventBean.getAppKey());
        beacon2WnsTransferArgs.setEventCode(eventBean.getEventCode());
        return beacon2WnsTransferArgs;
    }

    @Override // com.tencent.beacon.event.h
    public EventResult a(String str, EventBean eventBean) {
        com.tencent.beacon.base.util.c.a("[EventManager]", "eventName is %s, logID is %s", eventBean.getEventCode(), str);
        com.tencent.beacon.a.b.a.a().a(new b(this, eventBean, str));
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = "-1";
        }
        return EventResult.a.a(Long.parseLong(str2));
    }

    @Override // com.tencent.beacon.event.h
    public void a() {
        com.tencent.beacon.a.b.a.a().a(2000, 0L, this.e, this.f21360c);
        com.tencent.beacon.a.b.a.a().a(1000, 0L, this.f, this.d);
    }

    @Override // com.tencent.beacon.a.a.d
    public void a(com.tencent.beacon.a.a.c cVar) {
        int i = cVar.f21229a;
        if (i == 2) {
            Map map = (Map) cVar.b.get("d_m");
            if (map != null) {
                if (this.e == 2000) {
                    this.e = com.tencent.beacon.base.util.b.a((String) map.get("realtimePollingTime"), this.e, 1000L, 10000L);
                }
                if (this.f == 5000) {
                    this.f = com.tencent.beacon.base.util.b.a((String) map.get("normalPollingTime"), this.f, 2000L, 3600000L);
                }
            }
        } else if (i == 11) {
            Object obj = cVar.b.get("u_c_r_p");
            if (obj != null) {
                long longValue = ((Long) obj).longValue();
                if (longValue >= 1000 && longValue <= 10000) {
                    this.e = longValue;
                }
            }
            Object obj2 = cVar.b.get("u_c_n_p");
            if (obj2 != null) {
                long longValue2 = ((Long) obj2).longValue();
                if (longValue2 >= 2000 && longValue2 <= 3600000) {
                    this.f = longValue2;
                }
            }
        }
        com.tencent.beacon.base.util.c.a("[EventManager]", "pollingTime maybe change, realtime: %s normal: %s", Long.valueOf(this.e), Long.valueOf(this.f));
    }

    public void a(EventBean eventBean, String str) {
        Map<String, String> eventValue = eventBean.getEventValue();
        eventValue.put("A156", "N");
        eventBean.setEventValue(eventValue);
        ArrayList arrayList = new ArrayList();
        arrayList.add(eventBean);
        com.tencent.beacon.base.net.c.c().b(com.tencent.beacon.event.c.d.a(arrayList, true)).a(new c(this, eventBean, str), com.tencent.beacon.a.b.a.b());
    }

    @Override // com.tencent.beacon.event.h
    public void a(boolean z) {
        if (z) {
            this.d.run();
            this.f21360c.run();
            return;
        }
        com.tencent.beacon.a.b.a.a().a(this.d);
        com.tencent.beacon.a.b.a.a().a(this.f21360c);
    }

    @Override // com.tencent.beacon.event.h
    public boolean a(Runnable runnable) {
        return this.f21359a.post(runnable);
    }

    @Override // com.tencent.beacon.event.h
    public EventResult b(String str, EventBean eventBean) {
        boolean a2 = a(new a(this, eventBean));
        com.tencent.beacon.base.util.c.a("[EventModule]", 1, "event: %s. go in EventManager(%s). offer: %s", eventBean.getEventCode(), eventBean.getAppKey(), Boolean.valueOf(a2));
        if (a2) {
            String str2 = str;
            if (TextUtils.isEmpty(str)) {
                str2 = "-1";
            }
            return EventResult.a.a(Long.parseLong(str2));
        }
        return EventResult.a.a(103);
    }

    @Override // com.tencent.beacon.event.h
    public void b() {
        com.tencent.beacon.a.b.a.a().b(2000);
        com.tencent.beacon.a.b.a.a().b(1000);
    }

    @Override // com.tencent.beacon.event.h
    public void c() {
        com.tencent.beacon.a.b.a.a().a(2000, false);
        com.tencent.beacon.a.b.a.a().a(1000, false);
    }
}

package com.tencent.tmsbeacon.event;

import android.os.Handler;
import android.text.TextUtils;
import com.anythink.expressad.video.module.a.a.m;
import com.opos.acs.st.utils.ErrorContants;
import com.tencent.tmsbeacon.base.net.call.Callback;
import com.tencent.tmsbeacon.event.immediate.Beacon2MsfTransferArgs;
import com.tencent.tmsbeacon.event.immediate.Beacon2WnsTransferArgs;
import com.tencent.tmsbeacon.event.immediate.BeaconImmediateReportCallback;
import com.tencent.tmsbeacon.event.immediate.BeaconTransferArgs;
import com.tencent.tmsbeacon.event.open.BeaconReport;
import com.tencent.tmsbeacon.event.open.EventResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/event/d.class */
public class d implements com.tencent.tmsbeacon.a.a.d, h {
    private final com.tencent.tmsbeacon.event.a.a b;

    /* renamed from: c  reason: collision with root package name */
    private final g f39569c;
    private final g d;
    private long e = 2000;
    private long f = m.ag;

    /* renamed from: a  reason: collision with root package name */
    private final Handler f39568a = com.tencent.tmsbeacon.a.b.a.a().a(3000);

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/event/d$a.class */
    public class a implements Runnable {
        public final /* synthetic */ EventBean b;

        public a(EventBean eventBean) {
            this.b = eventBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.b.a(this.b.getEventType())) {
                boolean a2 = d.this.b.a(this.b);
                com.tencent.tmsbeacon.base.util.c.a("[EventModule]", 2, "event: %s. insert to DB %s", this.b.getEventCode(), Boolean.valueOf(a2));
                if (a2) {
                    d.this.b();
                    return;
                }
                return;
            }
            com.tencent.tmsbeacon.a.b.d b = com.tencent.tmsbeacon.a.b.d.b();
            b.a(ErrorContants.PERIODIC_REPORT_ERROR, "type: " + com.tencent.tmsbeacon.event.c.d.a(this.b.getEventType()) + " max db count!");
            com.tencent.tmsbeacon.base.util.c.a("[EventModule]", 2, "event: %s. insert to DB false. reason: DB count max!", this.b.getEventCode());
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/event/d$b.class */
    public class b implements Runnable {
        public final /* synthetic */ EventBean b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f39571c;

        public b(EventBean eventBean, String str) {
            this.b = eventBean;
            this.f39571c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                BeaconReport.getInstance().getImmediateReport().reportImmediate(d.this.a(com.tencent.tmsbeacon.event.c.d.a(this.b).toByteArray(), this.b), new BeaconImmediateReportCallback(d.this, this.b, this.f39571c));
            } catch (Throwable th) {
                com.tencent.tmsbeacon.base.util.c.b("[immediate] report error!", new Object[0]);
                com.tencent.tmsbeacon.base.util.c.a(th);
                d.this.a(this.b, this.f39571c);
                com.tencent.tmsbeacon.a.b.d.b().a("515", "immediate report error!", th);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/event/d$c.class */
    public class c implements Callback<byte[]> {
        public final /* synthetic */ EventBean b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f39572c;

        public c(EventBean eventBean, String str) {
            this.b = eventBean;
            this.f39572c = str;
        }

        @Override // com.tencent.tmsbeacon.base.net.call.Callback
        /* renamed from: a */
        public void onResponse(byte[] bArr) {
            com.tencent.tmsbeacon.base.util.c.a("[EventManager]", "convert to report by beacon socket success, eventCode = %s, logId = %s", this.b.getEventCode(), this.f39572c);
        }

        @Override // com.tencent.tmsbeacon.base.net.call.Callback
        public void onFailure(com.tencent.tmsbeacon.base.net.d dVar) {
            com.tencent.tmsbeacon.base.util.c.e("convert to report by beacon socket also fail, failure = %s", dVar.toString());
            com.tencent.tmsbeacon.a.b.d.b().a("464", dVar.toString());
            d.this.b(this.f39572c, this.b);
        }
    }

    public d() {
        com.tencent.tmsbeacon.event.a.a aVar = new com.tencent.tmsbeacon.event.a.a();
        this.b = aVar;
        this.f39569c = new g(2000, aVar, true);
        this.d = new g(1000, aVar, false);
        com.tencent.tmsbeacon.a.a.b.a().a(11, this);
        com.tencent.tmsbeacon.a.a.b.a().a(2, this);
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

    @Override // com.tencent.tmsbeacon.event.h
    public EventResult a(String str, EventBean eventBean) {
        com.tencent.tmsbeacon.base.util.c.a("[EventManager]", "eventName is %s, logID is %s", eventBean.getEventCode(), str);
        com.tencent.tmsbeacon.a.b.a.a().a(new b(eventBean, str));
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = "-1";
        }
        return EventResult.a.a(Long.parseLong(str2));
    }

    @Override // com.tencent.tmsbeacon.event.h
    public void a() {
        com.tencent.tmsbeacon.a.b.a.a().a(2000, 0L, this.e, this.f39569c);
        com.tencent.tmsbeacon.a.b.a.a().a(1000, 0L, this.f, this.d);
    }

    public void a(EventBean eventBean, String str) {
        Map<String, String> eventValue = eventBean.getEventValue();
        eventValue.put("A156", "N");
        eventBean.setEventValue(eventValue);
        ArrayList arrayList = new ArrayList();
        arrayList.add(eventBean);
        com.tencent.tmsbeacon.base.net.c.c().b(com.tencent.tmsbeacon.event.c.d.a((List<EventBean>) arrayList, true)).a(new c(eventBean, str), com.tencent.tmsbeacon.a.b.a.b());
    }

    @Override // com.tencent.tmsbeacon.event.h
    public void a(boolean z) {
        if (z) {
            this.d.run();
            this.f39569c.run();
            return;
        }
        com.tencent.tmsbeacon.a.b.a.a().a(this.d);
        com.tencent.tmsbeacon.a.b.a.a().a(this.f39569c);
    }

    @Override // com.tencent.tmsbeacon.event.h
    public boolean a(Runnable runnable) {
        return this.f39568a.post(runnable);
    }

    @Override // com.tencent.tmsbeacon.event.h
    public EventResult b(String str, EventBean eventBean) {
        boolean a2 = a(new a(eventBean));
        com.tencent.tmsbeacon.base.util.c.a("[EventModule]", 1, "event: %s. go in EventManager(%s). offer: %s", eventBean.getEventCode(), eventBean.getAppKey(), Boolean.valueOf(a2));
        if (a2) {
            String str2 = str;
            if (TextUtils.isEmpty(str)) {
                str2 = "-1";
            }
            return EventResult.a.a(Long.parseLong(str2));
        }
        return EventResult.a.a(103);
    }

    @Override // com.tencent.tmsbeacon.event.h
    public void b() {
        com.tencent.tmsbeacon.a.b.a.a().b(2000);
        com.tencent.tmsbeacon.a.b.a.a().b(1000);
    }

    @Override // com.tencent.tmsbeacon.event.h
    public void c() {
        com.tencent.tmsbeacon.a.b.a.a().a(2000, false);
        com.tencent.tmsbeacon.a.b.a.a().a(1000, false);
    }

    @Override // com.tencent.tmsbeacon.a.a.d
    public void onEvent(com.tencent.tmsbeacon.a.a.c cVar) {
        int i = cVar.f39460a;
        if (i == 2) {
            Map map = (Map) cVar.b.get("d_m");
            if (map != null) {
                this.e = com.tencent.tmsbeacon.base.util.b.a((String) map.get("realtimePollingTime"), this.e, 1000L, 10000L);
                this.f = com.tencent.tmsbeacon.base.util.b.a((String) map.get("normalPollingTime"), this.f, 2000L, 3600000L);
            }
            com.tencent.tmsbeacon.base.util.c.a("normal polling time has changed to " + this.f, new Object[0]);
        } else if (i == 11) {
            Object obj = cVar.b.get("u_c_r_p");
            if (obj != null) {
                long longValue = ((Long) obj).longValue();
                if (longValue <= 1000) {
                    longValue = 1000;
                }
                this.e = longValue;
            }
            Object obj2 = cVar.b.get("u_c_n_p");
            if (obj2 != null) {
                long longValue2 = ((Long) obj2).longValue();
                if (longValue2 <= 2000) {
                    longValue2 = 2000;
                }
                this.f = longValue2;
            }
        }
        com.tencent.tmsbeacon.base.util.c.a("[EventManager]", "pollingTime maybe change, realtime: %s normal: %s", Long.valueOf(this.e), Long.valueOf(this.f));
    }
}

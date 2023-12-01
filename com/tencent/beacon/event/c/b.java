package com.tencent.beacon.event.c;

import com.tencent.beacon.base.net.a.c;
import com.tencent.beacon.event.EventBean;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/event/c/b.class */
public final class b extends c.a<EventBean, com.tencent.beacon.event.a.b> {

    /* renamed from: a  reason: collision with root package name */
    private final C0898b f35043a = new C0898b();
    private final a b = new a();

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/event/c/b$a.class */
    static final class a implements com.tencent.beacon.base.net.a.c<EventBean, com.tencent.beacon.event.a.b> {
        a() {
        }

        @Override // com.tencent.beacon.base.net.a.c
        public com.tencent.beacon.event.a.b a(EventBean eventBean) {
            com.tencent.beacon.event.a.b bVar = new com.tencent.beacon.event.a.b();
            bVar.b = eventBean.getEventTime();
            bVar.d = eventBean.getAppKey();
            byte[] a2 = com.tencent.beacon.base.util.b.a(eventBean);
            bVar.e = a2;
            if (a2 != null) {
                bVar.f35036c = a2.length;
            }
            return bVar;
        }
    }

    /* renamed from: com.tencent.beacon.event.c.b$b  reason: collision with other inner class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/event/c/b$b.class */
    static final class C0898b implements com.tencent.beacon.base.net.a.c<com.tencent.beacon.event.a.b, EventBean> {
        C0898b() {
        }

        @Override // com.tencent.beacon.base.net.a.c
        public EventBean a(com.tencent.beacon.event.a.b bVar) {
            Object a2 = com.tencent.beacon.base.util.b.a(bVar.e);
            if (a2 != null && (a2 instanceof EventBean)) {
                EventBean eventBean = (EventBean) a2;
                eventBean.setCid(bVar.f35035a);
                return eventBean;
            }
            return null;
        }
    }

    private b() {
    }

    public static b a() {
        return new b();
    }

    public com.tencent.beacon.base.net.a.c<EventBean, com.tencent.beacon.event.a.b> b() {
        return this.b;
    }

    public com.tencent.beacon.base.net.a.c<com.tencent.beacon.event.a.b, EventBean> c() {
        return this.f35043a;
    }
}

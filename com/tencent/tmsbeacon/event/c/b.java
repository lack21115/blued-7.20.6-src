package com.tencent.tmsbeacon.event.c;

import com.tencent.tmsbeacon.base.net.a.c;
import com.tencent.tmsbeacon.event.EventBean;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/event/c/b.class */
public final class b extends c.a<EventBean, com.tencent.tmsbeacon.event.a.b> {

    /* renamed from: a  reason: collision with root package name */
    private final C1034b f39562a = new C1034b();
    private final a b = new a();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/event/c/b$a.class */
    public static final class a implements c<EventBean, com.tencent.tmsbeacon.event.a.b> {
        @Override // com.tencent.tmsbeacon.base.net.a.c
        public com.tencent.tmsbeacon.event.a.b a(EventBean eventBean) {
            com.tencent.tmsbeacon.event.a.b bVar = new com.tencent.tmsbeacon.event.a.b();
            bVar.b = eventBean.getEventTime();
            bVar.d = eventBean.getAppKey();
            byte[] a2 = com.tencent.tmsbeacon.base.util.b.a(eventBean);
            bVar.e = a2;
            if (a2 != null) {
                bVar.f39559c = a2.length;
            }
            return bVar;
        }
    }

    /* renamed from: com.tencent.tmsbeacon.event.c.b$b  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/event/c/b$b.class */
    public static final class C1034b implements c<com.tencent.tmsbeacon.event.a.b, EventBean> {
        @Override // com.tencent.tmsbeacon.base.net.a.c
        public EventBean a(com.tencent.tmsbeacon.event.a.b bVar) {
            Object a2 = com.tencent.tmsbeacon.base.util.b.a(bVar.e);
            if (a2 != null && (a2 instanceof EventBean)) {
                EventBean eventBean = (EventBean) a2;
                eventBean.setCid(bVar.f39558a);
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

    public c<EventBean, com.tencent.tmsbeacon.event.a.b> b() {
        return this.b;
    }

    public c<com.tencent.tmsbeacon.event.a.b, EventBean> c() {
        return this.f39562a;
    }
}

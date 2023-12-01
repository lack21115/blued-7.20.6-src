package com.youzan.spiderman.html;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/html/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private ConcurrentHashMap<String, c> f28140a;

    /* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/html/d$a.class */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        static d f28141a = new d((byte) 0);
    }

    private d() {
        this.f28140a = new ConcurrentHashMap<>();
    }

    /* synthetic */ d(byte b) {
        this();
    }

    public static d a() {
        return a.f28141a;
    }

    public final boolean a(l lVar) {
        return this.f28140a.containsKey(lVar.c());
    }

    public final c b(l lVar) {
        c cVar;
        synchronized (this) {
            c cVar2 = this.f28140a.get(lVar.c());
            if (cVar2 == null) {
                c cVar3 = new c(lVar);
                this.f28140a.put(lVar.c(), cVar3);
                cVar = cVar3;
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                cVar = cVar2;
                if (cVar2.a(currentTimeMillis)) {
                    cVar2.b(currentTimeMillis);
                    cVar = cVar2;
                }
            }
        }
        return cVar;
    }
}

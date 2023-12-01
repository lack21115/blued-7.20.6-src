package com.getui.gtc.e;

import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.db.DbManager;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/e/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public d f8388a;
    public com.getui.gtc.e.a b;

    /* renamed from: c  reason: collision with root package name */
    private e f8389c;

    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/e/c$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static c f8390a = new c((byte) 0);

        public static /* synthetic */ c a() {
            return f8390a;
        }
    }

    private c() {
        try {
            DbManager.init(GtcProvider.context(), b.class, com.getui.gtc.e.a.class, d.class, e.class);
            this.f8388a = (d) DbManager.getTable(b.class, d.class);
            this.f8389c = (e) DbManager.getTable(b.class, e.class);
            this.b = (com.getui.gtc.e.a) DbManager.getTable(b.class, com.getui.gtc.e.a.class);
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.b(th);
        }
    }

    /* synthetic */ c(byte b) {
        this();
    }
}

package com.getui.gtc.dim.b;

import android.text.TextUtils;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.db.DbManager;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/b/b.class */
public final class b {

    /* renamed from: a */
    public final Map<String, Long> f8329a;

    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/b/b$a.class */
    public static final class a {

        /* renamed from: a */
        private static final b f8330a = new b((byte) 0);

        public static /* synthetic */ b a() {
            return f8330a;
        }
    }

    private b() {
        this.f8329a = new HashMap();
        try {
            DbManager.init(GtcProvider.context(), com.getui.gtc.dim.a.a.class, com.getui.gtc.dim.a.b.class);
            ((com.getui.gtc.dim.a.b) DbManager.getTable(com.getui.gtc.dim.a.a.class, com.getui.gtc.dim.a.b.class)).a();
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a(th);
        }
    }

    /* synthetic */ b(byte b) {
        this();
    }

    public static boolean a(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return ((com.getui.gtc.dim.a.b) DbManager.getTable(com.getui.gtc.dim.a.a.class, com.getui.gtc.dim.a.b.class)).a(str, obj);
    }
}

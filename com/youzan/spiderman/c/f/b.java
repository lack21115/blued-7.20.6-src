package com.youzan.spiderman.c.f;

import com.youzan.spiderman.cache.SpiderCacheCallback;
import com.youzan.spiderman.cache.SpiderMan;
import com.youzan.spiderman.utils.Logger;
import com.youzan.spiderman.utils.StringUtils;
import java.util.LinkedList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/c/f/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f28084a;
    private List<a> b = new LinkedList();

    private b() {
    }

    public static b a() {
        if (f28084a == null) {
            f28084a = new b();
        }
        return f28084a;
    }

    public static boolean a(int i) {
        return i == 40009 || i == 40010 || i == 42000;
    }

    public final void a(a aVar) {
        SpiderCacheCallback spiderCacheCallback = SpiderMan.getInstance().getSpiderCacheCallback();
        if (spiderCacheCallback == null) {
            Logger.e("TokenHelper", "SpiderCacheCallback should be offered to return token", new Object[0]);
            return;
        }
        String onTokenNeeded = spiderCacheCallback.onTokenNeeded();
        if (StringUtils.isEmpty(onTokenNeeded) || onTokenNeeded.trim().isEmpty()) {
            this.b.add(aVar);
        } else {
            aVar.a(onTokenNeeded);
        }
    }

    public final void a(String str) {
        if (StringUtils.isEmpty(str) || str.trim().isEmpty()) {
            return;
        }
        for (a aVar : this.b) {
            try {
                aVar.a(str);
            } catch (Exception e) {
                Logger.e("TokenHelper", "sync token, exception", e);
            }
        }
        this.b.clear();
    }

    public final void a(String str, a aVar) {
        SpiderCacheCallback spiderCacheCallback = SpiderMan.getInstance().getSpiderCacheCallback();
        if (spiderCacheCallback == null) {
            Logger.e("TokenHelper", "SpiderCacheCallback should be offered to return token", new Object[0]);
            return;
        }
        String onTokenInactive = spiderCacheCallback.onTokenInactive(str);
        if (StringUtils.isEmpty(onTokenInactive) || onTokenInactive.trim().isEmpty() || onTokenInactive.equals(str)) {
            this.b.add(aVar);
        } else {
            aVar.a(onTokenInactive);
        }
    }
}

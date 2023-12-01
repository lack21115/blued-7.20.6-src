package com.youzan.spiderman.cache;

import android.content.Context;
import com.youzan.spiderman.html.HtmlCacheStrategy;
import com.youzan.spiderman.html.HtmlCallback;
import com.youzan.spiderman.html.HtmlResponse;
import com.youzan.spiderman.html.HtmlStatistic;
import com.youzan.spiderman.html.k;
import com.youzan.spiderman.utils.Logger;
import java.lang.ref.WeakReference;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/cache/SpiderMan.class */
public class SpiderMan {

    /* renamed from: a  reason: collision with root package name */
    private static SpiderMan f28102a;
    private static boolean b = true;

    /* renamed from: c  reason: collision with root package name */
    private static SpiderCacheCallback f28103c;
    private static WeakReference<SpiderCacheCallback> d;

    public static SpiderMan getInstance() {
        if (f28102a == null) {
            f28102a = new SpiderMan();
        }
        return f28102a;
    }

    public static boolean isEnable() {
        return b;
    }

    public static void setEnable(boolean z) {
        b = z;
    }

    public void fetchHtml(Context context, String str, HtmlCallback htmlCallback) {
        if (isEnable()) {
            k.a().a(context, str, htmlCallback);
        }
    }

    public SpiderCacheCallback getSpiderCacheCallback() {
        SpiderCacheCallback spiderCacheCallback;
        WeakReference<SpiderCacheCallback> weakReference = d;
        return (weakReference == null || (spiderCacheCallback = weakReference.get()) == null) ? f28103c : spiderCacheCallback;
    }

    public void init(Context context, String str, SpiderCacheCallback spiderCacheCallback) {
        f28103c = spiderCacheCallback;
        g.a(context);
        com.youzan.spiderman.b.c.a();
        com.youzan.spiderman.c.a.a(str);
        com.youzan.spiderman.c.b.a(context);
    }

    public void initLru() {
        if (isEnable()) {
            com.youzan.spiderman.b.f.a().b();
        }
    }

    public HtmlResponse interceptHtml(Context context, String str, HtmlStatistic htmlStatistic) {
        if (isEnable()) {
            return k.a().a(context, str, htmlStatistic);
        }
        return null;
    }

    public void preloadModifyFromRemote(Context context) {
        if (isEnable()) {
            com.youzan.spiderman.c.e.d.a().a(context);
            com.youzan.spiderman.c.c.c.a();
            com.youzan.spiderman.c.c.c.a(context);
        }
    }

    public void preloadZipFromAsset(Context context, String str) {
        if (isEnable()) {
            b.a(context, str);
        }
    }

    public void setHtmlCacheStrategy(HtmlCacheStrategy htmlCacheStrategy) {
        if (isEnable()) {
            k.a().a(htmlCacheStrategy);
        }
    }

    public void setLogEnable(boolean z) {
        Logger.setLogEnabled(z);
    }

    public void setWeakRefCacheCallback(SpiderCacheCallback spiderCacheCallback) {
        d = new WeakReference<>(spiderCacheCallback);
    }

    public void sync(String str) {
        if (isEnable()) {
            com.youzan.spiderman.c.f.b.a().a(str);
        }
    }

    public void unInitLru() {
        if (isEnable()) {
            com.youzan.spiderman.b.f.a().c();
        }
    }
}

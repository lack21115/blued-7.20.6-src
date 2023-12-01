package com.youzan.spiderman.html;

import android.content.Context;
import com.youzan.spiderman.utils.Logger;
import com.youzan.spiderman.utils.StringUtils;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/html/k.class */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    private com.youzan.spiderman.html.a f41843a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/html/k$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static k f41844a = new k((byte) 0);
    }

    private k() {
        this.f41843a = new com.youzan.spiderman.html.a();
    }

    /* synthetic */ k(byte b) {
        this();
    }

    public static k a() {
        return a.f41844a;
    }

    public final HtmlResponse a(Context context, l lVar, HtmlStatistic htmlStatistic) {
        return this.f41843a.a(context, lVar, htmlStatistic);
    }

    public final HtmlResponse a(Context context, String str, HtmlStatistic htmlStatistic) {
        if (context == null || StringUtils.isEmpty(str)) {
            Logger.e("HtmlManager", "fetchHtmlWith null context or url, return", new Object[0]);
            return null;
        }
        return this.f41843a.a(context, new l(str), htmlStatistic);
    }

    public final void a(Context context, String str, HtmlCallback htmlCallback) {
        if (context == null || StringUtils.isEmpty(str)) {
            Logger.e("HtmlManager", "fetchHtmlWith null context or url, return", new Object[0]);
            return;
        }
        this.f41843a.a(context, new l(str), htmlCallback);
    }

    public final void a(HtmlCacheStrategy htmlCacheStrategy) {
        this.f41843a.a(htmlCacheStrategy);
    }

    public final HtmlCacheStrategy b() {
        return this.f41843a.a();
    }
}

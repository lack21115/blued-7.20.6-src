package com.youzan.spiderman.html;

import android.content.Context;
import com.youzan.spiderman.html.d;
import com.youzan.spiderman.html.h;
import com.youzan.spiderman.utils.Logger;
import com.youzan.spiderman.utils.NetWorkUtil;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/html/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private h f41824a = h.a.f41839a;
    private d b = d.a.f41832a;

    /* renamed from: c  reason: collision with root package name */
    private com.youzan.spiderman.c.a.a f41825c = com.youzan.spiderman.c.a.a.a();
    private HtmlCacheStrategy d = null;

    public final HtmlCacheStrategy a() {
        return this.d;
    }

    public final HtmlResponse a(Context context, l lVar, HtmlStatistic htmlStatistic) {
        f fVar = new f(context, this.d, this.f41825c.f());
        if (fVar.a()) {
            if (this.f41824a.a(lVar.c()) != null || this.b.a(lVar)) {
                HtmlResponse a2 = this.b.b(lVar).a(fVar);
                if (htmlStatistic != null) {
                    htmlStatistic.setNeedRecord(true);
                    if (a2 != null) {
                        htmlStatistic.setPrefetch(true);
                    }
                }
                return a2;
            }
            return null;
        }
        return null;
    }

    public final void a(Context context, final l lVar, final HtmlCallback htmlCallback) {
        if (!new f(context, this.d, this.f41825c.f()).a()) {
            if (htmlCallback != null) {
                htmlCallback.onFailed();
            }
        } else if (NetWorkUtil.hasNetworkPermission(context)) {
            com.youzan.spiderman.a.c.a().a(new com.youzan.spiderman.a.a() { // from class: com.youzan.spiderman.html.a.1
                @Override // com.youzan.spiderman.a.a
                public final void a() throws Throwable {
                    a.this.b.b(lVar).a(htmlCallback);
                }

                @Override // com.youzan.spiderman.a.a
                public final void a(Throwable th) {
                    Logger.e("FetchEngine", "exception url:" + lVar.a(), th);
                }
            });
        } else {
            Logger.e("FetchEngine", "has no network permission to fetch html", new Object[0]);
            if (htmlCallback != null) {
                htmlCallback.onFailed();
            }
        }
    }

    public final void a(HtmlCacheStrategy htmlCacheStrategy) {
        this.d = htmlCacheStrategy;
    }
}
